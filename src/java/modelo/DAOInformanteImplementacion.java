
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DAOInformanteImplementacion implements DAOInformante{

    Conexion conexion = Conexion.getInstance();
    
    @Override
    public void registrar(Informante informante) {
        try {
            Connection conectar = this.conexion.conectar();
            PreparedStatement stmt = conectar.prepareStatement("insert into tablaInformante values(?,?,?,?,?,?,?,?,?)");
            
            //stmt.setInt(1, empleado.getId());
            //stmt.setString(2, empleado.getNombre());
            
            
            stmt.setInt(1, informante.getId());
            stmt.setString(2, informante.getNombre());
            stmt.setString(3, informante.getApellido());
            stmt.setString(4, informante.getCorreo());
            stmt.setString(5, informante.getContraseña());
            stmt.setString(6, informante.getTelefono());
            stmt.setString(7, informante.getGenero());
            stmt.setInt(8, informante.getEdad());
            

            stmt.executeUpdate();
            
            conexion.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()); //h
        }
    }

    @Override
    public void modificar(Informante informante) {
        
        try {
            Connection conectar = this.conexion.conectar();
            PreparedStatement stmt = conectar.prepareStatement("update tablaInformante set nombre = ? WHERE id_informante = ?");
            
            //stmt.setString(1, empleado.getNombre());
            //stmt.setInt(2, empleado.getId());
            
            stmt.setInt(1, informante.getId());
            stmt.setString(2, informante.getNombre());
            stmt.setString(3, informante.getApellido());
            stmt.setString(4, informante.getCorreo());
            stmt.setString(5, informante.getContraseña());
            stmt.setString(6, informante.getTelefono());
            stmt.setString(7, informante.getGenero());
            stmt.setInt(8, informante.getEdad());
            
            
            stmt.executeUpdate();
            
            conexion.cerrarConexion();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }

    @Override
    public void eliminar(Informante informante) {
    
        try {
            Connection conectar = this.conexion.conectar();
            PreparedStatement stmt = conectar.prepareStatement("delete from tablaInformante where id_informante = ?");
            
            //stmt.setInt(1, empleado.getId());
            
            stmt.setInt(1, informante.getId());
            stmt.executeUpdate();
            
            conexion.cerrarConexion();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }

    @Override
    public void buscar(Informante informante) {
        
        try {
            Connection conectar = this.conexion.conectar();
            PreparedStatement stmt = conectar.prepareStatement("select * from tablaInformante where id_informante = ?");
            
            //stmt.setInt(1, empleado.getId());
            stmt.setInt(1, informante.getId());
            
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                //empleado.setId(Integer.parseInt(rs.getString("id")));
                //empleado.setNombre(rs.getString("nombre"));
            
                informante.setId(Integer.parseInt(rs.getString("id_informante")));
                informante.setNombre(rs.getString("nombre"));
                informante.setApellido(rs.getString("apellido"));
                informante.setCorreo(rs.getString("correo"));
                informante.setContraseña(rs.getString("contraseña"));
                informante.setTelefono(rs.getString("telefono"));
                informante.setGenero(rs.getString("genero"));
                informante.setEdad(Integer.parseInt(rs.getString("edad")));
                //informante IDROBO
                
            }
            
            conexion.cerrarConexion();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    //NO SE DEBE PONER FORMULARIO CADA QUE SE LLENA UN ROBO. SE CREA USUARIO Y ESE USUARIO PUEDE PONER VARIOS
    //ROBOS. CAMBIAR TABLAS Y LOGICA


    
}