
package com.br.lp2.dao;

import com.br.lp2.model.javabeans.Item;
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
public class ItemDAO implements GenericDAO<Item> {

    private final Connection connection = SingletonConnection.getInstance().getConnection();

    @Override
    public boolean insert(Item item) {
        String sql = "INSERT INTO item(id_compra,id_produto,qtd)VALUES((SELECT MAX(id_compra)FROM compra),?,?)";
        boolean result = false;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, item.getProduto().getId_produto());
            ps.setLong(2, item.getQtd());
            result = (ps.executeUpdate() != 0);
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM ITEM";
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item item = new Item();
                item.setCompra(new CompraDAO().findById(rs.getLong("id_compra")));
                item.setProduto(new ProdutoDAO().findById(rs.getLong("id_produto")));
                item.setQtd(rs.getInt(("qtd")));
                items.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return items;
    }

    @Override
    public Item findById(long id) {
        String sql = "SELECT * FROM ITEM WHERE id_item = ?";
        Item item = new Item();
        try {
            PreparedStatement ps = connection.prepareCall(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                item.setCompra(new CompraDAO().findById(rs.getLong("id_compra")));
                item.setProduto(new ProdutoDAO().findById(rs.getLong("id_produto")));
                item.setQtd(rs.getInt(("qtd")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return item;
    }

    @Override
    public boolean modify(Item item) {
        String sql = "UPDATE item SET id_compra = ?, id_produto = ?,qtd = ?";
        boolean result = false;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, item.getCompra().getId_compra());
            ps.setLong(2, item.getProduto().getId_produto());
            ps.setInt(3, item.getQtd());
            result = (ps.executeUpdate() != 0);
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean remove(Item item) {
        String sql = "DELETE FROM item WHERE id_item = ?";
        boolean result = false;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, item.getId_item());
            result = (ps.executeUpdate() != 0);

        } catch (SQLException ex) {
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
