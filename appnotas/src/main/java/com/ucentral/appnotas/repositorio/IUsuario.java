package com.ucentral.appnotas.repositorio;

import com.ucentral.appnotas.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUsuario extends CrudRepository<Usuario, Integer> {
    
}
