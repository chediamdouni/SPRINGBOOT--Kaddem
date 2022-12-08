package esprit.tn.kaddem.restControllers;

import esprit.tn.kaddem.entities.Equipe;
import esprit.tn.kaddem.services.IEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/equipe")
public class EquipeController {
    @Autowired
    IEquipeService iEquipeService;

    @GetMapping("/getall")
    public List<Equipe> retrieveAllEquipes(){
        return iEquipeService.getAllEquipe();
    }

    @PostMapping("/add")
    public Equipe addEquipe(@RequestBody Equipe c){
        return iEquipeService.addEquipe(c);
    }

    @GetMapping("/getone")
    public Equipe retieveEquipe(@PathParam("id") long idEquipe){
        return iEquipeService.getById(idEquipe);
    }

    @DeleteMapping("/delete")
    public void removeEquipe(@PathParam("id") long idEquipe){
        iEquipeService.removeEquipe(idEquipe);
    }
}
