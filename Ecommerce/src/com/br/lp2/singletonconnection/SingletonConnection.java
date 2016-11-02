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
        ResourceBundle bundle = ResourceBundle.getBundle("com.br.lp2.bundle.resourcebundle");
        try {
            Class.forName(bundle.getString("DRIVER"));
            try {
                connection = DriverManager.getConnection(bundle.getString("PROTOCOL")
                    + "://" + bundle.getString("HOST")
                    + "/" + bundle.getString("DATABASE")
                    + ";useUnicode=yes&characterEncoding=UTF-8",
                    bundle.getString("USERNAME"),
                    bundle.getString("PASSWORD"));
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
