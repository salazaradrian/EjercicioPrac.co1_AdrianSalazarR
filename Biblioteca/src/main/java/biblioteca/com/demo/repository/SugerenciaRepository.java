package biblioteca.com.demo.repositories;

import biblioteca.com.demo.domain.Sugerencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SugerenciaRepository extends JpaRepository<Sugerencia, Long> { }
