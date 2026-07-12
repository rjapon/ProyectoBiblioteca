/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.proyectobiblioteca.controllers;

import ec.edu.ups.proyectobiblioteca.dao.AutorDAO;
import ec.edu.ups.proyectobiblioteca.enums.NacionalidadesAutor;
import ec.edu.ups.proyectobiblioteca.models.Autor;
import ec.edu.ups.proyectobiblioteca.views.ActualizarAutorView;
import ec.edu.ups.proyectobiblioteca.views.AgregarAutorView;
import ec.edu.ups.proyectobiblioteca.views.BuscarAutorView;
import ec.edu.ups.proyectobiblioteca.views.EliminarAutorView;
import ec.edu.ups.proyectobiblioteca.views.ListarAutorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

/**
 *
 * @author mateo
 */
public class AutorController {

    private ActualizarAutorView actualizarAutorView;
    private AgregarAutorView agregarAutorView;
    private EliminarAutorView eliminarAutorView;
    private BuscarAutorView buscarAutorView;
    private ListarAutorView listarAutorView;
    private AutorDAO autorDAO;

    public AutorController(ActualizarAutorView actualizarAutorView, AgregarAutorView agregarAutorView, EliminarAutorView eliminarAutorView, BuscarAutorView buscarAutorView, ListarAutorView listarAutorView, AutorDAO autorDAO) {
        this.actualizarAutorView = actualizarAutorView;
        this.agregarAutorView = agregarAutorView;
        this.eliminarAutorView = eliminarAutorView;
        this.listarAutorView = listarAutorView;
        this.buscarAutorView = buscarAutorView;
        this.autorDAO = autorDAO;

        configurarVentanaAgregarAutor();
        configurarVentanaActualizarAutor();
        configurarEventosBuscarAutor();
        configurarEventosEliminarAutor();
        configurarEventosBuscarEliminarAutor();
        configurarEventosBuscarActualizarAutor();
        configurarEventosActualizarAutor();
        configurarEventosAgregarAutor();
        configurarEventosListarAutores();
    }

    public void buscarAutor() {

        int codigo = Integer.parseInt(
                buscarAutorView.getTxtCodigoBuscarAutor().getText());

        Autor autor = autorDAO.buscar(codigo);

        if (autor != null) {

            buscarAutorView.getTxtNombreBuscarAutor()
                    .setText(autor.getNombre());

            buscarAutorView.getTxtNacionalidadBuscarAutor()
                    .setText(autor.getNacionalidad().toString());

        } else {

            buscarAutorView.mostrarInformacion(
                    "No se encontró el autor");
        }
    }

