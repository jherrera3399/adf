package com.adf.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.adf.model.CoinsDTO;

public class CoinsDispenser {
	
	@Autowired
	private ExchangeMachineValues exchangeMachineValues;
	
	private List<CoinsDTO> coinsDispenser = new ArrayList<CoinsDTO>();

	public CoinsDispenser() {
	}
	
	
	@PostConstruct
	public void initializeObj() {

		CoinsDTO coinsDTO = new CoinsDTO();
		coinsDTO.setId(1);
		coinsDTO.setCoinDenomination(new BigDecimal(exchangeMachineValues.twentyfiveCentsAmount).setScale(2, RoundingMode.FLOOR));
		coinsDTO.setCoinQuantity(exchangeMachineValues.twentyfiveCentsQuatity);
		coinsDTO.setCoinMaxQuantity(exchangeMachineValues.twentyfiveCentsMaxQuatity);
		coinsDispenser.add(coinsDTO);

		
		CoinsDTO coinsDime = new CoinsDTO();
		coinsDime.setId(2);
		coinsDime.setCoinDenomination(new BigDecimal(exchangeMachineValues.dimeCentsAmount).setScale(2, RoundingMode.FLOOR));
		coinsDime.setCoinQuantity(exchangeMachineValues.dimeCentsQuantity);
		coinsDime.setCoinMaxQuantity(exchangeMachineValues.dimeCentsMaxQuantity);
		coinsDispenser.add(coinsDime);
		

		CoinsDTO coinsFive = new CoinsDTO();
		coinsFive.setId(3);
		coinsFive.setCoinDenomination(new BigDecimal(exchangeMachineValues.fiveCentsAmount).setScale(2, RoundingMode.FLOOR));
		coinsFive.setCoinQuantity(exchangeMachineValues.fiveCentsQuantity);
		coinsFive.setCoinMaxQuantity(exchangeMachineValues.fiveCentsMaxQuantity);
		coinsDispenser.add(coinsFive);


		CoinsDTO coinsCent = new CoinsDTO();
		coinsCent.setId(4);
		coinsCent.setCoinDenomination(new BigDecimal(exchangeMachineValues.oneCentAmout).setScale(2, RoundingMode.FLOOR));
		coinsCent.setCoinQuantity(exchangeMachineValues.oneCentQuantity);
		coinsCent.setCoinMaxQuantity(exchangeMachineValues.oneCentMaxQuantity);
		coinsDispenser.add(coinsCent);
		
		Collections.sort(coinsDispenser);
		
		
	}
	
	public List<CoinsDTO> getCoinsDispenser() {
		return coinsDispenser;
	}

	public void setCoinsDispenser(List<CoinsDTO> coinsDispenser) {
		this.coinsDispenser = coinsDispenser;
	}
	


}
