package com.example.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long no;
	
	@Column(nullable=false)
	private Long userNum;
	
	@Column(nullable=false)
	private Long itemNum;
	
	@Column(nullable=false)
	private String itemName;
	
	@Column(nullable=false)
	private int price;
	
	@Column(nullable=false)
	private int quantity;

	@ManyToOne
	@JoinColumn(name="memberNum")
	private MemberCart memberCart;

}
