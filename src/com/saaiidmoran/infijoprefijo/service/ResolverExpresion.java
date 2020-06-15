package com.saaiidmoran.infijoprefijo.service;

import com.saaiidmoran.infijoprefijo.pila.Pila;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author saaii
 */

public class ResolverExpresion {
   
   public String ResulevePref(String prefijo){
   prefijo=Voltear(prefijo);  
   String resultado = "";
   Pila p=new Pila();
   String operando = "";
   String actual;
   float v1,v2;
    // Integer.parseInt(variable); para transformar String a entero
    for (int i=0;i<prefijo.length();i++){
        actual=prefijo.substring(i,i+1);
        //JOptionPane.showMessageDialog(null, actual);
        switch(actual){
            case "+":
                if(!"".equals(operando)){
                    p.empujar(operando);
                    operando="";
                    //JOptionPane.showMessageDialog(null,"Se agregó operando: "+p.cima()); 
                }
                v1=Float.parseFloat(p.sacar());
                v2=Float.parseFloat(p.sacar());
                p.empujar(String.valueOf(v1+v2));
                break;
            case "-":
                if(!"".equals(operando)){
                    p.empujar(operando);
                    operando="";
                    //JOptionPane.showMessageDialog(null,"Se agregó operando: "+p.cima()); 
                }
                v1=Float.parseFloat(p.sacar());
                v2=Float.parseFloat(p.sacar());
                p.empujar(String.valueOf(v1-v2));
                break;
            case "*":
                if(!"".equals(operando)){
                    p.empujar(operando);
                    operando="";
                    //JOptionPane.showMessageDialog(null,"Se agregó operando: "+p.cima()); 
                }
                v1=Float.parseFloat(p.sacar());
                v2=Float.parseFloat(p.sacar());
                p.empujar(String.valueOf(v1*v2));
                break;
            case "/":
                if(!"".equals(operando)){
                    p.empujar(operando);
                    operando="";
                    //JOptionPane.showMessageDialog(null,"Se agregó operando: "+p.cima()); 
                }
                v1=Float.parseFloat(p.sacar());
                v2=Float.parseFloat(p.sacar());
                p.empujar(String.valueOf(v1/v2));
                break;
            case "^":
                if(!"".equals(operando)){
                    p.empujar(operando);
                    operando="";
                    //JOptionPane.showMessageDialog(null,"Se agregó operando: "+p.cima()); 
                }
                v1=Float.parseFloat(p.sacar());
                v2=Float.parseFloat(p.sacar());
                p.empujar(String.valueOf(potenciaConRecursion(v1,v2)));
                break;
            case " ":
                if(!"".equals(operando)){
                    p.empujar(operando);
                    operando="";
                    //JOptionPane.showMessageDialog(null,"Se agregó operando: "+p.cima()); 
                }
                break;
            default:
                while(isNumeric(actual)){
                operando = actual+operando;
                break;
                }
                break;
        }
    }
    resultado=p.sacar();
    if(!p.estaVacia()){
      //JOptionPane.showMessageDialog(null,"Hay un error");  
    }
    return resultado;
    }
    
    public String ResulevePost(String postfijo){
    String resultado = "";
   Pila p=new Pila();
   String operando = "";
   String actual;
   float v1,v2;
    // Integer.parseInt(variable); para transformar String a entero
    for (int i=0;i<postfijo.length();i++){
        actual=postfijo.substring(i,i+1);
        //JOptionPane.showMessageDialog(null, actual);
        switch(actual){
            case "+":
                if(!"".equals(operando)){
                    p.empujar(operando);
                    operando="";
                    //JOptionPane.showMessageDialog(null,"Se agregó operando: "+p.cima()); 
                }
                v1=Float.parseFloat(p.sacar());
                v2=Float.parseFloat(p.sacar());
                p.empujar(String.valueOf(v2+v1));
                break;
            case "-":
                if(!"".equals(operando)){
                    p.empujar(operando);
                    operando="";
                    //JOptionPane.showMessageDialog(null,"Se agregó operando: "+p.cima()); 
                }
                v1=Float.parseFloat(p.sacar());
                v2=Float.parseFloat(p.sacar());
                p.empujar(String.valueOf(v2-v1));
                break;
            case "*":
                if(!"".equals(operando)){
                    p.empujar(operando);
                    operando="";
                    //JOptionPane.showMessageDialog(null,"Se agregó operando: "+p.cima()); 
                }
                v1=Float.parseFloat(p.sacar());
                v2=Float.parseFloat(p.sacar());
                p.empujar(String.valueOf(v2*v1));
                break;
            case "/":
                if(!"".equals(operando)){
                    p.empujar(operando);
                    operando="";
                    //JOptionPane.showMessageDialog(null,"Se agregó operando: "+p.cima()); 
                }
                v1=Float.parseFloat(p.sacar());
                v2=Float.parseFloat(p.sacar());
                p.empujar(String.valueOf(v2/v1));
                break;
            case "^":
                if(!"".equals(operando)){
                    p.empujar(operando);
                    operando="";
                    //JOptionPane.showMessageDialog(null,"Se agregó operando: "+p.cima()); 
                }
                v1=Float.parseFloat(p.sacar());
                v2=Float.parseFloat(p.sacar());
                p.empujar(String.valueOf(potenciaConRecursion(v2,v1)));
                break;
            case " ":
                if(!"".equals(operando)){
                    p.empujar(operando);
                    operando="";
                    //JOptionPane.showMessageDialog(null,"Se agregó operando: "+p.cima()); 
                }
                break;
            default:
                while(isNumeric(actual)){
                operando += actual;
                break;
                }
                break;
        }
    }
    resultado=p.sacar();
    if(!p.estaVacia()){
      //JOptionPane.showMessageDialog(null,"Hay un error");  
    }
    return resultado;
    }
    
