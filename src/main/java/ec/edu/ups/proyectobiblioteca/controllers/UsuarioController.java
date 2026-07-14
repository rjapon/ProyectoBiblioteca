/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.proyectobiblioteca.controllers;

import ec.edu.ups.proyectobiblioteca.dao.UsuarioDAO;
import ec.edu.ups.proyectobiblioteca.enums.CiudadesUsuario;
import ec.edu.ups.proyectobiblioteca.exceptions.CedulaInvalidaException;
import ec.edu.ups.proyectobiblioteca.exceptions.UsuarioNoEncontradoException;
import ec.edu.ups.proyectobiblioteca.exceptions.ValidarCamposException;
import ec.edu.ups.proyectobiblioteca.models.Usuario;
import ec.edu.ups.proyectobiblioteca.views.ActualizarUsuarioView;
import ec.edu.ups.proyectobiblioteca.views.BuscarUsuarioView;
import ec.edu.ups.proyectobiblioteca.views.CrearUsuarioView;
import ec.edu.ups.proyectobiblioteca.views.EliminarUsuarioView;
import ec.edu.ups.proyectobiblioteca.views.ListarUsuarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class UsuarioController {

    private CrearUsuarioView crearUsuarioView;
    private ActualizarUsuarioView actualizarUsuarioView;
    private EliminarUsuarioView eliminarUsuarioview;
    private ListarUsuarioView listarUsuarioView;
    private BuscarUsuarioView buscarUsuarioView;

    private UsuarioDAO usuarioDAO;

    public UsuarioController(CrearUsuarioView crearUsuarioView, ActualizarUsuarioView actualizarUsuarioView, EliminarUsuarioView eliminarUsuarioview, BuscarUsuarioView buscarUsuarioView,  ListarUsuarioView listarUsuarioView, UsuarioDAO usuarioDAO) {
        this.crearUsuarioView = crearUsuarioView;
        this.actualizarUsuarioView = actualizarUsuarioView;
        this.eliminarUsuarioview = eliminarUsuarioview;
        this.listarUsuarioView = listarUsuarioView;
        this.buscarUsuarioView = buscarUsuarioView;
        this.usuarioDAO = usuarioDAO;

        configurarEventosCrearUsuario();
        configurarEventosBuscarUsuario();
        configurarEventosBuscarActualizarUsuario();
        configurarEventosActualizarUsuario();
        configurarEventosBuscarEliminarUsuario();
        configurarEventosEliminarUsuario();
        configurarEventosListarUsuarios();
    }

    public void crearUsuario() {
     try{
        String cedula = crearUsuarioView.getTxtCedulaCrearUsuario().getText().trim();       
        String nombre = crearUsuarioView.getTxtNombreCrearUsuario().getText().trim();
        String telefono = crearUsuarioView.getTxtTelefonoCrearUsuario().getText().trim();
        String correo = crearUsuarioView.getTxtCorreoElectronico().getText().trim();
        CiudadesUsuario ciudad=  (CiudadesUsuario) crearUsuarioView.getCbxCiudad().getSelectedItem();
        String calleP = crearUsuarioView.getTxtCallePrincipal().getText().trim();
        
        if ( crearUsuarioView.getCbxCiudad().getItemCount() == 0){
                throw new ValidarCamposException ("Error- Autor no registrado");
            }
        
        if( cedula.isEmpty()|| nombre.isEmpty() || telefono.isEmpty() || correo.isEmpty() || calleP.isEmpty()){
            throw new ValidarCamposException("Error- Campos vacios");
        }
        
        if(cedula.length() != 10){
            throw new CedulaInvalidaException("Error - cedula invalida");
        }

        Usuario usuario = usuarioDAO.buscar(cedula);

        if (usuario != null) {

            crearUsuarioView.mostrarInformacion("Ya existe un usuario con esa cédula");
                    

        } else {

            Usuario nuevoUsuario = new Usuario(
                    nombre,
                    cedula,
                    telefono,
                    correo,
                    ciudad,
                    calleP
            );

            usuarioDAO.crear(nuevoUsuario);

            crearUsuarioView.mostrarInformacion("Usuario creado correctamente");
                    

            crearUsuarioView.getTxtCedulaCrearUsuario().setText("");
            crearUsuarioView.getTxtNombreCrearUsuario().setText("");
            crearUsuarioView.getTxtTelefonoCrearUsuario().setText("");
            crearUsuarioView.getTxtCallePrincipal().setText("");
            crearUsuarioView.getTxtCorreoElectronico().setText("");
            
            
        }
     }catch( ValidarCamposException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
     }catch ( CedulaInvalidaException e){
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    }

    public void configurarEventosCrearUsuario() {

        crearUsuarioView.getBtnCrear().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearUsuario();
            }
        });
    }

    public void buscarUsuario() {
     try{
        String cedula = buscarUsuarioView.getTxtCedulaBuscarUsuarioView().getText().trim();
        if ( cedula.isEmpty()){
            throw new ValidarCamposException("Error- campos vacios");
        }
        if(cedula.length() != 10){
            throw new CedulaInvalidaException("Error - cedula invalida");
        } 

        Usuario usuario = usuarioDAO.buscar(cedula);

        if (usuario != null) {

            buscarUsuarioView.getTxtNombreBuscarUsuarioView().setText(usuario.getNombre());
            buscarUsuarioView.getTxtTelefonoBuscarUsuarioView().setText(usuario.getTelefono());     
            buscarUsuarioView.getTxtCorreoElectronico().setText(usuario.getCorreo());   
            buscarUsuarioView.getTxtCiudad().setText(usuario.getCiudadesUsuario().toString());
            buscarUsuarioView.getTxtCallePrincipal().setText(usuario.getCallePrincipal());

        } else {

            buscarUsuarioView.mostrarInformacion("No se encontró el usuario");
                    

        }
     }catch(ValidarCamposException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
     }catch(CedulaInvalidaException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
     }
    }

    public void configurarEventosBuscarUsuario() {

        buscarUsuarioView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                buscarUsuario();

            }
        });

    }

    public void buscarUsuarioActualizar() {
     try{
        String cedula = actualizarUsuarioView.getTxtCedulaActualizarUsuario().getText().trim();
                
        if ( cedula.isEmpty()){
            throw new ValidarCamposException("Error- campos vacios");
        }
        if(cedula.length() != 10){
            throw new CedulaInvalidaException("Error - cedula invalida");
        }
        Usuario usuario = usuarioDAO.buscar(cedula);

        if (usuario != null) {

            actualizarUsuarioView.getTxtNombreActualizarUsuario().setText(usuario.getNombre());                  
            actualizarUsuarioView.getTxtTelefonoActualizarUsuario().setText(usuario.getTelefono());
            actualizarUsuarioView.getTxtCorreoElectronico().setText(usuario.getCorreo());   
            actualizarUsuarioView.getTxtCiudad().setText(usuario.getCiudadesUsuario().toString());
            actualizarUsuarioView.getTxtCallePrincipal().setText(usuario.getCallePrincipal());
                    

        } else {

            actualizarUsuarioView.mostrarInformacion("No se encontró el usuario");
                    
        }
     }catch(ValidarCamposException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
         
     }catch(CedulaInvalidaException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
     }

    }

    public void configurarEventosBuscarActualizarUsuario() {

        actualizarUsuarioView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                buscarUsuarioActualizar();

            }
        });

    }

    public void actualizarUsuario() {
     
     try{
        String cedula = actualizarUsuarioView.getTxtCedulaActualizarUsuario().getText().trim();
        
        if ( cedula.isEmpty()){
            throw new ValidarCamposException("Error - campos vacios");
        }
        if(cedula.length() != 10){
            throw new CedulaInvalidaException("Error - cedula invalida");
        }
        Usuario usuario = usuarioDAO.buscar(cedula);

        if (usuario == null) {
             throw new UsuarioNoEncontradoException("No se encontró el usuario");
         }
            String nombre = actualizarUsuarioView.getTxtNombreActualizarUsuario().getText();      
            String telefono = actualizarUsuarioView.getTxtTelefonoActualizarUsuario().getText();
            String correo = actualizarUsuarioView.getTxtCorreoElectronico().getText().trim();
            CiudadesUsuario ciudad=  (CiudadesUsuario) actualizarUsuarioView.getCbxCiudad().getSelectedItem();
            String calleP = actualizarUsuarioView.getTxtCallePrincipal().getText().trim();
            
            if( nombre.isEmpty() || telefono.isEmpty() || correo.isEmpty() || calleP.isEmpty()){
                throw new ValidarCamposException("Error - campos vacios");
            }
        
        
        int respuesta = JOptionPane.showConfirmDialog(
                actualizarUsuarioView,
                "¿Deseas actualizar el usuario?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {

            
            Usuario usuarioActualizado = new Usuario();

            usuarioActualizado.setCedula(cedula);
            usuarioActualizado.setNombre(nombre);
            usuarioActualizado.setTelefono(telefono);
            usuarioActualizado.setCorreo(correo);
            usuarioActualizado.setCiudadesUsuario(ciudad);
            usuarioActualizado.setCallePrincipal(calleP);

            usuarioDAO.actualizar(cedula, usuarioActualizado);

            actualizarUsuarioView.mostrarInformacion("Usuario actualizado correctamente");
                    
        }
     }catch(ValidarCamposException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
         
     }catch( UsuarioNoEncontradoException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
     }catch(CedulaInvalidaException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
     }

    }

    public void configurarEventosActualizarUsuario() {

        actualizarUsuarioView.getBtnActualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                
                
                actualizarUsuario();

            }
        });

    }

    public void buscarUsuarioEliminar() {
     
     try{
        String cedula = eliminarUsuarioview.getTxtCedulaEliminarUsuario().getText().trim();
                
        if ( cedula.isEmpty()){
            throw new ValidarCamposException("Error - campos vacios");
        }
        if(cedula.length() != 10){
            throw new CedulaInvalidaException("Error - cedula invalida");
        }
        Usuario usuario = usuarioDAO.buscar(cedula);

        if (usuario != null) {

            eliminarUsuarioview.getTxtNombreEliminarUsuario().setText(usuario.getNombre());
            eliminarUsuarioview.getTxtTelfonoEliminarUsuario().setText(usuario.getTelefono());
            eliminarUsuarioview.getTxtCorreoElectronico().setText(usuario.getCorreo());   
            eliminarUsuarioview.getTxtCiudad().setText(usuario.getCiudadesUsuario().toString());
            eliminarUsuarioview.getTxtCallePrincipal().setText(usuario.getCallePrincipal()); 
        } else {

            eliminarUsuarioview.mostrarInformacion("No se encontró el usuario");

        }
     }catch(ValidarCamposException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
     }catch (CedulaInvalidaException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
     }
    }

    public void configurarEventosBuscarEliminarUsuario() {

        eliminarUsuarioview.getBtnBuscarEliminarUsuario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                buscarUsuarioEliminar();

            }
        });

    }

    public void eliminarUsuario() {
     
     try{
        String cedula = eliminarUsuarioview.getTxtCedulaEliminarUsuario().getText().trim();
        
        if ( cedula.isEmpty()){
            throw new ValidarCamposException ("Error- campos vacios");
        }
        if(cedula.length() != 10){
            throw new CedulaInvalidaException("Error - cedula invalida");
        }
                

        int respuesta = JOptionPane.showConfirmDialog(
                eliminarUsuarioview,
                "¿Deseas eliminar el usuario?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {

            usuarioDAO.eliminar(cedula);

            eliminarUsuarioview.mostrarInformacion(
                    "Usuario eliminado correctamente");

            eliminarUsuarioview.getTxtCedulaEliminarUsuario().setText("");
            eliminarUsuarioview.getTxtNombreEliminarUsuario().setText("");
            eliminarUsuarioview.getTxtTelfonoEliminarUsuario().setText("");
            eliminarUsuarioview.getTxtCorreoElectronico().setText("");
            eliminarUsuarioview.getTxtCiudad().setText("");
            eliminarUsuarioview.getTxtCallePrincipal().setText("");
        }
     }catch(ValidarCamposException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
         
     }catch (CedulaInvalidaException e){
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    }

    public void configurarEventosEliminarUsuario() {

        eliminarUsuarioview.getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                eliminarUsuario();

            }
        });

    }

    public void listarUsuarios() {
        List<Usuario> usuarios = usuarioDAO.listar();
        listarUsuarioView.cargarDatos(usuarios);
    }

    public void configurarEventosListarUsuarios() {

        listarUsuarioView.getBtnListar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarUsuarios();
            }
        });

    }

}
