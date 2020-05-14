package controladores;

import controladores.listas.ListaTemas;
import modelos.dao.DAOTema;

/**
 *
 * @author Johan
 */
public class ControlTema {
    DAOTema daoTema;
    
    public ControlTema(String motor){
        daoTema = new DAOTema(motor);
    }
    
    public ListaTemas obtenerMasConsultados() throws Exception{
        return daoTema.obtenerMasConsultados();
    }
    
    public ListaTemas buscarTitulos(String filtro) throws Exception{
        filtro = filtro.trim().toLowerCase();
        return daoTema.buscarTitulos(filtro);
    }
}
