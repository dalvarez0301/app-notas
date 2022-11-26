package com.ucentral.appnotas.servicio;

import com.ucentral.appnotas.modelo.Usuario;
import com.ucentral.appnotas.repositorio.IUsuario;
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
public class usuarioServicioTest {

    @Mock
    private IUsuario repositorioUsuario; 

    @InjectMocks
    private usuarioServicio usuarioservicio;


    private Usuario usuario;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);

        usuario = new Usuario();
        usuario.setIdentificacion(10001);
        usuario.setNombre("Usuario 1");
        usuario.setApellido("Apellido 1");
        usuario.setCorreo("dalvarezr4@ucentral.edu.co");
        usuario.setContrasena(null);


    }

    @Test
    void testGuardarUsuario() {
        when(repositorioUsuario.save(any(Usuario.class))).thenReturn(usuario);
        assertNotNull(repositorioUsuario.save(new Usuario()));
        try{
            repositorioUsuario.save(usuario);
        }catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @Test
    void testBuscarUsuario() {
        when(repositorioUsuario.findById(10001)).thenReturn(java.util.Optional.of(usuario));
        assertNotNull(repositorioUsuario.findById(10001));

        try{
            repositorioUsuario.findById(10001);
        }catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @Test
    void testListarTodosUsuarios() {
        assertNotNull(repositorioUsuario.findAll());

        try{
            repositorioUsuario.findAll();
        }catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @Test
    void testEliminarUsuario() {
        repositorioUsuario.deleteById(10001);
        try{
            repositorioUsuario.deleteById(10001);
    } 
    catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
}

