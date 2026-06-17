package com.studentportal.model;

import java.sql.Date;

public class Student {
	private	int id;
private	String name;
private	String email;
private	String phone;
private	char gender;
 
public Student(int id, String name, String email, String phone, char gender, Date dob, String course, int batchid,
		Date joinDate, String address) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.gender = gender;
	this.dob = dob;
	this.course = course;
	this.batchid = batchid;
	this.joinDate = joinDate;
	this.address = address;
}
public Student(String name, String email, String phone, char gender, Date dob, String course, int batchid,
		Date joinDate, String address) {
	super();
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.gender = gender;
	this.dob = dob;
	this.course = course;
	this.batchid = batchid;
	this.joinDate = joinDate;
	this.address = address;
}
 
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
private Date dob;
private String course ;
private	int batchid;
private	Date joinDate;

public Student(int id, String name, String email, String phone, char gender, Date dob, String course, int batchid,
		Date joinDate, String address, String password, String status) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.gender = gender;
	this.dob = dob;
	this.course = course;
	this.batchid = batchid;
	this.joinDate = joinDate;
	this.address = address;
	this.password = password;
	this.status = status;
}
private	String address;
private String password;
private String status;
	 	public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
		public int getId() {
		return id;
	}
	@Override
		public String toString() {
			return "Student [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", gender="
					+ gender + ", batchid=" + batchid + ", joinDate=" + joinDate + ", address=" + address + "]";
		}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getBatchid() {
		return batchid;
	}
	public void setBatchid(int batchid) {
		this.batchid = batchid;
	}
	 
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getAddress() {
		return address;
	}
	public Student() {
		super();
	}
	public void setAddress(String address) {
		this.address = address;
	}
	 
	

}
