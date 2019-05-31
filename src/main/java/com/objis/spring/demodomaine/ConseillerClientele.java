package com.objis.spring.demodomaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

/**
 * Classe ConseillerClientele qui hérite de la classe Personne
 * Le conseiller clientele peut visualiser ses clients, éditer leurs informations ou les supprimer
 * Le conseiller est géré par le gérant via la classe ConseillerService
 * @author Jimmy Rakotoson, José-Alexandre Giry
 *
 */

@Entity
public class ConseillerClientele extends Personne {

    // Attributs
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    public String login;
    public String password;
    public String listeClients;
    /*ArrayList<Client> listeClients;*/

    public ConseillerClientele(Integer id, String nom, String prenom, String adresse, Integer codePostal, String ville, String telephone, String mail, String login, String password) {
        super();
        this.prenom = prenom;
        this.nom = nom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.telephone = telephone;
        this.mail = mail;
        this.login = login;
        this.listeClients = "{1,2}";
        this.password = password;
        /*this.listeClients = new ArrayList<Client>();*/
    }

    public ConseillerClientele(Integer id, String nom, String prenom, String adresse, Integer codePostal, String ville, String telephone, String mail, String login, String password, String listeClients) {
        super();
        this.prenom = prenom;
        this.nom = nom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.telephone = telephone;
        this.mail = mail;
        this.login = login;
        this.listeClients = listeClients;
        this.password = password;
    }

    public ConseillerClientele(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
