package esprit.tn.kaddem.services;

import esprit.tn.kaddem.entities.Equipe;
import esprit.tn.kaddem.repositories.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EquipeServiceImp implements IEquipeService{

    @Autowired
    EquipeRepository equipeRepository;

    @Override
    public Equipe addEquipe(Equipe c) {
        return equipeRepository.save(c);
    }
    @Override
    public Equipe updateEquipe(Equipe c) {
        return equipeRepository.save(c);
    }

    @Override
    public Equipe getById(long IdEquipe) {
        return equipeRepository.findById(IdEquipe).orElse(null);
    }

    @Override
    public List<Equipe> getAllEquipe() {
        return equipeRepository.findAll();
    }

    @Override
    public void removeEquipe(long IdEquipe) {
    equipeRepository.deleteById(IdEquipe);
    }
}
