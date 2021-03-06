package com.rarm.model;

import java.math.BigDecimal;

public class Records {

	private String itemName;
	private BigDecimal quantity;
	private BigDecimal unitPrice;

	public String getItemName() {
		return itemName;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

}
