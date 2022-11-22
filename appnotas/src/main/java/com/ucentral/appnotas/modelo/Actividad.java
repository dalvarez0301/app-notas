package com.ucentral.appnotas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "actividades")
public class Actividad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    
    @NotEmpty
    private String nombre;
    @NotNull
    private float ponderado;

    //relaciones entre tablas fk
    @ManyToOne
    @JoinColumn(name = "materia")
    private Materia materia;

    @ManyToOne
    @JoinColumn(name = "grupo")
    private Grupo grupo;

    @ManyToOne
    @JoinColumn(name = "corte")
    private Corte corte;

    public Actividad() {

    }

    public Actividad(int codigo, String nombre, float ponderado, Materia materia, Grupo grupo, Corte corte) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ponderado = ponderado;
        this.materia = materia;
        this.grupo = grupo;
        this.corte = corte;
    }

    public int getCodigo() {
        return codigo;
    }

    public Corte getCorte() {
        return corte;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPonderado() {
        return ponderado;
    }

    public Materia getMateria() {
        return materia;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public int getGrup() {
        return this.grupo.getCodigo();
    }

    public int getMaterias() {
        return this.materia.getCodigo();
    }

    public int getCortes() {
        return this.corte.getCodigo();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPonderado(float ponderado) {
        this.ponderado = ponderado;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    
    public void setCorte(Corte corte) {
        this.corte = corte;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }



}
