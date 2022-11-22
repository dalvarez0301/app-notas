package com.ucentral.appnotas.repositorio;

import com.ucentral.appnotas.modelo.Nota;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INota extends CrudRepository<Nota, Integer>{

    @Query(value=" SELECT n.id, n.nota, a.nombre, u.identificacion, u.nombre, u.apellido, u.correo, m.nombre from notas n join usuarios u on n.estudiante = u.identificacion join actividades a on n.actividad = a.codigo join materias m on a.materia  ", nativeQuery=true)
    public List<Nota> listNotas();
 
    
   
}
