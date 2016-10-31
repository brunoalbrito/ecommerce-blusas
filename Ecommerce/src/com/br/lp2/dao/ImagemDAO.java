/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.dao;

import com.br.lp2.model.javabeans.Imagem;
import com.br.lp2.singletonconnection.SingletonConnection;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

        String sql = "INSERT INTO imagem (id_produto,imagem)VALUES(?,?)";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Imagem findById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modify(Imagem e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Imagem e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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