
package modelo;

import java.sql.*;
/**
 *
 * @author sebas
 */
public class Datos_Robo {
    
    private Connection miConexion;
    private PreparedStatement ps;
    private ResultSet rs;
    private String mensaje;
    private Robo r;

    public Datos_Robo() {
        miConexion=Conexion.getConexion();
    }
    
    private void cargarRoboID(int id){
        String sql="select * from ciudad where id="+id;
        r = new Robo();
        try {
            ps=miConexion.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                r.setIdRobo(rs.getInt(1));
                r.setCiudad(rs.getString(2));
                r.setBarrio(rs.getString(3));
                r.setnRobos(rs.getInt(4));

            }
        } catch (Exception e) {
        }
    }
    
    public String getMensaje(){
        return mensaje;
    }
    
    public boolean agregarRobo(Robo robo){
        boolean agregado=false;
        String consulta="insert into ciudad values (null,?,?,?)";
        try {
            ps= miConexion.prepareStatement(consulta);
            
            ps.setString(1, robo.getCiudad());
            ps.setString(2, robo.getBarrio());
            ps.setInt(3, robo.getnRobos());
            
            if(ps.executeUpdate()>0){
                agregado=true;
                mensaje="robo agregado correctamente";
            }
        } catch (Exception e) {
            mensaje= e.getMessage();
        }
        return agregado;
    }
    
    public void aumentarRobo(int id){
        
        cargarRoboID(id);
        int nRobo= r.getnRobos()+1;
        String sql = "UPDATE `ciudad` SET `nrobos`='"+nRobo+"' WHERE `id`="+id;
        
        try {
            ps = miConexion.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
}
