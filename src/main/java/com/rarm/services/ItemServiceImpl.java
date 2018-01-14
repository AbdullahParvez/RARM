package com.rarm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rarm.model.Item;
import com.rarm.repository.ItemRepository;

@Service("ItemService")
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemRepository itemRepository;

	@Transactional
	@Override
	public Item save(Item item) {		
		return itemRepository.save(item);
	}

	@Override
	public List<String> findItemNamebyCategory(String category) {
		return itemRepository.findItemNamebyCategory(category);
	}


}