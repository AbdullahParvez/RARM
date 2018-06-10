package com.rarm.model;

import java.math.BigDecimal;

public class RecordsProduction {
	private String itemName;
	private BigDecimal quantity;
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

}
