package com.example.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	Member findByCin(String cin);
	List<Member>findByNomStartingWith(String caractere);
	Member findByEmail(String email);

}
