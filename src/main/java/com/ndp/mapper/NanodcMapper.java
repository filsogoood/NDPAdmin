package com.ndp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ndp.vo.Hardware_SpecsVO;
import com.ndp.vo.NanodcVO;
import com.ndp.vo.UserInfoVO;

import java.util.List;

@Mapper
public interface NanodcMapper {
    
	
	public List<NanodcVO> getAllnanodc();
}
