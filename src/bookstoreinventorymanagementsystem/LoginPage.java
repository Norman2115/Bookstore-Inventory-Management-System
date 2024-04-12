package bookstoreinventorymanagementsystem;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Norman
 */
public class LoginPage extends javax.swing.JFrame {

    private final UserData userData;
    private boolean isUsernameValid;
    private boolean isPasswordValid;

    /**
     * Creates new form LoginPage
     */
    public LoginPage() {
        userData = new UserData();
        isUsernameValid = false;
        isPasswordValid = false;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        RightPanel = new javax.swing.JPanel();
        banner = new javax.swing.JLabel();
        LeftPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        subTitleLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        usernameIcon = new javax.swing.JLabel();
        showHidePasswordIcon = new javax.swing.JLabel();
        forgotPasswordButton = new javax.swing.JLabel();
        loginButton = new javax.swing.JPanel();
        loginLabel = new javax.swing.JLabel();
        dontHaveAccountLabel = new javax.swing.JLabel();
        goToSignUpButton = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        passwordErrorLabel = new javax.swing.JLabel();
        usernameErrorLabel = new javax.swing.JLabel();

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
        titleLabel.setText("<html><font color='#3EA434'>Family</font> <font color='#008CD6'>Bookstore</font></html>");

        subTitleLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        subTitleLabel.setForeground(new java.awt.Color(0, 100, 0));
        subTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subTitleLabel.setText("Hello! Let's get started");

        usernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(0, 100, 0));
        usernameLabel.setText("Username or Email");

