package com.example.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.web.entity.MemberCart;

@Repository
public interface MemberCartRepository extends JpaRepository<MemberCart, Long>{
	
	MemberCart findByUserId(String userId);
}
