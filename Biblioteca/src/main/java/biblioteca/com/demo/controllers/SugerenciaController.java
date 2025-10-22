package biblioteca.com.demo.controllers;

import biblioteca.com.demo.domain.Sugerencia;
import biblioteca.com.demo.repositories.SugerenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SugerenciaController {

    @Autowired
    private SugerenciaRepository sugerenciaRepository;

    @GetMapping("/sugerencias")
    public String mostrarFormulario(Model model) {
        model.addAttribute("sugerencia", new Sugerencia());
        return "sugerencias";
    }

    @PostMapping("/sugerencias/enviar")
    public String enviarSugerencia(@ModelAttribute Sugerencia sugerencia, Model model) {
        sugerenciaRepository.save(sugerencia);
        model.addAttribute("mensajeExito", "¡Gracias! Tu sugerencia ha sido enviada.");
        model.addAttribute("sugerencia", new Sugerencia());
        return "sugerencias";
    }
}
