package com.ucentral.appnotas.servicio;

import com.ucentral.appnotas.interfacesServicios.INotaServicio;
import com.ucentral.appnotas.modelo.Nota;
import com.ucentral.appnotas.repositorio.INota;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class notaServicio implements INotaServicio{

    @Autowired
    private INota repositorioNota; 
    
    @Override
    public List<Nota> listarTodNota() {
        return (List<Nota>) repositorioNota.findAll();
    }

    @Override
    public Nota guardarNota(Nota nota) {
        return repositorioNota.save(nota);
    }

    @Override
    public Nota buscarNotaID(int id) {
        return repositorioNota.findById(id).orElse(null);
    }

    @Override
    public void eliminarNota(int id) {
        repositorioNota.deleteById(id);
    }
    
}
