/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.bundle;

import com.br.lp2.singletonconnection.SingletonConnection;
import java.sql.Connection;
import java.util.ResourceBundle;

/**
 *
 * @author 41583469
 */
public class Teste {
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("com.br.lp2.boundle.resourceboundle");
        System.out.println(bundle.getString("DRIVER"));
        Connection connection = SingletonConnection.getInstance().getConnection();
        
        System.out.println("Teste de linhas sobrescritas");
    }
}
