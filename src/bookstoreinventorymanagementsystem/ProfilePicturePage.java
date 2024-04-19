package bookstoreinventorymanagementsystem;

import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Image;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.ImageIcon;

/**
 * The class represents the user interface for selecting and displaying a
 * profile picture. Users are required to provide their own profile picture.
 * This page serves as the last step of the sign-up process.
 *
 * @author Teo Chung Henn
 */
public class ProfilePicturePage extends javax.swing.JFrame {

    private final UserData userData;
    private final NavigationStack<UserData> userDataStack;
    private File selectedFile;

    /**
     * Creates new form ProfilePicturePage
     *
     * @param userData the UserData object containing user information, passed
     * from SignUpEmailVerificationPage class.
     * @param userDataStack the navigation stack used for storing page data
     * history for restoration and navigation.
     */
    public ProfilePicturePage(UserData userData, NavigationStack<UserData> userDataStack) {
        initComponents();
        this.userData = userData;
        this.userDataStack = userDataStack;
    }

    /**
     * Displays the profile picture in the label component. This method scales
     * the image to fit the label's size.
     *
     * @param file the File object representing the profile picture file.
     */
    private void displayProfilePicture(File file) {
        ImageIcon icon = new ImageIcon(file.getPath());
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(pictureLabel.getWidth(),
                pictureLabel.getHeight(), Image.SCALE_SMOOTH);
        pictureLabel.setIcon(new ImageIcon(scaledImage));
        pictureLabel.setSize(uploadPicturePanel.getSize());
        pictureLabel.revalidate();
        pictureLabel.repaint();
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
        finishButton = new javax.swing.JPanel();
        finishLabel = new javax.swing.JLabel();
        uploadPicturePanel = new javax.swing.JPanel();
        pictureLabel = new javax.swing.JLabel();
        noPictureErrorLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JPanel();
        backLabel = new javax.swing.JLabel();
        alreadyHaveAnAccountLabel = new javax.swing.JLabel();
        goToLoginButton = new javax.swing.JLabel();

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
        titleLabel.setText("<html><font color='#3EA434'>Picture</font> <font color='#008CD6'>Time!</font></html>");

        subTitleLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        subTitleLabel.setForeground(new java.awt.Color(0, 100, 0));
        subTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subTitleLabel.setText("Upload your profile picture");

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
        finishLabel.setText("FINISH");

        javax.swing.GroupLayout finishButtonLayout = new javax.swing.GroupLayout(finishButton);
        finishButton.setLayout(finishButtonLayout);
        finishButtonLayout.setHorizontalGroup(
            finishButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, finishButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(finishLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );
        finishButtonLayout.setVerticalGroup(
            finishButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, finishButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(finishLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        uploadPicturePanel.setBackground(new java.awt.Color(253, 252, 248));
        uploadPicturePanel.setBorder(BorderFactory.createDashedBorder(ColorManager.MEDIUM_GREY, 3, 3, 1, true)
        );
        uploadPicturePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uploadPicturePanelMouseClicked(evt);
            }
        });

        pictureLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pictureLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/photo_icon.png"))); // NOI18N

        javax.swing.GroupLayout uploadPicturePanelLayout = new javax.swing.GroupLayout(uploadPicturePanel);
        uploadPicturePanel.setLayout(uploadPicturePanelLayout);
        uploadPicturePanelLayout.setHorizontalGroup(
            uploadPicturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(uploadPicturePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pictureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addContainerGap())
        );
        uploadPicturePanelLayout.setVerticalGroup(
            uploadPicturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(uploadPicturePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pictureLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addContainerGap())
        );

        noPictureErrorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        backButton.setBackground(new java.awt.Color(180, 180, 180));
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                backButtonMouseReleased(evt);
            }
        });

        backLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        backLabel.setForeground(new java.awt.Color(255, 255, 255));
        backLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backLabel.setText("BACK");

        javax.swing.GroupLayout backButtonLayout = new javax.swing.GroupLayout(backButton);
        backButton.setLayout(backButtonLayout);
        backButtonLayout.setHorizontalGroup(
            backButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );
        backButtonLayout.setVerticalGroup(
            backButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
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
                            .addComponent(noPictureErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(LeftPanelLayout.createSequentialGroup()
                                .addComponent(finishButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(uploadPicturePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addGap(52, 52, 52)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subTitleLabel)
                .addGap(18, 18, 18)
                .addComponent(uploadPicturePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(noPictureErrorLabel)
                .addGap(16, 16, 16)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(finishButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alreadyHaveAnAccountLabel)
                    .addComponent(goToLoginButton))
                .addContainerGap(103, Short.MAX_VALUE))
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

    private void finishButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finishButtonMouseClicked
        // Check if a profile picture file is selected
        if (selectedFile != null) {
            try {
                byte[] profilePicture = ImageUtils.convertFileToByteArray(selectedFile);
                userData.setProfilePicture(profilePicture);

                try {
                    // Save the user's sign-up data to the database as final step
                    UserDAO.saveUserDataToDatabase(userData);
                    dispose();
                    new SignUpSuccessfulPage().setVisible(true);
                } catch (SQLException ex) {
                    UIUtils.displayErrorMessage(ExceptionMessages.DATABASE_ERROR);
                    Logger.getLogger(ProfilePicturePage.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                } catch (NullPointerException ex) {
                    UIUtils.displayErrorMessage(ExceptionMessages.NULL_ERROR);
                    Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                }
            } catch (IOException ex) {
                UIUtils.displayErrorMessage(ExceptionMessages.IO_ERROR);
                Logger.getLogger(ProfilePicturePage.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        } else {
            // If no profile picture is selected, display error message
            UIUtils.setErrorLabelMessage(noPictureErrorLabel, "Must upload a picture");
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

    private void RightPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RightPanelMouseClicked
        RightPanel.grabFocus();
    }//GEN-LAST:event_RightPanelMouseClicked

    private void LeftPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeftPanelMouseClicked
        LeftPanel.grabFocus();
    }//GEN-LAST:event_LeftPanelMouseClicked

    private void uploadPicturePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uploadPicturePanelMouseClicked
        // Create a file chooser for user to select a picture file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose Profile Picture");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);

        // Create a file filter for image files only
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Image Files", "jpg", "jpeg", "png");
        fileChooser.addChoosableFileFilter(filter);

        // Check if a file is chosen
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            displayProfilePicture(selectedFile);
            UIUtils.resetErrorLabel(noPictureErrorLabel);
        }
    }//GEN-LAST:event_uploadPicturePanelMouseClicked

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        SignUpPage signUpPage = new SignUpPage(userData, userDataStack);
        signUpPage.onReturnFromNextPage();
        dispose();
        signUpPage.setVisible(true);
    }//GEN-LAST:event_backButtonMouseClicked

    private void backButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseEntered
        backButton.setBackground(ColorManager.DARK_GREY);
    }//GEN-LAST:event_backButtonMouseEntered

    private void backButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseExited
        backButton.setBackground(ColorManager.DEEP_GREY);
    }//GEN-LAST:event_backButtonMouseExited

    private void backButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMousePressed
        backButton.setBackground(ColorManager.CHARCOAL_GREY);
    }//GEN-LAST:event_backButtonMousePressed

    private void backButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseReleased
        backButton.setBackground(ColorManager.DARK_GREY);
    }//GEN-LAST:event_backButtonMouseReleased

    private void goToLoginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToLoginButtonMouseClicked
        dispose();
        new LoginPage().setVisible(true);
    }//GEN-LAST:event_goToLoginButtonMouseClicked

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
            java.util.logging.Logger.getLogger(ProfilePicturePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfilePicturePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfilePicturePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfilePicturePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ProfilePicturePage(new UserData(), new NavigationStack<>()).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JPanel RightPanel;
    private javax.swing.JLabel alreadyHaveAnAccountLabel;
    private javax.swing.JPanel backButton;
    private javax.swing.JLabel backLabel;
    private javax.swing.JLabel banner;
    private javax.swing.JPanel finishButton;
    private javax.swing.JLabel finishLabel;
    private javax.swing.JLabel goToLoginButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel noPictureErrorLabel;
    private javax.swing.JLabel pictureLabel;
    private javax.swing.JLabel subTitleLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel uploadPicturePanel;
    // End of variables declaration//GEN-END:variables
}
