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

        ResourceBundle bundle = ResourceBundle.getBundle(
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

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Actualizar Prestamo");

        panelActualizar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actualizar datos del prestamo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Bright", 0, 12))); // NOI18N

        lblCodigoActualizar.setText("Ingrese el codigo del prestamo:");

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/proyectobiblioteca/images/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");

        lblUsuarioActualizar.setText("Usuario:");

        txtUsuarioActualizar.setEditable(false);
        txtUsuarioActualizar.setEnabled(false);

        lblLibroActualizar.setText("Libro:");

        txtLibroActualizar.setEditable(false);
        txtLibroActualizar.setEnabled(false);

        lblFechaActualizar.setText("Fecha del prestamo:");

        txtFechaActualizar.setEditable(false);
        txtFechaActualizar.setEnabled(false);

        lblFechaDevActualizar.setText("Fecha de devolución:");

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/proyectobiblioteca/images/aceptar.png"))); // NOI18N
        btnAceptar.setText("Aceptar");

        btnCancelar.setText("Cancelar");

        lblLectura1.setText("(solo lectura)");

        lblLectura2.setText("(solo lectura)");

        lblLectura3.setText("(solo lectura)");

        lblAutorActualizar.setText("Autor:");

        txtAutorActualizar.setEditable(false);
        txtAutorActualizar.setEnabled(false);
        txtAutorActualizar.addActionListener(this::txtAutorActualizarActionPerformed);

        lblLectura4.setText("(solo lectura)");

        lblISBNActualizar.setText("ISBN:");

        ComboBoxDiaDevolucion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        ComboBoxMesDevolucion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        ComboBoxAnioDevolucion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2026" }));

        javax.swing.GroupLayout panelActualizarLayout = new javax.swing.GroupLayout(panelActualizar);
        panelActualizar.setLayout(panelActualizarLayout);
        panelActualizarLayout.setHorizontalGroup(
            panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelActualizarLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(btnAceptar)
                .addGap(80, 80, 80)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelActualizarLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelActualizarLayout.createSequentialGroup()
                        .addGroup(panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCodigoActualizar)
                            .addGroup(panelActualizarLayout.createSequentialGroup()
                                .addGroup(panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblUsuarioActualizar)
                                    .addComponent(lblLibroActualizar))
                                .addGap(18, 18, 18)
                                .addGroup(panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUsuarioActualizar)
                                    .addComponent(txtLibroActualizar)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelActualizarLayout.createSequentialGroup()
                                .addComponent(lblISBNActualizar)
                                .addGap(32, 32, 32)
                                .addGroup(panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtAutorActualizar)
                                    .addComponent(txtISBNActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelActualizarLayout.createSequentialGroup()
                                .addComponent(txtCodigoActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar))
                            .addComponent(lblLectura4)
                            .addComponent(lblLectura1)
                            .addComponent(lblLectura2)))
                    .addGroup(panelActualizarLayout.createSequentialGroup()
                        .addGroup(panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFechaDevActualizar)
                            .addComponent(lblFechaActualizar))
                        .addGroup(panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelActualizarLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
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
                    .addComponent(lblAutorActualizar))
                .addGap(0, 53, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblISBNActualizar)
                    .addComponent(txtISBNActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAutorActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAutorActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLectura4))
                .addGap(18, 18, 18)
                .addGroup(panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFechaActualizar)
                    .addGroup(panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFechaActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblLectura3)))
                .addGap(18, 18, 18)
                .addGroup(panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaDevActualizar)
                    .addComponent(ComboBoxDiaDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxMesDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxAnioDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(panelActualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelActualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAutorActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAutorActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAutorActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxAnioDevolucion;
    private javax.swing.JComboBox<String> ComboBoxDiaDevolucion;
    private javax.swing.JComboBox<String> ComboBoxMesDevolucion;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
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
