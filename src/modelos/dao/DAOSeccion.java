package modelos.dao;

import controladores.listas.ListaSecciones;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelos.Seccion;

/**
 *
 * @author Johan
 */
public class DAOSeccion extends DAOControlador{
    
    public DAOSeccion(String motor) {
        super(motor);
    }
    
    public ListaSecciones buscarSecciones(int tema) throws Exception{
        ListaSecciones secciones = new ListaSecciones();
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            conectar();
            String sql = "SELECT titulo, descripcion FROM secciones WHERE tema=?";
            st = getConn().prepareStatement(sql);
            st.setInt(1, tema);
            rs = st.executeQuery();
            while(rs.next()){
                Seccion seccion = new Seccion();
                seccion.setTitulo(rs.getString("titulo"));
                seccion.setDescripcion(rs.getString("descripcion"));

                secciones.agregar(seccion);
            }
        }catch(Exception ex){
            throw ex;
        }finally{
            if (st != null) st.close();
            if (rs != null) rs.close();
            desconectar();
        }
        return secciones;
    }
}
