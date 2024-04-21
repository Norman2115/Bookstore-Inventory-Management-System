package bookstoreinventorymanagementsystem;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 * The class represents the edit book info page for editing book information.
 * Users can modify details of a selected book.
 *
 * @author Tay Xuan Ye
 */
public class EditProductInfoPage extends javax.swing.JInternalFrame {

    private final BookData bookData;
    private File selectedFile;

    // Validation flags for form fields
    private boolean isBookTitleValid = true;
    private boolean isGenreSelected = true;
    private boolean isLanguageSelected = true;
    private boolean isISBNValid = true;
    private boolean isAuthorValid = true;
    private boolean isPublisherValid = true;
    private boolean isPublicationYearValid = true;
    private boolean isValidDiscount = true;
    private boolean isStockQuantityValid = true;
    private boolean isUnitPriceValid = true;

    /**
     * Creates new form EditProductInfoPage.
     */
    public EditProductInfoPage() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);

        bookData = new BookData();
    }

    /**
     * Fills the fields of the EditProductInfoPage with the details of the
     * specified BookData object.
     *
     * @param bookData The BookData object containing the book information to be
     * displayed
     */
    public void fillProductInfo(BookData bookData) {
        reset();
        bookTitleField.setText(bookData.getBookTitle());
        genreComboBox.setSelectedItem(bookData.getGenre());
        languageComboBox.setSelectedItem(bookData.getLanguage());
        isbnField.setText(String.valueOf(bookData.getISBN()));
        authorField.setText(bookData.getAuthor());
        publisherField.setText(bookData.getPublisher());
        yearField.setText(String.valueOf(bookData.getPublicatioYear()));
        quantityField.setText(String.valueOf(bookData.getStockQuantity()));
        unitPriceField.setText(String.valueOf(bookData.getUnitPrice()));
        discountField.setText(String.valueOf(bookData.getDiscount()));
        netPriceField.setText(String.format("%.2f", bookData.getNetPrice()));
        this.bookData.setCoverPage(bookData.getCoverPage());
        ImageIcon imageIcon = new ImageIcon(bookData.getCoverPage());
        Image scaledImage = imageIcon.getImage().getScaledInstance(pictureLabel.getWidth(),
                pictureLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        pictureLabel.setIcon(scaledImageIcon);
    }

    /**
     * Reset and clear the form fields and validation states.
     */
    private void reset() {
        UIUtils.resetFieldState(bookTitleField);
        UIUtils.resetFieldState(isbnField);
        UIUtils.resetFieldState(authorField);
        UIUtils.resetFieldState(publisherField);
        UIUtils.resetFieldState(yearField);
        UIUtils.resetFieldState(quantityField);
        UIUtils.resetFieldState(unitPriceField);
        UIUtils.resetFieldState(discountField);
        UIUtils.resetFieldState(netPriceField);

        UIUtils.resetErrorLabel(bookTitleErrorLabel);
        UIUtils.resetErrorLabel(isbnErrorLabel);
        UIUtils.resetErrorLabel(authorErrorLabel);
        UIUtils.resetErrorLabel(publisherErrorLabel);
        UIUtils.resetErrorLabel(yearErrorLabel);
        UIUtils.resetErrorLabel(quantityErrorLabel);
        UIUtils.resetErrorLabel(unitPriceErrorLabel);
        UIUtils.resetErrorLabel(discountErrorLabel);
        UIUtils.resetErrorLabel(coverPageErrorLabel);
        UIUtils.resetErrorLabel(genreErrorLabel);
        UIUtils.resetErrorLabel(languageErrorLabel);

        bookTitleField.setText("");
        isbnField.setText("");
        authorField.setText("");
        publisherField.setText("");
        yearField.setText("");
        quantityField.setText("");
        unitPriceField.setText("");
        discountField.setText("");
        netPriceField.setText("");
        genreComboBox.setSelectedIndex(0);
        languageComboBox.setSelectedIndex(0);
        pictureLabel.setIcon(new ImageIcon(getClass().getResource("/icon/photo_icon_1.png")));
        selectedFile = null;
    }

    /**
     * Checks if the entered book title is valid.
     */
    private void checkBookTitleValid() {
        String bookTitle = bookTitleField.getText();

        // Check if the entered book title is not empty
        if (!bookTitle.trim().isEmpty()) {
            // Validate the book title
            ValidationResult bookTitleValidation = ValidationHandler.validateFullName(bookTitle);
            isBookTitleValid = bookTitleValidation.isValid();

            // If book title is invalid, mark the field as errorneous and display error message
            if (!bookTitleValidation.isValid()) {
                UIUtils.setFieldErrorState(bookTitleField);
                UIUtils.setErrorLabelMessage(bookTitleErrorLabel, bookTitleValidation.getErrorMessage());
            } else {
                // If the book title is valid, reset the field state and clear error message
                UIUtils.resetFieldState(bookTitleField);
                UIUtils.resetErrorLabel(bookTitleErrorLabel);
            }
        } else {
            // If field is empty, reset the field state and clear error message, if any
            UIUtils.resetFieldState(bookTitleField);
            UIUtils.resetErrorLabel(bookTitleErrorLabel);
        }
    }

    /**
     * Checks if the entered author name is valid.
     */
    private void checkAuthorValid() {
        String author = authorField.getText();

        // Check if the entered author name is not empty
        if (!author.trim().isEmpty()) {
            ValidationResult authorNameValidation = ValidationHandler.validateFullName(author);
            isAuthorValid = authorNameValidation.isValid();

            // If author name is invalid, mark the field as errorneous and display error message
            if (!authorNameValidation.isValid()) {
                UIUtils.setFieldErrorState(authorField);
                UIUtils.setErrorLabelMessage(authorErrorLabel, authorNameValidation.getErrorMessage());
            } else {
                // If the author name is valid, reset the field state and clear error message
                UIUtils.resetFieldState(authorField);
                UIUtils.resetErrorLabel(authorErrorLabel);
            }
        } else {
            // If field is empty, reset the field state and clear error message, if any
            UIUtils.resetFieldState(authorField);
            UIUtils.resetErrorLabel(authorErrorLabel);
        }
    }

    /**
     * Checks if the entered publisher name is valid
     */
    private void checkPublisherValid() {
        String publisher = publisherField.getText();

        // Check if the entered publisher name is not empty
        if (!publisher.trim().isEmpty()) {
            // Validate the publisher name
            ValidationResult publisherNameValidation = ValidationHandler.validateFullName(publisher);
            isPublisherValid = publisherNameValidation.isValid();

            // If publisher name is invalid, mark the field as errorneous and display error message
            if (!publisherNameValidation.isValid()) {
                UIUtils.setFieldErrorState(publisherField);
                UIUtils.setErrorLabelMessage(publisherErrorLabel, publisherNameValidation.getErrorMessage());
            } else {
                // If the publisher name is valid, reset the field state and clear error message
                UIUtils.resetFieldState(publisherField);
                UIUtils.resetErrorLabel(publisherErrorLabel);
            }
        } else {
            // If field is empty, reset the field state and clear error message, if any
            UIUtils.resetFieldState(publisherField);
            UIUtils.resetErrorLabel(publisherErrorLabel);
        }
    }

    /**
     * Checks if the entered publication year is valid.
     */
    private void checkYearValid() {
        String publicationYear = yearField.getText();

        // Check if the entered publication year is not empty
        if (!publicationYear.trim().isEmpty()) {
            ValidationResult publicationYearValidation = ValidationHandler.validateYear(publicationYear);
            isPublicationYearValid = publicationYearValidation.isValid();

            // If publication year is invalid, mark the field as errorneous and display error message
            if (!publicationYearValidation.isValid()) {
                UIUtils.setFieldErrorState(yearField);
                UIUtils.setErrorLabelMessage(yearErrorLabel, publicationYearValidation.getErrorMessage());
            } else {
                // If the publication year is valid, reset the field state and clear error message
                UIUtils.resetFieldState(yearField);
                UIUtils.resetErrorLabel(yearErrorLabel);
            }
        } else {
            // If field is empty, reset the field state and clear error message, if any
            UIUtils.resetFieldState(yearField);
            UIUtils.resetErrorLabel(yearErrorLabel);
        }
    }

    /**
     * Checks if the entered stock quantity is valid.
     */
    private void checkQuantityValid() {
        String quantity = quantityField.getText();

        // Check if the entered stock quantity is not empty
        if (!quantity.trim().isEmpty()) {
            // Validate the stock quantity
            ValidationResult quantityValidation = ValidationHandler.validateStockQuantity(quantity);
            isStockQuantityValid = quantityValidation.isValid();

            // If stock quantity is invalid, mark the field as errorneous and display error message
            if (!quantityValidation.isValid()) {
                UIUtils.setFieldErrorState(quantityField);
                UIUtils.setErrorLabelMessage(quantityErrorLabel, quantityValidation.getErrorMessage());
            } else {
                // If the stock quantity is valid, reset the field state and clear error message
                UIUtils.resetFieldState(quantityField);
                UIUtils.resetErrorLabel(quantityErrorLabel);
            }
        } else {
            // If field is empty, reset the field state and clear error message, if any
            UIUtils.resetFieldState(quantityField);
            UIUtils.resetErrorLabel(quantityErrorLabel);
        }
    }

    /**
     * Checks if the entered unit price is valid.
     */
    private void checkUnitPriceValid() {
        String unitPrice = unitPriceField.getText();

        // Check if the entered unit price is not empty
        if (!unitPrice.trim().isEmpty()) {
            // Validate the unit price
            ValidationResult unitPriceValidation = ValidationHandler.validateUnitPrice(unitPrice);
            isUnitPriceValid = unitPriceValidation.isValid();

            // If unit price is invalid, mark the field as errorneous and display error message
            if (!unitPriceValidation.isValid()) {
                UIUtils.setFieldErrorState(unitPriceField);
                UIUtils.setErrorLabelMessage(unitPriceErrorLabel, unitPriceValidation.getErrorMessage());
            } else {
                // If the unit price is valid, reset the field state and clear error message
                UIUtils.resetFieldState(unitPriceField);
                UIUtils.resetErrorLabel(unitPriceErrorLabel);
            }
        } else {
            // If field is empty, reset the field state and clear error message, if any
            UIUtils.resetFieldState(unitPriceField);
            UIUtils.resetErrorLabel(unitPriceErrorLabel);
        }
    }

    private void checkDiscountValid() {
        String discount = discountField.getText();

        /**
         * Checks if the entered discount is valid.
         */
        if (!discount.trim().isEmpty()) {
            // Validate the discount
            ValidationResult discountValidation = ValidationHandler.validateDiscount(discount);
            isValidDiscount = discountValidation.isValid();

            // If discount is invalid, mark the field as errorneous and display error message
            if (!discountValidation.isValid()) {
                UIUtils.setFieldErrorState(discountField);
                UIUtils.setErrorLabelMessage(discountErrorLabel, discountValidation.getErrorMessage());
            } else {
                // If the discount is valid, reset the field state and clear error message
                UIUtils.resetFieldState(discountField);
                UIUtils.resetErrorLabel(discountErrorLabel);
            }
        } else {
            // If field is empty, reset the field state and clear error message, if any
            UIUtils.resetFieldState(discountField);
            UIUtils.resetErrorLabel(discountErrorLabel);
        }
    }

    /**
     * Checks if the entered ISBN is valid.
     */
    private void checkISBNValid() {
        String isbn = isbnField.getText();

        // Check if the entered ISBN is not empty
        if (!isbn.trim().isEmpty()) {
            // Validate the ISBN
            ValidationResult isbnValidation = ValidationHandler.validateISBN(isbn);

            // If the ISBN is valid, check if the ISBN is unique
            if (isbnValidation.isValid()) {
                try {
                    // Check if the ISBN is unique
                    ValidationResult isbnUniqueValidation = ValidationHandler.checkUniqueISBN(isbn);
                    isISBNValid = isbnUniqueValidation.isValid();

                    // If the ISBN is not unique, mark the field as errorneous and display error message
                    if (!isbnUniqueValidation.isValid()) {
                        UIUtils.setFieldErrorState(isbnField);
                        UIUtils.setErrorLabelMessage(isbnErrorLabel, isbnUniqueValidation.getErrorMessage());
                    } else {
                        // If the ISBN is unique, reset the field state and clear error message
                        UIUtils.resetFieldState(isbnField);
                        UIUtils.resetErrorLabel(isbnErrorLabel);
                    }
                } catch (SQLException ex) {
                    UIUtils.displayErrorMessage(ExceptionMessages.DATABASE_ERROR);
                    Logger.getLogger(EditProductInfoPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                // If the ISBN is invalid, mark the field as errorneous and display error message
                UIUtils.setFieldErrorState(isbnField);
                UIUtils.setErrorLabelMessage(isbnErrorLabel, isbnValidation.getErrorMessage());
            }
        } else {
            // If field is empty, reset the field state and clear error message, if any
            UIUtils.resetFieldState(isbnField);
            UIUtils.resetErrorLabel(isbnErrorLabel);
        }
    }

    /**
     * Calculates the net price based on the entered unit price and discount,
     * and updates the net price field.
     */
    private void calculateNetPrice() {
        // Check if the unit price field is not empty
        if (!unitPriceField.getText().trim().isEmpty()) {
            double unitPrice = Double.parseDouble(unitPriceField.getText().trim());
            double discount = discountField.getText().isEmpty() ? 0 : Double.parseDouble(discountField.getText());
            double netPrice = unitPrice * (1 - discount / 100);
            netPriceField.setText(String.format("%.2f", netPrice));
        } else {
            // If the unit price field is empty, set the net price field to 0
            netPriceField.setText("0.00");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bookTitleLabel = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        bookTitleField = new javax.swing.JTextField();
        genreLabel = new javax.swing.JLabel();
        languageLabel = new javax.swing.JLabel();
        authorField = new javax.swing.JTextField();
        authorLabel = new javax.swing.JLabel();
        publisherField = new javax.swing.JTextField();
        publisherLabel = new javax.swing.JLabel();
        yearLabel = new javax.swing.JLabel();
        quantityLabel = new javax.swing.JLabel();
        unitPriceLabel = new javax.swing.JLabel();
        discountLabel = new javax.swing.JLabel();
        netPriceLabel = new javax.swing.JLabel();
        yearField = new javax.swing.JTextField();
        quantityField = new javax.swing.JTextField();
        unitPriceField = new javax.swing.JTextField();
        netPriceField = new javax.swing.JTextField();
        uploadPicturePanel = new javax.swing.JPanel();
        pictureLabel = new javax.swing.JLabel();
        coverPageLabel = new javax.swing.JLabel();
        addProductButton = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        clearButton = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        discountField = new javax.swing.JTextField();
        genreComboBox = new javax.swing.JComboBox<>();
        languageComboBox = new javax.swing.JComboBox<>();
        unitPriceErrorLabel = new javax.swing.JLabel();
        coverPageErrorLabel = new javax.swing.JLabel();
        bookTitleErrorLabel = new javax.swing.JLabel();
        authorErrorLabel = new javax.swing.JLabel();
        publisherErrorLabel = new javax.swing.JLabel();
        yearErrorLabel = new javax.swing.JLabel();
        quantityErrorLabel = new javax.swing.JLabel();
        isbnLabel = new javax.swing.JLabel();
        isbnField = new javax.swing.JTextField();
        isbnErrorLabel = new javax.swing.JLabel();
        genreErrorLabel = new javax.swing.JLabel();
        languageErrorLabel = new javax.swing.JLabel();
        discountErrorLabel = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(951, 630));

        background.setBackground(new java.awt.Color(253, 252, 248));
        background.setPreferredSize(new java.awt.Dimension(942, 630));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setText("<html><font color='#3EA434'>EDIT</font> <font color='#008CD6'>BOOK</font></html>");

        bookTitleLabel.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        bookTitleLabel.setForeground(new java.awt.Color(0, 113, 176));
        bookTitleLabel.setText("Book Title");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        bookTitleField.setBackground(new java.awt.Color(253, 252, 248));
        bookTitleField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        bookTitleField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bookTitleFieldKeyReleased(evt);
            }
        });

        genreLabel.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        genreLabel.setForeground(new java.awt.Color(0, 113, 176));
        genreLabel.setText("Genre");

        languageLabel.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        languageLabel.setForeground(new java.awt.Color(0, 113, 176));
        languageLabel.setText("Language");

        authorField.setBackground(new java.awt.Color(253, 252, 248));
        authorField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        authorField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                authorFieldKeyReleased(evt);
            }
        });

        authorLabel.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        authorLabel.setForeground(new java.awt.Color(0, 113, 176));
        authorLabel.setText("Author");

        publisherField.setBackground(new java.awt.Color(253, 252, 248));
        publisherField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        publisherField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                publisherFieldKeyReleased(evt);
            }
        });

        publisherLabel.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        publisherLabel.setForeground(new java.awt.Color(0, 113, 176));
        publisherLabel.setText("Publisher");

        yearLabel.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        yearLabel.setForeground(new java.awt.Color(0, 113, 176));
        yearLabel.setText("Year");

        quantityLabel.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        quantityLabel.setForeground(new java.awt.Color(0, 113, 176));
        quantityLabel.setText("Quantity");

        unitPriceLabel.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        unitPriceLabel.setForeground(new java.awt.Color(0, 113, 176));
        unitPriceLabel.setText("Unit Price (RM)");

        discountLabel.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        discountLabel.setForeground(new java.awt.Color(0, 113, 176));
        discountLabel.setText("Discount (%)");

        netPriceLabel.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        netPriceLabel.setForeground(new java.awt.Color(0, 113, 176));
        netPriceLabel.setText("Net Price (RM)");

        yearField.setBackground(new java.awt.Color(253, 252, 248));
        yearField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        yearField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                yearFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                yearFieldKeyTyped(evt);
            }
        });

        quantityField.setBackground(new java.awt.Color(253, 252, 248));
        quantityField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        quantityField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantityFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                quantityFieldKeyTyped(evt);
            }
        });

        unitPriceField.setBackground(new java.awt.Color(253, 252, 248));
        unitPriceField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        unitPriceField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                unitPriceFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                unitPriceFieldKeyTyped(evt);
            }
        });

        netPriceField.setBackground(new java.awt.Color(253, 252, 248));
        netPriceField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        netPriceField.setEnabled(false);

        uploadPicturePanel.setBackground(new java.awt.Color(253, 252, 248));
        uploadPicturePanel.setBorder(BorderFactory.createDashedBorder(ColorManager.MEDIUM_GREY, 3, 3, 1, true)
        );
        uploadPicturePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uploadPicturePanelMouseClicked(evt);
            }
        });

        pictureLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pictureLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/photo_icon_1.png"))); // NOI18N

        javax.swing.GroupLayout uploadPicturePanelLayout = new javax.swing.GroupLayout(uploadPicturePanel);
        uploadPicturePanel.setLayout(uploadPicturePanelLayout);
        uploadPicturePanelLayout.setHorizontalGroup(
            uploadPicturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, uploadPicturePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        uploadPicturePanelLayout.setVerticalGroup(
            uploadPicturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(uploadPicturePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pictureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addContainerGap())
        );

        coverPageLabel.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        coverPageLabel.setForeground(new java.awt.Color(0, 113, 176));
        coverPageLabel.setText("Cover Page");

        addProductButton.setBackground(new java.awt.Color(0, 140, 214));
        addProductButton.setPreferredSize(new java.awt.Dimension(120, 52));
        addProductButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addProductButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addProductButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addProductButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addProductButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addProductButtonMouseReleased(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("UPDATE");

        javax.swing.GroupLayout addProductButtonLayout = new javax.swing.GroupLayout(addProductButton);
        addProductButton.setLayout(addProductButtonLayout);
        addProductButtonLayout.setHorizontalGroup(
            addProductButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addProductButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addContainerGap())
        );
        addProductButtonLayout.setVerticalGroup(
            addProductButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addProductButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        clearButton.setBackground(new java.awt.Color(62, 164, 52));
        clearButton.setPreferredSize(new java.awt.Dimension(120, 52));
        clearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clearButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                clearButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                clearButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                clearButtonMouseReleased(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("EXIT");

        javax.swing.GroupLayout clearButtonLayout = new javax.swing.GroupLayout(clearButton);
        clearButton.setLayout(clearButtonLayout);
        clearButtonLayout.setHorizontalGroup(
            clearButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clearButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        clearButtonLayout.setVerticalGroup(
            clearButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clearButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        discountField.setBackground(new java.awt.Color(253, 252, 248));
        discountField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        discountField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                discountFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                discountFieldKeyTyped(evt);
            }
        });

        genreComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Select -", "Fantasy", "Science Fiction", "Mystery/Thriller", "Romance", "Historical Fiction", "Horror", "Adventure", "Non-fiction", "Crime", "Young Adult" }));
        genreComboBox.setToolTipText("");
        genreComboBox.setPreferredSize(new java.awt.Dimension(235, 29));
        genreComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genreComboBoxActionPerformed(evt);
            }
        });

        languageComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Select -", "English", "Malay", "Chinese", "Spanish", "French", "Russian", "Japanese", "Arabic" }));
        languageComboBox.setPreferredSize(new java.awt.Dimension(235, 29));
        languageComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                languageComboBoxActionPerformed(evt);
            }
        });

        unitPriceErrorLabel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        unitPriceErrorLabel.setForeground(new java.awt.Color(253, 252, 248));

        coverPageErrorLabel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        coverPageErrorLabel.setForeground(new java.awt.Color(253, 252, 248));

        bookTitleErrorLabel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        bookTitleErrorLabel.setForeground(new java.awt.Color(253, 252, 248));

        authorErrorLabel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        authorErrorLabel.setForeground(new java.awt.Color(253, 252, 248));

        publisherErrorLabel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        publisherErrorLabel.setForeground(new java.awt.Color(253, 252, 248));

        yearErrorLabel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        yearErrorLabel.setForeground(new java.awt.Color(253, 252, 248));

        quantityErrorLabel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        quantityErrorLabel.setForeground(new java.awt.Color(253, 252, 248));

        isbnLabel.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        isbnLabel.setForeground(new java.awt.Color(0, 113, 176));
        isbnLabel.setText("ISBN");

        isbnField.setBackground(new java.awt.Color(253, 252, 248));
        isbnField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        isbnField.setEnabled(false);
        isbnField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                isbnFieldKeyReleased(evt);
            }
        });

        isbnErrorLabel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        isbnErrorLabel.setForeground(new java.awt.Color(253, 252, 248));

        genreErrorLabel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        genreErrorLabel.setForeground(new java.awt.Color(253, 252, 248));

        languageErrorLabel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        languageErrorLabel.setForeground(new java.awt.Color(253, 252, 248));

        discountErrorLabel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        discountErrorLabel.setForeground(new java.awt.Color(253, 252, 248));

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(backgroundLayout.createSequentialGroup()
                                                .addComponent(bookTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bookTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(backgroundLayout.createSequentialGroup()
                                                .addComponent(languageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(languageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(backgroundLayout.createSequentialGroup()
                                                .addComponent(genreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(genreErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(genreComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addComponent(bookTitleErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(backgroundLayout.createSequentialGroup()
                                                .addComponent(publisherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(publisherErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(publisherField, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                                                .addComponent(yearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(yearField, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(yearErrorLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(backgroundLayout.createSequentialGroup()
                                            .addComponent(authorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(authorErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(authorField, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, backgroundLayout.createSequentialGroup()
                                            .addComponent(quantityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(quantityErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(91, 91, 91)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(coverPageLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(netPriceLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(unitPriceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(discountLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(languageErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(backgroundLayout.createSequentialGroup()
                                        .addComponent(isbnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(isbnErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(isbnField, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(unitPriceField, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                .addComponent(netPriceField, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(discountField, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(coverPageErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(unitPriceErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(uploadPicturePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(discountErrorLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(addProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)))
                        .addGap(185, 185, 185))))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(152, 152, 152))
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(unitPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unitPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(unitPriceErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookTitleErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(genreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(genreComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(discountField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(discountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(genreErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(languageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(languageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(netPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(netPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(2, 2, 2)
                        .addComponent(languageErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(discountErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(isbnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(isbnField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addComponent(isbnErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(authorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(authorField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(coverPageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(2, 2, 2)
                        .addComponent(authorErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(publisherLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(publisherField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addComponent(publisherErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(yearLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yearField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addComponent(yearErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quantityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addComponent(quantityErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(uploadPicturePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(coverPageErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uploadPicturePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uploadPicturePanelMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose Profile Picture");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Image Files", "jpg", "jpeg", "png");
        fileChooser.addChoosableFileFilter(filter);

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            ImageIcon imageIcon = new ImageIcon(selectedFile.getPath());
            Image scaledImage = imageIcon.getImage().getScaledInstance(
                    pictureLabel.getWidth(), pictureLabel.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
            pictureLabel.setIcon(scaledImageIcon);
            UIUtils.resetErrorLabel(coverPageErrorLabel);
        }
    }//GEN-LAST:event_uploadPicturePanelMouseClicked

    private void addProductButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addProductButtonMouseClicked
        // Check if the book title field is empty
        if (bookTitleField.getText().trim().isEmpty()) {
            isBookTitleValid = false;
            UIUtils.markFieldAsRequired(bookTitleField, bookTitleErrorLabel);
        }

        // Check if the ISBN field is empty
        if (isbnField.getText().trim().isEmpty()) {
            isISBNValid = false;
            UIUtils.markFieldAsRequired(isbnField, isbnErrorLabel);
        }

        // Check if the author field is empty
        if (authorField.getText().trim().isEmpty()) {
            isAuthorValid = false;
            UIUtils.markFieldAsRequired(authorField, authorErrorLabel);
        }

        // Check if the publisher field is empty
        if (publisherField.getText().trim().isEmpty()) {
            isPublisherValid = false;
            UIUtils.markFieldAsRequired(publisherField, publisherErrorLabel);
        }

        // Check if the publication year is empty
        if (yearField.getText().trim().isEmpty()) {
            isPublicationYearValid = false;
            UIUtils.markFieldAsRequired(yearField, yearErrorLabel);
        }

        // Check if the quantity field is empty
        if (quantityField.getText().trim().isEmpty()) {
            isStockQuantityValid = false;
            UIUtils.markFieldAsRequired(quantityField, quantityErrorLabel);
        }

        // Check if the unit price field is empty
        if (unitPriceField.getText().isEmpty()) {
            isUnitPriceValid = false;
            UIUtils.markFieldAsRequired(unitPriceField, unitPriceErrorLabel);
        }

        // Check if the discount field is empty
        if (discountField.getText().isEmpty()) {
            isValidDiscount = false;
            UIUtils.markFieldAsRequired(discountField, discountErrorLabel);
        }

        // Check if a genre is selected from the combo box
        if (genreComboBox.getSelectedItem().equals(genreComboBox.getItemAt(0))) {
            isGenreSelected = false;
            UIUtils.setErrorLabelMessage(genreErrorLabel, "Please select a value");
        }

        // Check if a language is selected from the combo box
        if (languageComboBox.getSelectedItem().equals(languageComboBox.getItemAt(0))) {
            isLanguageSelected = false;
            UIUtils.setErrorLabelMessage(languageErrorLabel, "Please select a value");
        }

        // Check if all fields are valid
        if (isBookTitleValid && isISBNValid && isGenreSelected
                && isLanguageSelected && isAuthorValid && isPublisherValid
                && isPublicationYearValid && isUnitPriceValid
                && isStockQuantityValid && isValidDiscount) {
            // Set the data for the new book
            bookData.setBookTitle(bookTitleField.getText().trim());
            bookData.setAuthor(authorField.getText().trim());
            bookData.setISBN(isbnField.getText().trim());
            bookData.setPublisher(publisherField.getText().trim());
            bookData.setPublicationYear(Integer.parseInt(yearField.getText().trim()));
            bookData.setStockQuantity(Integer.parseInt(quantityField.getText().trim()));
            bookData.setUnitPrice(Double.parseDouble(unitPriceField.getText().trim()));
            bookData.setDiscount(Double.parseDouble(discountField.getText().trim()));
            bookData.setGenre(genreComboBox.getSelectedItem().toString());
            bookData.setLanguage(languageComboBox.getSelectedItem().toString());
            bookData.calculateNetPrice();

            // Check if a new cover page has been selected
            if (selectedFile != null) {
                try {
                    // Convert selected image file to byte array
                    byte[] coverPage = ImageUtils.convertFileToByteArray(selectedFile);
                    bookData.setCoverPage(coverPage);

                    // Save book data to database
                    try {
                        BookDAO.updateBookData(bookData);
                        UIUtils.displaySuccessMessage("Book updated successfully");
                        dispose();
                        AdminHomePage.createEditProductViewPage();
                    } catch (SQLException ex) {
                        UIUtils.displayErrorMessage(ExceptionMessages.DATABASE_ERROR);
                        Logger.getLogger(EditProductInfoPage.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                    } catch (NullPointerException ex) {
                        UIUtils.displayErrorMessage(ExceptionMessages.NULL_ERROR);
                        Logger.getLogger(EditProductInfoPage.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                    }
                } catch (IOException ex) {
                    UIUtils.displayErrorMessage(ExceptionMessages.IO_ERROR);
                    Logger.getLogger(EditProductInfoPage.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            } else {
                // If there is no new cover page selected
                try {
                    // Save book data to database
                    BookDAO.updateBookData(bookData);
                    UIUtils.displaySuccessMessage("Book updated successfully");
                    dispose();
                    AdminHomePage.createEditProductViewPage();
                } catch (SQLException ex) {
                    UIUtils.displayErrorMessage(ExceptionMessages.DATABASE_ERROR);
                    Logger.getLogger(EditProductInfoPage.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NullPointerException ex) {
                    UIUtils.displayErrorMessage(ExceptionMessages.NULL_ERROR);
                    Logger.getLogger(EditProductInfoPage.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }
    }//GEN-LAST:event_addProductButtonMouseClicked

    private void addProductButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addProductButtonMouseEntered
        addProductButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_addProductButtonMouseEntered

    private void addProductButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addProductButtonMouseExited
        addProductButton.setBackground(ColorManager.PRIMARY_BLUE);
    }//GEN-LAST:event_addProductButtonMouseExited

    private void addProductButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addProductButtonMousePressed
        addProductButton.setBackground(ColorManager.DEEP_BLUE);
    }//GEN-LAST:event_addProductButtonMousePressed

    private void addProductButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addProductButtonMouseReleased
        addProductButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_addProductButtonMouseReleased

    private void clearButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearButtonMouseClicked
        dispose();
        AdminHomePage.createEditProductViewPage();
    }//GEN-LAST:event_clearButtonMouseClicked

    private void clearButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearButtonMouseEntered
        clearButton.setBackground(ColorManager.MEDIUM_GREEN);
    }//GEN-LAST:event_clearButtonMouseEntered

    private void clearButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearButtonMouseExited
        clearButton.setBackground(ColorManager.PRIMARY_GREEN);
    }//GEN-LAST:event_clearButtonMouseExited

    private void clearButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearButtonMousePressed
        clearButton.setBackground(ColorManager.DEEP_GREEN);
    }//GEN-LAST:event_clearButtonMousePressed

    private void clearButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearButtonMouseReleased
        clearButton.setBackground(ColorManager.MEDIUM_GREEN);
    }//GEN-LAST:event_clearButtonMouseReleased

    private void bookTitleFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bookTitleFieldKeyReleased
        checkBookTitleValid();
    }//GEN-LAST:event_bookTitleFieldKeyReleased

    private void authorFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_authorFieldKeyReleased
        checkAuthorValid();
    }//GEN-LAST:event_authorFieldKeyReleased

    private void publisherFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_publisherFieldKeyReleased
        checkPublisherValid();
    }//GEN-LAST:event_publisherFieldKeyReleased

    private void yearFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearFieldKeyReleased
        checkYearValid();
    }//GEN-LAST:event_yearFieldKeyReleased

    private void quantityFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityFieldKeyReleased
        checkQuantityValid();
    }//GEN-LAST:event_quantityFieldKeyReleased

    private void discountFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discountFieldKeyReleased
        checkDiscountValid();
        if (isValidDiscount) {
            calculateNetPrice();
        }
    }//GEN-LAST:event_discountFieldKeyReleased

    private void isbnFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_isbnFieldKeyReleased
        checkISBNValid();
    }//GEN-LAST:event_isbnFieldKeyReleased

    private void yearFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearFieldKeyTyped
        char c = evt.getKeyChar();

        // Only accepts digits and limits the length to 4 characters
        if (!Character.isDigit(c) || yearField.getText().length() >= 4) {
            evt.consume();
        }
    }//GEN-LAST:event_yearFieldKeyTyped

    private void unitPriceFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unitPriceFieldKeyReleased
        checkUnitPriceValid();
        if (isUnitPriceValid) {
            calculateNetPrice();
        }
    }//GEN-LAST:event_unitPriceFieldKeyReleased

    private void unitPriceFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unitPriceFieldKeyTyped
        char c = evt.getKeyChar();

        // Only accepts digits and decimal point
        if (!Character.isDigit(c) && c != '.') {
            evt.consume();
        }
    }//GEN-LAST:event_unitPriceFieldKeyTyped

    private void quantityFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityFieldKeyTyped
        char c = evt.getKeyChar();

        // Only accepts digits
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_quantityFieldKeyTyped

    private void genreComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genreComboBoxActionPerformed
        UIUtils.resetErrorLabel(genreErrorLabel);
        isGenreSelected = genreComboBox.getSelectedIndex() != 0;
    }//GEN-LAST:event_genreComboBoxActionPerformed

    private void languageComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_languageComboBoxActionPerformed
        UIUtils.resetErrorLabel(languageErrorLabel);
        isLanguageSelected = languageComboBox.getSelectedIndex() != 0;
    }//GEN-LAST:event_languageComboBoxActionPerformed

    private void discountFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discountFieldKeyTyped
        char c = evt.getKeyChar();

        // Only accepts digits and decimal point
        if (!Character.isDigit(c) && c != '.') {
            evt.consume();
        }
    }//GEN-LAST:event_discountFieldKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addProductButton;
    private javax.swing.JLabel authorErrorLabel;
    private javax.swing.JTextField authorField;
    private javax.swing.JLabel authorLabel;
    private javax.swing.JPanel background;
    private javax.swing.JLabel bookTitleErrorLabel;
    private javax.swing.JTextField bookTitleField;
    private javax.swing.JLabel bookTitleLabel;
    private javax.swing.JPanel clearButton;
    private javax.swing.JLabel coverPageErrorLabel;
    private javax.swing.JLabel coverPageLabel;
    private javax.swing.JLabel discountErrorLabel;
    private javax.swing.JTextField discountField;
    private javax.swing.JLabel discountLabel;
    private javax.swing.JComboBox<String> genreComboBox;
    private javax.swing.JLabel genreErrorLabel;
    private javax.swing.JLabel genreLabel;
    private javax.swing.JLabel isbnErrorLabel;
    private javax.swing.JTextField isbnField;
    private javax.swing.JLabel isbnLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JComboBox<String> languageComboBox;
    private javax.swing.JLabel languageErrorLabel;
    private javax.swing.JLabel languageLabel;
    private javax.swing.JTextField netPriceField;
    private javax.swing.JLabel netPriceLabel;
    private javax.swing.JLabel pictureLabel;
    private javax.swing.JLabel publisherErrorLabel;
    private javax.swing.JTextField publisherField;
    private javax.swing.JLabel publisherLabel;
    private javax.swing.JLabel quantityErrorLabel;
    private javax.swing.JTextField quantityField;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JLabel unitPriceErrorLabel;
    private javax.swing.JTextField unitPriceField;
    private javax.swing.JLabel unitPriceLabel;
    private javax.swing.JPanel uploadPicturePanel;
    private javax.swing.JLabel yearErrorLabel;
    private javax.swing.JTextField yearField;
    private javax.swing.JLabel yearLabel;
    // End of variables declaration//GEN-END:variables
}
