package com.ndp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.ndp.vo.Hardware_SpecsVO;
import com.ndp.vo.UserInfoVO;

import java.util.List;

@Mapper
public interface Hardware_SpecsMapper {
    
	public int insertHardwareSpecs(Hardware_SpecsVO specsVO);
	public int checkHardwareSpecsExists(String nodeId);

}
