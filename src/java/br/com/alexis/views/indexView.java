/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexis.views;

import br.com.alexis.beans.LivroBean;
import br.com.alexis.beans.UsuarioBean;
import br.com.alexis.models.Livro;
import br.com.alexis.models.Usuario;
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
    @EJB
    UsuarioBean usuarioBean;
    private Livro livro;
    private Usuario usuario;
    private List<Livro> listaLivro;
    private List<Usuario> listaUsuario;
    private List<Usuario> listaUsuarioFiltrados;
    private List<Livro> listaLivroFiltrados;
    private String url;
    private boolean renderListaLivro;
    private boolean renderListaUsuario;
    private boolean renderListaAutor;

    public void iniciar() {

    }

    public void message() {
        addMessageInfo("Success", "Data saved");
    }

    public void renderizarCadastroLivro() {
        listaLivro = livroBean.findAll();
        renderListaLivro = true;
    }

    public void renderizarCadastroAutor() {
        listaLivro = livroBean.findAll();
        renderListaLivro = true;
    }

    public void renderizarCadastroUsuario() {
        listaUsuario = usuarioBean.findAll();
        renderListaUsuario = true;
    }

    public void adicionarLivro() {
        livro = new Livro();
        renderListaLivro = false;
    }

    public void adicionarUsuario() {
        usuario = new Usuario();
        renderListaUsuario = false;
    }

    public void confirmarLivro() {
        if (livro.getId() == null) {
            livroBean.salvar(livro);
            addMessageInfo("Registro salvo com sucesso", "Registro salvo com sucesso");
        } else {
            livroBean.update(livro);
            addMessageInfo("Registro atualizado com sucesso", "Registro atualizado com sucesso");
        }
        livro = new Livro();
        renderizarCadastroLivro();

    }

    public void deletarLivro() {
        livroBean.delete(livro);
        listaLivro = livroBean.findAll();
    }

    public void deletarUsuario() {
        usuarioBean.delete(usuarioBean);
    }

    public void confirmarUsuario() {
        if (usuario.getId() == null) {
            usuarioBean.salvar(usuario);
            addMessageInfo("Registro salvo com sucesso", "Registro salvo com sucesso");
        } else {
            usuarioBean.update(usuario);
            addMessageInfo("Registro atualizado com sucesso", "Registro atualizado com sucesso");
        }
        usuario = new Usuario();
        renderizarCadastroUsuario();

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
     * @return the listaLivro
     */
    public List<Livro> getListaLivro() {
        if (listaLivro == null) {
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
     * @return the listaUsuario
     */
    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    /**
     * @param listaUsuario the listaUsuario to set
     */
    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    /**
     * @return the renderListaUsuario
     */
    public boolean isRenderListaUsuario() {
        return renderListaUsuario;
    }

    /**
     * @param renderListaUsuario the renderListaUsuario to set
     */
    public void setRenderListaUsuario(boolean renderListaUsuario) {
        this.renderListaUsuario = renderListaUsuario;
    }

    /**
     * @return the listaUsuarioFiltrados
     */
    public List<Usuario> getListaUsuarioFiltrados() {
        return listaUsuarioFiltrados;
    }

    /**
     * @param listaUsuarioFiltrados the listaUsuarioFiltrados to set
     */
    public void setListaUsuarioFiltrados(List<Usuario> listaUsuarioFiltrados) {
        this.listaUsuarioFiltrados = listaUsuarioFiltrados;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
