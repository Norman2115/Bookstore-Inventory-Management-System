package bookstoreinventorymanagementsystem;

import javax.swing.JLayeredPane;

/**
 *
 * @author User
 */
public class AdminHomePage extends javax.swing.JFrame {

    private final UserData userData;
    private static final EditProductInfoPage EDIT_PRODUCT_INFO = new EditProductInfoPage();
    private static final ProductDetailPage PRODUCT_DETAIL_PAGE = new ProductDetailPage();
    /**
     * Creates new form Admin_homepage
     * @param userData
     */
    public AdminHomePage(UserData userData) {
        initComponents();
        displayPanel.removeAll();
        Dashboard text = new Dashboard();
        displayPanel.add(text).setVisible(true);

        this.userData = userData;
    }
    
    public static void createEditProductInfoPage(BookData productData){
        displayPanel.add(EDIT_PRODUCT_INFO,JLayeredPane.DEFAULT_LAYER,0);
        EDIT_PRODUCT_INFO.setVisible(true);
        EDIT_PRODUCT_INFO.fillProductInfo(productData);
    }
    public static void createProductDetailPage(BookData productData){
        displayPanel.add(PRODUCT_DETAIL_PAGE,JLayeredPane.DEFAULT_LAYER,0);
        PRODUCT_DETAIL_PAGE.setVisible(true);
        PRODUCT_DETAIL_PAGE.fillProductInfo(productData);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        basePanel = new javax.swing.JPanel();
        sideNavBar = new javax.swing.JPanel();
        addProductButton = new javax.swing.JPanel();
        addProductLable = new javax.swing.JLabel();
        deleteProductButton = new javax.swing.JPanel();
        deleteProductLable = new javax.swing.JLabel();
        editProductButton = new javax.swing.JPanel();
        editProductLable = new javax.swing.JLabel();
        restockButton = new javax.swing.JPanel();
        restockLable = new javax.swing.JLabel();
        invoiceButton = new javax.swing.JPanel();
        invoiceLable = new javax.swing.JLabel();
        logoutButton = new javax.swing.JPanel();
        logoutLable = new javax.swing.JLabel();
        viewProductButton = new javax.swing.JPanel();
        viewProductLable = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        profilePictureLabel = new javax.swing.JLabel();
        displayPanel = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(253, 252, 248));

        basePanel.setBackground(new java.awt.Color(255, 255, 255));
        basePanel.setPreferredSize(new java.awt.Dimension(1080, 630));

