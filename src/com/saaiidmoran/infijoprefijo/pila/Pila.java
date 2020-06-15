package com.saaiidmoran.infijoprefijo.pila;

/**
 *
 * @author saaii
 */

public class Pila {
    
    private NodoPila cima;
    private int tama;
    
    public Pila(){
        cima=null;
        tama=0;
    }
    
    //Metodo para saber cuando la pila esta vacía
    public boolean estaVacia(){
        return getCima() == null;
    }
    
    //Metodo para empujar (push) un elemento a la pila
    public void empujar(String elem){
        NodoPila nuevo=new NodoPila(elem);
        nuevo.setSiguiente(getCima());
        this.cima=nuevo;
        this.tama++;
    }
    
    //Metodo para sacar (pop) un elemento a la pila
    public String sacar(){
        String auxiliar=getCima().getDato();
        this.cima=getCima().getSiguiente();
        this.tama--;
        return auxiliar;
    }
    
    //Metodo para saber quien está en la cima de la pila
    public NodoPila getCima(){
        return this.cima;
    }
     
    //Metodo para saber el tamaño de la pila
    public int getTamano(){
        return this.tama;
    }
    
    //Metodo para limpiar la pila
    public void limpiarPila(){
        while(!estaVacia()){
            sacar();
        }
    }
    
    public String Recorrer() {
        NodoPila reco=cima;
        StringBuilder listado = new StringBuilder();
        String datos[]=new String[getTamano()];
        for(int i=getTamano()-1;i>=0;i--) {
            datos[i]=reco.getDato();
            reco=reco.getSiguiente();
        }
        for(int j=0;j<getTamano();j++){
            if(j==getTamano()-1){
            listado.append(datos[j]);   
            }else{
            listado.append(datos[j]).append(",");
            }
        }
        return listado.toString();
    }
    public String Recorrer1() {
        NodoPila reco=getCima();
        StringBuilder listado = new StringBuilder();        
        String datos[]=new String[getTamano()];
        listado.append("[");
        for(int i=getTamano()-1;i>=0;i--) {
            datos[i]=reco.getDato();
            reco=reco.getSiguiente();
        }
        for(int j=0;j<getTamano();j++){
            if(j==getTamano()-1){
            listado.append(datos[j]);   
            }else{
            listado.append(datos[j]).append(",");
            }
        }
        listado.append("]");
        return listado.toString();
    }
}