package com.adf.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class ExchangeMachineException extends Exception {

	private static final long serialVersionUID = 4764559310948658394L;
	private String errorMessage;
	private String className;
	private String errorCode;
	private List<?> errIds = new ArrayList<>();
	private Level logLevel = Level.WARNING;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public List<?> getErrIds() {
		return errIds;
	}
	public void setErrIds(List<?> errIds) {
		this.errIds = errIds;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public Level getLogLevel() {
		return logLevel;
	}
	public void setLogLevel(Level logLevel) {
		this.logLevel = logLevel;
	}

	
}
