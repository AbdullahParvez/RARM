package com.rarm.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

public class Capital extends BaseEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "amount", length = 20)
	private BigDecimal amount;

	@Column(name = "description")
	@Type(type = "text")
	private String description;

	public BigDecimal getAmount() {
		return amount;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Capital [amount=" + amount + ", description=" + description + "]";
	}

}
