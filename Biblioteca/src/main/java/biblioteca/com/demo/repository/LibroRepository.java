package biblioteca.com.demo.repository;

import biblioteca.com.demo.domain.Libro;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroRepository {

    private List<Libro> libros = new ArrayList<>();

    public List<Libro> findAll() {
        return libros;
    }

    public void save(Libro libro) {
        libros.add(libro);
    }
}
