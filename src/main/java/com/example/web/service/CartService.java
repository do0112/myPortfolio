package com.example.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.web.entity.Cart;
import com.example.web.repository.CartRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CartService {
	
	@Autowired
	private CartRepository repository;
	
	public void saveItems(Cart dto) {
		
		repository.save(dto);
	}
	
	public List<Cart> findUserNum(Long userNum) {
		List<Cart> cart = repository.findByUserNum(userNum);
		return cart;
	}
	
	public void cartAllDel(Long userNum) {
		List<Cart> cart = repository.findByMemberCart_UserNum(userNum);
		
		List<Long> idList = new ArrayList<>();
		for(Cart cartList : cart) {
			idList.add(cartList.getNo());
		}
		repository.deleteAllById(idList);
		
	}

	public void cartOneDel(Long num) {
		Cart cart = repository.findById(num).orElse(null);
		repository.delete(cart);
	}
	

	public void cartUpdate(Long num,int quantity) {
		Cart cart = repository.findById(num).orElse(null);
		cart.setQuantity(quantity);
		repository.save(cart);
	}
}
