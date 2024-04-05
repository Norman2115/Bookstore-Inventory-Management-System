package bookstoreinventorymanagementsystem;

/**
 *
 * @author Norman
 */
public class RoleSelectionPage extends javax.swing.JFrame {
    
    private UserRole userRole;
    private UserData userData;

    /**
     * Creates new form RoleSelectionPage
     */
    public RoleSelectionPage() {
        initComponents();
        userRole = null;
        userData = UserData.getInstance();
        titleLabel.setText("<html><font color='#3EA434'>What's</font> "
                + "<font color='#008CD6'>Your Role?</font></html>");
    }
    
    public void handleRoleSelection(UserRole userRole) {
        this.userRole = userRole;

        if (userRole == UserRole.ADMIN) {
            salespersonSelectionPanel.setBorder(javax.swing.BorderFactory
                    .createLineBorder(ColorManager.MEDIUM_GREY));
            salespersonIcon.setIcon(new javax.swing.ImageIcon(getClass()
                    .getResource("/icon/salesperson_unselected.png")));
            salespersonLabel.setForeground(ColorManager.LIGHT_GREY);

            adminSelectionPanel.setBorder(javax.swing.BorderFactory
                    .createLineBorder(new java.awt.Color(62, 164, 52)));
            adminSelectionPanel.setBackground(ColorManager.PRIMARY_WHITE);
            adminIcon.setIcon(new javax.swing.ImageIcon(getClass()
                    .getResource("/icon/admin_selected.png")));
            adminLabel.setForeground(ColorManager.DARK_GREEN);
        } else {
            adminSelectionPanel.setBorder(javax.swing.BorderFactory
                    .createLineBorder(ColorManager.MEDIUM_GREY));
            adminIcon.setIcon(new javax.swing.ImageIcon(getClass()
                    .getResource("/icon/admin_unselected.png")));
            adminLabel.setForeground(ColorManager.LIGHT_GREY);

            salespersonSelectionPanel.setBorder(javax.swing.BorderFactory
                    .createLineBorder(new java.awt.Color(62, 164, 52)));
            salespersonSelectionPanel.setBackground(ColorManager.PRIMARY_WHITE);
            salespersonIcon.setIcon(new javax.swing.ImageIcon(getClass()
                    .getResource("/icon/salesperson_selected.png")));
            salespersonLabel.setForeground(ColorManager.DARK_GREEN);
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
        basePanel = new javax.swing.JPanel();
        RightPanel = new javax.swing.JPanel();
        banner = new javax.swing.JLabel();
        LeftPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        subTitleLabel = new javax.swing.JLabel();
        continueButton = new javax.swing.JPanel();
        continueLabel = new javax.swing.JLabel();
        alreadyHaveAccountLabel = new javax.swing.JLabel();
        goToLoginButton = new javax.swing.JLabel();
        adminSelectionPanel = new javax.swing.JPanel();
        adminIcon = new javax.swing.JLabel();
        adminLabel = new javax.swing.JLabel();
        salespersonSelectionPanel = new javax.swing.JPanel();
        salespersonIcon = new javax.swing.JLabel();
        salespersonLabel = new javax.swing.JLabel();

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
        banner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/BookstorePic.png"))); // NOI18N

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
                .addComponent(banner, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
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
        titleLabel.setText("What's Your Role");

        subTitleLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        subTitleLabel.setForeground(new java.awt.Color(0, 100, 0));
        subTitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subTitleLabel.setText("Please choose a role to continue");

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

        alreadyHaveAccountLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        alreadyHaveAccountLabel.setForeground(new java.awt.Color(0, 100, 0));
        alreadyHaveAccountLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        alreadyHaveAccountLabel.setText("Already have an account?");

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

        adminSelectionPanel.setBackground(new java.awt.Color(253, 252, 248));
        adminSelectionPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        adminSelectionPanel.setPreferredSize(new java.awt.Dimension(186, 181));
        adminSelectionPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminSelectionPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                adminSelectionPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                adminSelectionPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                adminSelectionPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                adminSelectionPanelMouseReleased(evt);
            }
        });

        adminIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/admin_unselected.png"))); // NOI18N

        adminLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        adminLabel.setForeground(new java.awt.Color(230, 230, 230));
        adminLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminLabel.setText("Administrator");

