package com.bicar.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Rider {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String custid;
	
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}

	
	private String date;
	
	@JsonFormat(pattern = "HH:mm")
	private String start_time;
	
	private String ride_price;
	private String origin_source;
	private String destination;
	private boolean isOwner=false;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public void setStart_time(String string) {
		this.start_time = string;
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
	public boolean isOwner() {
		return isOwner;
	}
	public void setOwner(boolean isOwner) {
		this.isOwner = isOwner;
	}
	
	
	@Override
	public String toString() {
		return "Rider [id=" + id + ", custid=" + custid + ", date=" + date + ", start_time=" + start_time
				+ ", ride_price=" + ride_price + ", origin_source=" + origin_source + ", destination=" + destination
				+ ", isOwner=" + isOwner + "]";
	}
	public Rider() {
		super();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((custid == null) ? 0 : custid.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + id;
		result = prime * result + (isOwner ? 1231 : 1237);
		result = prime * result + ((origin_source == null) ? 0 : origin_source.hashCode());
		result = prime * result + ((ride_price == null) ? 0 : ride_price.hashCode());
		result = prime * result + ((start_time == null) ? 0 : start_time.hashCode());
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
		Rider other = (Rider) obj;
		if (custid == null) {
			if (other.custid != null)
				return false;
		} else if (!custid.equals(other.custid))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (id != other.id)
			return false;
		if (isOwner != other.isOwner)
			return false;
		if (origin_source == null) {
			if (other.origin_source != null)
				return false;
		} else if (!origin_source.equals(other.origin_source))
			return false;
		if (ride_price == null) {
			if (other.ride_price != null)
				return false;
		} else if (!ride_price.equals(other.ride_price))
			return false;
		if (start_time == null) {
			if (other.start_time != null)
				return false;
		} else if (!start_time.equals(other.start_time))
			return false;
		return true;
	}


}

//Backend: Offer a ride: capture the user ride information into table thru post call() [car owner]
//		  Find a ride : pick the user data and respond back withthat parameters through get call()
//						[Either you can store the values or save it to temp variables and then fetch the values]
//		
//		Parameters: 1. Date
//					2. Start time
//					3. Ride Rate/Price
//					4. Origin Source
//					5. Destination(TSYS)