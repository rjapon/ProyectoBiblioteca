/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.proyectobiblioteca.models;

import ec.edu.ups.proyectobiblioteca.enums.CiudadesUsuario;

/**
 *
 * @author Asus
 */
public class Usuario {

    private String nombre;
    private String cedula;
    private String telefono;
    private String correo;
    private CiudadesUsuario ciudadesUsuario;
    private String callePrincipal;

    public Usuario() {
    }

    public Usuario(String nombre, String cedula,String telefono,String correo,CiudadesUsuario ciudadesUsuario,String callePrincipal) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.correo= correo;
        this.ciudadesUsuario= ciudadesUsuario;
        this.callePrincipal = callePrincipal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public CiudadesUsuario getCiudadesUsuario() {
        return ciudadesUsuario;
    }

    public void setCiudadesUsuario(CiudadesUsuario ciudadesUsuario) {
        this.ciudadesUsuario = ciudadesUsuario;
    }

    public String getCallePrincipal() {
        return callePrincipal;
    }

    public void setCallePrincipal(String callePrincipal) {
        this.callePrincipal = callePrincipal;
    }
    
    
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", cedula=" + cedula + ", telefono=" + telefono + '}';
    }
}
