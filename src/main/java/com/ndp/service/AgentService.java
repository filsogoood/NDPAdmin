package com.ndp.service;

import com.ndp.config.JwtUtil;
import com.ndp.mapper.Hardware_SpecsMapper;
import com.ndp.mapper.Node_UsageMapper;
import com.ndp.mapper.NodesMapper;
import com.ndp.mapper.UserInfoMapper;
import com.ndp.vo.Hardware_SpecsVO;
import com.ndp.vo.Node_UsageVO;
import com.ndp.vo.NodesVO;
import com.ndp.vo.UserInfoVO;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private NodesMapper nodesMapper;
    @Autowired
    private Node_UsageMapper node_UsageMapper;
    @Autowired
    private Hardware_SpecsMapper hardware_SpecsMapper;
    
    
    
    public String updateNodeStatus(String nodeId, String status) {
        NodesVO node = new NodesVO();
        node.setNode_id(nodeId);
        node.setStatus(status);
        node.setUpdate_at(LocalDateTime.now());

        int result = nodesMapper.updateNodeStatusByNodeId(node);

        if (result > 0) {
            return "success";
        } else {
            return "fail";
        }
    }
    
    public boolean isNodeExists(String nodeId) {
        int count = nodesMapper.checkNodeExists(nodeId);
        return count > 0;
    }
    
    public String saveHardwareSpecs(Hardware_SpecsVO specsVO) {
        int result = hardware_SpecsMapper.insertHardwareSpecs(specsVO);

        if (result > 0) {
            return "success";
        } else {
            return "fail";
        }
    }
    
    public boolean isHardwareSpecsExists(String nodeId) {
        int count = hardware_SpecsMapper.checkHardwareSpecsExists(nodeId);
        return count > 0;
    }
    
    public String insertInitialNodeUsageRow(String nodeId) {
        int result = node_UsageMapper.insertInitialNodeUsage(nodeId);

        if (result > 0) {
            return "success";
        } else {
            return "fail";
        }
    }
    public String updateNodeUsage(Node_UsageVO usageVO) {
        int result = node_UsageMapper.updateNodeUsageByNodeId(usageVO);

        if (result > 0) {
            return "success";
        } else {
            return "fail";
        }
    }
    
    public boolean isNodeExists_usage(String nodeId) {
        return node_UsageMapper.isNodeExists(nodeId) > 0;
    }
    public String getNanodcIdByNodeId(String nodeId) {
        return nodesMapper.getNanodcIdByNodeId(nodeId);
    }
    
    public String getStatusIdByNodeId(String nodeId) {
        return nodesMapper.getStatusIdByNodeId(nodeId);
    }
    
    public void updateStaleNodesToPre() {
        List<Node_UsageVO> nodeList = node_UsageMapper.getAllNodeTimestamps();

        for (Node_UsageVO node : nodeList) {
            LocalDateTime timestamp = node.getTimestamp();
            long seconds = Duration.between(timestamp, LocalDateTime.now()).getSeconds();

            if (seconds > 300) {  // 5분 초과
            	updateNodeStatus(node.getNode_id(), "pre");
            }
        }
    }


    
    

    
    
    

    
}
