package com.adf.util;

public abstract class ExceptionMessageBuilder {

	public static final String HYPHEN = "-";
	public static final String DOUBLECOLONN = "::";
	public static final String COLON = ":";
	
	
	
	public static String createExceptionMessage(String service, String moduleName,String className, Exception exception) {
		
		StringBuilder errorMessage = new StringBuilder();
		errorMessage
		.append(service)
		.append(DOUBLECOLONN)
		.append(moduleName)
		.append(COLON);
		return errorMessage.toString();

	}
	
	public static String createExceptionMessage(String service, String moduleName,String className, String message){
		StringBuilder errorMessage = new StringBuilder();
		errorMessage
		.append(service)
		.append(DOUBLECOLONN)
		.append(moduleName)
		.append(COLON)
		.append(className)
		.append(HYPHEN)
		.append(message);
		return errorMessage.toString();
	}
	
	
	
}
