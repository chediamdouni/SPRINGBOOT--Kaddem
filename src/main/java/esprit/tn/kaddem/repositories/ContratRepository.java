package esprit.tn.kaddem.repositories;

import esprit.tn.kaddem.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ContratRepository extends JpaRepository<Contrat,Integer> {

    int countByArchiveFalseAndEtudiantNomEAndEtudiantPrenomE(String NomE, String PrenomE);
    List<Contrat> findByArchiveIsFalse();
    List<Contrat> findByArchiveIsFalseAndDateFinContrat(Date date);
}
