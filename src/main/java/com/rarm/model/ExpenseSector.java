package com.rarm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "expenseSectors")
public class ExpenseSector extends BaseEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "sectorName", length = 100, nullable = false)
	private String sectorName;

	@Column(name = "description")
	@Type(type = "text")
	private String description;
	
	public ExpenseSector(){
		
	}

	public ExpenseSector(String sectorName, String description) {
		this.sectorName = sectorName;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public Long getId() {
		return id;
	}

	public String getSectorName() {
		return sectorName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setSectorName(String sectorName) {
		this.sectorName = sectorName;
	}

	@Override
	public String toString() {
		return "ExpenseSector [sectorName=" + sectorName + ", description=" + description + "]";
	}

}
