/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ec.edu.ups.proyectobiblioteca.views;

import ec.edu.ups.proyectobiblioteca.controllers.AutorController;
import ec.edu.ups.proyectobiblioteca.controllers.PrestamoController;
import ec.edu.ups.proyectobiblioteca.controllers.UsuarioController;
import ec.edu.ups.proyectobiblioteca.dao.AutorDAO;
import ec.edu.ups.proyectobiblioteca.dao.AutorDAOMemoria;
import ec.edu.ups.proyectobiblioteca.dao.LibroDAO;
import ec.edu.ups.proyectobiblioteca.dao.LibroDAOMemoria;
import ec.edu.ups.proyectobiblioteca.dao.PrestamoDAO;
import ec.edu.ups.proyectobiblioteca.dao.PrestamoDAOMemoria;
import ec.edu.ups.proyectobiblioteca.dao.UsuarioDAO;
import ec.edu.ups.proyectobiblioteca.dao.UsuarioDAOMemoria;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Asus
 */
public class PrincipalView extends javax.swing.JFrame {

    private ActualizarAutorView actualizarAutorView;
    private ActualizarLibroView actualizarLibroView;
    private ActualizarPrestamoView actualizarPrestamoView;
    private ActualizarUsuarioView actualizarUsuarioView;

    private AgregarAutorView agregarAutorView;
    private AgregarLibroView agregarLibroView;

    private BuscarLibroView buscarLibroView;
    private BuscarPrestamoView buscarPrestamoView;
    private BuscarUsuarioView buscarUsuarioView;
    private BuscarAutorView buscarAutorView;
    private CrearPrestamoView crearPrestamoView;
    private CrearUsuarioView crearUsuarioView;

    private EliminarAutorView eliminarAutorView;
    private EliminarLibroView eliminarLibroView;
    private EliminarPrestamoView eliminarPrestamoView;
    private EliminarUsuarioView eliminarUsuarioView;

