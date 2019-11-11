package com.dbms.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dbms.model.Employee;
import com.dbms.model.Vendor;
public interface Vendordao {
	@Autowired
	public void delete(String name);
	public Vendor getVendor(String name);
	public void saveOrUpdateVendor(Vendor vendor);
	public List<Vendor> showVendor();
	public void venUpdate(Vendor vendor);
}
