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
    private String bookTitle;
    private String genre;
    private String language;
    private String author;
    private String publisher;
    private int publicationYear;
    private long isbn;
    private int stockQuantity;
    private double unitPrice;
    private double discount;
    private byte[] image;
    private double netPrice;
    private String bookID;
    public BookData(){
        reset();
    }
    
    public void setBookTitle(String bookTitle){
        this.bookTitle = bookTitle;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    public void setLanguage(String language){
        this.language=language;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public void setPublisher(String publisher){
        this.publisher=publisher;
    }
    public void setPublicationYear(int publicationYear){
        this.publicationYear=publicationYear;
    }
    public void setISBN(long isbn){
        this.isbn=isbn;
    }
    public void setStockQuantity(int stockQuantity){
        this.stockQuantity=stockQuantity;
    }
    public void setUnitPrice(double unitPrice){
        this.unitPrice=unitPrice;
    }
    public void setDiscount(double discount){
        this.discount=discount;
    }
    public void setImage(byte[] image){
        this.image = image;
    }
    
    public void calculateNetPrice(){
        this.netPrice=unitPrice-unitPrice*(discount/100.0);
    }
    
    public String getBookTitle(){
        return bookTitle;
    }
    public String getGenre(){
        return genre;
    }
    public String getLanguage(){
        return language;
    }
    public String getAuthor(){
        return author;
    }
    public String getPublisher(){
        return publisher;
    }
    public int getPublicatioYear(){
        return publicationYear;
    }
    public long getISBN(){
        return isbn;
    }
    public int getStockQuantity(){
        return stockQuantity;
    }
    public double getUnitPrice(){
        return unitPrice;
    }
    public double getDiscount(){
        return discount;
    }
    public double getNetPrice(){
        calculateNetPrice();
        return netPrice;
    }
    public byte[] getImage(){
        return image;
    }
    
    public void reset(){
        setBookTitle(null);
        setGenre(null);
        setLanguage(null);
        setAuthor(null);
        setPublisher(null);
        setPublicationYear(0);
        setISBN(0);
        setStockQuantity(0);
        setUnitPrice(0.0);
        setDiscount(0.0);
        setImage(null);    
        calculateNetPrice();
        bookID = null;
    }
    
    public void saveBookDataToDatabase(){
        try (Connection connection = DatabaseManager.getConnection();){
            
            
            StringBuilder queryBuilder = new StringBuilder("INSERT INTO product (book_title,genre,language,author,publisher,publication_year,isbn,stock_quantity,unit_price,discount,image,book_id) VALUES (?");
            for (int i = 1; i < 12; i++) {
                queryBuilder.append(", ?");
            }
            queryBuilder.append(");");
            String query = queryBuilder.toString();
            PreparedStatement statement = connection.prepareStatement(query);
            
            statement.setObject(1, bookTitle);
            statement.setObject(2, genre);
            statement.setObject(3, language);
            statement.setObject(4, author);
            statement.setObject(5, publisher);
            statement.setObject(6, publicationYear);
            statement.setObject(7, isbn);
            statement.setObject(8, stockQuantity);
            statement.setObject(9, unitPrice);
            statement.setObject(10, discount);
            statement.setObject(11, image);
            bookID = BookDAO.getNextBookID();
            System.out.print(bookID);
            statement.setObject(12, bookID);
            
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}