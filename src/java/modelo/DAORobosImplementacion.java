
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DAORobosImplementacion implements DAORobos{

    Conexion conexion = Conexion.getInstance();
    
    
    @Override
    public void registrar(Robos robo, Informante informante) {
    try {
            Connection conectar = this.conexion.conectar();
            PreparedStatement stmt = conectar.prepareStatement("insert into tablaRobos values(?,?,?,?,?,?,?,?,?,?)");
            
            stmt.setInt(1, robo.getId());
            stmt.setString(2, robo.getArmaUtilizada());
            stmt.setString(3, robo.getCantidadDeInvolucrados());
            stmt.setString(4, robo.getDescripcionDeLadrones());
            stmt.setString(5, robo.getVehiculo());
            stmt.setString(6, robo.getFechaHora());
            stmt.setString(7, robo.getLugar());
            stmt.setString(8, robo.getModusOperandi());
            stmt.setString(9, robo.getObjetosRobados()); 
            stmt.setInt(10, robo.getIdInformante()); 

            stmt.executeUpdate();
            
            conexion.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }

    @Override
    public void modificar(Robos robo, Informante informante) {
        try {
            Connection conectar = this.conexion.conectar();   //VARIABLES A CAMBIAR
            PreparedStatement stmt = conectar.prepareStatement("update tablaRobo set arma_utilizada = ? WHERE id_robo = ?");
            
            //stmt.setString(1, empleado.getNombre());
            //stmt.setInt(2, empleado.getId());
            
            stmt.setInt(1, robo.getId());
            stmt.setString(2, robo.getArmaUtilizada());
            stmt.setString(3, robo.getCantidadDeInvolucrados());
            stmt.setString(4, robo.getDescripcionDeLadrones());
            stmt.setString(5, robo.getVehiculo());
            stmt.setString(6, robo.getFechaHora());
            stmt.setString(7, robo.getLugar());
            stmt.setString(8, robo.getModusOperandi());
            stmt.setString(9, robo.getObjetosRobados()); 
            stmt.setInt(10, robo.getIdInformante());

            
            stmt.executeUpdate();
            
            conexion.cerrarConexion();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminar(Robos robo, Informante informante) {
    
        try {
            Connection conectar = this.conexion.conectar();
            PreparedStatement stmt = conectar.prepareStatement("delete from tablaRobo where id_robo = ?");
            
            //stmt.setInt(1, empleado.getId());
            
            stmt.setInt(1, robo.getId());
            stmt.executeUpdate();
            
            conexion.cerrarConexion();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }

    @Override
    public void buscar(Robos robo, Informante informante) {
    
        try {
            Connection conectar = this.conexion.conectar();
            PreparedStatement stmt = conectar.prepareStatement("select * from tablaRobo where id_robo = ?");
            
            //stmt.setInt(1, empleado.getId());
            stmt.setInt(1, robo.getId());
            
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                //empleado.setId(Integer.parseInt(rs.getString("id")));
                //empleado.setNombre(rs.getString("nombre"));
            
                robo.setId(Integer.parseInt(rs.getString(1)));
                robo.setArmaUtilizada(rs.getString(2));
                robo.setCantidadDeInvolucrados(rs.getString(3));
                robo.setDescripcionDeLadrones(rs.getString(4));
                robo.setVehiculo(rs.getString(5));
                robo.setFechaHora(rs.getString(6));
                robo.setLugar(rs.getString(7));
                robo.setModusOperandi(rs.getString(8));
                robo.setObjetosRobados(rs.getString(9));
                robo.setIdInformante(Integer.parseInt(rs.getString(10)));
                
            }
            
            conexion.cerrarConexion();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }

    @Override
    public List<Robos> obtenerRobosPorUsuario(Informante informante) {
        List<Robos> robos = new ArrayList<>();
        try {
            
            Connection conectar = this.conexion.conectar();
            PreparedStatement stmt = conectar.prepareStatement("select * from tablaRobo where id_robo = ?");
            
            
            stmt.setInt(1, informante.getId());
            ResultSet rs = stmt.executeQuery();
            
            
            while (rs.next()) {
                Robos robo = new Robos();
                robo.setId(Integer.parseInt(rs.getString(1)));
                robo.setArmaUtilizada(rs.getString(2));
                robo.setCantidadDeInvolucrados(rs.getString(3));
                
                robo.setDescripcionDeLadrones(rs.getString(4));
                robo.setVehiculo(rs.getString(5));
                robo.setFechaHora(rs.getString(6));
                robo.setLugar(rs.getString(7));
                robo.setModusOperandi(rs.getString(8));
                robo.setObjetosRobados(rs.getString(9));
                
                robo.setIdInformante(rs.getInt(10));
                
                robos.add(robo);
            }
            
            conexion.cerrarConexion();
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return robos;
    }
        

    }