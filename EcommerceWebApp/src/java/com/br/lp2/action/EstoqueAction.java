/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.action;

import com.br.lp2.dao.EstoqueDAO;
import com.br.lp2.model.javabeans.Estoque;

/**
 *
 * @author Bruno
 */
public class EstoqueAction extends ActionSupport {

    public String insert() {
        Estoque estoque = new Estoque();
        estoque.setQtd(Integer.parseInt(getRequest().getParameter("quantidade")));
        boolean result = new EstoqueDAO().insert(estoque);
        return result ? "WEB-INF/jsp/usuario/homeAdmin.jsp" : "erro.jsp";
    }
}
