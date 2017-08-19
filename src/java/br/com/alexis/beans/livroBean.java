package br.com.alexis.beans;

import br.com.alexis.models.Livro;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author alexisbrabo
 */
@Stateless
public class livroBean {
    Livro livro;
    @PersistenceUnit
    protected EntityManager em;
    
    public void salvar(Livro livro){
        em.persist(livro);
    }

}
