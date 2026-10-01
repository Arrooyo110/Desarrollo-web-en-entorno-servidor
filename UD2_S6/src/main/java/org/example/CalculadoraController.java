package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculadoraController {

    @GetMapping("/entrada")
    public String entrada(@RequestParam String nombre, Model model) {
        model.addAttribute("nombre", nombre);
        return "entrada";
    }
}