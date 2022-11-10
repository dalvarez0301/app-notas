package com.ucentral.appnotas.servicio;

import com.ucentral.appnotas.interfaces.IActividad;
import com.ucentral.appnotas.interfacesServicios.IActividadServicio;
import com.ucentral.appnotas.modelo.Actividad;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class actividadServicio implements IActividadServicio {

    @Autowired
    private IActividad data;

    @Override
    public List<Actividad> listar() {
        return (List<Actividad>) data.findAll();

    }

    @Override
    public Optional<Actividad> listarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
    
    }

    @Override
    public int save(Actividad a) {
        int res=0;
        Actividad actividad=data.save(a);
        if(!actividad.equals(null)){
            res=1;
        }
        return res;                                                                 // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
