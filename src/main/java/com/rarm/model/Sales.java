package com.rarm.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "sales")
public class Sales extends BaseEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "memoNo", length = 100, nullable = false)
	private String memoNo;

	@Column(name = "companyCode", length = 100, nullable = false)
	private String companyCode;

	@Column(name = "date", length = 100, nullable = false)
	private Date date;

	@Column(name = "itemName", length = 100, nullable = false)
	private String itemName;

	@Column(name = "quantity", length = 20, nullable = false)
	private BigDecimal quantity;

	@Column(name = "unitPrice", length = 20, nullable = false)
	private BigDecimal unitPrice;

	@Transient
	private BigDecimal totalPrice;

	@Transient
	private Date insertDate;

	public Sales() {

	}

	public Sales(String memoNo, String companyCode, Date date, String itemName, BigDecimal quantity,
			BigDecimal unitPrice) {
		super();
		this.memoNo = memoNo;
		this.companyCode = companyCode;
		this.date = date;
		this.itemName = itemName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public Sales(String memoNo, String companyCode, Date date, String itemName, BigDecimal quantity,
			BigDecimal unitPrice, BigDecimal totalPrice, Date insertDate) {
		super();
		this.memoNo = memoNo;
		this.companyCode = companyCode;
		this.date = date;
		this.itemName = itemName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalPrice = totalPrice;
		this.insertDate = insertDate;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public Date getDate() {
		return date;
	}

	@Override
	public Long getId() {
		return id;
	}

	public Date getInsertDate() {
		return insertDate;
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

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
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

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "Sales [memoNo=" + memoNo + ", companyCode=" + companyCode + ", date=" + date + ", itemName=" + itemName
				+ ", quantity=" + quantity + ", unitPrice=" + unitPrice + "]";
	}

}
