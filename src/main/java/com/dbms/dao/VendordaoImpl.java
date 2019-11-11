package com.dbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;

import com.dbms.model.Vendor;

public class VendordaoImpl implements Vendordao{
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public VendordaoImpl() {
		
	}
	
	public VendordaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	@Transactional
	public void delete(String name) {
		String sql = "DELETE FROM Vendor WHERE name=?";
		jdbcTemplate.update(sql,name);
	}
	@Transactional
	public Vendor getVendor(String name) {
		String sql = "SELECT * FROM Vendor WHERE name='"+name+"'";
		return jdbcTemplate.query(sql,new ResultSetExtractor<Vendor>() {
		
		public Vendor extractData(ResultSet rs) throws SQLException,DataAccessException{
			if(rs.next()) {
				Vendor vendor = new Vendor();
				vendor.setName(rs.getString("name"));
				//vendor.setPassword(rs.getString("password"));
				vendor.setAddress(rs.getString("address"));
				vendor.setState(rs.getString("state"));
				vendor.setPincode(rs.getLong("pincode"));
				vendor.setCity(rs.getString("city"));
				vendor.setEmail(rs.getString("email"));
				vendor.setPhone_no(rs.getLong("phone_no"));
				vendor.setBank_name(rs.getString("bank_name"));
				vendor.setBank_accno(rs.getString("bank_accno"));
				vendor.setBank_ifsc(rs.getString("bank_ifsc"));
				return vendor;
			}
			return null;
		}
		
	});
		
	}
	@Transactional
	public void saveOrUpdateVendor(Vendor vendor) {
		String sql="INSERT INTO Vendor(name, address,city, state, pincode, email, phone_no, bank_name ,bank_accno, bank_ifsc) VALUES(?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {vendor.getName(),vendor.getAddress(), vendor.getCity(),vendor.getState(),vendor.getPincode(),vendor.getEmail(),vendor.getPhone_no(),vendor.getBank_name(),vendor.getBank_accno(), vendor.getBank_ifsc()});
		
	}
	@Transactional	
	public List<Vendor> showVendor(){
		String sql="select * from Vendor";
		List <Vendor> allven=jdbcTemplate.query(sql,new RowMapper<Vendor>() {
			@Override
			public Vendor mapRow(ResultSet rs, int rowNum) throws SQLException{
				Vendor vendor = new Vendor();
				vendor.setName(rs.getString("name"));
				vendor.setVendor_id(rs.getLong("vendor_id"));
				vendor.setAddress(rs.getString("address"));
				vendor.setState(rs.getString("state"));
				vendor.setPincode(rs.getLong("pincode"));
				vendor.setCity(rs.getString("city"));
				vendor.setEmail(rs.getString("email"));
				vendor.setBank_name(rs.getString("bank_name"));
				vendor.setBank_accno(rs.getString("bank_accno"));
				vendor.setBank_ifsc(rs.getString("bank_ifsc"));
				vendor.setPhone_no(rs.getLong("phone_no"));
				return vendor;
			}
		});
		return allven;
	}
	@Transactional
	public void venUpdate(Vendor vendor) {
		String sql="update Vendor set address=?,city=?,state=?,pincode=?,email=?,phone_no=?,bank_name=?,bank_accno=?,bank_ifsc=? where name=?";
		jdbcTemplate.update(sql, new Object[] {vendor.getAddress(),vendor.getCity(),vendor.getState(),vendor.getPincode(),vendor.getEmail(),vendor.getPhone_no(),vendor.getBank_name(),vendor.getBank_accno(),vendor.getBank_ifsc(),vendor.getName()});
		
	}

}
