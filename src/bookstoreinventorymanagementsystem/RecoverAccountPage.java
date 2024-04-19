package bookstoreinventorymanagementsystem;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The class represents user interface for confirming user identity by during
 * the password reset process. Users are required to provide their account
 * username or email for validation
 *
 * @author Teo Chung Henn
 */
public class RecoverAccountPage extends javax.swing.JFrame implements NavigationListener {

    private UserData userData;
    private final NavigationStack<UserData> userDataStack;

    /**
     * Creates new form UsernameValidationPage
     *
     * @param userDataStack the navigation stack used for storing page data
     * history for restoration and navigation.
     */
    public RecoverAccountPage(NavigationStack<UserData> userDataStack) {
        initComponents();
        userData = new UserData();
        this.userDataStack = userDataStack;
    }

    /**
     * Called when returning from the next page in navigation. Restores the page
     * data and updates the field based on the restored data.
     */
    @Override
    public void onReturnFromNextPage() {
        if (userDataStack != null && !userDataStack.isEmpty()) {
            userData = userDataStack.popPageData();

            // Restore the usernameOrEmailField based on whether username or email was used for recovery
            if (userData.isUsingUsernameForRecover()) {
                usernameOrEmailField.setText(userData.getUsername());
            } else {
                usernameOrEmailField.setText(userData.getEmail());
            }
        }
    }

