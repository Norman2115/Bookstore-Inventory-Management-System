/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bookstoreinventorymanagementsystem;

import com.sun.jdi.connect.spi.Connection;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/**
 *
 * @author User
 */
public class ManageOrder extends javax.swing.JFrame {

    private int customerPk = 0;
    private int productPk = 0;
    private int finalTotalPrice = 0;
    private String orderID = "";
    
    
    public ManageOrder() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        basePanel = new javax.swing.JPanel();
        DateLabel = new javax.swing.JLabel();
        HomePage = new javax.swing.JLabel();
        lblGreenStrip = new javax.swing.JPanel();
        CartPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        CartLabel1 = new javax.swing.JLabel();
        finalTotalPriceLabel1 = new javax.swing.JLabel();
        QuantityLabel1 = new javax.swing.JLabel();
        QuantityLabel3 = new javax.swing.JLabel();
        QuantityTxt3 = new javax.swing.JTextField();
        addToCartButton = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        choice1 = new java.awt.Choice();
        CartPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        CartTable = new javax.swing.JTable();
        TotalLabel = new javax.swing.JLabel();
        CartLabel = new javax.swing.JLabel();
        finalTotalPriceLabel = new javax.swing.JLabel();
        finalPriceLabel = new javax.swing.JLabel();
        placeOrderButton = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblBlueStrip = new javax.swing.JPanel();
        homeButton = new javax.swing.JPanel();
        homeIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        basePanel.setBackground(new java.awt.Color(255, 255, 255));
        basePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        HomePage.setBackground(new java.awt.Color(0, 140, 214));
        HomePage.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        HomePage.setForeground(new java.awt.Color(0, 140, 214));
        HomePage.setText("Manage Order");

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

