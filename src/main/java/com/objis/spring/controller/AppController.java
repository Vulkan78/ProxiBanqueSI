package com.objis.spring.controller;
import com.objis.spring.demodomaine.Client;
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

    @RequestMapping({"/", "/index"})
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

    @RequestMapping(method = RequestMethod.POST, path = "/client")
    public String validateClient(Integer id, @RequestParam(name="nom") String nom, @RequestParam(name="prenom") String prenom){
        final Client newClient = new Client(id,nom, prenom, true);
        this.clientService.create(newClient);
        //return this.index();
        return "redirect:/clients.html";
    }

    @GetMapping("/delete")
    public String delete(Integer id){
        this.clientService.deleteClient(id);
        //return this.index();
        return "redirect:/index.html";
    }

    @GetMapping("/update")
    public ModelAndView update(Integer id){
        ModelAndView mav = new ModelAndView("client");
        Client client = this.clientService.updateClient(id);
        Hibernate.initialize(client);
        mav.addObject("updateForm",client);
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

    @RequestMapping({"/conseillers"})
    public ModelAndView conseillers (){
        ModelAndView MAV = new ModelAndView();
        MAV.setViewName("conseillers");
        MAV.addObject("conseillerList",this.conseillerService.getAll());
        return MAV;
    }

}
