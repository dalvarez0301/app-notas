package com.ucentral.appnotas.interfaces;

import com.ucentral.appnotas.modelo.Actividad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IActividad extends CrudRepository<Actividad, Integer> {

}