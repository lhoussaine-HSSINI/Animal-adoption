package com.example.animal_adoption.Authentication;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String tel;
    private int nombreAnimaux;
    private String password;
}