    public void configurarEventosBuscarAutor() {

        buscarAutorView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarAutor();
            }
        });

    }

    public void eliminarAutor() {

        int codigo = Integer.parseInt(
                eliminarAutorView.getTxtCodigoEliminarAutorView().getText());

        int respuesta = JOptionPane.showConfirmDialog(
                eliminarAutorView,
                "¿Deseas eliminar el autor?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {

            autorDAO.eliminar(codigo);

            eliminarAutorView.mostrarInformacion("Autor eliminado");

            eliminarAutorView.getTxtCodigoEliminarAutorView().setText("");
            eliminarAutorView.getTxtNombreEliminarAutorView().setText("");
            eliminarAutorView.getTxtNacionalidadEliminarAutorView().setText("");
        }
    }

    public void configurarEventosEliminarAutor() {

        eliminarAutorView.getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarAutor();
            }
        });

    }

    public void configurarEventosBuscarEliminarAutor() {

        eliminarAutorView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int codigo = Integer.parseInt(
                        eliminarAutorView.getTxtCodigoEliminarAutorView().getText());

                Autor autor = autorDAO.buscar(codigo);

                if (autor != null) {

                    eliminarAutorView.getTxtNombreEliminarAutorView()
                            .setText(autor.getNombre());

                    eliminarAutorView.getTxtNacionalidadEliminarAutorView()
                            .setText(autor.getNacionalidad().toString());

                } else {

                    eliminarAutorView.mostrarInformacion("No se encontró el autor");

                }

            }
        });

    }

    public void buscarAutorActualizar() {

        int codigo = Integer.parseInt(actualizarAutorView.getTxtCodigoActulizarAutorView().getText());

        Autor autor = autorDAO.buscar(codigo);

        if (autor != null) {

            actualizarAutorView.getTxtNombreActualizarAutorView().setText(autor.getNombre());

            actualizarAutorView.getCboNacionalidadesActualizar()
                    .setSelectedItem(autor.getNacionalidad());

        } else {

            actualizarAutorView.mostrarInformacion("No se encontró el autor");

        }
    }

    public void configurarEventosBuscarActualizarAutor() {

        actualizarAutorView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarAutorActualizar();
            }
        });

    }

    public void actualizarAutor() {

        int codigo = Integer.parseInt(
                actualizarAutorView.getTxtCodigoActulizarAutorView().getText());

        int respuesta = JOptionPane.showConfirmDialog(
                actualizarAutorView,
                "¿Deseas actualizar el autor?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {

            String nombre = actualizarAutorView
                    .getTxtNombreActualizarAutorView().getText();

            NacionalidadesAutor nacionalidad
                    = (NacionalidadesAutor) actualizarAutorView
                            .getCboNacionalidadesActualizar()
                            .getSelectedItem();

            Autor autorActualizado = new Autor();

            autorActualizado.setCodigo(codigo);
            autorActualizado.setNombre(nombre);
            autorActualizado.setNacionalidad(nacionalidad);

            autorDAO.actualizar(codigo, autorActualizado);

            actualizarAutorView.mostrarInformacion(
                    "Autor actualizado correctamente");
        }
    }

    public void cargarNacionalidadesActualizar() {

        actualizarAutorView.getCboNacionalidadesActualizar().removeAllItems();

        for (NacionalidadesAutor nacionalidad : NacionalidadesAutor.values()) {
            actualizarAutorView.getCboNacionalidadesActualizar().addItem(nacionalidad);
        }
    }

    public void configurarEventosActualizarAutor() {

        actualizarAutorView.getBtnActualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarAutor();
            }
        });

    }

    public void configurarVentanaActualizarAutor() {

        actualizarAutorView.addInternalFrameListener(new InternalFrameAdapter() {

            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                cargarNacionalidadesActualizar();
            }

        });
    }

    public void agregarAutor() {

        int codigo = Integer.parseInt(
                agregarAutorView.getTxtCodigoAgregarAutorView().getText());

        String nombre = agregarAutorView
                .getTxtNombreAgregarAutorView().getText();

        NacionalidadesAutor nacionalidad
                = (NacionalidadesAutor) agregarAutorView
                        .getCboNacionalidadesAgregar()
                        .getSelectedItem();

        Autor autor = autorDAO.buscar(codigo);

        if (autor != null) {

            agregarAutorView.mostrarInformacion(
                    "Ya existe un autor con ese código");

        } else {

            Autor nuevoAutor = new Autor(
                    codigo,
                    nombre,
                    nacionalidad);

            autorDAO.crear(nuevoAutor);

            agregarAutorView.mostrarInformacion(
                    "Autor agregado exitosamente");
        }

    }

    public void cargarNacionalidadesAgregar() {

        agregarAutorView.getCboNacionalidadesAgregar().removeAllItems();

        for (NacionalidadesAutor nacionalidad : NacionalidadesAutor.values()) {
            agregarAutorView.getCboNacionalidadesAgregar().addItem(nacionalidad);
        }
    }

    public void configurarEventosAgregarAutor() {

        agregarAutorView.getBtnAceptar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarAutor();
            }
        });

    }

    public void configurarVentanaAgregarAutor() {

        agregarAutorView.addInternalFrameListener(new InternalFrameAdapter() {

            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                cargarNacionalidadesAgregar();
            }

        });
    }

    public void listarAutores() {

        List<Autor> autores = autorDAO.listar();
        listarAutorView.cargarDatos(autores);
    }

    public void configurarEventosListarAutores() {

        listarAutorView.getBtnListar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarAutores();
            }
        });

    }

}
