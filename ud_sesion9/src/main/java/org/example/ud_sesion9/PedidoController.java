package org.example.ud_sesion9;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
class PedidoController {
    @GetMapping("/pedido")
    public String entrada(@RequestParam(defaultValue = "sin nombre") String producto,
                          @RequestParam(defaultValue = "0") double precio ,
                          @RequestParam(defaultValue = "1") int cantidad,
                          Model model){

        if (cantidad < 1) {
            cantidad = 1;
        }

        double base = precio * cantidad;
        double iva = base * 0.21;
        double total = base + iva;

        model.addAttribute("producto", producto);
        model.addAttribute("precio", precio);
        model.addAttribute("cantidad", cantidad);
        model.addAttribute("base", base);
        model.addAttribute("iva", iva);
        model.addAttribute("total", total);

        return "pedido";
    }
}
