package esprit.tn.kaddem.services;

import esprit.tn.kaddem.entities.Departement;

import java.util.List;

public interface IDepartementService {

    public Departement addDepartement(Departement d);
    public Departement updateDepartement(Departement d);
    public Departement getById(long IdDepartement);
    public List<Departement> getAllDepartement();
    public void removeDepartement(long IdDepartement);
}
