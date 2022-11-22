package com.ucentral.appnotas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "notas")
public class Nota {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private float nota;
    

    @ManyToOne
    @JoinColumn(name = "actividad")
    private Actividad actividad;

    @ManyToOne
    @JoinColumn(name = "estudiante")
    private Usuario estudiante;

    public Nota() {
    }

    public Nota(int id, float nota, Actividad actividad, Usuario estudiante) {
        this.id = id;
        this.nota = nota;
        this.actividad = actividad;
        this.estudiante = estudiante;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Usuario getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Usuario estudiante) {
        this.estudiante = estudiante;
    }
    
    
    
}
