package com.example.animal_adoption.model.dto;

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
    private int descriptionReponse;
    private Timestamp dateReponse;
    private CommentairesDTO commentairesByIdCommentaire;
    private UserDTO usersByIdUser;
}
