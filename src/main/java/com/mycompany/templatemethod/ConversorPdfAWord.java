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
 *
 * @author igxnxcio
 */
public class ConversorPdfAWord extends ConversorArchivo {

    private PDDocument documentoPdf;

    @Override
    protected void prepararDatos(String rutaArchivo) throws IOException {
        System.out.println("Abriendo archivo PDF: " + rutaArchivo);
        File archivo = new File(rutaArchivo);
        this.documentoPdf = PDDocument.load(archivo);
    }

    @Override
    protected String extraerContenido() throws IOException {

        System.out.println("Extrayendo el texto del PDF");

        PDFTextStripper stripper = new PDFTextStripper();
        return stripper.getText(this.documentoPdf);
    }

    @Override
    protected void escribirContenido(String rutaArchivo, String contenido) throws IOException {
        System.out.println("Creando y escribiendo su archivo Word en: " + rutaArchivo);
        try (XWPFDocument documentoWord = new XWPFDocument(); FileOutputStream out = new FileOutputStream(rutaArchivo)) {

            XWPFParagraph parrafo = documentoWord.createParagraph();
            XWPFRun run = parrafo.createRun();
            run.setText(contenido);

            documentoWord.write(out);
        }
    }

    @Override
    protected void cerrarDatos() throws IOException {
        System.out.println("Cerrando el documento PDF.");
        if (this.documentoPdf != null) {
            this.documentoPdf.close();
        }
    }
}
