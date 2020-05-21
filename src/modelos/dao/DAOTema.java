/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.dao;

import controladores.listas.ListaRecursos;
import controladores.listas.ListaSecciones;
import controladores.listas.ListaTemas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
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
    
    /**
     * @author Johan Romero
     * @return
     * @throws Exception 
     */
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
    
    /**
     * @author Carlos Riaño
     * @param id
     * @return
     * @throws Exception 
     */
    public Tema TemasAmostrar(int id) throws Exception {
        Tema parametro = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        DAOSeccion daoseccion = new DAOSeccion("MySQL");
        DAORecurso daorecurso = new DAORecurso("MySQL");
        try {
            conectar();
            String sql = "SELECT id,titulo,descripcion,referencias FROM temas WHERE id=?";
            st = getConn().prepareStatement(sql);
            st.setInt(1, id);
            rs = st.executeQuery();
            while (rs.next()) {
                parametro = new Tema();
                parametro.setId(rs.getInt("id"));
                parametro.setTitulo(rs.getString("titulo"));
                parametro.setDescripcion(rs.getString("descripcion"));
                parametro.setReferencias(rs.getString("referencias"));
                ListaSecciones ob1 = daoseccion.buscarSecciones(id);
                parametro.setSecciones(ob1);
                ListaRecursos ob2 = daorecurso.buscarRecursos(id);
                parametro.setRecursos(ob2);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (st != null) {
                st.close();
            }
            if (rs != null) {
                rs.close();
            }
            desconectar();
        }

        return parametro;
    }
    
    /**
     * @author Johan Romero
     * @param origen
     * @return
     * @throws Exception 
     */
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
    
    /**
     * @author Juan Pablo Ospina
     * @param titulo
     * @param descripcion
     * @param referencias
     * @param Visitas
     * @return
     * @throws Exception 
     */
    public int AgregarTema(String titulo,String descripcion,String referencias,int Visitas) throws Exception{
        String sql_insert="INSERT INTO temas(titulo,descripcion,referencias,visitas) values(?,?,?,?)";
        PreparedStatement ps;
        int v=0;
        try{
            this.conectar();
            ps=getConn().prepareStatement(sql_insert);
            ps.setString(1, titulo);
            ps.setString(2, descripcion);
            ps.setString(3,referencias);
            ps.setInt(4, Visitas);
            v=ps.executeUpdate();
            if(v>0){
                JOptionPane.showMessageDialog(null,"Se ha agregado con exito el tema");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"error primario "+e.getMessage());
        }finally{
            ps=null;
            this.desconectar();
        }
        return v;
    }
    
    /**
     * @author Juan Pablo Ospina
     * @param titulo
     * @return
     * @throws Exception 
     */
    public int ObtenerID(String titulo) throws Exception{
        ResultSet rs = null;
        PreparedStatement st = null;
        String sql_select="SELECT id FROM temas WHERE titulo = ?";
        int id=0;
        try{
            this.conectar();
            st = getConn().prepareStatement(sql_select);
            st.setString(1, titulo);
            rs = st.executeQuery();
            if(rs.first()){
                id=rs.getInt("id");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "error "+e.getMessage());
        }finally{
            st=null;
            this.desconectar();
        }
        return id;
    
    }
    
    /**
     * @author Johan Romero
     * @param filtro
     * @return
     * @throws Exception 
     */
    public ListaTemas buscarTitulos(String filtro) throws Exception {
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
