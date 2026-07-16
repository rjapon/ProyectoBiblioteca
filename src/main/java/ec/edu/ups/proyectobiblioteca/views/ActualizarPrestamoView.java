/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ec.edu.ups.proyectobiblioteca.views;

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
public class ActualizarPrestamoView extends javax.swing.JInternalFrame {
    
    private ResourceBundle bundle;

    /**
     * Creates new form ActualizarPrestamoView
     */
    public ActualizarPrestamoView() {
        initComponents();
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public void setBtnAceptar(JButton btnAceptar) {
        this.btnAceptar = btnAceptar;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JTextField getTxtCodigoActualizar() {
        return txtCodigoActualizar;
    }

    public void setTxtCodigoActualizar(JTextField txtCodigoActualizar) {
        this.txtCodigoActualizar = txtCodigoActualizar;
    }

    public JTextField getTxtFechaActualizar() {
        return txtFechaActualizar;
    }

    public void setTxtFechaActualizar(JTextField txtFechaActualizar) {
        this.txtFechaActualizar = txtFechaActualizar;
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

    public JTextField getTxtLibroActualizar() {
        return txtLibroActualizar;
    }

    public void setTxtLibroActualizar(JTextField txtLibroActualizar) {
        this.txtLibroActualizar = txtLibroActualizar;
    }

    public JTextField getTxtUsuarioActualizar() {
        return txtUsuarioActualizar;
    }

    public void setTxtUsuarioActualizar(JTextField txtUsuarioActualizar) {
        this.txtUsuarioActualizar = txtUsuarioActualizar;
    }

    public JTextField getTxtAutorActualizar() {
        return txtAutorActualizar;
    }

    public void setTxtAutorActualizar(JTextField txtAutorActualizar) {
        this.txtAutorActualizar = txtAutorActualizar;
    }

    public JTextField getTxtISBNActualizar() {
        return txtISBNActualizar;
    }

    public void setTxtISBNActualizar(JTextField txtISBNActualizar) {
        this.txtISBNActualizar = txtISBNActualizar;
    }

    public void cambiarIdioma(Locale locale) {

        bundle = ResourceBundle.getBundle(
                "ec.edu.ups.proyectobiblioteca.i18n.mensajes", locale);

        setTitle(bundle.getString("tituloVentanaActualizarPrestamo"));

        panelActualizar.setBorder(
                javax.swing.BorderFactory.createTitledBorder(
                        bundle.getString("tituloPanelActualizarPrestamo")));

        lblCodigoActualizar.setText(bundle.getString("lblCodigoPrestamo"));
        lblUsuarioActualizar.setText(bundle.getString("lblUsuarioPrestamo"));
        lblLibroActualizar.setText(bundle.getString("lblLibroPrestamo"));
        lblISBNActualizar.setText(bundle.getString("lblISBNPrestamo"));
        lblAutorActualizar.setText(bundle.getString("lblAutorPrestamo"));
        lblFechaActualizar.setText(bundle.getString("lblFechaPrestamo"));
        lblFechaDevActualizar.setText(bundle.getString("lblFechaDevPrestamo"));

        lblLectura1.setText(bundle.getString("lblLecturaPrestamo"));
        lblLectura2.setText(bundle.getString("lblLecturaPrestamo"));
        lblLectura3.setText(bundle.getString("lblLecturaPrestamo"));
        lblLectura4.setText(bundle.getString("lblLecturaPrestamo"));
        
        lblTituloActualizar.setText(bundle.getString("lblTituloActualizarPrestamo"));

        btnBuscar.setText(bundle.getString("btnBuscar"));
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

        panelActualizar = new javax.swing.JPanel();
        lblCodigoActualizar = new javax.swing.JLabel();
        txtCodigoActualizar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblUsuarioActualizar = new javax.swing.JLabel();
        txtUsuarioActualizar = new javax.swing.JTextField();
        lblLibroActualizar = new javax.swing.JLabel();
        txtLibroActualizar = new javax.swing.JTextField();
        lblFechaActualizar = new javax.swing.JLabel();
        txtFechaActualizar = new javax.swing.JTextField();
        lblFechaDevActualizar = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblLectura1 = new javax.swing.JLabel();
        lblLectura2 = new javax.swing.JLabel();
        lblLectura3 = new javax.swing.JLabel();
        lblAutorActualizar = new javax.swing.JLabel();
        txtAutorActualizar = new javax.swing.JTextField();
        lblLectura4 = new javax.swing.JLabel();
        lblISBNActualizar = new javax.swing.JLabel();
        txtISBNActualizar = new javax.swing.JTextField();
        ComboBoxDiaDevolucion = new javax.swing.JComboBox<>();
        ComboBoxMesDevolucion = new javax.swing.JComboBox<>();
        ComboBoxAnioDevolucion = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        lblTituloActualizar = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Actualizar Prestamo");

        panelActualizar.setBackground(new java.awt.Color(255, 255, 255));
        panelActualizar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Bright", 0, 12))); // NOI18N

        lblCodigoActualizar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblCodigoActualizar.setText("Ingrese el código del préstamo:");

        btnBuscar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/proyectobiblioteca/images/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");

        lblUsuarioActualizar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblUsuarioActualizar.setText("Usuario:");

        txtUsuarioActualizar.setEditable(false);
        txtUsuarioActualizar.setEnabled(false);

        lblLibroActualizar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblLibroActualizar.setText("Libro:");

        txtLibroActualizar.setEditable(false);
        txtLibroActualizar.setEnabled(false);

        lblFechaActualizar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblFechaActualizar.setText("Fecha del préstamo:");

        txtFechaActualizar.setEditable(false);
        txtFechaActualizar.setEnabled(false);

        lblFechaDevActualizar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblFechaDevActualizar.setText("Fecha de devolución:");

        btnAceptar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/proyectobiblioteca/images/aceptar.png"))); // NOI18N
        btnAceptar.setText("Aceptar");

        btnCancelar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        lblLectura1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblLectura1.setText("(solo lectura)");

        lblLectura2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblLectura2.setText("(solo lectura)");

        lblLectura3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblLectura3.setText("(solo lectura)");

        lblAutorActualizar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblAutorActualizar.setText("Autor:");

        txtAutorActualizar.setEditable(false);
        txtAutorActualizar.setEnabled(false);
        txtAutorActualizar.addActionListener(this::txtAutorActualizarActionPerformed);

        lblLectura4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblLectura4.setText("(solo lectura)");

        lblISBNActualizar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblISBNActualizar.setText("ISBN:");

        ComboBoxDiaDevolucion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        ComboBoxMesDevolucion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        ComboBoxAnioDevolucion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2026" }));

        javax.swing.GroupLayout panelActualizarLayout = new javax.swing.GroupLayout(panelActualizar);
        panelActualizar.setLayout(panelActualizarLayout);
        panelActualizarLayout.setHorizontalGroup(
            panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelActualizarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelActualizarLayout.createSequentialGroup()
                        .addGroup(panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFechaActualizar)
                            .addComponent(lblFechaDevActualizar))
                        .addGap(11, 11, 11)
                        .addGroup(panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelActualizarLayout.createSequentialGroup()
                                .addComponent(txtFechaActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblLectura3))
                            .addGroup(panelActualizarLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(ComboBoxDiaDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ComboBoxMesDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ComboBoxAnioDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelActualizarLayout.createSequentialGroup()
                        .addGroup(panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelActualizarLayout.createSequentialGroup()
                                .addComponent(lblCodigoActualizar)
                                .addGap(18, 18, 18)
                                .addComponent(txtCodigoActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelActualizarLayout.createSequentialGroup()
                                .addGroup(panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblLibroActualizar)
                                    .addComponent(lblUsuarioActualizar))
                                .addGap(23, 23, 23)
                                .addGroup(panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUsuarioActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(txtLibroActualizar)))
                            .addGroup(panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(panelActualizarLayout.createSequentialGroup()
                                    .addComponent(lblAutorActualizar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtAutorActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelActualizarLayout.createSequentialGroup()
                                    .addComponent(lblISBNActualizar)
                                    .addGap(42, 42, 42)
                                    .addComponent(txtISBNActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLectura4)
                            .addComponent(lblLectura1)
                            .addComponent(lblLectura2)
                            .addComponent(btnBuscar)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelActualizarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(panelActualizarLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(btnAceptar)
                .addGap(29, 29, 29)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelActualizarLayout.setVerticalGroup(
            panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelActualizarLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoActualizar)
                    .addComponent(txtCodigoActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addGroup(panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuarioActualizar)
                    .addComponent(txtUsuarioActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLectura1))
                .addGap(18, 18, 18)
                .addGroup(panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLibroActualizar)
                    .addComponent(txtLibroActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLectura2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtISBNActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblISBNActualizar))
                .addGap(18, 18, 18)
                .addGroup(panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAutorActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAutorActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblLectura4))
                .addGap(31, 31, 31)
                .addGroup(panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFechaActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLectura3)
                    .addComponent(lblFechaActualizar))
                .addGap(18, 18, 18)
                .addGroup(panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaDevActualizar)
                    .addComponent(ComboBoxDiaDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxMesDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxAnioDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        lblTituloActualizar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblTituloActualizar.setText("Actualizar Préstamo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTituloActualizar)
                .addGap(171, 171, 171))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblTituloActualizar)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAutorActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAutorActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAutorActualizarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();        
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxAnioDevolucion;
    private javax.swing.JComboBox<String> ComboBoxDiaDevolucion;
    private javax.swing.JComboBox<String> ComboBoxMesDevolucion;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAutorActualizar;
    private javax.swing.JLabel lblCodigoActualizar;
    private javax.swing.JLabel lblFechaActualizar;
    private javax.swing.JLabel lblFechaDevActualizar;
    private javax.swing.JLabel lblISBNActualizar;
    private javax.swing.JLabel lblLectura1;
    private javax.swing.JLabel lblLectura2;
    private javax.swing.JLabel lblLectura3;
    private javax.swing.JLabel lblLectura4;
    private javax.swing.JLabel lblLibroActualizar;
    private javax.swing.JLabel lblTituloActualizar;
    private javax.swing.JLabel lblUsuarioActualizar;
    private javax.swing.JPanel panelActualizar;
    private javax.swing.JTextField txtAutorActualizar;
    private javax.swing.JTextField txtCodigoActualizar;
    private javax.swing.JTextField txtFechaActualizar;
    private javax.swing.JTextField txtISBNActualizar;
    private javax.swing.JTextField txtLibroActualizar;
    private javax.swing.JTextField txtUsuarioActualizar;
    // End of variables declaration//GEN-END:variables
}
