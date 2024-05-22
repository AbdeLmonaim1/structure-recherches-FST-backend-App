package com.PFE.StructureRechercheFST.Services.Enseignant;

import com.PFE.StructureRechercheFST.DAO.EnseignantDAO;
import com.PFE.StructureRechercheFST.DAO.EvenementDAO;
import com.PFE.StructureRechercheFST.DAO.PublicationDAO;
import com.PFE.StructureRechercheFST.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
@SuppressWarnings("unused")
public class EnseignantService {

    @Autowired
    private PublicationDAO publicationDAO;

    @Autowired
    private EnseignantDAO enseignantDAO;
    @Autowired
    private EvenementDAO evenementDAO;

    public void Publier(Publication publication,Long idPublier) {
        Enseignant enseignant = null;
        if(enseignantDAO.findById(idPublier).isPresent()) {
            enseignant = enseignantDAO.findById(idPublier).get();
        }
        publication.setDatePub(new Date());
        publication.setEnseignant(enseignant);
        publicationDAO.save(publication);
    }

    public List<Publication> allPublications() {
        List<Publication> allPublications = publicationDAO.findAll();
        return allPublications;
    }
//    public List<Publication> getAllPublicationById(Long id){
//        List<Publication> publicationList = publicationDAO.findAllById(Collections.singleton(id));
//        return publicationList;
//    }
     public List<Publication> getAllPublicationsByEnseignantId(Long enseignantId) {
           return publicationDAO.findByEnseignantId(enseignantId);
    }
    public void organiser(Evenement evenement){
        evenementDAO.save(evenement);
    }
    public int coutPublicationByEnseignantId(Long enseignantId) {
        List<Publication> allPublicationByEnseignant = publicationDAO.findByEnseignantId(enseignantId);
        return allPublicationByEnseignant.size();
    }
    public int countAllEnseignant(){
        List<Enseignant> countAllEnseignant = enseignantDAO.findAll();
        return countAllEnseignant.size();
    }
}
