/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import javax.swing.JFrame;
import vue.GUI;
import modele.ListeContact;
import static io.io_fichiers.chargerListe;
import static io.io_fichiers.construireListe;
import static io.io_fichiers.sauvegarderListe;

/**
 *
 * @author Bernard
 */
public class AppCtr {

    /**
     * @param args the command line arguments
     * AppCtr fait essentiellement les opérations de lancement du programme:
     * charger la liste en mémoire et lancer la construction de l'interface 
     * visuelle.
     */
    public static void main(String[] args) {

        // TODO code application logic here



        //Créer l'interface graphique
        creerGui();

////        Ce bloc d'instructions n'est là que pour construire une liste initiale
////        Il n'est plus nécessaire maintenant, mais je le laisse au cas où 
////        il serait utile à des manipulations futures.
//
//        liste = construireListe();
//        System.out.println(liste);
//        sauvegarderListe(liste);
    }

    public static void creerGui() {

        final int WIDTH = 620, HEIGHT = 275;
        // initialiser frame
        GUI objGui = new GUI();

        // indiquer le titre du frame
        objGui.setTitle("Carnet d'adresses");
        // Donner une taille de la frame pour  affichage
        objGui.setSize(WIDTH , HEIGHT);
        // Afficher la frame et donc le Panel
        objGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        objGui.setLocationRelativeTo(null);
        objGui.setResizable(false);
        objGui.setVisible(true);
    }

}
