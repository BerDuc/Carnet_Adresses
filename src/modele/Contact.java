/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;

/**
 *
 * @author Bernard
 * Cette classe permet la création et modification d'objets contacts
 */
public class Contact implements Serializable {

    //
    // Fields
    //
    private String nom;
    private String prenom;
    private String nomMil;
    private String tel;
    private String courriel;
    private String adresse1;
    private String adresse2;
    private String zip;
    private String ville;
    private String etat;
    private String pays;

    //
    // Constructors
    //
    public Contact() {
    }

    
  
  public Contact(String nom, String prenom, String nomMil, String tel, 
            String courriel, String adresse1, String adresse2,  
            String ville, String etat, String zip, String pays) {
        this.nom = nom;
        this.prenom = prenom;
        this.nomMil = nomMil;
        this.tel = tel;
        this.courriel = courriel;
        this.adresse1 = adresse1;
        this.adresse2 = adresse2;
        this.zip = zip;
        this.ville = ville;
        this.etat = etat;
        this.pays = pays;
    }

//méthodes
    // gets et sets 
  
    @Override
    public String toString() {
        String initiale = "";
        if(nomMil != null && nomMil.length() > 0){
            initiale = nomMil.substring(0, 1)+".";
        }
        return nom + ", " + prenom + " " + initiale;
    }
    
    public static boolean controlMin(String nom, String prenom){
        boolean valide;
        
        valide = !(nom.equals("") || prenom.equals(""));        
        return valide;      
    }
    
    public void setContact(String nom, String prenom, String nomMil, String tel, 
            String courriel, String adresse1, String adresse2,  
            String ville, String etat, String zip, String pays) {
        this.nom = nom;
        this.prenom = prenom;
        this.nomMil = nomMil;
        this.tel = tel;
        this.courriel = courriel;
        this.adresse1 = adresse1;
        this.adresse2 = adresse2;
        this.ville = ville;
        this.zip = zip;
        this.etat = etat;
        this.pays = pays;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNomMil(String nom) {
        this.nomMil = nom;
    }

    public String getNomMil() {
        return nomMil;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel() {
        return tel;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public void setAdresse1(String add1) {
        this.adresse1 = add1;
    }

    public String getAdresse1() {
        return adresse1;
    }

    public void setAdresse2(String add2) {
        adresse2 = add2;
    }

    public String getAdresse2() {
        return adresse2;
    }

    public void setZIP(String zip) {
        this.zip = zip;
    }

    public String getZIP() {
        return zip;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getVille() {
        return ville;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getEtat() {
        return etat;
    }

    private void setPays(String pays) {
        this.pays = pays;
    }

    public String getPays() {
        return pays;
    }

}
