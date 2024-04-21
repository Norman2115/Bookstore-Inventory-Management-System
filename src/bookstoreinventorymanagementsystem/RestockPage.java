package bookstoreinventorymanagementsystem;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tay Xuan Ye
 */
public class RestockPage extends javax.swing.JInternalFrame {
    private int lowStockValue = 10;

    public RestockPage() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);

        BookData[] bookData;
        try {
            bookData = BookDAO.readBookDataFromDatabase("book", "book_title");
            displayRow(bookData);
            displaySideComponents();
        } catch (SQLException | IOException ex) {
            UIUtils.displayErrorMessage("An error occured: " + ex.getMessage());
            Logger.getLogger(RestockPage.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    private void displaySideComponents() {
        try {
            int outOfStock = BookDAO.getRowCount("book", "stock_quantity = 0");
            int lowStock = BookDAO.getRowCount("book", "stock_quantity < " + lowStockValue);
            int amountOfProduct = BookDAO.getRowCount("book");
            outOfStockLabel.setText(String.valueOf(outOfStock));
            lowStockLabel.setText(String.valueOf(lowStock));
            amountProductLabel.setText(String.valueOf(amountOfProduct));
        } catch (SQLException ex) {
            UIUtils.displayErrorMessage("An error occured: " + ex.getMessage());
            Logger.getLogger(RestockPage.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    private void displayRow(BookData[] productData) {
        ((DefaultTableModel) displayTable.getModel()).setRowCount(0);
        
        int length = productData.length;
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                Object[] rowData = new Object[8];
                rowData[0] = productData[i].getBookTitle();
                rowData[1] = productData[i].getISBN();
                rowData[2] = productData[i].getGenre();
                rowData[3] = productData[i].getLanguage();
                rowData[4] = productData[i].getAuthor();
                rowData[5] = productData[i].getPublisher();
                rowData[6] = productData[i].getPublicatioYear();
                rowData[7] = productData[i].getStockQuantity();
                
                ((DefaultTableModel) displayTable.getModel()).addRow(rowData);
            }
        } else {
            ((DefaultTableModel) displayTable.getModel()).setRowCount(0);
        }
    }

    private String getSelection() {
        String searchBy = null;
        switch (searchType.getSelectedIndex()) {
            case 0 ->
                searchBy = "book_title";
            case 1 ->
                searchBy = "book_title";
            case 2 ->
                searchBy = "isbn";
            case 3 ->
                searchBy = "stock_quantity";
        }
        return searchBy;
    }

    private void selectData() {
        BookData[] bookData;
        String searchBy = getSelection();
        String condition = searchBy + " LIKE " + "\'" + searchBar.getText() + "%" + "\'";
        try {
            bookData = BookDAO.readBookDataFromDatabase("book", condition, searchBy);
            displayRow(bookData);
        } catch (SQLException | IOException ex) {
            UIUtils.displayErrorMessage("An error occured: " + ex.getMessage());
            Logger.getLogger(RestockPage.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    private boolean restockIsValid() {
        return ValidationHandler.containsOnlyNumbers(quantityRestock.getText());
    }

    private boolean restockIsEmpty() {
        return quantityRestock.getText().isEmpty() || "".equals(quantityRestock.getText());
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
        searchBar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();
        searchType = new javax.swing.JComboBox<>();
        searchButton = new javax.swing.JLabel();
        restockButton = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        outOfStockLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lowStockLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        isbnTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        quantityRestock = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        amountProductLabel = new javax.swing.JLabel();
        quantityStockErrorLabel = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(951, 630));

        background.setBackground(new java.awt.Color(253, 252, 248));
        background.setPreferredSize(new java.awt.Dimension(942, 630));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setText("<html><font color='#3EA434'>RESTOCK</font> <font color='#008CD6'>PRODUCT</font></html>");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 113, 176));
        jLabel5.setText("Search");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        searchBar.setBackground(new java.awt.Color(253, 252, 248));
        searchBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        searchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarActionPerformed(evt);
            }
        });

        displayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Book Title", "ISBN", "Genre", "Language", "Author", "Publisher", "Year", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        displayTable.setToolTipText("");
        displayTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        displayTable.setFocusable(false);
        displayTable.setRowHeight(25);
        displayTable.setSelectionBackground(new java.awt.Color(0, 140, 214));
        displayTable.setSelectionForeground(new java.awt.Color(253, 252, 248));
        displayTable.setShowGrid(false);
        displayTable.getTableHeader().setResizingAllowed(false);
        displayTable.getTableHeader().setReorderingAllowed(false);
        displayTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displayTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(displayTable);

        searchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filter By", "Book Title", "ISBN", "Stock Quantity" }));
        searchType.setToolTipText("");

        searchButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search_icon.png"))); // NOI18N
        searchButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        searchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchButtonMouseClicked(evt);
            }
        });

        restockButton.setBackground(new java.awt.Color(0, 140, 214));
        restockButton.setPreferredSize(new java.awt.Dimension(120, 52));
        restockButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                restockButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                restockButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                restockButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                restockButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                restockButtonMouseReleased(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("RESTOCK");

        javax.swing.GroupLayout restockButtonLayout = new javax.swing.GroupLayout(restockButton);
        restockButton.setLayout(restockButtonLayout);
        restockButtonLayout.setHorizontalGroup(
            restockButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, restockButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addContainerGap())
        );
        restockButtonLayout.setVerticalGroup(
            restockButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, restockButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(253, 252, 248));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel3.setBackground(new java.awt.Color(62, 164, 52));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(253, 252, 248));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("OUT OF STOCK");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        outOfStockLabel.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        outOfStockLabel.setForeground(new java.awt.Color(0, 100, 0));
        outOfStockLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        outOfStockLabel.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(outOfStockLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(outOfStockLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(253, 252, 248));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel4.setBackground(new java.awt.Color(62, 164, 52));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(253, 252, 248));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("LOW STOCK");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        lowStockLabel.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        lowStockLabel.setForeground(new java.awt.Color(0, 100, 0));
        lowStockLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lowStockLabel.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lowStockLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lowStockLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 113, 176));
        jLabel8.setText("ISBN");

        isbnTextField.setBackground(new java.awt.Color(253, 252, 248));
        isbnTextField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        isbnTextField.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 113, 176));
        jLabel10.setText("Quantity");

        quantityRestock.setBackground(new java.awt.Color(253, 252, 248));
        quantityRestock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        quantityRestock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantityRestockKeyReleased(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 60, 60));
        jLabel2.setText("* SELECT ROW TO RESTOCK");

        jPanel5.setBackground(new java.awt.Color(253, 252, 248));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel6.setBackground(new java.awt.Color(62, 164, 52));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(253, 252, 248));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("AMOUNT PRODUCT");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        amountProductLabel.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        amountProductLabel.setForeground(new java.awt.Color(0, 100, 0));
        amountProductLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        amountProductLabel.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(amountProductLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(amountProductLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        quantityStockErrorLabel.setForeground(new java.awt.Color(253, 252, 248));

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchType, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(238, 238, 238))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1)
                                    .addGroup(backgroundLayout.createSequentialGroup()
                                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(backgroundLayout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(quantityStockErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(backgroundLayout.createSequentialGroup()
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(isbnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(quantityRestock, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 54, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(restockButton, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 54, Short.MAX_VALUE)))
                .addContainerGap())
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, backgroundLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel1)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(searchType, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, backgroundLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16)))
                .addGap(18, 18, 18)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(isbnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantityRestock, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(quantityStockErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(restockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 939, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void restockButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restockButtonMouseClicked
        int restock = Integer.parseInt(quantityRestock.getText());
        int selectRow = displayTable.getSelectedRow();
        String isbn = (String) ((DefaultTableModel) displayTable.getModel()).getValueAt(selectRow, 1);
        
        if (restockIsEmpty()) {
            UIUtils.markFieldAsRequired(quantityRestock, quantityStockErrorLabel);
        }
        
        if (restockIsValid() && !restockIsEmpty()) {
            BookData[] bookData;
            String condition = "isbn" + " = " + "\'" + isbn + "\'";
            try {
                bookData = BookDAO.readBookDataFromDatabase("book", condition, "isbn");
                bookData[0].setStockQuantity(bookData[0].getStockQuantity() + restock);
                BookDAO.updateStockQuantity(bookData[0]);
            } catch (SQLException | IOException ex) {
                UIUtils.displayErrorMessage("An error occured: " + ex.getMessage());
                Logger.getLogger(RestockPage.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        
        selectData();
        displaySideComponents();
        quantityRestock.setText("");
    }//GEN-LAST:event_restockButtonMouseClicked

    private void restockButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restockButtonMouseEntered
        restockButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_restockButtonMouseEntered

    private void restockButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restockButtonMouseExited
        restockButton.setBackground(ColorManager.PRIMARY_BLUE);
    }//GEN-LAST:event_restockButtonMouseExited

    private void restockButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restockButtonMousePressed
        restockButton.setBackground(ColorManager.DEEP_BLUE);
    }//GEN-LAST:event_restockButtonMousePressed

    private void restockButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restockButtonMouseReleased
        restockButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_restockButtonMouseReleased

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        selectData();
    }//GEN-LAST:event_searchBarActionPerformed

    private void searchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonMouseClicked
        selectData();
    }//GEN-LAST:event_searchButtonMouseClicked

    private void displayTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayTableMouseClicked
        if (evt.getClickCount() == 2) {
            int selectRow = displayTable.getSelectedRow();
            String isbn = (String) ((DefaultTableModel) displayTable.getModel()).getValueAt(selectRow, 1);
            BookData[] bookData;
            String condition = "isbn" + " = " + "\'" + isbn + "\'";
            
            try {
                bookData = BookDAO.readBookDataFromDatabase("book", condition, "isbn");
                isbnTextField.setText(String.valueOf(bookData[0].getISBN()));
            } catch (SQLException | IOException ex) {
                UIUtils.displayErrorMessage("An error occured: " + ex.getMessage());
                Logger.getLogger(RestockPage.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }//GEN-LAST:event_displayTableMouseClicked

    private void quantityRestockKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityRestockKeyReleased
        if (restockIsValid() && !restockIsEmpty()) {
            UIUtils.resetFieldState(quantityRestock);
            quantityStockErrorLabel.setForeground(ColorManager.WHITE);
        } else {
            UIUtils.setFieldErrorState(quantityRestock);
            UIUtils.setErrorLabelMessage(quantityStockErrorLabel, "Only digit accepted");
        }
        
        if (restockIsEmpty()) {
            UIUtils.markFieldAsRequired(quantityRestock, quantityStockErrorLabel);
        }
    }//GEN-LAST:event_quantityRestockKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountProductLabel;
    private javax.swing.JPanel background;
    private javax.swing.JTable displayTable;
    private javax.swing.JTextField isbnTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lowStockLabel;
    private javax.swing.JLabel outOfStockLabel;
    private javax.swing.JTextField quantityRestock;
    private javax.swing.JLabel quantityStockErrorLabel;
    private javax.swing.JPanel restockButton;
    private javax.swing.JTextField searchBar;
    private javax.swing.JLabel searchButton;
    private javax.swing.JComboBox<String> searchType;
    // End of variables declaration//GEN-END:variables
}
