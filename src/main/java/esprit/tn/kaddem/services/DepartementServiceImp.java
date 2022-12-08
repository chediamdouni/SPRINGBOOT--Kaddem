package esprit.tn.kaddem.services;

import esprit.tn.kaddem.entities.Departement;
import esprit.tn.kaddem.repositories.DepartementRepository;
import esprit.tn.kaddem.repositories.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartementServiceImp implements IDepartementService{

    @Autowired
    DepartementRepository departementRepository;

    @Override
    public Departement addDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {
        return departementRepository.save(d);
    }

    @Override
    public Departement getById(long IdDepartement) {
        return departementRepository.findById(IdDepartement).orElse(null);
    }

    @Override
    public List<Departement> getAllDepartement() {
        return departementRepository.findAll();
    }

    @Override
    public void removeDepartement(long IdDepartement) {
    departementRepository.deleteById(IdDepartement);
    }
}
