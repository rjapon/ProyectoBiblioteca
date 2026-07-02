/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.proyectobiblioteca.dao;

import ec.edu.ups.proyectobiblioteca.models.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class UsuarioDAOMemoria implements UsuarioDAO {

    private List<Usuario> lista;

    public UsuarioDAOMemoria() {
        lista = new ArrayList<>();
    }

    @Override
    public void crear(Usuario usuario) {
        lista.add(usuario);
    }

    @Override
    public Usuario buscar(String cedula) {

        for (Usuario usuario : lista) {
            if (usuario.getCedula().equals(cedula)) {
                return usuario;
            }
        }

        return null;
    }

    @Override
    public void actualizar(String cedula, Usuario usuario) {

        for (int i = 0; i < lista.size(); i++) {
            Usuario usuarioEncontrado = lista.get(i);

            if (usuarioEncontrado.getCedula().equals(cedula)) {
                lista.set(i, usuario);
                break;
            }
        }
    }

    @Override
    public void eliminar(String cedula) {

        Usuario usuarioEncontrado = buscar(cedula);

        if (usuarioEncontrado != null) {
            lista.remove(usuarioEncontrado);
        }
    }

    @Override
    public List<Usuario> listar() {
        return lista;
    }

}
