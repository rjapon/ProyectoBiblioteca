/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.proyectobiblioteca.controllers;

import ec.edu.ups.proyectobiblioteca.dao.UsuarioDAO;
import ec.edu.ups.proyectobiblioteca.models.Usuario;
import ec.edu.ups.proyectobiblioteca.views.ActualizarUsuarioView;
import ec.edu.ups.proyectobiblioteca.views.BuscarUsuarioView;
import ec.edu.ups.proyectobiblioteca.views.CrearUsuarioView;
import ec.edu.ups.proyectobiblioteca.views.EliminarUsuarioView;
import ec.edu.ups.proyectobiblioteca.views.ListarUsuarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class UsuarioController {

    private CrearUsuarioView crearUsuarioView;
    private ActualizarUsuarioView actualizarUsuarioView;
    private EliminarUsuarioView eliminarUsuarioview;
    private ListarUsuarioView listarUsuarioView;
    private BuscarUsuarioView buscarUsuarioView;

    private UsuarioDAO usuarioDAO;

    public UsuarioController(CrearUsuarioView crearUsuarioView, ActualizarUsuarioView actualizarUsuarioView, EliminarUsuarioView eliminarUsuarioview, BuscarUsuarioView buscarUsuarioView,  ListarUsuarioView listarUsuarioView, UsuarioDAO usuarioDAO) {
        this.crearUsuarioView = crearUsuarioView;
        this.actualizarUsuarioView = actualizarUsuarioView;
        this.eliminarUsuarioview = eliminarUsuarioview;
        this.listarUsuarioView = listarUsuarioView;
        this.buscarUsuarioView = buscarUsuarioView;
        this.usuarioDAO = usuarioDAO;

        configurarEventosCrearUsuario();
        configurarEventosBuscarUsuario();
        configurarEventosBuscarActualizarUsuario();
        configurarEventosActualizarUsuario();
        configurarEventosBuscarEliminarUsuario();
        configurarEventosEliminarUsuario();
        configurarEventosListarUsuarios();
    }

    public void crearUsuario() {

        String cedula = crearUsuarioView
                .getTxtCedulaCrearUsuario().getText();

        String nombre = crearUsuarioView
                .getTxtNombreCrearUsuario().getText();

        String telefono = crearUsuarioView
                .getTxtTelefonoCrearUsuario().getText();

        Usuario usuario = usuarioDAO.buscar(cedula);

        if (usuario != null) {

            crearUsuarioView.mostrarInformacion(
                    "Ya existe un usuario con esa cédula");

        } else {

            Usuario nuevoUsuario = new Usuario(
                    nombre,
                    cedula,
                    telefono);

            usuarioDAO.crear(nuevoUsuario);

            crearUsuarioView.mostrarInformacion(
                    "Usuario creado correctamente");

            crearUsuarioView.getTxtCedulaCrearUsuario().setText("");
            crearUsuarioView.getTxtNombreCrearUsuario().setText("");
            crearUsuarioView.getTxtTelefonoCrearUsuario().setText("");
        }

    }

    public void configurarEventosCrearUsuario() {

        crearUsuarioView.getBtnCrear().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearUsuario();
            }
        });
    }

    public void buscarUsuario() {

        String cedula = buscarUsuarioView
                .getTxtCedulaBuscarUsuarioView().getText();

        Usuario usuario = usuarioDAO.buscar(cedula);

        if (usuario != null) {

            buscarUsuarioView.getTxtNombreBuscarUsuarioView()
                    .setText(usuario.getNombre());

            buscarUsuarioView.getTxtTelefonoBuscarUsuarioView()
                    .setText(usuario.getTelefono());

        } else {

            buscarUsuarioView.mostrarInformacion(
                    "No se encontró el usuario");

        }

    }

    public void configurarEventosBuscarUsuario() {

        buscarUsuarioView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                buscarUsuario();

            }
        });

    }

    public void buscarUsuarioActualizar() {

        String cedula = actualizarUsuarioView
                .getTxtCedulaActualizarUsuario().getText();

        Usuario usuario = usuarioDAO.buscar(cedula);

        if (usuario != null) {

            actualizarUsuarioView.getTxtNombreActualizarUsuario()
                    .setText(usuario.getNombre());

            actualizarUsuarioView.getTxtTelefonoActualizarUsuario()
                    .setText(usuario.getTelefono());

        } else {

            actualizarUsuarioView.mostrarInformacion(
                    "No se encontró el usuario");

        }

    }

    public void configurarEventosBuscarActualizarUsuario() {

        actualizarUsuarioView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                buscarUsuarioActualizar();

            }
        });

    }

    public void actualizarUsuario() {

        String cedula = actualizarUsuarioView
                .getTxtCedulaActualizarUsuario().getText();

        int respuesta = JOptionPane.showConfirmDialog(
                actualizarUsuarioView,
                "¿Deseas actualizar el usuario?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {

            String nombre = actualizarUsuarioView
                    .getTxtNombreActualizarUsuario().getText();

            String telefono = actualizarUsuarioView
                    .getTxtTelefonoActualizarUsuario().getText();

            Usuario usuarioActualizado = new Usuario();

            usuarioActualizado.setCedula(cedula);
            usuarioActualizado.setNombre(nombre);
            usuarioActualizado.setTelefono(telefono);

            usuarioDAO.actualizar(cedula, usuarioActualizado);

            actualizarUsuarioView.mostrarInformacion(
                    "Usuario actualizado correctamente");
        }

    }

    public void configurarEventosActualizarUsuario() {

        actualizarUsuarioView.getBtnActualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                actualizarUsuario();

            }
        });

    }

    public void buscarUsuarioEliminar() {

        String cedula = eliminarUsuarioview
                .getTxtCedulaEliminarUsuario()
                .getText();

        Usuario usuario = usuarioDAO.buscar(cedula);

        if (usuario != null) {

            eliminarUsuarioview.getTxtNombreEliminarUsuario()
                    .setText(usuario.getNombre());

            eliminarUsuarioview.getTxtTelfonoEliminarUsuario()
                    .setText(usuario.getTelefono());

        } else {

            eliminarUsuarioview.mostrarInformacion("No se encontró el usuario");

        }
    }

    public void configurarEventosBuscarEliminarUsuario() {

        eliminarUsuarioview.getBtnBuscarEliminarUsuario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                buscarUsuarioEliminar();

            }
        });

    }

    public void eliminarUsuario() {

        String cedula = eliminarUsuarioview
                .getTxtCedulaEliminarUsuario()
                .getText();

        int respuesta = JOptionPane.showConfirmDialog(
                eliminarUsuarioview,
                "¿Deseas eliminar el usuario?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {

            usuarioDAO.eliminar(cedula);

            eliminarUsuarioview.mostrarInformacion(
                    "Usuario eliminado correctamente");

            eliminarUsuarioview.getTxtCedulaEliminarUsuario().setText("");
            eliminarUsuarioview.getTxtNombreEliminarUsuario().setText("");
            eliminarUsuarioview.getTxtTelfonoEliminarUsuario().setText("");
        }
    }

    public void configurarEventosEliminarUsuario() {

        eliminarUsuarioview.getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                eliminarUsuario();

            }
        });

    }

    public void listarUsuarios() {
        List<Usuario> usuarios = usuarioDAO.listar();
        listarUsuarioView.cargarDatos(usuarios);
    }

    public void configurarEventosListarUsuarios() {

        listarUsuarioView.getBtnListar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarUsuarios();
            }
        });

    }

}
