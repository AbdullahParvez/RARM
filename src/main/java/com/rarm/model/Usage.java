package com.rarm.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usageItem")
public class Usage extends BaseEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "itemName", length = 100, nullable = false)
	private String itemName;

	@Column(name = "quantity", length = 20, nullable = false)
	private BigDecimal quantity;

	public Usage() {

	}

	public Usage(String itemName, BigDecimal quantity) {
		super();
		this.itemName = itemName;
		this.quantity = quantity;
	}

	@Override
	public Long getId() {
		return id;
	}

	public String getItemName() {
		return itemName;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Usage [itemName=" + itemName + ", quantity=" + quantity + "]";
	}

}
