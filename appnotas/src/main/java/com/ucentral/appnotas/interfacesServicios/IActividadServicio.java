package com.ucentral.appnotas.interfacesServicios;

import com.ucentral.appnotas.modelo.Actividad;
import java.util.List;

public interface IActividadServicio {

    public List<Actividad> listarTodActividads();
    public Actividad guardarActividad(Actividad actividad);
    public Actividad buscarActividadID(int codigo);
    public void eliminarActividad(int codigo);
}
