package controladores.listas;

import modelos.Recurso;

/**
 *
 * @author Johan
 */
public class ListaRecursos extends ListaSimple<Recurso>{
    @Override
    public void ordenarPor(String atributo){
        if(!estaVacia()){
            boolean ordeno;
            do{
                NodoSimple<Recurso> actual = inicio, ant = null, sig = inicio.sig;
                ordeno = false;
                while(sig != null){
                    switch(atributo){
                        case "tipo":
                            ordeno = actual.getDato().getTipo().compareToIgnoreCase(sig.getDato().getTipo()) > 0;
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
