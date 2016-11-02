
package com.br.lp2.dao;

import java.util.List;

/**
 *
 * @author Bruno
 * @param <E> Elemento genérico responsável por receber qualquer
 * tipo de dados que precisar ser persistido
 */
public interface GenericDAO<E> {

    boolean insert(E e);

    List<E> findAll();

    E findById(long id);

    boolean modify(E e);

    boolean remove(E e);
}
