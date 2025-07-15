package com.ndp.service.impl;

import com.ndp.mapper.UserMapper;
import com.ndp.model.User;
import com.ndp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    
    private final UserMapper userMapper;
    
    @Override
    public List<User> getAllUsers() {
        return userMapper.findAll();
    }
    
    @Override
    public User getUserById(Long id) {
        return userMapper.findById(id);
    }
    
    @Override
    public User getUserByUsername(String username) {
        return userMapper.findByUsername(username);
    }
    
    @Override
    public User createUser(User user) {
        userMapper.insert(user);
        return user;
    }
    
    @Override
    public User updateUser(User user) {
        userMapper.update(user);
        return user;
    }
    
    @Override
    public boolean deleteUser(Long id) {
        return userMapper.deleteById(id) > 0;
    }
}
