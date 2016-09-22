/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.javabeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Beatriz
 */
public class Usuario implements Serializable {
    private long id_usuario;
    private String nome;
    private Date dt_nascimento;
    private String sobrenome;
    private String cpf;
    private Tipo tipo;
    private Endereco endereco;
    private List<Compra> compras;

    public Usuario() {
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", nome=" + nome + ", dt_nascimento=" + dt_nascimento + ", sobrenome=" + sobrenome + ", cpf=" + cpf + ", tipo=" + tipo + ", endereco=" + endereco + ", compras=" + compras + '}';
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    public List<Compra> getCompras() {
        return compras;
    }



    public long getId_usuario() {
        return id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public Date getDt_nascimento() {
        return dt_nascimento;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    
}
