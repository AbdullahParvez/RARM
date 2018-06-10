package com.rarm.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "production")
public class Production extends BaseEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "itemName", length = 100, nullable = false)
	private String itemName;

	@Column(name = "quantity", length = 20, nullable = false)
	private BigDecimal quantity;

	@Column(name = "date", length = 100, nullable = false)
	private Date date;

	public Production() {

	}

	public Production(String itemName, BigDecimal quantity, Date date) {
		super();
		this.itemName = itemName;
		this.quantity = quantity;
		this.date = date;
	}

	public Date getDate() {
		return date;
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

	public void setDate(Date date) {
		this.date = date;
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
		return "Production [itemName=" + itemName + ", quantity=" + quantity + "]";
	}

}
