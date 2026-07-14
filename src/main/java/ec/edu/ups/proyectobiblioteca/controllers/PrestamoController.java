package ec.edu.ups.proyectobiblioteca.controllers;

import ec.edu.ups.proyectobiblioteca.dao.LibroDAO;
import ec.edu.ups.proyectobiblioteca.dao.PrestamoDAO;
import ec.edu.ups.proyectobiblioteca.dao.UsuarioDAO;
import ec.edu.ups.proyectobiblioteca.models.Libro;
import ec.edu.ups.proyectobiblioteca.models.Prestamo;
import ec.edu.ups.proyectobiblioteca.models.Usuario;
import ec.edu.ups.proyectobiblioteca.views.ActualizarPrestamoView;
import ec.edu.ups.proyectobiblioteca.views.BuscarPrestamoView;
import ec.edu.ups.proyectobiblioteca.views.CrearPrestamoView;
import ec.edu.ups.proyectobiblioteca.views.EliminarPrestamoView;
import ec.edu.ups.proyectobiblioteca.views.ListarPrestamoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class PrestamoController {

    private PrestamoDAO prestamoDAO;
    private LibroDAO libroDAO;
    private UsuarioDAO usuarioDAO;

    private CrearPrestamoView crearPrestamoView;
    private ActualizarPrestamoView actualizarPrestamoView;
    private EliminarPrestamoView eliminarPrestamoView;
    private BuscarPrestamoView buscarPrestamoView;
    private ListarPrestamoView listarPrestamoView;

    public PrestamoController(PrestamoDAO prestamoDAO, LibroDAO libroDAO, UsuarioDAO usuarioDAO, CrearPrestamoView crearPrestamoView, ActualizarPrestamoView actualizarPrestamoView, EliminarPrestamoView eliminarPrestamoView, BuscarPrestamoView buscarPrestamoView, ListarPrestamoView listarPrestamoView) {

        this.prestamoDAO = prestamoDAO;
        this.libroDAO = libroDAO;
        this.usuarioDAO = usuarioDAO;

        this.crearPrestamoView = crearPrestamoView;
        this.actualizarPrestamoView = actualizarPrestamoView;
        this.eliminarPrestamoView = eliminarPrestamoView;
        this.buscarPrestamoView = buscarPrestamoView;
        this.listarPrestamoView = listarPrestamoView;

        mostrarFechaActual();

        configurarEventosCrearPrestamo();
        configurarEventosBuscarPrestamo();
        configurarEventosBuscarEliminarPrestamo();
        configurarEventosEliminarPrestamo();
        configurarEventosActualizarPrestamo();
        configurarEventosListarPrestamos();
        configurarEventosBuscarLibro();
        configurarEventosBuscarUsuario();

    }

    public void crearPrestamo() {

        int codigo = Integer.parseInt(
                crearPrestamoView.getTxtCodigoCrear().getText());

        Prestamo prestamoExistente = prestamoDAO.buscar(codigo);

        if (prestamoExistente != null) {

            crearPrestamoView.mostrarInformacion(
                    "Ya existe un préstamo con ese código");
            return;
        }

        String cedula = crearPrestamoView
                .getTxtCedulaCrear().getText();

        Usuario usuario = usuarioDAO.buscar(cedula);

        if (usuario == null) {

            crearPrestamoView.mostrarInformacion(
                    "No existe el usuario");
            return;
        }

        String isbn = crearPrestamoView
                .getTxtISBNCrear().getText();

        Libro libro = libroDAO.buscar(isbn);

        if (libro == null) {

            crearPrestamoView.mostrarInformacion(
                    "No existe el libro");
            return;
        }

        if (!libro.isDisponible()) {

            crearPrestamoView.mostrarInformacion(
                    "El libro no está disponible");
            return;
        }

        LocalDate fechaPrestamo = LocalDate.now();

        int dia = Integer.parseInt(
                crearPrestamoView.getComboBoxDiaDevolucion()
                        .getSelectedItem().toString());

        int mes = Integer.parseInt(
                crearPrestamoView.getComboBoxMesDevolucion()
                        .getSelectedItem().toString());

        int anio = Integer.parseInt(
                crearPrestamoView.getComboBoxAnioDevolucion()
                        .getSelectedItem().toString());

        LocalDate fechaDevolucion
                = LocalDate.of(anio, mes, dia);

        Prestamo prestamo = new Prestamo();

        prestamo.setCodigo(codigo);
        prestamo.setFechaPrestamo(fechaPrestamo);
        prestamo.setFechaDevolucion(fechaDevolucion);
        prestamo.setUsuario(usuario);
        prestamo.setLibro(libro);

        prestamoDAO.crear(prestamo);
        libroDAO.cambiarDisponibilidad(isbn, false);

        crearPrestamoView.mostrarInformacion(
                "Préstamo creado correctamente");
    }

    public void configurarEventosCrearPrestamo() {

        crearPrestamoView.getBtnAceptar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearPrestamo();
            }
        });

    }

    public void configurarEventosBuscarUsuario() {

        crearPrestamoView.getBtnBuscarUsuario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String cedula
                        = crearPrestamoView.getTxtCedulaCrear().getText();

                Usuario usuario = usuarioDAO.buscar(cedula);

                if (usuario != null) {

                    crearPrestamoView.getTxtUsuarioCrear()
                            .setText(usuario.getNombre());

                } else {

                    crearPrestamoView.mostrarInformacion(
                            "Usuario no encontrado");
                }

            }
        });

    }

    public void configurarEventosBuscarLibro() {

        crearPrestamoView.getBtnBuscarLibro().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String isbn
                        = crearPrestamoView.getTxtISBNCrear().getText();

                Libro libro = libroDAO.buscar(isbn);

                if (libro != null) {

                    crearPrestamoView.getTxtLibroCrear()
                            .setText(libro.getTitulo());

                    crearPrestamoView.getTxtAutorCrear()
                            .setText(libro.getAutor().getNombre());

                    crearPrestamoView.getTxtDisponibleCrear()
                            .setText(libro.isDisponible()
                                    ? "Sí"
                                    : "No");

                } else {

                    crearPrestamoView.mostrarInformacion(
                            "Libro no encontrado");
                }

            }
        });

    }

    public void mostrarFechaActual() {

        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        crearPrestamoView.getTxtFechaCrear().setEditable(false);

        crearPrestamoView.getTxtFechaCrear().setText(
                LocalDate.now().format(formatter));
    }

    public void buscarPrestamo() {

        int codigo = Integer.parseInt(
                buscarPrestamoView.getTxtCodigoBuscar().getText());

        Prestamo prestamo = prestamoDAO.buscar(codigo);

        if (prestamo != null) {

            DateTimeFormatter formatter
                    = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            buscarPrestamoView.getTxtUsuarioBuscar()
                    .setText(prestamo.getUsuario().getNombre());

            buscarPrestamoView.getTxtCedulaBuscar()
                    .setText(prestamo.getUsuario().getCedula());

            buscarPrestamoView.getTxtLibroBuscar()
                    .setText(prestamo.getLibro().getTitulo());

            buscarPrestamoView.getTxtAutorBuscar()
                    .setText(prestamo.getLibro().getAutor().getNombre());

            buscarPrestamoView.getTxtISBNBuscar()
                    .setText(prestamo.getLibro().getISBN());

            buscarPrestamoView.getTxtFechaBuscar()
                    .setText(prestamo.getFechaPrestamo().format(formatter));

            buscarPrestamoView.getTxtFechaDevBuscar()
                    .setText(prestamo.getFechaDevolucion().format(formatter));

            buscarPrestamoView.getTxtEstadoBuscar()
                    .setText(prestamo.getLibro().isDisponible()
                            ? "Disponible"
                            : "Prestado");

        } else {

            buscarPrestamoView.mostrarInformacion(
                    "No se encontró el préstamo");
        }

    }

    public void configurarEventosBuscarPrestamo() {

        buscarPrestamoView.getBtnBuscar().addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                buscarPrestamo();

            }

        });

    }

    public void buscarPrestamoEliminar() {

        int codigo = Integer.parseInt(
                eliminarPrestamoView.getTxtCodigoEliminar().getText());

        Prestamo prestamo = prestamoDAO.buscar(codigo);

        if (prestamo != null) {

            eliminarPrestamoView.getTxtUsuarioEliminar()
                    .setText(prestamo.getUsuario().getNombre());

            DateTimeFormatter formatter
                    = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            eliminarPrestamoView.getTxtFechaEliminar()
                    .setText(prestamo.getFechaPrestamo().format(formatter));

            eliminarPrestamoView.getTxtLibroEliminar()
                    .setText(prestamo.getLibro().getTitulo());

            eliminarPrestamoView.getTxtAutorEliminar()
                    .setText(prestamo.getLibro().getAutor().getNombre());

            eliminarPrestamoView.getTxtISBNEliminar()
                    .setText(prestamo.getLibro().getISBN());

        } else {

            eliminarPrestamoView.mostrarInformacion(
                    "No se encontró el préstamo");
        }
    }

    public void eliminarPrestamo() {

        int codigo = Integer.parseInt(
                eliminarPrestamoView.getTxtCodigoEliminar().getText());

        Prestamo prestamo = prestamoDAO.buscar(codigo);

        if (prestamo != null) {

            int respuesta = JOptionPane.showConfirmDialog(
                    eliminarPrestamoView,
                    "¿Deseas eliminar el préstamo?",
                    "Confirmación",
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {

                libroDAO.cambiarDisponibilidad(prestamo.getLibro().getISBN(),true);

                prestamoDAO.eliminar(codigo);

                eliminarPrestamoView.mostrarInformacion(
                        "Préstamo eliminado correctamente");

                eliminarPrestamoView.getTxtCodigoEliminar().setText("");
                eliminarPrestamoView.getTxtUsuarioEliminar().setText("");
                eliminarPrestamoView.getTxtFechaEliminar().setText("");
                eliminarPrestamoView.getTxtLibroEliminar().setText("");
                eliminarPrestamoView.getTxtAutorEliminar().setText("");
                eliminarPrestamoView.getTxtISBNEliminar().setText("");
            }

        } else {

            eliminarPrestamoView.mostrarInformacion(
                    "No existe el préstamo");
        }
    }

    public void configurarEventosBuscarEliminarPrestamo() {

        eliminarPrestamoView.getBtnBuscar().addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                buscarPrestamoEliminar();

            }
        });

    }

    public void configurarEventosEliminarPrestamo() {

        eliminarPrestamoView.getBtnEliminar().addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                eliminarPrestamo();

            }
        });

    }

    public void buscarPrestamoActualizar() {

        int codigo = Integer.parseInt(
                actualizarPrestamoView.getTxtCodigoActualizar().getText());

        Prestamo prestamo = prestamoDAO.buscar(codigo);

        if (prestamo != null) {

            DateTimeFormatter formatter
                    = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            actualizarPrestamoView.getTxtUsuarioActualizar()
                    .setText(prestamo.getUsuario().getNombre());

            actualizarPrestamoView.getTxtLibroActualizar()
                    .setText(prestamo.getLibro().getTitulo());

            actualizarPrestamoView.getTxtISBNActualizar()
                    .setText(prestamo.getLibro().getISBN());

            actualizarPrestamoView.getTxtAutorActualizar()
                    .setText(prestamo.getLibro().getAutor().getNombre());

            actualizarPrestamoView.getTxtFechaActualizar()
                    .setText(prestamo.getFechaPrestamo().format(formatter));

            LocalDate fecha = prestamo.getFechaDevolucion();

            actualizarPrestamoView.getComboBoxDiaDevolucion()
                    .setSelectedItem(String.valueOf(fecha.getDayOfMonth()));

            actualizarPrestamoView.getComboBoxMesDevolucion()
                    .setSelectedItem(String.valueOf(fecha.getMonthValue()));

            actualizarPrestamoView.getComboBoxAnioDevolucion()
                    .setSelectedItem(String.valueOf(fecha.getYear()));

        } else {

            actualizarPrestamoView.mostrarInformacion(
                    "No se encontró el préstamo");
        }
    }

    public void actualizarPrestamo() {

        int codigo = Integer.parseInt(
                actualizarPrestamoView.getTxtCodigoActualizar().getText());

        Prestamo prestamo = prestamoDAO.buscar(codigo);

        if (prestamo != null) {

            int dia = Integer.parseInt(
                    actualizarPrestamoView.getComboBoxDiaDevolucion()
                            .getSelectedItem().toString());

            int mes = Integer.parseInt(
                    actualizarPrestamoView.getComboBoxMesDevolucion()
                            .getSelectedItem().toString());

            int anio = Integer.parseInt(
                    actualizarPrestamoView.getComboBoxAnioDevolucion()
                            .getSelectedItem().toString());

            LocalDate fechaDevolucion = LocalDate.of(anio, mes, dia);

            prestamo.setFechaDevolucion(fechaDevolucion);

            prestamoDAO.actualizar(codigo, prestamo);

            actualizarPrestamoView.mostrarInformacion(
                    "Préstamo actualizado correctamente");

        } else {

            actualizarPrestamoView.mostrarInformacion(
                    "No existe el préstamo");
        }
    }

    public void configurarEventosActualizarPrestamo() {

        actualizarPrestamoView.getBtnBuscar().addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                buscarPrestamoActualizar();

            }
        });

        actualizarPrestamoView.getBtnAceptar().addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                actualizarPrestamo();

            }
        });

    }

    public void listarPrestamos() {

        List<Prestamo> prestamos = prestamoDAO.listar();

        listarPrestamoView.cargarDatos(prestamos);

    }

    public void configurarEventosListarPrestamos() {

        listarPrestamoView.getBtnListar().addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                listarPrestamos();

            }

        });

    }

}
