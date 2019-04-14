package com.adf.response;

import java.io.Serializable;

public class CoinsResponse implements Serializable {

	private Integer coinQuantity;
	private Double coinDenomination;
	private Double coinAmount;
	
	public Integer getCoinQuantity() {
		return coinQuantity;
	}
	public void setCoinQuantity(Integer coinQuantity) {
		this.coinQuantity = coinQuantity;
	}
	public Double getCoinDenomination() {
		return coinDenomination;
	}
	public void setCoinDenomination(Double coinDenomination) {
		this.coinDenomination = coinDenomination;
	}
	public Double getCoinAmount() {
		return coinAmount;
	}
	public void setCoinAmount(Double coinAmount) {
		this.coinAmount = coinAmount;
	}
	
	
}
