package com.tuempresa.tuaplicacion.entity;

import jakarta.annotation.Nonnull;
3import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    private String nombre;

    @Nonnull
    private String autor;

    @Nonnull
    private LocalDate fechaEscritura;

    @Nonnull
    private int numeroEdicion;

    @Nonnull
    private double precio;

    @Nonnull
    @jakarta.validation.constraints.Pattern(regexp = "Entretenimiento|Pedagógico", message = "El tipo debe ser 'Entretenimiento' o 'Pedagógico'")
    private String tipo;

    @Nonnull
    @jakarta.validation.constraints.Pattern(regexp = "Alta|Media|Baja", message = "La fama del escritor debe ser 'Alta', 'Media' o 'Baja'")
    private String famaEscritor;

    private Boolean eliminado = false; // Soft delete flag

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

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }
}
