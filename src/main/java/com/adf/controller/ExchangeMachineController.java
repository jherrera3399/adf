package com.adf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adf.exception.ExchangeMachineException;
import com.adf.model.BillToExchange;
import com.adf.request.ExchangeBillsRequest;
import com.adf.response.CoinsResponse;
import com.adf.response.ExchangeMachineResponse;
import com.adf.service.ExchangeMachineService;

@RestController
public class ExchangeMachineController {

	@Autowired
	private ExchangeMachineService exchangeMachineService;
	
	@RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        
		return "Hello World";
    }


	@PostMapping("/exhcangelist")
	public  ResponseEntity<ExchangeMachineResponse> billsToExchange(@RequestBody ExchangeBillsRequest exchangeBillsRequest) throws ExchangeMachineException {
		
		List<BillToExchange> lstBillToExchange = exchangeBillsRequest.getLstBillsToExchange();
		List<CoinsResponse> lstCoinsResponse = new ArrayList<CoinsResponse>();
		for(BillToExchange billToExchange : lstBillToExchange) {
			System.out.println("Amount of bill : " + billToExchange.getBillQuantity() + " With Denomination : " + billToExchange.getBillAmount() );
		}

		lstCoinsResponse = exchangeMachineService.billsToCoinstRef(lstBillToExchange);
			
		for(CoinsResponse coinsResponse : lstCoinsResponse) {
			System.out.println("Coins Response : " + coinsResponse.getCoinQuantity() + ", " + ", Coin Denomination : " + coinsResponse.getCoinDenomination() + ", " + coinsResponse.getCoinAmount());
		}
		
		List<String> lstString = new ArrayList<String>();
		return new ResponseEntity<ExchangeMachineResponse>(generateMachineMessage("", lstCoinsResponse), HttpStatus.OK);
		
	}


	
	private ExchangeMachineResponse generateMachineMessage(String message, java.util.List<?> list) {
		ExchangeMachineResponse exchangeMachineResponse = new ExchangeMachineResponse();
		exchangeMachineResponse.setStatus("");
		exchangeMachineResponse.setStatusCode(HttpStatus.OK.value());
		exchangeMachineResponse.setMessage(message);
		exchangeMachineResponse.setResults(list);

		return exchangeMachineResponse;
	}

	
	

}
