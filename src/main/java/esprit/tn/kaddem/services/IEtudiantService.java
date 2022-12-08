package esprit.tn.kaddem.services;

import esprit.tn.kaddem.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {

    public Etudiant addStudent(Etudiant e);
    public Etudiant updateStudent(Etudiant e);
    public Etudiant getById(long IdEtudiant);
    public List<Etudiant> getAllStudent();
    public void removeStudent(long idEtudiant);
}
