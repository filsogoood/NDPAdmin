package com.ndp.vo;

import lombok.Data;
import java.util.Date;

@Data
public class NanodcVO {
	private int id;
	private String nanodc_id;
	private String country;
	private String address;
	private String ip;
	private String latitude;
	private String longtitude;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(String longtitude) {
		this.longtitude = longtitude;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNanodc_id() {
		return nanodc_id;
	}
	public void setNanodc_id(String nanodc_id) {
		this.nanodc_id = nanodc_id;
	}
	
}
