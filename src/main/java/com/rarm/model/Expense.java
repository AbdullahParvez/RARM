package com.rarm.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "expenses")
public class Expense extends BaseEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "memoNo", length = 100, nullable = false)
	private String memoNo;

	@Column(name = "expenseSector", length = 100, nullable = false)
	private String expenseSector;

	@Column(name = "amount", length = 20, nullable = false)
	private BigDecimal amount;

	@Column(name = "description")
	@Type(type = "text")
	private String description;

	public Expense() {

	}

	public Expense(String memoNo, String expenseSector, BigDecimal amount, String description) {
		super();
		this.memoNo = memoNo;
		this.expenseSector = expenseSector;
		this.amount = amount;
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public String getDescription() {
		return description;
	}

	public String getExpenseSector() {
		return expenseSector;
	}

	@Override
	public Long getId() {
		return id;
	}

	public String getMemoNo() {
		return memoNo;
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

	public void setId(Long id) {
		this.id = id;
	}

	public void setMemoNo(String memoNo) {
		this.memoNo = memoNo;
	}

	@Override
	public String toString() {
		return "Expense [memoNo=" + memoNo + ", expenseSector=" + expenseSector + ", amount=" + amount
				+ ", description=" + description + "]";
	}

}
