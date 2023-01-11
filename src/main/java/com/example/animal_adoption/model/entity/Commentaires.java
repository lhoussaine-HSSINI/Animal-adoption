package com.example.animal_adoption.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "commentaires")
public class Commentaires {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_commentaire", nullable = false)
    private int idCommentaire;
    @Basic
    @Column(name = "description_commentaire", nullable = false)
    private String descriptionCommentaire;
    @Basic
    @Column(name = "date_commentaires", nullable = false)
    private Timestamp dateCommentaires;

    @ManyToOne
    @JoinColumn(name = "id_publication", referencedColumnName = "id_publication", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Publication publicationByIdPublication;
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "identifiant", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User usersByIdUser;
    @OneToMany(mappedBy = "commentairesByIdCommentaire")
    private Collection<Reponses> reponsesByIdCommentaire;

}
