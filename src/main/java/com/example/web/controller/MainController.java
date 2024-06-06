package com.example.web.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.web.entity.ItemList;
import com.example.web.entity.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MainController {
	
	
	@GetMapping("/")
	public String index(@RequestParam(required=false) String loginMember,Model model) {
		model.addAttribute("loginMember", MemberController.loginUser);
		return "index";
	}
	
	@GetMapping("/notice")
	public String notice(Model model) {
		model.addAttribute("loginMember", MemberController.loginUser);
		return "nav/notice";
	}
	
	@GetMapping("/faq")
	public String faq(@RequestParam(required=false) String loginMember,Model model) {
		model.addAttribute("loginMember", MemberController.loginUser);
		return "nav/faq";
	}
	
	
	

}
