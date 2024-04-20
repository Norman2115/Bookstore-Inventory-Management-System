/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoreinventorymanagementsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public final class BookData {

    private String bookID;
    private String bookTitle;
    private String isbn;
    private String genre;
    private String language;
    private String author;
    private String publisher;
    private int publicationYear;
    private int stockQuantity;
    private double unitPrice;
    private double discount;
    private byte[] image;
    private double netPrice;

    public BookData() {
        reset();
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void calculateNetPrice() {
        this.netPrice = unitPrice - unitPrice * (discount / 100.0);
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getGenre() {
        return genre;
    }

    public String getLanguage() {
        return language;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPublicatioYear() {
        return publicationYear;
    }

    public String getISBN() {
        return isbn;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public double getNetPrice() {
        calculateNetPrice();
        return netPrice;
    }

    public byte[] getImage() {
        return image;
    }

    public void reset() {
        setBookTitle(null);
        setGenre(null);
        setLanguage(null);
        setAuthor(null);
        setPublisher(null);
        setPublicationYear(0);
        setISBN(null);
        setStockQuantity(0);
        setUnitPrice(0.0);
        setDiscount(0.0);
        setImage(null);
        calculateNetPrice();
        bookID = null;
    }
}
