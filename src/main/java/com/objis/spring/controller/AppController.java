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

    @RequestMapping({"/", "/login"})
    public ModelAndView login (){
        ModelAndView MAV = new ModelAndView();
        MAV.setViewName("login");
        return MAV;
    }

    @RequestMapping({"/index"})
    public ModelAndView index (){
        ModelAndView MAV = new ModelAndView();
        MAV.setViewName("index");
        return MAV;
    }

    @RequestMapping({"/clients"})
    public ModelAndView clients (){
        ModelAndView MAV = new ModelAndView();
        MAV.setViewName("clients");
        MAV.addObject("clientList",this.clientService.getAll());
        return MAV;
    }

    @RequestMapping("/client")
    public ModelAndView showClient(){
        ModelAndView MAV = new ModelAndView();
        MAV.setViewName("client");
        return MAV;
    }

    @RequestMapping("/profil_client")
    public ModelAndView updateClient(){
        ModelAndView MAV = new ModelAndView();
        MAV.setViewName("profil_client");
        return MAV;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/client")
    public String validateClient(Integer id, @RequestParam(name="nom") String nom,
                                 @RequestParam(name="prenom") String prenom,
                                 @RequestParam(name="adresse") String adresse,
                                 @RequestParam(name="codePostal") Integer codePostal,
                                 @RequestParam(name="ville") String ville,
                                 @RequestParam(name="telephone") Integer telephone,
                                 @RequestParam(name="mail") String mail/*,
                                 @RequestParam(name="typePersonne") Boolean typePersonne*/){
        final Client newClient = new Client(id,nom, prenom, adresse, codePostal, ville, telephone, mail/*,typePersonne*/);
        this.clientService.create(newClient);
        //return this.index();
        return "redirect:/clients.html";
    }

    @GetMapping("/delete")
    public String delete(Integer id){
        this.clientService.deleteClient(id);
        //return this.index();
        return "redirect:/clients.html";
    }

    @GetMapping("/update")
    public ModelAndView update(Integer id){
        ModelAndView mav = new ModelAndView("profil_client");
        Client client = this.clientService.updateClient(id);
        Hibernate.initialize(client);
        mav.addObject("updateClient",client);
        //return this.index();
        return mav;
    }

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

    @PostMapping("/search")
    ModelAndView validateSearch(@RequestParam String keyword) {
        final ModelAndView mav = new ModelAndView("search");
        mav.addObject("formationList",
                this.clientService.find(keyword));
        return mav;
    }

    /* Conseiller clientèle */

    @RequestMapping("/conseiller")
    public ModelAndView showConseiller(){
        ModelAndView MAV = new ModelAndView();
        MAV.setViewName("conseiller");
        return MAV;
    }

    @RequestMapping({"/conseillers"})
    public ModelAndView conseillers (){
        ModelAndView MAV = new ModelAndView();
        MAV.setViewName("conseillers");
        MAV.addObject("conseillerList",this.conseillerService.getAll());
        return MAV;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/conseiller")
    public String validateConseiller(Integer id, @RequestParam(name="nom") String nom,
                                     @RequestParam(name="prenom") String prenom,
                                     @RequestParam(name="adresse") String adresse,
                                     @RequestParam(name="codePostal") Integer codePostal,
                                     @RequestParam(name="ville") String ville,
                                     @RequestParam(name="telephone") Integer telephone,
                                     @RequestParam(name="mail") String mail,
                                     @RequestParam(name="login") String login,
                                     @RequestParam(name="login") String password){
        final ConseillerClientele newConseiller = new ConseillerClientele (id,nom, prenom, adresse, codePostal, ville, telephone, mail,login, password);
        this.conseillerService.createConseiller(newConseiller);
        //return this.index();
        return "redirect:/conseillers.html";
    }

    @GetMapping("/updateConseiller")
    public ModelAndView updateConseiller(Integer id){
        ModelAndView mav = new ModelAndView("conseiller");
        ConseillerClientele conseiller = this.conseillerService.updateConseiller(id);
        Hibernate.initialize(conseiller);
        mav.addObject("updateConseiller",conseiller);
        //return this.index();
        return mav;
    }

    @PostMapping("/updateConseiller")
    public String valideUpdate(ConseillerClientele conseiller){
        this.conseillerService.valideUpdateConseiller(conseiller);
        return "redirect:/conseillers.html";
    }

    @GetMapping("/deleteConseiller")
    public String deleteConseiller(Integer id){
        this.conseillerService.deleteConseiller(id);
        //return this.index();
        return "redirect:/conseillers.html";
    }

}
