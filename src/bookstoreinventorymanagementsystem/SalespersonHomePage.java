/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bookstoreinventorymanagementsystem;

import java.awt.Color;

/**
 *
 * @author User
 */
public class SalespersonHomePage extends javax.swing.JFrame {

    /**
     * Creates new form SalespersonHomePage
     */
    public SalespersonHomePage() {
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
        lblGreenStrip = new javax.swing.JPanel();
        lblBlueStrip = new javax.swing.JPanel();
        HomePage = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pnlCustomer = new javax.swing.JLayeredPane();
        lblCustomer = new javax.swing.JLabel();
        customerIcon = new javax.swing.JLabel();
        Book1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pnlOrder = new javax.swing.JLayeredPane();
        lblOrder = new javax.swing.JLabel();
        orderIcon = new javax.swing.JLabel();
        Book2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        pnlInvoice = new javax.swing.JLayeredPane();
        lblInvoice = new javax.swing.JLabel();
        invoiceIcon = new javax.swing.JLabel();
        Book3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        pnlDashboard = new javax.swing.JLayeredPane();
        lblDashboard = new javax.swing.JLabel();
        iconDashboard = new javax.swing.JLabel();
        Book4 = new javax.swing.JLabel();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        logoutButton = new javax.swing.JPanel();
        logoutLabel = new javax.swing.JLabel();
        Bookshelf = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        basePanel.setBackground(new java.awt.Color(255, 255, 255));
        basePanel.setPreferredSize(new java.awt.Dimension(900, 500));

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

        lblBlueStrip.setBackground(new java.awt.Color(0, 140, 214));
        lblBlueStrip.setForeground(new java.awt.Color(51, 102, 255));

        javax.swing.GroupLayout lblBlueStripLayout = new javax.swing.GroupLayout(lblBlueStrip);
        lblBlueStrip.setLayout(lblBlueStripLayout);
        lblBlueStripLayout.setHorizontalGroup(
            lblBlueStripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        lblBlueStripLayout.setVerticalGroup(
            lblBlueStripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        HomePage.setBackground(new java.awt.Color(0, 140, 214));
        HomePage.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        HomePage.setForeground(new java.awt.Color(0, 140, 214));
        HomePage.setText("Home Page");

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlCustomer.setBackground(new java.awt.Color(255, 255, 255));
        pnlCustomer.setOpaque(true);
        pnlCustomer.setPreferredSize(new java.awt.Dimension(150, 160));
        pnlCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlCustomerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlCustomerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlCustomerMouseExited(evt);
            }
        });
        pnlCustomer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCustomer.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCustomer.setForeground(new java.awt.Color(0, 140, 214));
        lblCustomer.setText("Customer");
        pnlCustomer.add(lblCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 90, 30));

        customerIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Customer (icon).png"))); // NOI18N
        pnlCustomer.add(customerIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, -1, 110));

        jPanel1.add(pnlCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 16, 141, 165));

        Book1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Book (icon).png"))); // NOI18N
        Book1.setText("jLabel2");
        jPanel1.add(Book1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 12, 160, -1));

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlOrder.setBackground(new java.awt.Color(255, 255, 255));
        pnlOrder.setOpaque(true);
        pnlOrder.setPreferredSize(new java.awt.Dimension(150, 160));
        pnlOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlOrderMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlOrderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlOrderMouseExited(evt);
            }
        });
        pnlOrder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblOrder.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblOrder.setForeground(new java.awt.Color(0, 140, 214));
        lblOrder.setText("Order");
        pnlOrder.add(lblOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 130, 50, 30));

        orderIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Book Order (icon).png"))); // NOI18N
        pnlOrder.add(orderIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, -1, 120));

        jPanel2.add(pnlOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 16, 141, 165));

        Book2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Book (icon).png"))); // NOI18N
        Book2.setText("jLabel2");
        jPanel2.add(Book2, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 12, 160, -1));

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlInvoice.setBackground(new java.awt.Color(255, 255, 255));
        pnlInvoice.setOpaque(true);
        pnlInvoice.setPreferredSize(new java.awt.Dimension(150, 160));
        pnlInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlInvoiceMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlInvoiceMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlInvoiceMouseExited(evt);
            }
        });
        pnlInvoice.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblInvoice.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblInvoice.setForeground(new java.awt.Color(0, 140, 214));
        lblInvoice.setText("Invoice");
        pnlInvoice.add(lblInvoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 70, 30));

        invoiceIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Invoice(icon).png"))); // NOI18N
        pnlInvoice.add(invoiceIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 7, 110, 130));

        jPanel4.add(pnlInvoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 16, 141, 165));

        Book3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Book (icon).png"))); // NOI18N
        Book3.setText("jLabel2");
        jPanel4.add(Book3, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 12, 160, -1));

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlDashboard.setBackground(new java.awt.Color(255, 255, 255));
        pnlDashboard.setOpaque(true);
        pnlDashboard.setPreferredSize(new java.awt.Dimension(150, 160));
        pnlDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlDashboardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlDashboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlDashboardMouseExited(evt);
            }
        });
        pnlDashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDashboard.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDashboard.setForeground(new java.awt.Color(0, 140, 214));
        lblDashboard.setText("Dashboard");
        pnlDashboard.add(lblDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 130, 100, 30));

        iconDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Dashboard (icon).png"))); // NOI18N
        pnlDashboard.add(iconDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, -1, 110));

        jPanel5.add(pnlDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 16, 141, 165));

        Book4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Book (icon).png"))); // NOI18N
        Book4.setText("jLabel2");
        jPanel5.add(Book4, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 12, 160, -1));

        jLayeredPane3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoutButton.setBackground(new java.awt.Color(0, 200, 0));
        logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logoutButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                logoutButtonMouseReleased(evt);
            }
        });

        logoutLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logoutLabel.setForeground(new java.awt.Color(255, 255, 255));
        logoutLabel.setText("LOGOUT");

        javax.swing.GroupLayout logoutButtonLayout = new javax.swing.GroupLayout(logoutButton);
        logoutButton.setLayout(logoutButtonLayout);
        logoutButtonLayout.setHorizontalGroup(
            logoutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutButtonLayout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(logoutLabel)
                .addContainerGap(284, Short.MAX_VALUE))
        );
        logoutButtonLayout.setVerticalGroup(
            logoutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logoutLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        jLayeredPane3.add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(78, 26, 625, 27));

        Bookshelf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Bookshelf icon.png"))); // NOI18N
        jLayeredPane3.add(Bookshelf, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 13, 681, 122));

        javax.swing.GroupLayout basePanelLayout = new javax.swing.GroupLayout(basePanel);
        basePanel.setLayout(basePanelLayout);
        basePanelLayout.setHorizontalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBlueStrip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblGreenStrip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, basePanelLayout.createSequentialGroup()
                .addContainerGap(385, Short.MAX_VALUE)
                .addComponent(HomePage)
                .addGap(384, 384, 384))
            .addGroup(basePanelLayout.createSequentialGroup()
                .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(basePanelLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(basePanelLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        basePanelLayout.setVerticalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, basePanelLayout.createSequentialGroup()
                .addComponent(lblBlueStrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HomePage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGreenStrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLayeredPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
        );

        getContentPane().add(basePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCustomerMouseClicked
        new ManageCustomer().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_pnlCustomerMouseClicked

    private void pnlCustomerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCustomerMouseEntered
        pnlCustomer.setBackground(ColorManager.LIGHT_BLUE);
    }//GEN-LAST:event_pnlCustomerMouseEntered

    private void pnlOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlOrderMouseClicked
        new ManageOrder().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_pnlOrderMouseClicked

    private void pnlOrderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlOrderMouseEntered
        pnlOrder.setBackground(ColorManager.LIGHT_BLUE);
    }//GEN-LAST:event_pnlOrderMouseEntered

    private void pnlInvoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlInvoiceMouseClicked
        new ManageInvoice().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_pnlInvoiceMouseClicked

    private void pnlInvoiceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlInvoiceMouseEntered
        pnlInvoice.setBackground(ColorManager.LIGHT_BLUE);
    }//GEN-LAST:event_pnlInvoiceMouseEntered

    private void pnlDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDashboardMouseClicked
        new ManageDashboard().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_pnlDashboardMouseClicked

    private void pnlDashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDashboardMouseEntered
        pnlDashboard.setBackground(ColorManager.LIGHT_BLUE);
    }//GEN-LAST:event_pnlDashboardMouseEntered

    private void pnlCustomerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCustomerMouseExited
        pnlCustomer.setBackground(ColorManager.PRIMARY_WHITE);
    }//GEN-LAST:event_pnlCustomerMouseExited

    private void pnlOrderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlOrderMouseExited
        pnlOrder.setBackground(ColorManager.PRIMARY_WHITE);
    }//GEN-LAST:event_pnlOrderMouseExited

    private void pnlInvoiceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlInvoiceMouseExited
        pnlInvoice.setBackground(ColorManager.PRIMARY_WHITE);
    }//GEN-LAST:event_pnlInvoiceMouseExited

    private void pnlDashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDashboardMouseExited
        pnlDashboard.setBackground(ColorManager.PRIMARY_WHITE);
    }//GEN-LAST:event_pnlDashboardMouseExited

    private void logoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_logoutButtonMouseClicked

    private void logoutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseEntered
        logoutButton.setBackground(ColorManager.MEDIUM_GREEN);
    }//GEN-LAST:event_logoutButtonMouseEntered

    private void logoutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseExited
        logoutButton.setBackground(ColorManager.LIGHT_GREEN);
    }//GEN-LAST:event_logoutButtonMouseExited

    private void logoutButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMousePressed
        logoutButton.setBackground(ColorManager.DEEP_GREEN);
    }//GEN-LAST:event_logoutButtonMousePressed

    private void logoutButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseReleased
        logoutButton.setBackground(ColorManager.MEDIUM_GREEN);
    }//GEN-LAST:event_logoutButtonMouseReleased

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SalespersonHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalespersonHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalespersonHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalespersonHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalespersonHomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Book1;
    private javax.swing.JLabel Book2;
    private javax.swing.JLabel Book3;
    private javax.swing.JLabel Book4;
    private javax.swing.JLabel Bookshelf;
    private javax.swing.JLabel HomePage;
    private javax.swing.JPanel basePanel;
    private javax.swing.JLabel customerIcon;
    private javax.swing.JLabel iconDashboard;
    private javax.swing.JLabel invoiceIcon;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel lblBlueStrip;
    private javax.swing.JLabel lblCustomer;
    private javax.swing.JLabel lblDashboard;
    private javax.swing.JPanel lblGreenStrip;
    private javax.swing.JLabel lblInvoice;
    private javax.swing.JLabel lblOrder;
    private javax.swing.JPanel logoutButton;
    private javax.swing.JLabel logoutLabel;
    private javax.swing.JLabel orderIcon;
    private javax.swing.JLayeredPane pnlCustomer;
    private javax.swing.JLayeredPane pnlDashboard;
    private javax.swing.JLayeredPane pnlInvoice;
    private javax.swing.JLayeredPane pnlOrder;
    // End of variables declaration//GEN-END:variables
}
