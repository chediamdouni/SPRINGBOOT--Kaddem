package esprit.tn.kaddem.services;

import esprit.tn.kaddem.entities.Contrat;

import java.util.Date;
import java.util.List;

public interface IContratService {

    public Contrat addContrat(Contrat c);
    public Contrat updateContrat(Contrat c);
    public Contrat getById(long IdContrat);
    public List<Contrat> getAllContrat();
    public void removeContrat(long IdContrat);

}
