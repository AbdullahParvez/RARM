package com.rarm.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.rarm.model.Item;

public interface ItemService {
	
	Item save(Item item);
	
	List<String>findItemNamebyCategory(@Param("category")String category);

}
