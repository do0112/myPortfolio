package com.example.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.web.entity.ItemList;
import com.example.web.repository.ItemRepository;

@Service
public class ItemListService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public Page<ItemList> itemListAll(int currentPage){
		int pageSize = 8;
		Pageable pageable = PageRequest.of(currentPage,pageSize);
		Page<ItemList> list = itemRepository.findAll(pageable);		
		return list;
	}
	
	public Page<ItemList> itemListCategory(int currentPage,String itemCategory){
		int pageSize = 8;
		Pageable pageable = PageRequest.of(currentPage,pageSize);
		Page<ItemList> list = itemRepository.findByItemCategory(pageable, itemCategory);		
		return list;
	}

	public Page<ItemList> itemListCountry(int currentPage,String country) {
		int pageSize = 4;
		Pageable pageable = PageRequest.of(currentPage,pageSize);
		Page<ItemList> list = itemRepository.findByItemCountry(pageable, country);		
		return list;
	}
	
	public Page<ItemList> itemListBrand(int currentPage,String brand) {
		int pageSize = 8;
		Pageable pageable = PageRequest.of(currentPage,pageSize);
		Page<ItemList> list = itemRepository.findByItemBrand(pageable, brand);		
		return list;
	}
	
	public Page<ItemList> itemListTaste(int currentPage,String taste) {
		int pageSize = 8;
		if(currentPage<0) {
			currentPage = 0;
		}
		Pageable pageable = PageRequest.of(currentPage,pageSize);
		Page<ItemList> list = itemRepository.findByItemTaste(pageable, taste);		
		return list;
	}
	
	public Page<ItemList> itemListType(int currentPage,String type) {
		int pageSize = 8;
		Pageable pageable = PageRequest.of(currentPage,pageSize);
		Page<ItemList> list = itemRepository.findByItemType(pageable, type);		
		return list;
	}

	public ItemList numCheck(Long num) {
		ItemList list = itemRepository.findById(num).orElse(null);
		return list;
	}
	
	public Page<ItemList> searchItem(int currentPage,String keyword) {
		int pageSize = 16;
		Pageable pageable = PageRequest.of(currentPage,pageSize);
		Page<ItemList> list = itemRepository.findByItemNameContainingOrItemBrandContaining(pageable, keyword,keyword);
		return list;
	}
}
