package com.ejemplo.microservicio.modelo;

public class Saludo {

    private String mensaje;

    public Saludo(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}