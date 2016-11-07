/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.boundle;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 41583469
 */
public class NewClass {

    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle("com.br.lp2.boundle.actionConfig");
        try {
            Class c =  Class.forName(rb.getString("compra"));
            System.out.println(c.getName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
