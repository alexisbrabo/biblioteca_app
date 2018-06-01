/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alexis.converter;

import br.com.alexis.beans.AutorBean;
import br.com.alexis.padrao.Bean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author alexisbrabo
 */
public class ConverterUtil {

    public Bean getBean() {
        try {
            Context c = new InitialContext();
            AutorBean a = (AutorBean) c.lookup("java:global/bibliotecaApp/AutorBean!br.com.alexis.beans.AutorBean");
            return a;
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
