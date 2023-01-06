package com.example.animal_adoption.model.dto;

import com.example.animal_adoption.model.entity.Commentaires;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicationDTO {
    private int id_publication;
    private String titrePublication;
    private String descriptionPublication;
    private String villePublication;
    private int prixPublication;
    private AnimauxDTO animauxByIdAnim;
    private UserDTO usersByIdUser;
    private Collection<CommentairesDTO> commentairesByIdPublication;

}
