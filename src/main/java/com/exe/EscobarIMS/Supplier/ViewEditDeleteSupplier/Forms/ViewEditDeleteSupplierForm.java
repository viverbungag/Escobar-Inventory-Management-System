/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.exe.EscobarIMS.Supplier.ViewEditDeleteSupplier.Forms;

import com.exe.EscobarIMS.Supplier.SupplierFormActions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.event.*;

/**
 *
 * @author Viver
 */
@Component
public class ViewEditDeleteSupplierForm extends javax.swing.JFrame {

    /**
     * Creates new form ViewEditDeleteSupplierForm
     */

    @Autowired
    SupplierFormActions supplierFormActions;

    
    public ViewEditDeleteSupplierForm() {
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
        supplierTable = new javax.swing.JTable();
        deleteSupplierButton = new javax.swing.JButton();
        supplierFormTitle = new javax.swing.JLabel();
        editingPanel = new javax.swing.JPanel();
        editSupplierButton = new javax.swing.JButton();
        supplierContactNumberPanel = new javax.swing.JPanel();
        supplierContactNumberTextField = new javax.swing.JTextField();
        supplierContactNumberLabel = new javax.swing.JLabel();
        supplierContactPersonPanel = new javax.swing.JPanel();
        supplierContactPersonTextField = new javax.swing.JTextField();
        supplierContactPersonLabel = new javax.swing.JLabel();
        supplierAddressPanel = new javax.swing.JPanel();
        supplierAddressTextField = new javax.swing.JTextField();
        supplierAddressLabel = new javax.swing.JLabel();
        supplierNamePanel = new javax.swing.JPanel();
        supplierNameTextField = new javax.swing.JTextField();
        supplierNameLabel = new javax.swing.JLabel();
        noteLabel = new javax.swing.JLabel();
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

        supplierTable.setAutoCreateRowSorter(true);
        supplierTable.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        supplierTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier Name", "Supplier Address", "Supplier Contact Number", "Supplier Contact Person"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        supplierTable.setRowHeight(25);
        supplierTable.setRowMargin(5);
        supplierTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                supplierTableMousePressed(evt);
            }
        });
        tableScrollPanel.setViewportView(supplierTable);

        deleteSupplierButton.setText("Delete");
        deleteSupplierButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSupplierButtonActionPerformed(evt);
            }
        });

        supplierFormTitle.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        supplierFormTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        supplierFormTitle.setText("Supplier");

        editSupplierButton.setText("Edit");
        editSupplierButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSupplierButtonActionPerformed(evt);
            }
        });

        supplierContactNumberLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        supplierContactNumberLabel.setText("Supplier Contact Number");

        javax.swing.GroupLayout supplierContactNumberPanelLayout = new javax.swing.GroupLayout(supplierContactNumberPanel);
        supplierContactNumberPanel.setLayout(supplierContactNumberPanelLayout);
        supplierContactNumberPanelLayout.setHorizontalGroup(
            supplierContactNumberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, supplierContactNumberPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(supplierContactNumberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(supplierContactNumberLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(supplierContactNumberTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
        );
        supplierContactNumberPanelLayout.setVerticalGroup(
            supplierContactNumberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, supplierContactNumberPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(supplierContactNumberLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(supplierContactNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        supplierContactPersonLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        supplierContactPersonLabel.setText("Supplier Contact Person");

        javax.swing.GroupLayout supplierContactPersonPanelLayout = new javax.swing.GroupLayout(supplierContactPersonPanel);
        supplierContactPersonPanel.setLayout(supplierContactPersonPanelLayout);
        supplierContactPersonPanelLayout.setHorizontalGroup(
            supplierContactPersonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, supplierContactPersonPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(supplierContactPersonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(supplierContactPersonLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(supplierContactPersonTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
        );
        supplierContactPersonPanelLayout.setVerticalGroup(
            supplierContactPersonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, supplierContactPersonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(supplierContactPersonLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(supplierContactPersonTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        supplierAddressLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        supplierAddressLabel.setText("Supplier Address");

        javax.swing.GroupLayout supplierAddressPanelLayout = new javax.swing.GroupLayout(supplierAddressPanel);
        supplierAddressPanel.setLayout(supplierAddressPanelLayout);
        supplierAddressPanelLayout.setHorizontalGroup(
            supplierAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, supplierAddressPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(supplierAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(supplierAddressLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(supplierAddressTextField, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        supplierAddressPanelLayout.setVerticalGroup(
            supplierAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, supplierAddressPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(supplierAddressLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(supplierAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        supplierNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        supplierNameLabel.setText("Supplier Name");

        javax.swing.GroupLayout supplierNamePanelLayout = new javax.swing.GroupLayout(supplierNamePanel);
        supplierNamePanel.setLayout(supplierNamePanelLayout);
        supplierNamePanelLayout.setHorizontalGroup(
            supplierNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, supplierNamePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(supplierNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(supplierNameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(supplierNameTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
        );
        supplierNamePanelLayout.setVerticalGroup(
            supplierNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, supplierNamePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(supplierNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(supplierNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        noteLabel.setForeground(new java.awt.Color(255, 51, 51));
        noteLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        noteLabel.setText("NOTE: Just input 'N/A' if it should be blank");

        javax.swing.GroupLayout editingPanelLayout = new javax.swing.GroupLayout(editingPanel);
        editingPanel.setLayout(editingPanelLayout);
        editingPanelLayout.setHorizontalGroup(
            editingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editingPanelLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(editSupplierButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(noteLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(editingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(editingPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(editingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(supplierAddressPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(supplierNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(supplierContactNumberPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(supplierContactPersonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        editingPanelLayout.setVerticalGroup(
            editingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editingPanelLayout.createSequentialGroup()
                .addComponent(noteLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 369, Short.MAX_VALUE)
                .addComponent(editSupplierButton)
                .addContainerGap())
            .addGroup(editingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(editingPanelLayout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(supplierNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(supplierAddressPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(supplierContactNumberPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(supplierContactPersonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(84, Short.MAX_VALUE)))
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

        sortingMethodComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Supplier Name", "Supplier Address", "Supplier Contact Number", "Supplier Contact Person" }));
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
            .addComponent(supplierFormTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteSupplierButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(editingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(paginationAndSortPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tableScrollPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(supplierFormTitle)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(paginationAndSortPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tableScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addComponent(deleteSupplierButton)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setActionFormComponents(){
        supplierFormActions.setContentLimitComboBox(contentLimitComboBox);
        supplierFormActions.setCurrentPageNumberTextField(currentPageNumberTextField);
        supplierFormActions.setSupplierNameTextField(supplierNameTextField);
        supplierFormActions.setSupplierAddressTextField(supplierAddressTextField);
        supplierFormActions.setSupplierContactNumberTextField(supplierContactNumberTextField);
        supplierFormActions.setSupplierContactPersonTextField(supplierContactPersonTextField);
        supplierFormActions.setPreviousButton(previousButton);
        supplierFormActions.setNextButton(nextButton);
        supplierFormActions.setSupplierTable(supplierTable);
        supplierFormActions.setAscendingRadioButton(ascendingRadioButton);
        supplierFormActions.setDescendingRadioButton(descendingRadioButton);
        supplierFormActions.setSortingMethodComboBox(sortingMethodComboBox);
    }


    private void supplierTableMousePressed(MouseEvent evt) {
//        setActionFormComponents();
        supplierFormActions.supplierTableMousePressed();
    }

    private void formWindowOpened(WindowEvent evt) {
//        setActionFormComponents();
        supplierFormActions.formWindowOpened(supplierTable);
    }

    private void formWindowActivated(WindowEvent evt) {
        setActionFormComponents();
        supplierFormActions.formWindowActivated();
    }

    private void contentLimitComboBoxActionPerformed(ActionEvent evt) {
//        setActionFormComponents();
        supplierFormActions.contentLimitComboBoxActionPerformed();
    }

    private void sortingMethodComboBoxActionPerformed(ActionEvent evt) {
//        setActionFormComponents();
        supplierFormActions.sortingMethodComboBoxActionPerformed();
    }

    private void currentPageNumberTextFieldKeyReleased(KeyEvent evt) {
//        setActionFormComponents();
        supplierFormActions.currentPageNumberTextFieldKeyReleased(evt, paginationAndSortPanel);
    }

    private void currentPageNumberTextFieldFocusLost(FocusEvent evt) {
//        setActionFormComponents();
        supplierFormActions.currentPageNumberTextFieldFocusLost();
    }

    private void ascendingRadioButtonItemStateChanged(ItemEvent evt) {
//        setActionFormComponents();
        supplierFormActions.ascendingRadioButtonItemStateChanged();
    }

    private void previousButtonActionPerformed(ActionEvent evt) {
//        setActionFormComponents();
        supplierFormActions.previousButtonActionPerformed();
    }

    private void nextButtonActionPerformed(ActionEvent evt) {
//        setActionFormComponents();
        supplierFormActions.nextButtonActionPerformed();
    }

    private void editSupplierButtonActionPerformed(ActionEvent evt) {
//        setActionFormComponents();
        supplierFormActions.editSupplierButtonActionPerformed();
    }

    private void deleteSupplierButtonActionPerformed(ActionEvent evt) {
//        setActionFormComponents();
        supplierFormActions.deleteSupplierButtonActionPerformed();
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
            java.util.logging.Logger.getLogger(ViewEditDeleteSupplierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewEditDeleteSupplierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewEditDeleteSupplierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewEditDeleteSupplierForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewEditDeleteSupplierForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ascendingRadioButton;
    private javax.swing.JComboBox<String> contentLimitComboBox;
    private javax.swing.JTextField currentPageNumberTextField;
    private javax.swing.JButton deleteSupplierButton;
    private javax.swing.JRadioButton descendingRadioButton;
    private javax.swing.JButton editSupplierButton;
    private javax.swing.JPanel editingPanel;
    private javax.swing.JLabel limitLabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel noteLabel;
    private javax.swing.JPanel paginationAndSortPanel;
    private javax.swing.JButton previousButton;
    private javax.swing.JLabel sortLabel;
    private javax.swing.ButtonGroup sortMethodGroup;
    private javax.swing.JComboBox<String> sortingMethodComboBox;
    private javax.swing.JLabel supplierAddressLabel;
    private javax.swing.JPanel supplierAddressPanel;
    private javax.swing.JTextField supplierAddressTextField;
    private javax.swing.JLabel supplierContactNumberLabel;
    private javax.swing.JPanel supplierContactNumberPanel;
    private javax.swing.JTextField supplierContactNumberTextField;
    private javax.swing.JLabel supplierContactPersonLabel;
    private javax.swing.JPanel supplierContactPersonPanel;
    private javax.swing.JTextField supplierContactPersonTextField;
    private javax.swing.JLabel supplierFormTitle;
    private javax.swing.JLabel supplierNameLabel;
    private javax.swing.JPanel supplierNamePanel;
    private javax.swing.JTextField supplierNameTextField;
    private javax.swing.JTable supplierTable;
    private javax.swing.JScrollPane tableScrollPanel;
    // End of variables declaration//GEN-END:variables
}
