package com.rarm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "items")
public class Item extends BaseEntity<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "itemName", length = 100, nullable = false)
	private String itemName;

	@Column(name = "unitValue", length = 100, nullable = false)
	private String unitValue;

	@Column(name = "metricType", length = 100, nullable = false)
	private String metricType;

	@Column(name = "category", length = 100, nullable = false)
	private String category;

	@Column(name = "description")
	@Type(type = "text")
	private String description;
	
	public Item(){
		
	}

	public Item(String itemName, String unitValue, String metricType, String category, String description) {
		super();
		this.itemName = itemName;
		this.unitValue = unitValue;
		this.metricType = metricType;
		this.category = category;
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public Long getId() {
		return id;
	}

	public String getItemName() {
		return itemName;
	}

	public String getMetricType() {
		return metricType;
	}

	public String getUnitValue() {
		return unitValue;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setMetricType(String metricType) {
		this.metricType = metricType;
	}

	public void setUnitValue(String unitValue) {
		this.unitValue = unitValue;
	}

	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", unitValue=" + unitValue + ", metricType=" + metricType + ", category="
				+ category + ", description=" + description + "]";
	}

}
