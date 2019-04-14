package com.adf.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.adf.model.BillToExchange;
import com.adf.response.CoinsResponse;
import com.adf.util.CoinExchangeWrapper;
import com.adf.util.ExchangeMachineValues;

@Service
@Qualifier("exchangeMachineService")
public class ExchangeMachineServiceImpl implements ExchangeMachineService {

	
	@Autowired
	private ExchangeMachineValues exchangeMachineValues;
	
	
	
	@Override
	public List<CoinsResponse> billsToCoinst(List<BillToExchange> lstBillToExchange) throws Exception {
		// TODO Auto-generated method stub
	
		Double dTotal = 0.0;
		Double dQuaterCoinsAmount = 0.0;
		Integer iMaxQuarterAmount = 0;
		Double dDimeCointsAmount = 0.0;
		Integer iMaxDimeAmount = 0;
		Integer iMaxFiveQuantity = 0;
		Double dFiveCoinsAmount = 0.0;
		Integer iMaxOneQuantity = 0;
		Double dOneCoinsAmount = 0.0;
		
		List<CoinsResponse> lstCoinsResponse = new ArrayList<CoinsResponse>();
		
		CoinExchangeWrapper coinExchangeWrapper = new CoinExchangeWrapper();
		
//		coinExchangeWrapper.setTotal(0.0);
		
		for(BillToExchange billToExchange : lstBillToExchange) {
			dTotal = dTotal + (billToExchange.getBillQuantity() * billToExchange.getBillAmount().doubleValue());
		}
		
		coinExchangeWrapper.setTotal(dTotal);
		System.out.println("Amount to Exchange : " + dTotal );
		if(exchangeMachineValues.twentyfiveCentsQuatity > exchangeMachineValues.twentyfiveCentsMaxQuatity ) {
			iMaxQuarterAmount = exchangeMachineValues.twentyfiveCentsMaxQuatity;
		}else {
			iMaxQuarterAmount = exchangeMachineValues.twentyfiveCentsQuatity;
		}
		
		dQuaterCoinsAmount = exchangeMachineValues.twentyfiveCentsAmount * iMaxQuarterAmount;
		dTotal = dTotal - dQuaterCoinsAmount;
		coinExchangeWrapper.setTotal(coinExchangeWrapper.getTotal() - dQuaterCoinsAmount);
		if(dQuaterCoinsAmount > 0.0) {
			CoinsResponse quaterResponse = new CoinsResponse();
			quaterResponse.setCoinQuantity(iMaxQuarterAmount);
			quaterResponse.setCoinDenomination(exchangeMachineValues.twentyfiveCentsAmount);
			quaterResponse.setCoinAmount(dQuaterCoinsAmount);
			lstCoinsResponse.add(quaterResponse);
			exchangeMachineValues.twentyfiveCentsQuatity = exchangeMachineValues.twentyfiveCentsQuatity - iMaxQuarterAmount;  
		}
		
		
		System.out.println("--------------");
		System.out.println("Quaters Amount : " + dQuaterCoinsAmount);
		System.out.println("Amount after substraction : " + dTotal);
		System.out.println("Remaining coins in machine : " + exchangeMachineValues.twentyfiveCentsQuatity);
		System.out.println("Wrapper Amount after Substraction coins in machine : " + coinExchangeWrapper.getTotal());

		//Dime Calculations 
		if(exchangeMachineValues.dimeCentsQuantity > exchangeMachineValues.dimeCentsMaxQuantity ) {
			iMaxDimeAmount = exchangeMachineValues.dimeCentsMaxQuantity;
		}else {
			iMaxDimeAmount = exchangeMachineValues.dimeCentsQuantity;
		}
		
		dDimeCointsAmount = exchangeMachineValues.dimeCentsAmount * iMaxQuarterAmount;
		dTotal = dTotal - dDimeCointsAmount;
		coinExchangeWrapper.setTotal(coinExchangeWrapper.getTotal() - dDimeCointsAmount);
		if(dDimeCointsAmount > 0.0) {
			CoinsResponse coinsResponse = new CoinsResponse();
			coinsResponse.setCoinQuantity(iMaxQuarterAmount);
			coinsResponse.setCoinDenomination(exchangeMachineValues.dimeCentsAmount);
			coinsResponse.setCoinAmount(dDimeCointsAmount);
			lstCoinsResponse.add(coinsResponse);
			exchangeMachineValues.dimeCentsQuantity = exchangeMachineValues.dimeCentsQuantity - iMaxQuarterAmount;  
		}

		
		System.out.println("Dime Calculations --------------");
		System.out.println("Dime Amount : " + dDimeCointsAmount);
		System.out.println("Amount after substraction : " + dTotal);
		System.out.println("Remaining coins in machine : " + exchangeMachineValues.dimeCentsQuantity );
		System.out.println("Wrapper Amount after Substraction coins in machine : " + coinExchangeWrapper.getTotal());

		
		//Five Cents Calculation
		
		if(exchangeMachineValues.fiveCentsQuantity > exchangeMachineValues.fiveCentsMaxQuantity ) {
			iMaxFiveQuantity = exchangeMachineValues.fiveCentsMaxQuantity;
		}else {
			iMaxFiveQuantity = exchangeMachineValues.fiveCentsQuantity;
		}
		
		dFiveCoinsAmount = exchangeMachineValues.fiveCentsAmount * iMaxFiveQuantity;
		dTotal = dTotal - dFiveCoinsAmount;
		if(dFiveCoinsAmount > 0.0) {
			CoinsResponse coinsResponse = new CoinsResponse();
			coinsResponse.setCoinQuantity(iMaxFiveQuantity);
			coinsResponse.setCoinDenomination(exchangeMachineValues.fiveCentsAmount);
			coinsResponse.setCoinAmount(dFiveCoinsAmount);
			lstCoinsResponse.add(coinsResponse);
			exchangeMachineValues.fiveCentsQuantity = exchangeMachineValues.fiveCentsQuantity - iMaxFiveQuantity;  
		}

		
		System.out.println("Five Cents Calculations --------------");
		System.out.println("Five Cents Amount : " + dFiveCoinsAmount);
		System.out.println("Amount after substraction : " + dTotal);
		System.out.println("Remaining coins in machine : " + exchangeMachineValues.fiveCentsQuantity );

		
		//One Cent Calculation
		
		if(exchangeMachineValues.oneCentQuantity > exchangeMachineValues.oneCentMaxQuantity ) {
			iMaxOneQuantity = exchangeMachineValues.oneCentMaxQuantity;
		}else {
			iMaxOneQuantity = exchangeMachineValues.oneCentQuantity;
		}
		
		dOneCoinsAmount = exchangeMachineValues.oneCentAmout * iMaxOneQuantity;
		dTotal = dTotal - dOneCoinsAmount;
		if(dOneCoinsAmount > 0.0) {
			CoinsResponse coinsResponse = new CoinsResponse();
			coinsResponse.setCoinQuantity(iMaxOneQuantity);
			coinsResponse.setCoinDenomination(exchangeMachineValues.oneCentAmout);
			coinsResponse.setCoinAmount(dOneCoinsAmount);
			lstCoinsResponse.add(coinsResponse);
			exchangeMachineValues.oneCentQuantity = exchangeMachineValues.oneCentQuantity - iMaxOneQuantity;  
		}

		
		System.out.println("One Cents Calculations --------------");
		System.out.println("One Cents Amount : " + dOneCoinsAmount);
		System.out.println("Amount after substraction : " + dTotal);
		System.out.println("Remaining coins in machine : " + exchangeMachineValues.oneCentQuantity );
		
		
		return lstCoinsResponse;
	}

	
	
