package com.example.animal_adoption.model.Repository;

import com.example.animal_adoption.model.entity.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicationRepository extends JpaRepository<Publication, Integer> {

}
