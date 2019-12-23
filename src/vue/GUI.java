/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import static io.io_fichiers.chargerListe;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import static modele.Contact.controlMin;
import modele.ListeContact;
import static io.io_fichiers.sauvegarderListe;
import java.io.IOException;

/**
 *
 * @author Bernard
 */
public class GUI extends JFrame {

    //
    // Fields
    //
    private JList lstContacts;
    private JPanel pan1;
    private JPanel pan2;
    private JPanel pan3;
    private JPanel pan4;
    private JPanel pan5;
    private JPanel pan6;
    private JPanel pan7;
    private JPanel panButton, panCentre, panCN, panCC, panCS;
    private JScrollPane panListe;
    private JButton btnNouveau;
    private JButton btnSupprimer;
    private JButton btnRechercher;
    private JButton btnModifier;
    private JButton btnSauvegarder;
    private JButton btnCancel;
    private JLabel lblNom;
    private JTextField txtNom;
    private JLabel lblPrenom;
    private JTextField txtPrenom;
    private JLabel lblNomMilieu;
    private JTextField txtNomMilieu;
    private JLabel lblTelephone;
    private JTextField txtTelephone;
    private JLabel lblCourriel;
    private JTextField txtCourriel;
    private JLabel lblAdresse1;
    private JTextField txtAdresse1;
    private JLabel lblAdresse2;
    private JTextField txtAdresse2;
    private JLabel lblVille;
    private JTextField txtVille;
    private JLabel lblEtat;
    private JTextField txtEtat;
    private JLabel lblPays;
    private JTextField txtPays;
    private JLabel lblZip;
    private JTextField txtZip;

    private ListeContact liste;
    //
    // Constructors
    //
    public GUI() {

        try {
            liste = chargerListe();
        } catch (IOException ex) {
            liste = new ListeContact();
        }
        initComposants();
        initPanels();
        setListeners();
    }

    // Other methods
    //
    /**
     */
    public void initComposants() {

        // initialisation des boutons
        btnNouveau = new JButton("Nouveau");
        btnSupprimer = new JButton("Supprimer");
        btnRechercher = new JButton("Rechercher");
        btnModifier = new JButton("Modifier");
        btnSauvegarder = new JButton("Sauvegarder");
        btnCancel = new JButton("Cancel");

        //initialiser la liste de contacts
        lstContacts = new JList(liste);
        lstContacts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

//initialiser les labels et les textfields
        //panel1
        lblNom = new JLabel("Nom            ");
        txtNom = new JTextField(8);
        lblPrenom = new JLabel("Prenom  ");
        txtPrenom = new JTextField(7);
        lblNomMilieu = new JLabel("Nom du milieu ");
        txtNomMilieu = new JTextField(6);

        //panel2
        lblTelephone = new JLabel("Téléphone ");
        txtTelephone = new JTextField(8);
        lblCourriel = new JLabel("Courriel ");
        txtCourriel = new JTextField(22);

        //panel3
        lblAdresse1 = new JLabel("Adresse 1 ");
        txtAdresse1 = new JTextField(36);

        //panel4
        lblAdresse2 = new JLabel("Adresse 2 ");
        txtAdresse2 = new JTextField(36);
        //panel5
        lblVille = new JLabel("Ville            ");
        txtVille = new JTextField(15);

        //panel6
        lblEtat = new JLabel("Province   ");
        txtEtat = new JTextField(15);
        lblZip = new JLabel("               ZIP ");
        txtZip = new JTextField(6);

        //panel7
        lblPays = new JLabel("Pays          ");
        txtPays = new JTextField(15);

    }

