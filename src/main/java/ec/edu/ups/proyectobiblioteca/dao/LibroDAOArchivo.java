/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.proyectobiblioteca.dao;

import ec.edu.ups.proyectobiblioteca.enums.CategoriasLibro;
import ec.edu.ups.proyectobiblioteca.models.Autor;
import ec.edu.ups.proyectobiblioteca.models.Libro;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel Maza
 */
public class LibroDAOArchivo implements LibroDAO{
    
    private String ruta = "Archivos/libro.ups";
    private static final int TAM_ISBN = 13;
    private static final int TAM_TITULO = 100;
    private static final int TAM_EDITORIAL = 50;
    private static final int TAM_CATEGORIA = 30;
    private static final int TAM_FECHA = 10;
    private static final int TAM_CODIGO_AUTOR = 4;
    private AutorDAO autorDAO;
    
    private static final int TAM_REGISTRO = (TAM_ISBN *2)+ (TAM_TITULO * 2) + (TAM_EDITORIAL * 2) +1 +(TAM_CATEGORIA * 2)+ (TAM_CODIGO_AUTOR ) +(TAM_FECHA * 2) +1;

    public LibroDAOArchivo(AutorDAO autorDAO) {
        this.autorDAO = autorDAO;
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
    
    private void escribirLibro(RandomAccessFile archivo, Libro libro) throws IOException{
        
        
        escribirTexto(archivo,libro.getISBN(),TAM_ISBN);
        escribirTexto(archivo,libro.getTitulo(),TAM_TITULO);
        escribirTexto(archivo,libro.getEditorial(),TAM_EDITORIAL);
        archivo.writeBoolean(libro.isDisponible());
        escribirTexto(archivo,libro.getCategoria().name(),TAM_CATEGORIA);
        archivo.writeInt(libro.getAutor().getCodigo());
        escribirTexto(archivo,libro.getFechaPublicacion().toString(),TAM_FECHA);
            
    
        
        archivo.writeBoolean(true);
    }
    @Override
    public void crear(Libro libro) {
        try (RandomAccessFile archivo = new RandomAccessFile(ruta, "rw")) {

            archivo.seek(archivo.length());

            escribirLibro(archivo, libro);
            

        } catch (IOException e) {

            System.out.println("Error -al guardar libro");

        }
    }

    @Override
    public Libro buscar(String isbn) {
         Libro encontrado = null;
      try 

        (RandomAccessFile archivo =new RandomAccessFile(ruta, "r")){
         
        long cantidad = archivo.length() / TAM_REGISTRO;
        System.out.println("Buscando: " + isbn);
        for( long i = 0; i< cantidad ; i++){
            archivo.seek( i * TAM_REGISTRO );
            
            String isbnLeido = leerTexto(archivo,TAM_ISBN);
            String titulo = leerTexto(archivo, TAM_TITULO);
            String editorial = leerTexto(archivo,TAM_EDITORIAL);
            boolean disponible = archivo.readBoolean();
            String categoria = leerTexto(archivo,TAM_CATEGORIA);
            int codigoAutor = archivo.readInt();
            String fecha = leerTexto(archivo,TAM_FECHA);
            boolean activo = archivo.readBoolean();
            
            System.out.println("Leído: " + isbnLeido);
            if( activo && isbnLeido.equalsIgnoreCase(isbn)){
                
                encontrado = new Libro();
                encontrado.setISBN(isbnLeido);
                encontrado.setTitulo(titulo);
                encontrado.setEditorial(editorial);
                encontrado.setDisponible(disponible);
                encontrado.setCategoria(CategoriasLibro.valueOf(categoria));
                
                    
                Autor autor = autorDAO.buscar(codigoAutor);

                encontrado.setAutor(autor);
                encontrado.setFechaPublicacion(LocalDate.parse(fecha));
                
                break;
            }
        }
       

    } catch (IOException e) {
          e.printStackTrace();
    }

    return encontrado;
      
    }

    @Override
    public void actualizar(String isbn, Libro libro) {
        try 

        (RandomAccessFile archivo =new RandomAccessFile(ruta, "rw")){
                
        long cantidad = archivo.length() / TAM_REGISTRO;
        
        for( long i= 0; i< cantidad;i++){
            long posicion = i * TAM_REGISTRO;

            archivo.seek(posicion);

            
            String isbnLeido = leerTexto(archivo,TAM_ISBN);
            
            

            if (  isbnLeido.equalsIgnoreCase(isbn)) {

                archivo.seek(posicion);

                escribirLibro(archivo, libro);

                break;
            }
        
        }

        
    } catch (IOException e) {
         System.out.println("Error -al actualizar libro");
    }
    }

    @Override
    public void eliminar(String isbn) {
        try (RandomAccessFile archivo = new RandomAccessFile(ruta, "rw")){
      
        long cantidad = archivo.length() / TAM_REGISTRO;
        
        for(long i =0; i< cantidad ;i++){
            
            long posicion = i * TAM_REGISTRO;
            archivo.seek(posicion);
            
            String isbnLeido = leerTexto(archivo,TAM_ISBN);

            archivo.skipBytes((TAM_TITULO*2)
                    +(TAM_EDITORIAL*2)
                    +1
                    +(TAM_CATEGORIA*2)
                    +4
                    +(TAM_FECHA*2));
                   
            boolean activo = archivo.readBoolean();

            if (activo && isbnLeido.equalsIgnoreCase(isbn)) {

                archivo.seek(posicion+ +(TAM_ISBN*2)
                    +(TAM_TITULO*2)
                    +(TAM_EDITORIAL*2)
                    +1
                    +(TAM_CATEGORIA*2)
                    +4
                    +(TAM_FECHA*2));
                        
                archivo.writeBoolean(false);

                break;
            }           
            
        }
        
    }  catch (IOException e) {
         System.out.println("Error -al eliminar libro");
    }
    }

    @Override
    public void cambiarDisponibilidad(String isbn, boolean disponible) {
       try(RandomAccessFile archivo = new RandomAccessFile(ruta,"rw")){


        long cantidad = archivo.length()/TAM_REGISTRO;


        for(long i=0;i<cantidad;i++){


            long posicion=i*TAM_REGISTRO;


            archivo.seek(posicion);


            String isbnLeido = leerTexto(archivo,TAM_ISBN);



            if(isbnLeido.equals(isbn)){


                archivo.skipBytes(
                    (TAM_TITULO*2)
                    +(TAM_EDITORIAL*2)
                );


                archivo.writeBoolean(disponible);


                break;
            }
        }


    }catch(IOException e){

        System.out.println("Error cambiando disponibilidad");
    }
    }

    @Override
    public List<Libro> listar() {
        List<Libro> lista = new ArrayList<>();
        try (RandomAccessFile archivo = new RandomAccessFile(ruta, "r")) {
            long cantidad = archivo.length() / TAM_REGISTRO;
            
            for (long i = 0; i < cantidad; i++) {

            archivo.seek(i*TAM_REGISTRO);


            Libro libro = new Libro();


            libro.setISBN(
                leerTexto(archivo,TAM_ISBN)
            );


            libro.setTitulo(
                leerTexto(archivo,TAM_TITULO)
            );


            libro.setEditorial(
                leerTexto(archivo,TAM_EDITORIAL)
            );


            libro.setDisponible(
                archivo.readBoolean()
            );


            libro.setCategoria(
                CategoriasLibro.valueOf(
                    leerTexto(archivo,TAM_CATEGORIA)
                )
            );


            int codigoAutor = archivo.readInt();
             Autor autor = autorDAO.buscar(codigoAutor);

                libro.setAutor(autor);


            libro.setFechaPublicacion(
                LocalDate.parse(
                    leerTexto(archivo,TAM_FECHA)
                )
            );


            boolean activo = archivo.readBoolean();



            if(activo){

                lista.add(libro);
            }

        
        }
        }catch (IOException e) {

        System.out.println("Error al listar autores");

    }

    return lista;
    }
    
    
}
