package com.ndp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ndp.vo.Node_ScoresVO;
import com.ndp.vo.UserInfoVO;

import java.util.List;

@Mapper
public interface Node_ScoresMapper {
	List<Node_ScoresVO>getAllScore();
    
	
}
