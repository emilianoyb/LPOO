package com.gremio.controller;

import com.gremio.model.Contacto;
import com.gremio.repository.ContactoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactoController {

    private final ContactoRepository repo;

    // Spring inyecta el repository automáticamente
    public ContactoController(ContactoRepository repo) {
        this.repo = repo;
    }

    // GET /contactos -> muestra la lista
    @GetMapping("/contactos")
    public String listar(Model model) {
        model.addAttribute("contactos", repo.findAll());
        return "contactos";
    }

    // GET /nuevo -> muestra el formulario vacío
    @GetMapping("/nuevo")
    public String formulario(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "nuevo";
    }

    // POST /guardar -> recibe el formulario y guarda en BD
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Contacto contacto) {
        repo.save(contacto);
        return "redirect:/contactos";
    }

    // ---------- UPDATE ----------

    // GET /editar/{id} -> formulario con los datos actuales
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id,
                         Model model) {
        Contacto contacto = repo.findById(id).orElse(null);
        if (contacto == null) {
            return "redirect:/contactos";
        }
        model.addAttribute("contacto", contacto);
        return "editar";
    }

    // POST /actualizar -> como el objeto trae id, save() hace UPDATE
    @PostMapping("/actualizar")
    public String actualizar(@ModelAttribute Contacto contacto) {
        repo.save(contacto);
        return "redirect:/contactos";
    }

    // ---------- DELETE ----------

    // POST /eliminar/{id} -> borra el contacto
    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id) {
        repo.deleteById(id);
        return "redirect:/contactos";
    }
}
