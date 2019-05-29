package com.objis.spring.controller;


import com.objis.spring.demodomaine.Client;
import com.objis.spring.service.ClientService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



/**
 * Created by jimmy on 25/03/2019.
 */
@SpringBootApplication
@Transactional
@Controller
public class AppController {

    @Autowired
    private ClientService clientService;

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

    /*@RequestMapping(method = RequestMethod.POST, path = "/client")
    public String validateForm(Integer id, @RequestParam(nom="nom") String nom, @RequestParam(prenom="prenom") String prenom){
        final Client newClient = new Client(id,nom, prenom, true);
        this.clientService.create(newClient);
        //return this.index();
        return "redirect:/index.html";
    }*/

    @GetMapping("/delete")
    public String delete(Integer id){
        this.clientService.deleteForm(id);
        //return this.index();
        return "redirect:/index.html";
    }

    @GetMapping("/update")
    public ModelAndView update(Integer id){
        ModelAndView mav = new ModelAndView("client");
        Client client = this.clientService.updateForm(id);
        Hibernate.initialize(client);
        mav.addObject("updateForm",client);
        //return this.index();
        return mav;
    }

    @PostMapping("/update")
    public String valideUpdate(Client client){
        this.clientService.valideUpdate(client);
        return "redirect:/index.html";
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

}
