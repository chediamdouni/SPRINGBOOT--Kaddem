package esprit.tn.kaddem.restControllers;

import esprit.tn.kaddem.entities.Etudiant;
import esprit.tn.kaddem.services.IDepartementService;
import esprit.tn.kaddem.services.IEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
    @Autowired
    IEtudiantService iEtudiantService;
    @Autowired
    IDepartementService iDepartementService;

    @PostMapping("/add")
    public Etudiant addStudent(@RequestBody Etudiant e){
        return iEtudiantService.addStudent(e);
    }

    @PutMapping("/update")
    public Etudiant updateStudent(@RequestBody Etudiant e){
        return iEtudiantService.updateStudent(e);
    }

    @GetMapping("/getall")
    public List<Etudiant> getAllStudent(){
        return iEtudiantService.getAllStudent();
    }

    @DeleteMapping("/delete/{id}")
    public void removeEtudiant(@PathVariable Integer idEtudiant){
        iEtudiantService.removeStudent(idEtudiant);
    }

    @PostMapping("/assetoec/{idContrat}/{idEquipe}")
    public ResponseEntity AssignEtudiantToEquipeAndContrat(@RequestBody Etudiant e , @PathVariable Integer idContrat , @PathVariable Integer idEquipe) {
        iEtudiantService.AssignEtudiantToEquipeAndContrat(e, idContrat, idEquipe);
        return new ResponseEntity<>("Added", HttpStatus.OK);
    }

    @GetMapping("etudByDep/{idDepartment}")
    public List<Etudiant> getEtudiantsByDepartement(@PathVariable int idDepartment){
        return iEtudiantService.getEtudiantsByDepartement(idDepartment);
    }
}
