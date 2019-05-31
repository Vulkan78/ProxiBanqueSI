package com.objis.spring.controller;
import com.objis.spring.demodomaine.Client;
import com.objis.spring.demodomaine.ConseillerClientele;
import com.objis.spring.service.ClientService;
import com.objis.spring.service.ConseillerService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Jimmy Rakotoson, José-Alexandre Giry
 *
 */

@SpringBootApplication
@Transactional
@Controller
public class AppController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ConseillerService conseillerService;

    /**
     * Affiche la page d'authentification
     */
    @RequestMapping({"/", "/login"})
    public ModelAndView login (){
        ModelAndView MAV = new ModelAndView();
        MAV.setViewName("login");
        return MAV;
    }

    /**
     * Affiche la page d'accueil
     */
    @RequestMapping({"/index"})
    public ModelAndView index (){
        ModelAndView MAV = new ModelAndView();
        MAV.setViewName("index");
        return MAV;
    }

    /**
     *  Affiche la liste des clients
     */
    @RequestMapping({"/clients"})
    public ModelAndView clients (){
        ModelAndView MAV = new ModelAndView();
        MAV.setViewName("clients");
        MAV.addObject("clientList",this.clientService.getAll());
        return MAV;
    }

    /**
     * Affiche la page de creation d'un client
     */
    @RequestMapping("/client")
    public ModelAndView showClient(){
        ModelAndView MAV = new ModelAndView();
        MAV.setViewName("client");
        return MAV;
    }

    /**
     *  Affiche le profil du client
     */
    @RequestMapping("/profil_client")
    public ModelAndView updateClient(){
        ModelAndView MAV = new ModelAndView();
        MAV.setViewName("profil_client");
        return MAV;
    }

    /**
     * Valide la création du client et l'injecte dans la base
     */
    @RequestMapping(method = RequestMethod.POST, path = "/client")
    public String validateClient(Integer id, @RequestParam(name="nom") String nom,
                                 @RequestParam(name="prenom") String prenom,
                                 @RequestParam(name="adresse") String adresse,
                                 @RequestParam(name="codePostal") Integer codePostal,
                                 @RequestParam(name="ville") String ville,
                                 @RequestParam(name="telephone") String telephone,
                                 @RequestParam(name="mail") String mail/*,
                                 @RequestParam(name="typePersonne") Boolean typePersonne*/){
        final Client newClient = new Client(id,nom, prenom, adresse, codePostal, ville, telephone, mail/*,typePersonne*/);
        this.clientService.create(newClient);
        //return this.index();
        return "redirect:/clients.html";
    }

    /**
     * Supprime le client de la base
     */
    @GetMapping("/delete")
    public String delete(Integer id){
        this.clientService.deleteClient(id);
        //return this.index();
        return "redirect:/clients.html";
    }

    /**
     * Récupère les informations du client et les affiche dans le profil afin de pouvoir les modifier
     */
    @GetMapping("/update")
    public ModelAndView update(Integer id){
        ModelAndView mav = new ModelAndView("profil_client");
        Client client = this.clientService.updateClient(id);
        Hibernate.initialize(client);
        mav.addObject("updateClient",client);
        //return this.index();
        return mav;
    }

    /**
     * Valide les modifications du profil du client
     */
    @PostMapping("/update")
    public String valideUpdate(Client client){
        this.clientService.valideUpdate(client);
        return "redirect:/clients.html";
    }


    @RequestMapping({"/search"})
    public ModelAndView search (){
        ModelAndView MAV = new ModelAndView();
        MAV.setViewName("search");
        return MAV;
    }

   /* @PostMapping("/search")
    ModelAndView validateSearch(@RequestParam String keyword) {
        final ModelAndView mav = new ModelAndView("search");
        mav.addObject("formationList",
                this.clientService.find(keyword));
        return mav;
    }*/

    /** Conseiller clientèle */

    @RequestMapping("/conseiller")
    public ModelAndView showConseiller(){
        ModelAndView MAV = new ModelAndView();
        MAV.setViewName("conseiller");
        return MAV;
    }

    /**
     *  Affiche la liste des conseillers
     */
    @RequestMapping({"/conseillers"})
    public ModelAndView conseillers (){
        ModelAndView MAV = new ModelAndView();
        MAV.setViewName("conseillers");
        MAV.addObject("conseillerList",this.conseillerService.getAll());
        return MAV;
    }

    /**
     * Valide la création du conseiller et l'injecte dans la base
     */
    @RequestMapping(method = RequestMethod.POST, path = "/conseiller")
    public String validateConseiller(Integer id, @RequestParam(name="nom") String nom,
                                     @RequestParam(name="prenom") String prenom,
                                     @RequestParam(name="adresse") String adresse,
                                     @RequestParam(name="codePostal") Integer codePostal,
                                     @RequestParam(name="ville") String ville,
                                     @RequestParam(name="telephone") String telephone,
                                     @RequestParam(name="mail") String mail,
                                     @RequestParam(name="login") String login,
                                     @RequestParam(name="login") String password){
        final ConseillerClientele newConseiller = new ConseillerClientele (id,nom, prenom, adresse, codePostal, ville, telephone, mail,login, password);
        this.conseillerService.createConseiller(newConseiller);
        //return this.index();
        return "redirect:/conseillers.html";
    }

    /**
     * Récupère les informations du client et les affiche dans le profil afin de pouvoir les modifier
     */
    @GetMapping("/updateConseiller")
    public ModelAndView updateConseiller(Integer id){
        ModelAndView mav = new ModelAndView("conseiller");
        ConseillerClientele conseiller = this.conseillerService.updateConseiller(id);
        Hibernate.initialize(conseiller);
        mav.addObject("updateConseiller",conseiller);
        //return this.index();
        return mav;
    }

    /**
     * Valide les modifications du profil du conseiller
     */
    @PostMapping("/updateConseiller")
    public String valideUpdate(ConseillerClientele conseiller){
        this.conseillerService.valideUpdateConseiller(conseiller);
        return "redirect:/conseillers.html";
    }

    /**
     * Supprime le conseiller de la base
     */
    @GetMapping("/deleteConseiller")
    public String deleteConseiller(Integer id){
        this.conseillerService.deleteConseiller(id);
        //return this.index();
        return "redirect:/conseillers.html";
    }

}
