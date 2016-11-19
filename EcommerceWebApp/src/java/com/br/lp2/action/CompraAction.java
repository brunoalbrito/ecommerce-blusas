/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.action;

import com.br.lp2.dao.CompraDAO;
import com.br.lp2.dao.ProdutoDAO;
import com.br.lp2.model.javabeans.Compra;
import com.br.lp2.model.javabeans.Item;
import com.br.lp2.model.javabeans.Produto;
import com.br.lp2.model.javabeans.Usuario;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 41583469
 */
public class CompraAction extends ActionSupport {

    public String comprar() {
        System.out.println("Entrou no comprar!");

        List<Produto> produtos = new ProdutoDAO().findAll();
        List<Item> itens = new ArrayList();
        Compra compra = null;
        double total = 0;
        for (Produto produto : produtos) {
            String qtdProduto = getRequest().getParameter(produto.getId_produto() + "");
            int quantidade_produtos = Integer.parseInt(qtdProduto);
            if (quantidade_produtos > 0) {
                total += produto.getPreco();
                Item i = new Item();
                i.setProduto(produto);
                i.setQtd(quantidade_produtos);
                itens.add(i);
            }
        }

        if (!itens.isEmpty()) {
            compra = new Compra();
            compra.setDt_pedido(LocalDateTime.now());
            compra.setItens(itens);
            compra.setTotal(total);
            compra.setUsuario((Usuario) (getRequest().getSession().getAttribute("usuario")));
        }

        if (compra != null) {
            new CompraDAO().insert(compra);
            getRequest().getSession().setAttribute("sucesso", "Sucesso ao efetuar compra.");
            return "WEB-INF/jsp/sucesso.jsp";
        } else {
            getRequest().getSession().setAttribute("error", "Erro ao efetuar compra.");
            return "WEB-INF/jsp/error.jsp";
        }
    }

    public String listarTodos() {
        List<Compra> compras = new ArrayList<>();
        String back = null;
        compras = new CompraDAO().findAll();
        if (!compras.isEmpty()) {
            back = "WEB-INF/jsp/compra/listar.jsp";
        } else {
            back = "error.jsp";
        }
        getRequest().setAttribute("compras", compras);
        return back;
    }
}
