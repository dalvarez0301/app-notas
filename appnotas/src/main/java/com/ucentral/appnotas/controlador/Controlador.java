package com.ucentral.appnotas.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {


    @GetMapping("/menu_principal")
    public String index() {
        return "index";
    }


}
