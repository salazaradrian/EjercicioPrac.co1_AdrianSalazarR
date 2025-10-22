package biblioteca.com.demo.controllers;

import biblioteca.com.demo.domain.Libro;
import biblioteca.com.demo.domain.Categoria;
import biblioteca.com.demo.repository.LibroRepository;
import biblioteca.com.demo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

   
    @GetMapping
    public String listarLibros(Model model) {
        List<Libro> libros = libroRepository.findAll();
        List<Categoria> categorias = categoriaRepository.findAll();
        model.addAttribute("libros", libros);
        model.addAttribute("categorias", categorias);
        model.addAttribute("libro", new Libro()); // para el modal
        return "libros";
    }

    // Guardar un libro nuevo
    @PostMapping("/guardar")
    public String guardarLibro(@ModelAttribute Libro libro) {
        libroRepository.save(libro);
        return "redirect:/libros";
    }

    // Actualizar libro existente
    @PostMapping("/actualizar/{id}")
    public String actualizarLibro(@PathVariable Long id, @ModelAttribute Libro libroActualizado) {
        Optional<Libro> libroOptional = libroRepository.findById(id);
        if (libroOptional.isPresent()) {
            Libro libro = libroOptional.get();
            libro.setTitulo(libroActualizado.getTitulo());
            libro.setAutor(libroActualizado.getAutor());
            libro.setDescripcion(libroActualizado.getDescripcion());
            libro.setPrecio(libroActualizado.getPrecio());
            libro.setCategoria(libroActualizado.getCategoria());
            libro.setDisponible(libroActualizado.getDisponible());
            libroRepository.save(libro);
        }
        return "redirect:/libros";
    }

    // Eliminar libro
    @GetMapping("/eliminar/{id}")
    public String eliminarLibro(@PathVariable Long id) {
        libroRepository.deleteById(id);
        return "redirect:/libros";
    }

    
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Libro> obtenerLibro(@PathVariable Long id) {
        Optional<Libro> libroOptional = libroRepository.findById(id);
        return libroOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
