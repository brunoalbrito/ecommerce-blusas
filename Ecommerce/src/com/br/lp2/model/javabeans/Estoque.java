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
public class Estoque {
    private long id_estoque;
    private int qtd;
    private Produto produto;

    public Estoque() {
    }

    public long getId_estoque() {
        return id_estoque;
    }

    public int getQtd() {
        return qtd;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setId_estoque(long id_estoque) {
        this.id_estoque = id_estoque;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "Estoque{" + "id_estoque=" + id_estoque + ", qtd=" + qtd + ", produto=" + produto + '}';
    }
    
    
    
}
