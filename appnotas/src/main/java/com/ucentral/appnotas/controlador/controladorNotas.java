package com.ucentral.appnotas.controlador;

import com.ucentral.appnotas.interfacesServicios.IActividadServicio;
import com.ucentral.appnotas.interfacesServicios.INotaServicio;
import com.ucentral.appnotas.interfacesServicios.IUsuarioServicio;
import com.ucentral.appnotas.modelo.Actividad;
import com.ucentral.appnotas.modelo.Nota;
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
@RequestMapping("/views/viewNotas")
public class controladorNotas {

    @Autowired
    private INotaServicio notaServicio;

    @Autowired
    private IActividadServicio actividadServicio;

    @Autowired
    private IUsuarioServicio usuarioServicio;

    @RequestMapping("/consultar_notas")
    public String listarNotas(Model model){
        List<Nota> listaNotas = notaServicio.listarTodNota();

        model.addAttribute("nota", listaNotas);
        return "views/viewNotas/consultar_notas";
    }
    
    @GetMapping("/registrar_notas")
    public String registrarNotas(Model model){

        Nota notas = new Nota(); 
        List<Actividad> listaActividads = actividadServicio.listarTodActividads();
        List<Usuario> listaUsuarios = usuarioServicio.listarTodUsuarios();


        model.addAttribute("nota", notas);
        model.addAttribute("actividad", listaActividads);   
        model.addAttribute("usuario", listaUsuarios); 
          
        return "views/viewNotas/registrar_notas";
    }

    @PostMapping("/save")
    public String guardarActividad(@Valid @ModelAttribute Nota notas, BindingResult result, Model model, RedirectAttributes attribute){

        List<Actividad> listaActividads = actividadServicio.listarTodActividads();
        List<Usuario> listaUsuarios = usuarioServicio.listarTodUsuarios();

        if (result.hasErrors()){
            model.addAttribute("nota", notas);
            model.addAttribute("actividad", listaActividads);   
            model.addAttribute("usuario", listaUsuarios); 
            System.out.println("Error al guardar");
            return "views/viewNotas/registrar_notas";
        }
        notaServicio.guardarNota(notas);
        System.out.println("Nota guardada");
        attribute.addFlashAttribute("success", "La nota se ha guardado correctamente");
        return "redirect:consultar_notas";
    }
}
