package com.rarm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "companies")
public class Company extends BaseEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@Column(name = "codeNumber", length = 100, nullable = false, unique = true)
	private String codeNumber;

	@Column(name = "content")
	@Type(type = "text")
	private String address;

	@Column(name = "mobile", length = 50)
	private String mobile;

	@Column(name = "category", length = 100, nullable = false)
	private String category;

	public String getAddress() {
		return address;
	}

	public String getCategory() {
		return category;
	}

	public String getCodeNumber() {
		return codeNumber;
	}
	@Override
	public Long getId() {
		return id;
	}

	public String getMobile() {
		return mobile;
	}

	public String getName() {
		return name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCodeNumber(String codeNumber) {
		this.codeNumber = codeNumber;
	}


	public void setId(long id) {
		this.id = id;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", codeNumber=" + codeNumber + ", address="
				+ address + ", mobile=" + mobile + ", category=" + category + "]";
	}

}
