/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.proyectobiblioteca.models;

import ec.edu.ups.proyectobiblioteca.enums.NacionalidadesAutor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mateo
 */
public class Autor {

    private int codigo;
    private String nombre;
    private NacionalidadesAutor nacionalidad;
    private List<Libro> libros;

    public Autor() {
        libros = new ArrayList<>();
    }

    public Autor(int codigo, String nombre, NacionalidadesAutor nacionalidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        libros = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NacionalidadesAutor getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(NacionalidadesAutor nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        libro.setAutor(this);
    }

    @Override
    public String toString() {
        return "Autor{" + "codigo=" + codigo + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", libros=" + libros + '}';
    }

}
