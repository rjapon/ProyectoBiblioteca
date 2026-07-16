/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.proyectobiblioteca.dao;

import ec.edu.ups.proyectobiblioteca.models.Autor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mateo
 */
public class AutorDAOMemoria implements AutorDAO {

    private List<Autor> lista;

    public AutorDAOMemoria() {
        lista = new ArrayList<>();
    }

    @Override
    public void crear(Autor autor) {
        lista.add(autor);
    }

    @Override
    public Autor buscar(int codigo) {
        for (Autor autor : lista) {
            if (autor.getCodigo() == codigo) {
                return autor;
            }
        }
        return null;
    }

    @Override
    public void actualizar( Autor autor) {
        for (int i = 0; i < lista.size(); i++) {
            Autor autorEncontrado = lista.get(i);
            if (autorEncontrado.getCodigo() == autor.getCodigo()) {
                lista.set(i, autor);
                break;
            }
        }
    }

    @Override
    public void eliminar(int codigo) {
        Autor autorEncontrado = buscar(codigo);
        if (autorEncontrado != null) {
            lista.remove(autorEncontrado);
        }
    }

    @Override
    public List<Autor> listar() {
        return lista;
    }
    
   @Override
public Autor buscarPorNombre(String nombre) {

    for (Autor autor : lista) {

        if (autor.getNombre().equalsIgnoreCase(nombre)) {
            return autor;
        }

    }

    return null;
}


}
