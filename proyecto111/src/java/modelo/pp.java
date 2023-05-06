
package modelo;

import java.sql.*;
/**
 *
 * @author sebas
 */
public class pp {

    public pp() {
        
        try {
            Statement s= Conexion.getConexion().createStatement();
            ResultSet rs= s.executeQuery("select * from ciudad");
            
            while(rs.next()){
                
            }
            
        } catch (Exception e) {
            
        }
        
    }
    
    
    
    
    
    
}