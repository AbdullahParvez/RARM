package com.rarm.model;

import java.util.List;

public class RestProduction {

	private String date;
	private List<RecordsProduction> records;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<RecordsProduction> getRecords() {
		return records;
	}

	public void setRecords(List<RecordsProduction> records) {
		this.records = records;
	}

	@Override
	public String toString() {
		return "RestProduction [date=" + date + ", records=" + records + "]";
	}


}
