/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saaiidmoran.infijoprefijo.service;

/**
 *
 * @author saaii
 */
import com.saaiidmoran.infijoprefijo.pila.Pila;
 
public class conversionExpresion {
    
    private final String simbols = "+-*/()^="; 
    
    public String Infijo2PrefijoTxt(String infijo){
         Pila p1 = Infijo2Prefijo(infijo);
         String text = "";
         while (p1.i > 0){
             text += p1.pop();
         }
          return text;

     }
    public String Infijo2PosfijoTxt(String infijo){
        Pila p1 = Infijo2Posfijo(infijo);
        String text = "";
        while (p1.i > 0){
            text = p1.pop() + text;
        }         
        return text;
    }
    private Pila Infijo2Prefijo(String infijo) {
        infijo = '(' + infijo ; // Agregamos al final del infijo un ')'
        int tamaño = infijo.length();
        Pila PilaDefinitiva = new Pila(tamaño);
        Pila PilaTemp = new Pila(tamaño);
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
    
    private Pila Infijo2Posfijo(String infijo) {
       infijo += ')'; // Agregamos al final del infijo un ‘)’
       int tamaño = infijo.length();
       Pila PilaDefinitiva = new Pila(tamaño);
       Pila PilaTemp = new Pila(tamaño);
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
        String sSinEspacios = s.replaceAll("\\s+", ""); //Elimina espacios en blanco
        //Deja espacios entre operadores
        String str = ""; 
        for (int i = 0; i < sSinEspacios.length(); i++) {        
          if(simbols.contains("" + sSinEspacios.charAt(i))) {
            str += " " + sSinEspacios.charAt(i) + " ";
          }else{
              str += sSinEspacios.charAt(i);
          }      
        }
        return str.replaceAll("\\s+", " ").trim(); //Retorna la expresion depurada 
        //.trim para quitarle los espacios al principio y al final solamente
    }
}
