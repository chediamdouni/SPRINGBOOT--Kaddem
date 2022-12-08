package esprit.tn.kaddem.services;

import esprit.tn.kaddem.entities.Etudiant;
import esprit.tn.kaddem.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EtudiantServiceImp implements IEtudiantService{

    @Autowired
    EtudiantRepository etudiantRepository;

    @Override
    public Etudiant addStudent(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateStudent(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant getById(long IdEtudiant) {
        return etudiantRepository.findById(IdEtudiant).orElse(null);
    }

    @Override
    public List<Etudiant> getAllStudent() {
        return etudiantRepository.findAll();
    }

    @Override
    public void removeStudent(long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }
}
