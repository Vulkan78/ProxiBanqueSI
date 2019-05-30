package com.objis.spring.service;

import com.objis.spring.demodao.IClientDao;
import com.objis.spring.demodomaine.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jimmy on 25/03/2019.
 */
@Service
public class ClientService {

    @Autowired
    private IClientDao iClientDao;

    public List<Client> getAll(){
        return iClientDao.findAll();
    }

    public void create(Client newclient){
        iClientDao.save(newclient);
    }

    public void deleteClient(Integer id){
        iClientDao.deleteById(id);
    }

    public Client updateClient(Integer id){
        return iClientDao.getOne(id);
    }

    public Client valideUpdate(Client client) {
        return this.iClientDao.save(client);
    }

    public List<Client> find(String keyword) {
        List<Client> results = new ArrayList<Client>();
        String[] keywords = keyword.split("[ -]");
        for(String word: keywords) {
            results.addAll(this.iClientDao.findByNomContaining(word));
        }
        return results;
    }
}


