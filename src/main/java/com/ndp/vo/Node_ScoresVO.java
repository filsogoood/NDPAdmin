package com.ndp.vo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Node_ScoresVO {
    private int id;
    private String node_id;
    private String hardware_score;
    private String performance_score;
    private String total_score;
    private LocalDateTime calculated_at;
    
   

    public String getNode_id() {
		return node_id;
	}

	public String getHardware_score() {
		return hardware_score;
	}

	public void setHardware_score(String hardware_score) {
		this.hardware_score = hardware_score;
	}

	public String getPerformance_score() {
		return performance_score;
	}

	public void setPerformance_score(String performance_score) {
		this.performance_score = performance_score;
	}

	public String getTotal_score() {
		return total_score;
	}

	public void setTotal_score(String total_score) {
		this.total_score = total_score;
	}

	public LocalDateTime getCalculated_at() {
		return calculated_at;
	}

	public void setCalculated_at(LocalDateTime calculated_at) {
		this.calculated_at = calculated_at;
	}

	public void setNode_id(String node_id) {
		this.node_id = node_id;
	}

	
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

 
}
