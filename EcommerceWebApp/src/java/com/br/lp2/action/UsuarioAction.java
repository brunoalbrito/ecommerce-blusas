/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.action;

import com.br.lp2.dao.CompraDAO;
import com.br.lp2.dao.EstoqueDAO;
import com.br.lp2.dao.ItemDAO;
import com.br.lp2.dao.ProdutoDAO;
import com.br.lp2.dao.UsuarioDAO;
import com.br.lp2.model.javabeans.Compra;
import com.br.lp2.model.javabeans.Endereco;
import com.br.lp2.model.javabeans.Estoque;
import com.br.lp2.model.javabeans.Item;
import com.br.lp2.model.javabeans.Produto;
import com.br.lp2.model.javabeans.Tipo;
import com.br.lp2.model.javabeans.Usuario;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Beatriz
 */
public class UsuarioAction extends ActionSupport {

    public String insert() {
        String back = null;
        try {

            Usuario usuario = new Usuario();
            usuario.setNome(getRequest().getParameter("nome"));
            usuario.setSobrenome(getRequest().getParameter("sobrenome"));
            usuario.setCpf(getRequest().getParameter("cpf"));
            usuario.setUsuario(getRequest().getParameter("usuario"));
            usuario.setSenha(getRequest().getParameter("senha"));
            usuario.setTipo(Tipo.values()[Integer.parseInt(getRequest().getParameter("tipo"))]);
            usuario.setDt_nascimento(new SimpleDateFormat("yyyy-MM-dd").parse(getRequest().getParameter("dt_nascimento")));

            Endereco endereco = new Endereco();
            endereco.setBairro(getRequest().getParameter("bairro"));
            endereco.setCep(getRequest().getParameter("cep"));
            endereco.setCidade(getRequest().getParameter("cidade"));
            endereco.setEstado(getRequest().getParameter("estado"));
            endereco.setRua(getRequest().getParameter("rua"));

            usuario.setEndereco(endereco);

            System.out.println("Usuário criado: " + usuario);

            boolean result = new UsuarioDAO().insert(usuario);

            System.out.println("Usuário persistido: " + usuario);

            if (result) {
                getRequest().getSession().setAttribute("usuario", usuario);
                back = (usuario.getTipo().getIntTipo() == 0 ? "WEB-INF/jsp/usuario/homeAdmin.jsp" : "WEB-INF/jsp/usuario/homeUser.jsp");
            } else {
                back = "erro.jsp";
            }
        } catch (Exception e) {
            Logger.getLogger(UsuarioAction.class.getName()).log(Level.SEVERE, null, e);
        }
        return back;
    }

    public String doLogin() {
        String retorno = null;
        String username = getRequest().getParameter("usuario");
        String password = getRequest().getParameter("senha");

        Usuario usuario = new UsuarioDAO().findByUsername(username);

        if (usuario == null) {
            getRequest().getSession().setAttribute("error", "User not found");
        } else if (password.equals(usuario.getSenha())) {
            String remember = getRequest().getParameter("remember");

            Cookie c1 = new Cookie("username", username);

            if (remember != null) {
                c1.setMaxAge(60 * 60 * 24 * 7);
            } else {
                c1.setMaxAge(0);
            }

            getResponse().addCookie(c1);
            getRequest().getSession().setAttribute("usuario", usuario);

            retorno = goToHome();

        } else {
            getRequest().getSession().setAttribute("error", "Wrong Password!");
        }
        return retorno;

    }

    public String doLogout() {
        Cookie c = new Cookie("username", null);
        c.setMaxAge(0);
        getResponse().addCookie(c);
        getRequest().getSession().invalidate();
        return "index.jsp";
    }

    public String goToSignUp() {
        getRequest().setAttribute("tipoUsuarios", Tipo.values());
//        getRequest().getRequestDispatcher("ususario/cadastrousuario.jsp");
        System.out.println("Chegou!");
        return "WEB-INF/jsp/usuario/cadastrarusuario.jsp";
    }

    public String goToHome() {
        String retorno = null;

        Usuario usuario = (Usuario) getRequest().getSession().getAttribute("usuario");
        if (usuario.getTipo().getIntTipo() == 0) {
            retorno = "WEB-INF/jsp/usuario/homeAdmin.jsp";
        } else {
            getRequest().getSession().setAttribute("produtos", new ProdutoDAO().findAll());
            retorno = "WEB-INF/jsp/usuario/homeUser.jsp";
        }

        return retorno;
    }

    public String goToCompras() {
        String retorno = null;
        HttpSession session = getRequest().getSession();
        CompraDAO daoCompra = new CompraDAO();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario.getTipo().getIntTipo() == 0) {
            session.setAttribute("compras", daoCompra.findAll());
            retorno = "WEB-INF/jsp/compra/listar.jsp";
        } else {
            session.setAttribute("compras", daoCompra.findByUser(usuario));
            retorno = "WEB-INF/jsp/usuario/comprasUsuario.jsp";
        }
        return retorno;
    }

    public String comprar() {
        String retorno = null;
        HttpSession session = getRequest().getSession();
        List<Item> itens = new ArrayList<Item>();
        EstoqueDAO daoEstoque = new EstoqueDAO();
        ItemDAO daoItem = new ItemDAO();
        CompraDAO daoCompra = new CompraDAO();
        double totalCompra = 0;
        boolean pagamento = false;
        boolean entregue = false;
        
        Compra compra = new Compra();
        compra.setUsuario((Usuario)getRequest().getSession().getAttribute("usuario"));
        compra.setDt_pedido(LocalDateTime.now());
        compra.setPagamento(pagamento);
        compra.setEntregue(entregue);

        List<Produto> produtos = (List<Produto>) session.getAttribute("produtos");
        for (Produto produto : produtos) {
            String qtd = getRequest().getParameter(produto.getId_produto() + "");
            int intQtd = Integer.parseInt(qtd);
            if (intQtd > 0) {
                Item item = new Item();
                item.setProduto(produto);
                item.setQtd(intQtd);
                itens.add(item);
                totalCompra += produto.getPreco()*intQtd;
            }
        }

        if (!itens.isEmpty()) {
            boolean temErro = false;
            StringBuilder erro = new StringBuilder();
            compra.setTotal(totalCompra);
            compra.setItens(itens);
            for (Item i : itens) {
                Estoque e = daoEstoque.findByProduto(i.getProduto());
                if (e.getQtd() < i.getQtd()) {
                    temErro = true;
                    erro.append("Há somente " + e.getQtd() + " unidades do produto " + i.getProduto().getDescricao() + " em estoque!<br/>");
                }
            }
            if (temErro) {
                getRequest().setAttribute("error", erro.toString());
                retorno = "WEB-INF/jsp/error.jsp";
            } else {
                
                daoCompra.insert(compra);
                
                for(Item i:compra.getItens()){
                    i.setCompra(compra);
                    daoItem.insert(i);
                    Estoque e = daoEstoque.findByProduto(i.getProduto());
                    e.setQtd(e.getQtd() - i.getQtd());
                    daoEstoque.modify(e);
                }
                
                retorno = "WEB-INF/jsp/usuario/confirmacaoCompra.jsp";
            }
        } else {
            getRequest().setAttribute("error", "Selecione pelo menos um produto para fazer uma compra");
            retorno = "WEB-INF/jsp/error.jsp";
        }
        return retorno;
    }

}
