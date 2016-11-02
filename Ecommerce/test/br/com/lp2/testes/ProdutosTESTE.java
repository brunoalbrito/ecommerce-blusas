/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lp2.testes;

import com.br.lp2.dao.ProdutoDAO;
import com.br.lp2.model.javabeans.Produto;

/**
 *
 * @author Bruno
 */
public class ProdutosTESTE {
    public static void main(String[] args) {
        Produto produto = new Produto();
        produto.setCor("Vinho");
        produto.setPreco(111.50);
        produto.setTamanho('P');
        produto.setDescricao("Blusão");
        ProdutoDAO dAO = new ProdutoDAO();
        dAO.insert(produto);
    }
}
