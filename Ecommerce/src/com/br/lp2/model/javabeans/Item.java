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
public class Item {
    private long id_item;
    private int qtd;
    private Produto produto;

    public Item() {
    }

    @Override
    public String toString() {
        return "Item{" + "id_item=" + id_item + ", qtd=" + qtd + ", produto=" + produto + '}';
    }

    public long getId_item() {
        return id_item;
    }

    public int getQtd() {
        return qtd;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setId_item(long id_item) {
        this.id_item = id_item;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    
    
}
