/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lp2.testes;

import com.br.lp2.dao.ImagemDAO;
import com.br.lp2.model.javabeans.Imagem;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Bruno
 */
public class ImagemTESTE {
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
