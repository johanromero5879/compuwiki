package controladores.listas;

import modelos.Seccion;

/**
 *
 * @author Johan
 */
public class ListaSecciones extends ListaSimple<Seccion>{
    @Override
    public void ordenarPor(String atributo){
        if(!estaVacia()){
            boolean ordeno;
            do{
                NodoSimple<Seccion> actual = inicio, ant = null, sig = inicio.sig;
                ordeno = false;
                while(sig != null){
                    switch(atributo){
                        case "titulo":
                            ordeno = actual.getDato().getTitulo().compareToIgnoreCase(sig.getDato().getTitulo()) > 0;
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
