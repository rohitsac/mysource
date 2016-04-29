package com.hibernate;

import java.util.Set;

public class Course {
	private Integer cid;
	private String cname;
	private Integer duration;
	private double cost;
	private Set<Student> students;
	
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Course(){}

	public Course(String cname, Integer duration, double cost) {
		super();
		this.cname = cname;
		this.duration = duration;
		this.cost = cost;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return cid+"\t"+cname+"\t"+duration+"\t"+cost;
	}

}
