package com.ucentral.appnotas;

import com.ucentral.appnotas.modelo.Actividad;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class actividadesTest {
    

    @BeforeEach
    public void setUp() {
        
        Actividad actividad  =  new Actividad();
        actividad.setCodigo(1);
        actividad.setNombre("Prueba");
        actividad.setPonderado(10);

        

        
    }

    @Test
    public void test() {
        System.out.println("test");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("tearDown");
    }
}
