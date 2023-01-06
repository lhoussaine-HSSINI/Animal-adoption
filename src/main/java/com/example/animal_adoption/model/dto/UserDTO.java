package com.example.animal_adoption.model.dto;


import com.example.animal_adoption.model.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int identifiant;
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String tel;
    private int nombreAnimaux;
    private Collection<AnimauxDTO> animauxesByIdentifiant;
    private Collection<CommentairesDTO> commentairesByIdentifiant;
    private Collection<PublicationDTO> publicationsByIdentifiant;
    private Collection<ReponsesDTO> reponsesByIdentifiant;

}
