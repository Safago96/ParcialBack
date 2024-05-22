package com.tuempresa.tuaplicacion.mapper;

import com.tuempresa.tuaplicacion.dto.LibroDTO;
import com.tuempresa.tuaplicacion.entity.Libro;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LibroMapper {

    @Autowired
    private ModelMapper modelMapper;

    public LibroDTO convertirADTO(Libro libro) {
        return modelMapper.map(libro, LibroDTO.class);
    }

    public Libro convertirAEntity(LibroDTO libroDTO) {
        return modelMapper.map(libroDTO, Libro.class);
    }
}
