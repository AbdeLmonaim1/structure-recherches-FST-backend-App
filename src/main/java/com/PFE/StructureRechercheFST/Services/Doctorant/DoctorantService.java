package com.PFE.StructureRechercheFST.Services.Doctorant;

import com.PFE.StructureRechercheFST.DAO.DoctorantDAO;
import com.PFE.StructureRechercheFST.DAO.PublicationDAO;
import com.PFE.StructureRechercheFST.models.Doctorant;
import com.PFE.StructureRechercheFST.models.Publication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DoctorantService {
    @Autowired
    private PublicationDAO publicationDAO;
    @Autowired
    private DoctorantDAO doctorantDAO;

    public void publier(Publication publication, Long doctorantId){
        Doctorant doctorant = null;
        if(doctorantDAO.findById(doctorantId).isPresent()) {
            doctorant = doctorantDAO.findById(doctorantId).get();
        }
        publication.setDatePub(new Date());
        publication.setDoctorant(doctorant);
        publicationDAO.save(publication);
    }
}