        usernameField.setBackground(new java.awt.Color(253, 252, 248));
        usernameField.setForeground(new java.awt.Color(0, 100, 0));
        usernameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });
        usernameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usernameFieldKeyReleased(evt);
            }
        });

        passwordLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(0, 100, 0));
        passwordLabel.setText("Password");

        usernameIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user.png"))); // NOI18N
        usernameIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        showHidePasswordIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        showHidePasswordIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hidePasswordIcon.png"))); // NOI18N
        showHidePasswordIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        showHidePasswordIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showHidePasswordIconMouseClicked(evt);
            }
        });

        forgotPasswordButton.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        forgotPasswordButton.setForeground(new java.awt.Color(0, 100, 0));
        forgotPasswordButton.setText("Forgot Password?");
        forgotPasswordButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgotPasswordButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                forgotPasswordButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                forgotPasswordButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                forgotPasswordButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                forgotPasswordButtonMouseReleased(evt);
            }
        });

        loginButton.setBackground(new java.awt.Color(0, 140, 214));
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                loginButtonMouseReleased(evt);
            }
        });

        loginLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        loginLabel.setForeground(new java.awt.Color(255, 255, 255));
        loginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginLabel.setText("LOGIN");

        javax.swing.GroupLayout loginButtonLayout = new javax.swing.GroupLayout(loginButton);
        loginButton.setLayout(loginButtonLayout);
        loginButtonLayout.setHorizontalGroup(
            loginButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        loginButtonLayout.setVerticalGroup(
            loginButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        dontHaveAccountLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        dontHaveAccountLabel.setForeground(new java.awt.Color(0, 100, 0));
        dontHaveAccountLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dontHaveAccountLabel.setText("Don't have an account?");

        goToSignUpButton.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        goToSignUpButton.setForeground(new java.awt.Color(0, 100, 0));
        goToSignUpButton.setText("Sign up");
        goToSignUpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                goToSignUpButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                goToSignUpButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                goToSignUpButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                goToSignUpButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                goToSignUpButtonMouseReleased(evt);
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
                        .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(LeftPanelLayout.createSequentialGroup()
                                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(usernameIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(LeftPanelLayout.createSequentialGroup()
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(showHidePasswordIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(forgotPasswordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(LeftPanelLayout.createSequentialGroup()
                                .addComponent(dontHaveAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(goToSignUpButton))
                            .addComponent(passwordErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(usernameErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addComponent(usernameLabel)
                .addGap(13, 13, 13)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(usernameField)
                    .addComponent(usernameIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(2, 2, 2)
                .addComponent(usernameErrorLabel)
                .addGap(17, 17, 17)
                .addComponent(passwordLabel)
                .addGap(13, 13, 13)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(showHidePasswordIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(passwordField))
                .addGap(2, 2, 2)
                .addComponent(passwordErrorLabel)
                .addGap(10, 10, 10)
                .addComponent(forgotPasswordButton)
                .addGap(18, 18, 18)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dontHaveAccountLabel)
                    .addComponent(goToSignUpButton))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseClicked
        String usernameOrEmail = usernameField.getText();
        String email = "";

        if (!usernameOrEmail.trim().isEmpty()) {
            try {
                ValidationResult usernameOrEmailValidation = ValidationHandler
                        .validateUsernameOrEmail(usernameOrEmail);
                isUsernameValid = usernameOrEmailValidation.isValid();

                if (usernameOrEmailValidation.isValid()) {
                    if (!usernameOrEmail.contains("@")) {
                        email = UserDAO.readEmailByUsername(usernameOrEmail);
                    } else {
                        email = usernameOrEmail;
                    }
                } else {
                    UIUtils.setFieldErrorState(usernameField);
                    UIUtils.setErrorLabelMessage(usernameErrorLabel,
                            usernameOrEmailValidation.getErrorMessage());
                }
            } catch (SQLException ex) {
                UIUtils.displayErrorMessage(ExceptionMessages.DATABASE_ERROR);
                Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            UIUtils.markFieldAsRequired(usernameField, usernameErrorLabel);
        }

        String password = new String(passwordField.getPassword());

        if (!password.trim().isEmpty()) {
            try {
                String actualPassword = UserDAO.readPasswordByUsernameOrEmail(email);
                ValidationResult passwordMatchValidation = ValidationHandler
                        .checkPasswordMatches(password, actualPassword);
                isPasswordValid = passwordMatchValidation.isValid();

                if (!passwordMatchValidation.isValid()) {
                    UIUtils.setFieldErrorState(passwordField);
                    UIUtils.setErrorLabelMessage(passwordErrorLabel,
                            passwordMatchValidation.getErrorMessage());
                }
            } catch (SQLException ex) {
                UIUtils.displayErrorMessage(ExceptionMessages.DATABASE_ERROR);
                Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            UIUtils.markFieldAsRequired(passwordField, passwordErrorLabel);
        }

        if (isUsernameValid && isPasswordValid) {
            try {
                userData.readUserDataFromDatabase(usernameOrEmail);
                dispose();
                if (userData.getRole() == UserRole.ADMIN) {
                    new AdminHomePage(userData).setVisible(true);
                } else {
                    new SalespersonHomePage().setVisible(true);
                }
            } catch (SQLException ex) {
                UIUtils.displayErrorMessage(ExceptionMessages.DATABASE_ERROR);
                Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                UIUtils.displayErrorMessage(ExceptionMessages.IO_ERROR);
                Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_loginButtonMouseClicked

    private void loginButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseEntered
        loginButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_loginButtonMouseEntered

    private void loginButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseExited
        loginButton.setBackground(ColorManager.PRIMARY_BLUE);
    }//GEN-LAST:event_loginButtonMouseExited

    private void loginButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseReleased
        loginButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_loginButtonMouseReleased

    private void loginButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMousePressed
        loginButton.setBackground(ColorManager.DEEP_BLUE);
    }//GEN-LAST:event_loginButtonMousePressed

    private void forgotPasswordButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPasswordButtonMouseEntered
        forgotPasswordButton.setForeground(ColorManager.PRIMARY_BLUE);
    }//GEN-LAST:event_forgotPasswordButtonMouseEntered

    private void forgotPasswordButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPasswordButtonMouseExited
        forgotPasswordButton.setForeground(ColorManager.DARK_GREEN);
    }//GEN-LAST:event_forgotPasswordButtonMouseExited

    private void forgotPasswordButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPasswordButtonMousePressed
        forgotPasswordButton.setForeground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_forgotPasswordButtonMousePressed

    private void forgotPasswordButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPasswordButtonMouseReleased
        forgotPasswordButton.setForeground(ColorManager.PRIMARY_BLUE);
    }//GEN-LAST:event_forgotPasswordButtonMouseReleased

    private void goToSignUpButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToSignUpButtonMouseEntered
        goToSignUpButton.setForeground(ColorManager.PRIMARY_BLUE);
    }//GEN-LAST:event_goToSignUpButtonMouseEntered

    private void goToSignUpButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToSignUpButtonMouseExited
        goToSignUpButton.setForeground(ColorManager.DARK_GREEN);
    }//GEN-LAST:event_goToSignUpButtonMouseExited

    private void goToSignUpButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToSignUpButtonMousePressed
        goToSignUpButton.setForeground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_goToSignUpButtonMousePressed

    private void goToSignUpButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToSignUpButtonMouseReleased
        goToSignUpButton.setForeground(ColorManager.PRIMARY_BLUE);
    }//GEN-LAST:event_goToSignUpButtonMouseReleased

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void showHidePasswordIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showHidePasswordIconMouseClicked
        UIUtils.togglePasswordVisibility(passwordField, showHidePasswordIcon);
    }//GEN-LAST:event_showHidePasswordIconMouseClicked

    private void goToSignUpButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToSignUpButtonMouseClicked
        dispose();
        new RoleSelectionPage(userData).setVisible(true);
    }//GEN-LAST:event_goToSignUpButtonMouseClicked

    private void RightPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RightPanelMouseClicked
        RightPanel.grabFocus();
    }//GEN-LAST:event_RightPanelMouseClicked

    private void LeftPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeftPanelMouseClicked
        LeftPanel.grabFocus();
    }//GEN-LAST:event_LeftPanelMouseClicked

    private void forgotPasswordButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotPasswordButtonMouseClicked
        dispose();
        new UsernameValidationPage().setVisible(true);
    }//GEN-LAST:event_forgotPasswordButtonMouseClicked

    private void usernameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameFieldKeyReleased
        UIUtils.resetFieldState(usernameField);
        UIUtils.resetErrorLabel(usernameErrorLabel);
    }//GEN-LAST:event_usernameFieldKeyReleased

    private void passwordFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyReleased
        UIUtils.resetFieldState(passwordField);
        UIUtils.resetErrorLabel(passwordErrorLabel);
    }//GEN-LAST:event_passwordFieldKeyReleased

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
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        try {
            DatabaseManager.getConnection().close();
        } catch (ExceptionInInitializerError | SQLException ex) {
            UIUtils.displayErrorMessage(ExceptionMessages.DATABASE_ERROR);
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JPanel RightPanel;
    private javax.swing.JLabel banner;
    private javax.swing.JLabel dontHaveAccountLabel;
    private javax.swing.JLabel forgotPasswordButton;
    private javax.swing.JLabel goToSignUpButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel loginButton;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JLabel passwordErrorLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel showHidePasswordIcon;
    private javax.swing.JLabel subTitleLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel usernameErrorLabel;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameIcon;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
