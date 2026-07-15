/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.proyectobiblioteca.dao;

import ec.edu.ups.proyectobiblioteca.models.Libro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class LibroDAOMemoria implements LibroDAO {

    private List<Libro> lista;

    public LibroDAOMemoria() {
        lista = new ArrayList<>();
    }

    @Override
    public void crear(Libro libro) {
        lista.add(libro);
    }

    @Override
    public Libro buscar(String isbn) {
        for (Libro libro : lista) {
            if (libro.getISBN().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    @Override
    public void actualizar(String isbn, Libro libro) {
        for (int i = 0; i < lista.size(); i++) {
            Libro libroEncontrado = lista.get(i);

            if (libroEncontrado.getISBN().equals(isbn)) {
                lista.set(i, libro);
                break;
            }
        }
    }

    @Override
    public void eliminar(String isbn) {
        Libro libroEncontrado = buscar(isbn);

        if (libroEncontrado != null) {
            lista.remove(libroEncontrado);
        }
    }

    @Override
    public List<Libro> listar() {
        return lista;
    }

    @Override
    public void cambiarDisponibilidad(String isbn, boolean disponible) {

        Libro libro = buscar(isbn);

        if (libro != null) {
            libro.setDisponible(disponible);
        }
    }

}
