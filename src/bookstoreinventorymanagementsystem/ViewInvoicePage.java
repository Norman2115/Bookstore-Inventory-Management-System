package bookstoreinventorymanagementsystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class ViewInvoicePage extends javax.swing.JInternalFrame {
    public ViewInvoicePage() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
        displayRow(readDataFromDatabase());
        // jScrollPane1.getHorizontalScrollBar().setUI(new CustomScrollBar());
        // jScrollPane1.getVerticalScrollBar().setUI(new CustomScrollBar());
        // jTable1.getColumnModel().getColumn(0).setPreferredWidth(200);
    }

    private void displayRow(String[][] data) {
        ((DefaultTableModel) displayTable.getModel()).setRowCount(0);
        int length = data.length;
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                Object[] rowData = new Object[5];
                //0-sales_id;1-salesperson_id;2-customer_id;3-sales_date;4-total_price;5-customer_name;6-salesperson_name
                rowData[0] = data[i][0];
                rowData[1] = data[i][5];
                rowData[2] = data[i][1];
                rowData[3] = data[i][6];
                rowData[4] = data[i][3];
                //insert row
                ((DefaultTableModel) displayTable.getModel()).addRow(rowData);
            }
        } else {
            ((DefaultTableModel) displayTable.getModel()).setRowCount(0);
        }
    }

    private String[][] readDataFromDatabase() {
        try (Connection connection = DatabaseManager.getConnection()) {
            int i = 0;
            int rowNumber = BookDAO.getRowCount("sales_detail");
            String[][] data = new String[rowNumber][7];//0-sales_id;1-salesperson_id;2-customer_id;3-sales_date;4-total_price;5-customer_name;6-salesperson_name
            for (i = 0; i < rowNumber; i++) {
                data[i][0] = "";
                data[i][1] = "";
                data[i][2] = "";
                data[i][3] = "";
                data[i][4] = "";
            }
            //select data
            String query = "SELECT * FROM sales_detail s INNER JOIN customer c ON s.customer_id  = c.customer_id INNER JOIN user u ON s.salesperson_id = user_id ";
            System.out.println(query);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            //catch data from result set
            i = 0;
            while (resultSet.next()) {
                data[i][0] = resultSet.getString("sales_id");
                data[i][1] = resultSet.getString("salesperson_id");
                data[i][2] = resultSet.getString("customer_id");
                data[i][3] = resultSet.getString("sales_date");
                data[i][4] = resultSet.getString("total_price");
                data[i][5] = resultSet.getString("customer_name");
                data[i][6] = resultSet.getString("username");
                i++;
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(ViewInvoicePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private String[][] readDataFromDatabase(String condition, String orderBy) {
        try (Connection connection = DatabaseManager.getConnection()) {
            int i;
            int rowNumber = BookDAO.getRowCount("sales_detail", condition);
            String[][] data = new String[rowNumber][7];//0-sales_id;1-salesperson_id;2-customer_id;3-sales_date;4-total_price;5-customer_name;6-salesperson_name
            for (i = 0; i < rowNumber; i++) {
                data[i][0] = "";
                data[i][1] = "";
                data[i][2] = "";
                data[i][3] = "";
                data[i][4] = "";
                data[i][5] = "";
                data[i][6] = "";
            }
            //select data
            String query = "SELECT * FROM sales_detail s INNER JOIN customer c ON s.customer_id  = c.customer_id INNER JOIN user u ON s.salesperson_id = user_id " + " WHERE " + condition + " ORDER BY " + orderBy;
            System.out.println(query);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            //catch data from result set
            i = 0;
            while (resultSet.next()) {
                data[i][0] = resultSet.getString("sales_id");
                data[i][1] = resultSet.getString("salesperson_id");
                data[i][2] = resultSet.getString("customer_id");
                data[i][3] = resultSet.getString("sales_date");
                data[i][4] = resultSet.getString("total_price");
                data[i][5] = resultSet.getString("customer_name");
                data[i][6] = resultSet.getString("username");
                i++;
            }
            return data;
        } catch (SQLException ex) {
            Logger.getLogger(ViewInvoicePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private String getSelection() {
        String searchBy = null;
        switch (searchType.getSelectedIndex()) {
            case 0 -> searchBy = "sales_id";
            case 1 -> searchBy = "sales_id";
            case 2 -> searchBy = "customer_name";
            case 3 -> searchBy = "salesperson_id";
            case 4 -> searchBy = "username";
            case 5 -> searchBy = "sales_date";
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
        jLabel1.setText("<html><font color='#3EA434'>VIEW</font> <font color='#008CD6'>INVOICE</font></html>");

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
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Invoice ID", "Customer", "Salesperson ID", "Salesperson", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        searchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filter By", "Invoice ID", "Customer", "Salesperson  ID", "Salesperson", "Date" }));
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
        String searchBy = getSelection();
        String condition = searchBy + " LIKE " + "\'" + searchBar.getText() + "%" + "\'";
        displayRow(readDataFromDatabase(condition, searchBy));
    }//GEN-LAST:event_searchBarActionPerformed

    private void searchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchButtonMouseClicked
        String searchBy = getSelection();
        String condition = searchBy + " LIKE " + "\'" + searchBar.getText() + "%" + "\'";
        displayRow(readDataFromDatabase(condition, searchBy));
    }//GEN-LAST:event_searchButtonMouseClicked

    private void displayTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayTableMouseClicked
        if (evt.getClickCount() == 2) {
            int selectRow = displayTable.getSelectedRow();
            System.out.println("Selected row  " + selectRow);
            String[] invoiceData = new String[4];
            invoiceData[0] = (String) ((DefaultTableModel) displayTable.getModel()).getValueAt(selectRow, 0);
            invoiceData[1] = (String) ((DefaultTableModel) displayTable.getModel()).getValueAt(selectRow, 4);
            invoiceData[2] = (String) ((DefaultTableModel) displayTable.getModel()).getValueAt(selectRow, 3);
            invoiceData[3] = (String) ((DefaultTableModel) displayTable.getModel()).getValueAt(selectRow, 2);
            AdminHomePage.createInvoiceDetailPage(invoiceData);
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