        javax.swing.GroupLayout adminSelectionPanelLayout = new javax.swing.GroupLayout(adminSelectionPanel);
        adminSelectionPanel.setLayout(adminSelectionPanelLayout);
        adminSelectionPanelLayout.setHorizontalGroup(
            adminSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminSelectionPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(adminIcon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminSelectionPanelLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(adminLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        adminSelectionPanelLayout.setVerticalGroup(
            adminSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminSelectionPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(adminIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminLabel)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        salespersonSelectionPanel.setBackground(new java.awt.Color(253, 252, 248));
        salespersonSelectionPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        salespersonSelectionPanel.setPreferredSize(new java.awt.Dimension(186, 181));
        salespersonSelectionPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salespersonSelectionPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                salespersonSelectionPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                salespersonSelectionPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                salespersonSelectionPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                salespersonSelectionPanelMouseReleased(evt);
            }
        });

        salespersonIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/salesperson_unselected.png"))); // NOI18N

        salespersonLabel.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        salespersonLabel.setForeground(new java.awt.Color(230, 230, 230));
        salespersonLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salespersonLabel.setText("Salesperson");

        javax.swing.GroupLayout salespersonSelectionPanelLayout = new javax.swing.GroupLayout(salespersonSelectionPanel);
        salespersonSelectionPanel.setLayout(salespersonSelectionPanelLayout);
        salespersonSelectionPanelLayout.setHorizontalGroup(
            salespersonSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salespersonSelectionPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(salespersonSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(salespersonIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salespersonLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        salespersonSelectionPanelLayout.setVerticalGroup(
            salespersonSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(salespersonSelectionPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(salespersonIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salespersonLabel)
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
                            .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(subTitleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(LeftPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(continueButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftPanelLayout.createSequentialGroup()
                                .addComponent(adminSelectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(salespersonSelectionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(LeftPanelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(alreadyHaveAccountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(18, 18, 18)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(adminSelectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(salespersonSelectionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(continueButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alreadyHaveAccountLabel)
                    .addComponent(goToLoginButton))
                .addContainerGap(100, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(basePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void continueButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_continueButtonMouseClicked
        if (userRole != null) {
            userData.setRole(userRole);
            dispose();
            // new SignUpPage().setVisible(true);
            new SignUpPage().setVisible(true);
        } else {
            javax.swing.JOptionPane.showMessageDialog(
                    null, 
                    "PLease select a role.", 
                    "No role", 
                    javax.swing.JOptionPane.PLAIN_MESSAGE
            );
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

    private void adminSelectionPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminSelectionPanelMouseClicked
        handleRoleSelection(UserRole.ADMIN);
    }//GEN-LAST:event_adminSelectionPanelMouseClicked

    private void salespersonSelectionPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salespersonSelectionPanelMouseClicked
        handleRoleSelection(UserRole.SALESPERSON);
    }//GEN-LAST:event_salespersonSelectionPanelMouseClicked

    private void adminSelectionPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminSelectionPanelMouseEntered
        if (userRole != UserRole.ADMIN) {
            adminSelectionPanel.setBackground(ColorManager.DEEP_GREY);
        }
    }//GEN-LAST:event_adminSelectionPanelMouseEntered

    private void adminSelectionPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminSelectionPanelMouseExited
        if (userRole != UserRole.ADMIN) {
            adminSelectionPanel.setBackground(ColorManager.PRIMARY_WHITE);
        }
    }//GEN-LAST:event_adminSelectionPanelMouseExited

    private void salespersonSelectionPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salespersonSelectionPanelMouseEntered
        if (userRole != UserRole.SALESPERSON) {
            salespersonSelectionPanel.setBackground(ColorManager.DEEP_GREY);
        }
    }//GEN-LAST:event_salespersonSelectionPanelMouseEntered

    private void salespersonSelectionPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salespersonSelectionPanelMouseExited
        if (userRole != UserRole.SALESPERSON) {
            salespersonSelectionPanel.setBackground(ColorManager.PRIMARY_WHITE);
        }
    }//GEN-LAST:event_salespersonSelectionPanelMouseExited

    private void goToLoginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_goToLoginButtonMouseClicked
        dispose();
        LoginPage loginPage = new LoginPage();
        loginPage.setVisible(true);
    }//GEN-LAST:event_goToLoginButtonMouseClicked

    private void adminSelectionPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminSelectionPanelMousePressed
        if (userRole != UserRole.ADMIN) {
            adminSelectionPanel.setBackground(ColorManager.DARK_GREY);
        }
    }//GEN-LAST:event_adminSelectionPanelMousePressed

    private void adminSelectionPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminSelectionPanelMouseReleased
        if (userRole != UserRole.ADMIN) {
            adminSelectionPanel.setBackground(ColorManager.DEEP_GREY);
        }
    }//GEN-LAST:event_adminSelectionPanelMouseReleased

    private void salespersonSelectionPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salespersonSelectionPanelMousePressed
        if (userRole != UserRole.SALESPERSON) {
            salespersonSelectionPanel.setBackground(ColorManager.DARK_GREY);
        }
    }//GEN-LAST:event_salespersonSelectionPanelMousePressed

    private void salespersonSelectionPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salespersonSelectionPanelMouseReleased
        if (userRole != UserRole.SALESPERSON) {
            salespersonSelectionPanel.setBackground(ColorManager.DEEP_GREY);
        }
    }//GEN-LAST:event_salespersonSelectionPanelMouseReleased

    private void RightPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RightPanelMouseClicked
        RightPanel.grabFocus();
    }//GEN-LAST:event_RightPanelMouseClicked

    private void LeftPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeftPanelMouseClicked
        LeftPanel.grabFocus();
    }//GEN-LAST:event_LeftPanelMouseClicked

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
    private javax.swing.JLabel adminLabel;
    private javax.swing.JPanel adminSelectionPanel;
    private javax.swing.JLabel alreadyHaveAccountLabel;
    private javax.swing.JLabel banner;
    private javax.swing.JPanel basePanel;
    private javax.swing.JPanel continueButton;
    private javax.swing.JLabel continueLabel;
    private javax.swing.JLabel goToLoginButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel salespersonIcon;
    private javax.swing.JLabel salespersonLabel;
    private javax.swing.JPanel salespersonSelectionPanel;
    private javax.swing.JLabel subTitleLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
