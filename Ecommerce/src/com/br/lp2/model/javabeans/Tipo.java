/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp2.model.javabeans;

/**
 *
 * @author 41583469
 */
public enum Tipo {
    ADM("Administrador"), USER("Usuário");
    private String descricao;
    Tipo(String descricao){
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Tipo{" + "descricao=" + descricao + '}';
    }
    
}
