/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.dao;

import controladores.Encriptador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelos.Usuario;

/**
 *
 * @author Johan
 */
public class DAOUsuario extends DAOControlador{
    
    public DAOUsuario(String motor){
        super(motor);
    }
    
    public Usuario buscarCredenciales(String nombre, String contrasena) throws Exception{
        Usuario usuario = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conectar();
            String sql = "SELECT id, nombre, contrasena, rol FROM usuarios WHERE nombre = ? "+getLimitSQL(1);
            st = getConn().prepareStatement(sql);
            st.setString(1, nombre);
            rs = st.executeQuery();
            if(rs.next() && Encriptador.validar(contrasena, rs.getString("contrasena"))){
                usuario = new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("rol")
                );
            }else{
                throw new Exception("Credenciales no validas");
            }
        }catch(Exception ex){
            throw ex;
        }finally{
            if (st != null) st.close();
            if (rs != null) rs.close();
            desconectar();
        }
        return usuario;
    }
}
