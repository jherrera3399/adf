package com.adf.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class BillToExchange implements Serializable {

	private Integer billQuantity;
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
