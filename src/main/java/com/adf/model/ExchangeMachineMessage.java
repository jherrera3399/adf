package com.adf.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class ExchangeMachineMessage implements Serializable{

	private static final long serialVersionUID = 2301340355375517301L;
	private String status;
	private String message;
	private int statusCode;
	private List<?> results= new ArrayList<>();
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public List<?> getResults() {
		return results;
	}
	public void setResults(List<?> results) {
		this.results = results;
	}

	
	
	
}
