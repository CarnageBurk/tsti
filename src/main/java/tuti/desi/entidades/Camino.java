package tuti.desi.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "caminos")
public class Camino {

    @Id
    private String idCamino;
    private String ciudadDestino;
    private String estadoCamino;
    private String estadoClima;
    private int codigoPostal;

    // Getters y Setters
    public String getIdCamino() {
        return idCamino;
    }

    public void setIdCamino(String idCamino) {
        this.idCamino = idCamino;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public String getEstadoCamino() {
        return estadoCamino;
    }

    public void setEstadoCamino(String estadoCamino) {
        this.estadoCamino = estadoCamino;
    }

    public String getEstadoClima() {
        return estadoClima;
    }

    public void setEstadoClima(String estadoClima) {
        this.estadoClima = estadoClima;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}
