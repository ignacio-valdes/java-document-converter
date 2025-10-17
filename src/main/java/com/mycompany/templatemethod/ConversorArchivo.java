/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.templatemethod;
import java.io.IOException;

/**
 *
 * @author igxnxcio
 */
public abstract class ConversorArchivo {
    
    /*
    * Este es el Método Plantilla. Define el orden exacto de los pasos a realizarse en la conversion.
    * Es final para que las clases hijas no puedan alterar el orden de los pasos.
    */
    public final void convertir (String archivoEntrada, String archivoSalida) throws IOException {
    
            // Abre el archivo inicial.
            prepararDatos(archivoEntrada);
            
            // Lee el contenido del archivo.
            String contenido = extraerContenido();
            
            // Escribe el contenido anteriormente encontrado en un archivo nuevo.
            escribirContenido(archivoSalida, contenido);
            
            // Cierra todos los archivos
            cerrarDatos();
            
            System.out.println("Conversion completada");
    }
    
    /*
    * Métodos obligatorios que las clases concretas (hijas) deben 
    * rellenar con la lógica específica de cada formato.
    */
    
    // Preparar el archivo que se va a leer.
    protected abstract void prepararDatos (String rutaArchivo) throws IOException;
    
    // Sacar texto u otro contenido del archivo.
    protected abstract String extraerContenido () throws IOException;
    
    // Crear un nuevo archivo y escribir el contenido en él.
    protected abstract void escribirContenido (String rutaArchivo, String contenido) throws IOException;
    
    // Cerrar cualquier archivo que haya quedado abierto.
    protected abstract void cerrarDatos () throws IOException;
    
}
