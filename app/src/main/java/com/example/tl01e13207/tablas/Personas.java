package com.example.tl01e13207.tablas;

public class Personas
{
    private Integer id;
    private String nombre;
    private Integer numero;
    private String nota;

    public Personas(Integer id, String nombre, Integer numero, String nota) {
        this.id = id;
        this.nombre = nombre;
        this.numero = numero;
        this.nota = nota;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
}
