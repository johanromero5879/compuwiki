/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.dao;

import controladores.listas.ListaRecursos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelos.Recurso;

/**
 *
 * @author Johan
 */
public class DAORecurso extends DAOControlador{
    
    public DAORecurso(String motor) {
        super(motor);
    }
    
    public ListaRecursos buscarRecursos(int tema) throws Exception{
        return buscarRecursos(tema, null);
    }
            
    public ListaRecursos buscarRecursos(int tema, String tipo) throws Exception{
        ListaRecursos recursos = new ListaRecursos();
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conectar();
            String sql = "SELECT ruta, tipo FROM recursos WHERE tema=?";
            if(tipo != null && !tipo.isEmpty()){
                sql += " AND tipo = ?";
            }
            st = getConn().prepareStatement(sql);
            st.setInt(1, tema);
            if(tipo != null && !tipo.isEmpty()){
                st.setString(2, tipo);
            }

            rs = st.executeQuery();
            while(rs.next()){
                Recurso recurso = new Recurso();
                recurso.setRuta(rs.getString("ruta"));
                recurso.setTipo(rs.getString("tipo"));

                recursos.agregar(recurso);
            }
        }catch(Exception ex){
            throw ex;
        }finally{
            if (st != null) st.close();
            if (rs != null) rs.close();
            desconectar();
        }
        
        return recursos;
    }
}
