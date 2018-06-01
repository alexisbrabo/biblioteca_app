/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexis.converter;

import br.com.alexis.beans.AutorBean;
import br.com.alexis.models.Autor;
import br.com.alexis.padrao.Bean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author alexisbrabo
 */
@FacesConverter(forClass = Autor.class)
public class AutorConverter extends ConverterUtil implements Converter {

    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {

        if (string == null || string.equals("")) {
            return null;
        }
        Integer id = Integer.parseInt(string);
        Autor obj = (Autor) getBean().findByPrimaryKey(Autor.class, id);
        return obj;
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Autor obj = (Autor) o;
        return obj.getId().toString();
    }

}
