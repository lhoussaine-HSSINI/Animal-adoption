package com.example.animal_adoption.model.dto;

import com.example.animal_adoption.model.entity.Animaux;
import com.example.animal_adoption.model.entity.Commentaires;
import com.example.animal_adoption.model.entity.Publication;
import com.example.animal_adoption.model.entity.User;
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
    private Animaux animauxByIdAnim;
    private User usersByIdUser;
//    private Collection<Commentaires> commentairesByIdPublication;


    public PublicationDTO toPublicationDTO(Publication publication){
        return PublicationDTO.builder()
                .id_publication(publication.getIdPublication())
                .titrePublication(publication.getTitrePublication())
                .descriptionPublication(publication.getDescriptionPublication())
                .villePublication(publication.getVillePublication())
                .prixPublication(publication.getPrixPublication())
                .animauxByIdAnim(publication.getAnimauxByIdAnim())
                .usersByIdUser(publication.getUsersByIdUser())
//                .commentairesByIdPublication(publication.getCommentairesByIdPublication())
                .build();
    }
}
