package com.ucentral.appnotas.interfacesServicios;

import java.util.List;
import java.util.Optional;

import com.ucentral.appnotas.modelo.Actividad;

public interface IActividadServicio {

    public List<Actividad> listar();

    public Optional<Actividad> listarId(int id);

    public int save(Actividad a);

    public void delete(int id);

}
