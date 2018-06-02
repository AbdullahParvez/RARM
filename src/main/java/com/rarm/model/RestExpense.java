package com.rarm.model;

import java.util.List;

public class RestExpense {
	
	private String memoNo;
	private List<RecordsExpense> recordsExpense;
	
	public String getMemoNo() {
		return memoNo;
	}
	public void setMemoNo(String memoNo) {
		this.memoNo = memoNo;
	}
	public List<RecordsExpense> getRecordsExpense() {
		return recordsExpense;
	}
	public void setRecordsExpense(List<RecordsExpense> recordsExpense) {
		this.recordsExpense = recordsExpense;
	}
	@Override
	public String toString() {
		return "RestExpense [memoNo=" + memoNo + ", recordsExpense=" + recordsExpense + "]";
	}
	
	
	

}
