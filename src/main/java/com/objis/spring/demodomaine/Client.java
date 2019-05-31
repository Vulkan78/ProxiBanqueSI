package com.objis.spring.demodomaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe Client qui hérite de la classe Personne
 * Le client est géré par le conseiller clientele via la classe ClientService
 *
 * @author Jimmy Rakotoson, José-Alexandre Giry
 *
 */

@Entity
public class Client extends Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    /*public Boolean typePersonne;*/
    /*private Boolean fortune;*/

    public Client(Integer id, String nom, String prenom, String adresse, Integer codePostal, String ville, String telephone, String mail/*, Boolean typePersonne*/) {
        super();
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.telephone = telephone;
        this.mail = mail;
        /*this.typePersonne = falsetypePersonne*/;
    }

    public Client() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /*public Boolean getTypePersonne() {
        return typePersonne;
    }

    public void setTypePersonne(Boolean typePersonne) {
        this.typePersonne = typePersonne;
    }*/
}
