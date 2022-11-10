package com.ucentral.appnotas.servicio;

import com.ucentral.appnotas.interfaces.IMateria;
import com.ucentral.appnotas.interfacesServicios.IMateriasServicio;
import com.ucentral.appnotas.modelo.Materias;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class materiaServicio implements IMateriasServicio {
     
    @Autowired
    private IMateria data;

    @Override
    public List<Materias> listar() {
        return (List<Materias>) data.findAll();
    }

    @Override
    public Optional<Materias> listarId(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int save(Materias m) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
     

}
