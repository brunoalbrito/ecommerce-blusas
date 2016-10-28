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
    private boolean pagamento;
    private double total;
    private LocalDateTime dt_pedido;
    private List<Item> itens;

    public Compra() {

    }

    public long getId_compra() {
        return id_compra;
    }

    public void setId_compra(long id_compra) {
        this.id_compra = id_compra;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean getEntrege() {
        return entregue;
    }

    public void setEntregue(boolean entregue) {
        this.entregue = entregue;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDateTime getDt_pedido() {
        return dt_pedido;
    }

    public void setDt_pedido(LocalDateTime dt_pedido) {
        this.dt_pedido = dt_pedido;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public boolean getPagamento() {
        return pagamento;
    }

    public void setPagamento(boolean pagamento) {
        this.pagamento = pagamento;
    }
}
