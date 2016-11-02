package com.br.lp2.bundle;

import com.br.lp2.singletonconnection.SingletonConnection;
import java.sql.Connection;

/**
 *
 * @author 41583469
 */
public class Teste {
 /**
  * 
  * It's just a test to connnection
  * @param args
  */
    public static void main(String[] args) {
        Connection connection = SingletonConnection.getInstance().getConnection();
    }
}
