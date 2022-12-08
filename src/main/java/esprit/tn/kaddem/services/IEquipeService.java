package esprit.tn.kaddem.services;

import esprit.tn.kaddem.entities.Equipe;

import java.util.List;

public interface IEquipeService {
    public Equipe addEquipe(Equipe c);
    public Equipe updateEquipe(Equipe c);
    public Equipe getById(long IdEquipe);
    public List<Equipe> getAllEquipe();
    public void removeEquipe(long IdEquipe);
}
