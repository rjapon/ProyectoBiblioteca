/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.proyectobiblioteca.controllers;

import ec.edu.ups.proyectobiblioteca.dao.AutorDAO;
import ec.edu.ups.proyectobiblioteca.enums.NacionalidadesAutor;
import ec.edu.ups.proyectobiblioteca.exceptions.AutorNoEncontradoException;
import ec.edu.ups.proyectobiblioteca.exceptions.ValidarCamposException;
import ec.edu.ups.proyectobiblioteca.models.Autor;
import ec.edu.ups.proyectobiblioteca.views.ActualizarAutorView;
import ec.edu.ups.proyectobiblioteca.views.AgregarAutorView;
import ec.edu.ups.proyectobiblioteca.views.BuscarAutorView;
import ec.edu.ups.proyectobiblioteca.views.EliminarAutorView;
import ec.edu.ups.proyectobiblioteca.views.ListarAutorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
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

    private ResourceBundle bundle;

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

        cambiarIdioma(new Locale("es", "EC"));
    }

    public void cambiarIdioma(Locale locale) {
        bundle = ResourceBundle.getBundle(
                "ec.edu.ups.proyectobiblioteca.i18n.mensajes",
                locale);
    }

    public void buscarAutor() {

        try {
            String codigo = buscarAutorView.getTxtCodigoBuscarAutor().getText().trim();

            if (codigo.isEmpty()) {
                throw new ValidarCamposException("Campo de codigo vacio");
            }

            int codigo2 = Integer.parseInt(codigo);
            Autor autor = autorDAO.buscar(codigo2);
            if (autor != null) {

                buscarAutorView.getTxtNombreBuscarAutor().setText(autor.getNombre());
                buscarAutorView.getTxtNacionalidadBuscarAutor().setText(autor.getNacionalidad().toString());

            } else {

                buscarAutorView.mostrarInformacion("autorNoEncontrado");

            }
        } catch (ValidarCamposException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    bundle.getString("errorFormatoCodigo"));
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

        try {
            String codigo = eliminarAutorView.getTxtCodigoEliminarAutorView().getText();

            if (codigo.isEmpty()) {
                throw new ValidarCamposException("Campo de codigo esta vacio");
            }

            int codigo2 = Integer.parseInt(codigo);

            int respuesta = JOptionPane.showConfirmDialog(
                    eliminarAutorView,
                    "¿Deseas eliminar el autor?",
                    "Confirmación",
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {

                autorDAO.eliminar(codigo2);

                eliminarAutorView.mostrarInformacion("autorEliminado");

                eliminarAutorView.getTxtCodigoEliminarAutorView().setText("");
                eliminarAutorView.getTxtNombreEliminarAutorView().setText("");
                eliminarAutorView.getTxtNacionalidadEliminarAutorView().setText("");
            }
        } catch (ValidarCamposException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    bundle.getString("errorCodigoNumerico"));
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

                    eliminarAutorView.mostrarInformacion("autorNoEncontrado");

                }

            }
        });

    }

    public void buscarAutorActualizar() {

        try {
            String codigo = actualizarAutorView.getTxtCodigoActulizarAutorView().getText();

            if (codigo.isEmpty()) {
                throw new ValidarCamposException("Campo de codigo vacio");
            }

            int codigo2 = Integer.parseInt(codigo);
            Autor autor = autorDAO.buscar(codigo2);

            if (autor != null) {

                actualizarAutorView.getTxtNombreActualizarAutorView().setText(autor.getNombre());

                actualizarAutorView.getCboNacionalidadesActualizar()
                        .setSelectedItem(autor.getNacionalidad());

            } else {

                actualizarAutorView.mostrarInformacion("autorNoEncontrado");

            }
        } catch (ValidarCamposException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    bundle.getString("errorFormatoCodigo"));

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

        try {

            String codigo = actualizarAutorView.getTxtCodigoActulizarAutorView().getText().trim();
            String nombre = actualizarAutorView.getTxtNombreActualizarAutorView().getText().trim();

            if (nombre.isEmpty() || codigo.isEmpty()) {
                throw new ValidarCamposException("Error - campos vacios");
            }
            int codigo2 = Integer.parseInt(codigo);
            Autor autor = autorDAO.buscar(codigo2);

            if (autor == null) {
                throw new AutorNoEncontradoException("No se encontró el autor");
            }
            int respuesta = JOptionPane.showConfirmDialog(
                    actualizarAutorView,
                    "¿Deseas actualizar el autor?",
                    "Confirmación",
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {

                NacionalidadesAutor nacionalidad = (NacionalidadesAutor) actualizarAutorView.getCboNacionalidadesActualizar().getSelectedItem();

                Autor autorActualizado = new Autor();

                autorActualizado.setCodigo(codigo2);
                autorActualizado.setNombre(nombre);
                autorActualizado.setNacionalidad(nacionalidad);

                autorDAO.actualizar(codigo2, autorActualizado);

                actualizarAutorView.mostrarInformacion("autorActualizado");

            }
        } catch (ValidarCamposException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    bundle.getString("errorFormatoCodigoIncorrecto"));
        } catch (AutorNoEncontradoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
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
        try {
            String codigo = agregarAutorView.getTxtCodigoAgregarAutorView().getText();
            String nombre = agregarAutorView.getTxtNombreAgregarAutorView().getText();

            validarCampos(nombre, codigo);

            NacionalidadesAutor nacionalidad
                    = (NacionalidadesAutor) agregarAutorView
                            .getCboNacionalidadesAgregar()
                            .getSelectedItem();
            int codigo2 = Integer.parseInt(codigo);
            Autor autor = autorDAO.buscar(codigo2);

            if (autor != null) {

                agregarAutorView.mostrarInformacion("autorYaExiste");

            } else {

                Autor nuevoAutor = new Autor(codigo2, nombre, nacionalidad);
                autorDAO.crear(nuevoAutor);

                agregarAutorView.mostrarInformacion("autorAgregado");

            }

        } catch (ValidarCamposException e) {
            JOptionPane.showMessageDialog(agregarAutorView, e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(agregarAutorView, "El codigo debe ser numerico");
        }
    }

    public void validarCampos(String nombre, String codigo) throws ValidarCamposException {
        if (codigo.isEmpty() || nombre.isEmpty()) {
            throw new ValidarCamposException("No pueden existir campos vacios");
        }
        try {
            Integer.parseInt(codigo);
        } catch (NumberFormatException e) {
            throw new ValidarCamposException("El codigo debe ser entero");
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
