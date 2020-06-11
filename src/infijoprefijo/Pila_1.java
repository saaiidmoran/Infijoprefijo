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
public class Pila_1 {
    private NodoPila cima;
    int tama;
    public Pila_1(){
        cima=null;
        tama=0;
    }
    //Metodo para saber cuando la pila esta vacía
    public boolean estaVacia(){
        return cima==null;
    }
    //Metodo para empujar (push) un elemento a la pila
    public void empujar(String elem){
        NodoPila nuevo=new NodoPila(elem);
        nuevo.siguiente=cima;
        cima=nuevo;
        tama++;
    }
    //Metodo para sacar (pop) un elemento a la pila
    public String sacar(){
        String auxiliar=cima.dato;
        cima=cima.siguiente;
        tama--;
        return auxiliar;
    }
    //Metodo para saber quien está en la cima de la pila
    public String cima(){
        return cima.dato;
    }
    //Metodo para saber el tamaño de la pila
    public int tamano(){
        return tama;
    }
    //Metodo para limpiar la pila
    public void limpiarPila(){
        while(!estaVacia()){
            sacar();
        }
    }
    
    public String Recorrer() {
        NodoPila reco=cima;
        String listado="";
        String datos[]=new String[tamano()];
        for(int i=tamano()-1;i>=0;i--) {
            datos[i]=reco.dato;
            reco=reco.siguiente;
        }
        for(int j=0;j<tamano();j++){
            if(j==tamano()-1){
            listado+=datos[j];   
            }else{
            listado+=datos[j]+",";
            }
        }
        return listado;
    }
    public String Recorrer1() {
        NodoPila reco=cima;
        String listado="";
        String datos[]=new String[tamano()];
        for(int i=tamano()-1;i>=0;i--) {
            datos[i]=reco.dato;
            reco=reco.siguiente;
        }
        for(int j=0;j<tamano();j++){
            if(j==tamano()-1){
            listado+=datos[j];   
            }else{
            listado+=datos[j]+",";
            }
        }
        return "["+listado+"]";
    }
}
