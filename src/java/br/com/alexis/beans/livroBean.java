package br.com.alexis.beans;

import br.com.alexis.models.Livro;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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

    public void salvar(Livro livro) {
        em.persist(livro);
    }

    public List<Livro> findAll() {
        return em.createQuery("SELECT o FROM Livro o WHERE o.id > 0").getResultList();
    }

}
