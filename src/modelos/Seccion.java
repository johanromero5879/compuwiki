package modelos;

/**
 *
 * @author Johan Romero
 */
public class Seccion {
    private int tema;
    private String titulo;
    private String descripcion;
    
    public Seccion(){}
    
    public Seccion(int tema, String titulo, String descripcion) {
        this.tema = tema;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public int getTema() {
        return tema;
    }

    public void setTema(int tema) {
        this.tema = tema;
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
}
