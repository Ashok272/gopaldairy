package com.dbms.model;



public class Product {

	private String name;
	private Long vid;
	private long product_id;
	public long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}
	private String type;
	private Long qinstock;
	private Long price;
	private Long pcksize;

	public Product() {}
	public Product(String name, Long vid,   String type, Long price, Long qinstock, Long pcksize, Long carea, Long product_id) {
		this.name=name;
		this.vid=vid;
		this.type=type;
		this.price=price;
		this.qinstock=qinstock;
		this.pcksize=pcksize;
		this.product_id=product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getVid() {
		return vid;
	}
	public void setVid(Long vid) {
		this.vid = vid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public Long getQinstock() {
		return qinstock;
	}
	public void setQinstock(Long qinstock) {
		this.qinstock = qinstock;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getPcksize() {
		return pcksize;
	}
	public void setPcksize(Long pcksize) {
		this.pcksize = pcksize;
	}


	
}
