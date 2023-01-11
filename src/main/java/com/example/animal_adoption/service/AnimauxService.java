package com.example.animal_adoption.service;

import com.example.animal_adoption.model.Repository.AnimauxRepository;
import com.example.animal_adoption.model.dto.AnimauxDTO;
import com.example.animal_adoption.model.dto.UserDTO;
import com.example.animal_adoption.model.entity.Animaux;
import com.example.animal_adoption.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimauxService {

    @Autowired
    private AnimauxRepository animauxRepository;

    public List<AnimauxDTO>  getAnimaux_all(){
        return ((List<Animaux>) animauxRepository
                .findAll())
                .stream()
                .map(this::convertDataIntoDTO)
                .collect(Collectors.toList());
    }
    public List<Animaux>  saveAnimaux(){
        return animauxRepository.findAll();
    }

    // create convertDataIntoDTO() method that returns UserDTO
    private AnimauxDTO convertDataIntoDTO (Animaux animauxData) {

        // create instance of our UserLocationDTO class
        AnimauxDTO dto = new AnimauxDTO();
        dto.setIdAnimaux(animauxData.getIdAnimaux());
        dto.setType(animauxData.getType());
        dto.setAge(animauxData.getAge());
        dto.setPhoto(animauxData.getPhoto());
        dto.setDescription(animauxData.getDescription());
        dto.setNombreJours(animauxData.getNombreJours());
        dto.setUsersByIdUser(animauxData.getUsersByIdUser().getIdentifiant());
        return dto;
    }
}
