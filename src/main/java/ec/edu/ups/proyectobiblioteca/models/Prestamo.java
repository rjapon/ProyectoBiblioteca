/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.proyectobiblioteca.models;

import java.util.Date;

/**
 *
 * @author Asus
 */
public class Prestamo {

    private int codigo;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private String estado;
    private Libro libro;
    private Usuarios usuario;

}
