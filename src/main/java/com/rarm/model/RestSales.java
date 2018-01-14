package com.rarm.model;

import java.util.List;


public class RestSales {
	
	private String memoNo;

	private String customerCode;
	
	private List<Records> records;

	public String getMemoNo() {
		return memoNo;
	}

	public void setMemoNo(String memoNo) {
		this.memoNo = memoNo;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public List<Records> getRecords() {
		return records;
	}

	public void setRecords(List<Records> records) {
		this.records = records;
	}

	@Override
	public String toString() {
		return "RestSales [memoNo=" + memoNo + ", customerCode=" + customerCode + ", records=" + records + "]";
	}
	
	

}
