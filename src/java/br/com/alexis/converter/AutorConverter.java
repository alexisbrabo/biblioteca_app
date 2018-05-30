/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexis.converter;

import br.com.alexis.beans.AutorBean;
import br.com.alexis.models.Autor;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;
import org.jboss.weld.context.ejb.Ejb;

/**
 *
 * @author alexisbrabo
 */
@FacesConverter(forClass = Autor.class)
public class AutorConverter implements Converter {

    @Ejb
    AutorBean autorBean;

    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.equals("")) {
            return null;
        }
        Integer id = Integer.parseInt(string);
        Autor obj = (Autor) autorBean.findAutorById(id);
        return obj;
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Autor obj = (Autor) o;
        return obj.getId().toString();
    }

}
