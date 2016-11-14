/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lp2.testes;

import com.br.lp2.dao.UsuarioDAO;
import com.br.lp2.model.javabeans.Endereco;
import com.br.lp2.model.javabeans.Tipo;
import com.br.lp2.model.javabeans.Usuario;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class UsuarioTESTE {

    public static void main(String[] args) {
        Endereco e = new Endereco();
        e.setBairro("Jardim São Luiz");
        e.setCep("07890-090");
        e.setCidade("Cotia");
        e.setEstado("São Paulo");
        e.setRua("Rua Matos dos Campos");
        Usuario u = new Usuario();
        u.setCpf("45790098512");

        DateFormat df = DateFormat.getDateInstance();

        try {
            u.setDt_nascimento(df.parse("17/02/1997"));
        } catch (ParseException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        u.setEndereco(e);
        u.setNome("Bruno");
        u.setSobrenome("Albuquerque");
        u.setTipo(Tipo.ADM);
        u.setUsuario("brunobrito");
        u.setSenha("senha123");
        System.out.println("Tipo de usuario numericamente: " + u.getTipo().getIntTipo());
        new UsuarioDAO().insert(u);
//        UsuarioDAO dao = new UsuarioDAO();
//
//        for (Usuario u : dao.findAll()) {
//           System.out.println(u);
//        } 

    }
}
