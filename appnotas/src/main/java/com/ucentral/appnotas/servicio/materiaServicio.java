package com.ucentral.appnotas.servicio;

import com.ucentral.appnotas.interfacesServicios.IMateriasServicio;
import com.ucentral.appnotas.modelo.Materia;
import com.ucentral.appnotas.repositorio.IMateria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class materiaServicio implements IMateriasServicio {
     
    @Autowired
    private IMateria repositorioMateria;

    @Override
    public List<Materia> listarTodMaterias() {
        return (List<Materia>) repositorioMateria.findAll();
    }

    @Override
    public void guardarMaterias(Materia materia) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Materia buscarMateriaID(int codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void eliminarMateria(int codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }



}
