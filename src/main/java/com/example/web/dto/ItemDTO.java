package com.example.web.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.web.entity.ItemList;


public class ItemDTO {
	
	private Long num;
	private String itemName;
	private int itemPrice;
	private int itemCount;
	private String itemCategory;
	private String itemBrand;
	private String itemCountry;
	private String itemTaste;
	private String itemType;
	private String itemImg;
	
	public ItemList toEntity() {
		return new ItemList(num,itemName,itemPrice,itemCount,itemCategory,itemBrand,itemCountry,itemTaste,itemType,itemImg);
	}
}
