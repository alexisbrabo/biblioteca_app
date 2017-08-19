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
}
