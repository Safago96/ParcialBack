package com.tuempresa.tuaplicacion.controller;

import com.tuempresa.tuaplicacion.dto.LibroDTO;
import com.tuempresa.tuaplicacion.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @PostMapping
    public LibroDTO crearLibro(@Valid @RequestBody LibroDTO libroDTO) {
        return libroService.crearLibro(libroDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroDTO> actualizarLibro(@PathVariable Long id, @Valid @RequestBody LibroDTO libroDetalles) {
        LibroDTO libroActualizado = libroService.actualizarLibro(id, libroDetalles);
        if (libroActualizado != null) {
            return ResponseEntity.ok(libroActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public List<LibroDTO> obtenerTodosLosLibros() {
        return libroService.obtenerTodosLosLibros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroDTO> obtenerLibroPorId(@PathVariable Long id) {
        Optional<LibroDTO> libro = libroService.obtenerLibroPorId(id);
        if (libro.isPresent()) {
            return ResponseEntity.ok(libro.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
        return ResponseEntity.noContent().build();
    }
}
