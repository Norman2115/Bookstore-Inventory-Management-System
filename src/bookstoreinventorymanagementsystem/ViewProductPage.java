/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package bookstoreinventorymanagementsystem;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class ViewProductPage extends javax.swing.JInternalFrame {
    /**
     * Creates new form welcomeText
     */
    public ViewProductPage() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);

        BookData[] bookDatas;
        try {
            bookDatas = BookDAO.readBookDataFromDatabase("book", "book_title");
            displayRow(bookDatas);
        } catch (SQLException ex) {
            UIUtils.displayErrorMessage(ExceptionMessages.DATABASE_ERROR);
            Logger.getLogger(ViewProductPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            UIUtils.displayErrorMessage(ExceptionMessages.IO_ERROR);
            Logger.getLogger(ViewProductPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void displayRow(BookData[] productData) {
        ((DefaultTableModel) displayTable.getModel()).setRowCount(0);
        int length = productData.length;
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                Object[] rowData = new Object[10];
                rowData[0] = productData[i].getBookTitle();
                rowData[1] = productData[i].getISBN();
                rowData[2] = productData[i].getGenre();
                rowData[3] = productData[i].getLanguage();
                rowData[4] = productData[i].getAuthor();
                rowData[5] = productData[i].getPublisher();
                rowData[6] = productData[i].getPublicatioYear();
                rowData[7] = productData[i].getUnitPrice();
                rowData[8] = productData[i].getDiscount();
                productData[i].setNetPrice();
                rowData[9] = productData[i].getNetPrice();

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
        }
        return searchBy;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        displayPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        background = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        searchBar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();
        searchType = new javax.swing.JComboBox<>();
        searchButton = new javax.swing.JLabel();

        displayPanel.setBackground(new java.awt.Color(253, 252, 248));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setText("Inventory Management System");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        jLabel3.setText("Family Bookstore ");

        javax.swing.GroupLayout displayPanelLayout = new javax.swing.GroupLayout(displayPanel);
        displayPanel.setLayout(displayPanelLayout);
        displayPanelLayout.setHorizontalGroup(
            displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(displayPanelLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        displayPanelLayout.setVerticalGroup(
            displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, displayPanelLayout.createSequentialGroup()
                .addContainerGap(165, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(253, 253, 253))
        );

        jLabel4.setText("jLabel4");

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(951, 630));

        background.setBackground(new java.awt.Color(253, 252, 248));
        background.setPreferredSize(new java.awt.Dimension(942, 630));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setText("<html><font color='#3EA434'>VIEW</font> <font color='#008CD6'>INVENTORY</font></html>");

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

            },
            new String [] {
                "Book Title", "ISBN", "Genre", "Language", "Author", "Publisher", "Year", "Unit Price (RM)", "Discount (%)", "Net Price (RM)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
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
        displayTable.getTableHeader().setReorderingAllowed(false);
        displayTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displayTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(displayTable);

        searchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filter By", "Book Title", "ISBN" }));
        searchType.setToolTipText("");

        searchButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search_icon.png"))); // NOI18N
        searchButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        searchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchButtonMouseClicked(evt);
            }
        });

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
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, backgroundLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchType, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 60, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
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

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        BookData[] bookDatas;
        String searchBy = getSelection();
        String condition = searchBy + " LIKE " + "\'" + searchBar.getText() + "%" + "\'";
        try {
            bookDatas = BookDAO.readBookDataFromDatabase("book", condition, searchBy);
            displayRow(bookDatas);
        } catch (SQLException ex) {
            UIUtils.displayErrorMessage(ExceptionMessages.DATABASE_ERROR);
            Logger.getLogger(ViewProductPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            UIUtils.displayErrorMessage(ExceptionMessages.IO_ERROR);
            Logger.getLogger(ViewProductPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchBarActionPerformed

    private void searchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonMouseClicked
        BookData[] bookDatas;
        String searchBy = getSelection();
        String condition = searchBy + " LIKE " + "\'" + searchBar.getText() + "%" + "\'";
        try {
            bookDatas = BookDAO.readBookDataFromDatabase("book", condition, searchBy);
            displayRow(bookDatas);
        } catch (SQLException ex) {
            UIUtils.displayErrorMessage(ExceptionMessages.DATABASE_ERROR);
            Logger.getLogger(ViewProductPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            UIUtils.displayErrorMessage(ExceptionMessages.IO_ERROR);
            Logger.getLogger(ViewProductPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchButtonMouseClicked

    private void displayTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayTableMouseClicked
        if (evt.getClickCount() == 2) {
            int selectRow = displayTable.getSelectedRow();
            String isbn = (String) ((DefaultTableModel) displayTable.getModel()).getValueAt(selectRow, 1);
            BookData[] bookDatas;
            String condition = "isbn" + " = " + "\'" + isbn + "\'";
            try {
                bookDatas = BookDAO.readBookDataFromDatabase("book", condition, "isbn");
                AdminHomePage.createProductDetailPage(bookDatas[0]);
            } catch (SQLException ex) {
                UIUtils.displayErrorMessage(ExceptionMessages.DATABASE_ERROR);
                Logger.getLogger(ViewProductPage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                UIUtils.displayErrorMessage(ExceptionMessages.IO_ERROR);
                Logger.getLogger(ViewProductPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_displayTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JPanel displayPanel;
    private javax.swing.JTable displayTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchBar;
    private javax.swing.JLabel searchButton;
    private javax.swing.JComboBox<String> searchType;
    // End of variables declaration//GEN-END:variables
}
