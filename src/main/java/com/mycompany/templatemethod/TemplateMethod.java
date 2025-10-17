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
        
        String archivoEntrada = "documento.pdf";
        String archivoSalida = "documento_convertido.docx";
        
        ConversorArchivo conversor = new ConversorPdfAWord();
        
        try {
            conversor.convertir(archivoEntrada, archivoSalida);
        } catch (IOException e) {
            System.out.println("Ocurrio un error durante la conversión: " + e.getMessage());
        }
    }
}
