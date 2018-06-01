package br.com.alexis.views;

import br.com.alexis.beans.UsuarioBean;
import br.com.alexis.models.Usuario;
import br.com.alexis.padrao.View;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author alexisbrabo
 */
@ManagedBean
@ViewScoped
public class loginView extends View implements Serializable {

    @EJB
    private UsuarioBean usuarioBean;
    private String user;
    private String senha;

    public String logar() {

        Usuario usuario = usuarioBean.getUsuarioLogin(getUser(), getSenha());
        if (usuario != null) {
           
            return "index";
        }
        
        addMessageError("Erro", "Erro");
        return "";
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

}
