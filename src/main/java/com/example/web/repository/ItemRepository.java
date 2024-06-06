package com.example.web.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.web.entity.ItemList;

@Repository
public interface ItemRepository extends JpaRepository<ItemList, Long>{
	
	Page<ItemList> findAll(Pageable pageable);
	Page<ItemList> findByItemCategory(Pageable pageable,String itemCategory);
	Page<ItemList> findByItemBrand(Pageable pageable,String itemBrand);
	Page<ItemList> findByItemCountry(Pageable pageable,String itemCountry);
	Page<ItemList> findByItemTaste(Pageable pageable,String ItemTaste);
	Page<ItemList> findByItemType(Pageable pageable,String ItemType);
	Page<ItemList> findByItemNameContainingOrItemBrandContaining(Pageable pageable, String keyword,String Keyword);
}