    public void initPanels() {
        // Panel des boutons
        panButton = new JPanel();
        // ajouter les boutons au panel
        panButton.add(btnNouveau);
        panButton.add(btnSupprimer);
        panButton.add(btnModifier);
        panButton.add(btnSauvegarder);
        panButton.add(btnCancel);
        panButton.add(btnRechercher);
        // ajouter les boutons dans le bas du BorderLayout
        this.add(panButton, BorderLayout.SOUTH);

        //ajouter la liste dans un scroll panel
        panListe = new JScrollPane(lstContacts);
        //ajouter le panel liste dans le BorderLayout
        this.add(panListe, BorderLayout.WEST);

        //panels 1 à 7
        pan1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pan1.add(lblNom);
        pan1.add(txtNom);
        pan1.add(lblPrenom);
        pan1.add(txtPrenom);
        pan1.add(lblNomMilieu);
        pan1.add(txtNomMilieu);

        pan2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pan2.add(lblTelephone);
        pan2.add(txtTelephone);
        pan2.add(lblCourriel);
        pan2.add(txtCourriel);

        pan3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pan3.add(lblAdresse1);
        pan3.add(txtAdresse1);

        pan4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pan4.add(lblAdresse2);
        pan4.add(txtAdresse2);

        pan5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pan5.add(lblVille);
        pan5.add(txtVille);

        pan6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pan6.add(lblEtat);
        pan6.add(txtEtat);
        pan6.add(lblZip);
        pan6.add(txtZip);

        pan7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pan7.add(lblPays);
        pan7.add(txtPays);

        //ajouter les panels au centre
        //la partie du haut
        panCN = new JPanel(new BorderLayout());
        panCN.add(pan1, BorderLayout.NORTH);
        panCN.add(pan2, BorderLayout.CENTER);
        //la partie du centre
        panCC = new JPanel(new BorderLayout());
        panCC.add(pan3, BorderLayout.NORTH);
        panCC.add(pan4, BorderLayout.CENTER);
        panCC.add(pan5, BorderLayout.SOUTH);
        //la partie du bas
        panCS = new JPanel(new BorderLayout());
        panCS.add(pan6, BorderLayout.NORTH);
        panCS.add(pan7, BorderLayout.SOUTH);
        //maintenant tous au centre
        panCentre = new JPanel(new BorderLayout());
        panCentre.add(panCN, BorderLayout.NORTH);
        panCentre.add(panCC, BorderLayout.CENTER);
        panCentre.add(panCS, BorderLayout.SOUTH);

        //ajouter le panel central au centre du BorderLayout principal
        this.add(panCentre, BorderLayout.CENTER);

    }

