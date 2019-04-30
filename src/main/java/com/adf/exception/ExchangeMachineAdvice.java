package com.adf.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.adf.model.ExchangeMachineMessage;
import com.adf.util.ExceptionMessageBuilder;

@RestControllerAdvice
public class ExchangeMachineAdvice {

	@Autowired
	private Logger logger;
	
	private static final String ERROR_PROCESSING_REQUEST = "Error";
	private static final String PROCESS_NAME = "ExchangeMachineService";
	private static final String TECHNICAL_EXCEPTION_MESSAGE = "Technical Error";

	@ExceptionHandler(ExchangeMachineException.class)
	public ResponseEntity<ExchangeMachineMessage> agreementsExceptionHandler(ExchangeMachineException exception) {
		ExchangeMachineMessage exchangeMessage = new ExchangeMachineMessage();
		exchangeMessage.setStatus(ERROR_PROCESSING_REQUEST);
		exchangeMessage.setStatusCode(HttpStatus.BAD_REQUEST.value());
		exchangeMessage.setMessage(exception.getErrorMessage());
		if (exception.getErrIds() != null && exception.getErrIds().size() > 0) {
			exchangeMessage.setResults(exception.getErrIds());
		}
		
		if (exception.getLogLevel() == Level.INFO) {
			logger.info("ExchangeMachineException");
		}else if (exception.getLogLevel() == Level.WARNING) {
			logger.warning("ExchangeMachineException");
		}else {
			String sMessage = ExceptionMessageBuilder.createExceptionMessage(PROCESS_NAME, 
					TECHNICAL_EXCEPTION_MESSAGE,exception.getClassName(), exception);
			logger.log(Level.INFO, sMessage);
		}
		
		return new ResponseEntity<ExchangeMachineMessage>(exchangeMessage, HttpStatus.BAD_REQUEST);
	}

	
}
