/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexis.views;

import br.com.alexis.beans.AutorBean;
import br.com.alexis.models.Autor;
import br.com.alexis.padrao.View;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author alexisbrabo
 */
@ManagedBean
@ViewScoped
public class AutorView extends View implements Serializable {

    @EJB
    AutorBean autorBean;
    private Autor autor;
    private List<Autor> listaAutor;
    private List<Autor> listaAutoresFiltrados;
    private boolean renderListaAutor;

    public void iniciar() {

    }

    public void message() {
        addMessageInfo("Success", "Data saved");
    }

    public void renderizarCadastroAutor() {
        setListaAutor(autorBean.findAll());
        setRenderListaAutor(true);
    }

    public void adicionarAutor() {
        autor = new Autor();
        renderListaAutor = false;
    }

    public void confirmarAutor() {
        if (autor.getId() == null) {
            autorBean.salvar(autor);
            addMessageInfo("Registro salvo com sucesso", "Registro salvo com sucesso");
        } else {
            autorBean.update(autor);
            addMessageInfo("Registro atualizado com sucesso", "Registro atualizado com sucesso");
        }
        autor = new Autor();
        renderizarCadastroAutor();

    }

    public void deletarAutor() {
        autorBean.delete(autor);
        listaAutor = autorBean.findAll();
    }

    /**
     * @return the autor
     */
    public Autor getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    /**
     * @return the listaAutor
     */
    public List<Autor> getListaAutor() {
        return listaAutor;
    }

    /**
     * @param listaAutor the listaAutor to set
     */
    public void setListaAutor(List<Autor> listaAutor) {
        this.listaAutor = listaAutor;
    }

    /**
     * @return the renderListaAutor
     */
    public boolean isRenderListaAutor() {
        return renderListaAutor;
    }

    /**
     * @param renderListaAutor the renderListaAutor to set
     */
    public void setRenderListaAutor(boolean renderListaAutor) {
        this.renderListaAutor = renderListaAutor;
    }

    /**
     * @return the listaAutoresFiltrados
     */
    public List<Autor> getListaAutoresFiltrados() {
        return listaAutoresFiltrados;
    }

    /**
     * @param listaAutoresFiltrados the listaAutoresFiltrados to set
     */
    public void setListaAutoresFiltrados(List<Autor> listaAutoresFiltrados) {
        this.listaAutoresFiltrados = listaAutoresFiltrados;
    }

}
