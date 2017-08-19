/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexis.views;

import br.com.alexis.models.Livro;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import net.bootsfaces.utils.FacesMessages;

/**
 *
 * @author alexisbrabo
 */
@ManagedBean
public class indexView implements Serializable {

    private boolean renderCadastroLivro;
    private boolean renderCadastroAutor;
    private Livro livro;

    public void message() {
        FacesMessages.info("TESTE");
    }

    public void renderizarCadastroLivro() {
        livro = new Livro();
        renderCadastroLivro = true;
    }

    public void desRenderizarCadastroLivro() {
        renderCadastroLivro = false;
    }

    public void sair() {
        renderCadastroLivro = false;
    }

    public void confirmarLivro() {

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

}
