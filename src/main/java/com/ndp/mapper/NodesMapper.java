package com.ndp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ndp.vo.NodesVO;
import com.ndp.vo.UserInfoVO;

import java.util.List;

@Mapper
public interface NodesMapper {
    
	public int updateNodeStatusByNodeId(NodesVO nodesVO);
	public int checkNodeExists(String nodeId);
	public List<NodesVO> getAllNodes();
	public String getNanodcIdByNodeId(String nodeId);
	public String getStatusIdByNodeId(String nodeId);

}
