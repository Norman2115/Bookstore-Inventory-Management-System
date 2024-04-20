package bookstoreinventorymanagementsystem;

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
    private byte[] coverPage;
    private double netPrice;

    public BookData() {
        setBookID(null);
        setBookTitle(null);
        setGenre(null);
        setLanguage(null);
        setAuthor(null);
        setPublisher(null);
        setISBN(null);
        setCoverPage(null);
        setPublicationYear(0);
        setStockQuantity(0);
        setUnitPrice(0.0);
        setDiscount(0.0);
        calculateNetPrice();
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
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

    public void setCoverPage(byte[] coverPage) {
        this.coverPage = coverPage;
    }

    public void setNetPrice() {
        netPrice = unitPrice * (1 - discount / 100);
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
        return netPrice;
    }

    public byte[] getCoverPage() {
        return coverPage;
    }
}
