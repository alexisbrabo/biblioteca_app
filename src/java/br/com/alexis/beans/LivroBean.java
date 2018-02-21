/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexis.beans;

import br.com.alexis.models.Livro;
import br.com.alexis.padrao.Bean;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author alexi
 */
@Stateless
public class LivroBean extends Bean {

    public List<Livro> findAll() {
        return em.createQuery("SELECT o FROM Livro o WHERE o.id > 0").getResultList();
    }
    
    public void remove(Livro l) {
        Livro livro = em.merge(l);
        em.remove(livro);
    }

}
