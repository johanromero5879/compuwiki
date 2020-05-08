package modelos.dao;

import java.sql.Connection;
import modelos.conexiones.Conexion;
import modelos.conexiones.MySQL;

/**
 *
 * @author Johan Romero
 */
public class DAOControlador{
    private Conexion motor;
    
    public DAOControlador(String motor){
        switch(motor){
            case "MySQL":
                this.motor = new MySQL();
                break;
        }
    }
    
    public void conectar() throws Exception{
        this.motor.conectar();
    }
    
    public void desconectar() throws Exception{
        this.motor.desconectar();
    }
    
    public Connection getConn() throws Exception{
        if(this.motor.getConn() == null) throw new Exception();
        return this.motor.getConn();
    }
    
    public String getLimitSQL(int limit){
        String sql = "";
        if(limit >= 1){
            if(motor instanceof  MySQL){
                sql = "LIMIT "+limit;
            }
        }
        return sql;
    }
}
