package com.br.lp2.model.javabeans;

import java.io.Serializable;

/**
 *
 * @author 41514262
 */
public class Imagem implements Serializable{

    private Long id_imagem;
    private Long id_produto;
    private byte[] conteudo;

    public Imagem() {

    }

    public Imagem(Long id_imagem, byte[] conteudo) {
        this.id_imagem = id_imagem;
        this.conteudo = conteudo;
    }

    public Imagem(Long id_imagem) {
        this.id_imagem = id_imagem;
    }

    public Long getId_imagem() {
        return id_imagem;
    }

    public void setId_imagem(Long id_imagem) {
        this.id_imagem = id_imagem;
    }

    public byte[] getConteudo() {
        return conteudo;
    }

    public void setConteudo(byte[] conteudo) {
        this.conteudo = conteudo;
    }

    public Long getId_produto() {
        return id_produto;
    }

    public void setId_produto(Long id_produto) {
        this.id_produto = id_produto;
    }
    

    @Override
    public String toString() {
        return "Imagem{" + "id_imagem=" + id_imagem + ", conteudo=" + conteudo + '}';
    }
}
