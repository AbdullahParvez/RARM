package com.rarm.model;

import java.math.BigDecimal;

import javax.persistence.Column;

public class Records {

	@Column(name = "itemName", length = 100, nullable = false)
	private String itemName;

	@Column(name = "quantity", length = 20, nullable = false)
	private BigDecimal quantity;

	@Column(name = "unitPrice", length = 20, nullable = false)
	private BigDecimal unitPrice;

	@Column(name = "cash", length = 20, nullable = false)
	private BigDecimal cash;

	@Column(name = "due", length = 20, nullable = false)
	private BigDecimal due;

	public BigDecimal getCash() {
		return cash;
	}

	public BigDecimal getDue() {
		return due;
	}

	public String getItemName() {
		return itemName;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setCash(BigDecimal cash) {
		this.cash = cash;
	}

	public void setDue(BigDecimal due) {
		this.due = due;
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
