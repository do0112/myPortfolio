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
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
public class Member {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long no;
	
	@NonNull
	@Column(nullable=false,unique=true)
	private String userId;
	
	@NonNull
	@Column(nullable=false)
    private String userPw; 
	
	@NonNull
	@Column(nullable=false)
    private String userName; 
	
	@NonNull
	@Column(nullable=false,unique=true)
    private String mail; 
	
	@NonNull
	@Column(nullable=false,unique=true)
    private String phone; 
	
	@NonNull
	@Column(nullable=false)
    private String address;
	
	@NonNull
	@Column(nullable=false)
    private LocalDateTime enrollDate;
	
    private String mbti; 
}
