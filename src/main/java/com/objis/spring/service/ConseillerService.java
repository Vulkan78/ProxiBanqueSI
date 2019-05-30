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
 * @author Jimmy Rakotoson, José-Alexandre Giry
 *
 */

@Service
public class ConseillerService {

    @Autowired
    private IConseillerDao iConseillerDao;

    public List<ConseillerClientele> getAll(){
        return iConseillerDao.findAll();
    }

    public void createConseiller(ConseillerClientele newconseiller){
        iConseillerDao.save(newconseiller);
    }

    public void deleteConseiller(Integer id){
        iConseillerDao.deleteById(id);
    }

    public ConseillerClientele updateConseiller(Integer id){
        return iConseillerDao.getOne(id);
    }

    public ConseillerClientele valideUpdateConseiller(ConseillerClientele conseillerClientele) {
        return this.iConseillerDao.save(conseillerClientele);
    }

    public List<ConseillerClientele> findConseiller(String keyword) {
        List<ConseillerClientele> results = new ArrayList<ConseillerClientele>();
        String[] keywords = keyword.split("[ -]");
        for(String word: keywords) {
            results.addAll(this.iConseillerDao.findByNomContaining(word));
        }
        return results;
    }
}
