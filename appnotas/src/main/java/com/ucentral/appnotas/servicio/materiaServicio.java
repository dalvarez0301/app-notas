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
    public Materia guardarMaterias(Materia materia) {
        return repositorioMateria.save(materia);
         
    }

    @Override
    public Materia buscarMateriaID(int codigo) {
        return repositorioMateria.findById(codigo).orElse(null);
    }

    @Override
    public void eliminarMateria(int codigo) {
        repositorioMateria.deleteById(codigo);
    }




}
