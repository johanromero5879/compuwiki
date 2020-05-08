package modelos;

import controladores.listas.ListaRecursos;
import controladores.listas.ListaSecciones;


/**
 *
 * @author Johan Romero
 */
public class Tema {
    private int id;
    private String titulo;
    private String descripcion;
    private String referencias;
    private int visitas;
    private Tema origen; //Tema padre
    private ListaSecciones secciones;
    private ListaRecursos recursos;
    
    public Tema(){
        this.secciones = new ListaSecciones();
        this.recursos = new ListaRecursos();
    }
    
    public Tema(int id, String titulo, String descripcion, String referencias, int visitas, Tema origen){
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.referencias = referencias;
        this.visitas = visitas;
        this.origen = origen;
        this.secciones = new ListaSecciones();
        this.recursos = new ListaRecursos();
    }
        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getReferencias() {
        return referencias;
    }

    public void setReferencias(String referencias) {
        this.referencias = referencias;
    }
    
    public int getVisitas() {
        return visitas;
    }

    public void setVisitas(int visitas) {
        this.visitas = visitas;
    }

    public Tema getOrigen() {
        return origen;
    }

    public void setOrigen(Tema origen) {
        this.origen = origen;
    }

    public ListaSecciones getSecciones() {
        return secciones;
    }

    public void setSecciones(ListaSecciones secciones) {
        this.secciones = secciones;
    }

    public ListaRecursos getRecursos() {
        return recursos;
    }

    public void setRecursos(ListaRecursos recursos) {
        this.recursos = recursos;
    }
    
    
}
