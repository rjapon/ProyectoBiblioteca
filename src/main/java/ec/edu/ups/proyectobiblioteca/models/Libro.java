/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.proyectobiblioteca.models;

import ec.edu.ups.proyectobiblioteca.enums.CategoriasLibro;
import java.time.LocalDate;

/**
 *
 * @author Asus
 */
public class Libro {

    private String ISBN;
    private String titulo;
    private String editorial;
    private boolean disponible;
    private CategoriasLibro categoria;
    private Autor autor;
    private LocalDate fechaPublicacion;

    public Libro(String ISBN, String titulo, String editorial, boolean disponible, CategoriasLibro categoria, Autor autor, LocalDate fechaPublicacion) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.editorial = editorial;
        this.disponible = disponible;
        this.categoria = categoria;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
    }

    public Libro() {

    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public boolean verificarDisponibilidad() {

        if (disponible == true) {
            return true;
        } else {
            return false;
        }
    }

    public CategoriasLibro getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriasLibro categoria) {
        this.categoria = categoria;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    @Override
    public String toString() {
        return "Libro{" + "ISBN=" + ISBN + ", titulo=" + titulo + ", editorial=" + editorial + ", disponible=" + disponible + ", categoria=" + categoria + ", autor=" + autor + ", fechaPublicacion=" + fechaPublicacion + '}';
    }

}
