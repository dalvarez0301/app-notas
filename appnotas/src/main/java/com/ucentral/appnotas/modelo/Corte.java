package com.ucentral.appnotas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cortes")
public class Corte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int codigo;
    private String nombre;
    private int ponderado;

    public Corte() {

    }

    public Corte(int codigo, String nombre, int ponderado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ponderado = ponderado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPonderado() {
        return ponderado;
    }

    public void setPonderado(int ponderado) {
        this.ponderado = ponderado;
    }

}
