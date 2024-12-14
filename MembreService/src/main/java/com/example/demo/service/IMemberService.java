package com.example.demo.service;

import java.util.List;

import com.example.demo.Entities.EnseignantChercheur;
import com.example.demo.Entities.Etudiant;
import com.example.demo.Entities.Member;
import com.example.demo.beans.PublicationBean;

public interface IMemberService {
	//Crud sur les membres
	public Member addMember(Member m);
	public void deleteMember(Long id) ;
	public Member updateMember(Member p) ;
	public Member findMember(Long id) ;
	public List<Member> findAll();
	//Filtrage par propriété
	public Member findByCin(String cin);
	public Member findByEmail(String email);
	public List<Member> findByNom(String nom);
	//recherche spécifique des étudiants
	public List<Etudiant> findByDiplome(String diplome);
	//recherche spécifique des enseignants
	public List<EnseignantChercheur> findByGrade(String grade);
	public List<EnseignantChercheur> findByEtablissement(String
	etablissement);
	//other ...
	void affectEtudiantToEnseignant(long ide , long idE);
	
	
	List<Etudiant> findByEncadrant(EnseignantChercheur ens);
	
	public void affecterauteurTopublication(Long idauteur, Long idpub);

			public List<PublicationBean>
			findPublicationparauteur (Long idauteur);
		
	

}
