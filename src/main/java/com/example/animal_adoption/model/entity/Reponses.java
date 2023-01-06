package com.example.animal_adoption.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "reponses")
public class Reponses {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_reponse", nullable = false)
    private int idReponse;
    @Basic
    @Column(name = "description_reponse", nullable = false)
    private int descriptionReponse;
    @Basic
    @Column(name = "date_reponse", nullable = false)
    private Timestamp dateReponse;
    @ManyToOne
    @JoinColumn(name = "id_commentaire", referencedColumnName = "id_commentaire", nullable = false)
    private Commentaires commentairesByIdCommentaire;
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "identifiant", nullable = false)
    private User usersByIdUser;

}
