package com.example.web.entity;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemList {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long num;
	
	@Column(nullable=false,unique=true)
	private String itemName;
	
	@Column(nullable=false)
	private int itemPrice;
	
	@Column(nullable=false)
	private int itemCount;
	private String itemCategory;
	private String itemBrand;
	
	@Column(nullable=false)
	private String itemCountry;
	
	@Column(nullable=false)
	private String itemTaste;
	
	@Column(nullable=false)
	private String itemType;
	
	@Column(nullable=false)
	private String itemImg;
}
