package com.ndp.service;

import com.ndp.model.User;
import java.util.List;

public interface UserService {
    
    List<User> getAllUsers();
    
    User getUserById(Long id);
    
    User getUserByUsername(String username);
    
    User createUser(User user);
    
    User updateUser(User user);
    
    boolean deleteUser(Long id);
}
