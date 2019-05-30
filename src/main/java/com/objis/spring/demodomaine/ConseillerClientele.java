package com.objis.spring.demodomaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

/**
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

    public ConseillerClientele(Integer id, String nom, String prenom, String adresse, Integer codePostal, String ville, Integer telephone, String mail, String login, String password) {
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

    public ConseillerClientele(Integer id, String nom, String prenom, String adresse, Integer codePostal, String ville, Integer telephone, String mail, String login, String password, String listeClients) {
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

    // Get/Set
    /**
     * Methode pour recuperer la variable liste de client
     */
    public String getListeClients() {
        return this.listeClients;
    }

    /**
     * Methode pour attribuer une valeur � la variable liste de client
     */
    public void setListeClients(String listeClients) {
        this.listeClients = listeClients;
    }

    /**
     * Methode toString: donne le nombre et la liste des clients si il y a lieu
     */
    /*public String toString() {

        String message = "Conseiller clientele: [" + this.nom + " " + this.prenom + "]";
        if (!listeClients.isEmpty()) {
            message = message + "\nVous avez " + listeClients.size() + " client(s):";
            for (Client currentClient : listeClients) {
                message = message + "\n" + currentClient.toString();
            }
        } else {
            message = message + "\nVous n'avez aucun client.";
        }
        return message;
    }*/

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
