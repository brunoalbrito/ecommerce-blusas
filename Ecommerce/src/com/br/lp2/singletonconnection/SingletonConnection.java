/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.singletonconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class SingletonConnection {

    private Connection connection = null;
    private static SingletonConnection instance;

    public SingletonConnection() {
        ResourceBundle rb = ResourceBundle.getBundle("br.com.bundlle.fazer");
        try {
            Class.forName(rb.getString("driver"));
            try {
                connection = DriverManager.getConnection("url");
            } catch (SQLException ex) {
                Logger.getLogger(SingletonConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SingletonConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static SingletonConnection getInstance() {
        if (instance == null) {
            instance = new SingletonConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
