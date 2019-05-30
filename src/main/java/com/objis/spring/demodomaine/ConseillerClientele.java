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
    ArrayList<Client> listeClients;

    static int maxClients = 10;

    /**
     * Initialise un objet ConseillerClientele avec les parametres specifies au moment de l'instantiation
     */
    public ConseillerClientele() {
        super();
        this.listeClients = new ArrayList<Client>();
    }

    /**
     * Initialise un objet ConseillerClientele avec les parametres specifies au moment de l'instantiation
     */
    public ConseillerClientele(String nom, String prenom) {
        super();
        this.prenom = prenom;
        this.nom = nom;
        this.listeClients = new ArrayList<Client>();
    }

    public ConseillerClientele(String nom, String prenom, String login, String password) {
        super();
        this.prenom = prenom;
        this.nom = nom;
        this.login = login;
        this.password = password;
        this.listeClients = new ArrayList<Client>();
    }

    // Get/Set
    /**
     * Methode pour recuperer la variable liste de client
     */
    public ArrayList<Client> getListeClients() {
        return this.listeClients;
    }

    /**
     * Methode pour attribuer une valeur � la variable liste de client
     */
    public void setListeClients(ArrayList<Client> listeClients) {
        this.listeClients = listeClients;
    }

    /**
     * Methode pour recuperer la variable maxClients
     */
    public int getMaxClients() {
        return maxClients;
    }

    /**
     * Methode pour attribuer une valeur � la variable maxclients
     */
    public void setMaxClients(int maxClients) {
        this.maxClients = maxClients;
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
