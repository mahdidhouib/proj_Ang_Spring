package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.DAO.EnseignantChercheurRepository;
import com.example.demo.DAO.EtudiantRepository;
import com.example.demo.DAO.MemberPubRepository;
import com.example.demo.DAO.MemberRepository;
import com.example.demo.Entities.EnseignantChercheur;
import com.example.demo.Entities.Etudiant;
import com.example.demo.Entities.Member;
import com.example.demo.Entities.Member_Pub_Id;
import com.example.demo.Entities.Member_Publication;
import com.example.demo.beans.PublicationBean;
import com.example.demo.proxies.PublicationProxyService;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class MemberImp implements IMemberService {
	MemberRepository memberRepository;
	EtudiantRepository etudiantRepository;
	EnseignantChercheurRepository enseignantChercheurRepository;
	MemberPubRepository memberpubrepository;
	PublicationProxyService proxy;

	@Override
	public Member addMember(Member m) {
		memberRepository.save(m);
		return null;
	}

	@Override
	public void deleteMember(Long id) {
		memberRepository.deleteById(id);
		
	}

	@Override
	public Member updateMember(Member p) {
		memberRepository.saveAndFlush(p);
		return null;
	}

	@Override
	public Member findMember(Long id) {
		Member m=(Member)memberRepository.findById(id).get();
		return m;
	}

	@Override
	public List<Member> findAll() {
		return memberRepository.findAll();
	
	}

	@Override
	public Member findByCin(String cin) {
		return memberRepository.findByCin(cin);}

	@Override
	public Member findByEmail(String email) {
		return memberRepository.findByEmail(email);}

	@Override
	public List<Member> findByNom(String nom) {
		return memberRepository.findByNomStartingWith(nom);}

	@Override
	public List<Etudiant> findByDiplome(String diplome) {
		return etudiantRepository.findByDiplomeOrderByDateInscriptionDesc(diplome);
	}

	@Override
	public List<EnseignantChercheur> findByGrade(String grade) {
		// TODO Auto-generated method stub
		return enseignantChercheurRepository.findByGrade(grade);
	}

	@Override
	public List<EnseignantChercheur> findByEtablissement(String etablissement) {
		return enseignantChercheurRepository.findByEtablissement(etablissement);
	}

	@Override
	public void affectEtudiantToEnseignant(long ide, long idE) {
	  Etudiant m=(Etudiant)memberRepository.findById(ide).get();
	  EnseignantChercheur enc=enseignantChercheurRepository.findById(idE).get();
	  m.setEncadrant(enc);
	  memberRepository.save(m);
		
	}

	@Override
	public List<Etudiant> findByEncadrant(EnseignantChercheur ens) {
		// TODO Auto-generated method stub
		return etudiantRepository.findByEncadrant(ens);
	}
	public void affecterauteurTopublication(Long idauteur, Long idpub)
	{
	Member mbr= memberRepository.findById(idauteur).get();
	Member_Publication mbs= new Member_Publication();
	mbs.setAuteur(mbr);
	mbs.setId(new Member_Pub_Id(idpub, idauteur));
	memberpubrepository.save(mbs);
	}

	@Override
	public List<PublicationBean> findPublicationparauteur(Long idauteur) {
		List<PublicationBean> pubs=new ArrayList<PublicationBean>();
		List< Member_Publication>
		idpubs=memberpubrepository.findpubId(idauteur);
		idpubs.forEach(s->{
		System.out.println(s);
		pubs.add(proxy.findPublicationById(s.getId().getPublication_id()));
		}
		);
		return pubs;
		}

}
