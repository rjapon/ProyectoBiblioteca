/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.proyectobiblioteca.dao;

import ec.edu.ups.proyectobiblioteca.enums.CiudadesUsuario;
import ec.edu.ups.proyectobiblioteca.models.Usuario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel Maza
 */
public class UsuarioDAOArchivo implements  UsuarioDAO {
    
    
    private static final int TAM_NOMBRE = 50;
    private static final int TAM_CEDULA = 10;
    private static final int TAM_TELEFONO = 15;
    private static final int TAM_CORREO = 50;
    private static final int TAM_CIUDAD=100;
    private static final int TAM_CALLEPRINCIPAL=100;

    private static final int TAM_REGISTRO= (TAM_CEDULA * 2)+ (TAM_NOMBRE * 2)+ (TAM_TELEFONO * 2)+ (TAM_CORREO * 2)+ (TAM_CIUDAD * 2) +(TAM_CALLEPRINCIPAL * 2)+1
            ;       
            
    
    private String ruta = "Archivos/usuarios.ups";
    
    private void escribirTexto(RandomAccessFile  archivo,String texto, int longitud) throws IOException{
        
        StringBuilder sb = new StringBuilder(texto == null ? "" : texto);

        sb.setLength(longitud);

        archivo.writeChars(sb.toString());
    }
    private String leerTexto(RandomAccessFile archivo, int longitud) throws IOException{
        
        char[] caracteres  = new char[longitud];
        
        for(int i = 0; i<longitud ; i++){
            caracteres[i] = archivo.readChar();
        }
        
         return new String(caracteres).trim();
    }
    
    private void escribirUsuario(RandomAccessFile archivo, Usuario usuario) throws IOException{
        
        escribirTexto(archivo,usuario.getNombre(),TAM_NOMBRE);
        escribirTexto(archivo,usuario.getCedula(),TAM_CEDULA);
        escribirTexto(archivo,String.valueOf(usuario.getTelefono()),TAM_TELEFONO);
        escribirTexto(archivo,usuario.getCorreo(),TAM_CORREO);
        escribirTexto(archivo,usuario.getCiudadesUsuario().name(),TAM_CIUDAD);
        escribirTexto(archivo,usuario.getCallePrincipal(),TAM_CALLEPRINCIPAL);
        
        archivo.writeBoolean(true);
    }
    
    
    @Override
    public void crear(Usuario usuario) {
       try (RandomAccessFile archivo = new RandomAccessFile(ruta, "rw")) {

            archivo.seek(archivo.length());

            escribirUsuario(archivo, usuario);
            

        } catch (IOException e) {

            System.out.println("Error -al guardar usuario");

        }

    }

    @Override
    public Usuario buscar(String cedula)  {
        
      Usuario encontrado = null;
      try 

        (RandomAccessFile archivo =new RandomAccessFile(ruta, "r")){
         
        long cantidad = archivo.length() / TAM_REGISTRO;

        for( long i = 0; i< cantidad ; i++){
            archivo.seek( i * TAM_REGISTRO );
            
            String nombre = leerTexto(archivo, TAM_NOMBRE);
            String cedulaLeida = leerTexto(archivo, TAM_CEDULA);
            int telefono = Integer.parseInt(leerTexto(archivo, TAM_TELEFONO));
            String correo = leerTexto(archivo, TAM_CORREO);
            String ciudad = leerTexto(archivo, TAM_CIUDAD);
            String calle = leerTexto(archivo, TAM_CALLEPRINCIPAL);
            
            boolean activo = archivo.readBoolean();
            
            if( activo && cedulaLeida.equals(cedula)){
                
                encontrado = new Usuario();
                encontrado.setNombre(nombre);
                encontrado.setCedula(cedulaLeida);
                encontrado.setTelefono(telefono);
                encontrado.setCorreo(correo);
                encontrado.setCiudadesUsuario(CiudadesUsuario.valueOf(ciudad));
                encontrado.setCallePrincipal(calle);
                break;
            }
        }
       

    } catch (IOException e) {
         System.out.println("Error -al buscar usuario");
    }

    return encontrado;
      
    }

    @Override
    public void actualizar(String cedula, Usuario datos) {
       
       
        try 

        (RandomAccessFile archivo =new RandomAccessFile(ruta, "rw")){
                
        long cantidad = archivo.length() / TAM_REGISTRO;
        
        for( long i= 0; i< cantidad;i++){
            long posicion = i * TAM_REGISTRO;

            archivo.seek(posicion);

            leerTexto(archivo, TAM_NOMBRE);
            String cedulaLeida = leerTexto(archivo, TAM_CEDULA);
            leerTexto(archivo, TAM_TELEFONO);
            leerTexto(archivo, TAM_CORREO);
            leerTexto(archivo, TAM_CIUDAD);
            leerTexto(archivo, TAM_CALLEPRINCIPAL);
            
            boolean activo = archivo.readBoolean();

            if ( activo && cedulaLeida.equals(cedula)) {

                archivo.seek(posicion);

                escribirUsuario(archivo, datos);

                break;
            }

        
        }

        
    } catch (IOException e) {
         System.out.println("Error -al actualizar usuario");
    }
    }

    @Override
    public void eliminar(String cedula) {
        

    try (RandomAccessFile archivo = new RandomAccessFile(ruta, "rw")){
      
        long cantidad = archivo.length() / TAM_REGISTRO;
        
        for(long i =0; i< cantidad ;i++){
            long posicion = i * TAM_REGISTRO;
            archivo.seek(posicion);
            
            leerTexto(archivo, TAM_NOMBRE);
            String cedulaLeida = leerTexto(archivo, TAM_CEDULA);

            archivo.skipBytes((TAM_TELEFONO * 2)+ (TAM_CORREO * 2)+ (TAM_CIUDAD * 2)+ (TAM_CALLEPRINCIPAL * 2));
                   
            boolean activo = archivo.readBoolean();

            if (activo && cedulaLeida.equals(cedula)) {

                archivo.seek(posicion+ (TAM_CEDULA * 2)+ (TAM_NOMBRE * 2)+ (TAM_TELEFONO * 2)+ (TAM_CORREO * 2)+ (TAM_CIUDAD * 2)+ (TAM_CALLEPRINCIPAL * 2));
                        
                archivo.writeBoolean(false);

                break;
            }           
            
        }
        
    }  catch (IOException e) {
         System.out.println("Error -al eliminar usuario");
    }

    }

    @Override
    public List<Usuario> listar() {
        
        List<Usuario> lista = new ArrayList<>();
        try (RandomAccessFile archivo = new RandomAccessFile(ruta, "r")) {
            long cantidad = archivo.length() / TAM_REGISTRO;
            
            for (long i = 0; i < cantidad; i++) {

            archivo.seek(i * TAM_REGISTRO);

            Usuario usuario = new Usuario();

            usuario.setNombre(leerTexto(archivo, TAM_NOMBRE));
            usuario.setCedula(leerTexto(archivo, TAM_CEDULA));
            usuario.setTelefono(Integer.parseInt(leerTexto(archivo, TAM_TELEFONO)));
            usuario.setCorreo(leerTexto(archivo, TAM_CORREO));

            usuario.setCiudadesUsuario(CiudadesUsuario.valueOf(leerTexto(archivo, TAM_CIUDAD)));
                    
                          

            usuario.setCallePrincipal(leerTexto(archivo, TAM_CALLEPRINCIPAL));
                    
            boolean activo = archivo.readBoolean();
            if(activo){
                lista.add(usuario);
            }
        }
        }catch (IOException e) {

        System.out.println("Error al listar usuarios");

    }

    return lista;
    }
     
}
