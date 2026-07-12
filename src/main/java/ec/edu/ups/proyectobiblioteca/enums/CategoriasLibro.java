/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package ec.edu.ups.proyectobiblioteca.enums;

/**
 *
 * @author Asus
 */
public enum CategoriasLibro {

    Novela,
    Cuento,
    Ciencia_Ficcion,
    Fantasia,
    Romance,
    Misterio_Y_Suspenso,
    Terror,
    Aventuras,
    Drama,
    Fabulas,
    Biografías_Y_Autobiografias,
    Historia,
    Ciencia,
    Filosofia,
    Psicologia,
    Economia,
    Politica,
    Religion,
    Autoayuda,
    Divulgacion,
    Viajes,
    Cocina,
    Libros_De_Texto,
    Manuales,
    Enciclopedias,
    Diccionarios,
    Atlas,
    Guias_De_Estudio,
    Poesia,
    Teatro,
    Ensayo,
    Libros_Ilustrados,
    Cuentos_Infantiles,
    Novelas_Juveniles,
    Libros_educativos_para_niños,
    Informatica,
    Ingenieria,
    Medicina,
    Derecho,
    Administracion,
    Marketing;

    @Override
    public String toString() {
        return name()
                .replace("_", " ");
    }

}
