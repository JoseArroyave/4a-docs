package com.ms2viajes.viajes_ms.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Viaje {

    @Id
    private String id;
    private String conductor;
    private String cliente;
    private Boolean esAmigo;
    private String direccionOrigen;
    private String direccionDestino;
    private Date fechaViaje;
    private Float precio;
    private Boolean activo;

    public Viaje(String id, String conductor, String cliente, Boolean esAmigo, String direccionOrigen, String direccionDestino, Date fechaViaje, Boolean activo, Float precio) {
        this.id = id;
        this.conductor = conductor;
        this.cliente = cliente;
        this.esAmigo = esAmigo;
        this.direccionOrigen = direccionOrigen;
        this.direccionDestino = direccionDestino;
        this.fechaViaje = fechaViaje;
        this.activo = activo;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Boolean getEsAmigo() {
        return esAmigo;
    }

    public void setEsAmigo(Boolean esAmigo) {
        this.esAmigo = esAmigo;
    }

    public String getDireccionOrigen() {
        return direccionOrigen;
    }

    public void setDireccionOrigen(String direccionOrigen) {
        this.direccionOrigen = direccionOrigen;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public Date getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(Date fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
}
