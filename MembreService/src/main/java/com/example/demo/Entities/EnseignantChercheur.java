package com.example.demo.Entities;

import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("ens")
@NoArgsConstructor
public class EnseignantChercheur extends Member {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String grade;
	private String etablissement;



@Builder
public EnseignantChercheur( String cin, String nom, String prenom, Date dateNaissance,
String cv,
String email, String password, String etablissement, String
grade) {
super( cin, nom, prenom, dateNaissance, cv, email, password);

this.grade = grade;
this.etablissement = etablissement;
}
}