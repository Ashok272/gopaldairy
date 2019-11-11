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

import com.dbms.model.Dailyvendorbuy;
import com.dbms.model.Dailyvendorbuy;
public class DailyvendorbuydaoImpl implements Dailyvendorbuydao{
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public DailyvendorbuydaoImpl() {
			
		}
	
	
	
	public DailyvendorbuydaoImpl (DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	@Transactional
	public void updatedailyvendorbuy(Dailyvendorbuy dailyvendorbuy) {
		String sql="insert into Dailyvendorbuy(vennid,proddid,doprodbuy,quan,price) values(?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {dailyvendorbuy.getVennid(),dailyvendorbuy.getProddid(),dailyvendorbuy.getDoprodbuy(),dailyvendorbuy.getQuan(),dailyvendorbuy.getPrice()});
		
	}
	
	
	
	@Transactional
	public List<Dailyvendorbuy> disdailyvendorbuy(){
		
		String sql="select * from Dailyvendorbuy";
		List<Dailyvendorbuy> alldailyvendorbuy = jdbcTemplate.query(sql, new RowMapper<Dailyvendorbuy>(){
		@Override
		public Dailyvendorbuy mapRow(ResultSet rs, int rowNum) throws SQLException{
			Dailyvendorbuy dailyvendorbuy=new Dailyvendorbuy();
			dailyvendorbuy.setVennid(rs.getLong("vennid"));
			dailyvendorbuy.setProddid(rs.getLong("proddid"));
			dailyvendorbuy.setDoprodbuy(rs.getDate("doprodbuy"));
			dailyvendorbuy.setQuan(rs.getLong("quan"));
			dailyvendorbuy.setPrice(rs.getLong("price"));
			
			return dailyvendorbuy;
		}
		});
		return alldailyvendorbuy;
	}

}
