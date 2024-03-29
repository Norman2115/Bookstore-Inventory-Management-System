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
public class AdminHomePage extends javax.swing.JFrame {

    /**
     * Creates new form Admin_homepage
     */
    public AdminHomePage() {
        initComponents();
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
        toolsBar = new javax.swing.JPanel();
        addProductButton = new javax.swing.JPanel();
        addProductLable = new javax.swing.JLabel();
        deleteProductButton = new javax.swing.JPanel();
        deleteProductLable = new javax.swing.JLabel();
        editProductButton = new javax.swing.JPanel();
        editProductLable = new javax.swing.JLabel();
        restockButton = new javax.swing.JPanel();
        restockLable = new javax.swing.JLabel();
        invoiceButton = new javax.swing.JPanel();
        invoiceLable = new javax.swing.JLabel();
        logoutButton = new javax.swing.JPanel();
        logoutLable = new javax.swing.JLabel();
        viewProductButton = new javax.swing.JPanel();
        viewProductLable = new javax.swing.JLabel();
        welcomePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        topBar = new javax.swing.JPanel();
        userProfilePicturte = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        time1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(253, 252, 248));

        background.setBackground(new java.awt.Color(0, 255, 153));
        background.setPreferredSize(new java.awt.Dimension(1080, 600));

