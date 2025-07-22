package com.ndp.vo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Node_ScoresVO {
	private int id;
    private String node_id;

    private String cpu_score;
    private String gpu_score;
    private String ssd_score;
    private String ram_score;
    private String network_score;
    private String hardware_health_score;

    private String total_score;
    private String average_score;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNode_id() {
		return node_id;
	}
	public void setNode_id(String node_id) {
		this.node_id = node_id;
	}
	public String getCpu_score() {
		return cpu_score;
	}
	public void setCpu_score(String cpu_score) {
		this.cpu_score = cpu_score;
	}
	public String getGpu_score() {
		return gpu_score;
	}
	public void setGpu_score(String gpu_score) {
		this.gpu_score = gpu_score;
	}
	public String getSsd_score() {
		return ssd_score;
	}
	public void setSsd_score(String ssd_score) {
		this.ssd_score = ssd_score;
	}
	public String getRam_score() {
		return ram_score;
	}
	public void setRam_score(String ram_score) {
		this.ram_score = ram_score;
	}
	public String getNetwork_score() {
		return network_score;
	}
	public void setNetwork_score(String network_score) {
		this.network_score = network_score;
	}
	public String getHardware_health_score() {
		return hardware_health_score;
	}
	public void setHardware_health_score(String hardware_health_score) {
		this.hardware_health_score = hardware_health_score;
	}
	public String getTotal_score() {
		return total_score;
	}
	public void setTotal_score(String total_score) {
		this.total_score = total_score;
	}
	public String getAverage_score() {
		return average_score;
	}
	public void setAverage_score(String average_score) {
		this.average_score = average_score;
	}

    

 
}
