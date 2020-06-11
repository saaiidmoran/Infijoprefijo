/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infijoprefijo;

/**
 *
 * @author saaii
 */
import javax.swing.JOptionPane;
 
public class Pilas {
 
    
   public String Infijo2PrefijoTxt(String infijo){
        Pila p1 = Infijo2Prefijo(infijo);
        String text = "";
        while (p1.i > 0)
            text += p1.pop();
        return text;
 
    }
   public String Infijo2PosfijoTxt(String infijo){
    Pila p1 = Infijo2Posfijo(infijo);
        String text = "";
        while (p1.i > 0)
        text = p1.pop() + text;
        return text;
    }
    public static Pila Infijo2Prefijo(String infijo) {
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
                while (Jerarquia(caracter) > Jerarquia(PilaTemp.nextPop()))
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
    
 public static Pila Infijo2Posfijo(String infijo) {
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
            while (Jerarquia1(caracter) <= Jerarquia1(PilaTemp.nextPop()))
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
 public static int Jerarquia1(char elemento) {
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
                   res = 1; break;          
     } return res; 
 }

    public static int Jerarquia(char elemento) {
        int res = 0;
        switch (elemento) {
        case ')': case '=':
            res = 5; break;
        case '^':
            res = 2; break;
        case '*': case '/':
            res = 3; break;
        case '+': case '-': 
            res = 4; break;
        case '(':
            res = 1; break;
        }
        return res;
    }
    
    public String Depurar(String s) {
    s = s.replaceAll("\\s+", ""); //Elimina espacios en blanco
    String simbols = "+-*/()^=";
    String str = "";
  
    //Deja espacios entre operadores
    for (int i = 0; i < s.length(); i++) {
      if (simbols.contains("" + s.charAt(i))) {
        str += " " + s.charAt(i) + " ";
      }else str += s.charAt(i);
    }
    return str.replaceAll("\\s+", " ").trim();
  }
}
