package com.example.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.web.dto.ItemDTO;
import com.example.web.entity.Cart;
import com.example.web.entity.ItemList;
import com.example.web.message.Message;
import com.example.web.service.ItemListService;
import com.example.web.service.MemberCartService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class ItemController {
	
	@Autowired
	private ItemListService itemListService;
	@Autowired
	private MemberCartService memberCartService;

	@GetMapping("/item/itemList/{category}")
	public String itemListAll(@RequestParam(required=false) String search,@RequestParam(defaultValue="0") int page,@PathVariable String category,Model model) {
		log.info("cate : {}",category);
		Page<ItemList> items = null;
		if(category.equals("all")) {
			items = itemListService.itemListAll(page);
			model.addAttribute("title", "전체 라면");
		}else if(category.equals("korea")){
			items = itemListService.itemListCountry(page, category);
			model.addAttribute("title", "국내 라면");
		}else if(category.equals("japan")) {
			items = itemListService.itemListCountry(page, category);
			model.addAttribute("title", "일본 라면");
		}else if(category.equals("china")) {
			items = itemListService.itemListCountry(page, category);
			model.addAttribute("title", "중국 라면");
		}else if(category.equals("vietnam")) {
			items = itemListService.itemListCountry(page, category);
			model.addAttribute("title", "베트남 라면");
		}else if(category.equals("thailand")) {
			items = itemListService.itemListCountry(page, category);
			model.addAttribute("title", "태국 라면");
		}else if(category.equals("new")) {
			items = itemListService.itemListCategory(page, category);
			model.addAttribute("title", "신제품");
		}else if(category.equals("best")) {
			items = itemListService.itemListCategory(page, category);
			model.addAttribute("title", "베스트");
		}else if(category.equals("삼양")) {
			items = itemListService.itemListBrand(page, category);
			model.addAttribute("title", "삼양 라면");
		}else if(category.equals("팔도")) {
			items = itemListService.itemListBrand(page, category);
			model.addAttribute("title", "팔도 라면");
		}else if(category.equals("농심")) {
			items = itemListService.itemListBrand(page, category);
			model.addAttribute("title", "농심 라면");
		}else if(category.equals("spicy")) {
			items = itemListService.itemListTaste(page, category);
			model.addAttribute("title", "베리베리 매워요!");
		}else if(category.equals("mild")) {
			items = itemListService.itemListTaste(page, category);
			model.addAttribute("title", "아주 순해요~");
		}else if(category.equals("bag")) {
			items = itemListService.itemListType(page, category);
			model.addAttribute("title", "봉지 라면");
		}else if(category.equals("cup")) {
			items = itemListService.itemListType(page, category);
			model.addAttribute("title", "컵 라면");
		}else if(category.equals("search")) {
			items = itemListService.searchItem(page, search);
			if(items.getContent().isEmpty()) {
				
				model.addAttribute("message", Message.builder().message("상품명 또는 브랜드를 검색하세요!").uri("/").build());
				return "layouts/message";
			}
			model.addAttribute("search", search);
			model.addAttribute("title", null);
		}
		
		model.addAttribute("loginMember", MemberController.loginUser);
		model.addAttribute("list", items.getContent());
		model.addAttribute("page", items);
		return "items/itemList";

	}
	
	@GetMapping("/item/itemDetail/{num}")
	public String itemDetail(@PathVariable Long num,Model model) {
		ItemList itemList = itemListService.numCheck(num);
		if(MemberController.loginUser != null) {
			Long userNum = memberCartService.findUserNum(MemberController.loginUser);
			model.addAttribute("userNum", userNum);
		}else {
			model.addAttribute("userNum", 0);
		}
		
		model.addAttribute("itemList", itemList);
		model.addAttribute("loginMember", MemberController.loginUser);
		model.addAttribute("cartList", new Cart());
		return "items/itemDetail";
	}

	
}
