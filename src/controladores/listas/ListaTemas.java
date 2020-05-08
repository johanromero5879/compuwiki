/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores.listas;

import modelos.Tema;

/**
 *
 * @author Johan
 */
public class ListaTemas extends ListaSimple<Tema>{
    @Override
    public void ordenarPor(String atributo){
        if(!estaVacia()){
            boolean ordeno;
            do{
                NodoSimple<Tema> actual = inicio, ant = null, sig = inicio.sig;
                ordeno = false;
                while(sig != null){
                    switch(atributo){
                        case "titulo":
                            ordeno = actual.getDato().getTitulo().compareToIgnoreCase(sig.getDato().getTitulo()) > 0;
                            break;
                        case "visitas":
                            ordeno = actual.getDato().getVisitas() < sig.getDato().getVisitas();
                            break;
                    }
                    if(ordeno){
                        if(ant != null){
                            ant.sig = sig; 
                        }else{
                            inicio = sig;
                        }
                        
                        actual.sig = sig.sig;
                        sig.sig = actual;
                            
                        ant = sig;
                        sig = actual.sig;
                    }else{
                        ant = actual;
                        actual = sig;
                        sig = sig.sig;
                    }
                }
            }while(ordeno);
        }
    }
}
