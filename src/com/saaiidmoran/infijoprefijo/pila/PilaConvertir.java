package com.saaiidmoran.infijoprefijo.pila;

/**
 *
 * @author Laura Vivar
 */

public class PilaConvertir {
    int longi;
    char [] ccarac;
    public int i;
    
    public PilaConvertir(int tamaño){
        this.longi=tamaño;
        this.ccarac=new char[tamaño];
        this.i=0;        
    }
    public boolean push (char item){
        if(i<longi){
            ccarac[i++]=item;
            return true;
        }
        return false;
    }
    public char pop(){
        if(i<=0)
            return 0;
        return ccarac[--i];
    }
    public char nextPop(){
        if(i<=0)
            return 0;
        return ccarac[i-1];
    }
}
