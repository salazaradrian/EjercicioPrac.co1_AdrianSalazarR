package biblioteca.com.demo.repository;

import biblioteca.com.demo.domain.Queja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuejaRepository extends JpaRepository<Queja, Long> {
    // Aquí puedes agregar consultas personalizadas si es necesario
}
