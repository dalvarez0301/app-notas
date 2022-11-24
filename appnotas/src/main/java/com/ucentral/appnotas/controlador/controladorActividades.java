package com.ucentral.appnotas.controlador;

import com.ucentral.appnotas.interfacesServicios.IActividadServicio;
import com.ucentral.appnotas.interfacesServicios.ICorteServicio;
import com.ucentral.appnotas.interfacesServicios.IGrupoServicio;
import com.ucentral.appnotas.interfacesServicios.IMateriasServicio;
import com.ucentral.appnotas.modelo.Actividad;
import com.ucentral.appnotas.modelo.Corte;
import com.ucentral.appnotas.modelo.Grupo;
import com.ucentral.appnotas.modelo.Materia;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/views/viewActividades")
public class controladorActividades {
    
    @Autowired
    private IActividadServicio actividadServicio;

    @Autowired
    private IMateriasServicio materiaServicio;

    @Autowired
    private ICorteServicio corteServicio;

    @Autowired
    private IGrupoServicio grupoServicio;


    @RequestMapping("/consultar_actividades")
    public String listarActividades(Model model){
        List<Actividad> listaActividades = actividadServicio.listarTodActividads();

        model.addAttribute("actividad", listaActividades);
        return "views/viewActividades/consultar_actividades";
    }

    @GetMapping("/crear_actividades")
    public String CrearActividades(Model model){

        Actividad actividades = new Actividad(); 
        List<Materia> listaMaterias = materiaServicio.listarTodMaterias();
        List<Corte> listaCortes = corteServicio.listarTodCortes();
        List<Grupo> listaGrupos = grupoServicio.listarTodGrupos();

        model.addAttribute("actividad", actividades);
        model.addAttribute("materia", listaMaterias);   
        model.addAttribute("corte", listaCortes); 
        model.addAttribute("grupo", listaGrupos); 
          
        return "views/viewActividades/crear_actividades";
    }

    @PostMapping("/save")
    public String guardarActividad(@Valid @ModelAttribute Actividad actividades, BindingResult result, Model model, RedirectAttributes attribute){
        
        List<Materia> listaMaterias = materiaServicio.listarTodMaterias();
        List<Corte> listaCortes = corteServicio.listarTodCortes();
        List<Grupo> listaGrupos = grupoServicio.listarTodGrupos();

        if (result.hasErrors()){
            model.addAttribute("materia", listaMaterias);   
            model.addAttribute("corte", listaCortes); 
            model.addAttribute("grupo", listaGrupos); 
            System.out.println("Error al guardar");
            return "crear_actividades";
        }
        actividadServicio.guardarActividad(actividades);
        System.out.println("Actividad guardada");
        attribute.addFlashAttribute("success", "La actividad se ha guardado correctamente");
        return "redirect:consultar_actividades";
    }


    @RequestMapping("/modificar_actividades")
    public String consultarActividadesmodificar(Model model){
        List<Actividad> listaActividades = actividadServicio.listarTodActividads();

        model.addAttribute("actividad", listaActividades);
        return "views/viewActividades/modificar_actividades";
    }

    @GetMapping("/modificar_actividades/{codigo}")
    public String modificarActividades(@PathVariable("codigo") int codigo, Model model, RedirectAttributes attribute){

        Actividad actividades = null;
        if(codigo > 0){
            actividades = actividadServicio.buscarActividadID(codigo);
            if(actividades == null){
                System.out.println("Error: El ID de la actividad no existe!");
                attribute.addFlashAttribute("error", "El ID de la actividad no existe!");
                return "redirect:modificar_actividades";
            }
        }else{
            System.out.println("Error: El ID ingresado no es valido!");
            attribute.addFlashAttribute("error", "El ID ingresado no es valido!");
            return "redirect:modificar_actividades";
        }

        List<Materia> listaMaterias = materiaServicio.listarTodMaterias();
        List<Corte> listaCortes = corteServicio.listarTodCortes();
        List<Grupo> listaGrupos = grupoServicio.listarTodGrupos();

        model.addAttribute("actividad", actividades);
        model.addAttribute("materia", listaMaterias);   
        model.addAttribute("corte", listaCortes); 
        model.addAttribute("grupo", listaGrupos); 

        return "views/viewActividades/form_modificar_actividades";
    }

    @RequestMapping("/borrar_actividades")
    public String consultarActividadesborrar(Model model){
        List<Actividad> listaActividades = actividadServicio.listarTodActividads();

        model.addAttribute("actividad", listaActividades);
        return "views/viewActividades/borrar_actividades";
    }

    @GetMapping("/borrar_actividades/{codigo}")
    public String borrarActividades(@PathVariable("codigo") int codigo, RedirectAttributes attribute){

        Actividad actividades = null;
        if(codigo > 0){
            actividades = actividadServicio.buscarActividadID(codigo);
            if(actividades == null){
                System.out.println("Error: El ID de la actividad no existe!");
                attribute.addFlashAttribute("error", "El ID de la actividad no existe!");
                return "redirect:borrar_actividades";
            }
        }else{
            System.out.println("Error: El ID ingresado no es valido!");
            attribute.addFlashAttribute("error", "El ID ingresado no es valido!");
            return "redirect:borrar_actividades";
        }

        actividadServicio.eliminarActividad(codigo);
        System.out.println("Actividad borrada");
        attribute.addFlashAttribute("warning", "La actividad se ha eliminado correctamente");
        return "redirect:borrar_actividades";
    }
}
