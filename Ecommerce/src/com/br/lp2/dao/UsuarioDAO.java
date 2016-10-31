/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.dao;

import com.br.lp2.model.javabeans.Endereco;
import com.br.lp2.model.javabeans.Tipo;
import com.br.lp2.model.javabeans.Usuario;
import com.br.lp2.singletonconnection.SingletonConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 31595472
 */
public class UsuarioDAO implements GenericDAO<Usuario> {

    private static final Connection connection = SingletonConnection.getInstance().getConnection();

    @Override
    public boolean insert(Usuario e) {
        boolean result = false;

        try {
            String query = "insert into mack.usuario(id_endereco, nome, sobrenome, cpf, dt_nascimento, tipo) values(?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, e.getEndereco().getId_endereco());    
            ps.setString(2, e.getNome());
            ps.setString(3, e.getSobrenome());
            ps.setString(4, e.getCpf());
            ps.setDate(5, new Date(e.getDt_nascimento().getTime()));
            ps.setInt(6, (e.getTipo().getIntTipo()));
            int resp = ps.executeUpdate();
            result = (resp != 0);
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> usuarios = new ArrayList();

        try {
            String query = "select * from usuario";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId_usuario(rs.getLong("id_usuario"));
                u.setEndereco(new EnderecoDAO().findById(rs.getLong("id_endereco")));
                u.setNome(rs.getString("nome"));
                u.setSobrenome(rs.getString("sobrenome"));
                u.setCpf(rs.getString("cpf"));
                u.setDt_nascimento(rs.getDate("dt_nascimento"));
                u.setTipo(Tipo.values()[rs.getInt("tipo")]);
                usuarios.add(u);
            }
            ps.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    @Override
    public Usuario findById(long id) {
        Usuario u = null;

        try {
            String query = "select * from usuario where id_usuario = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                u = new Usuario();
                u.setId_usuario(rs.getLong("id_usuario"));
                u.setEndereco(new EnderecoDAO().findById(rs.getLong("id_endereco")));
                u.setNome(rs.getString("nome"));
                u.setSobrenome(rs.getString("sobrenome"));
                u.setCpf(rs.getString("cpf"));
                u.setDt_nascimento(rs.getDate("dt_nascimento"));
                u.setTipo(Tipo.values()[rs.getInt("tipo")]);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return u;
    }

    @Override
    public boolean modify(Usuario e) {
        boolean result = false;
        //ATUALIZANDO O ENDEREÇO DO USUÁRIO
        new EnderecoDAO().modify(e.getEndereco());
        try {
            String query = "update usuario set nome = ?, sobrenome = ?, cpf = ?, dt_nascimento = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            int resp = ps.executeUpdate();
            result = (resp != 0);
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean remove(Usuario e) {
        boolean result = false;
        try {
            String query = "delete from usuario where id_usuario = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            int resp = ps.executeUpdate();
            result = (resp != 0);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static void main(String[] args) {
        Endereco e = new Endereco();
        e.setBairro("bairro");
        e.setCep("cep");
        e.setCidade("cídade");
        e.setEstado("estado");
        e.setRua("rua");
//        int primarykeygerada = new EnderecoDAO().insertWithPKReturn(e);
        e.setId_endereco(1);
        Usuario u = new Usuario();
        u.setCpf("cpf");
        u.setDt_nascimento(new java.util.Date());
        u.setEndereco(e);
        u.setNome("nome");
        u.setSobrenome("sobrenome");
        u.setTipo(Tipo.ADM);
        new UsuarioDAO().insert(u);
    }
}
