package com.objis.spring.demodomaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by jimmy on 29/05/2019.
 */
@Entity
public class Client extends Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    private Boolean typePersonne;
    /*private Boolean fortune;*/

    public Client(Integer id, String nom, String prenom, Boolean typePersonne) {
        super();
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.typePersonne = typePersonne;
    }

    public Client(Integer id, String nom, String prenom, String adresse, Integer codePostal, String ville, Integer telephone, String mail, Boolean typePersonne) {
        super();
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.telephone = telephone;
        this.mail = mail;
        this.typePersonne = typePersonne;
    }

    public Client() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getTypePersonne() {
        return typePersonne;
    }

    public void setTypePersonne(Boolean typePersonne) {
        this.typePersonne = typePersonne;
    }
}
