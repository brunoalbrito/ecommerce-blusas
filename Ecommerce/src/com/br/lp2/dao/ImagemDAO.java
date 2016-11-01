/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.dao;

import com.br.lp2.model.javabeans.Imagem;
import com.br.lp2.singletonconnection.SingletonConnection;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author 41514262
 */
public class ImagemDAO implements GenericDAO<Imagem> {

    Connection connection = SingletonConnection.getInstance().getConnection();

    @Override
    public boolean insert(Imagem imagem) {
        boolean result = false;

        String sql = "INSERT INTO imagem (id_produto,conteudo)VALUES(?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, imagem.getId_produto());
            ps.setBlob(2, new SerialBlob(imagem.getConteudo()));

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
    public List<Imagem> findAll() {
        List<Imagem> imagens = new ArrayList<>();
        String sql = "SELECT * FROM imagem";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Imagem imagem = new Imagem();
                imagem.setId_imagem(rs.getLong("id_imagem"));
                imagem.setConteudo(rs.getBytes("conteudo"));
                imagem.setId_produto(rs.getLong("id_produto"));
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imagens;
    }

    @Override
    public Imagem findById(long id) {
        String sql = "SELECT * FROM imagem WHERE id_imagem = ?";
        Imagem imagem = new Imagem();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                imagem.setId_imagem(rs.getLong("id_imagem"));
                Blob blob = rs.getBlob("CONTEUDO");
                imagem.setConteudo(blob.getBytes(1, (int) blob.length()));
                blob.free();
                imagem.setId_produto(rs.getLong("id_produto"));
            }
            rs.close();
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imagem;
    }

    @Override
    public boolean modify(Imagem imagem) {
        boolean result = false;
        String sql = "UPDATE imagem SET conteudo = ? WHERE id_imagem = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setBlob(1, new SerialBlob(imagem.getConteudo()));

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
    public boolean remove(Imagem imagem) {
        boolean result = false;
        String sql = "DELETE FROM imagem WHERE id_imagem = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, imagem.getId_imagem());

            int resp = ps.executeUpdate();
            result = (resp != 0);

            ps.close();
            connection.close();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        File file = new File("teste.png");
        InputStream is = new FileInputStream(file);
        byte[] buffer = new byte[is.available()];
        is.read(buffer);
        is.close();
        Imagem imagem = new Imagem();
        long l = 1;
        imagem.setId_produto(l);
        imagem.setConteudo(buffer);
        ImagemDAO dAO = new ImagemDAO();
        dAO.insert(imagem);
    }
}
