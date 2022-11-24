package com.ucentral.appnotas.controlador;

import com.ucentral.appnotas.interfacesServicios.IGrupoServicio;
import com.ucentral.appnotas.modelo.Grupo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/views/viewGrupos")
public class controladorGrupo {
    

    @Autowired
    private IGrupoServicio grupoServicio;

    @GetMapping("/crear_grupos")
    public String CrearGrupos(Model model){
            
            Grupo grupos = new Grupo(); 
            model.addAttribute("grupo", grupos);
            return "views/viewGrupos/crear_grupos";
        }

        @PostMapping("/save")
        public String guardarGrupo(Grupo grupo, Model model, RedirectAttributes attribute){
            model.addAttribute("grupo", grupo);
            grupoServicio.guardarGrupos(grupo);
            attribute.addFlashAttribute("success", "El grupo se ha guardado correctamente");
            return "redirect:crear_grupos";
        } 
}
