package bookstoreinventorymanagementsystem;

/**
 *
 * @author Norman
 */
public class RoleSelectionPage extends javax.swing.JFrame {

    private boolean isAdminSelected = false;
    private boolean isSalespersonSelected = false;

    /**
     * Creates new form RoleSelectionPage
     */
    public RoleSelectionPage() {
        initComponents();
        jLabel1.setText("<html><font color='#3EA434'>What's</font> "
                + "<font color='#008CD6'>Your Role?</font></html>");
    }

    /**
     * Updates the UI components based on the selected role.
     *
     * @param isAdminSelected {@code true} if the admin role is selected,
     * {@code false} if the salesperson role is selected
     */
    public void handleRoleSelection(boolean isAdminSelected) {
        this.isAdminSelected = isAdminSelected;
        this.isSalespersonSelected = !isAdminSelected;

        if (isAdminSelected) {
            salespersonRole.setBorder(javax.swing.BorderFactory
                    .createLineBorder(ColorManager.MEDIUM_GREY));
            salespersonIcon.setIcon(new javax.swing.ImageIcon(getClass()
                    .getResource("/icon/salesperson_unselected.png")));
            salespersonText.setForeground(ColorManager.LIGHT_GREY);

            adminRole.setBorder(javax.swing.BorderFactory
                    .createLineBorder(new java.awt.Color(62, 164, 52)));
            adminRole.setBackground(ColorManager.PRIMARY_WHITE);
            adminIcon.setIcon(new javax.swing.ImageIcon(getClass()
                    .getResource("/icon/admin_selected.png")));
            adminText.setForeground(ColorManager.DARK_GREEN);
        } else {
            adminRole.setBorder(javax.swing.BorderFactory
                    .createLineBorder(ColorManager.MEDIUM_GREY));
            adminIcon.setIcon(new javax.swing.ImageIcon(getClass()
                    .getResource("/icon/admin_unselected.png")));
            adminText.setForeground(ColorManager.LIGHT_GREY);

            salespersonRole.setBorder(javax.swing.BorderFactory
                    .createLineBorder(new java.awt.Color(62, 164, 52)));
            salespersonRole.setBackground(ColorManager.PRIMARY_WHITE);
            salespersonIcon.setIcon(new javax.swing.ImageIcon(getClass()
                    .getResource("/icon/salesperson_selected.png")));
            salespersonText.setForeground(ColorManager.DARK_GREEN);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        RightPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        LeftPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        continueButton = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        loginLink = new javax.swing.JLabel();
        adminRole = new javax.swing.JPanel();
        adminIcon = new javax.swing.JLabel();
        adminText = new javax.swing.JLabel();
        salespersonRole = new javax.swing.JPanel();
        salespersonIcon = new javax.swing.JLabel();
        salespersonText = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 500));

        RightPanel.setBackground(new java.awt.Color(62, 164, 52));
        RightPanel.setPreferredSize(new java.awt.Dimension(450, 500));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/BookstorePic.png"))); // NOI18N

