package com.example.web.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class MemberCart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userNum;
	
	@NonNull
	@Column(nullable=false,unique=true)
	private String userId;
	
	@OneToMany(mappedBy = "memberCart")
	List<Cart> cart = new ArrayList<>();

}
