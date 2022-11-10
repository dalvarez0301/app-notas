package com.ucentral.appnotas.servicio;

import com.ucentral.appnotas.interfaces.IGrupo;
import com.ucentral.appnotas.interfacesServicios.IGrupoServicio;
import com.ucentral.appnotas.modelo.Grupo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class grupoServicio implements IGrupoServicio{
    
    @Autowired
    private IGrupo data;

    @Override
    public List<Grupo> listar() {
        return (List<Grupo>) data.findAll();
    }

    @Override
    public Optional<Grupo> listarId(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int save(Grupo g) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
