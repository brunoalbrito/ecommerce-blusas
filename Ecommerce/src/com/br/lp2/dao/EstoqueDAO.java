package com.br.lp2.dao;

import com.br.lp2.model.javabeans.Estoque;
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
 * @author 41583469
 */
public class EstoqueDAO implements GenericDAO<Estoque> {

    private final static Connection connection = SingletonConnection.getInstance().getConnection();

    @Override
    public boolean insert(Estoque estoque) {
        boolean result = false;

        String sql = "INSERT INTO estoque(id_produto,qtd)VALUES(?,?) ";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, estoque.getProduto().getId_produto());
            ps.setInt(2, estoque.getQtd());

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
    public List<Estoque> findAll() {
        List<Estoque> estoques = new ArrayList<>();
        String sql = "SELECT * FROM estoque INNER JOIN produto ON estoque.id_produto = produto.id_produto";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Estoque estoque = new Estoque();
                estoque.setId_estoque(rs.getLong("id_estoque"));
                Produto produto = new Produto();
                produto.setId_produto(rs.getLong("id_produto"));
                produto.setCor(rs.getString("cor"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setTamanho(rs.getString("tamanho").charAt(0));
                produto.setDescricao(rs.getString("descricao"));
                estoque.setProduto(produto);
                estoque.setQtd(rs.getInt("qtd"));
                estoques.add(estoque);
            }
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estoques;
    }

    @Override
    public Estoque findById(long id) {
        String sql = "SELECT * FROM estoque INNER JOIN produto ON estoque.id_produto = produto.id_produto AND id_estoque = ?";
        Estoque estoque = new Estoque();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                estoque.setId_estoque(rs.getLong("id_estoque"));
                Produto produto = new Produto();
                produto.setId_produto(rs.getLong("id_produto"));
                produto.setCor(rs.getString("cor"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setTamanho(rs.getString("tamanho").charAt(0));
                produto.setDescricao(rs.getString("descricao"));
                estoque.setProduto(produto);
                estoque.setQtd(rs.getInt("qtd"));
            }
            ps.close();
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estoque;
    }

    @Override
    public boolean modify(Estoque estoque) {
        boolean result = false;
        String sql = "UPDATE estoque SET id_produto = ?, qtd = ? WHERE id_estoque = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, estoque.getProduto().getId_produto());
            ps.setInt(2, estoque.getQtd());
            ps.setLong(3, estoque.getId_estoque());
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
    public boolean remove(Estoque estoque) {
        boolean result = false;
        String sql = "DELETE FROM estoque WHERE id_estoque = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, estoque.getId_estoque());

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
