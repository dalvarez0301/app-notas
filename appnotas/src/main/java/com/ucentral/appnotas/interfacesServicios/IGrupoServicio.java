package com.ucentral.appnotas.interfacesServicios;

import com.ucentral.appnotas.modelo.Grupo;
import java.util.List;

public interface IGrupoServicio {
    
    public List<Grupo> listarTodGrupos();
    public Grupo guardarGrupos(Grupo grupo);
    public Grupo buscarGruposID(int codigo);
    public void eliminarGrupos(int codigo);
}
