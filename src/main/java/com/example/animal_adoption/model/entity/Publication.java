package com.example.animal_adoption.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@Table(name = "publication")
public class Publication {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_publication", nullable = false)
    private int idPublication;
    @Basic
    @Column(name = "titre_publication", nullable = false, length = 256)
    private String titrePublication;
    @Basic
    @Column(name = "description_publication", nullable = false, length = 256)
    private String descriptionPublication;
    @Basic
    @Column(name = "ville_publication", nullable = false, length = 256)
    private String villePublication;
    @Basic
    @Column(name = "prix_publication", nullable = false)
    private int prixPublication;

    @OneToMany(mappedBy = "publicationByIdPublication")
    private Collection<Commentaires> commentairesByIdPublication;
    @ManyToOne
    @JoinColumn(name = "id_anim", referencedColumnName = "id_animaux", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Animaux animauxByIdAnim;
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "identifiant", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User usersByIdUser;
}
