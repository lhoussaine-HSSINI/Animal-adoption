package com.example.animal_adoption.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "animaux")
public class Animaux {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_animaux", nullable = false)
    private int idAnimaux;
    @Basic
    @Column(name = "type", nullable = false, length = 256)
    private String type;
    @Basic
    @Column(name = "age", nullable = false)
    private int age;
    @Basic
    @Column(name = "nombre_jours", nullable = false)
    private int nombreJours;
    @Basic
    @Column(name = "description", nullable = false, length = 256)
    private String description;
    @Basic
    @Column(name = "photo", nullable = false, length = 256)
    private String photo;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "identifiant", nullable = false)
    private User usersByIdUser;
    @OneToMany(mappedBy = "animauxByIdAnim")
    private Collection<Publication> publicationsByIdAnimaux;
}
