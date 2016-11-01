/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.dao;

import com.br.lp2.model.javabeans.Compra;
import com.br.lp2.model.javabeans.Usuario;
import com.br.lp2.singletonconnection.SingletonConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 41583469
 */
public class CompraDAO implements GenericDAO<Compra> {

    private final static Connection connection = SingletonConnection.getInstance().getConnection();

    @Override
    public boolean insert(Compra compra) {
        boolean result = false;
        String sql = "INSERT INTO compra(id_usuario,entrege,total,data_compra,pagamento)VALUES(?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setLong(1, compra.getUsuario().getId_usuario());
            ps.setBoolean(2, compra.getEntrege());
            ps.setDouble(3, compra.getTotal());
            ps.setTimestamp(4, Timestamp.valueOf(compra.getDt_pedido()));
            ps.setBoolean(5, compra.getPagamento());
            int resp = ps.executeUpdate();
            result = (resp != 0);
        } catch (SQLException ex) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Compra> findAll() {
        List<Compra> compras = new ArrayList<>();
        return compras;
    }

    @Override
    public Compra findById(long id) {
        Compra compra = new Compra();
        String sql = "SELECT * FROM compra INNER JOIN pessoa ON compra.id_usuario = usuario.id_usuario WHERE id_compra = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            /*Terminar*/
        } catch (SQLException ex) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return compra;
    }

    @Override
    public boolean modify(Compra compra) {
        boolean result = false;
        String sql = "UPDATE compra set ";
        return result;
    }

    @Override
    public boolean remove(Compra compra) {
        boolean result = false;
        String sql = "DELETE FROM compra WHERE id_compra = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, compra.getId_compra());

            int resp = ps.executeUpdate();
            result = (resp != 0);

            ps.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    public static void main(String[] args) {
        
        Usuario u = new Usuario();
        u.setId_usuario(1);
        
        Compra compra = new Compra();
        compra.setUsuario(u);
        compra.setDt_pedido(LocalDateTime.now());
        compra.setEntregue(true);
        compra.setPagamento(true);
        CompraDAO dAO = new CompraDAO();
        dAO.insert(compra);
        
    }
}
