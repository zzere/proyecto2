
package modelo;

import java.util.List;


public interface DAORobos {

    public void registrar (Robos robo, Informante informante);
    public void modificar (Robos robo, Informante informante);
    public void eliminar (Robos robo, Informante informante);
    public void buscar (Robos robo, Informante informante);
    
    public List<Robos> obtenerRobosPorUsuario(Informante informante);
}
