/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoreinventorymanagementsystem;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Utility class for opening PDF files. This class provides methods to open PDF
 * files by ID or by file path.
 *
 * @author Liew Wen Yen
 */
public class OpenPdf {

    /**
     * Opens a PDF file by its ID.
     *
     * @param id the ID of the PDF file.
     * @throws IOException if an I/O error occurs.
     * @throws FileNotFoundException if the PDF file is not found.
     */
    public static void OpenById(String id) throws IOException {
        File pdfFile = new File(SalesUtils.BILL_PATH + id + ".pdf");
        if (pdfFile.exists()) {
            Desktop.getDesktop().open(pdfFile);
        } else {
            throw new FileNotFoundException("PDF file not found: " + pdfFile.getPath());
        }
    }

    /**
     * Opens a PDF file by its file path.
     *
     * @param filePath the file path of the PDF file.
     * @throws IOException if an I/O error occurs.
     * @throws FileNotFoundException if the PDF file is not found.
     */
    public static void OpenByPath(String filePath) throws IOException {
        File pdfFile = new File(filePath);
        if (pdfFile.exists()) {
            Desktop.getDesktop().open(pdfFile);
        } else {
            throw new FileNotFoundException("PDF file not found: " + pdfFile.getPath());
        }
    }

}
