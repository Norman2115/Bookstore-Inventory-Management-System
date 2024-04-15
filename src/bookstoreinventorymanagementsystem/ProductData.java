/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoreinventorymanagementsystem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author User
 */
public final class ProductData {    
    private String bookTitle;
    private String genre;
    private String language;
    private String author;
    private String publisher;
    private int publicationYear;
    private int isbn;
    private int stockQuantity;
    private double unitPrice;
    private double discount;
    private byte[] image;
    private double netPrice;
    
    public ProductData(){
        setBookTitle(null);
        setGenre(null);
        setLanguage(null);
        setAuthor(null);
        setPublicationYear(0);
        setISBN(0);
        setStockQuantity(0);
        setUnitPrice(0.0);
        setDiscount(0.0);
        setImage(null); 
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
    public void setISBN(int isbn){
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
        this.netPrice=unitPrice*(discount/100.0)+unitPrice;
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
    public int getISBN(){
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
        setPublicationYear(0);
        setISBN(0);
        setStockQuantity(0);
        setUnitPrice(0.0);
        setDiscount(0.0);
        setImage(null);         
    }
    
    public void saveUserDataToDatabase() throws SQLException {
        Connection connection = DatabaseManager.getConnection();

        StringBuilder queryBuilder = new StringBuilder("INSERT INTO product (book_title,genre,language,author,publisher,publication_year,isbn,stock_quantity,unit_price,discount,picture) VALUES (?");
        for (int i = 1; i < 11; i++) {
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

        statement.executeUpdate();
    }
}
