package com.tuempresa.tuaplicacion.service;

import com.tuempresa.tuaplicacion.dto.LibroDTO;
import com.tuempresa.tuaplicacion.entity.Libro;
import com.tuempresa.tuaplicacion.mapper.LibroMapper;
import com.tuempresa.tuaplicacion.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private LibroMapper libroMapper;

    public LibroDTO crearLibro(LibroDTO libroDTO) {
        Libro libro = libroMapper.convertirAEntity(libroDTO);
        libro = libroRepository.save(libro);
        return libroMapper.convertirADTO(libro);
    }

    public LibroDTO actualizarLibro(Long id, LibroDTO libroDetalles) {
        Optional<Libro> optionalLibro = libroRepository.findById(id);
        if (optionalLibro.isPresent()) {
            Libro libro = optionalLibro.get();
            libro.setNombre(libroDetalles.getNombre());
            libro.setAutor(libroDetalles.getAutor());
            libro.setFechaEscritura(libroDetalles.getFechaEscritura());
            libro.setNumeroEdicion(libroDetalles.getNumeroEdicion());
            libro.setPrecio(libroDetalles.getPrecio());
            libro.setTipo(libroDetalles.getTipo());
            libro.setFamaEscritor(libroDetalles.getFamaEscritor());
            libro = libroRepository.save(libro);
            return libroMapper.convertirADTO(libro);
        } else {
            return null;
        }
    }

    public List<LibroDTO> obtenerTodosLosLibros() {
        return libroRepository.findByEliminadoFalse().stream()
                .map(libro -> libroMapper.convertirADTO(libro))
                .collect(Collectors.toList());
    }

    public Optional<LibroDTO> obtenerLibroPorId(Long id) {
        return libroRepository.findById(id)
                .filter(libro -> !libro.getEliminado())
                .map(libro -> libroMapper.convertirADTO(libro));
    }

    public void eliminarLibro(Long id) {
        Optional<Libro> optionalLibro = libroRepository.findById(id);
        if (optionalLibro.isPresent()) {
            Libro libro = optionalLibro.get();
            libro.setEliminado(true);
            libroRepository.save(libro);
        }
    }
}
