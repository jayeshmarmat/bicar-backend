package com.bicar.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Handshake {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private Integer Requestor;
	private Integer Approver;
	private String ReqStatus;
	public Integer getRequestor() {
		return Requestor;
	}
	public void setRequestor(Integer requestor) {
		Requestor = requestor;
	}
	public Integer getApprover() {
		return Approver;
	}
	public void setApprover(Integer approver) {
		Approver = approver;
	}
	public String getReqStatus() {
		return ReqStatus;
	}
	public void setReqStatus(String reqStatus) {
		ReqStatus = reqStatus;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Handshake [id=" + id + ", Requestor=" + Requestor + ", Approver=" + Approver + ", ReqStatus="
				+ ReqStatus + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Approver == null) ? 0 : Approver.hashCode());
		result = prime * result + ((ReqStatus == null) ? 0 : ReqStatus.hashCode());
		result = prime * result + ((Requestor == null) ? 0 : Requestor.hashCode());
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Handshake other = (Handshake) obj;
		if (Approver == null) {
			if (other.Approver != null)
				return false;
		} else if (!Approver.equals(other.Approver))
			return false;
		if (ReqStatus == null) {
			if (other.ReqStatus != null)
				return false;
		} else if (!ReqStatus.equals(other.ReqStatus))
			return false;
		if (Requestor == null) {
			if (other.Requestor != null)
				return false;
		} else if (!Requestor.equals(other.Requestor))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	

	
	
}
