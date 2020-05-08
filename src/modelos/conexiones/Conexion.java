/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Johan
 */
public abstract class Conexion {
    protected Connection conn;
    protected String driver;
    protected String user;
    protected String password;
    protected String db;
    protected String url;
    
    public void conectar() throws Exception{
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        }catch(ClassNotFoundException | SQLException ex){
            throw new Exception("Error al conectar");
        }
    }
    
    public void desconectar() throws Exception{
        if(conn != null && !conn.isClosed()) conn.close();
    }
    
    public Connection getConn(){
        return conn;
    }
}
