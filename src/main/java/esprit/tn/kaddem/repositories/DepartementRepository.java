package esprit.tn.kaddem.repositories;

import esprit.tn.kaddem.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends JpaRepository<Departement,Integer> {
}
