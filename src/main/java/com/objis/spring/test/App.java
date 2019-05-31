package com.objis.spring.test;
import com.objis.spring.demodao.IClientDao;
import com.objis.spring.demodomaine.Client;
import com.objis.spring.service.ClientService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public ClientService clientService = new ClientService();
    private IClientDao springDao;
    public Client client;
    private ClassPathXmlApplicationContext appContext;

    /**
     *
     *  Methode qui instancie un client
     *
     */
    @Before
    public void setUp() throws Exception {
        client = new Client(1, "testnom","testprenom", "testadresse", 78000, "testville", "0600007867", "testmail"/*,true*/);
        appContext = new ClassPathXmlApplicationContext("src/main/webapp/WEB-INF/application-servlet.xml");
        springDao = (IClientDao) appContext.getBean("IClientDao");
    }

    /**
     * Injection du client en base
     */
    @Test
    public void createClient() {
        clientService.create(client);
        System.out.println("Client ajouté en base : " + client.toString());
    }

    /**
     * Modification du client en base
     */
    @Test
    public void updateClient() {
        client.setNom("testUpdate");
        clientService.valideUpdate(client);
        System.out.println("Client modifié en base : " + client.toString());
    }

    /**
     * Suppression du client en base
     */
    @Test
    public void deleteClient() {
        Integer id = client.getId();
        clientService.deleteClient(id);
        System.out.println("Client supprimé en base.");
    }
}

