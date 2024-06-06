package com.example.web.dto;

import java.time.LocalDateTime;

import com.example.web.entity.Member;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@RequiredArgsConstructor
@Builder
public class MemberDTO {
	
	private Long no;
	
	private String userId;
	
    private String userPw; 
	@NonNull
    private String userName; 
	@NonNull
    private String mail; 
	@NonNull
    private String phone; 
	@NonNull
    private String address;
	@NonNull
    private LocalDateTime enrollDate;
	@NonNull
    private String mbti;
    
    public Member toEntity() {
    	return new Member(no,userId,userPw,userName,mail,phone,address,enrollDate,mbti);
    }
}
