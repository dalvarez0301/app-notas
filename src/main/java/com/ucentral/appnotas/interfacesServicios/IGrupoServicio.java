package com.ucentral.appnotas.interfacesServicios;

import com.ucentral.appnotas.modelo.Grupo;
import java.util.List;
import java.util.Optional;

public interface IGrupoServicio {
    
    public List<Grupo> listar();

    public Optional<Grupo> listarId(int id);

    public int save(Grupo g);

    public void delete(int id);
}
