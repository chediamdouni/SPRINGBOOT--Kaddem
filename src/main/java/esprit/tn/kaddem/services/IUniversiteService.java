package esprit.tn.kaddem.services;

import esprit.tn.kaddem.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    public Universite addUniversite(Universite c);
    public Universite updateUniversite(Universite c);
    public Universite getById(long IdUniversite);
    public List<Universite> getAllUniversite();
    public void removeUniversite(long IdUniversite);
}