/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.dao;

import controladores.listas.ListaTemas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelos.Recurso;
import modelos.Tema;

/**
 *
 * @author Johan
 */
public class DAOTema extends DAOControlador{
    
    public DAOTema(String motor) {
        super(motor);
    }
    
    public ListaTemas obtenerMasConsultados() throws Exception{
        ListaTemas temas = new ListaTemas();
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conectar();
            String sql = "SELECT * FROM mas_consultados "+getLimitSQL(3);
            
            st = getConn().prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next()){
                if(rs.getString("ruta") != null){
                    Tema tema = new Tema();
                    tema.setId(rs.getInt("id"));
                    tema.setTitulo(rs.getString("titulo"));
                    tema.setDescripcion(rs.getString("descripcion"));
                    tema.setVisitas(rs.getInt("visitas"));

                    tema.getRecursos().agregar(new Recurso(rs.getString("ruta")));
                    temas.agregar(tema);
                }
            }
        }catch(Exception ex){
            throw ex;
        }finally{
            if (st != null) st.close();
            if (rs != null) rs.close();
            desconectar();
        }
        
        return temas;
    }
    
    public ListaTemas buscarSubtemas(int origen) throws Exception{
        ListaTemas temas = new ListaTemas();
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conectar();
            String sql = "SELECT id, titulo, descripcion, visitas, referencias FROM temas WHERE origen=?";
            st = getConn().prepareStatement(sql);
            st.setInt(1, origen);
            rs = st.executeQuery();
            while(rs.next()){
                Tema tema = new Tema();
                tema.setId(rs.getInt("id"));
                tema.setTitulo(rs.getString("titulo"));
                tema.setDescripcion(rs.getString("descripcion"));
                tema.setVisitas(rs.getInt("visitas"));
                tema.setReferencias(rs.getString("referencias"));

                temas.agregar(tema);
            }
        }catch(Exception ex){
            throw ex;
        }finally{
            if (st != null) st.close();
            if (rs != null) rs.close();
            desconectar();
        }
        
        return temas;
    }
    
    public ListaTemas buscarTitulos(String filtro) throws Exception{
        ListaTemas temas = new ListaTemas();
        PreparedStatement st = null;
        ResultSet rs = null;
        
        try{
            conectar();
            String sql = "SELECT id, titulo FROM temas WHERE lower(titulo) LIKE ? ORDER BY titulo";
            st = getConn().prepareStatement(sql);
            st.setString(1, "%"+filtro+"%");
            rs = st.executeQuery();
            while(rs.next()){
                Tema tema = new Tema();
                tema.setId(rs.getInt("id"));
                tema.setTitulo(rs.getString("titulo"));
                temas.agregar(tema);
            }
        }catch(Exception ex){
            throw ex;
        }finally{
            if (st != null) st.close();
            if (rs != null) rs.close();
            desconectar();
        }
        
        return temas;
    }
}
