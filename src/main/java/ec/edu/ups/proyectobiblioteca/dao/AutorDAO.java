/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.proyectobiblioteca.dao;

import ec.edu.ups.proyectobiblioteca.models.Autor;
import java.util.List;

/**
 *
 * @author mateo
 */
public interface AutorDAO {
    void crear(Autor autor);
    Autor buscar(int codigo);
    void actualizar(int codigo, Autor autor);
    void eliminar(int codigo);
    Autor buscarPorNombre(String nombre);
    List<Autor>listar();
}
