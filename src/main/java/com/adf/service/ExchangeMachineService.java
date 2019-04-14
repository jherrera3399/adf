package com.adf.service;

import java.util.List;

import com.adf.model.BillToExchange;
import com.adf.response.CoinsResponse;

public interface ExchangeMachineService {

	public List<CoinsResponse> billsToCoinst(List<BillToExchange> lstBillToExchange) throws Exception;
	
}
