package com.jlc.jaxrs;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	String name, email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
