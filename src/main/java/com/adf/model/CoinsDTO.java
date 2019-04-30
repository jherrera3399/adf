package com.adf.model;

import java.math.BigDecimal;

public class CoinsDTO implements Comparable<CoinsDTO>{

	private Integer id;
	private Integer coinQuantity;
	private BigDecimal coinDenomination;
	private Integer coinMaxQuantity;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCoinQuantity() {
		return coinQuantity;
	}
	public void setCoinQuantity(Integer coinQuantity) {
		this.coinQuantity = coinQuantity;
	}


	
	
	public BigDecimal getCoinDenomination() {
		return coinDenomination;
	}
	public void setCoinDenomination(BigDecimal coinDenomination) {
		this.coinDenomination = coinDenomination;
	}
	public Integer getCoinMaxQuantity() {
		return coinMaxQuantity;
	}
	public void setCoinMaxQuantity(Integer coinMaxQuantity) {
		this.coinMaxQuantity = coinMaxQuantity;
	}

	@Override
	public int compareTo(CoinsDTO o) {
		
		if(id == null || o.getId() == null) {
			return 0;
		}
		
		return id.compareTo(o.id);
	}
	
	
}
