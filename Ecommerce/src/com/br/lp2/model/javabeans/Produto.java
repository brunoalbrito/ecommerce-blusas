/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.javabeans;

/**
 *
 * @author Beatriz
 */
public class Produto {

    private Imagem imagem;
    private long id_produto;
    private String cor;
    private char tamanho;
    private double preco;
    private String descricao;

    public Produto() {
    }

    public void setId_produto(long id_produto) {
        this.id_produto = id_produto;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setTamanho(char tamanho) {
        this.tamanho = tamanho;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getId_produto() {
        return id_produto;
    }

    public String getCor() {
        return cor;
    }

    public char getTamanho() {
        return tamanho;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public Imagem getImagem() {
        return imagem;
    }

    public void setImagem(Imagem imagem) {
        this.imagem = imagem;
    }

    @Override
    public String toString() {
        return "Produto{" + "imagem=" + imagem + ", id_produto=" + id_produto + ", cor=" + cor + ", tamanho=" + tamanho + ", preco=" + preco + ", descricao=" + descricao + '}';
    }

}
