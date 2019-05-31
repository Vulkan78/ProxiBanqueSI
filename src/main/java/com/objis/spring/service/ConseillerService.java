package com.objis.spring.service;

import com.objis.spring.demodao.IClientDao;
import com.objis.spring.demodao.IConseillerDao;
import com.objis.spring.demodomaine.Client;
import com.objis.spring.demodomaine.ConseillerClientele;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Services de la classe Conseiller
 * CRUD
 *
 * @author Jimmy Rakotoson, José-Alexandre Giry
 *
 */
@Service
public class ConseillerService {

    @Autowired
    private IConseillerDao iConseillerDao;

    /**
     * Recupère les conseillers en base
     * @return Une liste de Conseiller
     */
    public List<ConseillerClientele> getAll(){
        return iConseillerDao.findAll();
    }

    /**
     * Injecte le conseiller en base
     * @param newconseiller
     */
    public void createConseiller(ConseillerClientele newconseiller){
        iConseillerDao.save(newconseiller);
    }

    /**
     * Supprime le conseiller de la base
     * @param id
     *              ID du conseiller
     */
    public void deleteConseiller(Integer id){
        iConseillerDao.deleteById(id);
    }

    /**
     * Récupère le conseiller de la base à mettre à jour
     * @param id
     *              ID du conseiller
     * @return Conseiller
     */
    public ConseillerClientele updateConseiller(Integer id){
        return iConseillerDao.getOne(id);
    }

    /**
     * Met à jour le conseiller dans la base
     * @param conseillerClientele
     *
     */
    public ConseillerClientele valideUpdateConseiller(ConseillerClientele conseillerClientele) {
        return this.iConseillerDao.save(conseillerClientele);
    }

    /*public List<ConseillerClientele> findConseiller(String keyword) {
        List<ConseillerClientele> results = new ArrayList<ConseillerClientele>();
        String[] keywords = keyword.split("[ -]");
        for(String word: keywords) {
            results.addAll(this.iConseillerDao.findByNomContaining(word));
        }
        return results;
    }*/
}
