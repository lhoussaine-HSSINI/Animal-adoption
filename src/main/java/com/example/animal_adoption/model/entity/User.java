package com.example.animal_adoption.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Table(name = "users")
public class User implements UserDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "identifiant", nullable = false)
    private int identifiant;
    @Basic
    @Column(name = "nom", nullable = false, length = 255)
    private String nom;
    @Basic
    @Column(name = "prenom", nullable = false, length = 255)
    private String prenom;
    @Basic
    @Column(name = "adresse", nullable = false, length = 255)
    private String adresse;
    @Basic
    @Column(name = "email", nullable = false, length = 255)
    private String email;
    @Basic
    @Column(name = "tel", nullable = false, length = 255)
    private String tel;
    @Basic
    @Column(name = "nombre_animaux", nullable = false)
    private int nombreAnimaux;
    @Basic
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @OneToMany(mappedBy = "usersByIdUser")
    private Collection<Animaux> animauxesByIdentifiant;
    @OneToMany(mappedBy = "usersByIdUser")
    private Collection<Commentaires> commentairesByIdentifiant;
    @OneToMany(mappedBy = "usersByIdUser")
    private Collection<Publication> publicationsByIdentifiant;
    @OneToMany(mappedBy = "usersByIdUser")
    private Collection<Reponses> reponsesByIdentifiant;

    @Enumerated(EnumType.STRING)
    private Role role;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
