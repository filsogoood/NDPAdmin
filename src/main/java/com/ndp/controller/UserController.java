package com.ndp.controller;

import com.ndp.config.JwtUtil;
import com.ndp.service.UserService;
import com.ndp.vo.Hardware_SpecsVO;
import com.ndp.vo.NanodcVO;
import com.ndp.vo.Ndp_TokenVO;
import com.ndp.vo.Node_UsageVO;
import com.ndp.vo.NodesVO;
import com.ndp.vo.UserInfoVO;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        // 3. JSON으로 묶기
        response.put("nodes", nodes);
        response.put("node_usage", usage);
        response.put("hardware_specs", specs);
        response.put("nanodc", nanodc);
        response.put("ndp_list",ndp_list);

        return ResponseEntity.ok(response);
    }

}
