/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.action;

import com.br.lp2.dao.ImagemDAO;
import com.br.lp2.dao.ProdutoDAO;
import com.br.lp2.model.javabeans.Imagem;
import com.br.lp2.model.javabeans.Produto;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Part;

/**
 *
 * @author 41583469
 */
public class ProdutoAction extends ActionSupport {

    public String insert() {
        String back = null;
        try {
            Produto produto = new Produto();
            produto.setCor(this.getRequest().getParameter("cor"));
            produto.setDescricao(this.getRequest().getParameter("descricao"));
            produto.setPreco(Double.parseDouble(this.getRequest().getParameter("preco")));
            produto.setTamanho(this.getRequest().getParameter("tamanho").charAt(0));
            Part part = this.getRequest().getPart("imagem");
            byte[] buffer;
            try (InputStream inputStream = part.getInputStream()) {
                buffer = new byte[inputStream.available()];
                inputStream.read(buffer);
            }
            Imagem imagem = new Imagem();
            imagem.setConteudo(buffer);

            try {
                long respProd = new ProdutoDAO().insertReturnID(produto);
                imagem.setId_produto(respProd);
                Boolean respImg = new ImagemDAO().insert(imagem);
                if (respProd != 0 && respImg == true) {
                    back = "WEB-INF/jsp/produto/inserido.jsp";
                } else {
                    back = "erro";
                }
            } catch (Exception e) {
                Logger.getLogger(ProdutoAction.class.getName()).log(Level.SEVERE, null, e);
            }
            this.getRequest().setAttribute("produto", produto);
        } catch (Exception e) {
            Logger.getLogger(ProdutoAction.class.getName()).log(Level.SEVERE, null, e);
        }

        return back;
    }

    public String listarTodos() {
        String back = null;
        try {
            List<Produto> produtos = new ProdutoDAO().findAll();
            if (!produtos.isEmpty()) {
                back = "WEB-INF/jsp/produto/listar.jsp";
            } else {
                back = "error.jsp";
            }
            this.getRequest().setAttribute("produtos", produtos);
        } catch (Exception e) {
            Logger.getLogger(ProdutoAction.class.getName()).log(Level.SEVERE, null, e);
        }
        return back;
    }

    public String editar() {
        String back = null;
        try {
            Long id = Long.parseLong(this.getRequest().getParameter("id"));
            System.out.println(id);
            Produto produto = new ProdutoDAO().findById(id);
            if (produto.getCor() != null) {
                back = "WEB-INF/jsp/produto/editar.jsp";
            } else {
                back = "erro";
            }
            this.getRequest().setAttribute("produto", produto);
        } catch (Exception e) {
            Logger.getLogger(ProdutoAction.class.getName()).log(Level.SEVERE, null, e);
        }
        return back;
    }

    public String alterar() {
        String back = "erro";
        try {
            Produto produto = new Produto();
            produto.setId_produto(Long.parseLong(this.getRequest().getParameter("id_produto")));
            produto.setCor(this.getRequest().getParameter("cor"));
            produto.setDescricao(this.getRequest().getParameter("descricao"));
            produto.setPreco(Double.parseDouble(this.getRequest().getParameter("preco")));
            produto.setTamanho(this.getRequest().getParameter("tamanho").charAt(0));
            new ProdutoDAO().modify(produto);
            back = "index.jsp";
        } catch (Exception e) {
            Logger.getLogger(ProdutoAction.class.getName()).log(Level.SEVERE, null, e);
        }
        return back;
    }

    public String remover() {
        String back = "erro";
        System.out.println("Passou aqui");
        try {
            Produto produto = new Produto();
            produto.setId_produto(Long.parseLong(this.getRequest().getParameter("id_produto")));
            new ProdutoDAO().remove(produto);
            back = "WEB-INF/jsp/usuario/homeAdmin.jsp";
        } catch (Exception e) {
            Logger.getLogger(ProdutoAction.class.getName()).log(Level.SEVERE, null, e);
        }
        return back;
    }

    public String showHome() {
        String back = null;
        try {
            List<Produto> produtos = new ProdutoDAO().findAll();
            if (!produtos.isEmpty()) {
                back = "home.jsp";
            } else {
                back = "error.jsp";
            }
            this.getRequest().setAttribute("produtos", produtos);
        } catch (Exception e) {
            Logger.getLogger(ProdutoAction.class.getName()).log(Level.SEVERE, null, e);
        }
        return back;
    }
}
