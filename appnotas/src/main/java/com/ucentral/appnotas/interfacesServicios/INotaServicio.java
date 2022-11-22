package com.ucentral.appnotas.interfacesServicios;

import com.ucentral.appnotas.modelo.Nota;
import java.util.List;

public interface INotaServicio {

    public List<Nota> listarTodNota();
    public Nota guardarNota(Nota nota);
    public Nota buscarNotaID(int id);
    public void eliminarNota(int id);
}
