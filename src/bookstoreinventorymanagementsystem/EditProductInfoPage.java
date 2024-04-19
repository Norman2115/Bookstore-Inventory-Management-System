/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package bookstoreinventorymanagementsystem;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author User
 */
public class EditProductInfoPage extends javax.swing.JInternalFrame {
    
    private final ProductData productData;
    
    public EditProductInfoPage() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
        
        productData  = new ProductData();
    }
    
    public void fillProductInfo(ProductData productData){
        reset();
        bookTitle.setText(productData.getBookTitle());
        genre.setSelectedItem(productData.getGenre());
        language.setSelectedItem(productData.getLanguage());
        isbn.setText(String.valueOf(productData.getISBN()));
        author.setText(productData.getAuthor());
        publisher.setText(productData.getPublisher());
        year.setText(String.valueOf(productData.getPublicatioYear()));
        quantity.setText(String.valueOf(productData.getStockQuantity()));
        unitPrice.setText(String.valueOf(productData.getUnitPrice()));
        discount.setText(String.valueOf(productData.getDiscount()));
        productData.calculateNetPrice();
        double price = productData.getNetPrice();
        String formattedPrice = String.format("%.2f", price);
        netPrice.setText(formattedPrice);   
        ImageIcon imageIcon = new ImageIcon(productData.getImage());
        Image scaledImage = imageIcon.getImage().getScaledInstance(196, 176, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        pictureLabel.setIcon(scaledImageIcon);
    }
    
    private void reset(){
        UIUtils.resetFieldState(bookTitle);
        UIUtils.resetFieldState(isbn);
        UIUtils.resetFieldState(author);
        UIUtils.resetFieldState(publisher);
        UIUtils.resetFieldState(year);
        UIUtils.resetFieldState(quantity);
        UIUtils.resetFieldState(unitPrice);
        UIUtils.resetFieldState(discount);
        UIUtils.resetFieldState(netPrice);
        
        UIUtils.resetErrorLabel(bookTitleErrorLabel);
        UIUtils.resetErrorLabel(isbnErrorLabel);
        UIUtils.resetErrorLabel(authorErrorLabel);
        UIUtils.resetErrorLabel(publisherErrorLabel);
        UIUtils.resetErrorLabel(yearErrorLabel);
        UIUtils.resetErrorLabel(quantityErrorLabel);
        UIUtils.resetErrorLabel(unitPriceErrorLabel);
        UIUtils.resetErrorLabel(discountErrorLabel);
        
        bookTitle.setText(" ");
        isbn.setText(" ");
        author.setText(" ");
        publisher.setText(" ");
        year.setText(" ");
        quantity.setText(" ");
        unitPrice.setText(" ");
        discount.setText(" ");
        netPrice.setText(" ");
        pictureLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/photo_icon_1.png")));
        productData.reset();
    }
    
    private boolean bookTitleIsEmpty(){
        if (bookTitle == null|| "".equals(bookTitle.getText())){
            UIUtils.markFieldAsRequired(bookTitle,bookTitleErrorLabel);
            return true;
        }
        
        UIUtils.resetFieldState(bookTitle);
        bookTitleErrorLabel.setForeground(ColorManager.WHITE);
        return false;
    } 
    
    private boolean authorIsEmpty(){
        if (author == null|| "".equals(author.getText())){
            UIUtils.markFieldAsRequired(author,authorErrorLabel);
            return true;
        }
        
        UIUtils.resetFieldState(author);
        authorErrorLabel.setForeground(ColorManager.WHITE);
        return false;
    } 
    
    private boolean publisherIsEmpty(){
        if (publisher == null|| "".equals(publisher.getText())){
            UIUtils.markFieldAsRequired(publisher,publisherErrorLabel);
            return  true;
        }
        
        UIUtils.resetFieldState(publisher);
        publisherErrorLabel.setForeground(ColorManager.WHITE);
        return false;
    } 
    
    private boolean yearIsEmpty(){
        if (year.getText()==null||"".equals(year.getText())){
            UIUtils.markFieldAsRequired(year,yearErrorLabel);
            return true;
        }
        
        UIUtils.resetFieldState(year);
        yearErrorLabel.setForeground(ColorManager.WHITE);
        return false;
    } 
    
    private boolean quantityIsEmpty(){
        if (quantity.getText()==null||"".equals(quantity.getText())){
            UIUtils.markFieldAsRequired(quantity,quantityErrorLabel);
            return true;
        }
        
        UIUtils.resetFieldState(quantity);
        quantityErrorLabel.setForeground(ColorManager.WHITE);
        return false;
    } 
    
    private boolean unitPriceIsEmpty(){
        if (unitPrice.getText()==null||"".equals(unitPrice.getText())){
            UIUtils.markFieldAsRequired(unitPrice,unitPriceErrorLabel);
            return true;
        }
        
        UIUtils.resetFieldState(unitPrice);
        unitPriceErrorLabel.setForeground(ColorManager.WHITE);
        return false;
    } 
    
    private boolean yearIsValid(){
        ValidationResult valid = ValidationHandler.isValidYear(year.getText());
        if (valid.isValid()){
            int yearInInteger = Integer.parseInt(year.getText());
            productData.setPublicationYear(yearInInteger);
            UIUtils.resetFieldState(year);
            yearErrorLabel.setForeground(ColorManager.WHITE);
            return true;
        }
        
        UIUtils.setFieldErrorState(year);
        UIUtils.setErrorLabelMessage(yearErrorLabel, valid.getErrorMessage());
        return false;
    }
    
    private boolean quantityIsValid(){
        if (ValidationHandler.containsOnlyNumbers(quantity.getText())){
            productData.setStockQuantity(Integer.parseInt(quantity.getText()));
            UIUtils.resetFieldState(quantity);
            quantityErrorLabel.setForeground(ColorManager.WHITE);
            return true;
        }
        UIUtils.setFieldErrorState(quantity);
        UIUtils.setErrorLabelMessage(quantityErrorLabel, "Only digit accepted");  
        return false;
    }
    
    private boolean unitPriceIsValid(){
        ValidationResult valid = ValidationHandler.isValidPrice(unitPrice.getText());
        if (valid.isValid()){
            productData.setUnitPrice(Double.parseDouble(unitPrice.getText()));
            UIUtils.resetFieldState(unitPrice);
            unitPriceErrorLabel.setForeground(ColorManager.WHITE);
            return true;
        }
        
        UIUtils.setFieldErrorState(unitPrice);
        UIUtils.setErrorLabelMessage(unitPriceErrorLabel, valid.getErrorMessage());
        return false;
    }
    
    private boolean discountIsValid(){
        ValidationResult valid = ValidationHandler.isValidDiscountValue(discount.getText());
        if (valid.isValid()){
            productData.setDiscount(Double.parseDouble(discount.getText()));
            UIUtils.resetFieldState(discount);
            discountErrorLabel.setForeground(ColorManager.WHITE);
            return true;
        }
        UIUtils.setFieldErrorState(discount);
        UIUtils.setErrorLabelMessage(discountErrorLabel, valid.getErrorMessage());
        return false;
    }
    
    private boolean isbnIsValid(){
        ValidationResult formatValid = null;
        ValidationResult unique = null;
        formatValid = ValidationHandler.isValidISBN(isbn.getText());
        if(formatValid.isValid()==true){
            try {
                unique = ValidationHandler.checkUniqueISBN(isbn.getText());
            } catch (SQLException ex) {
                Logger.getLogger(EditProductInfoPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (formatValid.isValid()&&unique.isValid()){
            long isbnInInteger = Long.parseLong(isbn.getText());
            productData.setISBN(isbnInInteger);
            UIUtils.resetFieldState(isbn);
            isbnErrorLabel.setForeground(ColorManager.WHITE);
            return true;
        }

        UIUtils.setFieldErrorState(isbn);
        if (formatValid.isValid()==false){
            UIUtils.setErrorLabelMessage(isbnErrorLabel, formatValid.getErrorMessage());
            return false;
        }
        
        UIUtils.setErrorLabelMessage(isbnErrorLabel, unique.getErrorMessage());
        return false;
    }
    
    private void displayNetPrice(){
        if (unitPriceIsValid())
            productData.setUnitPrice(Double.parseDouble(unitPrice.getText()));
        if (discountIsValid())
            productData.setDiscount(Double.parseDouble(discount.getText()));
        productData.calculateNetPrice();
        double price = productData.getNetPrice(); 
        String formattedPrice = String.format("%.2f", price);
        netPrice.setText(formattedPrice);      
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
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        bookTitle = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        author = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        publisher = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        year = new javax.swing.JTextField();
        quantity = new javax.swing.JTextField();
        unitPrice = new javax.swing.JTextField();
        netPrice = new javax.swing.JTextField();
        uploadPicturePanel = new javax.swing.JPanel();
        pictureLabel = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        updateButton = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        exitButton = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        discount = new javax.swing.JTextField();
        genre = new javax.swing.JComboBox<>();
        language = new javax.swing.JComboBox<>();
        unitPriceErrorLabel = new javax.swing.JLabel();
        discountErrorLabel = new javax.swing.JLabel();
        bookTitleErrorLabel = new javax.swing.JLabel();
        authorErrorLabel = new javax.swing.JLabel();
        publisherErrorLabel = new javax.swing.JLabel();
        yearErrorLabel = new javax.swing.JLabel();
        quantityErrorLabel = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        isbn = new javax.swing.JTextField();
        isbnErrorLabel = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(951, 630));

        background.setBackground(new java.awt.Color(253, 252, 248));
        background.setPreferredSize(new java.awt.Dimension(942, 630));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setText("<html><font color='#3EA434'>EDIT</font> <font color='#008CD6'> PRODUCT</font></html>");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 113, 176));
        jLabel5.setText("Book Title");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        bookTitle.setBackground(new java.awt.Color(253, 252, 248));
        bookTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        bookTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookTitleActionPerformed(evt);
            }
        });
        bookTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bookTitleKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 113, 176));
        jLabel10.setText("Genre");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 113, 176));
        jLabel19.setText("Language");

        author.setBackground(new java.awt.Color(253, 252, 248));
        author.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        author.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorActionPerformed(evt);
            }
        });
        author.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                authorKeyReleased(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 113, 176));
        jLabel20.setText("Author");

        publisher.setBackground(new java.awt.Color(253, 252, 248));
        publisher.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        publisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publisherActionPerformed(evt);
            }
        });
        publisher.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                publisherKeyReleased(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 113, 176));
        jLabel21.setText("Publisher");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 113, 176));
        jLabel6.setText("Year");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 113, 176));
        jLabel11.setText("Quantity");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 113, 176));
        jLabel22.setText("Unit Price (RM)");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 113, 176));
        jLabel23.setText("Discount (%)");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 113, 176));
        jLabel24.setText("Net Price (RM)");

        year.setBackground(new java.awt.Color(253, 252, 248));
        year.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearActionPerformed(evt);
            }
        });
        year.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                yearKeyReleased(evt);
            }
        });

        quantity.setBackground(new java.awt.Color(253, 252, 248));
        quantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityActionPerformed(evt);
            }
        });
        quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantityKeyReleased(evt);
            }
        });

        unitPrice.setBackground(new java.awt.Color(253, 252, 248));
        unitPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        unitPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitPriceActionPerformed(evt);
            }
        });
        unitPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                unitPriceKeyReleased(evt);
            }
        });

        netPrice.setBackground(new java.awt.Color(253, 252, 248));
        netPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        netPrice.setEnabled(false);
        netPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                netPriceActionPerformed(evt);
            }
        });

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
            .addGroup(uploadPicturePanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(pictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        uploadPicturePanelLayout.setVerticalGroup(
            uploadPicturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(uploadPicturePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pictureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 113, 176));
        jLabel25.setText("Cover Page");

        updateButton.setBackground(new java.awt.Color(0, 140, 214));
        updateButton.setPreferredSize(new java.awt.Dimension(120, 52));
        updateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                updateButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                updateButtonMouseReleased(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("UPDATE");

        javax.swing.GroupLayout updateButtonLayout = new javax.swing.GroupLayout(updateButton);
        updateButton.setLayout(updateButtonLayout);
        updateButtonLayout.setHorizontalGroup(
            updateButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addContainerGap())
        );
        updateButtonLayout.setVerticalGroup(
            updateButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        exitButton.setBackground(new java.awt.Color(62, 164, 52));
        exitButton.setPreferredSize(new java.awt.Dimension(120, 52));
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                exitButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                exitButtonMouseReleased(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("EXIT");

        javax.swing.GroupLayout exitButtonLayout = new javax.swing.GroupLayout(exitButton);
        exitButton.setLayout(exitButtonLayout);
        exitButtonLayout.setHorizontalGroup(
            exitButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exitButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        exitButtonLayout.setVerticalGroup(
            exitButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exitButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        discount.setBackground(new java.awt.Color(253, 252, 248));
        discount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        discount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountActionPerformed(evt);
            }
        });
        discount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                discountKeyReleased(evt);
            }
        });

        genre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fantasy", "Science Fiction", "Mystery/Thriller", "Romance", "Historical Fiction", "Horror", "Adventure", "Non-fiction", "Crime", "Young Adult" }));
        genre.setPreferredSize(new java.awt.Dimension(235, 29));

        language.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "English", "Malay", "Chinese", "Spanish", "French", "Russian", "Japanese", "Arabic" }));
        language.setPreferredSize(new java.awt.Dimension(235, 29));

        unitPriceErrorLabel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        unitPriceErrorLabel.setForeground(new java.awt.Color(253, 252, 248));
        unitPriceErrorLabel.setText("jLabel7");

        discountErrorLabel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        discountErrorLabel.setForeground(new java.awt.Color(253, 252, 248));
        discountErrorLabel.setText("jLabel7");

        bookTitleErrorLabel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        bookTitleErrorLabel.setForeground(new java.awt.Color(253, 252, 248));
        bookTitleErrorLabel.setText("jLabel7");

        authorErrorLabel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        authorErrorLabel.setForeground(new java.awt.Color(253, 252, 248));
        authorErrorLabel.setText("jLabel7");

        publisherErrorLabel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        publisherErrorLabel.setForeground(new java.awt.Color(253, 252, 248));
        publisherErrorLabel.setText("jLabel7");

        yearErrorLabel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        yearErrorLabel.setForeground(new java.awt.Color(253, 252, 248));
        yearErrorLabel.setText("jLabel7");

        quantityErrorLabel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        quantityErrorLabel.setForeground(new java.awt.Color(253, 252, 248));
        quantityErrorLabel.setText("jLabel7");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 113, 176));
        jLabel28.setText("ISBN");

        isbn.setBackground(new java.awt.Color(253, 252, 248));
        isbn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        isbn.setEnabled(false);
        isbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isbnActionPerformed(evt);
            }
        });
        isbn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                isbnKeyReleased(evt);
            }
        });

        isbnErrorLabel.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        isbnErrorLabel.setForeground(new java.awt.Color(253, 252, 248));
        isbnErrorLabel.setText("jLabel7");

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
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(backgroundLayout.createSequentialGroup()
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(genre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(backgroundLayout.createSequentialGroup()
                                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(language, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(bookTitleErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(backgroundLayout.createSequentialGroup()
                                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(publisherErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(publisher, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(backgroundLayout.createSequentialGroup()
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(authorErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(author, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, backgroundLayout.createSequentialGroup()
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(quantityErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(yearErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(91, 91, 91)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(isbnErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(isbn, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(unitPrice)
                            .addComponent(netPrice, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(uploadPicturePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                            .addComponent(discount, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(unitPriceErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(discountErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(unitPriceErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookTitleErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(genre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addComponent(discountErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(language, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(netPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(uploadPicturePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(isbn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(isbnErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(author, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(authorErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(publisher, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(publisherErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yearErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantityErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(94, 94, 94))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bookTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookTitleActionPerformed

    private void authorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_authorActionPerformed

    private void publisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publisherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_publisherActionPerformed

    private void yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearActionPerformed

    private void quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityActionPerformed

    private void unitPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unitPriceActionPerformed

    private void netPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_netPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_netPriceActionPerformed

    private void uploadPicturePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uploadPicturePanelMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose Profile Picture");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Image Files", "jpg", "jpeg", "png");
        fileChooser.addChoosableFileFilter(filter);

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            ImageIcon imageIcon = new ImageIcon(selectedFile.getPath());
            // change image size
            Image scaledImage = imageIcon.getImage().getScaledInstance(196, 176, Image.SCALE_SMOOTH);
            ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
            
            // insert image into label
            pictureLabel.setIcon(scaledImageIcon);
            
            try {
                //convert image into BLOB
                byte[] image = ImageUtils.convertFileToByteArray(selectedFile);
                productData.setImage(image);
            } catch (IOException ex) {
                Logger.getLogger(EditProductInfoPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_uploadPicturePanelMouseClicked

    private void updateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMouseClicked
        boolean valid = true;
        //check is all required data is filled
        if(bookTitleIsEmpty())
            valid  = false;
        if(authorIsEmpty())
            valid  = false;
        if(publisherIsEmpty())
            valid  = false;
        if(yearIsEmpty())
            valid  = false;
        if(quantityIsEmpty())
            valid  = false;
        if(unitPriceIsEmpty())
            valid  = false;

        //check is all fill data is in accepted format
        if(!yearIsValid())
            valid = false;
        if(!quantityIsValid())
            valid = false;
        if(!unitPriceIsValid())
            valid = false;
        if(!discountIsValid())
            valid = false;
        
        //fill in defalt image if image is null
        if(productData.getImage()==null){
            Path imagePath = Paths.get("src", "icon", "no-image.png");
            try {
                byte[] imageBytes = Files.readAllBytes(imagePath);
                 productData.setImage(imageBytes);
            } catch (IOException ex) {
                Logger.getLogger(EditProductInfoPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //update data
        if (valid)
        {
            //get select language and genre
            productData.setBookTitle(bookTitle.getText());
            productData.setGenre(genre.getSelectedItem().toString());
            productData.setLanguage(language.getSelectedItem().toString());
            productData.setISBN(Long.parseLong(isbn.getText()));
            productData.setAuthor(author.getText());
            productData.setPublisher(publisher.getText());
            productData.setPublicationYear(Integer.parseInt(year.getText()));
            productData.setStockQuantity(Integer.parseInt(quantity.getText()));
            productData.setUnitPrice(Double.parseDouble(unitPrice.getText()));
            productData.setDiscount(Double.parseDouble(discount.getText()));
            try {
                UpdateProductData updateProductData = new UpdateProductData();
                System.out.println(productData.getISBN());
                updateProductData.updateData(productData);
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(EditProductInfoPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            reset();
        }
    }//GEN-LAST:event_updateButtonMouseClicked

    private void updateButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMouseEntered
        updateButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_updateButtonMouseEntered

    private void updateButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMouseExited
        updateButton.setBackground(ColorManager.PRIMARY_BLUE);
    }//GEN-LAST:event_updateButtonMouseExited

    private void updateButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMousePressed
        updateButton.setBackground(ColorManager.DEEP_BLUE);
    }//GEN-LAST:event_updateButtonMousePressed

    private void updateButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMouseReleased
        updateButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_updateButtonMouseReleased

    private void exitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseClicked
        this.dispose();
    }//GEN-LAST:event_exitButtonMouseClicked

    private void exitButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseEntered
        exitButton.setBackground(ColorManager.MEDIUM_GREEN);
    }//GEN-LAST:event_exitButtonMouseEntered

    private void exitButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseExited
        exitButton.setBackground(ColorManager.PRIMARY_GREEN);
    }//GEN-LAST:event_exitButtonMouseExited

    private void exitButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMousePressed
        exitButton.setBackground(ColorManager.DEEP_GREEN);
    }//GEN-LAST:event_exitButtonMousePressed

    private void exitButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseReleased
        exitButton.setBackground(ColorManager.MEDIUM_GREEN);
    }//GEN-LAST:event_exitButtonMouseReleased

    private void discountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_discountActionPerformed

    private void bookTitleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bookTitleKeyReleased
        productData.setBookTitle(bookTitle.getText());
        bookTitleIsEmpty();
    }//GEN-LAST:event_bookTitleKeyReleased

    private void authorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_authorKeyReleased
        productData.setAuthor(author.getText());
        authorIsEmpty();
    }//GEN-LAST:event_authorKeyReleased

    private void publisherKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_publisherKeyReleased
        productData.setPublisher(publisher.getText());
        publisherIsEmpty();
    }//GEN-LAST:event_publisherKeyReleased

    private void yearKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yearKeyReleased
        yearIsValid();  
    }//GEN-LAST:event_yearKeyReleased

    private void quantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityKeyReleased
        quantityIsValid();
    }//GEN-LAST:event_quantityKeyReleased

    private void unitPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unitPriceKeyReleased
        if(unitPriceIsValid())
            displayNetPrice();
    }//GEN-LAST:event_unitPriceKeyReleased

    private void discountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discountKeyReleased
        if(discountIsValid())
            displayNetPrice(); 
    }//GEN-LAST:event_discountKeyReleased

    private void isbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isbnActionPerformed

    private void isbnKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_isbnKeyReleased
        isbnIsValid();
    }//GEN-LAST:event_isbnKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField author;
    private javax.swing.JLabel authorErrorLabel;
    private javax.swing.JPanel background;
    private javax.swing.JTextField bookTitle;
    private javax.swing.JLabel bookTitleErrorLabel;
    private javax.swing.JTextField discount;
    private javax.swing.JLabel discountErrorLabel;
    private javax.swing.JPanel exitButton;
    private javax.swing.JComboBox<String> genre;
    private javax.swing.JTextField isbn;
    private javax.swing.JLabel isbnErrorLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox<String> language;
    private javax.swing.JTextField netPrice;
    private javax.swing.JLabel pictureLabel;
    private javax.swing.JTextField publisher;
    private javax.swing.JLabel publisherErrorLabel;
    private javax.swing.JTextField quantity;
    private javax.swing.JLabel quantityErrorLabel;
    private javax.swing.JTextField unitPrice;
    private javax.swing.JLabel unitPriceErrorLabel;
    private javax.swing.JPanel updateButton;
    private javax.swing.JPanel uploadPicturePanel;
    private javax.swing.JTextField year;
    private javax.swing.JLabel yearErrorLabel;
    // End of variables declaration//GEN-END:variables
}
