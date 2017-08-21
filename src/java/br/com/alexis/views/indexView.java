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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import net.bootsfaces.utils.FacesMessages;

/**
 *
 * @author alexisbrabo
 */
@ManagedBean
@ViewScoped
public class indexView implements Serializable {

    @EJB
    LivroBean livroBean;
    @EJB
    UsuarioBean usuarioBean;
    private boolean renderCadastroLivro;
    private boolean renderCadastroUsuario;
    private boolean renderCadastroAutor;
    private boolean renderListaLivro;
    private Livro livro;
    private List<Livro> listaLivro;
    private Usuario usuario;

    public void iniciar() {
        renderCadastroAutor = false;
        renderCadastroLivro = false;
        renderListaLivro = false;
        renderCadastroUsuario = false;
    }

    public void renderizarCadastroLivro() {
        iniciar();
        livro = new Livro();
        renderCadastroLivro = true;
    }

    public void renderizarCadastroUsuario() {
        iniciar();
        usuario = new Usuario();
        renderCadastroUsuario = true;
    }

    public void renderizarListaLivro() {
        iniciar();
        listaLivro = new ArrayList<>();
        listaLivro = livroBean.findAll();
        renderListaLivro = true;
    }

    public void confirmarLivro() {
        if (livro.getNome() == null || livro.getNome().equals("")) {
            FacesMessages.fatal("Nome do Livro Obrigatório!");
            return;
        }
        if (livro.getNumPaginas() == null) {
            FacesMessages.fatal("Número de Páginas Obrigatório!");
            return;
        }
        if (livro.getEditora() == null || livro.getEditora().equals("")) {
            FacesMessages.fatal("Editora Obrigatória!");
            return;
        }
        livroBean.salvar(livro);
    }

    public void confirmarUsuario() {
        if (usuario.getNome() == null || usuario.getNome().equals("")) {
            FacesMessages.fatal("Login Obrigatório!");
            return;
        }
        if (usuario.getSenha() == null || usuario.getSenha().equals("")) {
            FacesMessages.fatal("Senha Obrigatória!");
            return;
        }
        usuarioBean.salvar(usuario);
    }

    /**
     * ***********************************************************************************************************************************************************************************************************************
     *
     * /
     *
     **
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
        return listaLivro;
    }

    /**
     * @param listaLivro the listaLivro to set
     */
    public void setListaLivro(List<Livro> listaLivro) {
        this.listaLivro = listaLivro;
    }

    /**
     * @return the renderCadastroUsuario
     */
    public boolean isRenderCadastroUsuario() {
        return renderCadastroUsuario;
    }

    /**
     * @param renderCadastroUsuario the renderCadastroUsuario to set
     */
    public void setRenderCadastroUsuario(boolean renderCadastroUsuario) {
        this.renderCadastroUsuario = renderCadastroUsuario;
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
