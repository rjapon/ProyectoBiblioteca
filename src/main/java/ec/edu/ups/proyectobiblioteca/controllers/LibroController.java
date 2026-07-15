package ec.edu.ups.proyectobiblioteca.controllers;

import ec.edu.ups.proyectobiblioteca.dao.AutorDAO;
import ec.edu.ups.proyectobiblioteca.dao.LibroDAO;
import ec.edu.ups.proyectobiblioteca.enums.CategoriasLibro;
import ec.edu.ups.proyectobiblioteca.exceptions.AutorNoEncontradoException;
import ec.edu.ups.proyectobiblioteca.exceptions.ValidarCamposException;
import ec.edu.ups.proyectobiblioteca.models.Autor;
import ec.edu.ups.proyectobiblioteca.models.Libro;
import ec.edu.ups.proyectobiblioteca.views.ActualizarLibroView;
import ec.edu.ups.proyectobiblioteca.views.AgregarLibroView;
import ec.edu.ups.proyectobiblioteca.views.BuscarLibroView;
import ec.edu.ups.proyectobiblioteca.views.EliminarLibroView;
import ec.edu.ups.proyectobiblioteca.views.ListarLibroView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class LibroController {

    private AgregarLibroView agregarLibroView;
    private ActualizarLibroView actualizarLibroView;
    private BuscarLibroView buscarLibroView;
    private EliminarLibroView eliminarLibroView;
    private ListarLibroView listarLibroView;
    private CategoriasLibro categorias;

    private LibroDAO libroDAO;
    private AutorDAO autorDAO;

    private ResourceBundle bundle;

    public LibroController(
            AgregarLibroView agregarLibroView, ActualizarLibroView actualizarLibroView, BuscarLibroView buscarLibroView, EliminarLibroView eliminarLibroView, ListarLibroView listarLibroView, LibroDAO libroDAO, AutorDAO autorDAO) {

        this.agregarLibroView = agregarLibroView;
        this.actualizarLibroView = actualizarLibroView;
        this.buscarLibroView = buscarLibroView;
        this.eliminarLibroView = eliminarLibroView;
        this.listarLibroView = listarLibroView;
        this.libroDAO = libroDAO;
        this.autorDAO = autorDAO;

        configurarEventosAgregarLibro();
        configurarVentanaAgregarLibro();
        configurarEventosBuscarLibro();
        configurarEventosEliminarLibro();
        configurarEventosBuscarEliminarLibro();
        configurarEventosListarLibros();
        configurarEventosBuscarActualizarLibro();
        configurarEventosActualizarLibro();
        configurarVentanaActualizarLibro();
    }

    public void cambiarIdioma(Locale locale) {
        bundle = ResourceBundle.getBundle(
                "ec.edu.ups.proyectobiblioteca.i18n.mensajes",
                locale);
    }

    public void agregarLibro() {
        ///Pendiente

       try {
            String isbn = agregarLibroView.getTxtISBNAgregar().getText();
            String titulo = agregarLibroView.getTxtTituloAgregar().getText();

            String editorial = agregarLibroView.getTxtEditorialAgregar().getText();

            if (isbn.isEmpty() || titulo.isEmpty() || editorial.isEmpty()) {
                throw new ValidarCamposException(bundle.getString("errorCamposVacios"));
            }
            Libro libro = libroDAO.buscar(isbn);

            if (libro != null) {

                agregarLibroView.mostrarInformacion("libroYaExiste");

            } else {

                CategoriasLibro categoria = (CategoriasLibro) agregarLibroView.getCboCategoriaAgregar().getSelectedItem();

                if (agregarLibroView.getCboAutorAgregar().getItemCount() == 0) {
                    throw new ValidarCamposException(bundle.getString("errorAutorNoRegistrado"));
                }
                String nombreAutor = agregarLibroView.getCboAutorAgregar().getSelectedItem().toString();

                Autor autor = autorDAO.buscarPorNombre(nombreAutor);

                int dia = Integer.parseInt(agregarLibroView.getComboBoxDia().getSelectedItem().toString());
                int mes = Integer.parseInt(agregarLibroView.getComboBoxMes().getSelectedItem().toString());
                int anio = Integer.parseInt(agregarLibroView.getComboBoxAnio().getSelectedItem().toString());

                LocalDate fechaPublicacion = LocalDate.of(anio, mes, dia);

                Libro nuevoLibro = new Libro();

                nuevoLibro.setISBN(isbn);
                nuevoLibro.setTitulo(titulo);
                nuevoLibro.setEditorial(editorial);
                nuevoLibro.setCategoria(categoria);
                nuevoLibro.setDisponible(true);
                nuevoLibro.setAutor(autor);
                nuevoLibro.setFechaPublicacion(fechaPublicacion);

                libroDAO.crear(nuevoLibro);

                agregarLibroView.mostrarInformacion("libroAgregado");
            }
        } catch (ValidarCamposException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }

    public void configurarEventosAgregarLibro() {

        agregarLibroView.getBtnAceptar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                agregarLibro();

            }
        });

    }

    public void validarCampos(String isbn, String titulo, String editorial) throws ValidarCamposException {
        try {
            if (isbn.isEmpty() || titulo.isEmpty() || editorial.isEmpty()) {
                throw new ValidarCamposException(bundle.getString("errorCamposVacios"));
            }

        } catch (ValidarCamposException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }

    public void cargarAutoresCombo() {

        agregarLibroView.getCboAutorAgregar().removeAllItems();

        for (Autor autor : autorDAO.listar()) {

            agregarLibroView.getCboAutorAgregar()
                    .addItem(autor.getNombre());

        }

    }

    public void cargarCategoriasCombo() {

        DefaultComboBoxModel<CategoriasLibro> modelo = new DefaultComboBoxModel<>();

        for (CategoriasLibro categoria : CategoriasLibro.values()) {
            modelo.addElement(categoria);
        }

        agregarLibroView.getCboCategoriaAgregar().setModel(modelo);

    }

    public void configurarVentanaAgregarLibro() {

        agregarLibroView.addInternalFrameListener(new InternalFrameAdapter() {

            @Override
            public void internalFrameActivated(InternalFrameEvent e) {

                cargarAutoresCombo();
                cargarCategoriasCombo();

            }

        });

    }

    public void buscarLibro() {

        try {
            String isbn = buscarLibroView.getTxtISBNBuscar().getText().trim();

            if (isbn.isEmpty()) {
                throw new ValidarCamposException(bundle.getString("errorCampoVacio"));
            }

            Libro libro = libroDAO.buscar(isbn);

            if (libro != null) {

                buscarLibroView.getTxtTituloBuscar().setText(libro.getTitulo());

                buscarLibroView.getTxtAutorBuscar().setText(libro.getAutor().getNombre());

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                buscarLibroView.getTxtFechaBuscar().setText(libro.getFechaPublicacion().format(formatter));

                buscarLibroView.getTxtCategoriaBuscar().setText(libro.getCategoria().toString());

                buscarLibroView.getTxtEditorialBuscar().setText(libro.getEditorial());

                buscarLibroView.getTxtEstadoBuscar().setText(libro.isDisponible() ? bundle.getString("disponible") : bundle.getString("prestado"));

            } else {

                buscarLibroView.mostrarInformacion("libroNoEncontrado");

            }
        } catch (ValidarCamposException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void configurarEventosBuscarLibro() {

        buscarLibroView.getBtnBuscar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                buscarLibro();

            }

        });

    }

    public void eliminarLibro() {

        try {
            String isbn = eliminarLibroView.getTxtISBNEliminar().getText().trim();

            if (isbn.isEmpty()) {
                throw new ValidarCamposException(bundle.getString("errorCampoVacio"));
            }
            Libro libro = libroDAO.buscar(isbn);

            if (libro != null) {

                int respuesta = JOptionPane.showConfirmDialog(
                        eliminarLibroView,
                        bundle.getString("confirmarEliminarLibro"),
                        bundle.getString("tituloConfirmacion"),
                        JOptionPane.YES_NO_OPTION);

                if (respuesta == JOptionPane.YES_OPTION) {

                    libroDAO.eliminar(isbn);

                    eliminarLibroView.mostrarInformacion("libroEliminado");

                    eliminarLibroView.getTxtISBNEliminar().setText("");
                    eliminarLibroView.getTxtTituloEliminar().setText("");
                    eliminarLibroView.getTxtAutorEliminar().setText("");
                    eliminarLibroView.getTxtCategoriaEliminar().setText("");
                    eliminarLibroView.getTxtEditorialEliminar().setText("");
                    eliminarLibroView.getTxtFechaEliminar().setText("");
                }

            } else {
                eliminarLibroView.mostrarInformacion("libroNoEncontrado");
            }
        } catch (ValidarCamposException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void configurarEventosEliminarLibro() {

        eliminarLibroView.getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarLibro();
            }
        });

    }

    public void configurarEventosBuscarEliminarLibro() {

        eliminarLibroView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String isbn = eliminarLibroView.getTxtISBNEliminar().getText();

                if (isbn.isEmpty()) {
                    eliminarLibroView.mostrarInformacion("ingreseISBN");
                    return;
                }

                Libro libro = libroDAO.buscar(isbn);

                if (libro != null) {

                    eliminarLibroView.getTxtTituloEliminar()
                            .setText(libro.getTitulo());

                    eliminarLibroView.getTxtAutorEliminar()
                            .setText(libro.getAutor().getNombre());

                    eliminarLibroView.getTxtCategoriaEliminar()
                            .setText(libro.getCategoria().toString());

                    eliminarLibroView.getTxtEditorialEliminar()
                            .setText(libro.getEditorial());

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                    eliminarLibroView.getTxtFechaEliminar()
                            .setText(libro.getFechaPublicacion().format(formatter));

                } else {

                    eliminarLibroView.mostrarInformacion("libroNoEncontrado");
                }
            }
        });
    }

    public void listarLibros() {

        List<Libro> libros = libroDAO.listar();

        listarLibroView.cargarDatos(libros);
    }

    public void configurarEventosListarLibros() {
        listarLibroView.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent e) {
                listarLibros();
            }
        });

        listarLibroView.getBtlListar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarLibros();
            }
        });
    }

    public void buscarLibroActualizar() {

        try {
            String isbn = actualizarLibroView.getTxtISBNActualizar().getText().trim();

            if (isbn.isEmpty()) {
                throw new ValidarCamposException(bundle.getString("errorCamposVacios"));
            }
            Libro libro = libroDAO.buscar(isbn);

            if (libro != null) {

                actualizarLibroView.getTxtTituloActualizar()
                        .setText(libro.getTitulo());

                actualizarLibroView.getTxtEditorialActualizar()
                        .setText(libro.getEditorial());

                actualizarLibroView.getCboCategoriaActualizar()
                        .setSelectedItem(libro.getCategoria());

                actualizarLibroView.getCboAutorActualizar()
                        .setSelectedItem(libro.getAutor().getNombre());

                LocalDate fecha = libro.getFechaPublicacion();

                actualizarLibroView.getComboBoxDia()
                        .setSelectedItem(String.valueOf(fecha.getDayOfMonth()));

                actualizarLibroView.getComboBoxMes()
                        .setSelectedItem(String.valueOf(fecha.getMonthValue()));

                actualizarLibroView.getComboBoxAnio()
                        .setSelectedItem(String.valueOf(fecha.getYear()));

            } else {

                actualizarLibroView.mostrarInformacion("libroNoEncontrado");

            }
        } catch (ValidarCamposException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void configurarEventosBuscarActualizarLibro() {

        actualizarLibroView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarLibroActualizar();
            }
        });

    }

    public void actualizarLibro() {

        try {
            String isbn = actualizarLibroView.getTxtISBNActualizar().getText().trim();
            String titulo = actualizarLibroView.getTxtTituloActualizar().getText().trim();
            String editorial = actualizarLibroView.getTxtEditorialActualizar().getText().trim();

            if (isbn.isEmpty() || titulo.isEmpty() || editorial.isEmpty()) {
                throw new ValidarCamposException(bundle.getString("errorCamposVacios"));
            }

            CategoriasLibro categoria = (CategoriasLibro) actualizarLibroView.getCboCategoriaActualizar().getSelectedItem();

            if (actualizarLibroView.getCboAutorActualizar().getItemCount() == 0) {
                throw new ValidarCamposException(bundle.getString("errorAutorNoRegistrado"));
            }
            String nombreAutor = actualizarLibroView.getCboAutorActualizar().getSelectedItem().toString();
            int respuesta = JOptionPane.showConfirmDialog(
                    actualizarLibroView,
                    bundle.getString("confirmarActualizarLibro"),
                    bundle.getString("tituloConfirmacion"),
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {

                Autor autor = autorDAO.buscarPorNombre(nombreAutor);

                int dia = Integer.parseInt(
                        actualizarLibroView.getComboBoxDia().getSelectedItem().toString());

                int mes = Integer.parseInt(
                        actualizarLibroView.getComboBoxMes().getSelectedItem().toString());

                int anio = Integer.parseInt(
                        actualizarLibroView.getComboBoxAnio().getSelectedItem().toString());

                LocalDate fecha = LocalDate.of(anio, mes, dia);

                Libro libroActualizado = new Libro();

                libroActualizado.setISBN(isbn);
                libroActualizado.setTitulo(titulo);
                libroActualizado.setEditorial(editorial);
                libroActualizado.setCategoria(categoria);
                libroActualizado.setAutor(autor);
                libroActualizado.setFechaPublicacion(fecha);

                Libro libroAnterior = libroDAO.buscar(isbn);
                libroActualizado.setDisponible(libroAnterior.isDisponible());

                libroDAO.actualizar(isbn, libroActualizado);

                actualizarLibroView.mostrarInformacion("libroActualizado");
            }
        } catch (ValidarCamposException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }

    public void configurarEventosActualizarLibro() {

        actualizarLibroView.getBtnActualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarLibro();
            }
        });

    }

    public void cargarAutoresComboActualizar() {

        actualizarLibroView.getCboAutorActualizar().removeAllItems();

        for (Autor autor : autorDAO.listar()) {
            actualizarLibroView.getCboAutorActualizar().addItem(autor.getNombre());
        }
    }

    public void cargarCategoriasComboActualizar() {

        DefaultComboBoxModel<CategoriasLibro> modelo
                = new DefaultComboBoxModel<>();

        for (CategoriasLibro categoria : CategoriasLibro.values()) {
            modelo.addElement(categoria);
        }

        actualizarLibroView
                .getCboCategoriaActualizar()
                .setModel(modelo);
    }

    public void configurarVentanaActualizarLibro() {

        actualizarLibroView.addInternalFrameListener(new InternalFrameAdapter() {

            @Override
            public void internalFrameActivated(InternalFrameEvent e) {

                cargarAutoresComboActualizar();
                cargarCategoriasComboActualizar();

            }

        });

    }

}
