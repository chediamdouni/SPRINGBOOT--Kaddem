package esprit.tn.kaddem.services;

import esprit.tn.kaddem.entities.Contrat;
import esprit.tn.kaddem.repositories.ContratRepository;
import esprit.tn.kaddem.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContratServiceImp implements IContratService{

    @Autowired
    ContratRepository contratRepository;

    @Override
    public Contrat addContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public Contrat updateContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public Contrat getById(long idContrat) {
        return contratRepository.findById(idContrat).orElse(null);
    }

    @Override
    public List<Contrat> getAllContrat() {
        return contratRepository.findAll();
    }

    @Override
    public void removeContrat(long IdContrat) {
        contratRepository.deleteById(IdContrat);
    }
}
