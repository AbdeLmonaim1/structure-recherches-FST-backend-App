package com.PFE.StructureRechercheFST.RestAPIs.Admin;


import com.PFE.StructureRechercheFST.Services.Admin.Equipe_Admin;
import com.PFE.StructureRechercheFST.models.DTO.EncadrantLabel;
import com.PFE.StructureRechercheFST.models.Enseignant;
import com.PFE.StructureRechercheFST.models.Equipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SuppressWarnings("unused")
@CrossOrigin
@RequestMapping("/Admin/Equipe")
public class EquipeAdminController {

    @Autowired
    private Equipe_Admin equipeAdmin;

    @PostMapping("/AjouterEquipe/{responsable}")
    public List<Equipe> AjouterEquipe(@RequestBody Equipe equipe,@PathVariable String responsable) {
        return equipeAdmin.AjouterEquipe(equipe,responsable);
    }

    @GetMapping("/getAll")
    public List<Equipe> getEquipes() {
        return equipeAdmin.getEquipes();
    }

    @PutMapping("/addMembre/{idEquipe}")
    public void AjouterMembre(@RequestBody List<Enseignant> enseignants, @PathVariable Long idEquipe) {
        equipeAdmin.AjouterMembre(enseignants,idEquipe);
    }

    @GetMapping("/getById/{id}")
    public Equipe getEquipeById(@PathVariable Long id) {
        return equipeAdmin.getEquipeById(id);
    }

    @PostMapping("/addSeulMembre/{id}")
    public void AjouterUnSeulMembre(@RequestBody EncadrantLabel name, @PathVariable long id) {
        equipeAdmin.AjouterUnSeulMembre(name,id);
    }

    @GetMapping("/getChoicesMembre")
    public List<EncadrantLabel> getChoices() {
        return equipeAdmin.getMembreChoices();
    }

}
