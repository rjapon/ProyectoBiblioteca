/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.proyectobiblioteca.dao;

import ec.edu.ups.proyectobiblioteca.models.Libro;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface LibroDAO {

    void crear(Libro libro);

    Libro buscar(String isbn);

    void actualizar(String isbn, Libro libro);

    void eliminar(String isbn);
    
    void cambiarEstado();

    List<Libro> listar();

}
