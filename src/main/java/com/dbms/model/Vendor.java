package com.dbms.model;




public class Vendor {

	private String name;
	private String address;
	//@NotEmpty(message="required")
	private Long vendor_id;

	private Long pincode;
	private String city;
	private String state;
	private String bank_name;
	private String bank_accno;
	private String bank_ifsc;
	private Long phone_no;

	private String email;
	
	public Vendor() {
		
	}
	public Vendor(String name, String address, Long pincode, String city, String state,Long phone_no, String email, String bank_name,String bank_accno,String bank_ifsc) {
		this.name=name;
		this.city=city;
		this.address=address;
		this.pincode=pincode;
		this.state=state;
		this.phone_no=phone_no;
		this.email=email;
		this.bank_name=bank_name;
		this.bank_accno=bank_accno;
		this.bank_ifsc=bank_ifsc;
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
	public Long getVendor_id() {
		return vendor_id;
	}
	public Long getVid() {
		return vendor_id;
	}
	public void setVendor_id(Long vendor_id) {
		this.vendor_id = vendor_id;
	}
	public void setVid(Long vendor_id) {
		this.vendor_id = vendor_id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
