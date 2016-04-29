package com.jlcindia.servlets;

import javax.servlet.http.*;

public class MySessionListener implements HttpSessionListener{

	public MySessionListener(){
		System.out.println("MySessionListener def cons");
	}
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("session created");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("session destroyed");
	}
	
}
