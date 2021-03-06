package com.rarm.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rarm.model.Item;

@Repository("itemRepository")
public interface ItemRepository extends JpaRepository<Item, Long>{
	
	@Query("Select i.itemName from Item i where i.category=:category")
	List<String>findItemNamebyCategory(@Param("category")String category);
	
	@Query("Select i.itemName from Item i where i.category=:category1 or i.category=:category2")
	List<String>findProductionItem(@Param("category1")String category1, @Param("category2")String category2);
	
}
