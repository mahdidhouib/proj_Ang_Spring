package com.example.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entities.Member_Pub_Id;
import com.example.demo.Entities.Member_Publication;

public interface MemberPubRepository extends
JpaRepository<Member_Publication, Member_Pub_Id> {
@Query("select m from Membre_Publication m where m.id.auteur_id=:x")
List<Member_Publication> findpubId(@Param ("x") Long autId);
}