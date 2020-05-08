package modelos;

/**
 *
 * @author Johan Romero
 */
public class Recurso {
    private int tema;
    private String ruta;
    private String tipo;
    
    public Recurso(){}
    
    public Recurso(String ruta) {
        this.ruta = ruta;
    }
    
    public Recurso(String ruta, String tipo) {
        this.ruta = ruta;
        this.tipo = tipo;
    }
    
    public Recurso(int tema, String ruta, String tipo) {
        this.tema = tema;
        this.ruta = ruta;
        this.tipo = tipo;
    }

    public int getTema() {
        return tema;
    }

    public void setTema(int tema) {
        this.tema = tema;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
