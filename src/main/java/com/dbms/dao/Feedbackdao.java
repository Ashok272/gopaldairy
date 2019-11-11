package com.dbms.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dbms.model.Feedback;

public interface Feedbackdao {
	@Autowired
	public void updateFeedback(Feedback feedback);
	public List<Feedback> disfeedback();
}
