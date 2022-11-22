package com.ucentral.appnotas.interfacesServicios;
import com.ucentral.appnotas.modelo.Materia;
import java.util.List;


public interface  IMateriasServicio {
 
    public List<Materia> listarTodMaterias();
    public void guardarMaterias(Materia materia);
    public Materia buscarMateriaID(int codigo);
    public void eliminarMateria(int codigo);
}
