/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.proyectobiblioteca.models;

/**
 *
 * @author Asus
 */
public class Libro {

    private String ISBN;
    private String titulo;
    private String editorial;
    private boolean disponible;
    private String categoria;
    private Autor autor;

    public Libro(String ISBN, String titulo, String editorial, boolean disponible, String categoria) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.editorial = editorial;
        this.disponible = disponible;
        this.categoria = categoria;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    

    @Override
    public String toString() {
        return "Libro{" + "ISBN=" + ISBN + ", titulo=" + titulo + ", editorial=" + editorial + ", disponible=" + disponible + ", autor=" + (autor.getNombre()) + '}';
    }

}
