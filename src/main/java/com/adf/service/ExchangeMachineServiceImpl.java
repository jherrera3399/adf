package com.adf.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.adf.exception.ExchangeMachineException;
import com.adf.model.BillToExchange;
import com.adf.model.CoinsDTO;
import com.adf.response.CoinsResponse;
import com.adf.util.CoinExchangeWrapper;
import com.adf.util.CoinsDispenser;

@Service
@Qualifier("exchangeMachineService")
public class ExchangeMachineServiceImpl implements ExchangeMachineService {
	
	@Autowired
	private CoinExchangeWrapper coinExchangeWrapper;
	
	
	@Autowired
	private CoinsDispenser coinsDispenser;
	
	MathContext mc = new MathContext(2);
	
	
	private void getCoinsCalculation(CoinExchangeWrapper coinExchangeWrapper, List<CoinsResponse> lstCoinsResponse) {
		
		BigDecimal requieredCoins = new BigDecimal(BigInteger.ZERO,2);
		BigDecimal dCoinsAmount = new BigDecimal(BigInteger.ZERO,2);
		BigDecimal tempTotal = new BigDecimal(BigInteger.ZERO,2);
		BigDecimal newTotal = new BigDecimal(BigInteger.ZERO,2);
		BigDecimal currentDenomination = new BigDecimal(BigInteger.ZERO,2);
		Integer iMaxCoinsQuantity = 0;
		
		currentDenomination = coinExchangeWrapper.getCurrentCoinDenomination().setScale(2, RoundingMode.FLOOR);
		tempTotal = coinExchangeWrapper.getTotal().setScale(2, RoundingMode.CEILING);
		
		requieredCoins = tempTotal.divide(currentDenomination,2,RoundingMode.FLOOR);
		
		if(requieredCoins.intValue() > coinExchangeWrapper.getCurrentCoinQuantity()) {
			iMaxCoinsQuantity = coinExchangeWrapper.getCurrentCoinQuantity();
		}else if(requieredCoins.intValue() <= coinExchangeWrapper.getCurrentCoinQuantity()) {
			iMaxCoinsQuantity = requieredCoins.intValue();
		}else {
			iMaxCoinsQuantity = coinExchangeWrapper.getMaxCoinQuantity();
		}
		
		dCoinsAmount = currentDenomination.multiply(new BigDecimal(iMaxCoinsQuantity).setScale(2, RoundingMode.FLOOR));
		newTotal = tempTotal.subtract(dCoinsAmount, mc);
		coinExchangeWrapper.setTotal(newTotal);
		if(dCoinsAmount.doubleValue() > 0.0) {
			CoinsResponse coinsResponse = new CoinsResponse();
			coinsResponse.setCoinQuantity(iMaxCoinsQuantity);
			coinsResponse.setCoinDenomination(coinExchangeWrapper.getCurrentCoinDenomination().doubleValue());
			coinsResponse.setCoinAmount(dCoinsAmount.doubleValue());
			lstCoinsResponse.add(coinsResponse);
			coinExchangeWrapper.setCurrentCoinQuantity(coinExchangeWrapper.getCurrentCoinQuantity() -iMaxCoinsQuantity);
		
		}
		
	}



	@Override
	public List<CoinsResponse> billsToCoinstRef(List<BillToExchange> lstBillToExchange) throws ExchangeMachineException {
		// TODO Auto-generated method stub
		
		Double dTotal = 0.0;
		List<CoinsResponse> lstCoinsResponse = new ArrayList<CoinsResponse>();
		String erroMessage = null;
		
		for(BillToExchange billToExchange : lstBillToExchange) {
			dTotal = dTotal + (billToExchange.getBillQuantity() * billToExchange.getBillAmount().doubleValue());
		}
		
		try {
		
			//Iterate over coins denomination for calculation
			coinExchangeWrapper.setTotal(new BigDecimal(dTotal).setScale(2, RoundingMode.FLOOR));
			for(CoinsDTO coins : coinsDispenser.getCoinsDispenser() ) {
			
				System.out.println("Coin id : " + coins.getId() + " Denomination : " + coins.getCoinDenomination() + " Quantity : " + coins.getCoinQuantity());
				
				if(coins.getCoinQuantity() > 0) {
					coinExchangeWrapper.setCurrentCoinDenomination(coins.getCoinDenomination());
					coinExchangeWrapper.setCurrentCoinQuantity(coins.getCoinQuantity());
					coinExchangeWrapper.setMaxCoinQuantity(coins.getCoinMaxQuantity());
					getCoinsCalculation(coinExchangeWrapper, lstCoinsResponse);
					coins.setCoinQuantity(coinExchangeWrapper.getCurrentCoinQuantity());
				}
				
				System.out.println("Total Remain for Calculation : " + coinExchangeWrapper.getTotal());
				
				if(coinExchangeWrapper.getTotal().compareTo(BigDecimal.ZERO) == 0) {
					break;
				}
			}

			//Amount still not completed, needs to raise error
			if(coinExchangeWrapper.getTotal().compareTo(BigDecimal.ZERO) != 0) {
				//Raise exception
				erroMessage = "Not Enough coins to complete exchange";
				throw new Exception();
			}
		
		}catch(Exception e) {
			if(erroMessage != null) {
				throw getExchangeMachineException(erroMessage, e);
			}else {
				throw getExchangeMachineException(e.getMessage(), e);
			}
		}
		
		
		return lstCoinsResponse;
	}
	

	private ExchangeMachineException getExchangeMachineException(String errorMessage, Exception e) {
		
		ExchangeMachineException betaProgramException = new ExchangeMachineException();
		betaProgramException.setErrorMessage(errorMessage + e.getMessage());
		if (e.getStackTrace()!=null) {
			betaProgramException.setStackTrace(e.getStackTrace());
			betaProgramException.setClassName(e.getClass().getName());
			betaProgramException.setErrorMessage(errorMessage);
			betaProgramException.setLogLevel(Level.WARNING);
		}
		
		return betaProgramException;
	}



}
