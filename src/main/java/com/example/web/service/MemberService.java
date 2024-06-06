package com.example.web.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.web.dto.MemberDTO;
import com.example.web.entity.Member;
import com.example.web.entity.MemberCart;
import com.example.web.repository.MemberCartRepository;
import com.example.web.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberService {
	
	@Autowired
	private MemberRepository repository;
	
	
	public Member userLogin(String id,String pw) {
		 Member member = repository.findByUserId(id);
		 
		 if(member != null) {
			 if(member.getUserPw().equals(pw)) {
				 return member;
			 }
			 else {
				 return null;
			 }
		 }
		 
		 return member;
	}
	
	public void memberJoin(Member member) {
		LocalDateTime date = LocalDateTime.now();
		member.setEnrollDate(date);
		repository.save(member);
		
	}
	
	public Member idCheck(String userId) {
		
		return repository.findByUserId(userId);
	}
	
	public String searchId(String name,String phone) {
		Member member = repository.findByPhone(phone);
		
		if(member != null) {
			 if(member.getUserName().equals(name)) {
				 return member.getUserId();
			 }
			 else {
				 return null;
			 }
		 }
		
		return null;
	}
	
	public void passwordReset(String newPw,String id) {
		Member member = repository.findByUserId(id);
		log.info("member : {}",member);
		member.setUserPw(newPw);
		repository.save(member);
	}
	
	public void memberUpdate(MemberDTO member,String userId) {
		Member user = idCheck(userId);
		user.setNo(user.getNo());
		user.setUserName(member.getUserName());
		user.setMail(member.getMail());
		user.setPhone(member.getPhone());
		user.setAddress(member.getAddress());
		user.setMbti(member.getMbti());
		repository.save(user);
	}
	
	public Member nameCheck(String name) {
		Member member = repository.findByUserName(name);
		return member;
	}

	public void memberDel(String loginMember) {
		Member member = idCheck(loginMember);
		repository.delete(member);
		
	}
	
	
	
}
