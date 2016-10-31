/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.dao;

import com.br.lp2.model.javabeans.Endereco;
import com.br.lp2.singletonconnection.SingletonConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 41516060
 */
public class EnderecoDAO implements GenericDAO<Endereco> {

    private final static Connection connection = SingletonConnection.getInstance().getConnection();

    @Override
    public boolean insert(Endereco endereco) {
        boolean result = false;
        String sql = "INSERT INTO endereco (rua,cidade,bairro,estado,cep)VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, endereco.getRua());
            ps.setString(2, endereco.getCidade());
            ps.setString(3, endereco.getBairro());
            ps.setString(4, endereco.getEstado());
            ps.setString(5, endereco.getCep());
            int res = ps.executeUpdate();
            if (res != 0) {
                result = true;
            }
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int insertWithPKReturn(Endereco endereco) {
        int result = 0;
        String sql = "INSERT INTO endereco (rua,cidade,bairro,estado,cep)VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, endereco.getRua());
            ps.setString(2, endereco.getCidade());
            ps.setString(3, endereco.getBairro());
            ps.setString(4, endereco.getEstado());
            ps.setString(5, endereco.getCep());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            result = rs.getInt(1);
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Endereco> findAll() {
        List<Endereco> enderecos = new ArrayList<>();
        String sql = "SELECT * FROM endereco";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setId_endereco(rs.getLong("id_endereco"));
                endereco.setRua(rs.getString("rua"));
                endereco.setEstado(rs.getString("estado"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setCep(rs.getString("cep"));
                endereco.setBairro(rs.getString("bairro"));
                enderecos.add(endereco);
            }
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return enderecos;
    }

    @Override
    public Endereco findById(long id) {
        Endereco endereco = new Endereco();
        String sql = "SELECT * FROM endereco WHERE id_endereco = ?";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                endereco.setId_endereco(rs.getLong("id_endereco"));
                endereco.setRua(rs.getString("rua"));
                endereco.setEstado(rs.getString("estado"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setCep(rs.getString("cep"));
                endereco.setBairro(rs.getString("bairro"));
            }
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return endereco;
    }

    @Override
    public boolean modify(Endereco endereco) {
        boolean result = false;
        String sql = "UPDATE endereco SET rua = ?, cidade =?, bairro=?, estado=?, cep=? WHERE id_endereco = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, endereco.getRua());
            ps.setString(2, endereco.getCidade());
            ps.setString(3, endereco.getBairro());
            ps.setString(4, endereco.getEstado());
            ps.setString(5, endereco.getCep());
            ps.setLong(6, endereco.getId_endereco());
            int resp = ps.executeUpdate();
            result = (resp != 0);
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean remove(Endereco endereco) {
        boolean result = false;
        String sql = "DELETE FROM endereco WHERE id_endereco=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, endereco.getId_endereco());

            int resp = ps.executeUpdate();
            result = (resp != 0);

            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

}
