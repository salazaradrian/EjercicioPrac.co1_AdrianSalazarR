package biblioteca.com.demo.controllers;

import biblioteca.com.demo.domain.Libro;
import biblioteca.com.demo.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private LibroRepository libroRepository;

    @GetMapping("/")
    public String index(Model model) {
        // Tomar un libro como destacado si existe
        Libro libroDestacado = libroRepository.findAll().stream().findFirst().orElse(null);
        model.addAttribute("libroDestacado", libroDestacado);
        return "index"; // index.html
    }
}