    /**
     */
    public void setListeners() {

        //le Listener de la JList
        lstContacts.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent clic) {
                //changer les JTextField pour aller chercher les valeurs correspondantes

                if (!clic.getValueIsAdjusting()) {
                    int i = lstContacts.getSelectedIndex();

                    txtNom.setText(liste.get(i).getNom());
                    txtPrenom.setText(liste.get(i).getPrenom());
                    txtNomMilieu.setText(liste.get(i).getNomMil());
                    txtTelephone.setText(liste.get(i).getTel());
                    txtCourriel.setText(liste.get(i).getCourriel());
                    txtAdresse1.setText(liste.get(i).getAdresse1());
                    txtAdresse2.setText(liste.get(i).getAdresse2());
                    txtVille.setText(liste.get(i).getVille());
                    txtZip.setText(liste.get(i).getZIP());
                    txtEtat.setText(liste.get(i).getEtat());
                    txtPays.setText(liste.get(i).getPays());
                }
            }

        });

        //Bouton "Nouveau"
        btnNouveau.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                //demander confirmation
                int option = JOptionPane.showConfirmDialog(null, "Voulez-vous "
                        + "ajouter ces informations dans un nouveau contact?",
                        "Ajouter un nouveau contact", YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    //créer un nouveau contact
                    //attention, les nouveaux éléments n'apparaîtront triés que lorsque
                    //l'application sera redémarrée.
                    //le tri immédiat de la liste déclenche une exception dans le listener de la liste
                    //ce problème s'est posé dans "Supprimer" et la solution était de changer la position
                    //de l'élément sélectionné, mais le problème est plus difficile à gérer 
                    //quand c'est toute la liste qui change

                    if (controlMin(txtNom.getText(), txtPrenom.getText())) {
                        liste.creerNouveauContact(txtNom.getText(), txtPrenom.getText(),
                                txtNomMilieu.getText(), txtTelephone.getText(),
                                txtCourriel.getText(), txtAdresse1.getText(),
                                txtAdresse2.getText(), txtVille.getText(), txtEtat.getText(),
                                txtZip.getText(), txtPays.getText());
                    } else {
                        JOptionPane.showMessageDialog(null, "Votre contact doit "
                                + "obligatoirement avoir un nom et un prénom.", "",
                                INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Le contact n'a pas été "
                            + "ajouté.", "", INFORMATION_MESSAGE);
                }

            }
        });

        //Bouton "Supprimer"
        btnSupprimer.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Souhaitez-vous "
                        + "vraiment supprimer ce contact?",
                        "Supprimer un contact", YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {

                    int a = lstContacts.getSelectedIndex();
                    if (a > -1) {
                        if (a < liste.size() - 1) {
                            lstContacts.setSelectedIndex(a + 1);
                        } else {
                            lstContacts.setSelectedIndex(a - 1);
                        }
//                        listeGUI.remove(a);
                        liste.remove(a);
                        viderFormulaire();

                        JOptionPane.showMessageDialog(null, "Le contact a été supprimé de la "
                                + "liste. Sauvegardez pour rendre le changement permanent.", "Confirmation",
                                INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Le contact n'a pas été supprimé.",
                            "Confirmation", INFORMATION_MESSAGE);
                }
            }
        });

        //Bouton "Modifier"
        btnModifier.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Souhaitez-vous "
                        + "vraiment modifier ce contact?",
                        "Modifier un contact", YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    //vérifier que le contact a un nom et un prénom.
                    if (controlMin(txtNom.getText(), txtPrenom.getText())) {
                        //prendre l'index de la sélection et modifier le contact correspondant
                        int a = lstContacts.getSelectedIndex();
                        if (a > -1) {
                            liste.get(a).setContact(txtNom.getText(), txtPrenom.getText(),
                                    txtNomMilieu.getText(), txtTelephone.getText(),
                                    txtCourriel.getText(), txtAdresse1.getText(),
                                    txtAdresse2.getText(), txtVille.getText(), txtEtat.getText(),
                                    txtZip.getText(), txtPays.getText());
                            JOptionPane.showMessageDialog(null, "Le contact a été modifié."
                                    + "Sauvegardez pour rendre le changement permanent.",
                                    "Confirmation", INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Votre contact doit "
                                + "obligatoirement avoir un nom et un prénom.", "",
                                INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Le contact n'a pas été modifié.",
                            "Confirmation", INFORMATION_MESSAGE);
                }

            }
        }
        );

        //Bouton "Sauvegarder"
        btnSauvegarder.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e
            ) {
                int option = JOptionPane.showConfirmDialog(null, "Souhaitez-vous "
                        + "sauvegarder toutes les modifications à la liste?",
                        "Modifier un contact", YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    sauvegarderListe(liste);

                    JOptionPane.showMessageDialog(null, "Vos changements ont été "
                            + "sauvegardés.", "Confirmation",
                            INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, "Aucun changement "
                            + "effectué", "Confirmation",
                            INFORMATION_MESSAGE);
                }
            }
        }
        );
        //Bouton "Cancel"
        btnCancel.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                viderFormulaire();
            }
        }
        );

        //Bouton "Rechercher"
        btnRechercher.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                String recherche;
                int index, option;

                recherche = JOptionPane.showInputDialog(null, "Entrez le nom que "
                        + "vous cherchez", "Recherche", QUESTION_MESSAGE);
                index = liste.trouverContact(recherche);

                do {
                    if (index < 0) {
                        JOptionPane.showMessageDialog(null, "Aucun contact "
                                + "correspondant n'a été trouvé", "Confirmation",
                                INFORMATION_MESSAGE);
                        option = JOptionPane.NO_OPTION;
                    } else {
                        lstContacts.setSelectedIndex(index);
                        option = JOptionPane.showConfirmDialog(null, "Ce contact correspond à votre recherche. "
                                + "Souhaitez-vous poursuivre?", "Confirmation",
                                YES_NO_OPTION);
                        index = liste.trouverContact(recherche, index);
                    }
                } while (option == JOptionPane.YES_OPTION);
            }
        }
        );
    }

//on pourrait sans doute le faire direcement dans la méthode actionPerformed
//du bouton "cancel", mais en la mettant dans une méthode à part, on se permet
//de la réutiliser si on veut ajouter des fonctions au programme
    private void viderFormulaire() {
        txtNom.setText(null);
        txtPrenom.setText(null);
        txtNomMilieu.setText(null);
        txtTelephone.setText(null);
        txtCourriel.setText(null);
        txtAdresse1.setText(null);
        txtAdresse2.setText(null);
        txtVille.setText(null);
        txtEtat.setText(null);
        txtZip.setText(null);
        txtPays.setText(null);

    }
}
