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
    
    public static boolean validarExpresionMatematica(String expresion){
        return !campoVacio(expresion) && expresion.matches("[0-9([+]|[-]|[/]|[*]|[(]|[)]|[(^)])]+") && estaBienEscrita(expresion);
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
    
    private static boolean estaBienEscrita(String ex){
        int contadorParentesis[] = new int[2];
        for(int i = 0; i < ex.length(); i++){
            switch(ex.charAt(i)){
                case '(':
                    contadorParentesis[0]++;
                    if(i != ex.length()-1 && ex.charAt(i+1) == ')'){
                        return false;
                    }
                    break;
                case ')':
                    contadorParentesis[1]++;
                    break;
                case '+': case '-': case '*': case '/': case '^':
                    if(i != ex.length()-1 && esSigno(""+ex.charAt(i+1))){
                        return false;
                    }else
                    if(i == ex.length()-1 && esSigno(""+ex.charAt(i))){
                        return false;
                    }
                break;
            }
        }
        
        return (contadorParentesis[0] == contadorParentesis[1]);
        
    }
    
    private static boolean esSigno(String a){
        return "+-*/^".contains(a);
    }
    
    /*public static void main (String args[]){
    System.out.println(estaBienEscrita("1+2+3+4+5-*6"));
    }*/
    
}
