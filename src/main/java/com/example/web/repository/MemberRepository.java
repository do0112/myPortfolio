package com.example.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.web.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
	
	Member findByUserId(String userId); //중복확인
	Member findByPhone(String phone);
	Member findByUserName(String userName);
	
}
