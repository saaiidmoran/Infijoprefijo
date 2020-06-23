package com.saaiidmoran.infijoprefijo.beans;

/**
 *
 * @author saaii
 */
public class Variable {
    
    public Variable(){
        
    }
    
    public Variable(String var){
        this.var = var;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    private String var;
    private String valor;
    
}
