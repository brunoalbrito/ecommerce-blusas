/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.dao;

import com.br.lp2.model.javabeans.Produto;
import com.br.lp2.singletonconnection.SingletonConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bruno
 */
public class ProdutoDAO implements GenericDAO<Produto> {
    //RETIRAR ESSA VARIÁVEL, ABRIR E FECHAR CONEXÃO DENTRO DE TODOS OS MÉTODOS
    Connection connection = null;

    @Override
    public boolean insert(Produto produto) {
        boolean result = false;

        String sql = "INSERT INTO produto(cor,tamanho,preco,descricao)VALUES(?,?,?,?)";
        Connection connection = null;
        try {
            connection = SingletonConnection.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, produto.getCor());
            ps.setString(2, String.valueOf(produto.getTamanho()));
            ps.setDouble(3, produto.getPreco());
            ps.setString(4, produto.getDescricao());
            System.out.println(produto);
            int resp = ps.executeUpdate();
            if (resp != 0) {
                result = true;
            }
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Produto> findAll() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produto";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId_produto(rs.getLong("id_produto"));
                produto.setCor(rs.getString("cor"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setTamanho(rs.getString("tamanho").charAt(0));
                produto.setDescricao(rs.getString("descricao"));
                produtos.add(produto);
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return produtos;
    }

    @Override
    public Produto findById(long id) {
        String sql = "SELECT * FROM produto WHERE id_produto = ?";
        Produto produto = new Produto();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                produto.setId_produto(rs.getLong("id_produto"));
                produto.setCor(rs.getString("cor"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setTamanho(rs.getString("tamanho").charAt(0));
                produto.setDescricao(rs.getString("descricao"));
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return produto;
    }

    @Override
    public boolean modify(Produto produto) {
        boolean result = false;

        String sql = "UPDATE produto SET cor = ?, tamanho = ?, preco = ?,"
                + " descricao = ? WHERE id_produto = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, produto.getCor());
            ps.setString(2, String.valueOf(produto.getTamanho()));
            ps.setDouble(3, produto.getPreco());
            ps.setString(4, produto.getDescricao());
            ps.setLong(5, produto.getId_produto());

            int resp = ps.executeUpdate();
            if (resp != 0) {
                result = true;
            }
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean remove(Produto produto) {
        boolean result = false;
        String sql = "DELETE FROM produto WHERE id_produto = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, produto.getId_produto());

            int resp = ps.executeUpdate();
            result = (resp != 0);

            ps.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
