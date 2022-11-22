package com.ucentral.appnotas.servicio;

import com.ucentral.appnotas.interfacesServicios.IActividadServicio;
import com.ucentral.appnotas.modelo.Actividad;
import com.ucentral.appnotas.repositorio.IActividad;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class actividadServicio implements IActividadServicio {

    @Autowired
    private IActividad repositorioActividad;  // inyecta el repositorio IActividad

    @Override
    public List<Actividad> listarTodActividads() {
        return (List<Actividad>) repositorioActividad.listarActividadesGrupo1Corte1();
    }

    @Override
    public Actividad guardarActividad(Actividad actividad) {
        if (repositorioActividad.AcumuladoPonderado(actividad.getMaterias(), actividad.getCortes(), actividad.getGrup()) + actividad.getPonderado() <= 101){
            return repositorioActividad.save(actividad);
        }
        return null;
    }

    @Override
    public Actividad buscarActividadID(int codigo) {
        return repositorioActividad.findById(codigo).orElse(null);  //orelse devuelve un mensaje de error (null) si un id en el controlador no exita
    }

    @Override
    public void eliminarActividad(int codigo) {
        repositorioActividad.deleteById(codigo);
    }


 




}
