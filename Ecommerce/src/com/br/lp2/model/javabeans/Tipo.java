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
public class Tipo implements Serializable{
    private long id_tipo;
    private String descricao;

    public Tipo() {
    }

    @Override
    public String toString() {
        return "Tipo{" + "id_tipo=" + id_tipo + ", descricao=" + descricao + '}';
    }

    public long getId_tipo() {
        return id_tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId_tipo(long id_tipo) {
        this.id_tipo = id_tipo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
