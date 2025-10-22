package biblioteca.com.demo.controllers;

import biblioteca.com.demo.domain.Queja;
import biblioteca.com.demo.repository.QuejaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/quejas")
public class QuejaController {

    @Autowired
    private QuejaRepository quejaRepository;

    // Mostrar formulario y lista de quejas
    @GetMapping
    public String listarQuejas(Model model) {
        List<Queja> quejas = quejaRepository.findAll();
        model.addAttribute("quejas", quejas);
        model.addAttribute("queja", new Queja());
        return "queja-form";
    }

    // Guardar nueva queja
    @PostMapping("/guardar")
    public String guardarQueja(@Valid @ModelAttribute("queja") Queja queja, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("quejas", quejaRepository.findAll());
            return "queja-form";
        }
        quejaRepository.save(queja);
        return "redirect:/quejas?exito";
    }

    // Eliminar queja
    @GetMapping("/eliminar/{id}")
    public String eliminarQueja(@PathVariable("id") Long id) {
        quejaRepository.deleteById(id);
        return "redirect:/quejas?eliminado";
    }
}