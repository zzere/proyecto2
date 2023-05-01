
package modelo;

/**
 *
 * @author sebas
 */
public interface DAOInformante { //intentar crear padre y no una para cada hija

    public void registrar (Informante informante);
    public void modificar (Informante informante);
    public void eliminar (Informante informante);
    public void buscar (Informante informante);
    
    
}