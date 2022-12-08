package esprit.tn.kaddem.services;

import esprit.tn.kaddem.entities.Contrat;
import esprit.tn.kaddem.entities.Departement;
import esprit.tn.kaddem.entities.Equipe;
import esprit.tn.kaddem.entities.Etudiant;
import esprit.tn.kaddem.repositories.ContratRepository;
import esprit.tn.kaddem.repositories.DepartementRepository;
import esprit.tn.kaddem.repositories.EquipeRepository;
import esprit.tn.kaddem.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class EtudiantServiceImp implements IEtudiantService{

    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    DepartementRepository departementRepository;
    @Autowired
    ContratRepository contratRepository;
    @Autowired
    EquipeRepository equipeRepository;


    @Override
    public Etudiant addStudent(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateStudent(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant getById(Integer IdEtudiant) {
        return etudiantRepository.findById(IdEtudiant).orElse(null);
    }

    @Override
    public List<Etudiant> getAllStudent() {
        return etudiantRepository.findAll();
    }

    @Override
    public void removeStudent(Integer idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }
    @Override
    public void addAndAssignEtudiant(int idEtudiant, int idDepartement) {
        Etudiant e = etudiantRepository.findById(idEtudiant).orElse(null);
        Departement d = departementRepository.findById(idDepartement).orElse(null);
        if (d != null && e != null) {
            e.setDepartement(d);
        }
        etudiantRepository.save(e);
    }

    @Transactional
    @Override
    public Etudiant AssignEtudiantToEquipeAndContrat(Etudiant e, Integer idContrat, Integer idEquipe) {
        Contrat contrat = contratRepository.findById(idContrat).orElse(null);
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
        if (contrat != null && equipe != null) {
            Etudiant etudiant = etudiantRepository.save(e);
            contrat.setEtudiant(etudiant);
            equipe.getEtudiants().add(etudiant);
            return etudiant;
        }
        return null;
    }



    @Override
    public List<Etudiant> getEtudiantsByDepartement(int idDepartement) {

        return etudiantRepository.findByDepartementIdDepartement(idDepartement);
        //hedhi wla hedhi, bel key word wla blech
       /* Departement departement = departementRepository.findById(idDepartement).orElse(null);
        if(departement!=null)
        {
        return departement.getEtudiants();
        }*/
    }


}
