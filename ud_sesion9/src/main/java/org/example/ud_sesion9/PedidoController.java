package org.example.ud_sesion9;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PedidoController {

    @GetMapping("/pedido")
    public String mostrarFormulario(Model model) {
        // Metemos un objeto vacío para que Thymeleaf pueda enlazar los campos
        model.addAttribute("pedidoForm", new PedidoForm());
        return "pedido";
    }

    @PostMapping("/pedido")
    public String procesarPedido(@ModelAttribute("pedidoForm") PedidoForm form, Model model) {

        List<String> errores = validar(form);

        if (!errores.isEmpty()) {
            model.addAttribute("errores", errores);
            return "pedido";
        }

        double base = calcularBase(form.getUnidades(), form.getPrecio());
        double descuentoVolumen = calcularDescuentoVolumen(base, form.getUnidades());
        double descuentoClub = calcularDescuentoClub(base, form.getCliente());
        double extraMontaje = calcularMontaje(form.getMontaje());

        double baseImponible = base - descuentoVolumen - descuentoClub + extraMontaje;
        double iva = calcularIva(baseImponible);
        double total = baseImponible + iva;

        model.addAttribute("base", base);
        model.addAttribute("descuentoVolumen", descuentoVolumen);
        model.addAttribute("descuentoClub", descuentoClub);
        model.addAttribute("extraMontaje", extraMontaje);
        model.addAttribute("baseImponible", baseImponible);
        model.addAttribute("iva", iva);
        model.addAttribute("total", total);
        model.addAttribute("catalogo", obtenerCatalogo());

        return "desglose";
    }

    private List<String> validar(PedidoForm form) {
        List<String> errores = new ArrayList<>();
        if (form.getUnidades() == null || form.getUnidades() < 1 || form.getUnidades() > 100) {
            errores.add("Las unidades deben estar entre 1 y 100.");
        }
        if (form.getPrecio() == null || form.getPrecio() <= 0) {
            errores.add("El precio debe ser mayor que cero.");
        }
        if (form.getCliente() == null || (!form.getCliente().equals("particular") && !form.getCliente().equals("club"))) {
            errores.add("El tipo de cliente seleccionado no es válido.");
        }
        return errores;
    }

    private double calcularBase(int unidades, double precio) {
        return unidades * precio;
    }

    private double calcularDescuentoVolumen(double base, int unidades) {
        if (unidades >= 100) return base * 0.15;
        if (unidades >= 50) return base * 0.10;
        if (unidades >= 10) return base * 0.05;
        return 0.0;
    }

    private double calcularDescuentoClub(double base, String cliente) {
        if ("club".equals(cliente)) {
            return base * 0.10;
        }
        return 0.0;
    }

    private double calcularMontaje(Boolean montaje) {
        return (montaje != null && montaje) ? 15.0 : 0.0;
    }

    private double calcularIva(double baseImponible) {
        return baseImponible * 0.21;
    }

    private List<Articulo> obtenerCatalogo() {
        List<Articulo> catalogo = new ArrayList<>();
        catalogo.add(new Articulo("Bicicleta Montaña X1", 350.0, false));
        catalogo.add(new Articulo("Bicicleta Paseo Vintage", 210.0, true)); // Marcamos esta como agotada
        catalogo.add(new Articulo("Casco Aero Bici", 45.0, false));
        return catalogo;
    }
}