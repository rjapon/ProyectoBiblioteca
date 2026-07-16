/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.proyectobiblioteca.dao;

import ec.edu.ups.proyectobiblioteca.models.Prestamo;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel Maza
 */
public class PrestamoDAOArchivo implements PrestamoDAO {
    
    private String ruta = "Archivos/prestamo.ups";
    private static final int TAM_ESTADO = 20;
    private static final int TAM_FECHA = 10;

    private static final int TAM_ISBN = 13;
    private static final int TAM_CEDULA = 10;
    private LibroDAO libroDAO;
    private UsuarioDAO usuarioDAO;
    
    private static final int TAM_REGISTRO= 4+(TAM_FECHA * 2)+(TAM_FECHA * 2)+(TAM_ESTADO * 2)+(TAM_ISBN * 2)+(TAM_CEDULA * 2)+1;

    public PrestamoDAOArchivo(LibroDAO libroDAO, UsuarioDAO usuarioDAO) {
        this.libroDAO = libroDAO;
        this.usuarioDAO = usuarioDAO;
    }
    
    
    private String leerTexto(RandomAccessFile archivo, int longitud) throws IOException{
        
        char[] caracteres  = new char[longitud];
        
        for(int i = 0; i<longitud ; i++){
            caracteres[i] = archivo.readChar();
        }
        
         return new String(caracteres).trim();
    }
    
    private void escribirTexto(RandomAccessFile  archivo, String texto, int longitud) throws IOException{
        
        StringBuilder sb = new StringBuilder(texto == null ? "" : texto);

        sb.setLength(longitud);

        archivo.writeChars(sb.toString());
    }
    private void escribirPrestamo(RandomAccessFile archivo, Prestamo prestamo) throws IOException{
        
        archivo.writeInt(prestamo.getCodigo());
        escribirTexto(archivo,prestamo.getFechaPrestamo().toString(),TAM_FECHA);
        escribirTexto(archivo,prestamo.getFechaDevolucion().toString(),TAM_FECHA);
        escribirTexto(archivo,prestamo.getEstado(),TAM_ESTADO);
        escribirTexto(archivo, prestamo.getLibro().getISBN(),TAM_ISBN);
        escribirTexto(archivo,prestamo.getUsuario().getCedula(),TAM_CEDULA);
        
        archivo.writeBoolean(true);
    }
    
    
    @Override
    public void crear(Prestamo prestamo) {
        
         try (RandomAccessFile archivo = new RandomAccessFile(ruta, "rw")) {

            archivo.seek(archivo.length());

            escribirPrestamo(archivo, prestamo);
            

        } catch (IOException e) {

            System.out.println("Error -al guardar prestamo");

        }
    
    }
    

    @Override
    public Prestamo buscar(int codigo) {
        Prestamo encontrado = null;


    try(RandomAccessFile archivo = new RandomAccessFile(ruta,"r")){
       
        long cantidad = archivo.length()/TAM_REGISTRO;


        for(long i=0;i<cantidad;i++){


            archivo.seek(i*TAM_REGISTRO);


            int codigoLeido = archivo.readInt();


            String fechaPrestamo =leerTexto(archivo,TAM_FECHA);
                    
            String fechaDevolucion =leerTexto(archivo,TAM_FECHA);

            String estado =leerTexto(archivo,TAM_ESTADO);
                    
            String isbn =leerTexto(archivo,TAM_ISBN);
                    

            String cedula =leerTexto(archivo,TAM_CEDULA);
                    
            boolean activo =archivo.readBoolean();
                    

            if(activo && codigoLeido == codigo){


                encontrado = new Prestamo();


                encontrado.setCodigo(codigoLeido);


                encontrado.setFechaPrestamo(LocalDate.parse(fechaPrestamo));
                    
                
                encontrado.setFechaDevolucion( LocalDate.parse(fechaDevolucion));
                   
                
                encontrado.setEstado(estado);

                encontrado.setLibro(libroDAO.buscar(isbn));
                    
                encontrado.setUsuario(usuarioDAO.buscar(cedula));
                    
                


                break;
            }

        }


    }catch(IOException e){

        System.out.println("Error al buscar prestamo");
    }


    return encontrado;
    }

    @Override
    public void actualizar(int codigo, Prestamo prestamo) {
       try(RandomAccessFile archivo =
        new RandomAccessFile(ruta,"rw")){

        long cantidad =archivo.length() / TAM_REGISTRO;
                

        for(long i = 0; i < cantidad; i++){


            long posicion = i * TAM_REGISTRO;

            archivo.seek(posicion);

            int codigoLeido =archivo.readInt();
                    
            if(codigoLeido == codigo){


                archivo.seek(posicion);


                escribirPrestamo(archivo, prestamo);


                break;
            }


        }


    }catch(IOException e){

        System.out.println("Error al actualizar prestamo");

    }
    }

    @Override
    public void eliminar(int codigo) {
        try(RandomAccessFile archivo =new RandomAccessFile(ruta,"rw")){
        
        long cantidad = archivo.length()/TAM_REGISTRO;
           
        for(long i=0;i<cantidad;i++){


            long posicion=i*TAM_REGISTRO;


            archivo.seek(posicion);

            int codigoLeido =archivo.readInt();
                


            archivo.skipBytes(
                (TAM_FECHA*2)+
                (TAM_FECHA*2)+
                (TAM_ESTADO*2)+
                (TAM_ISBN*2)+
                (TAM_CEDULA*2)
            );


            boolean activo =archivo.readBoolean();
                
            if(activo && codigoLeido==codigo){
                archivo.seek(
                    posicion+
                    4+
                    (TAM_FECHA*2)+
                    (TAM_FECHA*2)+
                    (TAM_ESTADO*2)+
                    (TAM_ISBN*2)+
                    (TAM_CEDULA*2)
                );


                archivo.writeBoolean(false);


                break;
            }
        }


    }catch(IOException e){

        System.out.println("Error al eliminar prestamo");
    }
    }

    @Override
    public List<Prestamo> listar() {
        List<Prestamo> lista =new ArrayList<>();
            


    try(RandomAccessFile archivo =new RandomAccessFile(ruta,"r")){
        
        long cantidad =archivo.length()/TAM_REGISTRO;
                
        for(long i=0;i<cantidad;i++){

            archivo.seek(i*TAM_REGISTRO);

            int codigo = archivo.readInt();
                   
            LocalDate fechaPrestamo =LocalDate.parse(leerTexto(archivo,TAM_FECHA));
                
            LocalDate fechaDevolucion =LocalDate.parse(leerTexto(archivo,TAM_FECHA));
                     
            String estado =leerTexto(archivo,TAM_ESTADO);
               

            String isbn =leerTexto(archivo,TAM_ISBN);
               
            String cedula = leerTexto(archivo,TAM_CEDULA);
               

            boolean activo = archivo.readBoolean();
              
            if(activo){

                Prestamo p = new Prestamo();


                p.setCodigo(codigo);

                p.setFechaPrestamo(fechaPrestamo);

                p.setFechaDevolucion(fechaDevolucion);

                p.setEstado(estado);

                p.setLibro(libroDAO.buscar(isbn)
                    
                );

                p.setUsuario(usuarioDAO.buscar(cedula)
                    
                );


                lista.add(p);
            }
        }

    }catch(IOException e){

        System.out.println("Error al listar prestamos");
    }


    return lista;
    }
    
}
