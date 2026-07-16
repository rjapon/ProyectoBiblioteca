/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ec.edu.ups.proyectobiblioteca.views;

import ec.edu.ups.proyectobiblioteca.enums.CiudadesUsuario;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author mateo
 */
public class ActualizarUsuarioView extends javax.swing.JInternalFrame {
    
    private ResourceBundle mensajes;

    /**
     * Creates new form ActualizarUsuarioView
     */
    public ActualizarUsuarioView() {
        initComponents();
        DefaultComboBoxModel<CiudadesUsuario> modelo = (DefaultComboBoxModel) cbxCiudad.getModel(); cbxCiudad.getModel();
         
         modelo.addElement(CiudadesUsuario.CUENCA);
         modelo.addElement(CiudadesUsuario.CAMILO_PONCE_ENRIQUEZ);
         modelo.addElement(CiudadesUsuario.CHORDELEG);
         modelo.addElement(CiudadesUsuario.EL_PAN);
         modelo.addElement(CiudadesUsuario.GIRON);
         modelo.addElement(CiudadesUsuario.GUACHAPALA);
         modelo.addElement(CiudadesUsuario.GUALACEO);
         modelo.addElement(CiudadesUsuario.NABON);
         modelo.addElement(CiudadesUsuario.OÑA);
         modelo.addElement(CiudadesUsuario.PAUTE);
         modelo.addElement(CiudadesUsuario.PUCARA);
         modelo.addElement(CiudadesUsuario.SANTA_ISABEL);
         modelo.addElement(CiudadesUsuario.SAN_FERNANDO);
         modelo.addElement(CiudadesUsuario.SEVILLA_DE_ORO);
         modelo.addElement(CiudadesUsuario.SIGSIG);
    }

    public JComboBox<String> getCbxCiudad() {
        return cbxCiudad;
    }

    public void setCbxCiudad(JComboBox<String> cbxCiudad) {
        this.cbxCiudad = cbxCiudad;
    }
    
    public JTextField getTxtCallePrincipal() {
        return txtCallePrincipal;
    }

    public void setTxtCallePrincipal(JTextField txtCallePrincipal) {
        this.txtCallePrincipal = txtCallePrincipal;
    }
    
    public JTextField getTxtCiudad() {
        return txtCiudad;
    }

    public void setTxtCiudad(JTextField txtCiudad) {
        this.txtCiudad = txtCiudad;
    }

    public JLabel getTxtCorreoE() {
        return lblCorreoUsuario;
    }

    public void setTxtCorreoE(JLabel txtCorreoE) {
        this.lblCorreoUsuario = txtCorreoE;
    }

    public JTextField getTxtCorreoElectronico() {
        return txtCorreoElectronico;
    }

    public void setTxtCorreoElectronico(JTextField txtCorreoElectronico) {
        this.txtCorreoElectronico = txtCorreoElectronico;
    }
    
    

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public JTextField getTxtCedulaActualizarUsuario() {
        return txtCedulaActualizarUsuario;
    }

    public void setTxtCedulaActualizarUsuario(JTextField txtCedulaActualizarUsuario) {
        this.txtCedulaActualizarUsuario = txtCedulaActualizarUsuario;
    }

    public JTextField getTxtNombreActualizarUsuario() {
        return txtNombreActualizarUsuario;
    }

    public void setTxtNombreActualizarUsuario(JTextField txtNombreActualizarUsuario) {
        this.txtNombreActualizarUsuario = txtNombreActualizarUsuario;
    }

    public JTextField getTxtTelefonoActualizarUsuario() {
        return txtTelefonoActualizarUsuario;
    }

    public void setTxtTelefonoActualizarUsuario(JTextField txtTelefonoActualizarUsuario) {
        this.txtTelefonoActualizarUsuario = txtTelefonoActualizarUsuario;
    }

