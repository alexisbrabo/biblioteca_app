/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexis.beans;

import br.com.alexis.models.Usuario;
import br.com.alexis.padrao.Bean;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author alexisbrabo
 */
@Stateless
public class UsuarioBean extends Bean{

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
