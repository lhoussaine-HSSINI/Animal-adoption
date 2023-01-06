package com.example.animal_adoption.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimauxDTO {
    private int idAnimaux;
    private String type;
    private int age;
    private int nombreJours;
    private String description;
    private String photo;
    private UserDTO usersByIdUser;
    private Collection<PublicationDTO> publicationsByIdAnimaux;
}
