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
    private static ProductData instance;
    
    private String bookTitle;
    private String genre;
    private String language;
    private String author;
    private int publicationYear;
    private int isbn;
    private String supplier;
    private int stockQuantity;
    private double purchasePrice;
    private double unitPrice;
    private double promotion;
    private byte[] image;
    private double salesPrice;
    
    public ProductData(){
        setBookTitle(null);
        setGenre(null);
        setLanguage(null);
        setAuthor(null);
        setPublicationYear(0);
        setISBN(0);
        setSupplier(null);
        setStockQuantity(0);
        setPurchasePrice(0.0);
        setUnitPrice(0.0);
        setPromotion(0.0);
        setImage(null); 
    }
    
    public static ProductData getInstance(){
        if (instance == null){
            instance = new ProductData();
        }
        return instance;
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
    public void setPublicationYear(int publicationYear){
        this.publicationYear=publicationYear;
    }
    public void setISBN(int isbn){
        this.isbn=isbn;
    }
    public void setSupplier(String supplier){
        this.supplier=supplier;
    }
    public void setStockQuantity(int stockQuantity){
        this.stockQuantity=stockQuantity;
    }
    public void setPurchasePrice(double purchasePrice){
        this.purchasePrice=purchasePrice;
    }
    public void setUnitPrice(double unitPrice){
        this.unitPrice=unitPrice;
    }
    public void setPromotion(double promotion){
        this.promotion=promotion;
    }
    public void setImage(byte[] image){
        this.image = image;
    }
    
    public void calculateSalesPrice(){
        this.salesPrice=unitPrice*(1-promotion);
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
    public int getPublicatioYear(){
        return publicationYear;
    }
    public int getISBN(){
        return isbn;
    }
    public String getSupplier(){
        return supplier;
    }
    public int getStockQuantity(){
        return stockQuantity;
    }
    public double getPurchasePrice(){
        return purchasePrice;
    }
    public double getUnitPrice(){
        return unitPrice;
    }
    public double getPromotion(){
        return promotion;
    }
    public double getSalesPrice(){
        calculateSalesPrice();
        return salesPrice;
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
        setSupplier(null);
        setStockQuantity(0);
        setPurchasePrice(0.0);
        setUnitPrice(0.0);
        setPromotion(0.0);
        setImage(null);         
    }
    
    public void saveUserDataToDatabase() throws SQLException {
        DatabaseManager.connect();

        Connection connection = DatabaseManager.getConnection();

        StringBuilder queryBuilder = new StringBuilder("INSERT INTO product (product_name,genre,language,author,publication_year,isbn,supplier,stock_quantity,purchase_price,unit_price,promotion,picture) VALUES (?");
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
        statement.setObject(5, publicationYear);
        statement.setObject(6, isbn);
        statement.setObject(7, supplier);
        statement.setObject(8, stockQuantity);
        statement.setObject(9, purchasePrice);
        statement.setObject(10, unitPrice);
        statement.setObject(11, promotion);
        statement.setObject(12, image);

        statement.executeUpdate();
        
        DatabaseManager.closeConnection();
    }
}
