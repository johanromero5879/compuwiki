package modelos.conexiones;


/**
 *
 * @author Johan Romero
 */
public class MySQL extends Conexion{
    
    public MySQL(){
        conn = null;
        driver = "com.mysql.jdbc.Driver";
        user = "root";
        password = "";
        db = "compuwiki";
        url = "jdbc:mysql://localhost:3306/"+db;
    }
}
