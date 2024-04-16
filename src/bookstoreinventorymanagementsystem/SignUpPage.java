package bookstoreinventorymanagementsystem;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The class represents the user interface for signing up to the bookstore
 * inventory management system. Users are required to provide their full name,
 * email address, username, and password for registration.
 *
 * @author Teo Chung Henn
 */
public class SignUpPage extends javax.swing.JFrame {

    private final UserData userData;
    private boolean isFullNameValid;
    private boolean isUsernameValid;
    private boolean isPasswordValid;
    private boolean isEmailValid;
    private String fullName;
    private String username;
    private String password;
    private String email;

    /**
     * Creates new form SignUpPage.
     *
     * @param userData UserData object to store user data, passed from
     * RoleSelectionPage class.
     */
    public SignUpPage(UserData userData) {
        initComponents();
        this.userData = userData;
        isFullNameValid = false;
        isUsernameValid = false;
        isPasswordValid = false;
        isEmailValid = false;
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
        fullNameLabel = new javax.swing.JLabel();
        fullNameField = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        fullNameIcon = new javax.swing.JLabel();
        showHidePasswordIcon = new javax.swing.JLabel();
        signUpButton = new javax.swing.JPanel();
        signUpLabel = new javax.swing.JLabel();
        alreadyHaveAnAccountLabel = new javax.swing.JLabel();
        goToLoginButton = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        emailErrorLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        emailIcon = new javax.swing.JLabel();
        fullNameErrorLabel = new javax.swing.JLabel();
        usernameErrorLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        usernameIcon = new javax.swing.JLabel();
        passwordErrorLabel = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");

        basePanel.setBackground(new java.awt.Color(204, 204, 204));
        basePanel.setToolTipText("");
        basePanel.setPreferredSize(new java.awt.Dimension(900, 500));
        basePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                basePanelMouseClicked(evt);
            }
        });

        RightPanel.setBackground(new java.awt.Color(62, 164, 52));
        RightPanel.setPreferredSize(new java.awt.Dimension(450, 500));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(banner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        LeftPanel.setBackground(new java.awt.Color(253, 252, 248));
        LeftPanel.setPreferredSize(new java.awt.Dimension(450, 500));

        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("<html><font color='#3EA434'>Craft </font><font color='#008CD6'>Your Account</font></html>");

        fullNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        fullNameLabel.setForeground(new java.awt.Color(0, 100, 0));
        fullNameLabel.setText("Full Name");

        fullNameField.setBackground(new java.awt.Color(253, 252, 248));
        fullNameField.setForeground(new java.awt.Color(0, 100, 0));
        fullNameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        fullNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullNameFieldActionPerformed(evt);
            }
        });
        fullNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fullNameFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fullNameFieldKeyTyped(evt);
            }
        });

        passwordLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(0, 100, 0));
        passwordLabel.setText("Password");

        fullNameIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fullNameIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user.png"))); // NOI18N
        fullNameIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        showHidePasswordIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        showHidePasswordIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/hidePasswordIcon.png"))); // NOI18N
        showHidePasswordIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        showHidePasswordIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showHidePasswordIconMouseClicked(evt);
            }
        });

        signUpButton.setBackground(new java.awt.Color(0, 140, 214));
        signUpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signUpButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signUpButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signUpButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                signUpButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                signUpButtonMouseReleased(evt);
            }
        });

        signUpLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        signUpLabel.setForeground(new java.awt.Color(255, 255, 255));
        signUpLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        signUpLabel.setText("SIGN UP");

        javax.swing.GroupLayout signUpButtonLayout = new javax.swing.GroupLayout(signUpButton);
        signUpButton.setLayout(signUpButtonLayout);
        signUpButtonLayout.setHorizontalGroup(
            signUpButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signUpButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(signUpLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        signUpButtonLayout.setVerticalGroup(
            signUpButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, signUpButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(signUpLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        alreadyHaveAnAccountLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        alreadyHaveAnAccountLabel.setForeground(new java.awt.Color(0, 100, 0));
        alreadyHaveAnAccountLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        alreadyHaveAnAccountLabel.setText("Already have an account?");

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordFieldKeyTyped(evt);
            }
        });

        emailLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(0, 100, 0));
        emailLabel.setText("Email");

        emailField.setBackground(new java.awt.Color(253, 252, 248));
        emailField.setForeground(new java.awt.Color(0, 100, 0));
        emailField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });
        emailField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emailFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailFieldKeyTyped(evt);
            }
        });

        emailIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emailIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user.png"))); // NOI18N
        emailIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        usernameLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(0, 100, 0));
        usernameLabel.setText("Username");

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usernameFieldKeyTyped(evt);
            }
        });

        usernameIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user.png"))); // NOI18N
        usernameIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout LeftPanelLayout = new javax.swing.GroupLayout(LeftPanel);
        LeftPanel.setLayout(LeftPanelLayout);
        LeftPanelLayout.setHorizontalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeftPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(LeftPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fullNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(signUpButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(LeftPanelLayout.createSequentialGroup()
                                .addComponent(fullNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(fullNameIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(LeftPanelLayout.createSequentialGroup()
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(showHidePasswordIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(emailErrorLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(LeftPanelLayout.createSequentialGroup()
                                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(emailIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fullNameErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(passwordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(usernameErrorLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(usernameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(LeftPanelLayout.createSequentialGroup()
                                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(usernameIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(passwordErrorLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(alreadyHaveAnAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(goToLoginButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LeftPanelLayout.setVerticalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftPanelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(titleLabel)
                .addGap(22, 22, 22)
                .addComponent(fullNameLabel)
                .addGap(13, 13, 13)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fullNameIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fullNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(fullNameErrorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emailLabel)
                .addGap(13, 13, 13)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(emailField)
                    .addComponent(emailIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(emailErrorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usernameLabel)
                .addGap(13, 13, 13)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(usernameField)
                    .addComponent(usernameIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(usernameErrorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordLabel)
                .addGap(13, 13, 13)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(showHidePasswordIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(passwordErrorLabel)
                .addGap(30, 30, 30)
                .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alreadyHaveAnAccountLabel)
                    .addComponent(goToLoginButton))
                .addContainerGap(131, Short.MAX_VALUE))
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
            .addComponent(LeftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
            .addComponent(RightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
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
            .addComponent(basePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void signUpButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpButtonMouseClicked
        // Check if any required field is empty and mark it as required if so
        if (fullNameField.getText().trim().isEmpty()) {
            UIUtils.markFieldAsRequired(fullNameField, fullNameErrorLabel);
        }

        if (emailField.getText().trim().isEmpty()) {
            UIUtils.markFieldAsRequired(emailField, emailErrorLabel);
        }

        if (usernameField.getText().trim().isEmpty()) {
            UIUtils.markFieldAsRequired(usernameField, usernameErrorLabel);
        }

        if (new String(passwordField.getPassword()).trim().isEmpty()) {
            UIUtils.markFieldAsRequired(passwordField, passwordErrorLabel);
        }

        // If all fields are valid, set user data and proceed to sign-up email verification
        if (isFullNameValid && isEmailValid && isUsernameValid && isPasswordValid) {
            userData.setFullName(fullName);
            userData.setEmail(email);
            userData.setUsername(username);
            userData.setPassword(password);
            dispose();
            new SignUpEmailVerificationPage(userData).setVisible(true);
        }
    }//GEN-LAST:event_signUpButtonMouseClicked

    private void signUpButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpButtonMouseEntered
        signUpButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_signUpButtonMouseEntered

    private void signUpButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpButtonMouseExited
        signUpButton.setBackground(ColorManager.PRIMARY_BLUE);
    }//GEN-LAST:event_signUpButtonMouseExited

    private void signUpButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpButtonMouseReleased
        signUpButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_signUpButtonMouseReleased

    private void signUpButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpButtonMousePressed
        signUpButton.setBackground(ColorManager.DEEP_BLUE);
    }//GEN-LAST:event_signUpButtonMousePressed

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

    private void fullNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fullNameFieldActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void showHidePasswordIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showHidePasswordIconMouseClicked
        UIUtils.togglePasswordVisibility(passwordField, showHidePasswordIcon);
    }//GEN-LAST:event_showHidePasswordIconMouseClicked

    private void goToLoginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToLoginButtonMouseClicked
        dispose();
        new LoginPage().setVisible(true);
    }//GEN-LAST:event_goToLoginButtonMouseClicked

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void fullNameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fullNameFieldKeyReleased
        fullName = fullNameField.getText();

        // Check if the entered full name is not empty
        if (!fullName.trim().isEmpty()) {
            // Validate the full name
            ValidationResult fullNameValidation = ValidationHandler.validateFullName(fullName);
            isFullNameValid = fullNameValidation.isValid();

            // If full name is invalid, mark the field as errorneous and display error message
            if (!fullNameValidation.isValid()) {
                UIUtils.setFieldErrorState(fullNameField);
                UIUtils.setErrorLabelMessage(fullNameErrorLabel, fullNameValidation.getErrorMessage());
            } else {
                // If the full name is valid, reset the field state and clear error message
                UIUtils.resetFieldState(fullNameField);
                UIUtils.resetErrorLabel(fullNameErrorLabel);
            }
        } else {
            // If field is empty, reset the field state and clear error message, if any
            UIUtils.resetFieldState(emailField);
            UIUtils.resetErrorLabel(emailErrorLabel);
        }
    }//GEN-LAST:event_fullNameFieldKeyReleased

    private void emailFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailFieldKeyReleased
        email = emailField.getText();

        // Check if the entered email is not empty
        if (!email.trim().isEmpty()) {
            // Validate the email
            ValidationResult emailValidation = ValidationHandler.validateEmail(email);
            isEmailValid = emailValidation.isValid();

            // If the email is invalid, mark the field as errorneous and display error message
            if (!emailValidation.isValid()) {
                UIUtils.setFieldErrorState(emailField);
                UIUtils.setErrorLabelMessage(emailErrorLabel, emailValidation.getErrorMessage());
            } else {
                // If the email is valid, reset the field state and clear error message
                UIUtils.resetFieldState(emailField);
                UIUtils.resetErrorLabel(emailErrorLabel);
            }
        } else {
            // If field is empty, reset the field state and clear error message, if any
            UIUtils.resetFieldState(emailField);
            UIUtils.resetErrorLabel(emailErrorLabel);
        }
    }//GEN-LAST:event_emailFieldKeyReleased

    private void usernameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameFieldKeyReleased
        username = usernameField.getText();

        // Check if the entered username is not empty
        if (!username.trim().isEmpty()) {
            // Validate the username
            ValidationResult usernameValidation = ValidationHandler.validateUsername(username);

            // If the username is invalid, mark the field as errorneous and display error message
            if (!usernameValidation.isValid()) {
                UIUtils.setFieldErrorState(usernameField);
                UIUtils.setErrorLabelMessage(usernameErrorLabel, usernameValidation.getErrorMessage());
            } else {
                // If the username is valid, reset the field state and clear error message
                UIUtils.setFieldErrorState(usernameField);
                UIUtils.setErrorLabelMessage(usernameErrorLabel, usernameValidation.getErrorMessage());

                try {
                    // Check if the username is unique
                    ValidationResult usernameUniqueValidation = ValidationHandler.checkUniqueUsername(username);
                    isUsernameValid = usernameUniqueValidation.isValid();

                    // If the username is not unique, mark the field as errorneous and display error message
                    if (!usernameUniqueValidation.isValid()) {
                        UIUtils.setFieldErrorState(usernameField);
                        UIUtils.setErrorLabelMessage(usernameErrorLabel, usernameValidation.getErrorMessage());
                    } else {
                        // If the username is unique, reset the field state and clear error message
                        UIUtils.resetFieldState(usernameField);
                        UIUtils.resetErrorLabel(usernameErrorLabel);
                    }
                } catch (SQLException ex) {
                    UIUtils.displayErrorMessage(ExceptionMessages.DATABASE_ERROR);
                    Logger.getLogger(SignUpPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            // If field is empty, reset the field state and clear error message, if any
            UIUtils.resetFieldState(usernameField);
            UIUtils.resetErrorLabel(usernameErrorLabel);
        }
    }//GEN-LAST:event_usernameFieldKeyReleased

    private void passwordFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyReleased
        password = new String(passwordField.getPassword());

        // Check if the entered password is not empty
        if (!password.trim().isEmpty()) {
            // Validate the password
            ValidationResult passwordValidation = ValidationHandler.validatePassword(password);
            isPasswordValid = passwordValidation.isValid();

            // If the password is invalid, mark the field as errorneous and display error message
            if (!passwordValidation.isValid()) {
                UIUtils.setFieldErrorState(passwordField);
                UIUtils.setErrorLabelMessage(passwordErrorLabel, passwordValidation.getErrorMessage());
            } else {
                // If the password is invalid, reset the field state and clear error message
                UIUtils.resetFieldState(passwordField);
                UIUtils.resetErrorLabel(passwordErrorLabel);
            }
        } else {
            // If field is empty, reset the field state and clear error message, if any
            UIUtils.resetFieldState(passwordField);
            UIUtils.resetErrorLabel(passwordErrorLabel);
        }
    }//GEN-LAST:event_passwordFieldKeyReleased

    private void fullNameFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fullNameFieldKeyTyped
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            basePanel.requestFocusInWindow();
        }
    }//GEN-LAST:event_fullNameFieldKeyTyped

    private void emailFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailFieldKeyTyped
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            basePanel.requestFocusInWindow();
        }
    }//GEN-LAST:event_emailFieldKeyTyped

    private void usernameFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameFieldKeyTyped
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            basePanel.requestFocusInWindow();
        }
    }//GEN-LAST:event_usernameFieldKeyTyped

    private void passwordFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyTyped
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            basePanel.requestFocusInWindow();
        }
    }//GEN-LAST:event_passwordFieldKeyTyped

    private void basePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_basePanelMouseClicked
        basePanel.requestFocusInWindow();
    }//GEN-LAST:event_basePanelMouseClicked

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
            java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUpPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SignUpPage(new UserData()).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JPanel RightPanel;
    private javax.swing.JLabel alreadyHaveAnAccountLabel;
    private javax.swing.JLabel banner;
    private javax.swing.JPanel basePanel;
    private javax.swing.JLabel emailErrorLabel;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailIcon;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel fullNameErrorLabel;
    private javax.swing.JTextField fullNameField;
    private javax.swing.JLabel fullNameIcon;
    private javax.swing.JLabel fullNameLabel;
    private javax.swing.JLabel goToLoginButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel passwordErrorLabel;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel showHidePasswordIcon;
    private javax.swing.JPanel signUpButton;
    private javax.swing.JLabel signUpLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel usernameErrorLabel;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameIcon;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