        sideNavBar.setBackground(new java.awt.Color(0, 140, 214));
        sideNavBar.setAlignmentX(0.0F);
        sideNavBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        addProductButton.setBackground(new java.awt.Color(0, 140, 214));
        addProductButton.setPreferredSize(new java.awt.Dimension(138, 138));
        addProductButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addProductButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addProductButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addProductButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addProductButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                addProductButtonMouseReleased(evt);
            }
        });

        addProductLable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addProductLable.setForeground(new java.awt.Color(253, 252, 248));
        addProductLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addProductLable.setText("ADD PRODUCT");
        addProductLable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout addProductButtonLayout = new javax.swing.GroupLayout(addProductButton);
        addProductButton.setLayout(addProductButtonLayout);
        addProductButtonLayout.setHorizontalGroup(
            addProductButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addProductButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addProductLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        addProductButtonLayout.setVerticalGroup(
            addProductButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addProductButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addProductLable, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        deleteProductButton.setBackground(new java.awt.Color(0, 140, 214));
        deleteProductButton.setPreferredSize(new java.awt.Dimension(138, 138));
        deleteProductButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteProductButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteProductButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteProductButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deleteProductButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                deleteProductButtonMouseReleased(evt);
            }
        });

        deleteProductLable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteProductLable.setForeground(new java.awt.Color(253, 252, 248));
        deleteProductLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deleteProductLable.setText("DELETE PRODUCT");
        deleteProductLable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout deleteProductButtonLayout = new javax.swing.GroupLayout(deleteProductButton);
        deleteProductButton.setLayout(deleteProductButtonLayout);
        deleteProductButtonLayout.setHorizontalGroup(
            deleteProductButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deleteProductButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(deleteProductLable, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addContainerGap())
        );
        deleteProductButtonLayout.setVerticalGroup(
            deleteProductButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, deleteProductButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(deleteProductLable, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        editProductButton.setBackground(new java.awt.Color(0, 140, 214));
        editProductButton.setPreferredSize(new java.awt.Dimension(138, 138));
        editProductButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editProductButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editProductButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editProductButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editProductButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                editProductButtonMouseReleased(evt);
            }
        });

        editProductLable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editProductLable.setForeground(new java.awt.Color(253, 252, 248));
        editProductLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        editProductLable.setText("EDIT PRODUCT");
        editProductLable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout editProductButtonLayout = new javax.swing.GroupLayout(editProductButton);
        editProductButton.setLayout(editProductButtonLayout);
        editProductButtonLayout.setHorizontalGroup(
            editProductButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editProductButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editProductLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        editProductButtonLayout.setVerticalGroup(
            editProductButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editProductButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(editProductLable, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        restockButton.setBackground(new java.awt.Color(0, 140, 214));
        restockButton.setPreferredSize(new java.awt.Dimension(138, 138));
        restockButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                restockButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                restockButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                restockButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                restockButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                restockButtonMouseReleased(evt);
            }
        });

        restockLable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        restockLable.setForeground(new java.awt.Color(253, 252, 248));
        restockLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        restockLable.setText("RESTOCK");
        restockLable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout restockButtonLayout = new javax.swing.GroupLayout(restockButton);
        restockButton.setLayout(restockButtonLayout);
        restockButtonLayout.setHorizontalGroup(
            restockButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(restockButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(restockLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        restockButtonLayout.setVerticalGroup(
            restockButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(restockButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(restockLable, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        invoiceButton.setBackground(new java.awt.Color(0, 140, 214));
        invoiceButton.setPreferredSize(new java.awt.Dimension(138, 138));
        invoiceButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invoiceButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                invoiceButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                invoiceButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                invoiceButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                invoiceButtonMouseReleased(evt);
            }
        });

        invoiceLable.setBackground(new java.awt.Color(0, 140, 214));
        invoiceLable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        invoiceLable.setForeground(new java.awt.Color(253, 252, 248));
        invoiceLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invoiceLable.setText("VIEW INVOICE");
        invoiceLable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout invoiceButtonLayout = new javax.swing.GroupLayout(invoiceButton);
        invoiceButton.setLayout(invoiceButtonLayout);
        invoiceButtonLayout.setHorizontalGroup(
            invoiceButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(invoiceButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(invoiceLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        invoiceButtonLayout.setVerticalGroup(
            invoiceButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(invoiceButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(invoiceLable, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        logoutButton.setBackground(new java.awt.Color(0, 140, 214));
        logoutButton.setPreferredSize(new java.awt.Dimension(138, 138));
        logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logoutButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                logoutButtonMouseReleased(evt);
            }
        });

        logoutLable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logoutLable.setForeground(new java.awt.Color(253, 252, 248));
        logoutLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoutLable.setText("LOGOUT");
        logoutLable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout logoutButtonLayout = new javax.swing.GroupLayout(logoutButton);
        logoutButton.setLayout(logoutButtonLayout);
        logoutButtonLayout.setHorizontalGroup(
            logoutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        logoutButtonLayout.setVerticalGroup(
            logoutButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutLable, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        viewProductButton.setBackground(new java.awt.Color(0, 140, 214));
        viewProductButton.setPreferredSize(new java.awt.Dimension(138, 138));
        viewProductButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewProductButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewProductButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewProductButtonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                viewProductButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                viewProductButtonMouseReleased(evt);
            }
        });

        viewProductLable.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        viewProductLable.setForeground(new java.awt.Color(253, 252, 248));
        viewProductLable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewProductLable.setText("VIEW PRODUCT");
        viewProductLable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout viewProductButtonLayout = new javax.swing.GroupLayout(viewProductButton);
        viewProductButton.setLayout(viewProductButtonLayout);
        viewProductButtonLayout.setHorizontalGroup(
            viewProductButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewProductButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewProductLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        viewProductButtonLayout.setVerticalGroup(
            viewProductButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewProductButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewProductLable, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(0, 140, 214));

        profilePictureLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(profilePictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profilePictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout sideNavBarLayout = new javax.swing.GroupLayout(sideNavBar);
        sideNavBar.setLayout(sideNavBarLayout);
        sideNavBarLayout.setHorizontalGroup(
            sideNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideNavBarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(sideNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deleteProductButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editProductButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(restockButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addProductButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewProductButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(invoiceButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        sideNavBarLayout.setVerticalGroup(
            sideNavBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideNavBarLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(viewProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(restockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invoiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        displayPanel.setBackground(new java.awt.Color(204, 204, 204));
        displayPanel.setPreferredSize(new java.awt.Dimension(942, 630));

        javax.swing.GroupLayout displayPanelLayout = new javax.swing.GroupLayout(displayPanel);
        displayPanel.setLayout(displayPanelLayout);
        displayPanelLayout.setHorizontalGroup(
            displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 942, Short.MAX_VALUE)
        );
        displayPanelLayout.setVerticalGroup(
            displayPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout basePanelLayout = new javax.swing.GroupLayout(basePanel);
        basePanel.setLayout(basePanelLayout);
        basePanelLayout.setHorizontalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basePanelLayout.createSequentialGroup()
                .addComponent(sideNavBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(displayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        basePanelLayout.setVerticalGroup(
            basePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sideNavBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(displayPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(basePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(basePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void viewProductButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewProductButtonMouseReleased
        viewProductButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_viewProductButtonMouseReleased

    private void viewProductButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewProductButtonMousePressed
        viewProductButton.setBackground(ColorManager.DEEP_BLUE);
    }//GEN-LAST:event_viewProductButtonMousePressed

    private void viewProductButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewProductButtonMouseExited
        viewProductButton.setBackground(ColorManager.PRIMARY_BLUE);
    }//GEN-LAST:event_viewProductButtonMouseExited

// viewProductButton
    private void viewProductButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewProductButtonMouseEntered
        viewProductButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_viewProductButtonMouseEntered

    private void viewProductButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewProductButtonMouseClicked
        displayPanel.removeAll();
        ViewProductPage viewProduct = new ViewProductPage();
        displayPanel.add(viewProduct).setVisible(true);
    }//GEN-LAST:event_viewProductButtonMouseClicked

    private void logoutButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseReleased
        logoutButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_logoutButtonMouseReleased

    private void logoutButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMousePressed
        logoutButton.setBackground(ColorManager.DEEP_BLUE);
    }//GEN-LAST:event_logoutButtonMousePressed

    private void logoutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseExited
        logoutButton.setBackground(ColorManager.PRIMARY_BLUE);
    }//GEN-LAST:event_logoutButtonMouseExited

    private void logoutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseEntered
        logoutButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_logoutButtonMouseEntered

    //logout
    private void logoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseClicked
        dispose();
        new LoginPage().setVisible(true);
    }//GEN-LAST:event_logoutButtonMouseClicked

    private void invoiceButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceButtonMouseReleased
        invoiceButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_invoiceButtonMouseReleased

    private void invoiceButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceButtonMousePressed
        invoiceButton.setBackground(ColorManager.DEEP_BLUE);
    }//GEN-LAST:event_invoiceButtonMousePressed

    private void invoiceButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceButtonMouseExited
        invoiceButton.setBackground(ColorManager.PRIMARY_BLUE);
    }//GEN-LAST:event_invoiceButtonMouseExited

    private void invoiceButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceButtonMouseEntered
        invoiceButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_invoiceButtonMouseEntered

    //invoice
    private void invoiceButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceButtonMouseClicked
        displayPanel.removeAll();
        ViewInvoicePage viewInvoice = new ViewInvoicePage();
        displayPanel.add(viewInvoice).setVisible(true);
    }//GEN-LAST:event_invoiceButtonMouseClicked

    private void restockButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restockButtonMouseReleased
        restockButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_restockButtonMouseReleased

    private void restockButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restockButtonMousePressed
        restockButton.setBackground(ColorManager.DEEP_BLUE);
    }//GEN-LAST:event_restockButtonMousePressed

    private void restockButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restockButtonMouseExited
        restockButton.setBackground(ColorManager.PRIMARY_BLUE);
    }//GEN-LAST:event_restockButtonMouseExited

    private void restockButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restockButtonMouseEntered
        restockButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_restockButtonMouseEntered

    //restockButton
    private void restockButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restockButtonMouseClicked
        displayPanel.removeAll();
        RestockPage restockPage = new RestockPage();
        displayPanel.add(restockPage).setVisible(true);
    }//GEN-LAST:event_restockButtonMouseClicked

    private void editProductButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editProductButtonMouseReleased
        editProductButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_editProductButtonMouseReleased

    private void editProductButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editProductButtonMousePressed
        editProductButton.setBackground(ColorManager.DEEP_BLUE);
    }//GEN-LAST:event_editProductButtonMousePressed

    private void editProductButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editProductButtonMouseExited
        editProductButton.setBackground(ColorManager.PRIMARY_BLUE);
    }//GEN-LAST:event_editProductButtonMouseExited

    private void editProductButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editProductButtonMouseEntered
        editProductButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_editProductButtonMouseEntered

    //editProductButton
    private void editProductButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editProductButtonMouseClicked
        displayPanel.removeAll();
        EditProductViewPage editProductView = new EditProductViewPage();
        displayPanel.add(editProductView).setVisible(true);
    }//GEN-LAST:event_editProductButtonMouseClicked

    private void deleteProductButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteProductButtonMouseReleased
        deleteProductButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_deleteProductButtonMouseReleased

    private void deleteProductButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteProductButtonMousePressed
        deleteProductButton.setBackground(ColorManager.DEEP_BLUE);
    }//GEN-LAST:event_deleteProductButtonMousePressed

    private void deleteProductButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteProductButtonMouseExited
        deleteProductButton.setBackground(ColorManager.PRIMARY_BLUE);
    }//GEN-LAST:event_deleteProductButtonMouseExited

    private void deleteProductButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteProductButtonMouseEntered
        deleteProductButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_deleteProductButtonMouseEntered

    // deleteProductButton
    private void deleteProductButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteProductButtonMouseClicked
        displayPanel.removeAll();
        DeleteProductPage deleteProduct = new DeleteProductPage();
        displayPanel.add(deleteProduct).setVisible(true);
    }//GEN-LAST:event_deleteProductButtonMouseClicked

    private void addProductButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addProductButtonMouseReleased
        addProductButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_addProductButtonMouseReleased

    private void addProductButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addProductButtonMousePressed
        addProductButton.setBackground(ColorManager.DEEP_BLUE);
    }//GEN-LAST:event_addProductButtonMousePressed

    private void addProductButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addProductButtonMouseExited
        addProductButton.setBackground(ColorManager.PRIMARY_BLUE);
    }//GEN-LAST:event_addProductButtonMouseExited

    private void addProductButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addProductButtonMouseEntered
        addProductButton.setBackground(ColorManager.MEDIUM_BLUE);
    }//GEN-LAST:event_addProductButtonMouseEntered

    // addProductButton
    private void addProductButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addProductButtonMouseClicked
        displayPanel.removeAll();
        AddProductPage addProduct = new AddProductPage();
        displayPanel.add(addProduct).setVisible(true);
    }//GEN-LAST:event_addProductButtonMouseClicked

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
            java.util.logging.Logger.getLogger(AdminHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
            @Override
            public void run() {
                new AdminHomePage(new UserData()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addProductButton;
    private javax.swing.JLabel addProductLable;
    private javax.swing.JPanel basePanel;
    private javax.swing.JPanel deleteProductButton;
    private javax.swing.JLabel deleteProductLable;
    private static javax.swing.JDesktopPane displayPanel;
    private javax.swing.JPanel editProductButton;
    private javax.swing.JLabel editProductLable;
    private javax.swing.JPanel invoiceButton;
    private javax.swing.JLabel invoiceLable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel logoutButton;
    private javax.swing.JLabel logoutLable;
    private javax.swing.JLabel profilePictureLabel;
    private javax.swing.JPanel restockButton;
    private javax.swing.JLabel restockLable;
    private javax.swing.JPanel sideNavBar;
    private javax.swing.JPanel viewProductButton;
    private javax.swing.JLabel viewProductLable;
    // End of variables declaration//GEN-END:variables
}
