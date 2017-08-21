/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexis.outros;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import net.bootsfaces.utils.FacesMessages;

/**
 *
 * @author alexisbrabo
 */
public class Uteis {

    public static EntityManager JpaEntityManager() {

        FacesContext facesContext = FacesContext.getCurrentInstance();

        ExternalContext externalContext = facesContext.getExternalContext();

        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();

        return (EntityManager) request.getAttribute("entityManager");
    }

    //MOSTRAR MENSAGEM
    public static void Mensagem(String mensagem) {

        FacesContext facesContext = FacesContext.getCurrentInstance();

        facesContext.addMessage(null, new FacesMessage("Alerta", mensagem));
    }

    //MOSTRAR MENSAGEM
    public static void MensagemAtencao(String mensagem) {

        FacesMessages.warning(mensagem);
    }

    //MOSTRAR MENSAGEM
    public static void MensagemInfo(String mensagem) {

        FacesMessages.info(mensagem);
    }

    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
    }

    public static String getUserName() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        return session.getAttribute("username").toString();
    }

    public static String getUserId() {
        HttpSession session = getSession();
        if (session != null) {
            return (String) session.getAttribute("userid");
        } else {
            return null;
        }
    }

}
