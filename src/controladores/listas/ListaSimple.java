/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.listas;

/**
 * Lista simple de temas
 * @author Johan
 */
class ListaSimple<T>{
    protected NodoSimple<T> inicio;
    
    ListaSimple(){
        inicio = null;
    }
    
    public boolean estaVacia(){
        return inicio == null;
    }
    
    /**
     * Agrega nodos al final
     * @param dato 
     */
    public void agregar(T dato){
        NodoSimple<T> nuevo = new NodoSimple<>(dato);
        if(!estaVacia()){
           NodoSimple<T> actual = inicio;
           while(actual.sig != null){
               actual = actual.sig;
           }
           actual.sig = nuevo;
        }else{
           inicio = nuevo;
        }
    }
    
    /**
     * Obtiene el nodo en la posicion i.Las posiciones van de 0 a n-1
     * @param index 
     * @return  
     */
    public T obtener(int index){
        T dato = null;
        if(!estaVacia()){
            
            NodoSimple<T> actual = inicio;
            while(index > 0 && actual != null){
                actual = actual.sig;
                index--;
            }
            if(index == 0 && actual != null){
                dato = actual.getDato();
            }
        }
        return dato;
    }
    
    public int getLength(){
        int length = 0;
        if(!estaVacia()){
            NodoSimple<T> actual = inicio;
            while(actual != null){
                actual = actual.sig;
                length++;
            }
        }
        return length;
    }
    
    public void ordenarPor(String atributo){
        ordenarPor(atributo, "asc");
    }
    
    /**
     * Ordenamiento segun flujo ascendente o descendente
     * @param atributo 
     * @param flujo asc o desc
     */
    public void ordenarPor(String atributo, String flujo){}
}
