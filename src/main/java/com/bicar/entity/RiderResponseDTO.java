package com.bicar.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RiderResponseDTO {
	private String custid;
	private String date;
	private String start_time;
	private String ride_price;
	private String origin_source;
	private String destination;
	private String name;
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getRide_price() {
		return ride_price;
	}
	public void setRide_price(String ride_price) {
		this.ride_price = ride_price;
	}
	public String getOrigin_source() {
		return origin_source;
	}
	public void setOrigin_source(String origin_source) {
		this.origin_source = origin_source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
