package com.ucentral.appnotas.servicio;

import com.ucentral.appnotas.interfacesServicios.IUsuarioServicio;
import com.ucentral.appnotas.modelo.Usuario;
import com.ucentral.appnotas.repositorio.IUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class usuarioServicio implements IUsuarioServicio{

    @Autowired
    private IUsuario repositorioUsuario; 

    @Override
    public List<Usuario> listarTodUsuarios() {
        return (List<Usuario>) repositorioUsuario.findAll();
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    @Override
    public Usuario buscarUsuarioID(int identificacion) {
        return repositorioUsuario.findById(identificacion).orElse(null);
    }

    @Override
    public void eliminarUsuario(int identificacion) {
        repositorioUsuario.deleteById(identificacion);
    }
    
}