package com.ndp.vo;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Node_UsageVO {

    private int id;
    private String node_id;
    private LocalDateTime timestamp;
    private String cpu_usage_percent;
    private String mem_usage_percent;
    private String gpu_usage_percent;
    private String gpu_temp;
    private String used_storage_gb;
    private String ssd_health_percent;

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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getCpu_usage_percent() {
        return cpu_usage_percent;
    }

    public void setCpu_usage_percent(String cpu_usage_percent) {
        this.cpu_usage_percent = cpu_usage_percent;
    }

    public String getMem_usage_percent() {
        return mem_usage_percent;
    }

    public void setMem_usage_percent(String mem_usage_percent) {
        this.mem_usage_percent = mem_usage_percent;
    }

    public String getGpu_usage_percent() {
        return gpu_usage_percent;
    }

    public void setGpu_usage_percent(String gpu_usage_percent) {
        this.gpu_usage_percent = gpu_usage_percent;
    }

    public String getGpu_temp() {
        return gpu_temp;
    }

    public void setGpu_temp(String gpu_temp) {
        this.gpu_temp = gpu_temp;
    }

    public String getUsed_storage_gb() {
        return used_storage_gb;
    }

    public void setUsed_storage_gb(String used_storage_gb) {
        this.used_storage_gb = used_storage_gb;
    }

    public String getSsd_health_percent() {
        return ssd_health_percent;
    }

    public void setSsd_health_percent(String ssd_health_percent) {
        this.ssd_health_percent = ssd_health_percent;
    }
}
