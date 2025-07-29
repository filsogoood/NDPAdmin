package com.ndp.controller;

import com.ndp.config.JwtUtil;
import com.ndp.service.UserService;
import com.ndp.vo.Hardware_SpecsVO;
import com.ndp.vo.NanodcVO;
import com.ndp.vo.Ndp_TokenVO;
import com.ndp.vo.Node_ScoresVO;
import com.ndp.vo.Node_UsageVO;
import com.ndp.vo.NodesVO;
import com.ndp.vo.UserInfoVO;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
    private  UserService userService;
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        String userId = request.get("user_id");
        String password = request.get("password");

        String token = userService.login(userId, password);

        if (token != null) {
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
    
    @GetMapping("/data")
    public ResponseEntity<Map<String, Object>> getDashboardData(@RequestHeader("Authorization") String authHeader) {

        Map<String, Object> response = new HashMap<>();

        // 1. 토큰 추출 및 검증
        String token = authHeader.replace("Bearer ", "");
        if (!JwtUtil.validateToken(token)) {
            response.put("error", "Invalid or expired token");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        // 2. 데이터 가져오기
        List<NodesVO> nodes = userService.getAllNodes();
        List<Node_UsageVO> usage = userService.getAllused();
        List<Hardware_SpecsVO> specs = userService.getAllspecs();
        List<NanodcVO> nanodc = userService.getAllnanodc();
        List<Ndp_TokenVO> ndp_list = userService.getAllndp();
        List<UserInfoVO> all_users = userService.selectAllUsers();
        List<Node_ScoresVO> all_scores = userService.getAllScore();

        // 3. JSON으로 묶기
        response.put("nodes", nodes);
        response.put("node_usage", usage);
        response.put("hardware_specs", specs);
        response.put("nanodc", nanodc);
        response.put("ndp_list",ndp_list);
        response.put("all_users",all_users);
        response.put("all_scores",all_scores);
        

        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/tlong/data")
    public ResponseEntity<Map<String, Object>> getTlong_DashboardData(
            @RequestParam("nanodc_id") String nanodcId) {

        Map<String, Object> response = new HashMap<>();

        // 전체 데이터 조회
        List<NodesVO> nodesAll = userService.getAllNodes();
        List<Hardware_SpecsVO> specsAll = userService.getAllspecs();
        List<NanodcVO> nanodcAll = userService.getAllnanodc();
        List<Node_UsageVO> usageAll = userService.getAllused();
        List<Ndp_TokenVO> ndp_list = userService.getAllndp();
        List<Node_ScoresVO> all_scores = userService.getAllScore();

        // nanodc_id 기준 필터링 (Java 8 Stream API 사용)
        List<NodesVO> nodes = new ArrayList<>();
        for (NodesVO n : nodesAll) {
            if (nanodcId.equals(n.getNanodc_id())) {
                nodes.add(n);
            }
        }

        List<Hardware_SpecsVO> specs = new ArrayList<>();
        for (Hardware_SpecsVO s : specsAll) {
            if (nanodcId.equals(s.getNanodc_id())) {
                specs.add(s);
            }
        }

        List<NanodcVO> nanodc = new ArrayList<>();
        for (NanodcVO n : nanodcAll) {
            if (nanodcId.equals(n.getNanodc_id())) {
                nanodc.add(n);
            }
        }

        // nodes에서 node_id 목록 추출
        Set<String> nodeIdSet = new HashSet<>();
        for (NodesVO n : nodes) {
            nodeIdSet.add(n.getNode_id());
        }

        // node_usage 필터링
        List<Node_UsageVO> usage = new ArrayList<>();
        for (Node_UsageVO u : usageAll) {
            if (nodeIdSet.contains(u.getNode_id())) {
                usage.add(u);
            }
        }
        
        List<Node_ScoresVO> scores = new ArrayList<>();
        for (Node_ScoresVO s : all_scores) {
            if (nodeIdSet.contains(s.getNode_id())) {
                scores.add(s);
            }
        }
        
        List<Ndp_TokenVO> ndpListFiltered = new ArrayList<>();
        for (Ndp_TokenVO n : ndp_list) {
            if (nodeIdSet.contains(n.getNode_id())) {
                ndpListFiltered.add(n);
            }
        }

        

        // 결과 구성
        response.put("nodes", nodes);
        response.put("hardware_specs", specs);
        response.put("nanodc", nanodc);
        response.put("node_usage", usage);
        response.put("ndpListFiltered", ndpListFiltered);
        response.put("scores", scores);

        return ResponseEntity.ok(response);
    }


   

}
