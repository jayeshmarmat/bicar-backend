package com.bicar.entity;

public class LoginResponseDTO {
	private String status;
	private Integer custid;
	public String isStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	@Override
	public String toString() {
		return "LoginResponseDTO [status=" + status + ", custid=" + custid + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginResponseDTO other = (LoginResponseDTO) obj;
		if (custid != other.custid)
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
}
