package com.br.lp2.dao;

import com.br.lp2.model.javabeans.Compra;
import com.br.lp2.model.javabeans.Item;
import com.br.lp2.model.javabeans.Produto;
import com.br.lp2.singletonconnection.SingletonConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
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
        String sql = "INSERT INTO compra(id_usuario,entregue,total,data_compra,pagamento)VALUES(?,?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(sql);
            ps.setLong(1, compra.getUsuario().getId_usuario());
            ps.setBoolean(2, compra.getEntregue());
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
        List<Item> items = new ArrayList<>();
        UsuarioDAO udAO = new UsuarioDAO();
        String sql = "SELECT * FROM compra";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setUsuario(udAO.findById(rs.getLong("id_usuario")));
                compra.setId_compra(rs.getLong("id_compra"));
                compra.setEntregue(rs.getBoolean("entregue"));
                compra.setTotal(rs.getDouble("total"));
                compra.setDt_pedido(rs.getTimestamp("data_compra").toLocalDateTime());
                compra.setPagamento(rs.getBoolean("pagamento"));
                
                String sql1 = "SELECT item.qtd,produto.id_produto,"
                        + "produto.cor,produto.tamanho,produto.preco,produto.descricao FROM item "
                        + "inner join compra ON (item.id_compra = compra.id_compra) "
                        + "inner join produto ON (produto.id_produto = item.id_produto) AND item.id_compra = ?";
                PreparedStatement ps1 = connection.prepareStatement(sql1);
                ps1.setLong(1, compra.getId_compra());
                ResultSet rs1 = ps1.executeQuery();
                while (rs1.next()) {
                    Produto produto = new Produto();
                    produto.setCor(rs1.getString("cor"));
                    produto.setDescricao("descricao");
                    produto.setTamanho(rs1.getString("tamanho").charAt(0));
                    produto.setPreco(rs1.getDouble("preco"));
                    Item item = new Item();
                    item.setProduto(produto);
                    item.setQtd(rs1.getInt("qtd"));
                    items.add(item);
                }
                compra.setItens(items);
                compras.add(compra);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return compras;
    }

    @Override
    public Compra findById(long id) {
        Compra compra = new Compra();
        List<Item> items = new ArrayList<>();
        UsuarioDAO udAO = new UsuarioDAO();
        String sql = "select * from compra WHERE id_compra = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                compra.setUsuario(udAO.findById(rs.getLong(sql)));
                compra.setId_compra(rs.getLong("id_compra"));
                compra.setEntregue(rs.getBoolean("entregue"));
                compra.setTotal(rs.getDouble("total"));
                compra.setDt_pedido(rs.getTimestamp("data_compra").toLocalDateTime());
                compra.setPagamento(rs.getBoolean("pagamento"));
                
                String sql1 = "select item.qtd,produto.id_produto,"
                        + "produto.cor,produto.tamanho,produto.preco,produto.descricao from item "
                        + "inner join compra on (item.id_compra = compra.id_compra) "
                        + "inner join produto on (produto.id_produto = item.id_produto) and item.id_compra = ?";
                PreparedStatement ps1 = connection.prepareStatement(sql1);
                ps1.setLong(1, id);
                ResultSet rs1 = ps1.executeQuery();
                while (rs1.next()) {
                    Produto produto = new Produto();
                    produto.setCor(rs1.getString("cor"));
                    produto.setDescricao("descricao");
                    produto.setTamanho(rs.getString("tamanho").charAt(0));
                    produto.setPreco(rs.getDouble("preco"));
                    Item item = new Item();
                    item.setProduto(produto);
                    item.setQtd(rs.getInt("qtd"));
                    items.add(item);
                }
                compra.setItens(items);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return compra;
    }

    @Override
    public boolean modify(Compra compra) {
        boolean result = false;
        String sql = "UPDATE compra set entregue = ?, total = ?,data_compra = ?, pagamento = ? WHERE id_compra  = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setBoolean(1, compra.getEntregue());
            ps.setDouble(2, compra.getTotal());
            ps.setTimestamp(3, Timestamp.valueOf(compra.getDt_pedido()));
            ps.setBoolean(4, compra.getPagamento());
            ps.setLong(5, compra.getId_compra());

            int resp = ps.executeUpdate();
            result = (resp != 0);
        } catch (SQLException ex) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
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
}
