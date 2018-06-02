package com.rarm.model;

import java.math.BigDecimal;

public class RecordsExpense {

	private String expenseSector;
	private BigDecimal amount;
	private String description;

	public BigDecimal getAmount() {
		return amount;
	}

	public String getDescription() {
		return description;
	}

	public String getExpenseSector() {
		return expenseSector;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setExpenseSector(String expenseSector) {
		this.expenseSector = expenseSector;
	}

}
