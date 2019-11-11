package com.dbms.model;

import java.sql.Date;

public class Feedback {
	
	private Long feedback_id;
	private String username;
	private Date dof;
	private String feed_back;
	private String suggestion;
	public Long getFeedback_id() {
		return feedback_id;
	}
	public void setFeedback_id(Long feedback_id) {
		this.feedback_id = feedback_id;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getDof() {
		return dof;
	}
	public void setDof(Date dof) {
		this.dof = dof;
	}
	public String getFeed_back() {
		return feed_back;
	}
	public void setFeed_back(String feed_back) {
		this.feed_back = feed_back;
	}
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}


}
