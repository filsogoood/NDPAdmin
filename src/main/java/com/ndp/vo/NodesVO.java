package com.ndp.vo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class NodesVO {
    private int id;
    private String node_id;
    private String user_uuid;
    private String status;
    private LocalDateTime create_at;
    private LocalDateTime update_at;
    private String node_name;
    private String nanodc_id;
    
   

    public String getNode_id() {
		return node_id;
	}

	public void setNode_id(String node_id) {
		this.node_id = node_id;
	}

	public String getUser_uuid() {
		return user_uuid;
	}

	public void setUser_uuid(String user_uuid) {
		this.user_uuid = user_uuid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreate_at() {
		return create_at;
	}

	public void setCreate_at(LocalDateTime create_at) {
		this.create_at = create_at;
	}

	public LocalDateTime getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(LocalDateTime update_at) {
		this.update_at = update_at;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public String getNode_name() {
		return node_name;
	}

	public void setNode_name(String node_name) {
		this.node_name = node_name;
	}

	public String getNanodc_id() {
		return nanodc_id;
	}

	public void setNanodc_id(String nanodc_id) {
		this.nanodc_id = nanodc_id;
	}

    

 
}