    public void cambiarIdioma(Locale locale) {

        mensajes = ResourceBundle.getBundle("ec.edu.ups.proyectobiblioteca.i18n.mensajes", locale);

        setTitle(mensajes.getString("tituloVentanaActualizarUsuario"));

        jLabel1.setText(mensajes.getString("lblCedulaUsuario"));
        jLabel2.setText(mensajes.getString("lblNombreUsuario"));
        jLabel3.setText(mensajes.getString("lblTelefonoUsuario"));
        
        lblTituloActualizar.setText(mensajes.getString("lblTituloActualizar"));
        
        lblCorreoUsuario.setText(mensajes.getString("lblCorreoUsuario"));
        lblCiudad.setText(mensajes.getString("lblCiudadUsuario"));
        lblCiudad1.setText(mensajes.getString("lblCiudadUpUsuario"));
        lblCallePrincipal.setText(mensajes.getString("lblCallePrinUsuario"));
        lblIndicacion.setText(mensajes.getString("lblIndicacion"));

        btnBuscar.setText(mensajes.getString("btnBuscar"));
        btnActualizar.setText(mensajes.getString("btnActualizar"));
        btnCancelar.setText(mensajes.getString("btnCancelar"));
    }

     public void mostrarInformacion(String mensaje) {
        JOptionPane.showMessageDialog(this, mensajes.getString(mensaje));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCedulaActualizarUsuario = new javax.swing.JTextField();
        txtNombreActualizarUsuario = new javax.swing.JTextField();
        txtTelefonoActualizarUsuario = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        lblTituloActualizar = new javax.swing.JLabel();
        lblCorreoUsuario = new javax.swing.JLabel();
        txtCorreoElectronico = new javax.swing.JTextField();
        lblCiudad = new javax.swing.JLabel();
        txtCiudad = new javax.swing.JTextField();
        lblCallePrincipal = new javax.swing.JLabel();
        txtCallePrincipal = new javax.swing.JTextField();
        lblIndicacion = new javax.swing.JLabel();
        lblCiudad1 = new javax.swing.JLabel();
        cbxCiudad = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Actualizar Usuario");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel1.setText("Cédula:");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        jLabel3.setText("Teléfono:");

        btnActualizar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/proyectobiblioteca/images/actualizar.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(this::btnActualizarActionPerformed);

        btnCancelar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        btnBuscar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ec/edu/ups/proyectobiblioteca/images/buscar.png"))); // NOI18N
        btnBuscar.setText("Buscar");

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));

        lblTituloActualizar.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        lblTituloActualizar.setText("Actualizar Usuario");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(lblTituloActualizar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTituloActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        lblCorreoUsuario.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblCorreoUsuario.setText("Correo Electronico:");

        lblCiudad.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblCiudad.setText("Ciudad:");

        lblCallePrincipal.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblCallePrincipal.setText("Calle Principal:");

        lblIndicacion.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 12)); // NOI18N
        lblIndicacion.setText("(Ingrese en los campos los datos que desee actualizar)");

        lblCiudad1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lblCiudad1.setText("Ciudad(Actualizar):");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCedulaActualizarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(btnActualizar)
                        .addGap(41, 41, 41)
                        .addComponent(btnCancelar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblCiudad)
                        .addGap(78, 78, 78)
                        .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefonoActualizarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreActualizarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblCorreoUsuario)
                        .addGap(34, 34, 34)
                        .addComponent(txtCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCiudad1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCallePrincipal))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCallePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(134, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblIndicacion)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCedulaActualizarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(7, 7, 7)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIndicacion)
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreActualizarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTelefonoActualizarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreoElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCorreoUsuario))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCiudad)
                    .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCiudad1)
                    .addComponent(cbxCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCallePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCallePrincipal))
                .addGap(36, 36, 36)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<String> cbxCiudad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblCallePrincipal;
    private javax.swing.JLabel lblCiudad;
    private javax.swing.JLabel lblCiudad1;
    private javax.swing.JLabel lblCorreoUsuario;
    private javax.swing.JLabel lblIndicacion;
    private javax.swing.JLabel lblTituloActualizar;
    private javax.swing.JTextField txtCallePrincipal;
    private javax.swing.JTextField txtCedulaActualizarUsuario;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtCorreoElectronico;
    private javax.swing.JTextField txtNombreActualizarUsuario;
    private javax.swing.JTextField txtTelefonoActualizarUsuario;
    // End of variables declaration//GEN-END:variables
}
