/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Comparator;
import modele.Contact;

/**
 *
 * @author Bernard
 */
public class TriPrenom implements Comparator<Contact> {
    @Override
    public int compare(Contact o1, Contact o2) {
        return o1.getPrenom().compareToIgnoreCase(o2.getPrenom());
    }
}