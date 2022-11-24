package com.ucentral.appnotas.controlador;

import com.ucentral.appnotas.interfacesServicios.IUsuarioServicio;
import com.ucentral.appnotas.modelo.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/views/viewEstudiantes")
public class controladorUsuario {

    @Autowired
    private IUsuarioServicio usuarioServicio;

    //Consultar Usuarios
    @RequestMapping("/consultar_usuarios")
    public String listarUsuarios(Model model){
        List<Usuario> listaUsuarios = usuarioServicio.listarTodUsuarios();

        model.addAttribute("usuario", listaUsuarios);
        return "views/viewEstudiantes/consultar_usuarios";
    }

    //Crear Usuario 
    @GetMapping("/crear_usuarios")
    public String CrearUsuario(Model model){

        Usuario usuarios = new Usuario(); 
        model.addAttribute("usuario", usuarios);

        return "views/viewEstudiantes/crear_usuarios";
    }

    @PostMapping("/save")
    public String guardarUsuario(Usuario usuario, Model model, RedirectAttributes attribute){
        
        model.addAttribute("usuario", usuario);
        usuarioServicio.guardarUsuario(usuario);
        attribute.addFlashAttribute("success", "El estudiante se ha guardado correctamente");
        return "redirect:crear_usuarios";
    }

    @RequestMapping("/modificar_estudiante")
    public String modificarUsuarios(Model model){
        List<Usuario> listaUsuarios = usuarioServicio.listarTodUsuarios();

        model.addAttribute("usuario", listaUsuarios);
        return "views/viewEstudiantes/modificar_estudiante";
    }
    

}
