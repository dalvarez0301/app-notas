package com.ucentral.appnotas.interfacesServicios;

import com.ucentral.appnotas.modelo.Corte;
import java.util.List;
import java.util.Optional;

public interface ICorteServicio {
    
    public List<Corte> listar();

    public Optional<Corte> listarId(int id);

    public int save(Corte c);

    public void delete(int id);
}
