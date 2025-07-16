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

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private NodesMapper nodesMapper;
    @Autowired
    private Node_UsageMapper node_UsageMapper;
    @Autowired
    private Hardware_SpecsMapper hardware_SpecsMapper;

    public String login(String userId, String password) {
        UserInfoVO user = userInfoMapper.selectUserById(userId);

        if (user != null && password.equals(user.getPassword())) {
            return JwtUtil.generateToken(user.getUserUuid(), user.getUserId());
        }

        return null;  // 로그인 실패 시
    }
    
    public List<NodesVO> getAllNodes() {
        return nodesMapper.getAllNodes();
    }
    public List<Node_UsageVO> getAllused() {
        return node_UsageMapper.getAllused();
    }
    public List<Hardware_SpecsVO> getAllspecs() {
        return hardware_SpecsMapper.getAllspecs();
    }
    
  /*  public String registerNode(String userUuid) {
        String nodeId = UUID.randomUUID().toString();

        NodesVO node = new NodesVO();
        node.setNode_id(nodeId);
        node.setUser_uuid(userUuid);
        node.setStatus("pre");
        node.setCreate_at(LocalDateTime.now());
        node.setUpdate_at(LocalDateTime.now());

        nodesMapper.insertNode(node);

        return nodeId;
    }*/
    
}
