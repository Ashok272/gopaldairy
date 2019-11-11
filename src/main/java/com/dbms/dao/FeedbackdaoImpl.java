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

import com.dbms.model.Employee;
import com.dbms.model.Feedback;

public class FeedbackdaoImpl implements Feedbackdao{
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public FeedbackdaoImpl() {
		
	}
	
	public FeedbackdaoImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	@Transactional
	public void updateFeedback(Feedback feedback) {
		String sql="insert into Feedback(username,feed_back,suggestion,dof) values(?,?,?,?)";
		jdbcTemplate.update(sql,new Object[] {feedback.getUsername(),feedback.getFeed_back(),feedback.getSuggestion(), feedback.getDof()});
		
	}
	
	@Transactional
	public List<Feedback> disfeedback(){
		
		String sql="select * from Feedback";
		List<Feedback> allfeedback = jdbcTemplate.query(sql, new RowMapper<Feedback>(){
		@Override
		public Feedback mapRow(ResultSet rs, int rowNum) throws SQLException{
			Feedback feedback=new Feedback();
			feedback.setFeedback_id(rs.getLong("feedback_id"));
			feedback.setUsername(rs.getString("username"));
			feedback.setDof(rs.getDate("dof"));
			feedback.setFeed_back(rs.getString("feed_back"));
			feedback.setSuggestion(rs.getString("suggestion"));
			return feedback;
		}
		});
		return allfeedback;
	}



}
