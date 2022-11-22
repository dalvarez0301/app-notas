package com.ucentral.appnotas.repositorio;

import com.ucentral.appnotas.modelo.Corte;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICorte extends CrudRepository<Corte, Integer> {
    
}
