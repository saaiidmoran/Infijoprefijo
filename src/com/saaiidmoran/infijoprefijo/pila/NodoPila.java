package com.saaiidmoran.infijoprefijo.pila;

/**
 *
 * @author saaii
 */

public class NodoPila {
    
    private String dato;
    private NodoPila siguiente;
    
    public NodoPila(){
        
    }
    
    public NodoPila(String d){
        dato=d;
        siguiente=null;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public NodoPila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }    
}
