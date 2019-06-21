package com.kitri.hello.model.service;

import com.kitri.hello.model.dao.HelloDao;

public class HelloServiceImpl implements HelloService {

	private HelloDao helloDao;
	
	public void setHelloDao(HelloDao helloDao) {
		this.helloDao = helloDao;
	}

	public String Hello(String name) {
		return name + " 안녕하세요. \n" + helloDao.getGreeting();
	}
}
