package com.jlcindia.spring;

import org.springframework.context.ApplicationEvent;

public class BatchEvent extends ApplicationEvent{
	
	Batch batch;
	
	public BatchEvent(Object source, Batch batch) {
		super(source);
		this.batch = batch;
	}

	public Batch getBatch() {
		return batch;
	}
	
}
