package bookstoreinventorymanagementsystem;

/**
 * The class represents book data in the system. It stores information such as
 * book ID, title, ISBN, genre, language, author, publisher, publication year,
 * stock quantity, unit price, discount, net price and cover page image.
 *
 * @author Tay Xuan Ye
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
    private double netPrice;
    private byte[] coverPage;

    /**
     * Constructs a new BookData object with default values. All properties are
     * initialized to null or 0 value.
     */
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
        setNetPrice(0.0);
    }

    /**
     * Set the book ID.
     *
     * @param bookID the book ID to be set.
     */
    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    /**
     * Set the book title of the book.
     *
     * @param bookTitle the book title to be set.
     */
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    /**
     * Set the genre of the book.
     *
     * @param genre the genre to be set.
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Set the language of the book.
     *
     * @param language the language to be set.
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Set the author of the book.
     *
     * @param author the author to be set.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Set the publisher of the book.
     *
     * @param publisher the publisher to be set.
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Set the publication year of the book.
     *
     * @param publicationYear the publication year to be set.
     */
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    /**
     * Set the ISBN of the book.
     *
     * @param isbn the ISBN to be set.
     */
    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Set the stock quantity of the book.
     *
     * @param stockQuantity the stock quantity to be set.
     */
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    /**
     * Set the unit price of the book.
     *
     * @param unitPrice the unit price to be set.
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Set the discount of the book.
     *
     * @param discount the discount to be set.
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * Set the cover page of the book.
     *
     * @param coverPage the cover page of the book.
     */
    public void setCoverPage(byte[] coverPage) {
        this.coverPage = coverPage;
    }

    /**
     * Sets the net price of the book.
     *
     * @param netPrice the net price to set.
     */
    public void setNetPrice(double netPrice) {
        this.netPrice = netPrice;
    }

    /**
     * Calculates the net price of the book based on the unit price and
     * discount. The net price is calculated as the unit price multiplied by (1
     * - discount percentage/100).
     */
    public void calculateNetPrice() {
        netPrice = unitPrice * (1 - discount / 100.0);
    }

    /**
     * Retrieves the book ID of the book in the form of String.
     *
     * @return the book ID of the book, or null if not set.
     */
    public String getBookID() {
        return bookID;
    }

    /**
     * Retrieves the book title of the book in the form of String.
     *
     * @return the book title of the book, or null if not set.
     */
    public String getBookTitle() {
        return bookTitle;
    }

    /**
     * Retrieves the genre of the book in the form of String.
     *
     * @return the genre of the book, or null if not set.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Retrieves the language of the book in the form of String.
     *
     * @return the language of the book, or null if not set.
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Retrieves the author of the book in the form of String.
     *
     * @return the author of the book, or null if not set.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Retrieves the publisher of the book in the from of String.
     *
     * @return the publisher of the book, or null if not set.
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Retrieves the publication year of the book in the form of integer.
     *
     * @return the publication year of the book, or 0 if not set.
     */
    public int getPublicatioYear() {
        return publicationYear;
    }

    /**
     * Retrieves the ISBN of the book in the form of String.
     *
     * @return the ISBN of the book, or null if not set.
     */
    public String getISBN() {
        return isbn;
    }

    /**
     * Retrieves the stock quantity of the book in the form of integer.
     *
     * @return the stock quantity of the book, or 0 if not set.
     */
    public int getStockQuantity() {
        return stockQuantity;
    }

    /**
     * Retrieves the unit price of the book in the form of double.
     *
     * @return the unit price of the book, or 0.0 if not set.
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * Retrieves the discount of the book in the form of double.
     *
     * @return the discount of the book, or 0.0 if not set.
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Retrieves the net price of the book in the term of double.
     *
     * @return the net price of the book, or 0.0 if not set.
     */
    public double getNetPrice() {
        return netPrice;
    }

    /**
     * Retrieves the cover page of the book in the term of byte array.
     *
     * @return the cover page of the book, or null if not set.
     */
    public byte[] getCoverPage() {
        return coverPage;
    }
}
