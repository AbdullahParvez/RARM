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
@Table(name = "paddyPurchases")
public class PaddyPurchase extends BaseEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "memoNo", length = 100, nullable = false, unique = true)
	private String memoNo;

	@Column(name = "companyCode", length = 100, nullable = false)
	private String companyCode;
	
	@Column(name = "itemName", length = 100, nullable = false)
	private String itemName = "Paddy";

	@Column(name = "date", length = 100, nullable = false)
	private Date date;

	@Column(name = "quantitySack", length = 20, nullable = false)
	private BigDecimal quantitySack;

	@Column(name = "quantityKG", length = 20, nullable = false)
	private BigDecimal quantityKG;

	@Column(name = "unitPricePerMon", length = 20, nullable = false)
	private BigDecimal unitPricePerMon;

	@Column(name = "totalSackPrice", length = 20, nullable = false)
	private BigDecimal totalSackPrice;

	@Transient
	private BigDecimal totalPrice;

	@Transient
	private Date insertDate;

	public PaddyPurchase() {

	}

	public PaddyPurchase(String memoNo, String companyCode, Date date, BigDecimal quantitySack, BigDecimal quantityKG,
			BigDecimal unitPricePerMon, BigDecimal totalSackPrice) {
		super();
		this.memoNo = memoNo;
		this.companyCode = companyCode;
		this.date = date;
		this.quantitySack = quantitySack;
		this.quantityKG = quantityKG;
		this.unitPricePerMon = unitPricePerMon;
		this.totalSackPrice = totalSackPrice;
	}

	public PaddyPurchase(String memoNo, String companyCode, Date date, BigDecimal quantitySack, BigDecimal quantityKG,
			BigDecimal unitPricePerMon, BigDecimal totalSackPrice, BigDecimal totalPrice, Date insertDate) {
		super();
		this.memoNo = memoNo;
		this.companyCode = companyCode;
		this.date = date;
		this.quantitySack = quantitySack;
		this.quantityKG = quantityKG;
		this.unitPricePerMon = unitPricePerMon;
		this.totalSackPrice = totalSackPrice;
		this.totalPrice = totalPrice;
		this.insertDate = insertDate;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
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

	public String getMemoNo() {
		return memoNo;
	}

	public BigDecimal getQuantityKG() {
		return quantityKG;
	}

	public BigDecimal getQuantitySack() {
		return quantitySack;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public BigDecimal getTotalSackPrice() {
		return totalSackPrice;
	}

	public BigDecimal getUnitPricePerMon() {
		return unitPricePerMon;
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

	public void setMemoNo(String memoNo) {
		this.memoNo = memoNo;
	}

	public void setQuantityKG(BigDecimal quantityKG) {
		this.quantityKG = quantityKG;
	}

	public void setQuantitySack(BigDecimal quantitySack) {
		this.quantitySack = quantitySack;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setTotalSackPrice(BigDecimal totalSackPrice) {
		this.totalSackPrice = totalSackPrice;
	}

	public void setUnitPricePerMon(BigDecimal unitPricePerMon) {
		this.unitPricePerMon = unitPricePerMon;
	}

	@Override
	public String toString() {
		return "Paddy [memoNo=" + memoNo + ", companyCode=" + companyCode + ", date=" + date + ", quantitySack="
				+ quantitySack + ", quantityKG=" + quantityKG + ", unitPricePerMon=" + unitPricePerMon
				+ ", totalSackPrice=" + totalSackPrice + "]";
	}

}
