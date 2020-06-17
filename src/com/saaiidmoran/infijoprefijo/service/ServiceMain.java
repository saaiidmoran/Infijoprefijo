package com.saaiidmoran.infijoprefijo.service;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author saaii
 */

public class ServiceMain {
    
    public Image generarIcono(){         
        Image icon = null;        
        try{
            icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/saaiidmoran/infijoprefijo/resources/Logo.png"));
        }catch(NullPointerException e){
            System.out.println("No se encontró el archivo para el icono \n" + e);
        }        
        return icon;        
    }
    
    public static boolean validarExpresionMAtematica(String expresion){
        return expresion.matches("[0-9([+]|[-]|[/]|[*]|[(]|[)]|[(^)])]+");
    }
    
    public static boolean campoVacio(String campo){
        return "".equals(campo);
    }
    
    public static boolean validaSignos(String ex){        
        int contador=0;
        for (int i = 0; i < ex.length(); i++) {
          if ("+-*/^".contains("" + ex.charAt(i))) {
            contador++;
          }
        }
        return contador>0;
    }
    
}
