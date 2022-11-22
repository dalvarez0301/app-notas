package com.ucentral.appnotas.interfacesServicios;

import com.ucentral.appnotas.modelo.Usuario;
import java.util.List;

public interface  IUsuarioServicio {

    public List<Usuario> listarTodUsuarios();
    public Usuario guardarUsuario(Usuario usuario);
    public Usuario buscarUsuarioID(int identificacion);
    public void eliminarUsuario(int identificacion);
    
}
