package com.spring.mvc;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		
		return Student.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Student stu = (Student)obj;
		
		if(stu.getSname()==null || stu.getSname().length()==0)
			errors.rejectValue("sname", "errors.sname.required", new Object[]{}, "Name is Required");
		
		if(stu.getPhone()==null || stu.getPhone().length()==0)
			errors.rejectValue("phone", "errors.phone.required", new Object[]{}, "Phone is Required");
		
		else if(stu.getPhone().length() != 10) {
			errors.rejectValue("phone", "errors.phone.invalid", new Object[]{}, "Invalid Phone");
		}
		
		else if(stu.getPhone().length() == 10){
			try{
				Long.parseLong(stu.getPhone());
			}catch(Exception e){
				errors.rejectValue("phone", "errors.phone.invalid", new Object[]{}, "Only Digits Allowed");
			}
		}
		
		if(stu.getEmail()==null || stu.getEmail().length()==0)
			errors.rejectValue("email", "errors.email.required", new Object[]{}, "Email is Required");
		
		else if(!((stu.getEmail().contains("@")) && (stu.getEmail().endsWith(".com") || stu.getEmail().endsWith(".co.in") || stu.getEmail().endsWith(".in")))){
			errors.rejectValue("email", "errors.email.invalid", new Object[]{}, "Invalid Email");
		}
		
		if(stu.getTimings().length < 1)
			errors.rejectValue("timings", "errors.timings", new Object[]{}, "Select Suitable Timings");
		
		if(stu.getGender() == null || stu.getGender().length() == 0)
			errors.rejectValue("gender", "errors.gender", new Object[]{}, "Gender is required");
		
		if(stu.getQualification()==null || stu.getQualification().length()==0 || stu.getQualification().equals("----Select Option----"))
			errors.rejectValue("qualification", "errors.qualification", new Object[]{}, "Select Qualification");
		
	}

	

}
