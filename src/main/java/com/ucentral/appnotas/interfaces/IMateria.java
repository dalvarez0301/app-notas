package com.ucentral.appnotas.interfaces;

import com.ucentral.appnotas.modelo.Materias;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMateria extends CrudRepository<Materias, Integer> {

}