        CartPanel1.setBackground(new java.awt.Color(0, 153, 255));
        CartPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        CartPanel1.setForeground(new java.awt.Color(153, 153, 153));
        CartPanel1.setOpaque(false);
        CartPanel1.setPreferredSize(new java.awt.Dimension(380, 420));

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "BookID", "Book Name", "Quantity", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productTable.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                productTableComponentShown(evt);
            }
        });
        jScrollPane3.setViewportView(productTable);
        if (productTable.getColumnModel().getColumnCount() > 0) {
            productTable.getColumnModel().getColumn(0).setResizable(false);
            productTable.getColumnModel().getColumn(0).setPreferredWidth(80);
            productTable.getColumnModel().getColumn(1).setResizable(false);
            productTable.getColumnModel().getColumn(2).setResizable(false);
            productTable.getColumnModel().getColumn(3).setResizable(false);
        }

        CartLabel1.setBackground(new java.awt.Color(102, 204, 255));
        CartLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CartLabel1.setForeground(new java.awt.Color(0, 140, 214));
        CartLabel1.setText("Checkout");

        QuantityLabel1.setText("Customer:");

        QuantityLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        QuantityLabel3.setForeground(new java.awt.Color(0, 100, 0));
        QuantityLabel3.setText("Quantity: ");

        QuantityTxt3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        QuantityTxt3.setForeground(new java.awt.Color(0, 100, 0));
        QuantityTxt3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        addToCartButton.setBackground(new java.awt.Color(0, 140, 214));
        addToCartButton.setPreferredSize(new java.awt.Dimension(136, 33));
        addToCartButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addToCartButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addToCartButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addToCartButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addToCartButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addToCartButtonMouseReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Add to Cart");

        javax.swing.GroupLayout addToCartButtonLayout = new javax.swing.GroupLayout(addToCartButton);
        addToCartButton.setLayout(addToCartButtonLayout);
        addToCartButtonLayout.setHorizontalGroup(
            addToCartButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addToCartButtonLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addToCartButtonLayout.setVerticalGroup(
            addToCartButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        choice1.setName(""); // NOI18N

        javax.swing.GroupLayout CartPanel1Layout = new javax.swing.GroupLayout(CartPanel1);
        CartPanel1.setLayout(CartPanel1Layout);
        CartPanel1Layout.setHorizontalGroup(
            CartPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CartPanel1Layout.createSequentialGroup()
                .addGroup(CartPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CartPanel1Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(CartLabel1))
                    .addGroup(CartPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(QuantityLabel1)
                        .addGap(20, 20, 20)
                        .addComponent(choice1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CartPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(CartPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CartPanel1Layout.createSequentialGroup()
                                .addGap(0, 85, Short.MAX_VALUE)
                                .addGroup(CartPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(finalTotalPriceLabel1)
                                    .addGroup(CartPanel1Layout.createSequentialGroup()
                                        .addComponent(QuantityLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(QuantityTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(96, 96, 96)))
                                .addGap(19, 19, 19))
                            .addComponent(addToCartButton, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        CartPanel1Layout.setVerticalGroup(
            CartPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CartPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CartLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CartPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(QuantityLabel1)
                    .addComponent(choice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(CartPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(QuantityTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QuantityLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addToCartButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(finalTotalPriceLabel1))
        );

        CartPanel.setBackground(new java.awt.Color(255, 255, 255));
        CartPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        CartPanel.setPreferredSize(new java.awt.Dimension(380, 420));

        CartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No.", "Book Name", "Quantity", "Sub Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(CartTable);
        if (CartTable.getColumnModel().getColumnCount() > 0) {
            CartTable.getColumnModel().getColumn(0).setResizable(false);
            CartTable.getColumnModel().getColumn(0).setPreferredWidth(80);
            CartTable.getColumnModel().getColumn(1).setResizable(false);
            CartTable.getColumnModel().getColumn(2).setResizable(false);
            CartTable.getColumnModel().getColumn(3).setResizable(false);
        }

        TotalLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        TotalLabel.setForeground(new java.awt.Color(0, 100, 0));
        TotalLabel.setText("Total Payment: RM");

        CartLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        CartLabel.setForeground(new java.awt.Color(0, 140, 214));
        CartLabel.setText("Cart");

        finalPriceLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        finalPriceLabel.setForeground(new java.awt.Color(0, 100, 0));
        finalPriceLabel.setText("00.0");

        placeOrderButton.setBackground(new java.awt.Color(0, 140, 214));
        placeOrderButton.setPreferredSize(new java.awt.Dimension(136, 33));
        placeOrderButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                placeOrderButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                placeOrderButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                placeOrderButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                placeOrderButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                placeOrderButtonMouseReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Place Order");

        javax.swing.GroupLayout placeOrderButtonLayout = new javax.swing.GroupLayout(placeOrderButton);
        placeOrderButton.setLayout(placeOrderButtonLayout);
        placeOrderButtonLayout.setHorizontalGroup(
            placeOrderButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, placeOrderButtonLayout.createSequentialGroup()
                .addContainerGap(123, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(124, 124, 124))
        );
        placeOrderButtonLayout.setVerticalGroup(
            placeOrderButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout CartPanelLayout = new javax.swing.GroupLayout(CartPanel);
        CartPanel.setLayout(CartPanelLayout);
        CartPanelLayout.setHorizontalGroup(
            CartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CartPanelLayout.createSequentialGroup()
                .addGroup(CartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CartPanelLayout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(TotalLabel)
                        .addGap(18, 18, 18)
                        .addComponent(finalPriceLabel))
                    .addGroup(CartPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(finalTotalPriceLabel))
                    .addGroup(CartPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(CartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(placeOrderButton, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)))
                    .addGroup(CartPanelLayout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(CartLabel)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        CartPanelLayout.setVerticalGroup(
            CartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CartPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(CartLabel)
                .addGap(39, 39, 39)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(CartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CartPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(finalPriceLabel)
                        .addGap(7, 7, 7))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CartPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(TotalLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(finalTotalPriceLabel)
                .addGap(18, 18, 18)
                .addComponent(placeOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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
                .addComponent(homeIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );
        homeButtonLayout.setVerticalGroup(
            homeButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeButtonLayout.createSequentialGroup()
                .addComponent(homeIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblBlueStrip.add(homeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 28));

        javax.swing.GroupLayout basePanelLayout = new javax.swing.GroupLayout(basePanel);
        basePanel.setLayout(basePanelLayout);
        basePanelLayout.setHorizontalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblGreenStrip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, basePanelLayout.createSequentialGroup()
                .addGap(0, 366, Short.MAX_VALUE)
                .addComponent(HomePage)
                .addGap(367, 367, 367))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, basePanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(CartPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addComponent(lblBlueStrip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(basePanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(DateLabel)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        basePanelLayout.setVerticalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basePanelLayout.createSequentialGroup()
                .addComponent(lblBlueStrip, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HomePage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGreenStrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CartPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CartPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(basePanelLayout.createSequentialGroup()
                    .addGap(0, 259, Short.MAX_VALUE)
                    .addComponent(DateLabel)
                    .addGap(0, 259, Short.MAX_VALUE)))
        );

        getContentPane().add(basePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // DefaultTableModel model = (DefaultTableModel) BookTable.getModel();
        try {
            // Connection con = ConnectionProvider.getCon();
            //Statement st = con.createStatement();
            // ResultSet rs = st.executeQuery("select *from ")

        } catch (Exception e) {
            //  JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_formComponentShown

    private void productTableComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_productTableComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_productTableComponentShown

    private void addToCartButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addToCartButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_addToCartButtonMouseClicked

    private void addToCartButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addToCartButtonMouseEntered
        addToCartButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_addToCartButtonMouseEntered

    private void addToCartButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addToCartButtonMouseExited
        addToCartButton.setBackground(ColorManager.PRIMARY_BLUE);
    }//GEN-LAST:event_addToCartButtonMouseExited

    private void addToCartButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addToCartButtonMousePressed
        addToCartButton.setBackground(ColorManager.DEEP_BLUE);
    }//GEN-LAST:event_addToCartButtonMousePressed

    private void addToCartButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addToCartButtonMouseReleased
        addToCartButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_addToCartButtonMouseReleased

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

    private void placeOrderButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_placeOrderButtonMouseReleased
        placeOrderButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_placeOrderButtonMouseReleased

    private void placeOrderButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_placeOrderButtonMousePressed
        placeOrderButton.setBackground(ColorManager.DEEP_BLUE);
    }//GEN-LAST:event_placeOrderButtonMousePressed

    private void placeOrderButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_placeOrderButtonMouseExited
        placeOrderButton.setBackground(ColorManager.PRIMARY_BLUE);
    }//GEN-LAST:event_placeOrderButtonMouseExited

    private void placeOrderButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_placeOrderButtonMouseEntered
        placeOrderButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_placeOrderButtonMouseEntered

    private void placeOrderButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_placeOrderButtonMouseClicked

    }//GEN-LAST:event_placeOrderButtonMouseClicked

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
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CartLabel;
    private javax.swing.JLabel CartLabel1;
    private javax.swing.JPanel CartPanel;
    private javax.swing.JPanel CartPanel1;
    private javax.swing.JTable CartTable;
    private javax.swing.JLabel DateLabel;
    private javax.swing.JLabel HomePage;
    private javax.swing.JLabel QuantityLabel1;
    private javax.swing.JLabel QuantityLabel3;
    private javax.swing.JTextField QuantityTxt3;
    private javax.swing.JLabel TotalLabel;
    private javax.swing.JPanel addToCartButton;
    private javax.swing.JPanel basePanel;
    private java.awt.Choice choice1;
    private javax.swing.JLabel finalPriceLabel;
    private javax.swing.JLabel finalTotalPriceLabel;
    private javax.swing.JLabel finalTotalPriceLabel1;
    private javax.swing.JPanel homeButton;
    private javax.swing.JLabel homeIcon;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel lblBlueStrip;
    private javax.swing.JPanel lblGreenStrip;
    private javax.swing.JPanel placeOrderButton;
    private javax.swing.JTable productTable;
    // End of variables declaration//GEN-END:variables
}