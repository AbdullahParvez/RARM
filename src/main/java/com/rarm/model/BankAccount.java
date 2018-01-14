package com.rarm.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BankAccount extends BaseEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "bankName", length = 100, nullable = false)
	private String bankName;

	@Column(name = "accountNo", length = 100, nullable = false)
	private String accountNo;

	@Column(name = "accountCode", length = 100, nullable = false, unique = true)
	private String accountCode;

	@Column(name = "bankCharge", length = 20)
	private BigDecimal bankCharge;

	@Column(name = "bankInterest", length = 20)
	private BigDecimal bankInterest;

	public String getAccountCode() {
		return accountCode;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public BigDecimal getBankCharge() {
		return bankCharge;
	}

	public BigDecimal getBankInterest() {
		return bankInterest;
	}

	public String getBankName() {
		return bankName;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public void setBankCharge(BigDecimal bankCharge) {
		this.bankCharge = bankCharge;
	}

	public void setBankInterest(BigDecimal bankInterest) {
		this.bankInterest = bankInterest;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "BankAccount [bankName=" + bankName + ", accountNo=" + accountNo + ", accountCode=" + accountCode
				+ ", bankCharge=" + bankCharge + ", bankInterest=" + bankInterest + "]";
	}

}