	private void getCoinsCalculation(Integer coinsCurrentQuantity, Integer coinsMaxQuantity, Double coinsDonomination, Double dTotal, List<CoinsResponse> lstCoinsResponse, CoinExchangeWrapper coinExchangeWrapper ) {
		
		Integer iMaxCoinsQuantity = 0;
		Double dCoinsAmount = 0.0;
		
		
		if(coinsCurrentQuantity > coinsMaxQuantity ) {
			iMaxCoinsQuantity = coinsMaxQuantity;
		}else {
			iMaxCoinsQuantity = coinsCurrentQuantity;
		}
		
		dCoinsAmount = coinsDonomination * iMaxCoinsQuantity;
		dTotal = dTotal - dCoinsAmount;
		if(dCoinsAmount > 0.0) {
			CoinsResponse quaterResponse = new CoinsResponse();
			quaterResponse.setCoinQuantity(iMaxCoinsQuantity);
			quaterResponse.setCoinDenomination(coinsDonomination);
			quaterResponse.setCoinAmount(dCoinsAmount);
			lstCoinsResponse.add(quaterResponse);
			coinsCurrentQuantity = coinsCurrentQuantity - iMaxCoinsQuantity;
			coinExchangeWrapper.setCurrentCoinQuantity(coinsCurrentQuantity);
		
		}
		
	}
}
