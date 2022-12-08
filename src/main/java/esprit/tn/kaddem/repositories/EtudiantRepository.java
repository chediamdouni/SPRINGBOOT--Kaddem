package esprit.tn.kaddem.repositories;


import esprit.tn.kaddem.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {
    public Etudiant findByNomEAndPrenomE(String nomE,String prenomE);

    List<Etudiant> findByDepartementIdDepartement(int idDepartement);
}
