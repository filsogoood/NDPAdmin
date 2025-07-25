package com.ndp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ndp.vo.UserInfoVO;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    
	UserInfoVO selectUserById(@Param("user_id") String userId);
	List<UserInfoVO> selectAllUsers();
}
