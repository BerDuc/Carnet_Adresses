/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.util.ArrayList;
import static java.util.Collections.list;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import util.TriNom;
import util.TriNomMil;
import util.TriPrenom;

/**
 *
 * @author Bernard
 * Cette classe crée une liste de contacts compatible avec la JList
 */
public class ListeContact extends DefaultListModel<Contact> { 

    //
    // Constructors
    //
    public ListeContact() {
    }

//methodes  
    
    
    public void trierLC() {

        ArrayList<Contact> liste = new ArrayList();
        for (int i = 0; i < this.size(); i++) {
            liste.add(this.get(i));
        }
        liste.sort(new TriPrenom());
        liste.sort(new TriNomMil());
        liste.sort(new TriNom());
        this.clear();
        for (int j = 0; j < liste.size(); j++) {
            this.addElement(liste.get(j));
        }

    }

    public void creerNouveauContact(String nom, String prenom, String nomMil,
            String tel, String courriel, String add1, String add2, String ville,
            String etat, String zip, String pays) {

        Contact nouveau = new Contact(nom, prenom, nomMil, tel, courriel, add1,
                add2, ville, etat, zip, pays);
        //tester si c'est un doublon
        if (!verifierDoublon(nouveau)) {
            this.addElement(nouveau);
            JOptionPane.showMessageDialog(null, "Le contact a été ajouté à la "
                    + "liste. N'oubliez pas de sauvegarder.", "Confirmation",
                    INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Un contact à ce nom existe déjà.",
                    "Information", INFORMATION_MESSAGE);
        }

    }

    public boolean verifierDoublon(Contact nouveau) {
        boolean doublon = false;
        int i = 0;
        while (i < this.size() && doublon == false) {
            if (this.getElementAt(i).toString().equals(nouveau.toString())) {
                doublon = true;
            }
            i++;

        }
        return doublon;
    }
    
    public int trouverContact(String cherche){
        int i = 0;
        int index= -1;
        while (i<this.size() && index<0){
            if (this.getElementAt(i).toString().toLowerCase().contains(cherche.toLowerCase())){
                index = i;
            }
            i++;
        }        
        return index;
    }
    
    public int trouverContact(String cherche, int debut){
        int i = debut+1;
        int index= -1;
        while (i<this.size() && index<0){
            if (this.getElementAt(i).toString().toLowerCase().contains(cherche.toLowerCase())){
                index = i;
            }
            i++;
        }        
        return index;
    }

}
