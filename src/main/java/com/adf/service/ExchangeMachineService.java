package com.adf.service;

import java.util.List;

import com.adf.exception.ExchangeMachineException;
import com.adf.model.BillToExchange;
import com.adf.response.CoinsResponse;

public interface ExchangeMachineService {
	
	public List<CoinsResponse> billsToCoinstRef(List<BillToExchange> lstBillToExchange) throws ExchangeMachineException;

}
