package com.flower.navigation.common;

public class AjaxEntity {
	
	private String resCode;
	
	private String message;
	
	private Object record;
	
	

	public AjaxEntity(String resCode, String message, Object record) {
		super();
		this.resCode = resCode;
		this.message = message;
		this.record = record;
	}


	public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getRecord() {
		return record;
	}

	public void setRecord(Object record) {
		this.record = record;
	}
	
	

}
