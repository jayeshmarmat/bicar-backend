package com.bicar.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name = "Customer")

public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "custid")
	private int custid;
	
	@OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private User user;
	

	@NotNull
	@Column(name = "name")	
	private String name;

	@NotNull
	@Column(name = "age")
	private int age;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@NotNull
	@Column(name = "mobile")
	private long mobile;

	@NotNull
	@Column(name = "address")
	private String address; 

	@NotNull
	@Column(name = "primary_id")
	private long primary_id;

	@NotNull
	@Column(name = "cust_type")
	private long cust_type;

	@NotNull
	@Column(name = "email")
	private String email;

	@NotNull
	@Column(name = "company_name")
	private String company_name;

	@NotNull
	@Column(name = "rating")
	private int rating;

	@NotNull
	@Column(name = "pincode")
	private int pincode;

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result + ((company_name == null) ? 0 : company_name.hashCode());
		result = prime * result + (int) (cust_type ^ (cust_type >>> 32));
		result = prime * result + custid;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (mobile ^ (mobile >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + pincode;
		result = prime * result + (int) (primary_id ^ (primary_id >>> 32));
		result = prime * result + rating;
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
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age != other.age)
			return false;
		if (company_name == null) {
			if (other.company_name != null)
				return false;
		} else if (!company_name.equals(other.company_name))
			return false;
		if (cust_type != other.cust_type)
			return false;
		if (custid != other.custid)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (mobile != other.mobile)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pincode != other.pincode)
			return false;
		if (primary_id != other.primary_id)
			return false;
		if (rating != other.rating)
			return false;
		return true;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPrimary_id() {
		return primary_id;
	}

	public void setPrimary_id(long primary_id) {
		this.primary_id = primary_id;
	}

	public long getCust_type() {
		return cust_type;
	}

	public void setCust_type(long cust_type) {
		this.cust_type = cust_type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public Customer(int custid, User user, String name, int age, long mobile, String address, long primary_id,
			long cust_type, String email, String company_name, int rating, int pincode) {
		super();
		this.custid = custid;
		this.user = user;
		this.name = name;
		this.age = age;
		this.mobile = mobile;
		this.address = address;
		this.primary_id = primary_id;
		this.cust_type = cust_type;
		this.email = email;
		this.company_name = company_name;
		this.rating = rating;
		this.pincode = pincode;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", user=" + user + ", name=" + name + ", age=" + age + ", mobile="
				+ mobile + ", address=" + address + ", primary_id=" + primary_id + ", cust_type=" + cust_type
				+ ", email=" + email + ", company_name=" + company_name + ", rating=" + rating + ", pincode=" + pincode
				+ ", getUser()=" + getUser() + ", hashCode()=" + hashCode() + ", getCustid()=" + getCustid()
				+ ", getName()=" + getName() + ", getAge()=" + getAge() + ", getMobile()=" + getMobile()
				+ ", getAddress()=" + getAddress() + ", getPrimary_id()=" + getPrimary_id() + ", getCust_type()="
				+ getCust_type() + ", getEmail()=" + getEmail() + ", getCompany_name()=" + getCompany_name()
				+ ", getRating()=" + getRating() + ", getPincode()=" + getPincode() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