        javax.swing.GroupLayout RightPanelLayout = new javax.swing.GroupLayout(RightPanel);
        RightPanel.setLayout(RightPanelLayout);
        RightPanelLayout.setHorizontalGroup(
            RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 438, Short.MAX_VALUE)
                .addContainerGap())
        );
        RightPanelLayout.setVerticalGroup(
            RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addContainerGap())
        );

        LeftPanel.setBackground(new java.awt.Color(253, 252, 248));
        LeftPanel.setPreferredSize(new java.awt.Dimension(450, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("What's Your Role");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 100, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Please choose a role to continue");

        continueButton.setBackground(new java.awt.Color(0, 140, 214));
        continueButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                continueButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                continueButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                continueButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                continueButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                continueButtonMouseReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("CONTINUE");

        javax.swing.GroupLayout continueButtonLayout = new javax.swing.GroupLayout(continueButton);
        continueButton.setLayout(continueButtonLayout);
        continueButtonLayout.setHorizontalGroup(
            continueButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, continueButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addContainerGap())
        );
        continueButtonLayout.setVerticalGroup(
            continueButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, continueButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 100, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Already have an account?");

        loginLink.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        loginLink.setForeground(new java.awt.Color(0, 100, 0));
        loginLink.setText("Login");
        loginLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginLinkMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginLinkMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginLinkMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginLinkMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                loginLinkMouseReleased(evt);
            }
        });

        adminRole.setBackground(new java.awt.Color(253, 252, 248));
        adminRole.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        adminRole.setPreferredSize(new java.awt.Dimension(186, 181));
        adminRole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminRoleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                adminRoleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                adminRoleMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                adminRoleMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                adminRoleMouseReleased(evt);
            }
        });

        adminIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/admin_unselected.png"))); // NOI18N

        adminText.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        adminText.setForeground(new java.awt.Color(230, 230, 230));
        adminText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminText.setText("Administrator");

        javax.swing.GroupLayout adminRoleLayout = new javax.swing.GroupLayout(adminRole);
        adminRole.setLayout(adminRoleLayout);
        adminRoleLayout.setHorizontalGroup(
            adminRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminRoleLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(adminIcon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminRoleLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(adminText, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        adminRoleLayout.setVerticalGroup(
            adminRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminRoleLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(adminIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminText)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        salespersonRole.setBackground(new java.awt.Color(253, 252, 248));
        salespersonRole.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        salespersonRole.setPreferredSize(new java.awt.Dimension(186, 181));
        salespersonRole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salespersonRoleMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                salespersonRoleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                salespersonRoleMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                salespersonRoleMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                salespersonRoleMouseReleased(evt);
            }
        });

        salespersonIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/salesperson_unselected.png"))); // NOI18N

        salespersonText.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        salespersonText.setForeground(new java.awt.Color(230, 230, 230));
        salespersonText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salespersonText.setText("Salesperson");

        javax.swing.GroupLayout salespersonRoleLayout = new javax.swing.GroupLayout(salespersonRole);
        salespersonRole.setLayout(salespersonRoleLayout);
        salespersonRoleLayout.setHorizontalGroup(
            salespersonRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salespersonRoleLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(salespersonRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(salespersonIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salespersonText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        salespersonRoleLayout.setVerticalGroup(
            salespersonRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salespersonRoleLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(salespersonIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salespersonText)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout LeftPanelLayout = new javax.swing.GroupLayout(LeftPanel);
        LeftPanel.setLayout(LeftPanelLayout);
        LeftPanelLayout.setHorizontalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeftPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(LeftPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(continueButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftPanelLayout.createSequentialGroup()
                                .addComponent(adminRole, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(salespersonRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(LeftPanelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(loginLink)))
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addContainerGap())
        );
        LeftPanelLayout.setVerticalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(adminRole, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(salespersonRole, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(continueButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(loginLink))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(RightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LeftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LeftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void continueButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_continueButtonMouseClicked
        // Navigate
    }//GEN-LAST:event_continueButtonMouseClicked

    private void continueButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_continueButtonMouseEntered
        continueButton.setBackground(new java.awt.Color(0, 113, 176));
    }//GEN-LAST:event_continueButtonMouseEntered

    private void continueButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_continueButtonMouseExited
        continueButton.setBackground(new java.awt.Color(0, 140, 214));
    }//GEN-LAST:event_continueButtonMouseExited

    private void continueButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_continueButtonMouseReleased
        continueButton.setBackground(new java.awt.Color(0, 113, 176));
    }//GEN-LAST:event_continueButtonMouseReleased

    private void continueButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_continueButtonMousePressed
        continueButton.setBackground(new java.awt.Color(0, 92, 143));
    }//GEN-LAST:event_continueButtonMousePressed

    private void loginLinkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginLinkMouseEntered
        loginLink.setForeground(new java.awt.Color(0, 140, 214));
    }//GEN-LAST:event_loginLinkMouseEntered

    private void loginLinkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginLinkMouseExited
        loginLink.setForeground(new java.awt.Color(0, 100, 0));
    }//GEN-LAST:event_loginLinkMouseExited

    private void loginLinkMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginLinkMousePressed
        loginLink.setForeground(new java.awt.Color(0, 113, 176));
    }//GEN-LAST:event_loginLinkMousePressed

    private void loginLinkMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginLinkMouseReleased
        loginLink.setForeground(new java.awt.Color(0, 140, 214));
    }//GEN-LAST:event_loginLinkMouseReleased

    private void adminRoleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminRoleMouseClicked
        handleRoleSelection(true);
    }//GEN-LAST:event_adminRoleMouseClicked

    private void salespersonRoleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salespersonRoleMouseClicked
        handleRoleSelection(false);
    }//GEN-LAST:event_salespersonRoleMouseClicked

    private void adminRoleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminRoleMouseEntered
        if (!isAdminSelected) {
            adminRole.setBackground(ColorManager.DARK_GREY);
        }
    }//GEN-LAST:event_adminRoleMouseEntered

    private void adminRoleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminRoleMouseExited
        if (!isAdminSelected) {
            adminRole.setBackground(ColorManager.PRIMARY_WHITE);
        }
    }//GEN-LAST:event_adminRoleMouseExited

    private void salespersonRoleMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salespersonRoleMouseEntered
        if (!isSalespersonSelected) {
            salespersonRole.setBackground(ColorManager.DARK_GREY);
        }
    }//GEN-LAST:event_salespersonRoleMouseEntered

    private void salespersonRoleMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salespersonRoleMouseExited
        if (!isSalespersonSelected) {
            salespersonRole.setBackground(ColorManager.PRIMARY_WHITE);
        }
    }//GEN-LAST:event_salespersonRoleMouseExited

    private void loginLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginLinkMouseClicked
        dispose();
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
    }//GEN-LAST:event_loginLinkMouseClicked

    private void adminRoleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminRoleMousePressed
        if (!isAdminSelected) {
            adminRole.setBackground(ColorManager.DEEP_GREY);
        }
    }//GEN-LAST:event_adminRoleMousePressed

    private void adminRoleMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminRoleMouseReleased
        if (!isAdminSelected) {
            adminRole.setBackground(ColorManager.DARK_GREY);
        }
    }//GEN-LAST:event_adminRoleMouseReleased

    private void salespersonRoleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salespersonRoleMousePressed
        if (!isSalespersonSelected) {
            salespersonRole.setBackground(ColorManager.DEEP_GREY);
        }
    }//GEN-LAST:event_salespersonRoleMousePressed

    private void salespersonRoleMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salespersonRoleMouseReleased
        if (!isSalespersonSelected) {
            salespersonRole.setBackground(ColorManager.DARK_GREY);
        }
    }//GEN-LAST:event_salespersonRoleMouseReleased

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
            java.util.logging.Logger.getLogger(RoleSelectionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RoleSelectionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RoleSelectionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RoleSelectionPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RoleSelectionPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JPanel RightPanel;
    private javax.swing.JLabel adminIcon;
    private javax.swing.JPanel adminRole;
    private javax.swing.JLabel adminText;
    private javax.swing.JPanel continueButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel loginLink;
    private javax.swing.JLabel salespersonIcon;
    private javax.swing.JPanel salespersonRole;
    private javax.swing.JLabel salespersonText;
    // End of variables declaration//GEN-END:variables
}
