/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.action;

import com.br.lp2.dao.EnderecoDAO;
import com.br.lp2.dao.UsuarioDAO;
import com.br.lp2.model.javabeans.Endereco;
import com.br.lp2.model.javabeans.Tipo;
import com.br.lp2.model.javabeans.Usuario;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Cookie;

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
            endereco.setId_endereco(new EnderecoDAO().insertWithPKReturn(endereco));
            
            usuario.setEndereco(endereco);
            boolean result = new UsuarioDAO().insert(usuario);
            if(result){
                back = "WEB-INF/jsp/homeUser.jsp";
            }else{
                back = "erro.jsp";
            }
        } catch (Exception e) {
            Logger.getLogger(UsuarioAction.class.getName()).log(Level.SEVERE, null, e);
        }
        return back;
    }
    
    public String doLogin(){
        String retorno=null;
        String username = getRequest().getParameter("usuario");
        String password = getRequest().getParameter("senha");
        
        Usuario usuario = new UsuarioDAO().findByUsername(username);
        
        if(usuario==null){
            getRequest().getSession().setAttribute("error","User not found");
        }else if(password.equals(usuario.getSenha())){
            String remember = getRequest().getParameter("remember");
            Cookie c1 = new Cookie ("username", username);
            
            if(remember!=null){
                c1.setMaxAge(60*60*24*7);
            }else{
                c1.setMaxAge(0);
            }
            getResponse().addCookie(c1);
            getRequest().getSession().setAttribute("usuario", usuario);
            if(usuario.getTipo().getIntTipo()==0){
                retorno = "WEB-INF/jsp/homeAdmin.jsp";
            }else{
                retorno="WEB-INF/jsp/homeUser.jsp";
            }
            
        }else{
           getRequest().getSession().setAttribute("error", "Wrong Password!"); 
        }
        return retorno;
        
    }

}
