/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lp2.testes;

import com.br.lp2.dao.ItemDAO;
import com.br.lp2.model.javabeans.Item;
import com.br.lp2.model.javabeans.Produto;

/**
 *
 * @author Bruno
 */
public class ItemTESTE {

    public static void main(String[] args) {
        Item item = new Item();
        Produto produto = new Produto();
        produto.setId_produto(97);
        item.setProduto(produto);
        item.setQtd(2);
        new ItemDAO().insert(item);

    }
}
