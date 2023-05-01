
package modelo;

public class Robos {


    int id;
    String armaUtilizada;
    String cantidadDeInvolucrados; //ladrones
    String descripcionDeLadrones;
    String vehiculo; 
    String fechaHora;
    String lugar;
    String modusOperandi;
    String objetosRobados;
    int idInformante;
    
    public Robos() {
    }

    public Robos(int id, String armaUtilizada, String cantidadDeInvolucrados, String descripcionDeLadrones, String vehiculo, String fechaHora, String lugar, String modusOperandi, String objetosRobados, int idInformante) {
        this.id = id;
        this.armaUtilizada = armaUtilizada;
        this.cantidadDeInvolucrados = cantidadDeInvolucrados;
        this.descripcionDeLadrones = descripcionDeLadrones;
        this.vehiculo = vehiculo;
        this.fechaHora = fechaHora;
        this.lugar = lugar;
        this.modusOperandi = modusOperandi;
        this.objetosRobados = objetosRobados;
        this.idInformante = idInformante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArmaUtilizada() {
        return armaUtilizada;
    }

    public void setArmaUtilizada(String armaUtilizada) {
        this.armaUtilizada = armaUtilizada;
    }

    public String getCantidadDeInvolucrados() {
        return cantidadDeInvolucrados;
    }

    public void setCantidadDeInvolucrados(String cantidadDeInvolucrados) {
        this.cantidadDeInvolucrados = cantidadDeInvolucrados;
    }

    public String getDescripcionDeLadrones() {
        return descripcionDeLadrones;
    }

    public void setDescripcionDeLadrones(String descripcionDeLadrones) {
        this.descripcionDeLadrones = descripcionDeLadrones;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getModusOperandi() {
        return modusOperandi;
    }

    public void setModusOperandi(String modusOperandi) {
        this.modusOperandi = modusOperandi;
    }

    public String getObjetosRobados() {
        return objetosRobados;
    }

    public void setObjetosRobados(String objetosRobados) {
        this.objetosRobados = objetosRobados;
    }

    public int getIdInformante() {
        return idInformante;
    }

    public void setIdInformante(int idInformante) {
        this.idInformante = idInformante;
    }

    
    
    
    
}