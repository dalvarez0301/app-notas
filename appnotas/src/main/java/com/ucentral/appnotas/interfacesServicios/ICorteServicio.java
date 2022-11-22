package com.ucentral.appnotas.interfacesServicios;

import com.ucentral.appnotas.modelo.Corte;
import java.util.List;

public interface ICorteServicio {
    
    public List<Corte> listarTodCortes();
    public void guardarCortes(Corte corte);
    public Corte buscarCortesID(int codigo);
    public void eliminarCortes(int codigo);
}
