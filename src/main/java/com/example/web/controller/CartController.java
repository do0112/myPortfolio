package com.example.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.web.entity.Cart;
import com.example.web.message.Message;
import com.example.web.service.CartService;
import com.example.web.service.MemberCartService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class CartController {
	
	@Autowired
	private CartService service;
	@Autowired
	private MemberCartService memberCartService;
	
	@GetMapping("/item/cart")
	public String cart(Model model) {
		if(MemberController.loginUser == null) {
			model.addAttribute("message", Message.builder().message("로그인 후 사용하세요!").uri("/member/login").build()); 
		}else {
			Long userNum = memberCartService.findUserNum(MemberController.loginUser);
			List<Cart> cart = service.findUserNum(userNum);
			int totalPrice = 0;
			for(Cart items : cart) {
				totalPrice += items.getPrice() * items.getQuantity();
			}
			model.addAttribute("cartList", cart);
			model.addAttribute("userNum", userNum);
			model.addAttribute("totalPrice", totalPrice);
			model.addAttribute("loginMember", MemberController.loginUser);
			return "items/cart";
		}
		return "layouts/message";
		
	}
	
	@GetMapping("/item/cartAllDel")
	public String cartAllDel(Model model) {
		Long userNum = memberCartService.findUserNum(MemberController.loginUser);
		
		service.cartAllDel(userNum);
		model.addAttribute("loginMember", MemberController.loginUser);
		model.addAttribute("message", Message.builder().message("장바구니를 비웠습니다!").uri("/item/cart").build());
		return "layouts/message";
	}
	
	@GetMapping("/item/cartDel")
	public String cartDel(@RequestParam Long no,Model model) {
		service.cartOneDel(no);
		model.addAttribute("loginMember", MemberController.loginUser);
		return "redirect:/item/cart";
	}
	
	@PostMapping("/item/cartUpdate")
	public String cartUpdate(@RequestParam int quantity,@RequestParam Long no,Model model) {
		if(quantity < 1) {
			model.addAttribute("message", Message.builder().message("상품 수량을 다시 확인해주세요!").uri("/item/cart").build());
		}else {
			service.cartUpdate(no,quantity);
			model.addAttribute("message", Message.builder().message("수정되었습니다!").uri("/item/cart").build());
		}
		
		return "layouts/message";
	}
	
	
	
	@PostMapping("/item/itemDetail/{num}")
	public String toCart(@PathVariable Long num,Cart cartList,Model model) {
		if(cartList.getUserNum() == 0) {
			model.addAttribute("message", Message.builder().message("로그인 후 사용해주세요!").uri("/member/login").build());

		}else {
			service.saveItems(cartList);
			model.addAttribute("loginMember", MemberController.loginUser);
			model.addAttribute("message", Message.builder().message("장바구니에 추가했습니다!").uri("/item/cart").build());
		}
		
		return "layouts/message";
	}
	

}
