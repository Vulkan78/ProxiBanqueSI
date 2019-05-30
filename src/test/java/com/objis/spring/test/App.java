package com.objis.spring.test;

import com.objis.spring.demodao.IClientDao;
import com.objis.spring.demodomaine.Client;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {

    private Client client;
    private IClientDao springDao;
    private ClassPathXmlApplicationContext appContext;

    /**
     * Initialisation du contexte Spring et du bean du Dao.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        client = new Client(1, "testnom","testprenom", true);
        appContext = new ClassPathXmlApplicationContext("src/main/webapp/WEB-INF/application-servlet.xml");
        springDao = (IClientDao) appContext.getBean("IClientDao");
    }

    /**
     * Sauvegarde du bean par l’interface Repository de Spring Data
     */
    @Test
    public void saveClient() {
        Client result = springDao.save(client);
        System.out.println("Formation ajoutée en base : " + result.toString());
    }
}

