package com.example.animal_adoption.model.dto;

import com.example.animal_adoption.model.entity.Commentaires;
import com.example.animal_adoption.model.entity.Reponses;
import com.example.animal_adoption.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReponsesDTO {
    private int idReponse;
    private String descriptionReponse;
    private Timestamp dateReponse;
    private Commentaires commentairesByIdCommentaire;
    private User usersByIdUser;

    public  ReponsesDTO  toReponsesDTO(Reponses reponses){
        return  ReponsesDTO.builder()
                .idReponse(reponses.getIdReponse())
                .descriptionReponse(reponses.getDescriptionReponse())
                .dateReponse(reponses.getDateReponse())
                .commentairesByIdCommentaire(reponses.getCommentairesByIdCommentaire())
                .usersByIdUser(reponses.getUsersByIdUser())
                .build();
    }
}
