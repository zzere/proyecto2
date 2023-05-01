
package modelo;
import java.sql.*;
import javax.swing.JOptionPane;


public class Conexion {

    
    //se crea constructor privado. No permite hacer instancias, lo que obliga a usar el patron singleton
    private Conexion(){
        
    }
    

    private static Connection conexion;
    
    private static Conexion instancia;
    
    private static final String url = "jdbc:mysql://localhost/bd_appRobos";
    private static final String root = "root";
    private static final String password = "1233";
    
    //retorna la conexion a la bd
    public Connection  conectar(){
        
        try {
            //debe cargar el drive para hacer la conexion
            Class.forName("com.mysql.cj.jdbc.Driver");
            //nos conectamos a la bd, conexion guarda la direccion a donde conectar
            conexion = DriverManager.getConnection(url, root, password);
            
            JOptionPane.showMessageDialog(null, "conexion exitosa");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return conexion;
        
    }
    
    
    public void cerrarConexion() throws SQLException{
        try {
            conexion.close();
            System.out.println("Desconectado de la base de datos");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            conexion.close();
        }
        finally{
            conexion.close();
        }
    }
    
    //recuerda usar conexion.close en finally cada que se abra
    
    
    
    //ponemos patron singleton. Va a ser del tipo al que vamos a dejar singleton
    public static Conexion getInstance(){ //se pone static para llamar a la clase y no tner que hacer instancias del new
        if(instancia == null){
            instancia = new Conexion(); //si esta vacio lo pasamos de var a obj. SI la inst esta vacia crea una nueva.
        }
        return instancia; //si la inst esta nula, la retorna
    }
    
}
