package esprit.tn.kaddem.restControllers;

import esprit.tn.kaddem.entities.Departement;
import esprit.tn.kaddem.services.IDepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/departement")
public class DepartementController {
    @Autowired
    IDepartementService iDepartementService;

    @GetMapping("/getall")
    List<Departement> retrieveDepartments(){
        return iDepartementService.getAllDepartement();
    }

    @PostMapping("add")
    public Departement addDepartement(@RequestBody Departement d){
        return iDepartementService.addDepartement(d);
    }

    @PutMapping("update")
    public Departement updateDepartement(@RequestBody Departement d){
        return iDepartementService.updateDepartement(d);
    }

    @GetMapping("/getone")
    public Departement retrieveDepartement(@PathParam("id") Integer idDepartement){
        return iDepartementService.getById(idDepartement);
    }

    @DeleteMapping("/delete")
    public void deleteDepartement(@PathParam("id") Integer idDepartement){
        iDepartementService.removeDepartement(idDepartement);
    }
    @PostMapping ("/assign/{id}/{idDepartement}")
    public void addAndAssignDepartement(@PathVariable int idUniversite,@PathVariable int idDepartement) {
        iDepartementService.assignUniversiteToDepartement(idUniversite,idDepartement);
    }

    @GetMapping("/retriveDepByUniv/{idUniversity}")
    public List<Departement> retrieveDepartementByUniversity(@PathVariable Integer idUniversity){
        return iDepartementService.retrieveDepartementsByUniversite(idUniversity);
    }
}
