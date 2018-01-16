package com.rarm.model;

import java.util.List;

public class RestPurchase {
	
	private String memoNo;

	private String companyCode;
	
	private List<Records> records;

	public String getMemoNo() {
		return memoNo;
	}

	public void setMemoNo(String memoNo) {
		this.memoNo = memoNo;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public List<Records> getRecords() {
		return records;
	}

	public void setRecords(List<Records> records) {
		this.records = records;
	}

	@Override
	public String toString() {
		return "RestSales [memoNo=" + memoNo + ", companyCode=" + companyCode + ", records=" + records + "]";
	}
	

}
