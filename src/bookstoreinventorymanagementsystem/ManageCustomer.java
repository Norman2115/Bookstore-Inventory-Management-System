package bookstoreinventorymanagementsystem;

import java.sql.Statement;
import javax.swing.table.TableModel;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Liew Wen Yen
 */
public class ManageCustomer extends javax.swing.JFrame {

    private String customerID = "";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private String email;
    private String name;
    private String mobileNumber;
    private boolean isFullNameValid = false;
    private boolean isEmailValid = false;
    private boolean isMobileNumberValid = false;

    /**
     * Creates new form ManageCustomer
     */
    public ManageCustomer() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        con = DatabaseManager.getConnection();
        updateTable();
    }

    private boolean validateFields() {
        // Reset validation flags
        isFullNameValid = true;
        isEmailValid = true;
        isMobileNumberValid = true;

        if (customerNameTxt.getText().trim().isEmpty()) {
            UIUtils.markFieldAsRequired(customerNameTxt, fullNameErrorLabel);
            isFullNameValid = false;
        }

        if (customerMNumberTxt.getText().trim().isEmpty()) {
            UIUtils.markFieldAsRequired(customerMNumberTxt, mobileNumberErrorLabel);
            isMobileNumberValid = false;
        }

        if (customerEmailTxt.getText().trim().isEmpty()) {
            UIUtils.markFieldAsRequired(customerEmailTxt, emailErrorLabel);
            isEmailValid = false;
        }

        return (isFullNameValid && isEmailValid && isMobileNumberValid);
    }

    //Customer table is updated
    private void updateTable() {
        String sql = "select *from customer";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            customerTable.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    // Clear text fields
    public void clearFields() {

        customerNameTxt.setText(null);
        customerMNumberTxt.setText(null);
        customerEmailTxt.setText(null);
    }

    private String generateCustomerID() throws SQLException {

        PreparedStatement ps = null;

        try {
            // Get the current customer ID counter value
            String query = "SELECT current_customer_id FROM customer_id_counter WHERE prefix = 'C'";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();

            if (rs.next()) {
                int currentID = rs.getInt("current_customer_id");

                // Format the customer ID
                customerID = "C" + String.format("%04d", currentID);

                // Increment the counter
                query = "UPDATE customer_id_counter SET current_customer_id = ? WHERE prefix = 'C'";
                ps = con.prepareStatement(query);
                ps.setInt(1, currentID + 1);
                ps.executeUpdate();
            }
        } finally {
            // Close resources
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                // Handle exception
                JOptionPane.showMessageDialog(null, e);
            }
        }

        return customerID;
    }

    private void saveCustomerToDatabase(String name, String mobileNumber, String email) {
        try {
            // Establish connection to the database
            con = DatabaseManager.getConnection();

            // Prepare SQL statement with parameters
            String query = "INSERT INTO customer (customer_id, name, mobileNumber, email) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            // Generate the customer ID
            customerID = generateCustomerID();

            // Set parameters
            ps.setString(1, customerID);
            ps.setString(2, name);
            ps.setString(3, mobileNumber);
            ps.setString(4, email);

            // Execute the SQL statement
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Customer saved successfully with ID: " + customerID);
                clearFields();
                updateTable();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to save customer record.");
            }
        } catch (SQLException e) {
            // Handle any exceptions
            JOptionPane.showMessageDialog(null, e);
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

        jPanel1 = new javax.swing.JPanel();
        lblGreenStrip = new javax.swing.JPanel();
        lblCustomer = new javax.swing.JLabel();
        lblBlueStrip = new javax.swing.JPanel();
        homeButton = new javax.swing.JPanel();
        homeIcon = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        customerNameTxt = new javax.swing.JTextField();
        customerMNumberTxt = new javax.swing.JTextField();
        customerEmailTxt = new javax.swing.JTextField();
        saveButton = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        updateButton = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        fullNameErrorLabel = new javax.swing.JLabel();
        emailErrorLabel = new javax.swing.JLabel();
        mobileNumberErrorLabel = new javax.swing.JLabel();
        clearButton = new javax.swing.JPanel();
        clearLabel = new javax.swing.JLabel();
        deleteButton = new javax.swing.JPanel();
        deleteLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImages(null);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 500));

        lblGreenStrip.setBackground(new java.awt.Color(62, 164, 52));

        javax.swing.GroupLayout lblGreenStripLayout = new javax.swing.GroupLayout(lblGreenStrip);
        lblGreenStrip.setLayout(lblGreenStripLayout);
        lblGreenStripLayout.setHorizontalGroup(
            lblGreenStripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        lblGreenStripLayout.setVerticalGroup(
            lblGreenStripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        lblCustomer.setBackground(new java.awt.Color(0, 140, 214));
        lblCustomer.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblCustomer.setForeground(new java.awt.Color(0, 140, 214));
        lblCustomer.setText("Customer");

        lblBlueStrip.setBackground(new java.awt.Color(0, 140, 214));
        lblBlueStrip.setForeground(new java.awt.Color(51, 102, 255));
        lblBlueStrip.setPreferredSize(new java.awt.Dimension(45, 28));
        lblBlueStrip.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homeButton.setBackground(new java.awt.Color(0, 140, 214));
        homeButton.setPreferredSize(new java.awt.Dimension(136, 33));
        homeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                homeButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                homeButtonMouseReleased(evt);
            }
        });

        homeIcon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        homeIcon.setForeground(new java.awt.Color(255, 255, 255));
        homeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Home Icon.png"))); // NOI18N
        homeIcon.setPreferredSize(new java.awt.Dimension(33, 30));

        javax.swing.GroupLayout homeButtonLayout = new javax.swing.GroupLayout(homeButton);
        homeButton.setLayout(homeButtonLayout);
        homeButtonLayout.setHorizontalGroup(
            homeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homeIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );
        homeButtonLayout.setVerticalGroup(
            homeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeButtonLayout.createSequentialGroup()
                .addComponent(homeIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblBlueStrip.add(homeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 28));

        jScrollPane1.setBorder(null);

        customerTable.setAutoCreateRowSorter(true);
        customerTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Mobile Number", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        customerTable.setGridColor(new java.awt.Color(255, 255, 255));
        customerTable.setRowHeight(25);
        customerTable.setSelectionBackground(new java.awt.Color(0, 140, 214));
        customerTable.getTableHeader().setResizingAllowed(false);
        customerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(customerTable);
        if (customerTable.getColumnModel().getColumnCount() > 0) {
            customerTable.getColumnModel().getColumn(0).setResizable(false);
            customerTable.getColumnModel().getColumn(0).setPreferredWidth(3);
            customerTable.getColumnModel().getColumn(1).setResizable(false);
            customerTable.getColumnModel().getColumn(1).setPreferredWidth(70);
            customerTable.getColumnModel().getColumn(2).setResizable(false);
            customerTable.getColumnModel().getColumn(2).setPreferredWidth(50);
            customerTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 100, 0));
        jLabel1.setText("Name");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 100, 0));
        jLabel2.setText("Mobile Number");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 100, 0));
        jLabel3.setText("Email");

        customerNameTxt.setForeground(new java.awt.Color(0, 100, 0));
        customerNameTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        customerNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerNameTxtActionPerformed(evt);
            }
        });
        customerNameTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                customerNameTxtKeyReleased(evt);
            }
        });

        customerMNumberTxt.setForeground(new java.awt.Color(0, 100, 0));
        customerMNumberTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        customerMNumberTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerMNumberTxtActionPerformed(evt);
            }
        });
        customerMNumberTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                customerMNumberTxtKeyReleased(evt);
            }
        });

        customerEmailTxt.setForeground(new java.awt.Color(0, 100, 0));
        customerEmailTxt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        customerEmailTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerEmailTxtActionPerformed(evt);
            }
        });
        customerEmailTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                customerEmailTxtKeyReleased(evt);
            }
        });

        saveButton.setBackground(new java.awt.Color(0, 140, 214));
        saveButton.setPreferredSize(new java.awt.Dimension(136, 33));
        saveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saveButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                saveButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                saveButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                saveButtonMouseReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SAVE");

        javax.swing.GroupLayout saveButtonLayout = new javax.swing.GroupLayout(saveButton);
        saveButton.setLayout(saveButtonLayout);
        saveButtonLayout.setHorizontalGroup(
            saveButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(saveButtonLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel4)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        saveButtonLayout.setVerticalGroup(
            saveButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        updateButton.setBackground(new java.awt.Color(0, 140, 214));
        updateButton.setPreferredSize(new java.awt.Dimension(136, 33));
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

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("UPDATE");

        javax.swing.GroupLayout updateButtonLayout = new javax.swing.GroupLayout(updateButton);
        updateButton.setLayout(updateButtonLayout);
        updateButtonLayout.setHorizontalGroup(
            updateButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateButtonLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel8)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        updateButtonLayout.setVerticalGroup(
            updateButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        clearButton.setBackground(new java.awt.Color(0, 140, 214));
        clearButton.setPreferredSize(new java.awt.Dimension(136, 33));
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

        clearLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        clearLabel.setForeground(new java.awt.Color(255, 255, 255));
        clearLabel.setText("CLEAR");

        javax.swing.GroupLayout clearButtonLayout = new javax.swing.GroupLayout(clearButton);
        clearButton.setLayout(clearButtonLayout);
        clearButtonLayout.setHorizontalGroup(
            clearButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clearButtonLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(clearLabel)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        clearButtonLayout.setVerticalGroup(
            clearButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(clearLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        deleteButton.setBackground(new java.awt.Color(0, 140, 214));
        deleteButton.setPreferredSize(new java.awt.Dimension(136, 33));
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deleteButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                deleteButtonMouseReleased(evt);
            }
        });

        deleteLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteLabel.setForeground(new java.awt.Color(255, 255, 255));
        deleteLabel.setText("DELETE");

        javax.swing.GroupLayout deleteButtonLayout = new javax.swing.GroupLayout(deleteButton);
        deleteButton.setLayout(deleteButtonLayout);
        deleteButtonLayout.setHorizontalGroup(
            deleteButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteButtonLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(deleteLabel)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        deleteButtonLayout.setVerticalGroup(
            deleteButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deleteLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBlueStrip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblGreenStrip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(395, Short.MAX_VALUE)
                .addComponent(lblCustomer)
                .addGap(395, 395, 395))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(customerNameTxt)
                    .addComponent(customerEmailTxt)
                    .addComponent(customerMNumberTxt)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mobileNumberErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fullNameErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(541, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(51, 51, 51)
                    .addComponent(emailErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(562, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblBlueStrip, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCustomer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGreenStrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customerNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customerMNumberTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customerEmailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(182, 182, 182)
                    .addComponent(fullNameErrorLabel)
                    .addGap(84, 84, 84)
                    .addComponent(mobileNumberErrorLabel)
                    .addContainerGap(234, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(348, 348, 348)
                    .addComponent(emailErrorLabel)
                    .addContainerGap(152, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {
            // Fetch data from the database
            con = DatabaseManager.getConnection();
            Statement st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM customer");

            // Populate the table model
            DefaultTableModel model = (DefaultTableModel) customerTable.getModel();
            
            model.setRowCount(0); // Clear existing rows
            while (rs.next()) {
                String[] rowData = {
                    rs.getString("customer_id"),
                    rs.getString("name"),
                    rs.getString("mobileNumber"),
                    rs.getString("email")
                };
                model.addRow(rowData);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: Unable to fetch data from the database: " + e.getMessage());
        }
    }//GEN-LAST:event_formComponentShown

    private void customerEmailTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerEmailTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerEmailTxtActionPerformed

    private void customerMNumberTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerMNumberTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerMNumberTxtActionPerformed

    private void customerNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customerNameTxtActionPerformed

    private void customerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerTableMouseClicked
        int index = customerTable.getSelectedRow();
        TableModel model = customerTable.getModel();
        String id = model.getValueAt(index, 0).toString();
        customerID = id;

        name = model.getValueAt(index, 1).toString();
        customerNameTxt.setText(name);

        mobileNumber = model.getValueAt(index, 2).toString();
        customerMNumberTxt.setText(mobileNumber);

        email = model.getValueAt(index, 3).toString();
        customerEmailTxt.setText(email);

        saveButton.setEnabled(false);
        saveButton.setBackground(ColorManager.DEEP_BLUE);
        updateButton.setEnabled(true);
    }//GEN-LAST:event_customerTableMouseClicked

    private void saveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMouseClicked
        name = customerNameTxt.getText();
        mobileNumber = customerMNumberTxt.getText();
        email = customerEmailTxt.getText();

        // Check if all fields are valid
        if (isFullNameValid && isEmailValid && isMobileNumberValid) {
            saveCustomerToDatabase(name, mobileNumber, email);
        } else {
            JOptionPane.showMessageDialog(null, "Please correct the errors in the fields.");
        }
    }//GEN-LAST:event_saveButtonMouseClicked

    private void saveButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMouseEntered
        saveButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_saveButtonMouseEntered

    private void saveButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMouseExited
        saveButton.setBackground(ColorManager.PRIMARY_BLUE);
    }//GEN-LAST:event_saveButtonMouseExited

    private void saveButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMousePressed
        saveButton.setBackground(ColorManager.DEEP_BLUE);
    }//GEN-LAST:event_saveButtonMousePressed

    private void saveButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMouseReleased
        saveButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_saveButtonMouseReleased

    private void updateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateButtonMouseClicked
        name = customerNameTxt.getText();
        mobileNumber = customerMNumberTxt.getText();
        email = customerEmailTxt.getText();

        if (validateFields() == false) {
            JOptionPane.showMessageDialog(null, "All fields are required");
        } else {
            try {
                // Establish connection to the database
                Connection con = DatabaseManager.getConnection();

                // Prepare SQL statement with parameters for updating customer data
                String query = "UPDATE customer SET name = ?, mobileNumber = ?, email = ? WHERE customer_id = ?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, name);
                ps.setString(2, mobileNumber);
                ps.setString(3, email);
                ps.setString(4, customerID); // assuming customerPk holds the primary key of the customer to be updated

                // Execute the SQL statement
                int rowsAffected = ps.executeUpdate();

                if (rowsAffected > 0) {
                    // Display success message
                    JOptionPane.showMessageDialog(null, "Customer Updated Successfully");
                    updateTable();
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to update customer");
                }
            } catch (Exception e) {
                // Handle any exceptions
                JOptionPane.showMessageDialog(null, e);
            }
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

    private void homeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseClicked
        setVisible(false);
        new SalespersonHomePage().setVisible(true);
    }//GEN-LAST:event_homeButtonMouseClicked

    private void homeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseEntered
        homeButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_homeButtonMouseEntered

    private void homeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseExited
        homeButton.setBackground(ColorManager.PRIMARY_BLUE);
    }//GEN-LAST:event_homeButtonMouseExited

    private void homeButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMousePressed
        homeButton.setBackground(ColorManager.DEEP_BLUE);
    }//GEN-LAST:event_homeButtonMousePressed

    private void homeButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeButtonMouseReleased
        homeButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_homeButtonMouseReleased

    private void customerNameTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customerNameTxtKeyReleased
        name = customerNameTxt.getText();
        if (!name.trim().isEmpty()) {
            ValidationResult fullNameValidation = ValidationHandler.validateFullName(name);
            isFullNameValid = fullNameValidation.isValid();
            if (!fullNameValidation.isValid()) {
                UIUtils.setFieldErrorState(customerNameTxt);
                UIUtils.setErrorLabelMessage(fullNameErrorLabel, fullNameValidation.getErrorMessage());
            } else {
                UIUtils.resetFieldState(customerNameTxt);
                UIUtils.resetErrorLabel(fullNameErrorLabel);
            }
        } else {
            UIUtils.resetFieldState(customerNameTxt);
            UIUtils.resetErrorLabel(emailErrorLabel);
        }
    }//GEN-LAST:event_customerNameTxtKeyReleased

    private void customerEmailTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customerEmailTxtKeyReleased
        email = customerEmailTxt.getText();
        if (!email.trim().isEmpty()) {
            ValidationResult emailValidation = ValidationHandler.validateEmail(email);
            isEmailValid = emailValidation.isValid();
            if (!emailValidation.isValid()) {
                UIUtils.setFieldErrorState(customerEmailTxt);
                UIUtils.setErrorLabelMessage(emailErrorLabel, emailValidation.getErrorMessage());
            } else {
                UIUtils.resetFieldState(customerEmailTxt);
                UIUtils.resetErrorLabel(emailErrorLabel);
            }
        } else {
            UIUtils.resetFieldState(customerEmailTxt);
            UIUtils.resetErrorLabel(emailErrorLabel);
        }
    }//GEN-LAST:event_customerEmailTxtKeyReleased

    private void customerMNumberTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customerMNumberTxtKeyReleased
        mobileNumber = customerMNumberTxt.getText();
        if (!mobileNumber.trim().isEmpty()) {
            ValidationResult mobileNumberValidation = ValidationHandler.validateMobileNumber(mobileNumber);
            isMobileNumberValid = mobileNumberValidation.isValid();
            if (!mobileNumberValidation.isValid()) {
                UIUtils.setFieldErrorState(customerMNumberTxt);
                UIUtils.setErrorLabelMessage(mobileNumberErrorLabel, mobileNumberValidation.getErrorMessage());
            } else {
                UIUtils.resetFieldState(customerMNumberTxt);
                UIUtils.resetErrorLabel(mobileNumberErrorLabel);
            }
        } else {
            UIUtils.resetFieldState(customerMNumberTxt);
            UIUtils.resetErrorLabel(emailErrorLabel);
        }
    }//GEN-LAST:event_customerMNumberTxtKeyReleased

    private void clearButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearButtonMouseClicked
        clearFields();
    }//GEN-LAST:event_clearButtonMouseClicked

    private void clearButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_clearButtonMouseEntered

    private void clearButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_clearButtonMouseExited

    private void clearButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearButtonMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_clearButtonMousePressed

    private void clearButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearButtonMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_clearButtonMouseReleased

    private void deleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseClicked
       int selectedRow = customerTable.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Please select a record to delete.");
        return;
    }

    String customerIDToDelete = customerTable.getValueAt(selectedRow, 0).toString();

    int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
    if (confirmation == JOptionPane.YES_OPTION) {
        try {
            // Establish connection to the database
            Connection con = DatabaseManager.getConnection();

            // Prepare SQL statement for deleting the record
            String query = "DELETE FROM customer WHERE customer_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, customerIDToDelete);

            // Execute the SQL statement
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                // Display success message
                JOptionPane.showMessageDialog(null, "Record deleted successfully.");
                updateTable(); // Refresh the table to reflect changes
                clearFields(); // Clear input fields
            } else {
                JOptionPane.showMessageDialog(null, "Failed to delete record.");
            }
        } catch (Exception e) {
            // Handle any exceptions
            JOptionPane.showMessageDialog(null, e);
        }
    }
    }//GEN-LAST:event_deleteButtonMouseClicked

    private void deleteButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonMouseEntered

    private void deleteButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonMouseExited

    private void deleteButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonMousePressed

    private void deleteButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteButtonMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ManageCustomer().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ManageCustomer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel clearButton;
    private javax.swing.JLabel clearLabel;
    private javax.swing.JTextField customerEmailTxt;
    private javax.swing.JTextField customerMNumberTxt;
    private javax.swing.JTextField customerNameTxt;
    private javax.swing.JTable customerTable;
    private javax.swing.JPanel deleteButton;
    private javax.swing.JLabel deleteLabel;
    private javax.swing.JLabel emailErrorLabel;
    private javax.swing.JLabel fullNameErrorLabel;
    private javax.swing.JPanel homeButton;
    private javax.swing.JLabel homeIcon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel lblBlueStrip;
    private javax.swing.JLabel lblCustomer;
    private javax.swing.JPanel lblGreenStrip;
    private javax.swing.JLabel mobileNumberErrorLabel;
    private javax.swing.JPanel saveButton;
    private javax.swing.JPanel updateButton;
    // End of variables declaration//GEN-END:variables
}
