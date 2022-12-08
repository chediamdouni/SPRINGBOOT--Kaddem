package esprit.tn.kaddem.services;

import esprit.tn.kaddem.entities.Contrat;
import org.springframework.web.bind.annotation.*;
import esprit.tn.kaddem.entities.Etudiant;
import esprit.tn.kaddem.repositories.ContratRepository;
import esprit.tn.kaddem.repositories.EtudiantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
@Slf4j
@Service
public class ContratServiceImp implements IContratService{

    @Autowired
    ContratRepository contratRepository;
    @Autowired
    EtudiantRepository etudiantRepository;

    @Override
    public Contrat addContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public Contrat updateContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public Contrat getById(Integer idContrat) {
        return contratRepository.findById(idContrat).orElse(null);
    }

    @Override
    public List<Contrat> getAllContrat() {
        return contratRepository.findAll();
    }

    @Override
    public void removeContrat(Integer IdContrat) {
        contratRepository.deleteById(IdContrat);
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {


        List <Etudiant> etudiants = etudiantRepository.findAll();
        Etudiant etudiant=null;
        for (Etudiant etudiant1:etudiants)
            if(etudiant1.getNomE().equals(nomE)&&etudiant1.getPrenomE().equals(prenomE)){
                etudiant=etudiant1;
            }
        int nbrContratActifs=0;
        if(etudiant!=null){
            for (Contrat c : etudiant.getContrats()){
                if (c.isArchive()==false) {
                    nbrContratActifs++;
                }
            }
            if(nbrContratActifs<5){
                ce.setEtudiant(etudiant);
            }
        } return contratRepository.save(ce);
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        List<Contrat> contrats=contratRepository.findAll();
        int i=0;
        for (Contrat ct:contrats) {
            if (ct.getDateDebutC().toString().equals(startDate.toString())
                    &&
                    ct.getDateFinC().toString().equals(endDate.toString()))
            {
                i++;
            }
        }
        return i;
    }
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        List<Contrat> contrats = contratRepository.findAll();

        long diff = endDate.getTime() - startDate.getTime();
        double chiffreAffaire = 0;
        //double resultat =0 ;
        for (Contrat ct : contrats) {
            if (ct.isArchive() == false) {
                if ((ct.getDateDebutC().before(startDate)) && (ct.getDateFinC().after(endDate))) {

                    double diffMois = diff / (1000 * 60 * 60 * 24 * 30);
                    double resultat =0 ;
                    switch (ct.getSpecialite()) {
                        case IA:
                            chiffreAffaire =+ diffMois * 300;
                            break;
                        case RESEAUX:
                            chiffreAffaire =+ diffMois * 350;
                            break;
                        case CLOUD:
                            chiffreAffaire =+ diffMois * 400;
                            break;
                        case SECURITE:
                            chiffreAffaire =+ diffMois * 450;
                            break;
                    }
                    return (float) chiffreAffaire;
                }
            }
        }
        return (float) chiffreAffaire;
    }

    @Transactional
    public void archiveContracts(){
        contratRepository.findByArchiveIsFalseAndDateFinContrat(new Date()).stream()
                .forEach(contrat -> contrat.setArchive(true));
    }

    @Scheduled(fixedRate = 60000)
    @Override
    public void retrieveAndUpdateStatusContrat() {
        etudiantRepository.findAll().stream()
                .map(Etudiant::getEquipes)
                .flatMap(Collection::stream)
                .forEach(equipe -> log.info(equipe.getNomEquipe()));

    }
}
