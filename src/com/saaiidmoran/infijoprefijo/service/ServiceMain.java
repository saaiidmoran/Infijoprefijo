package com.saaiidmoran.infijoprefijo.service;
import com.saaiidmoran.infijoprefijo.beans.Variable;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
        return !campoVacio(expresion) && expresion.matches("[0-9a-zA-Z([+]|[-]|[/]|[*]|[(]|[)]|[(^)])]+") && estaBienEscrita(expresion);
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
    
    private static boolean esLetra(String l){
        return l.matches("[a-zA-Z]{1}");
    }
    
    public static boolean isNumeric(String cadena){
	return cadena.matches("[0-9]{1}");
    }
    
    private static boolean esNumeroOrLetra(String x){
        return isNumeric(x) || esLetra(x);
    }
    
    public static String agregarSignosX(String x){
        StringBuilder retorno = new StringBuilder();
        for(int i = 0; i < x.length() ;i++){
            switch(x.charAt(i)){
                case ')':
                    if((i != x.length()-1 && x.charAt(i+1) == '(') ||
                        (i != x.length()-1 && esNumeroOrLetra(""+x.charAt(i+1)))
                      ){
                        retorno.append(x.charAt(i)).append("*");
                    }else{
                        retorno.append(x.charAt(i));
                    }
                break;
                
                case '(':
                    retorno.append(x.charAt(i));
                break;
                
                default:
                    if(esSigno(x.charAt(i)+"")){
                        retorno.append(x.charAt(i));
                    }else{
                        if(
                           (i != x.length()-1 && isNumeric("" + x.charAt(i)) && esLetra("" + x.charAt(i+1))) ||
                           (i != x.length()-1 && esLetra("" + x.charAt(i)) && isNumeric("" + x.charAt(i+1))) ||
                           (i != x.length()-1 && esLetra("" + x.charAt(i)) && esLetra("" + x.charAt(i+1))) ||
                           (i != x.length()-1 && x.charAt(i+1) == '(')
                          ){
                            retorno.append(x.charAt(i)).append("*");
                        }else{
                            retorno.append(x.charAt(i));
                        }                        
                    }               
                    
                break;
            }
        }
        return retorno.toString();
    }
    
    public static String sustituirLetraValor(String s){
        StringBuilder retorno = new StringBuilder();
        ArrayList<String> varsString = new ArrayList<>();
        ArrayList<Variable> varsObject = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            if(esLetra(Character.toString(s.charAt(i)))){
                String actual = Character.toString(s.charAt(i));
                if(!varsString.contains(actual)){
                    varsString.add(actual);
                    varsObject.add(new Variable(actual));
                }
            }
        }
        
        varsObject.forEach(v -> {
            String Op = JOptionPane.showInputDialog("Ingrese el valor de \"" + v.getVar() + "\"");
            while(!Op.matches("[0-9]+")){
                JOptionPane.showMessageDialog(null, "No se insertó un valor correcto, vuelva a ingresarlo","Error", JOptionPane.ERROR_MESSAGE);
                Op = JOptionPane.showInputDialog("Ingrese el valor de \"" + v.getVar() + "\"");
            }
            v.setValor(Op);
        });
        
        for(int i = 0; i < s.length(); i++){
            if(esLetra(Character.toString(s.charAt(i)))){
                for(Variable v : varsObject){
                    if(v.getVar().equals(Character.toString(s.charAt(i)))){
                        retorno.append(v.getValor());
                    }
                }
            }else{
                retorno.append(Character.toString(s.charAt(i)));
            }
        }
        return retorno.toString();        
    }
    
    /*public static void main (String args[]){
    System.out.println(sustituirLetraValor(agregarSignosX("1+2b+c")));
    }*/
    
}
