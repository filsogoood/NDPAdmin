package com.ndp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ndp.vo.NanodcVO;
import com.ndp.vo.Ndp_TokenVO;
import com.ndp.vo.UserInfoVO;

import java.util.List;

@Mapper
public interface Ndp_TokenMapper {
    
	public List<Ndp_TokenVO> getAllndp();
}
