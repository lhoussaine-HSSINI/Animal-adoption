package com.example.animal_adoption.model.dto;

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
    private int descriptionCommentaire;
    private Timestamp dateCommentaires;
    private PublicationDTO publicationByIdPublication;
    private UserDTO usersByIdUser;
    private Collection<ReponsesDTO> reponsesByIdCommentaire;

}
