/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bookstoreinventorymanagementsystem;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class ManageSales extends javax.swing.JFrame {

    /**
     * Creates new form ManageInvoice
     */
    public ManageSales() {
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        CartTable = new javax.swing.JTable();
        lblBlueStrip = new javax.swing.JPanel();
        homeButton = new javax.swing.JPanel();
        homeIcon = new javax.swing.JLabel();
        HomePage = new javax.swing.JLabel();
        lblGreenStrip = new javax.swing.JPanel();
        TotalLabel = new javax.swing.JLabel();
        TotalLabel1 = new javax.swing.JLabel();
        TotalLabel2 = new javax.swing.JLabel();
        TotalLabel3 = new javax.swing.JLabel();
        TotalLabel4 = new javax.swing.JLabel();
        TotalLabel7 = new javax.swing.JLabel();
        TotalLabel8 = new javax.swing.JLabel();
        TotalLabel9 = new javax.swing.JLabel();
        placeOrderButton = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 500));

        CartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Book Name", "Quantity", "Price", "Sub Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
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

        HomePage.setBackground(new java.awt.Color(0, 140, 214));
        HomePage.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        HomePage.setForeground(new java.awt.Color(0, 140, 214));
        HomePage.setText("Sales");

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

        TotalLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        TotalLabel.setForeground(new java.awt.Color(0, 100, 0));
        TotalLabel.setText("Bill To: ");

        TotalLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        TotalLabel1.setForeground(new java.awt.Color(0, 100, 0));
        TotalLabel1.setText("Customer Name");

        TotalLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        TotalLabel2.setForeground(new java.awt.Color(0, 100, 0));
        TotalLabel2.setText("salesID");

        TotalLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        TotalLabel3.setForeground(new java.awt.Color(0, 100, 0));
        TotalLabel3.setText("Sales ID:");

        TotalLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        TotalLabel4.setForeground(new java.awt.Color(0, 100, 0));
        TotalLabel4.setText("Sales Date:");

        TotalLabel7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        TotalLabel7.setForeground(new java.awt.Color(0, 100, 0));
        TotalLabel7.setText("salesDate");

        TotalLabel8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        TotalLabel8.setForeground(new java.awt.Color(0, 100, 0));
        TotalLabel8.setText("Total:");

        TotalLabel9.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        TotalLabel9.setForeground(new java.awt.Color(0, 100, 0));
        TotalLabel9.setText("00.0");

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
        jLabel4.setText("Generate Bill");

        javax.swing.GroupLayout placeOrderButtonLayout = new javax.swing.GroupLayout(placeOrderButton);
        placeOrderButton.setLayout(placeOrderButtonLayout);
        placeOrderButtonLayout.setHorizontalGroup(
            placeOrderButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(placeOrderButtonLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel4)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        placeOrderButtonLayout.setVerticalGroup(
            placeOrderButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblGreenStrip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblBlueStrip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(HomePage)
                .addGap(408, 408, 408))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TotalLabel8)
                        .addGap(60, 60, 60)
                        .addComponent(TotalLabel9))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(TotalLabel)
                            .addGap(28, 28, 28)
                            .addComponent(TotalLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(TotalLabel4)
                                .addComponent(TotalLabel3))
                            .addGap(26, 26, 26)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(TotalLabel2)
                                .addComponent(TotalLabel7)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(placeOrderButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblBlueStrip, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HomePage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGreenStrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TotalLabel)
                        .addComponent(TotalLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TotalLabel2)
                            .addComponent(TotalLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TotalLabel7)
                            .addComponent(TotalLabel4))))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TotalLabel8)
                    .addComponent(TotalLabel9))
                .addGap(43, 43, 43)
                .addComponent(placeOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentShown

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

    private void placeOrderButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_placeOrderButtonMouseClicked
       
    }//GEN-LAST:event_placeOrderButtonMouseClicked

    private void placeOrderButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_placeOrderButtonMouseEntered
        placeOrderButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_placeOrderButtonMouseEntered

    private void placeOrderButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_placeOrderButtonMouseExited
        placeOrderButton.setBackground(ColorManager.PRIMARY_BLUE);
    }//GEN-LAST:event_placeOrderButtonMouseExited

    private void placeOrderButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_placeOrderButtonMousePressed
        placeOrderButton.setBackground(ColorManager.DEEP_BLUE);
    }//GEN-LAST:event_placeOrderButtonMousePressed

    private void placeOrderButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_placeOrderButtonMouseReleased
        placeOrderButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_placeOrderButtonMouseReleased

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
            java.util.logging.Logger.getLogger(ManageSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageSales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CartTable;
    private javax.swing.JLabel HomePage;
    private javax.swing.JLabel TotalLabel;
    private javax.swing.JLabel TotalLabel1;
    private javax.swing.JLabel TotalLabel2;
    private javax.swing.JLabel TotalLabel3;
    private javax.swing.JLabel TotalLabel4;
    private javax.swing.JLabel TotalLabel7;
    private javax.swing.JLabel TotalLabel8;
    private javax.swing.JLabel TotalLabel9;
    private javax.swing.JPanel homeButton;
    private javax.swing.JLabel homeIcon;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel lblBlueStrip;
    private javax.swing.JPanel lblGreenStrip;
    private javax.swing.JPanel placeOrderButton;
    // End of variables declaration//GEN-END:variables
}