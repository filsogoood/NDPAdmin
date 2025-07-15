package com.ndp.service;

import com.ndp.config.JwtUtil;
import com.ndp.mapper.UserInfoMapper;
import com.ndp.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public String login(String userId, String password) {
        UserInfoVO user = userInfoMapper.selectUserById(userId);

        if (user != null && password.equals(user.getPassword())) {
            return JwtUtil.generateToken(user.getUserUuid());
        }

        return null;  // 로그인 실패 시
    }
}
