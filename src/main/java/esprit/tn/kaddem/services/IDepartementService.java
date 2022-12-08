package esprit.tn.kaddem.services;

import esprit.tn.kaddem.entities.Departement;

import java.util.List;

public interface IDepartementService {

    public Departement addDepartement(Departement d);
    public Departement updateDepartement(Departement d);
    public Departement getById(Integer IdDepartement);
    public List<Departement> getAllDepartement();
    public void removeDepartement(Integer IdDepartement);
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);
}
