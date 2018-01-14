package com.rarm.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class ItemValidation {
	
	@NotEmpty
	private String itemName;
	
	private String category;
	
	private String description;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	} 

}
