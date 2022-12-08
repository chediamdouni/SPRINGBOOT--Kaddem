package esprit.tn.kaddem.services;

import esprit.tn.kaddem.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {

    public Etudiant addStudent(Etudiant e);
    public Etudiant updateStudent(Etudiant e);
    public Etudiant getById(Integer IdEtudiant);
    public List<Etudiant> getAllStudent();
    public void removeStudent(Integer idEtudiant);
    public void addAndAssignEtudiant(int idEtudiant, int idDepartement);

    public Etudiant AssignEtudiantToEquipeAndContrat(Etudiant e , Integer idContrat , Integer idEquipe);

    List<Etudiant> getEtudiantsByDepartement (int idDepartement);

}
