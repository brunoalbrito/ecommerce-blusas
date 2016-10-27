/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.javabeans;

import java.io.Serializable;

/**
 *
 * @author Beatriz
 */
public class Endereco implements Serializable {
    private long id_endereco;
    private String estado;
    private String cep;
    private String cidade;
    private String bairro;
    private String rua;

    public Endereco() {
    }

    public long getId_endereco() {
        return id_endereco;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setId_endereco(long id_endereco) {
        this.id_endereco = id_endereco;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id_endereco=" + id_endereco + ", estado=" + estado + ", cep=" + cep + ", cidade=" + cidade + ", bairro=" + bairro + ", rua=" + rua + '}';
    }
    
    
}