    public DefaultTableModel ResulevePostTabla (String postfijo){
    DefaultTableModel tabla = new DefaultTableModel();
    tabla.addColumn("Símbolo");
    tabla.addColumn("Pila");
    String datos[]=new String[2];
    String resultado = "";
    Pila p=new Pila();
    String operando = "";
    String actual;
    float v1,v2;
    // Integer.parseInt(variable); para transformar String a entero
    for (int i=0;i<postfijo.length();i++){
        actual=postfijo.substring(i,i+1);
        switch(actual){ 
            case "+":
                if(!"".equals(operando)){
                    p.empujar(operando);
                     datos[0]=operando;
                    datos[1]="["+p.Recorrer()+"]";
                    tabla.addRow(datos);
                    operando="";
                }
                v1=Float.parseFloat(p.sacar());
                v2=Float.parseFloat(p.sacar());
                p.empujar(String.valueOf(v2+v1));
                datos[0]=actual;
                datos[1]="["+p.Recorrer()+"]";
                tabla.addRow(datos);
                break;
            case "-":
                if(!"".equals(operando)){
                    p.empujar(operando);
                     datos[0]=operando;
                    datos[1]="["+p.Recorrer()+"]";
                    tabla.addRow(datos);
                    operando="";
                }
                v1=Float.parseFloat(p.sacar());
                v2=Float.parseFloat(p.sacar());
                p.empujar(String.valueOf(v2-v1));
                datos[0]=actual;
                datos[1]="["+p.Recorrer()+"]";
                tabla.addRow(datos);
                break;
            case "*":
                if(!"".equals(operando)){
                    p.empujar(operando);
                     datos[0]=operando;
                    datos[1]="["+p.Recorrer()+"]";
                    tabla.addRow(datos);
                    operando="";
                }
                v1=Float.parseFloat(p.sacar());
                v2=Float.parseFloat(p.sacar());
                p.empujar(String.valueOf(v2*v1));
                datos[0]=actual;
                datos[1]=p.Recorrer();
                tabla.addRow(datos);
                break;
            case "/":
                if(!"".equals(operando)){
                    p.empujar(operando);
                     datos[0]=operando;
                    datos[1]="["+p.Recorrer()+"]";
                    tabla.addRow(datos);
                    operando="";
                }
                v1=Float.parseFloat(p.sacar());
                v2=Float.parseFloat(p.sacar());
                p.empujar(String.valueOf(v2/v1));
                datos[0]=actual;
                datos[1]="["+p.Recorrer()+"]";
                tabla.addRow(datos);
                break;
            case "^":
                if(!"".equals(operando)){
                    p.empujar(operando);
                     datos[0]=operando;
                    datos[1]="["+p.Recorrer()+"]";
                    tabla.addRow(datos);
                    operando="";
                }
                v1=Float.parseFloat(p.sacar());
                v2=Float.parseFloat(p.sacar());
                p.empujar(String.valueOf(potenciaConRecursion(v2,v1)));
                datos[0]=actual;
                datos[1]="["+p.Recorrer()+"]";
                tabla.addRow(datos);
                break;
            case " ":
                if(!"".equals(operando)){
                    p.empujar(operando);
                    datos[0]=operando;
                    datos[1]="["+p.Recorrer()+"]";
                    tabla.addRow(datos);
                    operando="";
                }
                break;
            default:
                while(isNumeric(actual)){
                operando += actual;
                break;
                }
                break;
        }
    }
    resultado=p.sacar();
    if(!p.estaVacia()){ 
    }
    return tabla;
    }
    
