package com.example.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.web.entity.Member;
import com.example.web.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class JoinRestController {

	@Autowired
	private MemberService service;
	
	@PostMapping("/member/duplicatecheck")
	public ResponseEntity<String> duplicateCheck(@RequestBody Map<String, String> body) {
		log.info("body : {}",body);
		
		String userId = body.get("userid");
		Member member = service.idCheck(userId);
		
		if(member != null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\" : \"#id_error\"}");
		}else {
			return ResponseEntity.ok("{\"message\" : \"#id_pass\"}");
		}
	}
	
	
}
