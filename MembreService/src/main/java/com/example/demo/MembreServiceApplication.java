package com.example.demo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.example.demo.DAO.MemberRepository;
import com.example.demo.Entities.EnseignantChercheur;
import com.example.demo.Entities.Etudiant;
import com.example.demo.Entities.Member;
import com.example.demo.beans.PublicationBean;
import com.example.demo.proxies.PublicationProxyService;
import com.example.demo.service.IMemberService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MembreServiceApplication implements CommandLineRunner{
	MemberRepository memberRepository;
	IMemberService memberService;
	PublicationProxyService pubProxy;

	public static void main(String[] args) {
		SpringApplication.run(MembreServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Etudiant etd1=Etudiant.builder()
				.cin("123456")
				.dateInscription(new Date())
				.dateNaissance(new Date())
				.diplome("mastère")
				.email("etd1@gmail.com")
				.password("pass1")
				.encadrant(null)
				.cv("cv1")
				.nom("abid")
				.prenom("youssef)")
				.sujet("blockhain")
				.build();
		memberRepository.save(etd1);
		Etudiant etd2=Etudiant.builder()
				.cin("111111")
				.dateInscription(new Date())
				.dateNaissance(new Date())
				.diplome("ingenierie")
				.email("etd2@gmail.com")
				.password("pass2")
				.encadrant(null)
				.cv("cv1")
				.nom("mahdi")
				.prenom("dhouib)")
				.sujet("IA")
				.build();
		memberRepository.save(etd2);
		EnseignantChercheur EN1=EnseignantChercheur.builder()
				.cin("111111")
				.dateNaissance(new Date())
				.email("en1@gmail.com")
				.password("pass21")
				.cv("cv1")
				.nom("mahdi")
				.prenom("dhouib)")
				.grade("assistant")
				.etablissement("enis")
				.build();
		memberRepository.save(EN1);
		EnseignantChercheur EN2=EnseignantChercheur.builder()
				.cin("222222")
				.dateNaissance(new Date())
				.email("en2@gmail.com")
				.password("pass22")
				.cv("cv1")
				.nom("ahmad")
				.prenom("dhouib)")
				.grade("assistant")
				.etablissement("enis")
				.build();
		memberRepository.save(EN2);
		
		System.out.println("Liste des membres :");
		memberRepository.findAll().forEach(member -> System.out.println(member.getNom()  +" "+ member.getPrenom()) );
		
		
	    
	    System.out.println("\nEntrez l'ID du membre à rechercher :");
	    // Lire l'ID inséré par l'utilisateur

	    Optional<?> foundMember = memberRepository.findById(etd1.getId());
	    if (foundMember.isPresent()) {
	        Object member = foundMember.get();
	        if (member instanceof Etudiant || member instanceof EnseignantChercheur) {
	            System.out.println("Membre trouvé : Nom = " + ((Etudiant) member).getNom());
	        }
	    } else {
	        System.out.println("Aucun membre trouvé avec l'ID : " + ((Member) foundMember.get()).getNom());
	    }

	   
		System.out.println("\nModification d'un membre :");
		etd1.setCin("848484");
		memberRepository.save(etd1);
		
		//memberRepository.delete(etd1);
		
		Member m= memberService.findMember(1L);
		m.setCv("cv1.pdf");
		memberService.updateMember(m);
		// Delete a Member
		//memberService.deleteMember(2L);
		
		System.out.println("**************************************************************");
		
		
		memberService.affectEtudiantToEnseignant(1L,3L);
		memberService.affectEtudiantToEnseignant(2L,3L);
		
		List<Etudiant> etudiantsByEncadrant = memberService.findByEncadrant(EN1);
		
		etudiantsByEncadrant.forEach(etd -> System.out.println("nom" + etd.getNom()+",prenom"+etd.getPrenom()));
		
		PublicationBean pub = pubProxy.findPublicationById(1L);
		System.out.println(pub.getTitre());
		
		memberService.affecterauteurTopublication(1L, 1L);
		memberService.affecterauteurTopublication(1L, 2L);
		
		

		

		
	}
	

}
