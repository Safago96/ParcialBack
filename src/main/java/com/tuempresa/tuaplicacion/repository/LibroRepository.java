package com.tuempresa.tuaplicacion.repository;

import com.tuempresa.tuaplicacion.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByEliminadoFalse();
}
