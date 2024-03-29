package com.jlcindia.struts2;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class BidSearchSubmitAction extends ActionSupport{
	private String bid;
	private List<StudentTO> students = new ArrayList<>();
	
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	
	
	public List<StudentTO> getStudents() {
		return students;
	}
	public void setStudents(List<StudentTO> students) {
		this.students = students;
	}
	@Override
	public void validate() {
		System.out.println("bidSearchSubmitAction--validate()");
		
		if(bid==null || bid.length()==0)
			addFieldError("bid", getText("errors.bid.required"));
		else if(!bid.startsWith("B-"))
			addFieldError("bid", getText("errors.bid.format1"));
		else{
			String p2 = bid.substring(2);
			try{
				int x = Integer.parseInt(p2);
				if(x<10 || x>99)
					addFieldError("bid", getText("errors.bid.format2"));
			}catch(Exception e){
				addFieldError("bid", getText("errors.bid.format3"));
			}
		}
	}
	
	@Override
	public String execute() throws Exception {
		String result = "success";
		System.out.println("BidSearchSubmitAction--execute()");
		System.out.println(bid);
		if(bid.equals("B-99")){
			StudentTO sto = new StudentTO();
			sto.setSid("JLC-123");
			sto.setBid(bid);
			sto.setSname("asd");
			sto.setEmail("a@b.com");
			sto.setPhone("124656");
			
			students.add(sto);	students.add(sto);	students.add(sto);
			students.add(sto);	students.add(sto);	students.add(sto);
			students.add(sto);	students.add(sto);	students.add(sto);
		}
		else{
			result = "input";
			addActionError("Batch id not Found");
		}
		return result;
	}
	
}
