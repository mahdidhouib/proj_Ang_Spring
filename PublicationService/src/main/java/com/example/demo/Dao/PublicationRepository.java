package com.example.demo.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.example.demo.Entities.Publication;

@RepositoryRestController
public interface PublicationRepository extends JpaRepository<Publication,Long> {
}