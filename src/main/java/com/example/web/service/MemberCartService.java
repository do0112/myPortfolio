package com.example.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.web.entity.MemberCart;
import com.example.web.repository.MemberCartRepository;

@Service
public class MemberCartService {
	
	@Autowired
	MemberCartRepository memberCartRepository;
	
	public void memberCartInsert(MemberCart memberCart) {
		
		memberCartRepository.save(memberCart);
	}
	
	public Long findUserNum(String userId) {
		return memberCartRepository.findByUserId(userId).getUserNum();
	}
	
	public void memberCartDel(Long userNum) {
		
		memberCartRepository.deleteById(userNum);
	}
	
}
