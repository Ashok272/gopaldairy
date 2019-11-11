package com.dbms.model;

import java.sql.Date;

public class Dailyvendorbuy {
	
	private Long vennid;
	private Long proddid;
	private Date doprodbuy;
	private Long quan;
	private Long pricevenby;
	
	
	public Long getVennid() {
		return vennid;
	}
	public void setVennid(Long vennid) {
		this.vennid = vennid;
	}
	public Long getProddid() {
		return proddid;
	}
	public void setProddid(Long proddid) {
		this.proddid = proddid;
	}
	public Date getDoprodbuy() {
		return doprodbuy;
	}
	public void setDoprodbuy(Date doprodbuy) {
		this.doprodbuy = doprodbuy;
	}
	public Long getQuan() {
		return quan;
	}
	public void setQuan(Long quan) {
		this.quan = quan;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	private Long price;

}
