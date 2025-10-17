/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.templatemethod;
import java.io.IOException;

/**
 *
 * @author igxnxcio
 */
public class TemplateMethod {

    public static void main(String[] args) {
        
        // Definimos los nombres de los archivos de entrada y salida.
        String archivoEntrada = "documento.pdf";
        String archivoSalida = "documento_convertido.docx";
        
        // Creamos nuestro "trabajador" especializado en convertir de PDF a Word.
        ConversorArchivo conversor = new ConversorPdfAWord();
        
        // Usamos un bloque "try-catch" para manejar posibles errores con los archivos.
        try {
            // Llamamos al método principal para que inicie todo el proceso.
            conversor.convertir(archivoEntrada, archivoSalida);
        } catch (IOException e) {
            // Si ocurre un error con los archivos, se imprime un mensaje en la consola.
            System.out.println("Ocurrio un error durante la conversión: " + e.getMessage());
        }
    }
}
