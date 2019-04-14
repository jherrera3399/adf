package com.adf.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExchangeMachineValues {
		
	@Value("${twentyfiveCentsquatity}")
	public Integer twentyfiveCentsQuatity;
	
	@Value("${twentyfiveCentsAmount}")
	public Double twentyfiveCentsAmount; 
	
	@Value("${twentyfiveCentsmaxquatity}")
	public Integer twentyfiveCentsMaxQuatity;
			
	@Value("${dimecentsquantity}")		
	public Integer dimeCentsQuantity;	
	
	@Value("${dimecentsamount}")
	public Double dimeCentsAmount;

	@Value("${dimecentsmaxquantity}")
	public Integer dimeCentsMaxQuantity;
	
	@Value("${fivecentsquantity}")
	public Integer fiveCentsQuantity;
	
	@Value("${fivecentsamount}")
	public Double fiveCentsAmount;
	
	@Value("${fivecentsmaxquantity}")
	public Integer fiveCentsMaxQuantity;
			
	@Value("${onecentquantity}")		
	public Integer oneCentQuantity;
	
	@Value("${onecentamout}")
	public Double oneCentAmout;
	
	@Value("${onecentmaxquantity}")
	public Integer oneCentMaxQuantity;
	
	@Value("${tenCentsAmount}")
	public Integer tenCentsAmount;
	
}
