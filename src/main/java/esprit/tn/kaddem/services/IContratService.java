package esprit.tn.kaddem.services;

import esprit.tn.kaddem.entities.Contrat;

import java.util.Date;
import java.util.List;

public interface IContratService {

    public Contrat addContrat(Contrat c);
    public Contrat updateContrat(Contrat c);
    public Contrat getById(Integer IdContrat);
    public List<Contrat> getAllContrat();
    public void removeContrat(Integer IdContrat);
    public Contrat affectContratToEtudiant (Contrat ce, String nomE,String prenomE);
    Integer nbContratsValides(Date startDate, Date endDate);
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);
    void retrieveAndUpdateStatusContrat();

}
