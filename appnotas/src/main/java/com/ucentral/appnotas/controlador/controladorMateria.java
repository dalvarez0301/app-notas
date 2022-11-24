package com.ucentral.appnotas.controlador;

import com.ucentral.appnotas.interfacesServicios.IMateriasServicio;
import com.ucentral.appnotas.modelo.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/views/viewMaterias")
public class controladorMateria {

    @Autowired
    private IMateriasServicio materiaServicio;

    @GetMapping("/crear_materias")
    public String CrearMaterias(Model model) {
        
        Materia materia = new Materia();
        model.addAttribute("materia", materia);
        return "views/viewMaterias/crear_materias";
    }

    @PostMapping("/save")
    public String save(Materia materia, Model model,  RedirectAttributes attribute) {
        model.addAttribute("materia", materia);
        materiaServicio.guardarMaterias(materia);
        attribute.addFlashAttribute("success", "la materia se ha guardado correctamente");
        return "redirect:crear_materias";
    }

    @GetMapping("/modificar_materia")
    public String modificarMaterias(Model model) {
        
        Materia materia = new Materia();
        model.addAttribute("materia", materia);
        return "views/viewMaterias/modificar_materia";
    }
    
}

