package com.tienda.controller;

import com.tienda.exception.StockInsuficienteException;
import com.tienda.exception.VideojuegoNoEncontradoException;
import com.tienda.model.Catalogos;
import com.tienda.model.Videojuego;
import com.tienda.service.VideojuegoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class VideojuegoController {

    private final VideojuegoService service;

    public VideojuegoController(VideojuegoService service) {
        this.service = service;
    }

    // ---- Listas para los menús desplegables (disponibles en las vistas)
    @ModelAttribute("plataformas")
    public List<String> plataformas() {
        return Catalogos.PLATAFORMAS;
    }

    @ModelAttribute("generos")
    public List<String> generos() {
        return Catalogos.GENEROS;
    }

    @ModelAttribute("clasificaciones")
    public List<String> clasificaciones() {
        return Catalogos.CLASIFICACIONES;
    }

    @GetMapping("/")
    public String inicio() {
        return "redirect:/videojuegos";
    }

    // READ: inventario con búsqueda y filtro por plataforma
    @GetMapping("/videojuegos")
    public String listar(
            @RequestParam(name = "q", required = false) String q,
            @RequestParam(name = "plataforma", required = false)
                    String plataforma,
            Model model) {
        model.addAttribute("juegos", service.listar(q, plataforma));
        model.addAttribute("q", q == null ? "" : q);
        model.addAttribute("plataforma",
                           plataforma == null ? "" : plataforma);
        model.addAttribute("resumen", service.resumen());
        model.addAttribute("umbral",
                           VideojuegoService.UMBRAL_POCO_STOCK);
        return "videojuegos";
    }

    // CREATE: formulario vacío
    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("videojuego", new Videojuego());
        return "formulario";
    }

    // CREATE: guarda el videojuego nuevo
    @PostMapping("/guardar")
    public String guardar(
            @Valid @ModelAttribute("videojuego") Videojuego videojuego,
            BindingResult result,
            RedirectAttributes flash) {
        if (result.hasErrors()) {
            return "formulario";
        }
        service.guardar(videojuego);
        aviso(flash, "success", "Videojuego agregado al inventario.");
        return "redirect:/videojuegos";
    }

    // UPDATE: formulario con los datos actuales
    @GetMapping("/editar/{id}")
    public String formularioEditar(@PathVariable("id") Long id,
                                   Model model,
                                   RedirectAttributes flash) {
        try {
            model.addAttribute("videojuego", service.buscarPorId(id));
            return "formulario";
        } catch (VideojuegoNoEncontradoException e) {
            aviso(flash, "danger", e.getMessage());
            return "redirect:/videojuegos";
        }
    }

    // UPDATE: guarda los cambios
    @PostMapping("/actualizar")
    public String actualizar(
            @Valid @ModelAttribute("videojuego") Videojuego videojuego,
            BindingResult result,
            RedirectAttributes flash) {
        if (result.hasErrors()) {
            return "formulario";
        }
        service.guardar(videojuego);
        aviso(flash, "success", "Videojuego actualizado correctamente.");
        return "redirect:/videojuegos";
    }

    // DELETE: se hace con POST para evitar borrados accidentales
    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id,
                           RedirectAttributes flash) {
        try {
            service.eliminar(id);
            aviso(flash, "warning", "Videojuego eliminado del inventario.");
        } catch (VideojuegoNoEncontradoException e) {
            aviso(flash, "danger", e.getMessage());
        }
        return "redirect:/videojuegos";
    }

    // VENTA: descuenta una unidad del stock
    @PostMapping("/vender/{id}")
    public String vender(@PathVariable("id") Long id,
                         RedirectAttributes flash) {
        try {
            Videojuego juego = service.vender(id);
            aviso(flash, "success", "Venta registrada: " + juego.getTitulo()
                  + " (" + juego.getPlataforma() + "). Quedan "
                  + juego.getStock() + " unidad(es).");
        } catch (VideojuegoNoEncontradoException
                 | StockInsuficienteException e) {
            aviso(flash, "danger", e.getMessage());
        }
        return "redirect:/videojuegos";
    }

    // Mensaje que se muestra como alerta de Bootstrap
    private void aviso(RedirectAttributes flash,
                       String tipo, String mensaje) {
        flash.addFlashAttribute("tipo", tipo);
        flash.addFlashAttribute("mensaje", mensaje);
    }
}
