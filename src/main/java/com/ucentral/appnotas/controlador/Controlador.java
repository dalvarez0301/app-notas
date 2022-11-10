package com.ucentral.appnotas.controlador;

import com.ucentral.appnotas.interfaces.ICorte;
import com.ucentral.appnotas.interfaces.IGrupo;
import com.ucentral.appnotas.interfaces.IMateria;
import com.ucentral.appnotas.interfacesServicios.IActividadServicio;
import com.ucentral.appnotas.interfacesServicios.ICorteServicio;
import com.ucentral.appnotas.interfacesServicios.IGrupoServicio;
import com.ucentral.appnotas.interfacesServicios.IMateriasServicio;
import com.ucentral.appnotas.modelo.Actividad;
import com.ucentral.appnotas.modelo.Corte;
import com.ucentral.appnotas.modelo.Grupo;
import com.ucentral.appnotas.modelo.Materias;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class Controlador {

    //Tabla actividades 
    @Autowired
    private IActividadServicio service;

    @GetMapping("/listar-actividades")
    public String listar(Model model){
        List<Actividad>actividades=service.listar();
        model.addAttribute("actividades",actividades);
        return "index";
    }

    @Autowired
    private IMateria materia;

    @Autowired
    private IGrupo grupo;

    @Autowired
    private ICorte corte;

    @GetMapping("/new")
    public String agregar(Model model){
        List<Materias> listaMaterias = (List<Materias>) materia.findAll();
        List<Grupo> listaGrupos = (List<Grupo>) grupo.findAll();
        List<Corte> listaCortes = (List<Corte>) corte.findAll();
        
        model.addAttribute("actividad", new Actividad());
        model.addAttribute("listaMaterias", listaMaterias);
        model.addAttribute("listaGrupos", listaGrupos);
        model.addAttribute("listaCortes", listaCortes);
        return "form-nueva-actividad";
    }

    @PostMapping("/save")
    public String save(@Validated Actividad a, Model model){
        service.save(a);
        return "redirect:/listar-actividades";
    }

    //Tabla materias
    @Autowired
    private IMateriasServicio serviced;

    @GetMapping("/listar-materias")
    public String lista(Model model){
        List<Materias>materias=serviced.listar();
        model.addAttribute("materias",materias);
        return "materias";
    }

    //Tabla Grupos
    @Autowired
    private IGrupoServicio serviceds;

    @GetMapping("/listar-grupos")
    public String list(Model model){
        List<Grupo>grupos=serviceds.listar();
        model.addAttribute("grupos",grupos);
        return "grupos";
    }    

    //Tabla Cortes
    @Autowired
    private ICorteServicio servicedsc;

    @GetMapping("/listar-cortes")
    public String listw(Model model){
        List<Corte>cortes=servicedsc.listar();
        model.addAttribute("cortes",cortes);
        return "cortes";
    }     
    
}


