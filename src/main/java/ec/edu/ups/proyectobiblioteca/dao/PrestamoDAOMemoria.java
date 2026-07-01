/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.proyectobiblioteca.dao;

import ec.edu.ups.proyectobiblioteca.models.Prestamo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class PrestamoDAOMemoria implements PrestamoDAO {

    private List<Prestamo> lista;

    public PrestamoDAOMemoria() {
        lista = new ArrayList<>();
    }

    @Override
    public void crear(Prestamo prestamo) {
        lista.add(prestamo);
    }

    @Override
    public Prestamo buscar(int codigo) {
        for (Prestamo prestamo : lista) {
            if (prestamo.getCodigo() == codigo) {
                return prestamo;
            }
        }
        return null;
    }

    @Override
    public void actualizar(int codigo, Prestamo prestamo) {
        for (int i = 0; i < lista.size(); i++) {
            Prestamo prestamoEncontrado = lista.get(i);

            if (prestamoEncontrado.getCodigo() == codigo) {
                lista.set(i, prestamo);
                break;
            }
        }
    }

    @Override
    public void eliminar(int codigo) {
        Prestamo prestamoEncontrado = buscar(codigo);

        if (prestamoEncontrado != null) {
            lista.remove(prestamoEncontrado);
        }
    }

    @Override
    public List<Prestamo> listar() {
        return lista;
    }

}
