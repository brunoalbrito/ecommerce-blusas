/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.bundle;

import com.br.lp2.dao.EstoqueDAO;
import com.br.lp2.model.javabeans.Estoque;
import com.br.lp2.model.javabeans.Produto;
import java.util.List;

/**
 *
 * @author 41583469
 */
public class Teste {

    public static void main(String[] args) {
//        Estoque estoque = new Estoque();
//        Produto produto = new Produto();
//        produto.setId_produto(1);
//        estoque.setProduto(produto);
//        estoque.setQtd(10);
        EstoqueDAO dAO = new EstoqueDAO();
        List<Estoque> estoques = dAO.findAll();
        for (Estoque e : estoques) {
            System.out.println(e);
        }
    }
}
