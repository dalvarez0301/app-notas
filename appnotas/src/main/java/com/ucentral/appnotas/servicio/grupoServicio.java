package com.ucentral.appnotas.servicio;

import com.ucentral.appnotas.interfacesServicios.IGrupoServicio;
import com.ucentral.appnotas.modelo.Grupo;
import com.ucentral.appnotas.repositorio.IGrupo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class grupoServicio implements IGrupoServicio{
    
    @Autowired
    private IGrupo repositorioGrupo;

    @Override
    public List<Grupo> listarTodGrupos() {
        return (List<Grupo>) repositorioGrupo.findAll();
    }
    
    @Override
    public Grupo guardarGrupos(Grupo grupo) {
        return repositorioGrupo.save(grupo);
    }

    @Override
    public Grupo buscarGruposID(int codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void eliminarGrupos(int codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }



    
}
