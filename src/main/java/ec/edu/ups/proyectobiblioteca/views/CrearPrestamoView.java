/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ec.edu.ups.proyectobiblioteca.views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Asus
 */
public class CrearPrestamoView extends javax.swing.JInternalFrame {

    /**
     * Creates new form CrearPrestamoView
     */
    public CrearPrestamoView() {
        initComponents();
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public void setBtnAceptar(JButton btnAceptar) {
        this.btnAceptar = btnAceptar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JTextField getTxtCedulaCrear() {
        return txtCedulaCrear;
    }

    public void setTxtCedulaCrear(JTextField txtCedulaCrear) {
        this.txtCedulaCrear = txtCedulaCrear;
    }

    public JTextField getTxtCodigoCrear() {
        return txtCodigoCrear;
    }

    public void setTxtCodigoCrear(JTextField txtCodigoCrear) {
        this.txtCodigoCrear = txtCodigoCrear;
    }

    public JTextField getTxtDisponibleCrear() {
        return txtDisponibleCrear;
    }

    public void setTxtDisponibleCrear(JTextField txtDisponibleCrear) {
        this.txtDisponibleCrear = txtDisponibleCrear;
    }

    public JTextField getTxtFechaCrear() {
        return txtFechaCrear;
    }

    public void setTxtFechaCrear(JTextField txtFechaCrear) {
        this.txtFechaCrear = txtFechaCrear;
    }

    public JComboBox<String> getComboBoxAnioDevolucion() {
        return ComboBoxAnioDevolucion;
    }

    public void setComboBoxAnioDevolucion(JComboBox<String> ComboBoxAnioDevolucion) {
        this.ComboBoxAnioDevolucion = ComboBoxAnioDevolucion;
    }

    public JComboBox<String> getComboBoxDiaDevolucion() {
        return ComboBoxDiaDevolucion;
    }

    public void setComboBoxDiaDevolucion(JComboBox<String> ComboBoxDiaDevolucion) {
        this.ComboBoxDiaDevolucion = ComboBoxDiaDevolucion;
    }

    public JComboBox<String> getComboBoxMesDevolucion() {
        return ComboBoxMesDevolucion;
    }

    public void setComboBoxMesDevolucion(JComboBox<String> ComboBoxMesDevolucion) {
        this.ComboBoxMesDevolucion = ComboBoxMesDevolucion;
    }

    public JTextField getTxtISBNCrear() {
        return txtISBNCrear;
    }

    public void setTxtISBNCrear(JTextField txtISBNCrear) {
        this.txtISBNCrear = txtISBNCrear;
    }

    public JButton getBtnBuscarLibro() {
        return btnBuscarLibro;
    }

    public void setBtnBuscarLibro(JButton btnBuscarLibro) {
        this.btnBuscarLibro = btnBuscarLibro;
    }

    public JButton getBtnBuscarUsuario() {
        return btnBuscarUsuario;
    }

    public void setBtnBuscarUsuario(JButton btnBuscarUsuario) {
        this.btnBuscarUsuario = btnBuscarUsuario;
    }

    public JTextField getTxtAutorCrear() {
        return txtAutorCrear;
    }

    public void setTxtAutorCrear(JTextField txtAutorCrear) {
        this.txtAutorCrear = txtAutorCrear;
    }

    public JTextField getTxtLibroCrear() {
        return txtLibroCrear;
    }

    public void setTxtLibroCrear(JTextField txtLibroCrear) {
        this.txtLibroCrear = txtLibroCrear;
    }

    public JTextField getTxtUsuarioCrear() {
        return txtUsuarioCrear;
    }

    public void setTxtUsuarioCrear(JTextField txtUsuarioCrear) {
        this.txtUsuarioCrear = txtUsuarioCrear;
    }

    public void cambiarIdioma(Locale locale) {

        ResourceBundle bundle = ResourceBundle.getBundle(
                "ec.edu.ups.proyectobiblioteca.i18n.mensajes", locale);

        setTitle(bundle.getString("tituloVentanaCrearPrestamo"));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("tituloPanelCrearPrestamo")));

        lblCodigoCrear.setText(bundle.getString("lblInCodigoPrestamo"));
        lblFechaCrear.setText(bundle.getString("lblFechaPrestamo"));
        lblFechaDevCrear.setText(bundle.getString("lblFechaDevPrestamo"));
        lblCedulaCrear.setText(bundle.getString("lblCedulaPrestamo"));
        lblUsuarioCrear.setText(bundle.getString("lblUsuarioPrestamo"));
        lblISBNCrear.setText(bundle.getString("lblISBNPrestamo"));
        lblLibroCrear.setText(bundle.getString("lblLibroPrestamo"));
        lblAutorCrear.setText(bundle.getString("lblAutorPrestamo"));
        lblDisponibleCrear.setText(bundle.getString("lblDisponiblePrestamo"));

        btnBuscarUsuario.setText(bundle.getString("btnBuscar"));
        btnBuscarLibro.setText(bundle.getString("btnBuscar"));
        btnAceptar.setText(bundle.getString("btnAceptar"));
        btnCancelar.setText(bundle.getString("btnCancelar"));
    }

