package com.ucentral.appnotas.repositorio;

import com.ucentral.appnotas.modelo.Materia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMateria extends CrudRepository<Materia, Integer> {

}