/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.exe.EscobarIMS.MenuCategory.ViewEditDeleteMenuCategory.Forms;

import com.exe.EscobarIMS.MenuCategory.MenuCategoryFormActions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.event.*;

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
        editingPanel = new javax.swing.JPanel();
        editMenuCategoryButton = new javax.swing.JButton();
        menuCategoryNameLabel = new javax.swing.JLabel();
        menuCategoryNameTextField = new javax.swing.JTextField();
        paginationAndSortPanel = new javax.swing.JPanel();
        previousButton = new javax.swing.JButton();
        currentPageNumberTextField = new javax.swing.JTextField();
        limitLabel = new javax.swing.JLabel();
        sortingMethodComboBox = new javax.swing.JComboBox<>();
        sortLabel = new javax.swing.JLabel();
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

        menuCategoryNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuCategoryNameLabel.setText("Menu Category Name");

        javax.swing.GroupLayout editingPanelLayout = new javax.swing.GroupLayout(editingPanel);
        editingPanel.setLayout(editingPanelLayout);
        editingPanelLayout.setHorizontalGroup(
            editingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuCategoryNameTextField)
            .addComponent(menuCategoryNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(editingPanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(editMenuCategoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        editingPanelLayout.setVerticalGroup(
            editingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuCategoryNameLabel)
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

        limitLabel.setText("Limit:");

        sortingMethodComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Menu Category Name" }));
        sortingMethodComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortingMethodComboBoxActionPerformed(evt);
            }
        });

        sortLabel.setText("Sorted by:");

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

        javax.swing.GroupLayout paginationAndSortPanelLayout = new javax.swing.GroupLayout(paginationAndSortPanel);
        paginationAndSortPanel.setLayout(paginationAndSortPanelLayout);
        paginationAndSortPanelLayout.setHorizontalGroup(
            paginationAndSortPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paginationAndSortPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(paginationAndSortPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(paginationAndSortPanelLayout.createSequentialGroup()
                        .addComponent(sortLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sortingMethodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paginationAndSortPanelLayout.createSequentialGroup()
                        .addComponent(ascendingRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(descendingRadioButton)))
                .addGap(18, 18, 18)
                .addComponent(limitLabel)
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
        paginationAndSortPanelLayout.setVerticalGroup(
            paginationAndSortPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paginationAndSortPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(paginationAndSortPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sortingMethodComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sortLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paginationAndSortPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextButton)
                    .addComponent(contentLimitComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(previousButton)
                    .addComponent(currentPageNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(limitLabel)
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
                        .addComponent(editingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(paginationAndSortPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                            .addComponent(tableScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MenuCategoryFormTitle)
                .addGap(18, 18, 18)
                .addComponent(paginationAndSortPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tableScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(editingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteMenuCategoryButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setActionFormComponents(){
        menuCategoryFormActions.setContentLimitComboBox(contentLimitComboBox);
        menuCategoryFormActions.setCurrentPageNumberTextField(currentPageNumberTextField);
        menuCategoryFormActions.setMenuCategoryNameTextField(menuCategoryNameTextField);
        menuCategoryFormActions.setPreviousButton(previousButton);
        menuCategoryFormActions.setNextButton(nextButton);
        menuCategoryFormActions.setMenuCategoryTable(menuCategoryTable);
        menuCategoryFormActions.setAscendingRadioButton(ascendingRadioButton);
        menuCategoryFormActions.setDescendingRadioButton(descendingRadioButton);
        menuCategoryFormActions.setSortingMethodComboBox(sortingMethodComboBox);
    }


    private void menuCategoryTableMousePressed(MouseEvent evt) {
//        setActionFormComponents();
        menuCategoryFormActions.menuCategoryTableMousePressed();
    }

    private void formWindowOpened(WindowEvent evt) {
//        setActionFormComponents();
        menuCategoryFormActions.formWindowOpened(menuCategoryTable);
    }

    private void formWindowActivated(WindowEvent evt) {
        setActionFormComponents();
        menuCategoryFormActions.formWindowActivated();
    }

    private void contentLimitComboBoxActionPerformed(ActionEvent evt) {
//        setActionFormComponents();
        menuCategoryFormActions.contentLimitComboBoxActionPerformed();
    }

    private void sortingMethodComboBoxActionPerformed(ActionEvent evt) {
//        setActionFormComponents();
        menuCategoryFormActions.sortingMethodComboBoxActionPerformed();
    }

    private void currentPageNumberTextFieldKeyReleased(KeyEvent evt) {
//        setActionFormComponents();
        menuCategoryFormActions.currentPageNumberTextFieldKeyReleased(evt, paginationAndSortPanel);
    }

    private void currentPageNumberTextFieldFocusLost(FocusEvent evt) {
//        setActionFormComponents();
        menuCategoryFormActions.currentPageNumberTextFieldFocusLost();
    }

    private void ascendingRadioButtonItemStateChanged(ItemEvent evt) {
//        setActionFormComponents();
        menuCategoryFormActions.ascendingRadioButtonItemStateChanged();
    }

    private void previousButtonActionPerformed(ActionEvent evt) {
//        setActionFormComponents();
        menuCategoryFormActions.previousButtonActionPerformed();
    }

    private void nextButtonActionPerformed(ActionEvent evt) {
//        setActionFormComponents();
        menuCategoryFormActions.nextButtonActionPerformed();
    }

    private void editMenuCategoryButtonActionPerformed(ActionEvent evt) {
//        setActionFormComponents();
        menuCategoryFormActions.editMenuCategoryButtonActionPerformed();
    }

    private void deleteMenuCategoryButtonActionPerformed(ActionEvent evt) {
//        setActionFormComponents();
        menuCategoryFormActions.deleteMenuCategoryButtonActionPerformed();
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
    private javax.swing.JLabel limitLabel;
    private javax.swing.JLabel menuCategoryNameLabel;
    private javax.swing.JTextField menuCategoryNameTextField;
    private javax.swing.JTable menuCategoryTable;
    private javax.swing.JButton nextButton;
    private javax.swing.JPanel paginationAndSortPanel;
    private javax.swing.JButton previousButton;
    private javax.swing.JLabel sortLabel;
    private javax.swing.ButtonGroup sortMethodGroup;
    private javax.swing.JComboBox<String> sortingMethodComboBox;
    private javax.swing.JScrollPane tableScrollPanel;
    // End of variables declaration//GEN-END:variables
}
