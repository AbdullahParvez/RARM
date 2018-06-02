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
@Table(name = "sales")
public class Sales extends BaseEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "memoNo", length = 100, nullable = false)
	private String memoNo;

	@Column(name = "customerCode", length = 100, nullable = false)
	private String customerCode;

	@Column(name = "date", length = 100, nullable = false)
	private Date date;

	@Column(name = "itemName", length = 100, nullable = false)
	private String itemName;

	@Column(name = "quantity", length = 20, nullable = false)
	private BigDecimal quantity;

	@Column(name = "unitPrice", length = 20, nullable = false)
	private BigDecimal unitPrice;

	public Sales() {

	}

	public Sales(String memoNo, String customerCode, Date date, String itemName, BigDecimal quantity,
			BigDecimal unitPrice) {
		super();
		this.memoNo = memoNo;
		this.customerCode = customerCode;
		this.date = date;
		this.itemName = itemName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	@Override
	public Long getId() {
		return id;
	}

	public String getItemName() {
		return itemName;
	}

	public String getMemoNo() {
		return memoNo;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setMemoNo(String memoNo) {
		this.memoNo = memoNo;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "Sales [memoNo=" + memoNo + ", customerCode=" + customerCode + ", date=" + date + ", itemName="
				+ itemName + ", quantity=" + quantity + ", unitPrice=" + unitPrice + "]";
	}

}
