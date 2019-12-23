/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import modele.Contact;
import modele.ListeContact;

/**
 *
 * @author Bernard Cette classe contient des méthodes statics pour gérer les
 * fichiers et, dans une moindre mesure, la liste
 */
public class io_fichiers {

    public static void sauvegarderListe(ListeContact liste) {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("contacts.txt"));
            output.writeObject(liste);
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(io_fichiers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(io_fichiers.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Cette methode a été rédigée de manière provisoire pour créer un premier 
    //document liste avec lequel travailler. Elle ne fait plus partie du 
    //fonctionnement, mais je la laisse là au cas où on en aurait besoin 
    //pendant la maintenance
    public static ListeContact construireListe() {
        ListeContact liste = new ListeContact();
        //Constructeur: (String nom, String prenom, String nomMil, String tel, 
//                        String courriel, String adresse1, String adresse2,  
//                        String ville, String etat, String zip, String pays)
        Contact c1 = new Contact("Bunny", "Bugs", "", "514-333-8810",
                "bugs.bunny@gmail.com", "", "",
                "New York", "Caroline", "", "Afghanistan");
        Contact c2 = new Contact("Fudd", "Elmer", "", "514-444-5500",
                "", "", "",
                "Montreal", "Virginie", "", "Lune");
        Contact c3 = new Contact("Library", "Genesis", "", "514-443-3310",
                "courriel@labas.ca", "", "",
                "New York", "Genesis", "", "Russie");
        Contact c4 = new Contact("Library", "Alexandria", "", "514-443-3310",
                "treasure@burned.eg", "", "",
                "Alexandrie", "", "", "Egypte");

        liste.addElement(c1);
        liste.addElement(c2);
        liste.addElement(c3);
        liste.addElement(c4);
        return liste;
    }

    public static ListeContact chargerListe() throws IOException {

        String line, file = "contacts.txt";

        ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
        ListeContact liste = new ListeContact();

        try {
            Object a = in.readObject();

            if (a instanceof ListeContact) {

                liste = (ListeContact) a;
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Fichier non-trouvé");
        } catch (EOFException ex) {

        } finally {
            in.close();
        }

        liste.trierLC();

        return liste;

    }

}
