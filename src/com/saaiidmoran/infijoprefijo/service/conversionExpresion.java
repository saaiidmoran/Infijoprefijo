package com.saaiidmoran.infijoprefijo.service;

/**
 *
 * @author saaii
 */

import com.saaiidmoran.infijoprefijo.pila.PilaConvertir;
 
public class ConversionExpresion {
    
    private final String simbolos = "+-*/()^=";
    
    public String Infijo2PrefijoTxt(String infijo){
         PilaConvertir pilaPrefijo = convertirPrefijo(infijo);
         StringBuilder text = new StringBuilder();
         while (pilaPrefijo.i > 0){
             text.append(pilaPrefijo.pop());
         }
          return text.toString();
     }
    
    public String Infijo2PosfijoTxt(String infijo){
        PilaConvertir pilaPostfijo = convertirPosfijo(infijo);
        StringBuilder text = new StringBuilder();
        while (pilaPostfijo.i > 0){
            text.append(pilaPostfijo.pop());
        }  
        return text.reverse().toString();
    }
    
    private PilaConvertir convertirPrefijo(String infijo) {
        infijo = '(' + infijo ; // Agregamos al final del infijo un ')'
        int tamaño = infijo.length();
        PilaConvertir PilaDefinitiva = new PilaConvertir(tamaño);
        PilaConvertir PilaTemp = new PilaConvertir(tamaño);
        PilaTemp.push(')'); // Agregamos a la pila temporal un '('
        for (int i = tamaño-1; i > -1; i--) {
            char caracter = infijo.charAt(i);
            switch (caracter) {
            case ')':
                PilaTemp.push(caracter);
                break;
            case '+':case '-':case '^':case '*':case '/': case '=':
                while (jerarquiaSignosPrefijo(caracter) > jerarquiaSignosPrefijo(PilaTemp.nextPop()))
                    PilaDefinitiva.push(PilaTemp.pop());
                PilaTemp.push(caracter);
                break;
            case '(':
                while (PilaTemp.nextPop() != ')')
                    PilaDefinitiva.push(PilaTemp.pop());
                PilaTemp.pop();
                break;
            default:
                PilaDefinitiva.push(caracter);
            }
        }
        return PilaDefinitiva;
    }
    
    private PilaConvertir convertirPosfijo(String infijo) {
       infijo += ')'; // Agregamos al final del infijo un ‘)’
       int tamaño = infijo.length();
       PilaConvertir PilaDefinitiva = new PilaConvertir(tamaño);
       PilaConvertir PilaTemp = new PilaConvertir(tamaño);
       PilaTemp.push('('); // Agregamos a la pila temporal un ‘(‘
       for (int i = 0; i < tamaño; i++) { 
           char caracter = infijo.charAt(i);
           switch (caracter) {
               case '(': PilaTemp.push(caracter); break; 
               case '+':case '-':case '^':case '*':case '/': case '=': 
                   while (jerarquiaSignosPostfijo(caracter) <= jerarquiaSignosPostfijo(PilaTemp.nextPop()))
                       PilaDefinitiva.push(PilaTemp.pop());
                        PilaTemp.push(caracter);
                   break;
               case ')': 
                   while (PilaTemp.nextPop() != '(')
                       PilaDefinitiva.push(PilaTemp.pop());
                   PilaTemp.pop();
                   break;
               default:
                   PilaDefinitiva.push(caracter);
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
    
    public String Depurar(String s) {
        StringBuilder construirRetorno = new StringBuilder();
        String sSinEspacios = s.replaceAll("\\s+", ""); //Elimina espacios en blanco
        //Deja espacios entre operadores
        for (int i = 0; i < sSinEspacios.length(); i++) {        
          if(simbolos.contains("" + sSinEspacios.charAt(i))) {
            construirRetorno.append(" ").append(sSinEspacios.charAt(i)).append(" ");
          }else{
              construirRetorno.append(sSinEspacios.charAt(i));
          }      
        }
        return construirRetorno.toString().replaceAll("\\s+", " ").trim(); //Retorna la expresion depurada 
        //.trim para quitarle los espacios al principio y al final solamente
    }
}
