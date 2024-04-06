package bookstoreinventorymanagementsystem;

/**
 *
 * @author Norman
 */
public class ResetPasswordPage extends javax.swing.JFrame {

    private final UserData userData;
    
    /**
     * Creates new form LoginPage
     */
    public ResetPasswordPage() {
        initComponents();
        userData = UserData.getInstance();
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
        basePanel = new javax.swing.JPanel();
        RightPanel = new javax.swing.JPanel();
        banner = new javax.swing.JLabel();
        LeftPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        subTitleLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        showHidePasswordIcon = new javax.swing.JLabel();
        confirmButton = new javax.swing.JPanel();
        confirmLabel = new javax.swing.JLabel();
        dontHaveAccountLabel = new javax.swing.JLabel();
        goToLoginButton = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        confirmPasswordLabel = new javax.swing.JLabel();
        confirmPasswordField = new javax.swing.JPasswordField();
        showHideConfirmPasswordIcon = new javax.swing.JLabel();
        passwordErrorLabel = new javax.swing.JLabel();
        confirmPasswordErrorLabel = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");

        basePanel.setBackground(new java.awt.Color(204, 204, 204));
        basePanel.setToolTipText("");
        basePanel.setPreferredSize(new java.awt.Dimension(900, 500));

        RightPanel.setBackground(new java.awt.Color(62, 164, 52));
        RightPanel.setPreferredSize(new java.awt.Dimension(450, 500));
        RightPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RightPanelMouseClicked(evt);
            }
        });

        banner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        banner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/banner_16.png"))); // NOI18N

        javax.swing.GroupLayout RightPanelLayout = new javax.swing.GroupLayout(RightPanel);
        RightPanel.setLayout(RightPanelLayout);
        RightPanelLayout.setHorizontalGroup(
            RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(banner, javax.swing.GroupLayout.PREFERRED_SIZE, 438, Short.MAX_VALUE)
                .addContainerGap())
        );
        RightPanelLayout.setVerticalGroup(
            RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(banner, javax.swing.GroupLayout.PREFERRED_SIZE, 488, Short.MAX_VALUE)
                .addContainerGap())
        );

        LeftPanel.setBackground(new java.awt.Color(253, 252, 248));
        LeftPanel.setPreferredSize(new java.awt.Dimension(450, 500));
        LeftPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LeftPanelMouseClicked(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("<html><font color='#3EA434'>Reset</font> <font color='#008CD6'>Password</font></html>");

        subTitleLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        subTitleLabel.setForeground(new java.awt.Color(0, 100, 0));
        subTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subTitleLabel.setText("New password should be different from old one");

        passwordLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(0, 100, 0));
        passwordLabel.setText("Password");

        showHidePasswordIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        showHidePasswordIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hidePasswordIcon.png"))); // NOI18N
        showHidePasswordIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        showHidePasswordIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showHidePasswordIconMouseClicked(evt);
            }
        });

        confirmButton.setBackground(new java.awt.Color(0, 140, 214));
        confirmButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                confirmButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                confirmButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                confirmButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                confirmButtonMouseReleased(evt);
            }
        });

        confirmLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        confirmLabel.setForeground(new java.awt.Color(255, 255, 255));
        confirmLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        confirmLabel.setText("CONFIRM");

        javax.swing.GroupLayout confirmButtonLayout = new javax.swing.GroupLayout(confirmButton);
        confirmButton.setLayout(confirmButtonLayout);
        confirmButtonLayout.setHorizontalGroup(
            confirmButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, confirmButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(confirmLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        confirmButtonLayout.setVerticalGroup(
            confirmButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, confirmButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(confirmLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        dontHaveAccountLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        dontHaveAccountLabel.setForeground(new java.awt.Color(0, 100, 0));
        dontHaveAccountLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dontHaveAccountLabel.setText("Remember your password?");

        goToLoginButton.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        goToLoginButton.setForeground(new java.awt.Color(0, 100, 0));
        goToLoginButton.setText("Login");
        goToLoginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goToLoginButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                goToLoginButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                goToLoginButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                goToLoginButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                goToLoginButtonMouseReleased(evt);
            }
        });

        passwordField.setBackground(new java.awt.Color(253, 252, 248));
        passwordField.setForeground(new java.awt.Color(0, 100, 0));
        passwordField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        passwordField.setEchoChar('\u2022');
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                passwordFieldKeyReleased(evt);
            }
        });

        confirmPasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        confirmPasswordLabel.setForeground(new java.awt.Color(0, 100, 0));
        confirmPasswordLabel.setText("Confirm Password");

        confirmPasswordField.setBackground(new java.awt.Color(253, 252, 248));
        confirmPasswordField.setForeground(new java.awt.Color(0, 100, 0));
        confirmPasswordField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        confirmPasswordField.setEchoChar('\u2022');
        confirmPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmPasswordFieldActionPerformed(evt);
            }
        });
        confirmPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                confirmPasswordFieldKeyReleased(evt);
            }
        });

        showHideConfirmPasswordIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        showHideConfirmPasswordIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hidePasswordIcon.png"))); // NOI18N
        showHideConfirmPasswordIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        showHideConfirmPasswordIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showHideConfirmPasswordIconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout LeftPanelLayout = new javax.swing.GroupLayout(LeftPanel);
        LeftPanel.setLayout(LeftPanelLayout);
        LeftPanelLayout.setHorizontalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeftPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(subTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(LeftPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(confirmButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(LeftPanelLayout.createSequentialGroup()
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(showHidePasswordIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(confirmPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftPanelLayout.createSequentialGroup()
                                .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(showHideConfirmPasswordIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(passwordErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(confirmPasswordErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(LeftPanelLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(dontHaveAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(goToLoginButton)))
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addContainerGap())
        );
        LeftPanelLayout.setVerticalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subTitleLabel)
                .addGap(29, 29, 29)
                .addComponent(passwordLabel)
                .addGap(13, 13, 13)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(showHidePasswordIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(passwordErrorLabel)
                .addGap(15, 15, 15)
                .addComponent(confirmPasswordLabel)
                .addGap(13, 13, 13)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(showHideConfirmPasswordIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(confirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(confirmPasswordErrorLabel)
                .addGap(25, 25, 25)
                .addComponent(confirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dontHaveAccountLabel)
                    .addComponent(goToLoginButton))
                .addContainerGap(112, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout basePanelLayout = new javax.swing.GroupLayout(basePanel);
        basePanel.setLayout(basePanelLayout);
        basePanelLayout.setHorizontalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basePanelLayout.createSequentialGroup()
                .addComponent(RightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LeftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        basePanelLayout.setVerticalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basePanelLayout.createSequentialGroup()
                .addGroup(basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LeftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(basePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(basePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void confirmButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmButtonMouseClicked
        // Navigate
    }//GEN-LAST:event_confirmButtonMouseClicked

    private void confirmButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmButtonMouseEntered
        confirmButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_confirmButtonMouseEntered

    private void confirmButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmButtonMouseExited
        confirmButton.setBackground(ColorManager.PRIMARY_BLUE);
    }//GEN-LAST:event_confirmButtonMouseExited

    private void confirmButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmButtonMouseReleased
        confirmButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_confirmButtonMouseReleased

    private void confirmButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmButtonMousePressed
        confirmButton.setBackground(ColorManager.DEEP_BLUE);
    }//GEN-LAST:event_confirmButtonMousePressed

    private void goToLoginButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToLoginButtonMouseEntered
        goToLoginButton.setForeground(ColorManager.PRIMARY_BLUE);
    }//GEN-LAST:event_goToLoginButtonMouseEntered

    private void goToLoginButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToLoginButtonMouseExited
        goToLoginButton.setForeground(ColorManager.DARK_GREEN);
    }//GEN-LAST:event_goToLoginButtonMouseExited

    private void goToLoginButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToLoginButtonMousePressed
        goToLoginButton.setForeground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_goToLoginButtonMousePressed

    private void goToLoginButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToLoginButtonMouseReleased
        goToLoginButton.setForeground(ColorManager.PRIMARY_BLUE);
    }//GEN-LAST:event_goToLoginButtonMouseReleased

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void showHidePasswordIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showHidePasswordIconMouseClicked
        UIUtils.togglePasswordVisibility(passwordField, showHidePasswordIcon);
    }//GEN-LAST:event_showHidePasswordIconMouseClicked

    private void goToLoginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToLoginButtonMouseClicked
        dispose();
        // new RoleSelectionPage().setVisible(true);
        new LoginPage().setVisible(true);
    }//GEN-LAST:event_goToLoginButtonMouseClicked

    private void RightPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RightPanelMouseClicked
        RightPanel.grabFocus();
    }//GEN-LAST:event_RightPanelMouseClicked

    private void LeftPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeftPanelMouseClicked
        LeftPanel.grabFocus();
    }//GEN-LAST:event_LeftPanelMouseClicked

    private void confirmPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmPasswordFieldActionPerformed

    private void showHideConfirmPasswordIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showHideConfirmPasswordIconMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_showHideConfirmPasswordIconMouseClicked

    private void passwordFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyReleased
        String password = new String(passwordField.getPassword());
        ValidationResult passwordValidation = ValidationHandler.validatePassword(password);
        UIUtils.setFieldErrorState(passwordField, passwordErrorLabel, passwordValidation);
        confirmPasswordFieldKeyReleased(evt);
    }//GEN-LAST:event_passwordFieldKeyReleased

    private void confirmPasswordFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmPasswordFieldKeyReleased
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());
        ValidationResult confirmPasswordValidation 
                = ValidationHandler.confirmPasswordMatches(password, confirmPassword);
        UIUtils.setFieldErrorState(confirmPasswordField, confirmPasswordErrorLabel, 
                confirmPasswordValidation);
    }//GEN-LAST:event_confirmPasswordFieldKeyReleased

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
            java.util.logging.Logger.getLogger(ResetPasswordPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResetPasswordPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResetPasswordPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResetPasswordPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResetPasswordPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JPanel RightPanel;
    private javax.swing.JLabel banner;
    private javax.swing.JPanel basePanel;
    private javax.swing.JPanel confirmButton;
    private javax.swing.JLabel confirmLabel;
    private javax.swing.JLabel confirmPasswordErrorLabel;
    private javax.swing.JPasswordField confirmPasswordField;
    private javax.swing.JLabel confirmPasswordLabel;
    private javax.swing.JLabel dontHaveAccountLabel;
    private javax.swing.JLabel goToLoginButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel passwordErrorLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel showHideConfirmPasswordIcon;
    private javax.swing.JLabel showHidePasswordIcon;
    private javax.swing.JLabel subTitleLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
