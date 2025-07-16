package com.ndp.controller;

import com.ndp.service.AgentService;
import com.ndp.service.UserService;
import com.ndp.vo.Hardware_SpecsVO;
import com.ndp.vo.Node_UsageVO;
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
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AgentController {
	
	@Autowired
    private  UserService userService;
	@Autowired
    private  AgentService agentService;
	
	
	@PostMapping("/nodes/register")
	public ResponseEntity<String> registerAgent(@RequestBody Map<String, Object> request) {
		System.out.println("레지스터 호출");
	    // 1️⃣ node_id 추출 및 검증
	    String nodeId = (String) request.get("node_id");

	    if (nodeId == null) {
	        return ResponseEntity.badRequest().body("Missing node_id");
	    }

	    if (!agentService.isNodeExists(nodeId)) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unknown node");
	    }

	    agentService.updateNodeStatus(nodeId, "active");
	    System.out.println("레지스터 node_id 검증 완료");
	    // 2️⃣ 하드웨어 스펙 처리
	    @SuppressWarnings("unchecked")
	    Map<String, Object> hw = (Map<String, Object>) request.get("hardware_specs");

	    if (hw != null && !agentService.isHardwareSpecsExists(nodeId)) {

	        Hardware_SpecsVO specsVO = new Hardware_SpecsVO();
	        specsVO.setNode_id(nodeId);

	        specsVO.setCpu_model((String) hw.get("cpu_model"));
	        specsVO.setCpucores((String) hw.get("cpucores"));
	        specsVO.setGpu_model((String) hw.get("gpu_model"));
	        specsVO.setGpu_vram_gb((String) hw.get("gpu_vram_gb"));
	        specsVO.setTotal_ram_gb((String) hw.get("total_ram_gb"));
	        specsVO.setStorage_type((String) hw.get("storage_type"));
	        specsVO.setStorage_total_gb((String) hw.get("storage_total_gb"));


	        agentService.saveHardwareSpecs(specsVO);
	        agentService.insertInitialNodeUsageRow(nodeId);
	        System.out.println("칼럼 세팅 완료");

	    }

	    return ResponseEntity.ok("Agent registered");
	}
	
	@PostMapping("/nodes/telemetry")
	public ResponseEntity<String> receiveTelemetry(@RequestBody Map<String, Object> request) {

	    String node_id = (String) request.get("node_id");

	    if (node_id == null) {
	        return ResponseEntity.badRequest().body("Missing node_id");
	    }

	    if (!agentService.isNodeExists(node_id)) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unknown node");
	    }

	    Node_UsageVO usageVO = new Node_UsageVO();
	    usageVO.setNode_id(node_id);
	    usageVO.setCpu_usage_percent((String) request.get("cpu_usage_percent"));
	    usageVO.setMem_usage_percent((String) request.get("mem_usage_percent"));
	    usageVO.setGpu_usage_percent((String) request.get("gpu_usage_percent"));
	    usageVO.setGpu_temp((String) request.get("gpu_temp"));  // 필드명 gpu_temp_percent 아님 주의
	    usageVO.setUsed_storage_gb((String) request.get("used_storage_gb"));
	    usageVO.setSsd_health_percent((String) request.get("ssd_health_percent"));


	    String result = agentService.updateNodeUsage(usageVO);

	    return ResponseEntity.ok(result);
	}






   
   
}
