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
 *
 * @author Liew Wen Yen
 */
public class OpenPdf {

    public static void OpenById(String id) throws IOException {
        File pdfFile = new File(SalesUtils.billPath + id + ".pdf");
        if (pdfFile.exists()) {
            Desktop.getDesktop().open(pdfFile);
        } else {
            throw new FileNotFoundException("PDF file not found: " + pdfFile.getPath());
        }
    }

    public static void OpenByPath(String filePath) throws IOException {

        File pdfFile = new File(filePath);
        if (pdfFile.exists()) {
            Desktop.getDesktop().open(pdfFile);
        } else {
            throw new FileNotFoundException("PDF file not found: " + pdfFile.getPath());
        }
    }

}
