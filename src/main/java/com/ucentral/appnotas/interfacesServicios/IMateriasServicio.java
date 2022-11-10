package com.ucentral.appnotas.interfacesServicios;
import com.ucentral.appnotas.modelo.Materias;
import java.util.List;
import java.util.Optional;


public interface  IMateriasServicio {
 
    public List<Materias> listar();

    public Optional<Materias> listarId(int id);

    public int save(Materias m);

    public void delete(int id);
}
