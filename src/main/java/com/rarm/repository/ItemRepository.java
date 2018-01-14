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
	

}
