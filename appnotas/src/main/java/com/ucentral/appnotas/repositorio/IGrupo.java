package com.ucentral.appnotas.repositorio;

import com.ucentral.appnotas.modelo.Grupo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGrupo extends CrudRepository<Grupo, Integer> {
    
}
