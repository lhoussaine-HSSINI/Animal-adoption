package com.example.animal_adoption.model.Repository;

import com.example.animal_adoption.model.entity.Commentaires;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentairesRepository extends JpaRepository<Commentaires, Integer> {
}