    private ListarLibroView listarLibroView;
    private ListarUsuarioView listarUsuarioView;
    private ListarPrestamoView listarPrestamoView;
    private ListarLibrosAutorView listarLibrosAutorView;
    private UsuarioDAO usuarioDAO;
    private AutorDAO autorDAO;
    private UsuarioController usuarioController;
    private AutorController autorController;
    private PrestamoController prestamoController;
    private LibroDAO libroDAO;
    private PrestamoDAO prestamoDAO;

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PrincipalView.class.getName());

    /**
     * Creates new form PrincipalVoew
     */
    public PrincipalView() {

        actualizarAutorView = new ActualizarAutorView();
        actualizarLibroView = new ActualizarLibroView();
        actualizarPrestamoView = new ActualizarPrestamoView();
        actualizarUsuarioView = new ActualizarUsuarioView();
        agregarAutorView = new AgregarAutorView();
        agregarLibroView = new AgregarLibroView();
        buscarLibroView = new BuscarLibroView();
        buscarPrestamoView = new BuscarPrestamoView();
        buscarUsuarioView = new BuscarUsuarioView();
        buscarAutorView = new BuscarAutorView();
        crearPrestamoView = new CrearPrestamoView();
        crearUsuarioView = new CrearUsuarioView();
        eliminarAutorView = new EliminarAutorView();
        eliminarLibroView = new EliminarLibroView();
        eliminarPrestamoView = new EliminarPrestamoView();
        eliminarUsuarioView = new EliminarUsuarioView();
        listarLibroView = new ListarLibroView();
        listarUsuarioView = new ListarUsuarioView();
        listarPrestamoView = new ListarPrestamoView();
        listarLibrosAutorView = new ListarLibrosAutorView();

        usuarioDAO = new UsuarioDAOMemoria();
        autorDAO = new AutorDAOMemoria();
        libroDAO = new LibroDAOMemoria();
        prestamoDAO = new PrestamoDAOMemoria();

        usuarioController = new UsuarioController(crearUsuarioView, actualizarUsuarioView, eliminarUsuarioView, buscarUsuarioView, usuarioDAO);
        autorController = new AutorController(actualizarAutorView, agregarAutorView, eliminarAutorView, buscarAutorView, autorDAO);
        prestamoController = new PrestamoController(prestamoDAO, libroDAO, usuarioDAO, crearPrestamoView, actualizarPrestamoView, eliminarPrestamoView, buscarPrestamoView, listarPrestamoView);

        initComponents();
    }

    public void cambiarIdioma(Locale locale) {

        ResourceBundle bundle = ResourceBundle.getBundle("ec.edu.ups.proyectobiblioteca.i18n.mensajes", locale);
        IdiomaMenu.setText(bundle.getString("idiomaMenu"));

        PrestamoMenu.setText(bundle.getString("prestamoMenu"));
        CrearPrestamoMenuItem.setText(bundle.getString("crearMenuItem"));
        BuscarPrestamoMenuItem.setText(bundle.getString("buscarMenuItem"));
        ActualizarPrestamoMenuItem.setText(bundle.getString("actualizarMenuItem"));
        EliminarPrestamoMenuItem.setText(bundle.getString("eliminarMenuItem"));
        ListarPrestamoMenuItem.setText(bundle.getString("listarMenuItem"));

        LibroMenu.setText(bundle.getString("libroMenu"));
        AgregarLibroMenuItem.setText(bundle.getString("agregarMenuItem"));
        EliminarLibroMenuItem.setText(bundle.getString("eliminarMenuItem"));
        BuscarLibroMenuItem.setText(bundle.getString("buscarMenuItem"));
        ActualizarLibroMenuItem.setText(bundle.getString("actualizarMenuItem"));
        ListarLibroMenuItem.setText(bundle.getString("listarMenuItem"));

        AutorMenu.setText(bundle.getString("autorMenu"));
        AgregarAutorMenuItem.setText(bundle.getString("agregarMenuItem"));
        BuscarAutorMenuItem.setText(bundle.getString("buscarMenuItem"));
        EliminarAutorMenuItem.setText(bundle.getString("eliminarMenuItem"));
        ActualizarAutorMenuItem.setText(bundle.getString("actualizarMenuItem"));
        ListarLibroAutorMenuItem.setText(bundle.getString("listarMenuItem"));

        UsuarioMenu.setText(bundle.getString("usuarioMenu"));
        CrearUsuarioMenuItem.setText(bundle.getString("crearMenuItem"));
        BuscarUsuarioMenuItem.setText(bundle.getString("buscarMenuItem"));
        EliminarUsuarioMenuItem.setText(bundle.getString("eliminarMenuItem"));
        ActualizarUsuarioMenuItem.setText(bundle.getString("actualizarMenuItem"));
        ListarUsuarioMenuItem.setText(bundle.getString("listarLibrosMenuItem"));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar2 = new javax.swing.JMenuBar();
        PrestamoMenu = new javax.swing.JMenu();
        CrearPrestamoMenuItem = new javax.swing.JMenuItem();
        BuscarPrestamoMenuItem = new javax.swing.JMenuItem();
        EliminarPrestamoMenuItem = new javax.swing.JMenuItem();
        ActualizarPrestamoMenuItem = new javax.swing.JMenuItem();
        ListarPrestamoMenuItem = new javax.swing.JMenuItem();
        LibroMenu = new javax.swing.JMenu();
        AgregarLibroMenuItem = new javax.swing.JMenuItem();
        EliminarLibroMenuItem = new javax.swing.JMenuItem();
        ActualizarLibroMenuItem = new javax.swing.JMenuItem();
        BuscarLibroMenuItem = new javax.swing.JMenuItem();
        ListarLibroMenuItem = new javax.swing.JMenuItem();
        AutorMenu = new javax.swing.JMenu();
        AgregarAutorMenuItem = new javax.swing.JMenuItem();
        EliminarAutorMenuItem = new javax.swing.JMenuItem();
        ActualizarAutorMenuItem = new javax.swing.JMenuItem();
        ListarLibroAutorMenuItem = new javax.swing.JMenuItem();
        BuscarAutorMenuItem = new javax.swing.JMenuItem();
        UsuarioMenu = new javax.swing.JMenu();
        CrearUsuarioMenuItem = new javax.swing.JMenuItem();
        EliminarUsuarioMenuItem = new javax.swing.JMenuItem();
        ActualizarUsuarioMenuItem = new javax.swing.JMenuItem();
        BuscarUsuarioMenuItem = new javax.swing.JMenuItem();
        ListarUsuarioMenuItem = new javax.swing.JMenuItem();
        IdiomaMenu = new javax.swing.JMenu();
        IdiomaESMenuItem = new javax.swing.JMenuItem();
        IdiomaINMenuItem = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 371, Short.MAX_VALUE)
        );

        PrestamoMenu.setText("Prestamo");

        CrearPrestamoMenuItem.setText("Crear");
        CrearPrestamoMenuItem.addActionListener(this::CrearPrestamoMenuItemActionPerformed);
        PrestamoMenu.add(CrearPrestamoMenuItem);

        BuscarPrestamoMenuItem.setText("Buscar");
        BuscarPrestamoMenuItem.addActionListener(this::BuscarPrestamoMenuItemActionPerformed);
        PrestamoMenu.add(BuscarPrestamoMenuItem);

        EliminarPrestamoMenuItem.setText("Eliminar");
        EliminarPrestamoMenuItem.addActionListener(this::EliminarPrestamoMenuItemActionPerformed);
        PrestamoMenu.add(EliminarPrestamoMenuItem);

        ActualizarPrestamoMenuItem.setText("Actualizar");
        ActualizarPrestamoMenuItem.addActionListener(this::ActualizarPrestamoMenuItemActionPerformed);
        PrestamoMenu.add(ActualizarPrestamoMenuItem);

        ListarPrestamoMenuItem.setText("Listar");
        ListarPrestamoMenuItem.addActionListener(this::ListarPrestamoMenuItemActionPerformed);
        PrestamoMenu.add(ListarPrestamoMenuItem);

        jMenuBar2.add(PrestamoMenu);

        LibroMenu.setText("Libro");

        AgregarLibroMenuItem.setText("Agregar");
        AgregarLibroMenuItem.addActionListener(this::AgregarLibroMenuItemActionPerformed);
        LibroMenu.add(AgregarLibroMenuItem);

        EliminarLibroMenuItem.setText("Eliminar");
        EliminarLibroMenuItem.addActionListener(this::EliminarLibroMenuItemActionPerformed);
        LibroMenu.add(EliminarLibroMenuItem);

        ActualizarLibroMenuItem.setText("Actualizar");
        ActualizarLibroMenuItem.addActionListener(this::ActualizarLibroMenuItemActionPerformed);
        LibroMenu.add(ActualizarLibroMenuItem);

        BuscarLibroMenuItem.setText("Buscar");
        BuscarLibroMenuItem.addActionListener(this::BuscarLibroMenuItemActionPerformed);
        LibroMenu.add(BuscarLibroMenuItem);

        ListarLibroMenuItem.setText("Listar");
        ListarLibroMenuItem.addActionListener(this::ListarLibroMenuItemActionPerformed);
        LibroMenu.add(ListarLibroMenuItem);

        jMenuBar2.add(LibroMenu);

        AutorMenu.setText("Autor");

        AgregarAutorMenuItem.setText("Agregar");
        AgregarAutorMenuItem.addActionListener(this::AgregarAutorMenuItemActionPerformed);
        AutorMenu.add(AgregarAutorMenuItem);

        EliminarAutorMenuItem.setText("Eliminar");
        EliminarAutorMenuItem.addActionListener(this::EliminarAutorMenuItemActionPerformed);
        AutorMenu.add(EliminarAutorMenuItem);

        ActualizarAutorMenuItem.setText("Actualizar");
        ActualizarAutorMenuItem.addActionListener(this::ActualizarAutorMenuItemActionPerformed);
        AutorMenu.add(ActualizarAutorMenuItem);

        ListarLibroAutorMenuItem.setText("Listar Libros");
        ListarLibroAutorMenuItem.addActionListener(this::ListarLibroAutorMenuItemActionPerformed);
        AutorMenu.add(ListarLibroAutorMenuItem);

        BuscarAutorMenuItem.setText("Buscar");
        BuscarAutorMenuItem.addActionListener(this::BuscarAutorMenuItemActionPerformed);
        AutorMenu.add(BuscarAutorMenuItem);

        jMenuBar2.add(AutorMenu);

        UsuarioMenu.setText("Usuarios");

        CrearUsuarioMenuItem.setText("Crear");
        CrearUsuarioMenuItem.addActionListener(this::CrearUsuarioMenuItemActionPerformed);
        UsuarioMenu.add(CrearUsuarioMenuItem);

        EliminarUsuarioMenuItem.setText("Eliminar");
        EliminarUsuarioMenuItem.addActionListener(this::EliminarUsuarioMenuItemActionPerformed);
        UsuarioMenu.add(EliminarUsuarioMenuItem);

        ActualizarUsuarioMenuItem.setText("Actualizar");
        ActualizarUsuarioMenuItem.addActionListener(this::ActualizarUsuarioMenuItemActionPerformed);
        UsuarioMenu.add(ActualizarUsuarioMenuItem);

        BuscarUsuarioMenuItem.setText("Buscar");
        BuscarUsuarioMenuItem.addActionListener(this::BuscarUsuarioMenuItemActionPerformed);
        UsuarioMenu.add(BuscarUsuarioMenuItem);

        ListarUsuarioMenuItem.setText("Listar");
        ListarUsuarioMenuItem.addActionListener(this::ListarUsuarioMenuItemActionPerformed);
        UsuarioMenu.add(ListarUsuarioMenuItem);

        jMenuBar2.add(UsuarioMenu);

        IdiomaMenu.setText("Idioma");

        IdiomaESMenuItem.setText("Español");
        IdiomaESMenuItem.addActionListener(this::IdiomaESMenuItemActionPerformed);
        IdiomaMenu.add(IdiomaESMenuItem);

        IdiomaINMenuItem.setText("Inglés");
        IdiomaINMenuItem.addActionListener(this::IdiomaINMenuItemActionPerformed);
        IdiomaMenu.add(IdiomaINMenuItem);

        jMenuBar2.add(IdiomaMenu);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarLibroMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarLibroMenuItemActionPerformed
        if (!agregarLibroView.isVisible()) {
            jDesktopPane1.remove(agregarLibroView);
            agregarLibroView.setVisible(true);
            jDesktopPane1.add(agregarLibroView);
        }
    }//GEN-LAST:event_AgregarLibroMenuItemActionPerformed

    private void ActualizarLibroMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarLibroMenuItemActionPerformed
        if (!actualizarLibroView.isVisible()) {
            jDesktopPane1.remove(actualizarLibroView);
            actualizarLibroView.setVisible(true);
            jDesktopPane1.add(actualizarLibroView);
        }
    }//GEN-LAST:event_ActualizarLibroMenuItemActionPerformed

    private void ListarLibroMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarLibroMenuItemActionPerformed
        if (!listarLibroView.isVisible()) {
            jDesktopPane1.remove(listarLibroView);
            listarLibroView.setVisible(true);
            jDesktopPane1.add(listarLibroView);
        }
    }//GEN-LAST:event_ListarLibroMenuItemActionPerformed

    private void EliminarAutorMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarAutorMenuItemActionPerformed
        if (!eliminarAutorView.isVisible()) {
            jDesktopPane1.remove(eliminarAutorView);
            eliminarAutorView.setVisible(true);
            jDesktopPane1.add(eliminarAutorView);
        }
    }//GEN-LAST:event_EliminarAutorMenuItemActionPerformed

    private void EliminarUsuarioMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarUsuarioMenuItemActionPerformed
        if (!eliminarUsuarioView.isVisible()) {
            jDesktopPane1.remove(eliminarUsuarioView);
            eliminarUsuarioView.setVisible(true);
            jDesktopPane1.add(eliminarUsuarioView);
        }
    }//GEN-LAST:event_EliminarUsuarioMenuItemActionPerformed

    private void BuscarUsuarioMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarUsuarioMenuItemActionPerformed
        if (!buscarUsuarioView.isVisible()) {
            jDesktopPane1.remove(buscarUsuarioView);
            buscarUsuarioView.setVisible(true);
            jDesktopPane1.add(buscarUsuarioView);
        }
    }//GEN-LAST:event_BuscarUsuarioMenuItemActionPerformed

    private void ListarPrestamoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarPrestamoMenuItemActionPerformed
        if (!listarPrestamoView.isVisible()) {
            jDesktopPane1.remove(listarPrestamoView);
            listarPrestamoView.setVisible(true);
            jDesktopPane1.add(listarPrestamoView);
        }
    }//GEN-LAST:event_ListarPrestamoMenuItemActionPerformed

    private void ListarLibroAutorMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarLibroAutorMenuItemActionPerformed
        if (!listarLibrosAutorView.isVisible()) {
            jDesktopPane1.remove(listarLibrosAutorView);
            listarLibrosAutorView.setVisible(true);
            jDesktopPane1.add(listarLibrosAutorView);
        }
    }//GEN-LAST:event_ListarLibroAutorMenuItemActionPerformed

    private void CrearPrestamoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearPrestamoMenuItemActionPerformed
        if (!crearPrestamoView.isVisible()) {
            jDesktopPane1.remove(crearPrestamoView);
            crearPrestamoView.setVisible(true);
            jDesktopPane1.add(crearPrestamoView);
        }
    }//GEN-LAST:event_CrearPrestamoMenuItemActionPerformed

    private void BuscarPrestamoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarPrestamoMenuItemActionPerformed
        if (!buscarPrestamoView.isVisible()) {
            jDesktopPane1.remove(buscarPrestamoView);
            buscarPrestamoView.setVisible(true);
            jDesktopPane1.add(buscarPrestamoView);
        }
    }//GEN-LAST:event_BuscarPrestamoMenuItemActionPerformed

    private void EliminarPrestamoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarPrestamoMenuItemActionPerformed
        if (!eliminarPrestamoView.isVisible()) {
            jDesktopPane1.remove(eliminarPrestamoView);
            eliminarPrestamoView.setVisible(true);
            jDesktopPane1.add(eliminarPrestamoView);
        }
    }//GEN-LAST:event_EliminarPrestamoMenuItemActionPerformed

    private void ActualizarPrestamoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarPrestamoMenuItemActionPerformed
        if (!actualizarPrestamoView.isVisible()) {
            jDesktopPane1.remove(actualizarPrestamoView);
            actualizarPrestamoView.setVisible(true);
            jDesktopPane1.add(actualizarPrestamoView);
        }
    }//GEN-LAST:event_ActualizarPrestamoMenuItemActionPerformed

    private void EliminarLibroMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarLibroMenuItemActionPerformed
        if (!eliminarLibroView.isVisible()) {
            jDesktopPane1.remove(eliminarLibroView);
            eliminarLibroView.setVisible(true);
            jDesktopPane1.add(eliminarLibroView);
        }
    }//GEN-LAST:event_EliminarLibroMenuItemActionPerformed

    private void BuscarLibroMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarLibroMenuItemActionPerformed
        if (!buscarLibroView.isVisible()) {
            jDesktopPane1.remove(buscarLibroView);
            buscarLibroView.setVisible(true);
            jDesktopPane1.add(buscarLibroView);
        }
    }//GEN-LAST:event_BuscarLibroMenuItemActionPerformed

    private void AgregarAutorMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarAutorMenuItemActionPerformed
        if (!agregarAutorView.isVisible()) {
            jDesktopPane1.remove(agregarAutorView);
            agregarAutorView.setVisible(true);
            jDesktopPane1.add(agregarAutorView);
        }
    }//GEN-LAST:event_AgregarAutorMenuItemActionPerformed

    private void ActualizarAutorMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarAutorMenuItemActionPerformed
        if (!actualizarAutorView.isVisible()) {
            jDesktopPane1.remove(actualizarAutorView);
            actualizarAutorView.setVisible(true);
            jDesktopPane1.add(actualizarAutorView);
        }
    }//GEN-LAST:event_ActualizarAutorMenuItemActionPerformed

    private void CrearUsuarioMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearUsuarioMenuItemActionPerformed
        if (!crearUsuarioView.isVisible()) {
            jDesktopPane1.remove(crearUsuarioView);
            crearUsuarioView.setVisible(true);
            jDesktopPane1.add(crearUsuarioView);
        }
    }//GEN-LAST:event_CrearUsuarioMenuItemActionPerformed

    private void ActualizarUsuarioMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarUsuarioMenuItemActionPerformed
        if (!actualizarUsuarioView.isVisible()) {
            jDesktopPane1.remove(actualizarUsuarioView);
            actualizarUsuarioView.setVisible(true);
            jDesktopPane1.add(actualizarUsuarioView);
        }
    }//GEN-LAST:event_ActualizarUsuarioMenuItemActionPerformed

    private void ListarUsuarioMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarUsuarioMenuItemActionPerformed
        if (!listarUsuarioView.isVisible()) {
            jDesktopPane1.remove(listarUsuarioView);
            listarUsuarioView.setVisible(true);
            jDesktopPane1.add(listarUsuarioView);
        }
    }//GEN-LAST:event_ListarUsuarioMenuItemActionPerformed

    private void BuscarAutorMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarAutorMenuItemActionPerformed

        if (!buscarAutorView.isVisible()) {
            jDesktopPane1.remove(buscarAutorView);
            buscarAutorView.setVisible(true);
            jDesktopPane1.add(buscarAutorView);
        }
    }//GEN-LAST:event_BuscarAutorMenuItemActionPerformed

    private void IdiomaESMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdiomaESMenuItemActionPerformed
        Locale locale = new Locale("es", "EC");
        this.cambiarIdioma(locale);

        // Prestamo View
        crearPrestamoView.cambiarIdioma(locale);
        actualizarPrestamoView.cambiarIdioma(locale);
        buscarPrestamoView.cambiarIdioma(locale);
        eliminarPrestamoView.cambiarIdioma(locale);
        listarPrestamoView.cambiarIdioma(locale);

        // Autor View
        actualizarAutorView.cambiarIdioma(locale);
        agregarAutorView.cambiarIdioma(locale);
        buscarAutorView.cambiarIdioma(locale);
        eliminarAutorView.cambiarIdioma(locale);
        listarLibrosAutorView.cambiarIdioma(locale);
        ResourceBundle bundle;

        // Usuario View
        actualizarUsuarioView.cambiarIdioma(locale);
        buscarUsuarioView.cambiarIdioma(locale);
        crearUsuarioView.cambiarIdioma(locale);
        eliminarUsuarioView.cambiarIdioma(locale);

    }//GEN-LAST:event_IdiomaESMenuItemActionPerformed

    private void IdiomaINMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdiomaINMenuItemActionPerformed
        Locale locale = new Locale("en", "US");
        this.cambiarIdioma(locale);

        // Prestamo View
        crearPrestamoView.cambiarIdioma(locale);
        actualizarPrestamoView.cambiarIdioma(locale);
        buscarPrestamoView.cambiarIdioma(locale);
        eliminarPrestamoView.cambiarIdioma(locale);
        listarPrestamoView.cambiarIdioma(locale);

        // Autor View
        actualizarAutorView.cambiarIdioma(locale);
        agregarAutorView.cambiarIdioma(locale);
        buscarAutorView.cambiarIdioma(locale);
        eliminarAutorView.cambiarIdioma(locale);
        listarLibrosAutorView.cambiarIdioma(locale);

        // Usuario View
        actualizarUsuarioView.cambiarIdioma(locale);
        buscarUsuarioView.cambiarIdioma(locale);
        crearUsuarioView.cambiarIdioma(locale);
        eliminarUsuarioView.cambiarIdioma(locale);

    }//GEN-LAST:event_IdiomaINMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new PrincipalView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ActualizarAutorMenuItem;
    private javax.swing.JMenuItem ActualizarLibroMenuItem;
    private javax.swing.JMenuItem ActualizarPrestamoMenuItem;
    private javax.swing.JMenuItem ActualizarUsuarioMenuItem;
    private javax.swing.JMenuItem AgregarAutorMenuItem;
    private javax.swing.JMenuItem AgregarLibroMenuItem;
    private javax.swing.JMenu AutorMenu;
    private javax.swing.JMenuItem BuscarAutorMenuItem;
    private javax.swing.JMenuItem BuscarLibroMenuItem;
    private javax.swing.JMenuItem BuscarPrestamoMenuItem;
    private javax.swing.JMenuItem BuscarUsuarioMenuItem;
    private javax.swing.JMenuItem CrearPrestamoMenuItem;
    private javax.swing.JMenuItem CrearUsuarioMenuItem;
    private javax.swing.JMenuItem EliminarAutorMenuItem;
    private javax.swing.JMenuItem EliminarLibroMenuItem;
    private javax.swing.JMenuItem EliminarPrestamoMenuItem;
    private javax.swing.JMenuItem EliminarUsuarioMenuItem;
    private javax.swing.JMenuItem IdiomaESMenuItem;
    private javax.swing.JMenuItem IdiomaINMenuItem;
    private javax.swing.JMenu IdiomaMenu;
    private javax.swing.JMenu LibroMenu;
    private javax.swing.JMenuItem ListarLibroAutorMenuItem;
    private javax.swing.JMenuItem ListarLibroMenuItem;
    private javax.swing.JMenuItem ListarPrestamoMenuItem;
    private javax.swing.JMenuItem ListarUsuarioMenuItem;
    private javax.swing.JMenu PrestamoMenu;
    private javax.swing.JMenu UsuarioMenu;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables
}
