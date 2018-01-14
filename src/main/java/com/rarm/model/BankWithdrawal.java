package com.rarm.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BankWithdrawal extends BaseEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "accountCode", length = 100, nullable = false, unique = true)
	private String accountCode;

	@Column(name = "transactionNo", length = 100, nullable = false)
	private String transactionNo;

	@Column(name = "amount", length = 20)
	private BigDecimal amount;

	public String getAccountCode() {
		return accountCode;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	@Override
	public Long getId() {
		return id;
	}

	public String getTransactionNo() {
		return transactionNo;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	@Override
	public String toString() {
		return "BankWithdrawal [accountCode=" + accountCode + ", transactionNo=" + transactionNo + ", amount=" + amount
				+ "]";
	}

}
