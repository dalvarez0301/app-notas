package com.ucentral.appnotas.servicio;

import com.ucentral.appnotas.interfacesServicios.ICorteServicio;
import com.ucentral.appnotas.modelo.Corte;
import com.ucentral.appnotas.repositorio.ICorte;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class corteServicio implements ICorteServicio{
    
    @Autowired
    private ICorte repositorioCorte;
    
    @Override
    public List<Corte> listarTodCortes() {
        return (List<Corte>) repositorioCorte.findAll();
    }

    @Override
    public void guardarCortes(Corte corte) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Corte buscarCortesID(int codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void eliminarCortes(int codigo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }



}