        toolsBar.setBackground(new java.awt.Color(0, 140, 214));
        toolsBar.setAlignmentX(0.0F);
        toolsBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        addProductButton.setBackground(new java.awt.Color(62, 164, 52));
        addProductButton.setPreferredSize(new java.awt.Dimension(138, 138));
        addProductButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addProductButtonMouseEntered(evt);
            }
        });

        addProductLable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addProductLable.setForeground(new java.awt.Color(253, 252, 248));
        addProductLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addProductLable.setText("ADD PRODUCT");
        addProductLable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout addProductButtonLayout = new javax.swing.GroupLayout(addProductButton);
        addProductButton.setLayout(addProductButtonLayout);
        addProductButtonLayout.setHorizontalGroup(
            addProductButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addProductButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addProductLable, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addContainerGap())
        );
        addProductButtonLayout.setVerticalGroup(
            addProductButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addProductButtonLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(addProductLable, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        deleteProductButton.setBackground(new java.awt.Color(62, 164, 52));
        deleteProductButton.setPreferredSize(new java.awt.Dimension(138, 138));

        deleteProductLable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteProductLable.setForeground(new java.awt.Color(253, 252, 248));
        deleteProductLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deleteProductLable.setText("DELETE PRODUCT");
        deleteProductLable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout deleteProductButtonLayout = new javax.swing.GroupLayout(deleteProductButton);
        deleteProductButton.setLayout(deleteProductButtonLayout);
        deleteProductButtonLayout.setHorizontalGroup(
            deleteProductButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteProductButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(deleteProductLable, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addContainerGap())
        );
        deleteProductButtonLayout.setVerticalGroup(
            deleteProductButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteProductButtonLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(deleteProductLable, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        editProductButton.setBackground(new java.awt.Color(62, 164, 52));
        editProductButton.setPreferredSize(new java.awt.Dimension(138, 138));

        editProductLable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editProductLable.setForeground(new java.awt.Color(253, 252, 248));
        editProductLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editProductLable.setText("EDIT PRODUCT");
        editProductLable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout editProductButtonLayout = new javax.swing.GroupLayout(editProductButton);
        editProductButton.setLayout(editProductButtonLayout);
        editProductButtonLayout.setHorizontalGroup(
            editProductButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editProductButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editProductLable, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addContainerGap())
        );
        editProductButtonLayout.setVerticalGroup(
            editProductButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editProductButtonLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(editProductLable, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        restockButton.setBackground(new java.awt.Color(62, 164, 52));
        restockButton.setPreferredSize(new java.awt.Dimension(138, 138));

        restockLable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        restockLable.setForeground(new java.awt.Color(253, 252, 248));
        restockLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        restockLable.setText("RESTOCK");
        restockLable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout restockButtonLayout = new javax.swing.GroupLayout(restockButton);
        restockButton.setLayout(restockButtonLayout);
        restockButtonLayout.setHorizontalGroup(
            restockButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(restockButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(restockLable, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addContainerGap())
        );
        restockButtonLayout.setVerticalGroup(
            restockButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(restockButtonLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(restockLable, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        invoiceButton.setBackground(new java.awt.Color(62, 164, 52));
        invoiceButton.setPreferredSize(new java.awt.Dimension(138, 138));

        invoiceLable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        invoiceLable.setForeground(new java.awt.Color(253, 252, 248));
        invoiceLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invoiceLable.setText("INVOICE");
        invoiceLable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout invoiceButtonLayout = new javax.swing.GroupLayout(invoiceButton);
        invoiceButton.setLayout(invoiceButtonLayout);
        invoiceButtonLayout.setHorizontalGroup(
            invoiceButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(invoiceButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(invoiceLable, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addContainerGap())
        );
        invoiceButtonLayout.setVerticalGroup(
            invoiceButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(invoiceButtonLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(invoiceLable, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        logoutButton.setBackground(new java.awt.Color(62, 164, 52));
        logoutButton.setPreferredSize(new java.awt.Dimension(138, 138));

        logoutLable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logoutLable.setForeground(new java.awt.Color(253, 252, 248));
        logoutLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoutLable.setText("LOGOUT");
        logoutLable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout logoutButtonLayout = new javax.swing.GroupLayout(logoutButton);
        logoutButton.setLayout(logoutButtonLayout);
        logoutButtonLayout.setHorizontalGroup(
            logoutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutLable, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addContainerGap())
        );
        logoutButtonLayout.setVerticalGroup(
            logoutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutButtonLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(logoutLable, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        viewProductButton.setBackground(new java.awt.Color(62, 164, 52));
        viewProductButton.setPreferredSize(new java.awt.Dimension(138, 138));
        viewProductButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewProductButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewProductButtonMouseExited(evt);
            }
        });

        viewProductLable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        viewProductLable.setForeground(new java.awt.Color(253, 252, 248));
        viewProductLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewProductLable.setText("VIEW PRODUCT");
        viewProductLable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout viewProductButtonLayout = new javax.swing.GroupLayout(viewProductButton);
        viewProductButton.setLayout(viewProductButtonLayout);
        viewProductButtonLayout.setHorizontalGroup(
            viewProductButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewProductButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewProductLable, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addContainerGap())
        );
        viewProductButtonLayout.setVerticalGroup(
            viewProductButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewProductButtonLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(viewProductLable, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout toolsBarLayout = new javax.swing.GroupLayout(toolsBar);
        toolsBar.setLayout(toolsBarLayout);
        toolsBarLayout.setHorizontalGroup(
            toolsBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolsBarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(toolsBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addProductButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteProductButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editProductButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(restockButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invoiceButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewProductButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        toolsBarLayout.setVerticalGroup(
            toolsBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolsBarLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(viewProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(addProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(deleteProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(editProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(restockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(invoiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        welcomePanel.setBackground(new java.awt.Color(253, 252, 248));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel2.setText("Inventory Management System");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        jLabel3.setText("Family Bookstore ");

        javax.swing.GroupLayout welcomePanelLayout = new javax.swing.GroupLayout(welcomePanel);
        welcomePanel.setLayout(welcomePanelLayout);
        welcomePanelLayout.setHorizontalGroup(
            welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcomePanelLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        welcomePanelLayout.setVerticalGroup(
            welcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, welcomePanelLayout.createSequentialGroup()
                .addContainerGap(165, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(253, 253, 253))
        );

        topBar.setBackground(new java.awt.Color(0, 140, 214));
        topBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        userProfilePicturte.setText("ICOM");

        date.setText("Date");

        time1.setText("Time");

        javax.swing.GroupLayout topBarLayout = new javax.swing.GroupLayout(topBar);
        topBar.setLayout(topBarLayout);
        topBarLayout.setHorizontalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topBarLayout.createSequentialGroup()
                .addContainerGap(802, Short.MAX_VALUE)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(time1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userProfilePicturte)
                .addGap(36, 36, 36))
        );
        topBarLayout.setVerticalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(time1)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userProfilePicturte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(toolsBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(welcomePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(topBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(topBar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toolsBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(welcomePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewProductButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewProductButtonMouseEntered
        viewProductButton.setBackground(Color.red);
    }//GEN-LAST:event_viewProductButtonMouseEntered

    private void addProductButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addProductButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_addProductButtonMouseEntered

    private void viewProductButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewProductButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_viewProductButtonMouseExited

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
            java.util.logging.Logger.getLogger(AdminHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AdminHomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addProductButton;
    private javax.swing.JLabel addProductLable;
    private javax.swing.JPanel background;
    private javax.swing.JLabel date;
    private javax.swing.JPanel deleteProductButton;
    private javax.swing.JLabel deleteProductLable;
    private javax.swing.JPanel editProductButton;
    private javax.swing.JLabel editProductLable;
    private javax.swing.JPanel invoiceButton;
    private javax.swing.JLabel invoiceLable;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel logoutButton;
    private javax.swing.JLabel logoutLable;
    private javax.swing.JPanel restockButton;
    private javax.swing.JLabel restockLable;
    private javax.swing.JLabel time1;
    private javax.swing.JPanel toolsBar;
    private javax.swing.JPanel topBar;
    private javax.swing.JLabel userProfilePicturte;
    private javax.swing.JPanel viewProductButton;
    private javax.swing.JLabel viewProductLable;
    private javax.swing.JPanel welcomePanel;
    // End of variables declaration//GEN-END:variables
}
