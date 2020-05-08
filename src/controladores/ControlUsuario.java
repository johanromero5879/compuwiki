package controladores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import modelos.Usuario;
import modelos.dao.DAOUsuario;

/**
 *
 * @author Johan Romero
 */
public class ControlUsuario{
    DAOUsuario daoUsuario;
    
    public ControlUsuario(String motorDB){
        daoUsuario = new DAOUsuario(motorDB);
    }
    
    private boolean validatePattern(String text, String pattern){
        Pattern reg = Pattern.compile(pattern);
        Matcher m = reg.matcher(text);
        return m.matches();
    }
    
    
    public void validarNombre(String nombre) throws Exception{
        
        nombre = nombre.trim();
        
        if(nombre.isEmpty()) 
            throw new Exception("El nombre de usuario no puede ir vacio.");
        
        if(nombre.length() < 3 || nombre.length() > 16)
            throw new Exception("El nombre de usuario debe tener entre 3 a 16 caracteres");
        
        if(!validatePattern(nombre, "[\\w\\d]+")) 
            throw new Exception("El nombre de usuario debe tener solo caracteres alfanumericos");
        
    }
    
    public Usuario login(String nombre, String contrasena) throws Exception{
        Usuario usuario = null;
        validarNombre(nombre);
        usuario = daoUsuario.buscarCredenciales(nombre, contrasena);
        return usuario;
    }
}
