/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package ec.edu.ups.proyectobiblioteca.enums;

/**
 *
 * @author Miguel Maza
 */
public enum CiudadesUsuario {
    CUENCA,
    GIRON,
    GUALACEO,
    PAUTE,
    SIGSIG,
    CHORDELEG,
    EL_PAN,
    GUACHAPALA,
    NABON,
    OÑA,
    PUCARA,
    SAN_FERNANDO,
    SANTA_ISABEL,
    SEVILLA_DE_ORO,
    CAMILO_PONCE_ENRIQUEZ;
    
    @Override    
    public String toString() {
         return name().replace("_", " ");
                
    }
}
