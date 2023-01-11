package com.example.animal_adoption.model.dto;

import com.example.animal_adoption.model.entity.Commentaires;
import com.example.animal_adoption.model.entity.Publication;
import com.example.animal_adoption.model.entity.Reponses;
import com.example.animal_adoption.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Collection;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentairesDTO {

    private int idCommentaire;
    private String descriptionCommentaire;
    private Timestamp dateCommentaires;
    private Publication publicationByIdPublication;
    private User usersByIdUser;
//    private Collection<Reponses> reponsesByIdCommentaire;

    public CommentairesDTO toPublicationDTO(Commentaires commentaires) {
        return CommentairesDTO.builder()
                .idCommentaire(commentaires.getIdCommentaire())
                .descriptionCommentaire(commentaires.getDescriptionCommentaire())
                .dateCommentaires(commentaires.getDateCommentaires())
                .publicationByIdPublication(commentaires.getPublicationByIdPublication())
                .usersByIdUser(commentaires.getUsersByIdUser())
//                .reponsesByIdCommentaire(commentaires.getReponsesByIdCommentaire())
                .build();
    }
}
