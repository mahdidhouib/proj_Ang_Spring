package com.example.demo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.EnseignantChercheur;
import com.example.demo.Entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	List<Etudiant>findByDiplome(String diplome);
	List<Etudiant>findByEncadrant(EnseignantChercheur encadrant);
	List<Etudiant>findByDiplomeOrderByDateInscriptionDesc(String
	diplome);

}
