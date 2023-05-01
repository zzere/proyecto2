
package modelo;

import java.util.List;


public class Informante extends Usuario{
    
    private String telefono;
    private String genero;
    private int edad;
    
    public Informante() {
    }

    public Informante(String telefono, String genero, int edad, int id, String nombre, String apellido, String correo, String contraseña) {
        super(id, nombre, apellido, correo, contraseña);
        this.telefono = telefono;
        this.genero = genero;
        this.edad = edad;
        
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    
}