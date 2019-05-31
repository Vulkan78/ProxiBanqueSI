package com.objis.spring.service;

import com.objis.spring.demodao.IClientDao;
import com.objis.spring.demodomaine.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Services de la classe Client
 * CRUD
 *
 * @author Jimmy Rakotoson, José-Alexandre Giry
 *
 */
@Service
public class ClientService {

    @Autowired
    private IClientDao iClientDao;

    /**
     * Recupère les clients en base
     * @return Une liste de Clients
     */
    public List<Client> getAll(){
        return iClientDao.findAll();
    }

    /**
     * Injecte le client en base
     * @param newclient
     */
    public void create(Client newclient){
        iClientDao.save(newclient);
    }

    /**
     * Supprime le client de la base
     * @param id
     *              ID du client
     */
    public void deleteClient(Integer id){
        iClientDao.deleteById(id);
    }

    /**
     * Récupère le client de la base à mettre à jour
     * @param id
     *              ID du client
     * @return Client
     */
    public Client updateClient(Integer id){
        return iClientDao.getOne(id);
    }

    /**
     * Met à jour le client dans la base
     * @param client
     *
     */
    public Client valideUpdate(Client client) {
        return this.iClientDao.save(client);
    }

    /*public List<Client> find(String keyword) {
        List<Client> results = new ArrayList<Client>();
        String[] keywords = keyword.split("[ -]");
        for(String word: keywords) {
            results.addAll(this.iClientDao.findByNomContaining(word));
        }
        return results;
    }*/
}


