package com.example.animal_adoption.model.Repository;

import com.example.animal_adoption.model.entity.Animaux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnimauxRepository extends JpaRepository<Animaux, Integer> {
    Optional<Animaux> findByType(String type);
    Optional<Animaux> findByUsersByIdUser(Integer id);
}
