
package controladores;

import modelos.dao.DAOSeccion;
import vistas.PanelCrear_2;

public class ControlSecciones {
     DAOSeccion seccion;
    PanelCrear_2 p2=new PanelCrear_2();
    public ControlSecciones(String control) {
        seccion=new DAOSeccion(control);
    }
    public void AgregarSeccion(int tema,String titulo,String descripcion) throws Exception{
        if(p2.vacio()==false){
            seccion.InsertarSeccion(tema,titulo, descripcion);
        }
    }
}
