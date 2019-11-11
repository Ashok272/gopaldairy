package com.dbms.model;



public class User{

	private String username;

	private String password;

	private String mpassword;

	private String name;
	
	private String address;
	//@NotEmpty(message="required")
	private Long pincode;
	private String city;
	
	private String state;

	private String email;
	private Long phone_no;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(Long phone_no) {
		this.phone_no = phone_no;
	}
	public User() {
		
	}
	
	public User(String uname, String pass, String mpass,  String name, String address, String city, String state, Long pincode, Long phone_no, String email) {
		this.username=uname;
		this.password=pass;
		this.mpassword=mpass;
		this.name=name;
		this.city=city;
		this.address=address;
		this.state=state;
		this.pincode=pincode;
		this.phone_no=phone_no;
		this.email=email;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public User(String uname,String pass) {
		this.username=uname;
		this.password=pass;
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMpassword() {
		return mpassword;
	}

	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	
	
}