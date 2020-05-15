package controladores;

import controladores.listas.ListaTemas;
import modelos.dao.DAOTema;
import vistas.PanelCrear_1;

/**
 *
 * @author Johan
 */
public class ControlTema {
    int aux=0;
    DAOTema daoTema;
    PanelCrear_1 p1=new PanelCrear_1();
    public ControlTema(String motor){
        daoTema = new DAOTema(motor);
    }
    public ListaTemas obtenerMasConsultados() throws Exception{
        return daoTema.obtenerMasConsultados();
    }
    public void IngresarTemas(String titulo,String descripcion,String referencias,int visitas) throws Exception{
        if(p1.vacio()==false && p1.verficarImagen()==false){
            daoTema.AgregarTema(titulo, descripcion, referencias, visitas);
            aux=daoTema.ObtenerID(titulo);
        }else{}
    }

    public int getAux() {
        return aux;
    }
    
    
    
}
