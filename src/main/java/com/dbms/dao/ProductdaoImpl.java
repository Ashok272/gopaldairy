package com.dbms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.transaction.annotation.Transactional;

import com.dbms.model.Product;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
public class ProductdaoImpl implements Productdao{
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ProductdaoImpl() {
		
	}
	@Transactional
	public List<Product> showProducts(){
		String sql="select * from Product";
		List<Product> allpro =jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
		return allpro;
	}
	public ProductdaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	@Transactional
	public void delete(Long product_id) {
		String sql = "DELETE FROM Product WHERE product_id=?";
		jdbcTemplate.update(sql,product_id);
	}
	@Transactional
	public Product getProduct(Long product_id) {
		String sql = "SELECT * FROM Product WHERE product_id='"+product_id+"'";
		return jdbcTemplate.query(sql,new ResultSetExtractor<Product>() {
		
		public Product extractData(ResultSet rs) throws SQLException,DataAccessException{
			if(rs.next()) {
				Product product = new Product();
				product.setName(rs.getString("name"));
				//product.setPassword(rs.getString("password"));
				product.setVid(rs.getLong("vid"));
				product.setProduct_id(rs.getLong("product_id"));
				product.setType(rs.getString("type"));
				product.setQinstock(rs.getLong("qinstock"));
				product.setPrice(rs.getLong("price"));
				product.setPcksize(rs.getLong("pcksize"));
				return product;
			}
			return null;
		}
		
	});
		
	}
	@Transactional
	public void saveOrUpdateProduct(Product product) {
		String sql="INSERT INTO Product(vid, type, qinstock, price, pcksize, name) VALUES(?,?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {product.getVid(), product.getType(),product.getQinstock(),product.getPrice(),product.getPcksize(),product.getName()});
		
	}
		
	public void proUpdate(Product product) {
		String sql="Update Product set vid=?, type=?,qinstock=?,price=?,pcksize=?,name=? where product_id=?";
		jdbcTemplate.update(sql,new Object[] {product.getVid(),product.getType(),product.getQinstock(),product.getPrice(), product.getPcksize(),product.getName(),product.getProduct_id()});
	}
	
}
