package esprit.tn.kaddem.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEquipe;
    private String nomEquipe;
    private Niveau niveau;
    @OneToOne
    private DetailsEquipe equipeDetails;
    @ManyToMany(mappedBy="equipes", cascade = CascadeType.ALL)
    private Set<Etudiant> Etudiants;


}
