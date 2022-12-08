package esprit.tn.kaddem.restControllers;

import esprit.tn.kaddem.entities.Contrat;
import esprit.tn.kaddem.services.IContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/contrat")
public class ContratController {

    @Autowired
    IContratService iContratService;

    @GetMapping("/retrieveAllContrats")
    public List<Contrat> retrieveAllContrats(){
        return iContratService.getAllContrat();
    }

    @PostMapping("/add")
    public Contrat addContrat(@RequestBody Contrat c){
        return iContratService.addContrat(c);
    }

    @PutMapping("/update")
    public Contrat updateContrat(@RequestBody Contrat c){
        return iContratService.updateContrat(c);
    }

    @GetMapping("/getcontrat")
    public Contrat retrieveContrat(@PathParam("id") long idContrat){
        return iContratService.getById(idContrat);
    }

    @GetMapping("/delete")
    public void removeContrat(@PathParam("id") long idContrat){
        iContratService.removeContrat(idContrat);
    }

}
