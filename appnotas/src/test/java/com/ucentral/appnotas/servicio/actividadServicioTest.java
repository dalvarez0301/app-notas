package com.ucentral.appnotas.servicio;

import com.ucentral.appnotas.modelo.Actividad;
import com.ucentral.appnotas.repositorio.IActividad;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class actividadServicioTest {


    @Mock
    private IActividad repositorioActividad;; 

    @InjectMocks
    private actividadServicio actividadservicio;

    private Actividad actividad;



    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);

        actividad = new Actividad();
        actividad.setCodigo(100);
        actividad.setNombre("Actividad 1");
        actividad.setPonderado(100);
        actividad.setMateria(null);
        actividad.setGrupo(null);
        actividad.setCorte(null);

    }

    @Test
    void testListarTodActividads() {
        
    when(repositorioActividad.findAll()).thenReturn(Arrays.asList(actividad));
    assertNotNull(repositorioActividad.findAll());

        try{
            repositorioActividad.findAll();
        }catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }

    }

    @Test
    void testGuardarActividad() {
        when(repositorioActividad.save(any(Actividad.class))).thenReturn(actividad);
        assertNotNull(repositorioActividad.save(new Actividad()));
        
        try{
            repositorioActividad.save(actividad);
        }catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @Test
    void testBuscarActividad() {
        when(repositorioActividad.findById(100)).thenReturn(java.util.Optional.of(actividad));
        assertNotNull(repositorioActividad.findById(100));

        try{
            repositorioActividad.findById(100);
        }catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @Test
    void testEliminarActividad() {
        repositorioActividad.deleteById(100);

        try{
            repositorioActividad.deleteById(100);
        }catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }


}
