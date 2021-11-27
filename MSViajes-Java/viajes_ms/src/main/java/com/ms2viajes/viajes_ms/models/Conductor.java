package com.ms2viajes.viajes_ms.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Conductor {
    @Id
    private String  cedula;
    private String  nombres;
    private String  apellidos;
    private String  telefono;
    private String  tipoCarro;
    private Date    fechaCreacion;
    private Boolean disponible;
    private Float   balance;

    public Conductor(String cedula, String nombres, String apellidos, String telefono, String tipoCarro, Date fechaCreacion, Boolean disponible, Float balance) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.tipoCarro = tipoCarro;
        this.fechaCreacion = fechaCreacion;
        this.disponible = disponible;
        this.balance = balance;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoCarro() {
        return tipoCarro;
    }

    public void setTipoCarro(String tipoCarro) {
        this.tipoCarro = tipoCarro;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }
}
