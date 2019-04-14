package com.adf.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.adf.model.BillToExchange;

public class ExchangeBillsRequest implements Serializable {

	private List<BillToExchange> lstBillsToExchange = new ArrayList<BillToExchange>();

	public List<BillToExchange> getLstBillsToExchange() {
		return lstBillsToExchange;
	}

	public void setLstBillsToExchange(List<BillToExchange> lstBillsToExchange) {
		this.lstBillsToExchange = lstBillsToExchange;
	}
			
	
}
