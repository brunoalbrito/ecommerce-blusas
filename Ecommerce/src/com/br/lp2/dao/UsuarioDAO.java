package com.br.lp2.dao;

import com.br.lp2.model.javabeans.Tipo;
import com.br.lp2.model.javabeans.Usuario;
import com.br.lp2.singletonconnection.SingletonConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 41583469
 */
public class UsuarioDAO implements GenericDAO<Usuario> {

    private final Connection connection = SingletonConnection.getInstance().getConnection();

    @Override
    public boolean insert(Usuario e) {
        boolean result = false;
        //INSERINDO ENDEREÇO DO USUÁRIO AO BANCO E PEGANDO ID GERADO
        e.getEndereco().setId_endereco(new EnderecoDAO().insertWithPKReturn(e.getEndereco()));
        System.out.println("Usuário recebido: " + e.toString());
        try {
            String query = "insert into mack.usuario(id_endereco, nome, sobrenome,"
                    + " cpf, dt_nascimento, tipo, usuario ,senha)"
                    + " values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, e.getEndereco().getId_endereco());
            ps.setString(2, e.getNome());
            ps.setString(3, e.getSobrenome());
            ps.setString(4, e.getCpf());
            ps.setDate(5, new Date(e.getDt_nascimento().getTime()));
            ps.setInt(6, (e.getTipo().getIntTipo()));
            ps.setString(7, e.getUsuario());
            ps.setString(8, e.getSenha());
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
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "select * from usuario";
        EnderecoDAO daoEndereco = new EnderecoDAO();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId_usuario(rs.getLong("id_usuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setDt_nascimento(new java.util.Date(rs.getDate("dt_nascimento").getTime()));
                usuario.setEndereco(daoEndereco.findById(rs.getLong("id_endereco")));
                usuario.setSenha(rs.getString("senha"));
                usuario.setSobrenome(rs.getString("sobrenome"));
                usuario.setTipo(Tipo.values()[rs.getInt("tipo")]);
                usuario.setUsuario(rs.getString("usuario"));
                //FALTA SETAR AS COMPRAS DO USUÁRIO (DEPENDE DO COMPRA DAO)
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    @Override
    public Usuario findById(long id) {
        Usuario usuario = new Usuario();
        String sql = "select * from usuario where id_usuario = ?";
        EnderecoDAO daoEndereco = new EnderecoDAO();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                usuario.setId_usuario(rs.getLong("id_usuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setDt_nascimento(new java.util.Date(rs.getDate("dt_nascimento").getTime()));
                usuario.setEndereco(daoEndereco.findById(rs.getLong("id_endereco")));
                usuario.setSenha(rs.getString("senha"));
                usuario.setSobrenome(rs.getString("sobrenome"));
                usuario.setTipo(Tipo.values()[rs.getInt("tipo")]);
                usuario.setUsuario(rs.getString("usuario"));
                //FALTA SETAR AS COMPRAS DO USUÁRIO (DEPENDE DO COMPRA DAO)
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }
    
    public Usuario findByUsername(String username){
        Usuario usuario = new Usuario();
        EnderecoDAO daoEndereco = new EnderecoDAO();
        
        String sql = "SELECT * FROM usuario WHERE usuario=?";
        try{
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setString(1, username);
        
        ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                usuario.setId_usuario(rs.getLong("id_usuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setDt_nascimento(new java.util.Date(rs.getDate("dt_nascimento").getTime()));
                usuario.setEndereco(daoEndereco.findById(rs.getLong("id_endereco")));
                usuario.setSenha(rs.getString("senha"));
                usuario.setSobrenome(rs.getString("sobrenome"));
                usuario.setTipo(Tipo.values()[rs.getInt("tipo")]);
                usuario.setUsuario(rs.getString("usuario"));
                //FALTA SETAR AS COMPRAS DO USUÁRIO (DEPENDE DO COMPRA DAO)
            }
        }catch(SQLException ex){
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return usuario;
    }

    @Override
    public boolean modify(Usuario e) {
        boolean result = false;
        String sql = "UPDATE usuario SET id_endereco = ?,nome = ?,sobrenome = ?,"
                + "cpf = ?, data_nascimento = ?."
                + "usuario = ?,senha = ? WHERE id_usuario = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, e.getEndereco().getId_endereco());
            ps.setString(2, e.getNome());
            ps.setString(3, e.getSobrenome());
            ps.setString(4, e.getCpf());
            ps.setDate(5, new Date(e.getDt_nascimento().getTime()));
            ps.setString(6, e.getUsuario());
            ps.setString(7, e.getSenha());
            ps.setLong(8, e.getId_usuario());
            int resp = ps.executeUpdate();
            result = (resp != 0);

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean remove(Usuario e) {
        boolean result = false;
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, e.getId_usuario());
            int resp = ps.executeUpdate();
            result = (resp != 0);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
