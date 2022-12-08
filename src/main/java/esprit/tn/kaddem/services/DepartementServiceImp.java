package esprit.tn.kaddem.services;

import esprit.tn.kaddem.entities.Departement;
import esprit.tn.kaddem.entities.Universite;
import esprit.tn.kaddem.repositories.DepartementRepository;
import esprit.tn.kaddem.repositories.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartementServiceImp implements IDepartementService{

    @Autowired
    DepartementRepository departementRepository;
    @Autowired
    UniversiteRepository universiteRepository;

    @Override
    public Departement addDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement getById(Integer IdDepartement) {
        return departementRepository.findById(IdDepartement).orElse(null);
    }

    @Override
    public List<Departement> getAllDepartement() {
        return departementRepository.findAll();
    }

    @Override
    public void removeDepartement(Integer IdDepartement) {
    departementRepository.deleteById(IdDepartement);
    }
    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {

        Universite universite= universiteRepository.findById(idUniversite).orElse(null);
        Departement departement= departementRepository.findById(idDepartement).orElse(null);
        if(universite !=null && departement!=null){
            universite.getDepartements().add(departement);
            universiteRepository.save(universite);
        }
    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        Universite universite=universiteRepository.findById(idUniversite).orElse(null);
        if(universite!=null){
            return (List<Departement>) universite.getDepartements();
        }
        return null;

    }
}
