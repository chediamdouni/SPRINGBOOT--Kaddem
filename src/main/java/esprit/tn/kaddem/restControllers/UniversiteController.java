package esprit.tn.kaddem.restControllers;

import esprit.tn.kaddem.entities.Universite;
import esprit.tn.kaddem.services.IUniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
@RequestMapping("/universite")
@RestController
public class UniversiteController {
    @Autowired
    IUniversiteService iUnivresiteService;

    @GetMapping("getall")
    public List<Universite> retrieveAllUniversite(){
        return iUnivresiteService.getAllUniversite();
    }

    @PostMapping("/add")
    public Universite addUnivesite(@RequestBody Universite u){
        return iUnivresiteService.addUniversite(u);
    }

    @PutMapping("/update")
    public Universite updateUniversite(@RequestBody Universite u){
        return iUnivresiteService.updateUniversite(u);
    }

    @GetMapping ("/getOne")
    public Universite retrieveUniversite(@PathParam("id") Integer idUniversite){
        return  iUnivresiteService.getById(idUniversite);
    }

    @DeleteMapping("/delete")
    public void removeUniversite(@PathParam("id") Integer idUniversite){
        iUnivresiteService.removeUniversite(idUniversite);
    }
}
