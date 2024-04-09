package bookstoreinventorymanagementsystem;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.UnsupportedEncodingException;
import javax.mail.MessagingException;
import javax.swing.Timer;

/**
 *
 * @author Norman
 */
public class SignUpEmailVerificationPage extends javax.swing.JFrame {

    private final UserData userData;
    private final EmailHandler emailHandler;
    private String verificationCode;
    private final Timer resendCodeButtonTimer;

    /**
     * Creates new form LoginPage
     */
    public SignUpEmailVerificationPage() {
        initComponents();
        userData = UserData.getInstance();
        LeftPanel.grabFocus();
        emailHandler = new EmailHandler();
        sendVerificationEmailAsync(userData.getEmail());
        resendCodeButtonTimer = new Timer(10000, (ActionEvent e) -> {
            resendCodeButton.setEnabled(true);
        });
    }

    private void sendVerificationEmailAsync(String toEmail) {
        Thread emailThread = new Thread(() -> {
            try {
                emailHandler.sendRegistrationVerificationEmail(toEmail);
                verificationCode = emailHandler.getVerificationCode();
            } catch (MessagingException | UnsupportedEncodingException ex) {
                UIUtils.displayErrorMessage(ex.getMessage());
                dispose();
                new LoginPage().setVisible(true);
            }
        });
        emailThread.start();
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
        verificationCodeLabel = new javax.swing.JLabel();
        verificationCodeField = new javax.swing.JTextField();
        verificationCodeIcon = new javax.swing.JLabel();
        finishButton = new javax.swing.JPanel();
        finishLabel = new javax.swing.JLabel();
        rememberPasswordLabel = new javax.swing.JLabel();
        goToLoginButton = new javax.swing.JLabel();
        verificationCodeErrorLabel = new javax.swing.JLabel();
        didntReceiveLabel = new javax.swing.JLabel();
        resendCodeButton = new javax.swing.JLabel();
        resendCodeButton1 = new javax.swing.JLabel();

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
        titleLabel.setText("<html><font color='#3EA434'>Almost</font> <font color='#008CD6'>There!</font></html>"
        );

        subTitleLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        subTitleLabel.setForeground(new java.awt.Color(0, 100, 0));
        subTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subTitleLabel.setText("We sent an email to " + UserData.getInstance().getEmail());

        verificationCodeLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        verificationCodeLabel.setForeground(new java.awt.Color(0, 100, 0));
        verificationCodeLabel.setText("Verification Code");

        verificationCodeField.setBackground(new java.awt.Color(253, 252, 248));
        verificationCodeField.setForeground(new java.awt.Color(0, 100, 0));
        verificationCodeField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        verificationCodeField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                verificationCodeFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                verificationCodeFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                verificationCodeFieldKeyTyped(evt);
            }
        });

        verificationCodeIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        verificationCodeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user.png"))); // NOI18N
        verificationCodeIcon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        finishButton.setBackground(new java.awt.Color(0, 140, 214));
        finishButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                finishButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                finishButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                finishButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                finishButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                finishButtonMouseReleased(evt);
            }
        });

        finishLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        finishLabel.setForeground(new java.awt.Color(255, 255, 255));
        finishLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        finishLabel.setText("CONTINUE");

        javax.swing.GroupLayout finishButtonLayout = new javax.swing.GroupLayout(finishButton);
        finishButton.setLayout(finishButtonLayout);
        finishButtonLayout.setHorizontalGroup(
            finishButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, finishButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(finishLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        finishButtonLayout.setVerticalGroup(
            finishButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, finishButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(finishLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
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

        didntReceiveLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        didntReceiveLabel.setForeground(new java.awt.Color(0, 100, 0));
        didntReceiveLabel.setText("Didn't receive?");

        resendCodeButton.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        resendCodeButton.setForeground(new java.awt.Color(0, 100, 0));
        resendCodeButton.setText("Resend");
        resendCodeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resendCodeButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                resendCodeButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                resendCodeButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                resendCodeButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                resendCodeButtonMouseReleased(evt);
            }
        });

        resendCodeButton1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        resendCodeButton1.setForeground(new java.awt.Color(0, 100, 0));
        resendCodeButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resendCodeButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                resendCodeButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                resendCodeButton1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                resendCodeButton1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                resendCodeButton1MouseReleased(evt);
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
                            .addComponent(subTitleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)))
                    .addGroup(LeftPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(verificationCodeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(LeftPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(rememberPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(goToLoginButton))
                            .addComponent(finishButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(LeftPanelLayout.createSequentialGroup()
                                .addComponent(verificationCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(verificationCodeIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(verificationCodeErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(LeftPanelLayout.createSequentialGroup()
                                .addComponent(didntReceiveLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(resendCodeButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(resendCodeButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addComponent(verificationCodeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(verificationCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(verificationCodeIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(verificationCodeErrorLabel)
                .addGap(10, 10, 10)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(didntReceiveLabel)
                        .addComponent(resendCodeButton))
                    .addComponent(resendCodeButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(finishButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rememberPasswordLabel)
                    .addComponent(goToLoginButton))
                .addContainerGap(149, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void finishButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finishButtonMouseClicked
        String enteredCode = verificationCodeField.getText();

        if (enteredCode.trim().isEmpty()) {
            UIUtils.markFieldAsRequired(verificationCodeField,
                    verificationCodeErrorLabel);
            return;
        }

        ValidationResult codeValidation = ValidationHandler
                .validateVerificationCode(enteredCode, verificationCode);
        UIUtils.setFieldErrorState(verificationCodeField,
                verificationCodeErrorLabel, codeValidation);

        if (codeValidation.isValid()) {
            dispose();
            new ProfilePicturePage().setVisible(true);
        }
    }//GEN-LAST:event_finishButtonMouseClicked

    private void finishButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finishButtonMouseEntered
        finishButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_finishButtonMouseEntered

    private void finishButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finishButtonMouseExited
        finishButton.setBackground(ColorManager.PRIMARY_BLUE);
    }//GEN-LAST:event_finishButtonMouseExited

    private void finishButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finishButtonMouseReleased
        finishButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_finishButtonMouseReleased

    private void finishButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finishButtonMousePressed
        finishButton.setBackground(ColorManager.DEEP_BLUE);
    }//GEN-LAST:event_finishButtonMousePressed

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

    private void verificationCodeFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_verificationCodeFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            LeftPanel.requestFocusInWindow();
        }
    }//GEN-LAST:event_verificationCodeFieldKeyPressed

    private void verificationCodeFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_verificationCodeFieldKeyReleased
        if (verificationCodeField.getText().trim().isEmpty()) {
            UIUtils.resetFieldState(verificationCodeField);
            UIUtils.resetErrorLabel(verificationCodeErrorLabel);
        }
    }//GEN-LAST:event_verificationCodeFieldKeyReleased

    private void verificationCodeFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_verificationCodeFieldKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)
                || verificationCodeField.getText().length() >= 6) {
            evt.consume();
        }
    }//GEN-LAST:event_verificationCodeFieldKeyTyped

    private void resendCodeButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resendCodeButtonMouseClicked
        sendVerificationEmailAsync(userData.getEmail());
        resendCodeButton.setEnabled(false);
        resendCodeButtonTimer.start();
    }//GEN-LAST:event_resendCodeButtonMouseClicked

    private void resendCodeButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resendCodeButtonMouseEntered
        resendCodeButton.setForeground(ColorManager.PRIMARY_BLUE);
    }//GEN-LAST:event_resendCodeButtonMouseEntered

    private void resendCodeButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resendCodeButtonMouseExited
        resendCodeButton.setForeground(ColorManager.DARK_GREEN);
    }//GEN-LAST:event_resendCodeButtonMouseExited

    private void resendCodeButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resendCodeButtonMousePressed
        resendCodeButton.setForeground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_resendCodeButtonMousePressed

    private void resendCodeButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resendCodeButtonMouseReleased
        resendCodeButton.setForeground(ColorManager.PRIMARY_BLUE);
    }//GEN-LAST:event_resendCodeButtonMouseReleased

    private void resendCodeButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resendCodeButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_resendCodeButton1MouseClicked

    private void resendCodeButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resendCodeButton1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_resendCodeButton1MouseEntered

    private void resendCodeButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resendCodeButton1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_resendCodeButton1MouseExited

    private void resendCodeButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resendCodeButton1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_resendCodeButton1MousePressed

    private void resendCodeButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resendCodeButton1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_resendCodeButton1MouseReleased

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
            java.util.logging.Logger.getLogger(SignUpEmailVerificationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUpEmailVerificationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUpEmailVerificationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUpEmailVerificationPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            public void run() {
                new SignUpEmailVerificationPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JPanel RightPanel;
    private javax.swing.JLabel banner;
    private javax.swing.JLabel didntReceiveLabel;
    private javax.swing.JPanel finishButton;
    private javax.swing.JLabel finishLabel;
    private javax.swing.JLabel goToLoginButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel rememberPasswordLabel;
    private javax.swing.JLabel resendCodeButton;
    private javax.swing.JLabel resendCodeButton1;
    private javax.swing.JLabel subTitleLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel verificationCodeErrorLabel;
    private javax.swing.JTextField verificationCodeField;
    private javax.swing.JLabel verificationCodeIcon;
    private javax.swing.JLabel verificationCodeLabel;
    // End of variables declaration//GEN-END:variables
}
