package com.kitri.hello.model.dao;

import java.util.Calendar;

public class HelloDaoImpl implements HelloDao{

	Calendar calendar;

	public void makeCalendar() {
		calendar = Calendar.getInstance();
	}

	public String getGreeting() {
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		if (hour > 7 && hour < 12) {
			return "good morning";
		} else if (hour >= 12 && hour < 18) {
			return "good afternoon";
		} else {
			return "good evening";
		}
	}
}
