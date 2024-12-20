package com.example.demo.beans;

import java.util.Date;

import lombok.Data;

@Data
public class PublicationBean {
	private Long id;

	private String titre;

	private String type;// article de journal/ manifestation/chapitre delivre/livre/poster

	private Date dateApparition;

	private String lien;

	private String sourcePdf;
}
