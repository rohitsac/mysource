package com.spring.rest.to;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="students")
public class Students {

	List<StudentTO> studList = new ArrayList<StudentTO>();
	
	@XmlElement(name="student")
	public List<StudentTO> getStudList(){
		return studList;
	}
	
	public void setStudList(List<StudentTO> studList){
		this.studList = studList;
	}
	
}
