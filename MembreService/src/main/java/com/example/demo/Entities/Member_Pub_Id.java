package com.example.demo.Entities;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member_Pub_Id implements Serializable {
	private Long publication_id;
	private Long auteur_id;
}
