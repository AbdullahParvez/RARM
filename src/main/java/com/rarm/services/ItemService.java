package com.rarm.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.rarm.model.Item;

public interface ItemService {
	
	Item save(Item item);
	
	List<String>findItemNamebyCategory(@Param("category")String category);

	List<Item> findAllItems();
	
	List<String>findProductionItem(@Param("category")String category1, @Param("category")String category2);

}
