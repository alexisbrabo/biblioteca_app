/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexis.beans;

import br.com.alexis.models.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author alexisbrabo
 */
@Stateless
public class UsuarioBean {

    Usuario usuario;
    @PersistenceContext
    protected EntityManager em;

    public void salvar(Usuario usuario) {

        em.persist(usuario);
    }

    public List<Usuario> findAll() {
        List<Usuario> listaUsuario = em.createQuery("SELECT o FROM Usuario o WHERE o.id > 0").getResultList();
        return listaUsuario;
    }

    public Usuario getUsuarioLogin(String user, String senha) {
        List<Usuario> listaUsuario = em.createQuery("SELECT o FROM Usuario o WHERE o.id > 0 and o.nome = '" + user + "' and o.senha = '" + senha + "'").getResultList();
        if (listaUsuario.isEmpty()) {
            return null;
        } else {
            return listaUsuario.get(0);
        }
    }

}
