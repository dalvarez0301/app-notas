package com.ucentral.appnotas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "actividades")
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    private String nombre;
    private float ponderado;

    //relaciones entre tablas fk
    @ManyToOne
    @JoinColumn(name = "materia")
    private Materias materias;

    @ManyToOne
    @JoinColumn(name = "grupo")
    private Grupo grupo;

    @ManyToOne
    @JoinColumn(name = "corte")
    private Corte cortes;

    public Actividad() {

    }

    
    public Actividad(int codigo, String nombre, float ponderado, Materias materias, Grupo grupo, Corte cortes) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ponderado = ponderado;
        this.materias = materias;
        this.grupo = grupo;
        this.cortes = cortes;
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


    public float getPonderado() {
        return ponderado;
    }


    public void setPonderado(float ponderado) {
        this.ponderado = ponderado;
    }


    public Materias getMaterias() {
        return materias;
    }


    public void setMaterias(Materias materias) {
        this.materias = materias;
    }


    public Grupo getGrupo() {
        return grupo;
    }


    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }


    public Corte getCortes() {
        return cortes;
    }


    public void setCortes(Corte cortes) {
        this.cortes = cortes;
    }

    

    


}
