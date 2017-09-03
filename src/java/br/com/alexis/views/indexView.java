/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexis.views;

import br.com.alexis.beans.LivroBean;
import br.com.alexis.models.Livro;
import br.com.alexis.padrao.View;
import java.io.Serializable;
import java.util.ArrayList;
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
public class indexView extends View implements Serializable {
    @EJB
    LivroBean livroBean;
    private boolean renderCadastroLivro;
    private boolean renderListaLivro;
    private boolean renderCadastroAutor;
    private Livro livro;
    private List<Livro> listaLivro;
    private List<Livro> listaLivroFiltrados;
    private String url;
    
    public void iniciar(){
        renderCadastroAutor = false;
        renderCadastroLivro = false;
        renderListaLivro = false;
    }

    public void message() {
        addMessageInfo("Success", "Data saved");
    }
    
   
    public void renderizarCadastroLivro() {
        iniciar();
        livro = new Livro();
        renderCadastroLivro = true;
    }
    
    public void renderizarListaLivro() {
        iniciar();
        listaLivro = livroBean.findAll();
        renderListaLivro = true;
    }

    public void desRenderizarCadastroLivro() {
        renderCadastroLivro = false;
    }

    public void sair() {
        renderCadastroLivro = false;
    }

    public void confirmarLivro() {
        livroBean.salvar(livro);
        livro = new Livro();
        addMessageInfo("Registro salvo com sucesso", "Registro salvo com sucesso");
    }

    /**
     * @return the renderCadastroLivro
     */
    public boolean isRenderCadastroLivro() {
        return renderCadastroLivro;
    }

    /**
     * @param renderCadastroLivro the renderCadastroLivro to set
     */
    public void setRenderCadastroLivro(boolean renderCadastroLivro) {
        this.renderCadastroLivro = renderCadastroLivro;
    }

    /**
     * @return the renderCadastroAutor
     */
    public boolean isRenderCadastroAutor() {
        return renderCadastroAutor;
    }

    /**
     * @param renderCadastroAutor the renderCadastroAutor to set
     */
    public void setRenderCadastroAutor(boolean renderCadastroAutor) {
        this.renderCadastroAutor = renderCadastroAutor;
    }

    /**
     * @return the livro
     */
    public Livro getLivro() {
        return livro;
    }

    /**
     * @param livro the livro to set
     */
    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    /**
     * @return the renderListaLivro
     */
    public boolean isRenderListaLivro() {
        return renderListaLivro;
    }

    /**
     * @param renderListaLivro the renderListaLivro to set
     */
    public void setRenderListaLivro(boolean renderListaLivro) {
        this.renderListaLivro = renderListaLivro;
    }

    /**
     * @return the listaLivro
     */
    public List<Livro> getListaLivro() {
        if (listaLivro == null){
            listaLivro = new ArrayList<>();
        }
        return listaLivro;
    }

    /**
     * @param listaLivro the listaLivro to set
     */
    public void setListaLivro(List<Livro> listaLivro) {
        this.listaLivro = listaLivro;
    }

    /**
     * @return the listaLivroFiltrados
     */
    public List<Livro> getListaLivroFiltrados() {
        return listaLivroFiltrados;
    }

    /**
     * @param listaLivroFiltrados the listaLivroFiltrados to set
     */
    public void setListaLivroFiltrados(List<Livro> listaLivroFiltrados) {
        this.listaLivroFiltrados = listaLivroFiltrados;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

}
