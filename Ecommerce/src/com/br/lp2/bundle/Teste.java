/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.bundle;

import com.br.lp2.model.javabeans.Compra;
import com.br.lp2.singletonconnection.SingletonConnection;
import java.sql.Connection;

/**
 *
 * @author 41583469
 */
public class Teste {

    public static void main(String[] args) {
        Connection connection = SingletonConnection.getInstance().getConnection();

    }
}
