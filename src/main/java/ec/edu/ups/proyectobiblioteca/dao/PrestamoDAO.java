/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.proyectobiblioteca.dao;

import ec.edu.ups.proyectobiblioteca.models.Prestamo;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface PrestamoDAO {
    
    void crear(Prestamo prestamo);
    Prestamo buscar(int codigo);
    void actualizar(int codigo, Prestamo prestamo);
    void eliminar(int codigo);
    List<Prestamo> listar();
    
}
