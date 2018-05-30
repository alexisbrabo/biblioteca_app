/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexis.padrao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alexi
 */
public class Bean {

    @PersistenceContext
    protected EntityManager em;

    public void salvar(Object o) {
        em.persist(o);
    }

    public void update(Object o) {
        em.merge(o);
    }

    public void delete(Object o) {
        if (!em.contains(o)) {
            o = em.merge(o);
        }
        em.remove(o);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
