
package controladores;

import modelos.dao.DAORecurso;
import vistas.PanelCrear_1;

public class ControlRecursos {
    DAORecurso recurso;
    PanelCrear_1 p1=new PanelCrear_1();
    public ControlRecursos(String control) {
        recurso=new DAORecurso(control);
    }
    public void AgregarRecurso(int tema,String ruta,String tipo) throws Exception{
        if(p1.vacio()==false && p1.verficarImagen()==false){
            recurso.AgregarRecurso(tema, ruta, tipo);
        }
    }
    
}
