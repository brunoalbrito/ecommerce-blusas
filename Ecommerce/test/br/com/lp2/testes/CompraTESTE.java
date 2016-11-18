/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lp2.testes;

import com.br.lp2.dao.CompraDAO;
import com.br.lp2.dao.EstoqueDAO;
import com.br.lp2.model.javabeans.Compra;
import com.br.lp2.model.javabeans.Estoque;
import com.br.lp2.model.javabeans.Usuario;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class CompraTESTE {
     public static void main(String[] args) {

//        Usuario u = new Usuario();;
//        u.setId_usuario(3);
//
//        Compra compra = new Compra();
//        compra.setUsuario(u);
//        compra.setDt_pedido(LocalDateTime.now());
//        compra.setTotal(200);
//        compra.setEntregue(true);
//        compra.setPagamento(true);
//        
//        List<Compra> c = new CompraDAO().findAll();
//         for (Compra compra1 : c) {
//             System.out.println(compra1);
//         }
         
         Estoque estoque = new Estoque();
         estoque.setQtd(10);
         new EstoqueDAO().insert(estoque);
    }
}
