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
import java.text.ParseException;
import java.util.List;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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

        configurarEventosCrearPrestamo();
        configurarEventosBuscarPrestamo();
        configurarEventosEliminarPrestamo();
        configurarEventosActualizarPrestamo();
        configurarEventosListarPrestamos();
    }

    // Crear Prestamo
    public void crearPrestamo() {

        if (crearPrestamoView.getTxtCodigoCrear().getText().trim().isEmpty()
                || crearPrestamoView.getTxtISBNCrear().getText().trim().isEmpty()
                || crearPrestamoView.getTxtCedulaCrear().getText().trim().isEmpty()
                || crearPrestamoView.getTxtFechaCrear().getText().trim().isEmpty()
                || crearPrestamoView.getTxtFechaDevCrear().getText().trim().isEmpty()) {

            crearPrestamoView.mostrarInformacion("Complete todos los campos.");
            return;
        }

        try {

            int codigo = Integer.parseInt(crearPrestamoView.getTxtCodigoCrear().getText());
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

            Date fechaPrestamo = formato.parse(crearPrestamoView.getTxtFechaCrear().getText());
            Date fechaDevolucion = formato.parse(crearPrestamoView.getTxtFechaDevCrear().getText());

            String cedula = crearPrestamoView.getTxtCedulaCrear().getText();
            String isbn = crearPrestamoView.getTxtISBNCrear().getText();

            Usuario usuario = usuarioDAO.buscar(cedula);
            Libro libro = libroDAO.buscar(isbn);

            if (usuario == null) {
                crearPrestamoView.mostrarInformacion("Usuario no encontrado.");
                return;
            }

            if (libro == null) {
                crearPrestamoView.mostrarInformacion("Libro no encontrado.");
                return;
            }

            if (!libro.isDisponible()) {
                crearPrestamoView.mostrarInformacion("El libro no está disponible.");
                return;
            }

            Prestamo prestamo = new Prestamo(codigo, fechaPrestamo, fechaDevolucion, "Prestado", libro, usuario);

            prestamoDAO.crear(prestamo);

            libro.setDisponible(false);

            crearPrestamoView.mostrarInformacion("Préstamo creado exitosamente.");

        } catch (Exception e) {

            crearPrestamoView.mostrarInformacion("Error al ingresar los datos.");

        }

    }

    public void buscarUsuario() {

        String cedula = crearPrestamoView.getTxtCedulaCrear().getText();

        Usuario usuario = usuarioDAO.buscar(cedula);

        if (usuario != null) {

            crearPrestamoView.getTxtUsuarioCrear().setText(usuario.getNombre());

        } else {

            crearPrestamoView.getTxtUsuarioCrear().setText("");
            crearPrestamoView.mostrarInformacion("Usuario no encontrado.");

        }
    }

    public void buscarLibro() {

        String isbn = crearPrestamoView.getTxtISBNCrear().getText();

        Libro libro = libroDAO.buscar(isbn);

        if (libro != null) {

            crearPrestamoView.getTxtLibroCrear().setText(libro.getTitulo());
            crearPrestamoView.getTxtAutorCrear().setText(libro.getAutor().getNombre());

            if (libro.isDisponible()) {
                crearPrestamoView.getTxtDisponibleCrear().setText("Sí");
            } else {
                crearPrestamoView.getTxtDisponibleCrear().setText("No");
            }

        } else {

            crearPrestamoView.getTxtLibroCrear().setText("");
            crearPrestamoView.getTxtAutorCrear().setText("");
            crearPrestamoView.getTxtDisponibleCrear().setText("");

            crearPrestamoView.mostrarInformacion("Libro no encontrado.");

        }
    }

    private void configurarEventosCrearPrestamo() {

        crearPrestamoView.getBtnBuscarUsuario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarUsuario();
            }
        });

        crearPrestamoView.getBtnBuscarLibro().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarLibro();
            }
        });

        crearPrestamoView.getBtnAceptar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearPrestamo();
            }
        });

    }

    //Buscar Prestamo
    public void buscarPrestamo() {

        if (buscarPrestamoView.getTxtCodigoBuscar().getText().trim().isEmpty()) {
            buscarPrestamoView.mostrarInformacion("Ingrese el código.");
            return;
        }

        try {

            int codigo = Integer.parseInt(buscarPrestamoView.getTxtCodigoBuscar().getText());

            Prestamo prestamo = prestamoDAO.buscar(codigo);

            if (prestamo != null) {

                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

                buscarPrestamoView.getTxtUsuarioBuscar().setText(prestamo.getUsuario().getNombre());
                buscarPrestamoView.getTxtCedulaBuscar().setText(prestamo.getUsuario().getCedula());

                buscarPrestamoView.getTxtLibroBuscar().setText(prestamo.getLibro().getTitulo());
                buscarPrestamoView.getTxtAutorBuscar().setText(prestamo.getLibro().getAutor().getNombre());
                buscarPrestamoView.getTxtISBNBuscar().setText(prestamo.getLibro().getISBN());

                buscarPrestamoView.getTxtFechaBuscar().setText(formato.format(prestamo.getFechaPrestamo()));
                buscarPrestamoView.getTxtFechaDevBuscar().setText(formato.format(prestamo.getFechaDevolucion()));

                buscarPrestamoView.getTxtEstadoBuscar().setText(prestamo.getEstado());

            } else {

                buscarPrestamoView.mostrarInformacion("Préstamo no encontrado.");

            }

        } catch (NumberFormatException e) {
            buscarPrestamoView.mostrarInformacion("El código debe ser un número.");
        }
    }

    private void configurarEventosBuscarPrestamo() {

        buscarPrestamoView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPrestamo();
            }
        });

    }

    // Eliminar Prestamo
    public void eliminarPrestamo() {

        if (eliminarPrestamoView.getTxtCodigoEliminar().getText().trim().isEmpty()) {
            eliminarPrestamoView.mostrarInformacion("Ingrese el código.");
            return;
        }

        try {

            int codigo = Integer.parseInt(
                    eliminarPrestamoView.getTxtCodigoEliminar().getText());

            Prestamo prestamo = prestamoDAO.buscar(codigo);

            if (prestamo != null) {

                int opcion = JOptionPane.showConfirmDialog(
                        eliminarPrestamoView,
                        "¿Está seguro de eliminar el préstamo?",
                        "Confirmar eliminación",
                        JOptionPane.YES_NO_OPTION);

                if (opcion == JOptionPane.YES_OPTION) {

                    Libro libro = prestamo.getLibro();
                    libro.setDisponible(true);
                    libroDAO.actualizar(libro.getISBN(), libro);

                    prestamoDAO.eliminar(codigo);

                    eliminarPrestamoView.mostrarInformacion(
                            "Préstamo eliminado correctamente.");
                }

            } else {

                eliminarPrestamoView.mostrarInformacion(
                        "Préstamo no encontrado.");
            }

        } catch (NumberFormatException e) {

            eliminarPrestamoView.mostrarInformacion(
                    "El código debe ser un número.");

        }
    }

    public void buscarPrestamoEliminar() {

        if (eliminarPrestamoView.getTxtCodigoEliminar().getText().trim().isEmpty()) {
            eliminarPrestamoView.mostrarInformacion("Ingrese el código.");
            return;
        }

        try {

            int codigo = Integer.parseInt(
                    eliminarPrestamoView.getTxtCodigoEliminar().getText());

            Prestamo prestamo = prestamoDAO.buscar(codigo);

            if (prestamo != null) {

                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

                eliminarPrestamoView.getTxtUsuarioEliminar().setText(
                        prestamo.getUsuario().getNombre());

                eliminarPrestamoView.getTxtFechaEliminar().setText(
                        formato.format(prestamo.getFechaPrestamo()));

                eliminarPrestamoView.getTxtLibroEliminar().setText(
                        prestamo.getLibro().getTitulo());

                eliminarPrestamoView.getTxtAutorEliminar().setText(
                        prestamo.getLibro().getAutor().getNombre());

                eliminarPrestamoView.getTxtISBNEliminar().setText(
                        prestamo.getLibro().getISBN());

            } else {

                eliminarPrestamoView.mostrarInformacion(
                        "Préstamo no encontrado.");

            }

        } catch (NumberFormatException e) {

            eliminarPrestamoView.mostrarInformacion(
                    "El código debe ser un número.");

        }
    }

    private void configurarEventosEliminarPrestamo() {

        eliminarPrestamoView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPrestamoEliminar();
            }
        });

        eliminarPrestamoView.getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarPrestamo();
            }
        });

    }

    //Actualizar Prestamo
    public void actualizarPrestamo() {

        if (actualizarPrestamoView.getTxtCodigoActualizar().getText().trim().isEmpty() || actualizarPrestamoView.getTxtFechaDevActualizar().getText().trim().isEmpty()) {
            actualizarPrestamoView.mostrarInformacion("Complete todos los campos.");
            return;
        }

        try {

            int codigo = Integer.parseInt(
                    actualizarPrestamoView.getTxtCodigoActualizar().getText());

            Prestamo prestamo = prestamoDAO.buscar(codigo);

            if (prestamo != null) {

                try {

                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

                    Date nuevaFechaDevolucion = formato.parse(
                            actualizarPrestamoView.getTxtFechaDevActualizar().getText());

                    prestamo.setFechaDevolucion(nuevaFechaDevolucion);

                    prestamoDAO.actualizar(codigo, prestamo);

                    actualizarPrestamoView.mostrarInformacion(
                            "Préstamo actualizado correctamente.");

                } catch (ParseException e) {

                    actualizarPrestamoView.mostrarInformacion(
                            "Formato de fecha inválido. Use dd/MM/yyyy.");

                }

            } else {

                actualizarPrestamoView.mostrarInformacion(
                        "Préstamo no encontrado.");

            }

        } catch (NumberFormatException e) {

            actualizarPrestamoView.mostrarInformacion(
                    "El código debe ser un número.");

        }
    }

    public void buscarPrestamoActualizar() {

        if (actualizarPrestamoView.getTxtCodigoActualizar().getText().trim().isEmpty()) {
            actualizarPrestamoView.mostrarInformacion("Ingrese el código.");
            return;
        }

        int codigo = Integer.parseInt(
                actualizarPrestamoView.getTxtCodigoActualizar().getText());

        Prestamo prestamo = prestamoDAO.buscar(codigo);

        if (prestamo != null) {

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

            actualizarPrestamoView.getTxtUsuarioActualizar().setText(prestamo.getUsuario().getNombre());
            actualizarPrestamoView.getTxtFechaActualizar().setText(formato.format(prestamo.getFechaPrestamo()));
            actualizarPrestamoView.getTxtLibroActualizar().setText(prestamo.getLibro().getTitulo());
            actualizarPrestamoView.getTxtAutorActualizar().setText(prestamo.getLibro().getAutor().getNombre());
            actualizarPrestamoView.getTxtISBNActualizar().setText(prestamo.getLibro().getISBN());

        } else {

            actualizarPrestamoView.mostrarInformacion("Préstamo no encontrado.");

        }
    }

    private void configurarEventosActualizarPrestamo() {

        actualizarPrestamoView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPrestamoActualizar();
            }
        });

        actualizarPrestamoView.getBtnAceptar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarPrestamo();
            }
        });
    }

    // Listar Prestamo
    public void listarPrestamos() {

        List<Prestamo> lista = prestamoDAO.listar();

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Código");
        modelo.addColumn("Libro");
        modelo.addColumn("Usuario");
        modelo.addColumn("Fecha Préstamo");

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        for (Prestamo p : lista) {

            modelo.addRow(new Object[]{
                p.getCodigo(),
                p.getLibro().getTitulo(),
                p.getUsuario().getNombre(),
                formato.format(p.getFechaPrestamo())
            });
        }
        listarPrestamoView.getTblPrestamos().setModel(modelo);
    }

    private void configurarEventosListarPrestamos() {

        listarPrestamoView.getBtnListar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarPrestamos();
            }
        });
    }
}
