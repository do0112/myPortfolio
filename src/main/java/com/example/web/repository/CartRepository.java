package com.example.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.web.entity.Cart;
import com.example.web.entity.MemberCart;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long>{
	
	List<Cart> findByUserNum(Long userNum);
	List<Cart> findByMemberCart_UserNum(Long userNum);
	
}