    /**
     * Called when proceeding to the next page in navigation. Pushes the current
     * page data to the stack to maintain navigation history.
     */
    @Override
    public void onProceedToNextPage() {
        if (userDataStack != null) {
            userDataStack.pushPageData(userData);
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
        banner = new javax.swing.JLabel();
        LeftPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        subTitleLabel = new javax.swing.JLabel();
        usernameOrEmailLabel = new javax.swing.JLabel();
        usernameOrEmailField = new javax.swing.JTextField();
        usernameIcon = new javax.swing.JLabel();
        continueButton = new javax.swing.JPanel();
        continueLabel = new javax.swing.JLabel();
        rememberPasswordLabel = new javax.swing.JLabel();
        goToLoginButton = new javax.swing.JLabel();
        usernameOrEmailErrorLabel = new javax.swing.JLabel();

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
        RightPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RightPanelMouseClicked(evt);
            }
        });

        banner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        banner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bookstore_banner.png"))); // NOI18N

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
        titleLabel.setText("<html><font color='#3EA434'>Recover</font> <font color='#008CD6'>Account</font></html>");

        subTitleLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        subTitleLabel.setForeground(new java.awt.Color(0, 100, 0));
        subTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subTitleLabel.setText("Let's confirm your identity");

        usernameOrEmailLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        usernameOrEmailLabel.setForeground(new java.awt.Color(0, 100, 0));
        usernameOrEmailLabel.setText("Username or Email");

        usernameOrEmailField.setBackground(new java.awt.Color(253, 252, 248));
        usernameOrEmailField.setForeground(new java.awt.Color(0, 100, 0));
        usernameOrEmailField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        usernameOrEmailField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameOrEmailFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usernameOrEmailFieldKeyReleased(evt);
            }
        });

        usernameIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user.png"))); // NOI18N
        usernameIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

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

        continueLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        continueLabel.setForeground(new java.awt.Color(255, 255, 255));
        continueLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        continueLabel.setText("CONTINUE");

        javax.swing.GroupLayout continueButtonLayout = new javax.swing.GroupLayout(continueButton);
        continueButton.setLayout(continueButtonLayout);
        continueButtonLayout.setHorizontalGroup(
            continueButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, continueButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(continueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addContainerGap())
        );
        continueButtonLayout.setVerticalGroup(
            continueButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, continueButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(continueLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        rememberPasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        rememberPasswordLabel.setForeground(new java.awt.Color(0, 100, 0));
        rememberPasswordLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rememberPasswordLabel.setText("Remember your password?");

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
                            .addComponent(subTitleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(LeftPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameOrEmailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(LeftPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(rememberPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(goToLoginButton))
                            .addComponent(continueButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(LeftPanelLayout.createSequentialGroup()
                                .addComponent(usernameOrEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(usernameIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(usernameOrEmailErrorLabel))
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
                .addGap(55, 55, 55)
                .addComponent(usernameOrEmailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(usernameOrEmailField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(usernameOrEmailErrorLabel)
                .addGap(25, 25, 25)
                .addComponent(continueButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rememberPasswordLabel)
                    .addComponent(goToLoginButton))
                .addContainerGap(170, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void continueButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_continueButtonMouseClicked
        String usernameOrEmail = usernameOrEmailField.getText();

        // Check if the entered username or email is not empty
        if (!usernameOrEmail.trim().isEmpty()) {
            try {
                // Validate the username or email
                ValidationResult usernameOrEmailValidation = ValidationHandler.validateUsernameOrEmail(usernameOrEmail);

                // If the username or email is valid, retrieve the userdata from the database
                if (usernameOrEmailValidation.isValid()) {
                    try {
                        userData = UserDAO.readUserDataFromDatabase(usernameOrEmail);
                        dispose();
                        onProceedToNextPage();
                        new ResetPasswordEmailVerificationPage(userData, userDataStack).setVisible(true);
                    } catch (IOException ex) {
                        UIUtils.displayErrorMessage(ExceptionMessages.DATABASE_ERROR);
                        Logger.getLogger(RecoverAccountPage.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                    } catch (NullPointerException ex) {
                        UIUtils.displayErrorMessage(ExceptionMessages.NULL_ERROR);
                        Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                    }
                } else {
                    // If the username or email is invalid, mark the field as errorneous and display error message
                    UIUtils.setFieldErrorState(usernameOrEmailField);
                    UIUtils.setErrorLabelMessage(usernameOrEmailErrorLabel, usernameOrEmailValidation.getErrorMessage());
                }
            } catch (SQLException ex) {
                UIUtils.displayErrorMessage(ExceptionMessages.DATABASE_ERROR);
                Logger.getLogger(RecoverAccountPage.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            } catch (NullPointerException ex) {
                UIUtils.displayErrorMessage(ExceptionMessages.NULL_ERROR);
                Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        } else {
            // Mark the username or email field as required if it's empty
            UIUtils.markFieldAsRequired(usernameOrEmailField, usernameOrEmailErrorLabel);
        }
    }//GEN-LAST:event_continueButtonMouseClicked

    private void continueButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_continueButtonMouseEntered
        continueButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_continueButtonMouseEntered

    private void continueButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_continueButtonMouseExited
        continueButton.setBackground(ColorManager.PRIMARY_BLUE);
    }//GEN-LAST:event_continueButtonMouseExited

    private void continueButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_continueButtonMouseReleased
        continueButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_continueButtonMouseReleased

    private void continueButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_continueButtonMousePressed
        continueButton.setBackground(ColorManager.DEEP_BLUE);
    }//GEN-LAST:event_continueButtonMousePressed

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

    private void goToLoginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToLoginButtonMouseClicked
        dispose();
        new LoginPage().setVisible(true);
    }//GEN-LAST:event_goToLoginButtonMouseClicked

    private void LeftPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeftPanelMouseClicked
        LeftPanel.grabFocus();
    }//GEN-LAST:event_LeftPanelMouseClicked

    private void RightPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RightPanelMouseClicked
        RightPanel.grabFocus();
    }//GEN-LAST:event_RightPanelMouseClicked

    private void usernameOrEmailFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameOrEmailFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            LeftPanel.requestFocusInWindow();
        }
    }//GEN-LAST:event_usernameOrEmailFieldKeyPressed

    private void usernameOrEmailFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameOrEmailFieldKeyReleased
        UIUtils.resetFieldState(usernameOrEmailField);
        UIUtils.resetErrorLabel(usernameOrEmailErrorLabel);
    }//GEN-LAST:event_usernameOrEmailFieldKeyReleased

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
            java.util.logging.Logger.getLogger(RecoverAccountPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecoverAccountPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecoverAccountPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecoverAccountPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        java.awt.EventQueue.invokeLater(() -> {
            new RecoverAccountPage(new NavigationStack<>()).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JPanel RightPanel;
    private javax.swing.JLabel banner;
    private javax.swing.JPanel continueButton;
    private javax.swing.JLabel continueLabel;
    private javax.swing.JLabel goToLoginButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel rememberPasswordLabel;
    private javax.swing.JLabel subTitleLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel usernameIcon;
    private javax.swing.JLabel usernameOrEmailErrorLabel;
    private javax.swing.JTextField usernameOrEmailField;
    private javax.swing.JLabel usernameOrEmailLabel;
    // End of variables declaration//GEN-END:variables
}
