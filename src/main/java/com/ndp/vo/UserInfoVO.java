package com.ndp.vo;

import lombok.Data;
import java.util.Date;

@Data
public class UserInfoVO {
	private int id;
    private String userUuid;
    private String userId;
    private String password;
    private String user_name;
    private String ndp_address;
    
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getNdp_address() {
		return ndp_address;
	}
	public void setNdp_address(String ndp_address) {
		this.ndp_address = ndp_address;
	}
	public String getUserUuid() {
		return userUuid;
	}
	public void setUserUuid(String userUuid) {
		this.userUuid = userUuid;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
