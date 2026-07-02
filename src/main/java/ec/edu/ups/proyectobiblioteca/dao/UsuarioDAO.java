/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.proyectobiblioteca.dao;

import ec.edu.ups.proyectobiblioteca.models.Usuario;
import java.util.List;

/**
 *
 * @author Asus
 */
public interface UsuarioDAO {

     void crear(Usuario usuario);

    Usuario buscar(String cedula);

    void actualizar(String cedula, Usuario usuario);

    void eliminar(String cedula);

    List<Usuario> listar();

}
