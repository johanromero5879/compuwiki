package modelos;

/**
 *
 * @author Johan Romero
 */
public class Usuario {
    private int id;
    private String nombre;
    private String contrasena;
    private String rol;
    
    public Usuario(){}
    
    public Usuario(int id, String nombre, String rol) {
        this(id, nombre, null, rol);
    }
    
    public Usuario(int id, String nombre, String contrasena, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
}
