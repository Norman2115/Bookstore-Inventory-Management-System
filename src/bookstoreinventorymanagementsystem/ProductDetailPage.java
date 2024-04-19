/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package bookstoreinventorymanagementsystem;

import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author User
 */
public class ProductDetailPage extends javax.swing.JInternalFrame {
    
    private final BookData productData;
    
    public ProductDetailPage() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
        
        productData  = new BookData();
    }
    
    public void fillProductInfo(BookData productData){
        reset();
        bookTitle.setText(productData.getBookTitle());
        genre.setText(productData.getGenre());
        language.setText(productData.getLanguage());
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
    
    private void displayNetPrice(){
        productData.setUnitPrice(Double.parseDouble(unitPrice.getText()));
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
        exitButton = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        discount = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        isbn = new javax.swing.JTextField();
        language = new javax.swing.JTextField();
        genre = new javax.swing.JTextField();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(951, 630));

        background.setBackground(new java.awt.Color(253, 252, 248));
        background.setPreferredSize(new java.awt.Dimension(942, 630));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setText("<html><font color='#3EA434'>PRODUCT</font> <font color='#008CD6'> DETAIL</font></html>");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 113, 176));
        jLabel5.setText("Book Title");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        bookTitle.setBackground(new java.awt.Color(253, 252, 248));
        bookTitle.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        bookTitle.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 113, 176));
        jLabel10.setText("Genre");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 113, 176));
        jLabel19.setText("Language");

        author.setBackground(new java.awt.Color(253, 252, 248));
        author.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        author.setEnabled(false);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 113, 176));
        jLabel20.setText("Author");

        publisher.setBackground(new java.awt.Color(253, 252, 248));
        publisher.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        publisher.setEnabled(false);

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
        year.setEnabled(false);

        quantity.setBackground(new java.awt.Color(253, 252, 248));
        quantity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        quantity.setEnabled(false);

        unitPrice.setBackground(new java.awt.Color(253, 252, 248));
        unitPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        unitPrice.setEnabled(false);

        netPrice.setBackground(new java.awt.Color(253, 252, 248));
        netPrice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        netPrice.setEnabled(false);

        uploadPicturePanel.setBackground(new java.awt.Color(253, 252, 248));
        uploadPicturePanel.setBorder(BorderFactory.createDashedBorder(ColorManager.MEDIUM_GREY, 3, 3, 1, true)
        );
        uploadPicturePanel.setEnabled(false);

        pictureLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pictureLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/photo_icon_1.png"))); // NOI18N
        pictureLabel.setEnabled(false);

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
        discount.setEnabled(false);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 113, 176));
        jLabel28.setText("ISBN");

        isbn.setBackground(new java.awt.Color(253, 252, 248));
        isbn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        isbn.setEnabled(false);

        language.setBackground(new java.awt.Color(253, 252, 248));
        language.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        language.setEnabled(false);

        genre.setBackground(new java.awt.Color(253, 252, 248));
        genre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        genre.setEnabled(false);

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
                                    .addGroup(backgroundLayout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(backgroundLayout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(genre, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(backgroundLayout.createSequentialGroup()
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(language, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(backgroundLayout.createSequentialGroup()
                                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(publisher, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(backgroundLayout.createSequentialGroup()
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(author, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, backgroundLayout.createSequentialGroup()
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(91, 91, 91)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(isbn, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(unitPrice)
                            .addComponent(netPrice, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(uploadPicturePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(discount, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(exitButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
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
                .addGap(27, 27, 27)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(genre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(discount, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(language, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(netPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(isbn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(author, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(publisher, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(uploadPicturePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94))))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField author;
    private javax.swing.JPanel background;
    private javax.swing.JTextField bookTitle;
    private javax.swing.JTextField discount;
    private javax.swing.JPanel exitButton;
    private javax.swing.JTextField genre;
    private javax.swing.JTextField isbn;
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
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField language;
    private javax.swing.JTextField netPrice;
    private javax.swing.JLabel pictureLabel;
    private javax.swing.JTextField publisher;
    private javax.swing.JTextField quantity;
    private javax.swing.JTextField unitPrice;
    private javax.swing.JPanel uploadPicturePanel;
    private javax.swing.JTextField year;
    // End of variables declaration//GEN-END:variables
}
