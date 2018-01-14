package com.rarm.model;

import java.math.BigDecimal;
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
	
	public Sales(){
		
	}

	public Sales(String memoNo, String customerCode, String itemName, BigDecimal quantity, BigDecimal unitPrice,
			BigDecimal cash, BigDecimal due) {
		super();
		this.memoNo = memoNo;
		this.customerCode = customerCode;
		this.itemName = itemName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.cash = cash;
		this.due = due;
	}

	public BigDecimal getCash() {
		return cash;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public BigDecimal getDue() {
		return due;
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

	public void setCash(BigDecimal cash) {
		this.cash = cash;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public void setDue(BigDecimal due) {
		this.due = due;
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
		return "Sales [memoNo=" + memoNo + ", customerCode=" + customerCode + ", itemName=" + itemName + ", quantity="
				+ quantity + ", unitPrice=" + unitPrice + ", cash=" + cash + ", due=" + due + "]";
	}

}
