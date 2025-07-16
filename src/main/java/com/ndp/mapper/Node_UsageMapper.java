package com.ndp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ndp.vo.Node_UsageVO;
import com.ndp.vo.NodesVO;
import com.ndp.vo.UserInfoVO;

import java.util.List;

@Mapper
public interface Node_UsageMapper {
    
	public int insertInitialNodeUsage(@Param("node_id") String nodeId);
	public int updateNodeUsageByNodeId(Node_UsageVO nodeUsageVO);
	public List<Node_UsageVO> getAllused();


}
