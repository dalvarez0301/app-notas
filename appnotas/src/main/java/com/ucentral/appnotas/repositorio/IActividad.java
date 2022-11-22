package com.ucentral.appnotas.repositorio;

import com.ucentral.appnotas.modelo.Actividad;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IActividad extends CrudRepository<Actividad, Integer> {



    @Query(value="SELECT * FROM actividades ORDER BY corte ASC", nativeQuery=true)
    public List<Actividad> listarActividadesGrupo1Corte1();
    
    
    @Query(value="select ifnull ( sum(ponderado), 0) from actividades where materia = ?1 and corte = ?2 and grupo = ?3", nativeQuery=true)
    int AcumuladoPonderado(int mate, int cort, int grup);



}


