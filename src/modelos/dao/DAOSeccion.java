package modelos.dao;

import controladores.listas.ListaSecciones;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
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
    public int InsertarSeccion(int tema,String titulo,String descripcion) throws Exception{
        PreparedStatement ps;
        String sql_insert="INSERT INTO secciones(tema,titulo,descripcion) values(?,?,?)";
        try{
                this.conectar();
                ps=getConn().prepareStatement(sql_insert);
                ps.setInt(1, tema);
                ps.setString(2, titulo);
                ps.setString(3, descripcion);
                int v=ps.executeUpdate();
                if(v>0){
                    System.out.println("Se ha agregado con exito las secciones");
                }else{
                    JOptionPane.showMessageDialog(null,"error, no ha sido posible subir esos datos");
                }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"error "+e.getMessage());
        }finally{
            ps=null;
            this.desconectar();
        }
        return 0;
    }
}
