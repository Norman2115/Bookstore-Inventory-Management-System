package bookstoreinventorymanagementsystem;

import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.ImageIcon;

/**
 *
 * @author Teo Chung Henn
 */
public class ProfilePicturePage extends javax.swing.JFrame {

    private final UserData userData;
    private File selectedFile;

    /**
     * Creates new form LoginPage
     * @param userData
     */
    public ProfilePicturePage(UserData userData) {
        initComponents();
        this.userData = userData;
    }

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

    private byte[] convertFileToByteArray(File file) {
        byte[] byteArray = null;
        try (BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream(file)); ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            byteArray = baos.toByteArray();
        } catch (IOException ex) {
            Logger.getLogger(ProfilePicturePage.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return byteArray;
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
        dontHaveAccountLabel = new javax.swing.JLabel();
        goToSignUpButton = new javax.swing.JLabel();
        uploadPicturePanel = new javax.swing.JPanel();
        pictureLabel = new javax.swing.JLabel();
        noPictureErrorLabel = new javax.swing.JLabel();

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
                .addComponent(finishLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addContainerGap())
        );
        finishButtonLayout.setVerticalGroup(
            finishButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, finishButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(finishLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        dontHaveAccountLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        dontHaveAccountLabel.setForeground(new java.awt.Color(0, 100, 0));
        dontHaveAccountLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dontHaveAccountLabel.setText("Already have an account?");

        goToSignUpButton.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        goToSignUpButton.setForeground(new java.awt.Color(0, 100, 0));
        goToSignUpButton.setText("Login");
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
                            .addGroup(LeftPanelLayout.createSequentialGroup()
                                .addComponent(dontHaveAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(goToSignUpButton))
                            .addComponent(finishButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(noPictureErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 26, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(uploadPicturePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
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
                .addComponent(finishButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dontHaveAccountLabel)
                    .addComponent(goToSignUpButton))
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
        if (selectedFile != null) {
            byte[] profilePicture = convertFileToByteArray(selectedFile);
            userData.setProfilePicture(profilePicture);
            try {
                userData.saveUserDataToDatabase();
                dispose();
                new SignUpSuccessfulPage().setVisible(true);
            } catch (SQLException ex) {
                UIUtils.displayErrorMessage(ex.getMessage());
                Logger.getLogger(ProfilePicturePage.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
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

    private void goToSignUpButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToSignUpButtonMouseClicked
        dispose();
        new LoginPage().setVisible(true);
    }//GEN-LAST:event_goToSignUpButtonMouseClicked

    private void RightPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RightPanelMouseClicked
        RightPanel.grabFocus();
    }//GEN-LAST:event_RightPanelMouseClicked

    private void LeftPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeftPanelMouseClicked
        LeftPanel.grabFocus();
    }//GEN-LAST:event_LeftPanelMouseClicked

    private void uploadPicturePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uploadPicturePanelMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose Profile Picture");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Image Files", "jpg", "jpeg", "png");
        fileChooser.addChoosableFileFilter(filter);

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            displayProfilePicture(selectedFile);
            UIUtils.resetErrorLabel(noPictureErrorLabel);
        }
    }//GEN-LAST:event_uploadPicturePanelMouseClicked

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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfilePicturePage(new UserData()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JPanel RightPanel;
    private javax.swing.JLabel banner;
    private javax.swing.JLabel dontHaveAccountLabel;
    private javax.swing.JPanel finishButton;
    private javax.swing.JLabel finishLabel;
    private javax.swing.JLabel goToSignUpButton;
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
