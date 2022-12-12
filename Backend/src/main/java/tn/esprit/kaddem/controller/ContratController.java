package tn.esprit.kaddem.controller;

import lombok.AllArgsConstructor;
import org.hibernate.annotations.Cache;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.kaddem.entities.Contrat;
import tn.esprit.kaddem.services.IContratServices;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Contrat")
@AllArgsConstructor
public class ContratController {


    IContratServices contratServices;

    @GetMapping("/getAll")
    @Cacheable("data")
    public List<Contrat> getAllContrat() {
        return contratServices.getALLContrat();
    }

    @PostMapping("/add")
    @CacheEvict("data")
    public Contrat addContrat(@RequestBody Contrat c) {
        return contratServices.addContrat(c);
    }

    @GetMapping("getById/{idContrat}")
    public Contrat getContrat(@PathVariable ("idContrat")Integer idContrat) {
        return contratServices.getContratById(idContrat);
    }

    @PutMapping("/update")
    @CacheEvict("data")
    public Contrat updateContrat(@RequestBody Contrat c) {
        return contratServices.updateContrat(c);
    }

    @DeleteMapping("delete/{idContrat}")
    @CacheEvict("data")
    public void deleteContrat(@PathVariable ("idContrat") Integer idContrat) {
        contratServices.deleteContrat(idContrat);
    }

    @PostMapping("/affectToEtudiant/{prenomE}")
    @CacheEvict("data")
    public Contrat affectContratToEtudiant(@RequestBody Contrat ce, String nomE, @PathVariable ("prenomE") String prenomE) {

        return contratServices.affectContratToEtudiant(ce, nomE, prenomE);

    }

    @GetMapping("getCA/{Ds}/{Df}")
    @Cacheable("data")
    public float getChiffreAffaireEntreDeuxDate(@PathVariable("Ds") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @PathVariable("Df") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return contratServices.getChiffreAffaireEntreDeuxDate(startDate, endDate);
    }

    @GetMapping("/getValide/{DateDebutContrat}/{DateFinContrat}")
    @Cacheable("data")
    public Integer GetValide(@PathVariable("DateDebutContrat") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateD, @PathVariable("DateFinContrat") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateF) {

        return contratServices.nbContratsValides(dateD, dateF);
    }
}