    public void mostrarInformacion(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        jPanel1 = new javax.swing.JPanel();
        lblCodigoCrear = new javax.swing.JLabel();
        lblFechaCrear = new javax.swing.JLabel();
        lblISBNCrear = new javax.swing.JLabel();
        txtCodigoCrear = new javax.swing.JTextField();
        txtFechaCrear = new javax.swing.JTextField();
        txtISBNCrear = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblLibroCrear = new javax.swing.JLabel();
        lblAutorCrear = new javax.swing.JLabel();
        lblDisponibleCrear = new javax.swing.JLabel();
        txtDisponibleCrear = new javax.swing.JTextField();
        lblCedulaCrear = new javax.swing.JLabel();
        txtCedulaCrear = new javax.swing.JTextField();
        lblFechaDevCrear = new javax.swing.JLabel();
        txtLibroCrear = new javax.swing.JTextField();
        txtAutorCrear = new javax.swing.JTextField();
        btnBuscarUsuario = new javax.swing.JButton();
        btnBuscarLibro = new javax.swing.JButton();
        lblUsuarioCrear = new javax.swing.JLabel();
        txtUsuarioCrear = new javax.swing.JTextField();
        ComboBoxDiaDevolucion = new javax.swing.JComboBox<>();
        ComboBoxMesDevolucion = new javax.swing.JComboBox<>();
        ComboBoxAnioDevolucion = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setClosable(true);
        setResizable(true);
        setTitle("Crear Prestamo\n");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Bright", 0, 12))); // NOI18N
        jPanel1.setToolTipText("");

        lblCodigoCrear.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblCodigoCrear.setText("Código de préstamo:");

        lblFechaCrear.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblFechaCrear.setText("Fecha de préstamo:");

        lblISBNCrear.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblISBNCrear.setText("ISBN:");

        txtCodigoCrear.addActionListener(this::txtCodigoCrearActionPerformed);

        txtFechaCrear.setEditable(false);

        btnAceptar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/proyectobiblioteca/images/aceptar.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(this::btnAceptarActionPerformed);

        btnCancelar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        lblLibroCrear.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblLibroCrear.setText("Libro:");

        lblAutorCrear.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblAutorCrear.setText("Autor:");

        lblDisponibleCrear.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblDisponibleCrear.setText("Disponible?");

        txtDisponibleCrear.setEditable(false);
        txtDisponibleCrear.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        txtDisponibleCrear.setEnabled(false);

        lblCedulaCrear.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblCedulaCrear.setText("Cédula:");

        txtCedulaCrear.addActionListener(this::txtCedulaCrearActionPerformed);

        lblFechaDevCrear.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblFechaDevCrear.setText("Fecha de devolución:");

        txtLibroCrear.setEnabled(false);
        txtLibroCrear.addActionListener(this::txtLibroCrearActionPerformed);

        txtAutorCrear.setEnabled(false);

        btnBuscarUsuario.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnBuscarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/proyectobiblioteca/images/buscar.png"))); // NOI18N
        btnBuscarUsuario.setText("Buscar");

        btnBuscarLibro.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnBuscarLibro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/proyectobiblioteca/images/buscar.png"))); // NOI18N
        btnBuscarLibro.setText("Buscar");

        lblUsuarioCrear.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblUsuarioCrear.setText("Usuario:");

        txtUsuarioCrear.setEnabled(false);

        ComboBoxDiaDevolucion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        ComboBoxMesDevolucion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        ComboBoxAnioDevolucion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2026" }));

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel1.setText("Registrar Préstamo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblDisponibleCrear)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtDisponibleCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblAutorCrear)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtAutorCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblISBNCrear)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtISBNCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblLibroCrear)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtLibroCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnAceptar)
                                            .addComponent(txtUsuarioCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCedulaCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnBuscarLibro)
                                    .addComponent(btnCancelar)))
                            .addComponent(lblUsuarioCrear)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCedulaCrear)
                                .addGap(237, 237, 237)
                                .addComponent(btnBuscarUsuario))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFechaDevCrear)
                                    .addComponent(lblFechaCrear)
                                    .addComponent(lblCodigoCrear))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFechaCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(ComboBoxDiaDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(ComboBoxMesDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(ComboBoxAnioDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtCodigoCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(74, 74, 74)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoCrear)
                    .addComponent(txtCodigoCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaCrear, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtFechaCrear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaDevCrear)
                    .addComponent(ComboBoxDiaDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxMesDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxAnioDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedulaCrear)
                    .addComponent(txtCedulaCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarUsuario))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuarioCrear)
                    .addComponent(txtUsuarioCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblISBNCrear)
                    .addComponent(txtISBNCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarLibro))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLibroCrear)
                    .addComponent(txtLibroCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAutorCrear)
                    .addComponent(txtAutorCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDisponibleCrear)
                    .addComponent(txtDisponibleCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoCrearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoCrearActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtLibroCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLibroCrearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLibroCrearActionPerformed

    private void txtCedulaCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaCrearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaCrearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxAnioDevolucion;
    private javax.swing.JComboBox<String> ComboBoxDiaDevolucion;
    private javax.swing.JComboBox<String> ComboBoxMesDevolucion;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscarLibro;
    private javax.swing.JButton btnBuscarUsuario;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel lblAutorCrear;
    private javax.swing.JLabel lblCedulaCrear;
    private javax.swing.JLabel lblCodigoCrear;
    private javax.swing.JLabel lblDisponibleCrear;
    private javax.swing.JLabel lblFechaCrear;
    private javax.swing.JLabel lblFechaDevCrear;
    private javax.swing.JLabel lblISBNCrear;
    private javax.swing.JLabel lblLibroCrear;
    private javax.swing.JLabel lblUsuarioCrear;
    private javax.swing.JTextField txtAutorCrear;
    private javax.swing.JTextField txtCedulaCrear;
    private javax.swing.JTextField txtCodigoCrear;
    private javax.swing.JTextField txtDisponibleCrear;
    private javax.swing.JTextField txtFechaCrear;
    private javax.swing.JTextField txtISBNCrear;
    private javax.swing.JTextField txtLibroCrear;
    private javax.swing.JTextField txtUsuarioCrear;
    // End of variables declaration//GEN-END:variables
}
