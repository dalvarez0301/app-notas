package com.ucentral.appnotas.servicio;

import com.ucentral.appnotas.interfaces.ICorte;
import com.ucentral.appnotas.interfacesServicios.ICorteServicio;
import com.ucentral.appnotas.modelo.Corte;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class corteServicio implements ICorteServicio{
    
    @Autowired
    private ICorte data;

    @Override
    public List<Corte> listar() {
        return (List<Corte>) data.findAll();
    }

    @Override
    public Optional<Corte> listarId(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int save(Corte c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
