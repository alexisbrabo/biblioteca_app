package br.com.alexis.views;

import br.com.alexis.beans.UsuarioBean;
import br.com.alexis.models.Usuario;
import br.com.alexis.outros.Uteis;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import net.bootsfaces.utils.FacesMessages;

/**
 *
 * @author alexisbrabo
 */
@ManagedBean
@ViewScoped
public class loginView implements Serializable {

    @EJB
    private UsuarioBean usuarioBean;
    private String user;
    private String senha;

    public String logar() {

        Usuario usuario = usuarioBean.getUsuarioLogin(getUser(), getSenha());
        if (usuario != null) {
            FacesMessages.fatal("!");
            HttpSession session = Uteis.getSession();
            return "index";
        }
        FacesMessages.fatal("Nome do Livro Obrigatório!");
        FacesContext ctx = FacesContext.getCurrentInstance();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário inválido", "Usuário inválido");
        ctx.addMessage(null, msg);
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
