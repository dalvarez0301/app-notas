package com.ucentral.appnotas.controlador;

import com.ucentral.appnotas.interfacesServicios.ICorteServicio;
import com.ucentral.appnotas.modelo.Corte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/views/viewCortes")
public class controladorCorte {
    

    @Autowired
    private ICorteServicio corteServicio;

    @GetMapping("/crear_cortes")
    public String CrearCortes(Model model){
            
            Corte cortes = new Corte(); 
            model.addAttribute("corte", cortes);
            return "views/viewCortes/crear_cortes";
        }

        @PostMapping("/save")
        public String guardarCorte(Corte corte, Model model, RedirectAttributes attribute){
            model.addAttribute("corte", corte);
            corteServicio.guardarCortes(corte);
            attribute.addFlashAttribute("success", "El corte se ha guardado correctamente");
            return "redirect:crear_cortes";
        }    
    
}
