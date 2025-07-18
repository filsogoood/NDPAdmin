package com.ndp.vo;

import lombok.Data;

@Data
public class Hardware_SpecsVO {
    private int id;

    private String node_id;
    private String cpu_model;
    private String cpucores;
    private String gpu_model;
    private String gpu_vram_gb;
    private String total_ram_gb;
    private String storage_type;
    private String storage_total_gb;
    private String cpu_count;
    private String gpu_count;
    private String nvme_count;
    private String nanodc_id;

    public int getId() {
        return id;
    }

    public String getCpu_count() {
		return cpu_count;
	}

	public void setCpu_count(String cpu_count) {
		this.cpu_count = cpu_count;
	}

	public String getGpu_count() {
		return gpu_count;
	}

	public void setGpu_count(String gpu_count) {
		this.gpu_count = gpu_count;
	}

	public String getNvme_count() {
		return nvme_count;
	}

	public void setNvme_count(String nvme_count) {
		this.nvme_count = nvme_count;
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

    public String getCpu_model() {
        return cpu_model;
    }

    public void setCpu_model(String cpu_model) {
        this.cpu_model = cpu_model;
    }

  

    public String getGpu_model() {
        return gpu_model;
    }

    public void setGpu_model(String gpu_model) {
        this.gpu_model = gpu_model;
    }

    public String getGpu_vram_gb() {
        return gpu_vram_gb;
    }

    public void setGpu_vram_gb(String gpu_vram_gb) {
        this.gpu_vram_gb = gpu_vram_gb;
    }

    public String getTotal_ram_gb() {
        return total_ram_gb;
    }

    public void setTotal_ram_gb(String total_ram_gb) {
        this.total_ram_gb = total_ram_gb;
    }

    public String getStorage_type() {
        return storage_type;
    }

    public void setStorage_type(String storage_type) {
        this.storage_type = storage_type;
    }

    public String getStorage_total_gb() {
        return storage_total_gb;
    }

    public void setStorage_total_gb(String storage_total_gb) {
        this.storage_total_gb = storage_total_gb;
    }

	public String getCpucores() {
		return cpucores;
	}

	public void setCpucores(String cpucores) {
		this.cpucores = cpucores;
	}

	public String getNanodc_id() {
		return nanodc_id;
	}

	public void setNanodc_id(String nanodc_id) {
		this.nanodc_id = nanodc_id;
	}
}
