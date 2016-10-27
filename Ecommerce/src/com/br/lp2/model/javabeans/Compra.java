/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.javabeans;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author Beatriz
 */
public class Compra implements Serializable {
    private long id_compra;
    private Usuario usuario;
    private boolean entregue;
    private double total;
    private LocalDateTime dt_pedido;
    private List<Item> itens;


    public Compra() {
        
    }


    

    public long getId_compra() {
        return id_compra;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public boolean isEntregue() {
        return entregue;
    }

    public double getTotal() {
        return total;
    }

    public LocalDateTime getDt_pedido() {
        return dt_pedido;
    }


    public void setId_compra(long id_compra) {
        this.id_compra = id_compra;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setEntregue(boolean entregue) {
        this.entregue = entregue;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setDt_pedido(LocalDateTime dt_pedido) {
        this.dt_pedido = dt_pedido;
    }    
    
}
