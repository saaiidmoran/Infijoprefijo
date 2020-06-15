/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saaiidmoran.infijoprefijo;

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
    
}
