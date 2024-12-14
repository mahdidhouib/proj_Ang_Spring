package com.example.demo.Entities;

import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter @Setter
@DiscriminatorValue("etd")
@NoArgsConstructor
public class Etudiant extends Member{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	@Temporal(TemporalType.DATE)
	private Date dateInscription;
	private String diplome;
	private String sujet;
	
	@ManyToOne
	private EnseignantChercheur encadrant;
	
	@Builder
	public Etudiant( String cin, String nom, String prenom, Date dateNaissance,
	String cv,
	String email, String password, Date dateInscription, String sujet, String
	diplome,
	EnseignantChercheur encadrant) {
	super( cin, nom, prenom, dateNaissance, cv, email, password);
	this.dateInscription = dateInscription;
	this.sujet = sujet;
	this.diplome = diplome;
	this.encadrant = encadrant;
	}
	

}
