/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bia;

import com.br.lp2.dao.EnderecoDAO;
import com.br.lp2.model.javabeans.Endereco;
import java.util.List;

/**
 *
 * @author 41516060
 */
public class Teste {
    public static void main(String[] args) {
        Endereco endereco = new Endereco();
        endereco.setRua("rua mon");
        endereco.setBairro("lala");
        endereco.setCep("0382");
        endereco.setCidade("o");
        endereco.setEstado("ohio");
        endereco.setId_endereco(1);
        EnderecoDAO enderecoDao = new EnderecoDAO();
        enderecoDao.modify(endereco);
    }
    
}
