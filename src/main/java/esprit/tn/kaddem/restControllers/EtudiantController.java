package esprit.tn.kaddem.restControllers;

import esprit.tn.kaddem.entities.Etudiant;
import esprit.tn.kaddem.services.IDepartementService;
import esprit.tn.kaddem.services.IEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @DeleteMapping("/delete")
    public void removeEtudiant(@PathParam("id") long idEtudiant){
        iEtudiantService.removeStudent(idEtudiant);
    }
}