    public DefaultTableModel ResulevePrefTabla (String prefijo){
    prefijo=Voltear(prefijo);
    DefaultTableModel tabla = new DefaultTableModel();
    tabla.addColumn("Símbolo");
    tabla.addColumn("Pila");
    String datos[]=new String[2];
    String resultado = "";
    Pila p=new Pila();
    String operando = "";
    String actual;
    float v1,v2;
    // Integer.parseInt(variable); para transformar String a entero
    for (int i=0;i<prefijo.length();i++){
        actual=prefijo.substring(i,i+1);
        switch(actual){ 
            case "+":
                if(!"".equals(operando)){
                    p.empujar(operando);
                    datos[0]=operando;
                    datos[1]=p.Recorrer1();
                    tabla.addRow(datos);
                    operando="";
                }
                
                v1=Float.parseFloat(p.sacar());
                v2=Float.parseFloat(p.sacar());
                p.empujar(String.valueOf(v1+v2));
                datos[0]=actual;
                datos[1]=p.Recorrer1();
                tabla.addRow(datos);
                break;
            case "-":
                if(!"".equals(operando)){
                    p.empujar(operando);
                    datos[0]=operando;
                    datos[1]=p.Recorrer1();
                    tabla.addRow(datos);
                    operando="";
                }
                
                v1=Float.parseFloat(p.sacar());
                v2=Float.parseFloat(p.sacar());
                p.empujar(String.valueOf(v1-v2));
                datos[0]=actual;
                datos[1]=p.Recorrer1();
                tabla.addRow(datos);
                break;
            case "*":
                if(!"".equals(operando)){
                    p.empujar(operando);
                    datos[0]=operando;
                    datos[1]=p.Recorrer1();
                    tabla.addRow(datos);
                    operando="";
                }
                
                v1=Float.parseFloat(p.sacar());
                v2=Float.parseFloat(p.sacar());
                p.empujar(String.valueOf(v1*v2));
                datos[0]=actual;
                datos[1]=p.Recorrer1();
                tabla.addRow(datos);
                break;
            case "/":
                if(!"".equals(operando)){
                    p.empujar(operando);
                    datos[0]=operando;
                    datos[1]=p.Recorrer1();
                    tabla.addRow(datos);
                    operando="";
                }
                
                v1=Float.parseFloat(p.sacar());
                v2=Float.parseFloat(p.sacar());
                p.empujar(String.valueOf(v1/v2));
                datos[0]=actual;
                datos[1]=p.Recorrer1();
                tabla.addRow(datos);
                break;
            case "^":
                if(!"".equals(operando)){
                    p.empujar(operando);
                    datos[0]=operando;
                    datos[1]=p.Recorrer1();
                    tabla.addRow(datos);
                    operando="";
                }
                
                v1=Float.parseFloat(p.sacar());
                v2=Float.parseFloat(p.sacar());
                p.empujar(String.valueOf(potenciaConRecursion(v1,v2)));
                datos[0]=actual;
                datos[1]=p.Recorrer1();
                tabla.addRow(datos);
                break;
            case " ":
                if(!"".equals(operando)){
                    p.empujar(operando);
                    datos[0]=operando;
                    datos[1]=p.Recorrer1();
                    tabla.addRow(datos);
                    operando=""; 
                }
                break;
            default:
                while(isNumeric(actual)){
                operando = actual+operando;
                break;
                }
                break;
        }
    }
    resultado=p.sacar();
    if(!p.estaVacia()){ 
    }
    return tabla;
    }
    
    private static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
}
    
    public boolean Valida(String ex){
        String simbols = "+-*/^";
        int contador=0;
        for (int i = 0; i < ex.length(); i++) {
          if (simbols.contains("" + ex.charAt(i))) {
            contador++;
          }
        }
        return contador>0;
    }
    
    private String Voltear(String cadena){
        if(cadena.length()==1){
            return cadena;
        }
        else{
            return Voltear(cadena.substring(1))+cadena.charAt(0);
        }
    }
    
     public float potenciaConRecursion (float m, float n) {
        if (n==0) { return 1;
        } else  { return m * potenciaConRecursion (m, n-1); }
    } //Cierre del método
}
