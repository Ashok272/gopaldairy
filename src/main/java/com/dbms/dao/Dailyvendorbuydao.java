package com.dbms.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dbms.model.Dailyvendorbuy;

public interface Dailyvendorbuydao {
	

		@Autowired
		public abstract void updatedailyvendorbuy(Dailyvendorbuy dailyvendorbuy);
		public List<Dailyvendorbuy> disdailyvendorbuy();
	

}
