package com.saaiidmoran.infijoprefijo.service;

/**
 *
 * @author saaii
 */

import com.saaiidmoran.infijoprefijo.pila.Pila;
 
public class ConvertirExpresion {
    
    public String Infijo2PrefijoTxt(String infijo){
         Pila pilaPrefijo = pilaConvertirPrefijo(depurarExpresion(infijo));
         StringBuilder text = new StringBuilder();
         while (!pilaPrefijo.estaVacia()){
             text.append(pilaPrefijo.sacar());
         }
          return text.toString();
     }
    
    public String Infijo2PosfijoTxt(String infijo){
        Pila pilaPostfijo = pilaConvertirPosfijo(depurarExpresion(infijo));
        StringBuilder text = new StringBuilder();
        while (!pilaPostfijo.estaVacia()){
            text.append(pilaPostfijo.sacar());
        }  
        return text.reverse().toString();
    }
    
    private Pila pilaConvertirPrefijo(String infijo) {
        infijo = '(' + infijo ; // Agregamos al final del infijo un '('
        int tamaño = infijo.length();
        Pila PilaDefinitiva = new Pila();
        Pila PilaTemp = new Pila();
        PilaTemp.empujar(")"); // Agregamos a la pila temporal un ')'
        for (int i = tamaño-1; i > -1; i--) {
            char caracter = infijo.charAt(i);
            switch (caracter) {
            case ')':
                PilaTemp.empujar(Character.toString(caracter));
                break;
            case '+':case '-':case '^':case '*':case '/': case '=':
                while (jerarquiaSignosPrefijo(caracter) > jerarquiaSignosPrefijo(PilaTemp.getCima().getDato().charAt(0)))
                    PilaDefinitiva.empujar(PilaTemp.sacar());
                PilaTemp.empujar(Character.toString(caracter));
                break;
            case '(':
                while (PilaTemp.getCima().getDato().charAt(0) != ')')
                    PilaDefinitiva.empujar(PilaTemp.sacar());
                PilaTemp.sacar();
                break;
            default:
                PilaDefinitiva.empujar(Character.toString(caracter));
            }
        }
        return PilaDefinitiva;
    }
    
    private Pila pilaConvertirPosfijo(String infijo) {
       infijo += ')'; // Agregamos al final del infijo un ')'
       int tamaño = infijo.length();
       Pila PilaDefinitiva = new Pila();
       Pila PilaTemp = new Pila();
       PilaTemp.empujar("("); // Agregamos a la pila temporal un '('
       for (int i = 0; i < tamaño; i++) { 
           char caracter = infijo.charAt(i);
           switch (caracter) {
               case '(': 
                   PilaTemp.empujar(Character.toString(caracter)); 
               break; 
               case '+':case '-':case '^':case '*':case '/': case '=': 
                   while (jerarquiaSignosPostfijo(caracter) <= jerarquiaSignosPostfijo(PilaTemp.getCima().getDato().charAt(0)))
                       PilaDefinitiva.empujar(PilaTemp.sacar());
                   PilaTemp.empujar(Character.toString(caracter));
                   break;
               case ')': 
                   while (PilaTemp.getCima().getDato().charAt(0) != '(')
                       PilaDefinitiva.empujar(PilaTemp.sacar());
                   PilaTemp.sacar();
                   break;
               default:
                   PilaDefinitiva.empujar(Character.toString(caracter));
           } 
       } return PilaDefinitiva;
    }
    private int jerarquiaSignosPostfijo(char elemento) {
        int res = 0; 
        switch (elemento) {
            case ')':  
                res = 5;
                break;
            case '^':
                res = 4;
                break; 
            case '*': case '/':
                res = 3;
                break;
            case '+': case '-': case '=': 
                res = 2;
                break;
            case '(': 
                res = 1; 
                break;          
        } return res; 
    }

    private int jerarquiaSignosPrefijo(char elemento) {
        int res = 0;
        switch (elemento) {
            case ')': case '=':
                res = 5; 
                break;
            case '^':
                res = 2; 
                break;
            case '*': case '/':
                res = 3; 
                break;
            case '+': case '-': 
                res = 4; 
                break;
            case '(':
                res = 1; 
                break;
        }
        return res;
    }
    
    private String depurarExpresion(String s) {
        StringBuilder construirRetorno = new StringBuilder();
        String sSinEspacios = s.replaceAll("\\s+", ""); //Elimina espacios en blanco
        //Deja espacios entre operadores
        for (int i = 0; i < sSinEspacios.length(); i++) {        
          if("+-*/()^".contains(Character.toString(sSinEspacios.charAt(i)))) {
            construirRetorno.append(" ").append(sSinEspacios.charAt(i)).append(" ");
          }else{
              construirRetorno.append(sSinEspacios.charAt(i));
          }      
        }
        return construirRetorno.toString().replaceAll("\\s+", " ").trim(); //Retorna la expresion depurada 
        //.trim para quitarle los espacios al principio y al final solamente
    }
}
