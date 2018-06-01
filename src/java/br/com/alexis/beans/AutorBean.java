/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexis.beans;

import br.com.alexis.models.Autor;
import br.com.alexis.padrao.Bean;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author alexi
 */
@Stateless
public class AutorBean extends Bean {

    public List<Autor> findAll() {
        return em.createQuery("SELECT o FROM Autor o WHERE o.id > 0").getResultList();
    }

    public List<Autor> findAutorByNome(String texto) {
        List<Autor> lista = em.createQuery("SELECT o FROM Autor o WHERE o.nome like '%" + texto + "%'").getResultList();
        return lista;
    }

    public List<Autor> findAutorById(Integer id) {
        return em.createQuery("SELECT o FROM Autor o WHERE o.id = '" + id + "'").getResultList();
    }

}
