package esprit.tn.kaddem.services;

import esprit.tn.kaddem.entities.Universite;
import esprit.tn.kaddem.repositories.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UniversiteServiceImp implements IUniversiteService {

    @Autowired
    UniversiteRepository universiteRepository;
    @Override
    public Universite addUniversite(Universite c) {
        return universiteRepository.save(c);
    }

    @Override
    public Universite updateUniversite(Universite c) {
        return universiteRepository.save(c);
    }

    @Override
    public Universite getById(long IdUniversite) {
        return universiteRepository.findById(IdUniversite).orElse(null);
    }

    @Override
    public List<Universite> getAllUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public void removeUniversite(long IdUniversite) {
        universiteRepository.deleteById(IdUniversite);
    }
}
