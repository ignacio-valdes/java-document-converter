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
    
    public final void convertir (String archivoEntrada, String archivoSalida) throws IOException {
    
            prepararDatos(archivoEntrada);
            
            String contenido = extraerContenido();
            
            escribirContenido(archivoSalida, contenido);
            
            cerrarDatos();
            
            System.out.println("Conversion completada");
    }
    
    protected abstract void prepararDatos (String rutaArchivo) throws IOException;
    
    protected abstract String extraerContenido () throws IOException;
    
    protected abstract void escribirContenido (String rutaArchivo, String contenido) throws IOException;
    
    protected abstract void cerrarDatos () throws IOException;
    
}
