package com.tuempresa.tuaplicacion.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class LibroDTO {
    private Long id;

    @NotNull
    private String nombre;

    @NotNull
    private String autor;

    @NotNull
    private LocalDate fechaEscritura;

    @NotNull
    private int numeroEdicion;

    @NotNull
    private double precio;

    @NotNull
    @Pattern(regexp = "Entretenimiento|Pedagógico", message = "El tipo debe ser 'Entretenimiento' o 'Pedagógico'")
    private String tipo;

    @NotNull
    @Pattern(regexp = "Alta|Media|Baja", message = "La fama del escritor debe ser 'Alta', 'Media' o 'Baja'")
    private String famaEscritor;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getFechaEscritura() {
        return fechaEscritura;
    }

    public void setFechaEscritura(LocalDate fechaEscritura) {
        this.fechaEscritura = fechaEscritura;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFamaEscritor() {
        return famaEscritor;
    }

    public void setFamaEscritor(String famaEscritor) {
        this.famaEscritor = famaEscritor;
    }
}
