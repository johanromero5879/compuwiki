/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.listas;


/**
 * Nodo simple
 * @author Johan
 */
class NodoSimple<T>{
    private T dato;
    protected NodoSimple sig;
    
    public NodoSimple(T dato) {
        this(dato, null);
    }
    
    public NodoSimple(T dato, NodoSimple sig) {
        this.dato = dato;
        this.sig = sig;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }
}
