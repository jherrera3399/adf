package com.adf.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Pattern;

public class BillToExchange implements Serializable {

	@Pattern(regexp = "^[0-9]\\\\d{0,4}", message = "Invalid amount to exchange, please review your data and try again!")
	private Integer billQuantity;
	
	@Pattern(regexp = "^[0-9]\\d{0,9}(\\.\\d{1,2})?%?$", message = "Invalid amount to exchange, please review your data and try again!")
	private BigDecimal billAmount;
	
	public Integer getBillQuantity() {
		return billQuantity;
	}
	public void setBillQuantity(Integer billQuantity) {
		this.billQuantity = billQuantity;
	}
	public BigDecimal getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(BigDecimal billAmount) {
		this.billAmount = billAmount;
	}
	
	
}
