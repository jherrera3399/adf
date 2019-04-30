package com.adf.util;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("coinExchangeWrapper")
public class CoinExchangeWrapper {

	private BigDecimal total = new BigDecimal(BigInteger.ZERO,2);
	private Integer currentCoinQuantity;
	private Integer maxCoinQuantity;
	private BigDecimal currentCoinDenomination = new BigDecimal(BigInteger.ZERO,2);
	
	public CoinExchangeWrapper() {
	}
	
	public Integer getCurrentCoinQuantity() {
		return currentCoinQuantity;
	}
	public void setCurrentCoinQuantity(Integer currentCoinQuantity) {
		this.currentCoinQuantity = currentCoinQuantity;
	}
	public Integer getMaxCoinQuantity() {
		return maxCoinQuantity;
	}
	public void setMaxCoinQuantity(Integer maxCoinQuantity) {
		this.maxCoinQuantity = maxCoinQuantity;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public BigDecimal getCurrentCoinDenomination() {
		return currentCoinDenomination;
	}

	public void setCurrentCoinDenomination(BigDecimal currentCoinDenomination) {
		this.currentCoinDenomination = currentCoinDenomination;
	}

	
	
	
}
