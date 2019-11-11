package com.dbms.model;

import java.sql.Date;

public class PayLog {
	private Long emp_id;
	private Long ven_id;
	private String description;
	private Long amount;
	private Date dop;
	private String ptype;
	private Long payid;
	public Long getPayid() {
		return payid;
	}

	public void setPayid(Long payid) {
		this.payid = payid;
	}

	public PayLog() {
		
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}

	public Long getVen_id() {
		return ven_id;
	}

	public void setVen_id(Long ven_id) {
		this.ven_id = ven_id;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Date getDop() {
		return dop;
	}

	public void setDop(Date dop) {
		this.dop = dop;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	
	
}
