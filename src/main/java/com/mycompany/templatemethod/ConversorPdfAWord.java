/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.templatemethod;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Clase "concreta" que sabe como hacer el trabajo de convertir un PDF a un Word.
 * @author igxnxcio
 */
public class ConversorPdfAWord extends ConversorArchivo {

    // Esta variable guarda el documento pdf
    private PDDocument documentoPdf;

    /**
     * Implementación de abrir el archivo PDF.
     * @param rutaArchivo
     * @throws java.io.IOException
     */
    @Override
    protected void prepararDatos(String rutaArchivo) throws IOException {
        System.out.println("Abriendo archivo PDF: " + rutaArchivo);
        File archivo = new File(rutaArchivo);
        // Carga el archivo PDF y lo guarda en la variable
        this.documentoPdf = PDDocument.load(archivo);
    }

    /**
     * Implementación de sacar el texto o contenido del PDF.
     * @return 
     * @throws java.io.IOException
     */
    @Override
    protected String extraerContenido() throws IOException {

        System.out.println("Extrayendo el texto del PDF");

        PDFTextStripper stripper = new PDFTextStripper();
        return stripper.getText(this.documentoPdf);
    }

    /**
     * Implementación de escribir el texto en un archivo Word.
     * @param rutaArchivo
     * @param contenido
     * @throws java.io.IOException
     */
    @Override
    protected void escribirContenido(String rutaArchivo, String contenido) throws IOException {
        System.out.println("Creando y escribiendo su archivo Word en: " + rutaArchivo);
        // Este "try" se asegura de que los archivos se cierren solos.
        try (XWPFDocument documentoWord = new XWPFDocument(); FileOutputStream out = new FileOutputStream(rutaArchivo)) {

            // Creamos un párrafo nuevo dentro del documento Word.
            XWPFParagraph parrafo = documentoWord.createParagraph();
            // creamos un "run", que es donde se escribe el texto dentro del párrafo.
            XWPFRun run = parrafo.createRun();
            // Agrega el texto que sacamos del PDF.
            run.setText(contenido);

            // Guarda el documento Word.
            documentoWord.write(out);
        }
    }

    /**
     * Implementación de cerrar el archivo PDF
     * @throws IOException 
     */
    @Override
    protected void cerrarDatos() throws IOException {
        System.out.println("Cerrando el documento PDF.");
        // Se asegura de que el documento exista antes de intentar cerrarlo.
        if (this.documentoPdf != null) {
            this.documentoPdf.close();
        }
    }
}
