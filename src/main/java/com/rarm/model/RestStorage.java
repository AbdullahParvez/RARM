package com.rarm.model;

import java.util.List;

public class RestStorage {

	private String date;
	private List<RecordsStorage> records;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<RecordsStorage> getRecords() {
		return records;
	}

	public void setRecords(List<RecordsStorage> records) {
		this.records = records;
	}

	@Override
	public String toString() {
		return "RestProduction [date=" + date + ", records=" + records + "]";
	}


}
