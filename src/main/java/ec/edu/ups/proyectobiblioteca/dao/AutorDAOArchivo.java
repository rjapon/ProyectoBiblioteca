/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.proyectobiblioteca.dao;

import ec.edu.ups.proyectobiblioteca.enums.NacionalidadesAutor;
import ec.edu.ups.proyectobiblioteca.models.Autor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel Maza
 */
public class AutorDAOArchivo implements AutorDAO{
    
    private String ruta = "Archivos/autores.ups";
    private static final int TAM_CODIGO = 4;
    private static final int TAM_NOMBRE = 60;
    private static final int TAM_NACIONALIDAD = 30;
    
    private static final int TAM_REGISTRO = (TAM_CODIGO )+ (TAM_NOMBRE * 2) + (TAM_NACIONALIDAD * 2) +1;
    
    private void escribirTexto(RandomAccessFile  archivo, String texto, int longitud) throws IOException{
        
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
    private void escribirAutor(RandomAccessFile archivo, Autor autor) throws IOException{
        
        archivo.writeInt(autor.getCodigo());
        escribirTexto(archivo,autor.getNombre(),TAM_NOMBRE);
        escribirTexto(archivo,autor.getNacionalidad().name(),TAM_NACIONALIDAD);
        
        archivo.writeBoolean(true);
    }
    
    @Override
    public void crear(Autor autor) {
         try (RandomAccessFile archivo = new RandomAccessFile(ruta, "rw")) {

            archivo.seek(archivo.length());

            escribirAutor(archivo, autor);
            

        } catch (IOException e) {

            System.out.println("Error -al guardar autor");

        }
    }

    @Override
    public Autor buscar(int codigo) {
        
      Autor encontrado = null;
      try 

        (RandomAccessFile archivo =new RandomAccessFile(ruta, "r")){
         
        long cantidad = archivo.length() / TAM_REGISTRO;

        for( long i = 0; i< cantidad ; i++){
            archivo.seek( i * TAM_REGISTRO );
            
            int codigoLeido = archivo.readInt();
            String nombre = leerTexto(archivo, TAM_NOMBRE);
            String nacionalidad = leerTexto(archivo, TAM_NACIONALIDAD);
           
            
            boolean activo = archivo.readBoolean();
            
            if( activo && codigoLeido == codigo){
                
                encontrado = new Autor();
                encontrado.setCodigo(codigo);
                encontrado.setNombre(nombre);
                encontrado.setNacionalidad(NacionalidadesAutor.valueOf(nacionalidad));
                
                break;
            }
        }
       

    } catch (IOException e) {
         System.out.println("Error -al buscar autor");
    }

    return encontrado;
      
    
    }

    @Override
    public void actualizar( Autor autor) {
       try 

        (RandomAccessFile archivo =new RandomAccessFile(ruta, "rw")){
                
        long cantidad = archivo.length() / TAM_REGISTRO;
        
        for( long i= 0; i< cantidad;i++){
            long posicion = i * TAM_REGISTRO;

            archivo.seek(posicion);
            int codigoLeido = archivo.readInt();
            
            archivo.skipBytes((TAM_NOMBRE * 2) + (TAM_NACIONALIDAD * 2));
            boolean activo = archivo.readBoolean();

            if ( activo && codigoLeido == autor.getCodigo()) {

                archivo.seek(posicion);

                escribirAutor(archivo, autor);

                break;
            }
        
        }

        
    } catch (IOException e) {
         System.out.println("Error -al actualizar autor");
    }
    }

    @Override
    public void eliminar(int codigo) {
        try (RandomAccessFile archivo = new RandomAccessFile(ruta, "rw")){
      
        long cantidad = archivo.length() / TAM_REGISTRO;
        
        for(long i =0; i< cantidad ;i++){
            long posicion = i * TAM_REGISTRO;
            archivo.seek(posicion);
            
            int codigoLeido = archivo.readInt();

            archivo.skipBytes((TAM_NOMBRE * 2)+ (TAM_NACIONALIDAD * 2));
                   
            boolean activo = archivo.readBoolean();

            if (activo && codigoLeido== codigo) {

                archivo.seek(posicion+ 4 + (TAM_NOMBRE * 2)+ (TAM_NACIONALIDAD * 2));
                        
                archivo.writeBoolean(false);

                break;
            }           
            
        }
        
    }  catch (IOException e) {
         System.out.println("Error -al eliminar autor");
    }

    }

    @Override
    public Autor buscarPorNombre(String nombre) {
       Autor encontrado = null;

    try (RandomAccessFile archivo = new RandomAccessFile(ruta, "r")) {

        long cantidad = archivo.length() / TAM_REGISTRO;

        for (long i = 0; i < cantidad; i++) {

            archivo.seek(i * TAM_REGISTRO);

            int codigo = archivo.readInt();

            String nombreLeido = leerTexto(archivo, TAM_NOMBRE);

            String nacionalidad = leerTexto(archivo, TAM_NACIONALIDAD);

            boolean activo = archivo.readBoolean();


            if (activo && nombreLeido.equalsIgnoreCase(nombre)) {

                encontrado = new Autor();

                encontrado.setCodigo(codigo);
                encontrado.setNombre(nombreLeido);
                encontrado.setNacionalidad(
                    NacionalidadesAutor.valueOf(nacionalidad)
                );

                break;
            }
        }

    } catch (IOException e) {
        System.out.println("Error al buscar autor por nombre");
    }

    return encontrado;
    }


    @Override
    public List<Autor> listar() {
        List<Autor> lista = new ArrayList<>();
        try (RandomAccessFile archivo = new RandomAccessFile(ruta, "r")) {
            long cantidad = archivo.length() / TAM_REGISTRO;
            
            for (long i = 0; i < cantidad; i++) {

            archivo.seek(i * TAM_REGISTRO);


           int codigo = archivo.readInt();

            String nombre = leerTexto(archivo, TAM_NOMBRE);

            String nacionalidad = leerTexto(archivo, TAM_NACIONALIDAD);

            boolean activo = archivo.readBoolean();


            if (activo) {

                Autor autor = new Autor();

                autor.setCodigo(codigo);
                autor.setNombre(nombre);
                autor.setNacionalidad(
                        NacionalidadesAutor.valueOf(nacionalidad)
                );

                lista.add(autor);
            }
        }
        }catch (IOException e) {

        System.out.println("Error al listar autores");

    }

    return lista;
    }
    
}
