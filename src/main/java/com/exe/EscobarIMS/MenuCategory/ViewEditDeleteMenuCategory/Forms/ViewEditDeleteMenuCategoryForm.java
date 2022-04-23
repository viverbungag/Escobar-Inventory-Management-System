/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.exe.EscobarIMS.MenuCategory.ViewEditDeleteMenuCategory.Forms;

import com.exe.EscobarIMS.MenuCategory.MenuCategoryFormActions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Viver
 */
@Component
public class ViewEditDeleteMenuCategoryForm extends javax.swing.JFrame {

    /**
     * Creates new form ViewEditDeleteMenuCategoryForm
     */

    @Autowired
    MenuCategoryFormActions menuCategoryFormActions;

    
    public ViewEditDeleteMenuCategoryForm() {
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

        sortMethodGroup = new javax.swing.ButtonGroup();
        tableScrollPanel = new javax.swing.JScrollPane();
        menuCategoryTable = new javax.swing.JTable();
        deleteMenuCategoryButton = new javax.swing.JButton();
        MenuCategoryFormTitle = new javax.swing.JLabel();
        paginationAndSortPanel = new javax.swing.JPanel();
        editMenuCategoryButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        menuCategoryNameTextField = new javax.swing.JTextField();
        editingPanel = new javax.swing.JPanel();
        previousButton = new javax.swing.JButton();
        currentPageNumberTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        sortingMethodComboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        ascendingRadioButton = new javax.swing.JRadioButton();
        descendingRadioButton = new javax.swing.JRadioButton();
        nextButton = new javax.swing.JButton();
        contentLimitComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        menuCategoryTable.setAutoCreateRowSorter(true);
        menuCategoryTable.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        menuCategoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Menu Category Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        menuCategoryTable.setRowHeight(25);
        menuCategoryTable.setRowMargin(5);
        menuCategoryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuCategoryTableMousePressed(evt);
            }
        });
        tableScrollPanel.setViewportView(menuCategoryTable);

        deleteMenuCategoryButton.setText("Delete");
        deleteMenuCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMenuCategoryButtonActionPerformed(evt);
            }
        });

        MenuCategoryFormTitle.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        MenuCategoryFormTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuCategoryFormTitle.setText("Menu Categories");

        editMenuCategoryButton.setText("Edit");
        editMenuCategoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMenuCategoryButtonActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Menu Category Name");

        javax.swing.GroupLayout paginationAndSortPanelLayout = new javax.swing.GroupLayout(paginationAndSortPanel);
        paginationAndSortPanel.setLayout(paginationAndSortPanelLayout);
        paginationAndSortPanelLayout.setHorizontalGroup(
            paginationAndSortPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuCategoryNameTextField)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(paginationAndSortPanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(editMenuCategoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        paginationAndSortPanelLayout.setVerticalGroup(
            paginationAndSortPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paginationAndSortPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(menuCategoryNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(editMenuCategoryButton)
                .addContainerGap())
        );

        previousButton.setText("Prev");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });

        currentPageNumberTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        currentPageNumberTextField.setText("1");
        currentPageNumberTextField.setToolTipText("");
        currentPageNumberTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                currentPageNumberTextFieldFocusLost(evt);
            }
        });
        currentPageNumberTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                currentPageNumberTextFieldKeyReleased(evt);
            }
        });

        jLabel2.setText("Limit:");

        sortingMethodComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Menu Category Name" }));
        sortingMethodComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortingMethodComboBoxActionPerformed(evt);
            }
        });

        jLabel4.setText("Sorted by:");

        sortMethodGroup.add(ascendingRadioButton);
        ascendingRadioButton.setSelected(true);
        ascendingRadioButton.setText("Ascending");
        ascendingRadioButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ascendingRadioButtonItemStateChanged(evt);
            }
        });

        sortMethodGroup.add(descendingRadioButton);
        descendingRadioButton.setText("Descending");

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        contentLimitComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5", "15", "30", "50", "100" }));
        contentLimitComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentLimitComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editingPanelLayout = new javax.swing.GroupLayout(editingPanel);
        editingPanel.setLayout(editingPanelLayout);
        editingPanelLayout.setHorizontalGroup(
            editingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editingPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(editingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(editingPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sortingMethodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editingPanelLayout.createSequentialGroup()
                        .addComponent(ascendingRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(descendingRadioButton)))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contentLimitComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(previousButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentPageNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextButton)
                .addGap(71, 71, 71))
        );
        editingPanelLayout.setVerticalGroup(
            editingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editingPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(editingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sortingMethodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextButton)
                    .addComponent(contentLimitComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(previousButton)
                    .addComponent(currentPageNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(ascendingRadioButton)
                    .addComponent(descendingRadioButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuCategoryFormTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(deleteMenuCategoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(paginationAndSortPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editingPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 539, Short.MAX_VALUE)
                            .addComponent(tableScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MenuCategoryFormTitle)
                .addGap(18, 18, 18)
                .addComponent(editingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tableScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(paginationAndSortPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteMenuCategoryButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCategoryTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCategoryTableMousePressed
        menuCategoryFormActions.menuCategoryTableMousePressed(menuCategoryTable, menuCategoryNameTextField);
    }//GEN-LAST:event_menuCategoryTableMousePressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        menuCategoryFormActions.formWindowOpened(menuCategoryTable);
    }

    private void formWindowActivated(java.awt.event.WindowEvent evt) {
        menuCategoryFormActions.formWindowActivated(
                menuCategoryTable, currentPageNumberTextField,
                contentLimitComboBox, sortingMethodComboBox,
                ascendingRadioButton, descendingRadioButton,
                previousButton, nextButton);
    }

    private void contentLimitComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        menuCategoryFormActions.contentLimitComboBoxActionPerformed(
                menuCategoryTable, currentPageNumberTextField,
                contentLimitComboBox, sortingMethodComboBox,
                ascendingRadioButton, descendingRadioButton,
                previousButton, nextButton);
    }

    private void sortingMethodComboBoxActionPerformed(java.awt.event.ActionEvent evt) {
        menuCategoryFormActions.sortingMethodComboBoxActionPerformed(
                menuCategoryTable, currentPageNumberTextField,
                contentLimitComboBox, sortingMethodComboBox,
                ascendingRadioButton, descendingRadioButton,
                previousButton, nextButton);
    }

    private void currentPageNumberTextFieldKeyReleased(java.awt.event.KeyEvent evt) {
        menuCategoryFormActions.currentPageNumberTextFieldKeyReleased(evt, paginationAndSortPanel);
    }

    private void currentPageNumberTextFieldFocusLost(java.awt.event.FocusEvent evt) {
        menuCategoryFormActions.currentPageNumberTextFieldFocusLost(
                menuCategoryTable, currentPageNumberTextField,
                contentLimitComboBox, sortingMethodComboBox,
                ascendingRadioButton, descendingRadioButton,
                previousButton, nextButton);
    }

    private void ascendingRadioButtonItemStateChanged(java.awt.event.ItemEvent evt) {
        menuCategoryFormActions.ascendingRadioButtonItemStateChanged(
                menuCategoryTable, currentPageNumberTextField,
                contentLimitComboBox, sortingMethodComboBox,
                ascendingRadioButton, descendingRadioButton,
                previousButton, nextButton);
    }

    private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {
        menuCategoryFormActions.previousButtonActionPerformed(
                menuCategoryTable, currentPageNumberTextField,
                contentLimitComboBox, sortingMethodComboBox,
                ascendingRadioButton, descendingRadioButton,
                previousButton, nextButton);
    }

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {
        menuCategoryFormActions.nextButtonActionPerformed(
                menuCategoryTable, currentPageNumberTextField,
                contentLimitComboBox, sortingMethodComboBox,
                ascendingRadioButton, descendingRadioButton,
                previousButton, nextButton);
    }

    private void editMenuCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {
        menuCategoryFormActions.editMenuCategoryButtonActionPerformed(menuCategoryNameTextField, menuCategoryTable);
    }

    private void deleteMenuCategoryButtonActionPerformed(java.awt.event.ActionEvent evt) {
        menuCategoryFormActions.deleteMenuCategoryButtonActionPerformed(menuCategoryNameTextField, menuCategoryTable);
    }

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
            java.util.logging.Logger.getLogger(ViewEditDeleteMenuCategoryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewEditDeleteMenuCategoryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewEditDeleteMenuCategoryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewEditDeleteMenuCategoryForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewEditDeleteMenuCategoryForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MenuCategoryFormTitle;
    private javax.swing.JRadioButton ascendingRadioButton;
    private javax.swing.JComboBox<String> contentLimitComboBox;
    private javax.swing.JTextField currentPageNumberTextField;
    private javax.swing.JButton deleteMenuCategoryButton;
    private javax.swing.JRadioButton descendingRadioButton;
    private javax.swing.JButton editMenuCategoryButton;
    private javax.swing.JPanel editingPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField menuCategoryNameTextField;
    private javax.swing.JTable menuCategoryTable;
    private javax.swing.JButton nextButton;
    private javax.swing.JPanel paginationAndSortPanel;
    private javax.swing.JButton previousButton;
    private javax.swing.ButtonGroup sortMethodGroup;
    private javax.swing.JComboBox<String> sortingMethodComboBox;
    private javax.swing.JScrollPane tableScrollPanel;
    // End of variables declaration//GEN-END:variables
}
