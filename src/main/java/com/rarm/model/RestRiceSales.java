package com.rarm.model;

import java.util.List;

public class RestRiceSales {

	private String memoNo;
	private String companyCode;
	private String date;
	private List<RecordsRiceSales> records;

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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<RecordsRiceSales> getRecords() {
		return records;
	}

	public void setRecords(List<RecordsRiceSales> records) {
		this.records = records;
	}

	@Override
	public String toString() {
		return "RestRiceSales [memoNo=" + memoNo + ", companyCode=" + companyCode + ", date=" + date + ", records="
				+ records + "]";
	}
	
	

}
