package com.example.animal_adoption.service;


import com.example.animal_adoption.model.Repository.UserRepository;
import com.example.animal_adoption.model.dto.*;
import com.example.animal_adoption.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public List<UserDTO> getpageHome(){
        return ((List<User>) userRepository
                .findAll())
                .stream()
                .map(this::convertDataIntoDTO)
                .collect(Collectors.toList());
    }

    // create convertDataIntoDTO() method that returns UserDTO
    private UserDTO convertDataIntoDTO (User userData) {

        // create instance of our UserLocationDTO class
        UserDTO dto = new UserDTO();
        dto.setIdentifiant(userData.getIdentifiant());
        dto.setNom(userData.getNom());
        dto.setPrenom(userData.getPrenom());
        dto.setAdresse(userData.getAdresse());
        dto.setEmail(userData.getEmail());
        dto.setTel(userData.getTel());
        dto.setNombreAnimaux(userData.getNombreAnimaux());
        dto.setAnimauxesByIdentifiant(userData.getAnimauxesByIdentifiant());
        dto.setCommentairesByIdentifiant(userData.getCommentairesByIdentifiant());
        dto.setPublicationsByIdentifiant(userData.getPublicationsByIdentifiant());
        dto.setReponsesByIdentifiant(userData.getReponsesByIdentifiant());
        return dto;
    }
 }
