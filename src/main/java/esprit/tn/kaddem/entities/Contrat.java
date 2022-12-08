package esprit.tn.kaddem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idContrat;
    @Temporal (TemporalType.DATE)
    private Date dateDebutC;
    @Temporal (TemporalType.DATE)
    private Date dateFinC;
    private Specialite specialite;
    private boolean archive;
    private float montantC;
    @ManyToOne
    @JsonIgnore
    private Etudiant etudiant;
}
