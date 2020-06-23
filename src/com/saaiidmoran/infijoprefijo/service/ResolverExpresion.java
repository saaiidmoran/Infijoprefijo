package com.saaiidmoran.infijoprefijo.service;

import com.saaiidmoran.infijoprefijo.pila.Pila;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author saaii
 */

public class ResolverExpresion {
   
    public String ResulevePref(String prefijo){
        return quitarCorchetes(ResulevePrefTabla(prefijo).getValueAt(ResulevePrefTabla(prefijo).getRowCount()-1, 1).toString());
    }    
    public String ResulevePost(String postfijo){
        return quitarCorchetes(ResulevePostTabla(postfijo).getValueAt(ResulevePostTabla(postfijo).getRowCount()-1, 1).toString());
    }
    
    public DefaultTableModel ResulevePostTabla (String postfijo){
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("Símbolo");
        tabla.addColumn("Pila");
        String datos[]=new String[2];
        Pila p=new Pila();
        String operando = "";
        String actual;
        float v1,v2;
        for (int i=0;i<postfijo.length();i++){
            actual=postfijo.substring(i,i+1);
            switch(actual){ 
                case "+": case "-": case "*": case "/": case "^":
                    if(!"".equals(operando)){
                        p.empujar(operando);
                         datos[0]=operando;
                        datos[1]="["+p.Recorrer()+"]";
                        tabla.addRow(datos);
                        operando="";
                    }
                    v1=Float.parseFloat(p.sacar());
                    v2=Float.parseFloat(p.sacar());

                    switch(actual){
                        case "+":
                                p.empujar(String.valueOf(v2+v1)); //
                        break;

                        case "-":
                                p.empujar(String.valueOf(v2-v1)); //
                        break;

                        case "*":
                                p.empujar(String.valueOf(v2*v1)); //
                        break;

                        case "/":
                                p.empujar(String.valueOf(v2/v1)); //
                        break;

                        case "^":
                                p.empujar(String.valueOf(potenciaConRecursion(v2,v1))); //
                        break;
                    }

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
                    while(ServiceMain.isNumeric(actual)){
                    operando += actual;
                    break;
                    }
                    break;
            }
        }
        return tabla;
    }
    
    public DefaultTableModel ResulevePrefTabla (String prefijo){
        prefijo=Voltear(prefijo);
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("Símbolo");
        tabla.addColumn("Pila");
        String datos[]=new String[2];
        Pila p=new Pila();
        String operando = "";
        String actual;
        float v1,v2;
        // Integer.parseInt(variable); para transformar String a entero
        for (int i=0;i<prefijo.length();i++){
            actual=prefijo.substring(i,i+1);
            switch(actual){ 
                case "+": case "-": case "*": case "/": case "^":
                    if(!"".equals(operando)){
                        p.empujar(operando);
                        datos[0]=operando;
                        datos[1]=p.Recorrer1();
                        tabla.addRow(datos);
                        operando="";
                    }
                    v1=Float.parseFloat(p.sacar());
                    v2=Float.parseFloat(p.sacar());
                    switch(actual){
                        case "+":
                                p.empujar(String.valueOf(v1+v2));
                        break;

                        case "-":
                                p.empujar(String.valueOf(v1-v2));
                        break;

                        case "*":
                                p.empujar(String.valueOf(v1*v2));
                        break;

                        case "/":
                                p.empujar(String.valueOf(v1/v2));
                        break;

                        case "^":
                                p.empujar(String.valueOf(potenciaConRecursion(v1,v2)));
                        break;
                    }
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
                    while(ServiceMain.isNumeric(actual)){
                    operando = actual+operando;
                    break;
                    }
                break;
            }
        }
        return tabla;
    }
    
    private String Voltear(String cadena){
        if(cadena.length()==1){
            return cadena;
        }
        else{
            return Voltear(cadena.substring(1))+cadena.charAt(0);
        }
    }
    
    private float potenciaConRecursion (float m, float n) {
        if (n==0) {
            return 1;
        } else  { 
            return m * potenciaConRecursion (m, n-1); 
        }
    } //Cierre del método
     
    private String quitarCorchetes(String r){
        StringBuilder retorno = new StringBuilder();
        retorno.append(r.substring(1, r.length()-1));
        return retorno.toString();
    }
}

