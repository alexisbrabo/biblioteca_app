package br.com.alexis.beans;

import br.com.alexis.models.Livro;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alexisbrabo
 */
@Stateless
public class LivroBean {

    Livro livro;
    @PersistenceContext
    protected EntityManager em;

    public void salvar(Livro livro) {
        em.persist(livro);
    }

    public List<Livro> findAll() {
        List<Livro> listaLivro = em.createQuery("SELECT o FROM Livro o WHERE o.id > 0").getResultList();
        return listaLivro;
    }

}
