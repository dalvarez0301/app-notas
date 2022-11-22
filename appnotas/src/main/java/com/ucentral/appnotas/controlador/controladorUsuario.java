package com.ucentral.appnotas.controlador;

import com.ucentral.appnotas.interfacesServicios.IUsuarioServicio;
import com.ucentral.appnotas.modelo.Usuario;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("views/viewUsuarios")
public class controladorUsuario {

    @Autowired
    private IUsuarioServicio usuarioServicio;

    //Consultar Usuarios
    @RequestMapping("/consultar_usuarios")
    public String listarUsuarios(Model model){
        List<Usuario> listaUsuarios = usuarioServicio.listarTodUsuarios();

        model.addAttribute("usuario", listaUsuarios);
        return "views/viewUsuarios/consultar_usuarios";
    }

    //Crear Usuario 
    @GetMapping("/crear_usuarios")
    public String CrearUsuario(Model model){

        Usuario usuarios = new Usuario(); 

        model.addAttribute("usuario", usuarios);

          
        return "views/viewUsuarios/crear_usuarios";
    }

    @PostMapping("/save")
    public String guardarUsuario(@Valid @ModelAttribute Usuario usuarios, BindingResult result, Model model, RedirectAttributes attribute){
        
        if (result.hasErrors()){

            System.out.println("Error al guardar");
            return "views/viewUsuarios/crear_usuario";
        }
        usuarioServicio.guardarUsuario(usuarios);
        System.out.println("Usuario guardo");
        attribute.addFlashAttribute("success", "El usuario se ha guardado correctamente");
        return "redirect:/views/viewUsuarios/consultar_usuarios";
    }


    
}
