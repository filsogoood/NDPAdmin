package com.ndp.model;

import lombok.Data;
import java.util.Date;

@Data
public class User {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String phone;
    private Date createdAt;
    private Date updatedAt;
}
