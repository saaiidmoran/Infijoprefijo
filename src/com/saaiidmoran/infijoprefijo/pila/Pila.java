/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saaiidmoran.infijoprefijo.pila;

/**
 *
 * @author Laura Vivar
 */
public class Pila {
    int longi;
    char [] ccarac;
    public int i;
    
    public Pila(int tamaño){
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
