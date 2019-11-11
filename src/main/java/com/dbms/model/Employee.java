package com.dbms.model;



public class Employee{

	private String username;

	private String password;

	private String mpassword;

	private String name;
	private Long emp_id;
	private String address;
	//@NotEmpty(message="required")
	private Long pincode;
	private String city;
	
	private String state;
	private String timings;
	private String bank_name;
	private String bank_accno;
	private String bank_ifsc;
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

	public Long getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(Long phone_no) {
		this.phone_no = phone_no;
	}
	public Employee() {
		
	}
	
	public Employee(String uname, String pass, String mpass,  String name, String address, String city, String state, Long pincode, Long phone_no, String timings,String bank_name,String bank_accno,String bank_ifsc) {
		this.username=uname;
		this.password=pass;
		this.mpassword=mpass;
		this.name=name;
		this.city=city;
		this.address=address;
		this.state=state;
		this.pincode=pincode;
		this.phone_no=phone_no;
		this.timings=timings;
		this.timings=bank_name;
		this.timings=bank_accno;
		this.timings=bank_ifsc;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getBank_accno() {
		return bank_accno;
	}

	public void setBank_accno(String bank_accno) {
		this.bank_accno = bank_accno;
	}

	public String getBank_ifsc() {
		return bank_ifsc;
	}

	public void setBank_ifsc(String bank_ifsc) {
		this.bank_ifsc = bank_ifsc;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode= pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Employee(String uname,String pass) {
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

	public String getTimings() {
		return timings;
	}

	public void setTimings(String timings) {
		this.timings = timings;
	}

	public Long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}
	
	
}