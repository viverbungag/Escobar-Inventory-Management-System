/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.exe.EscobarIMS.Supply.ViewEditDeleteSupply.Forms;

import com.exe.EscobarIMS.Supply.SupplyFormActions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.event.*;

/**
 *
 * @author Viver
 */
@Component
public class ViewEditDeleteSupplyForm extends javax.swing.JFrame {

    /**
     * Creates new form ViewEditDeleteSupplierForm
     */

    @Autowired
    SupplyFormActions supplyFormActions;

    
    public ViewEditDeleteSupplyForm() {
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
        supplyTable = new javax.swing.JTable();
        deleteSupplyButton = new javax.swing.JButton();
        supplyFormTitle = new javax.swing.JLabel();
        editingPanel = new javax.swing.JPanel();
        editSupplyButton = new javax.swing.JButton();
        unitOfMeasurementPanel = new javax.swing.JPanel();
        unitOfMeasurementLabel = new javax.swing.JLabel();
        unitOfMeasurementComboBox = new javax.swing.JComboBox<>();
        supplierPanel = new javax.swing.JPanel();
        supplierLabel = new javax.swing.JLabel();
        supplierComboBox = new javax.swing.JComboBox<>();
        supplyNamePanel = new javax.swing.JPanel();
        supplyNameTextField = new javax.swing.JTextField();
        supplyNameLabel = new javax.swing.JLabel();
        minimumQuantityPanel = new javax.swing.JPanel();
        minimumQuantityTextField = new javax.swing.JTextField();
        minimumQuantityLabel = new javax.swing.JLabel();
        supplyCategoryPanel = new javax.swing.JPanel();
        supplyCategoryLabel = new javax.swing.JLabel();
        supplyCategoryComboBox = new javax.swing.JComboBox<>();
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

        supplyTable.setAutoCreateRowSorter(true);
        supplyTable.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        supplyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supply Name", "Supply Category", "Supplier", "Quantity", "Unit of Measurement", "Minimum Quantity", "Below Minimum"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        supplyTable.setRowHeight(25);
        supplyTable.setRowMargin(5);
        supplyTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                supplyTableMousePressed(evt);
            }
        });
        tableScrollPanel.setViewportView(supplyTable);

        deleteSupplyButton.setText("Delete");
        deleteSupplyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSupplyButtonActionPerformed(evt);
            }
        });

        supplyFormTitle.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        supplyFormTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        supplyFormTitle.setText("Supply");

        editSupplyButton.setText("Edit");
        editSupplyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editSupplyButtonActionPerformed(evt);
            }
        });

        unitOfMeasurementLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        unitOfMeasurementLabel.setText("Unit of Measurement");

        javax.swing.GroupLayout unitOfMeasurementPanelLayout = new javax.swing.GroupLayout(unitOfMeasurementPanel);
        unitOfMeasurementPanel.setLayout(unitOfMeasurementPanelLayout);
        unitOfMeasurementPanelLayout.setHorizontalGroup(
            unitOfMeasurementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, unitOfMeasurementPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(unitOfMeasurementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(unitOfMeasurementLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(unitOfMeasurementComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        unitOfMeasurementPanelLayout.setVerticalGroup(
            unitOfMeasurementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, unitOfMeasurementPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(unitOfMeasurementLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(unitOfMeasurementComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        supplierLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        supplierLabel.setText("Supplier");

        javax.swing.GroupLayout supplierPanelLayout = new javax.swing.GroupLayout(supplierPanel);
        supplierPanel.setLayout(supplierPanelLayout);
        supplierPanelLayout.setHorizontalGroup(
            supplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, supplierPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(supplierLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(supplierComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        supplierPanelLayout.setVerticalGroup(
            supplierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, supplierPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(supplierLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(supplierComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        supplyNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        supplyNameLabel.setText("Supplier Name");

        javax.swing.GroupLayout supplyNamePanelLayout = new javax.swing.GroupLayout(supplyNamePanel);
        supplyNamePanel.setLayout(supplyNamePanelLayout);
        supplyNamePanelLayout.setHorizontalGroup(
            supplyNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, supplyNamePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(supplyNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(supplyNameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(supplyNameTextField, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        supplyNamePanelLayout.setVerticalGroup(
            supplyNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, supplyNamePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(supplyNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(supplyNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        minimumQuantityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimumQuantityLabel.setText("Minimum Quantity");

        javax.swing.GroupLayout minimumQuantityPanelLayout = new javax.swing.GroupLayout(minimumQuantityPanel);
        minimumQuantityPanel.setLayout(minimumQuantityPanelLayout);
        minimumQuantityPanelLayout.setHorizontalGroup(
            minimumQuantityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, minimumQuantityPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(minimumQuantityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(minimumQuantityLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(minimumQuantityTextField, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        minimumQuantityPanelLayout.setVerticalGroup(
            minimumQuantityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, minimumQuantityPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(minimumQuantityLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(minimumQuantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        supplyCategoryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        supplyCategoryLabel.setText("Supply Category");

        javax.swing.GroupLayout supplyCategoryPanelLayout = new javax.swing.GroupLayout(supplyCategoryPanel);
        supplyCategoryPanel.setLayout(supplyCategoryPanelLayout);
        supplyCategoryPanelLayout.setHorizontalGroup(
            supplyCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, supplyCategoryPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(supplyCategoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(supplyCategoryComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        supplyCategoryPanelLayout.setVerticalGroup(
            supplyCategoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, supplyCategoryPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(supplyCategoryLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(supplyCategoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout editingPanelLayout = new javax.swing.GroupLayout(editingPanel);
        editingPanel.setLayout(editingPanelLayout);
        editingPanelLayout.setHorizontalGroup(
            editingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editingPanelLayout.createSequentialGroup()
                .addGroup(editingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editingPanelLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(editSupplyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editingPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(editingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minimumQuantityPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supplyCategoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supplyNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(unitOfMeasurementPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supplierPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        editingPanelLayout.setVerticalGroup(
            editingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editingPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(supplyNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(supplyCategoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(unitOfMeasurementPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(supplierPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(minimumQuantityPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(editSupplyButton)
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

        sortingMethodComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Supply Name", "Supply Category", "Supplier", "Quantity", "Unit of Measurement", "Minimum Quantity", "Below Minimum" }));
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
            .addComponent(supplyFormTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(deleteSupplyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(editingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tableScrollPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1032, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(paginationAndSortPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(supplyFormTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(paginationAndSortPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tableScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(editingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteSupplyButton)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setActionFormComponents(){
        supplyFormActions.setContentLimitComboBox(contentLimitComboBox);
        supplyFormActions.setCurrentPageNumberTextField(currentPageNumberTextField);
        supplyFormActions.setSupplyNameTextField(supplyNameTextField);
        supplyFormActions.setMinimumQuantityTextField(minimumQuantityTextField);
        supplyFormActions.setUnitOfMeasurementComboBox(unitOfMeasurementComboBox);
        supplyFormActions.setSupplyCategoryComboBox(supplyCategoryComboBox);
        supplyFormActions.setSupplierComboBox(supplierComboBox);
        supplyFormActions.setPreviousButton(previousButton);
        supplyFormActions.setNextButton(nextButton);
        supplyFormActions.setSupplyTable(supplyTable);
        supplyFormActions.setAscendingRadioButton(ascendingRadioButton);
        supplyFormActions.setDescendingRadioButton(descendingRadioButton);
        supplyFormActions.setSortingMethodComboBox(sortingMethodComboBox);
    }


    private void supplyTableMousePressed(MouseEvent evt) {
//        setActionFormComponents();
        supplyFormActions.supplyTableMousePressed();
    }

    private void formWindowOpened(WindowEvent evt) {
//        setActionFormComponents();
        supplyFormActions.formWindowOpened(supplyTable);
    }

    private void formWindowActivated(WindowEvent evt) {
        setActionFormComponents();
        supplyFormActions.formWindowActivated();
    }

    private void contentLimitComboBoxActionPerformed(ActionEvent evt) {
//        setActionFormComponents();
        supplyFormActions.contentLimitComboBoxActionPerformed();
    }

    private void sortingMethodComboBoxActionPerformed(ActionEvent evt) {
//        setActionFormComponents();
        supplyFormActions.sortingMethodComboBoxActionPerformed();
    }

    private void currentPageNumberTextFieldKeyReleased(KeyEvent evt) {
//        setActionFormComponents();
        supplyFormActions.currentPageNumberTextFieldKeyReleased(evt, paginationAndSortPanel);
    }

    private void currentPageNumberTextFieldFocusLost(FocusEvent evt) {
//        setActionFormComponents();
        supplyFormActions.currentPageNumberTextFieldFocusLost();
    }

    private void ascendingRadioButtonItemStateChanged(ItemEvent evt) {
//        setActionFormComponents();
        supplyFormActions.ascendingRadioButtonItemStateChanged();
    }

    private void previousButtonActionPerformed(ActionEvent evt) {
//        setActionFormComponents();
        supplyFormActions.previousButtonActionPerformed();
    }

    private void nextButtonActionPerformed(ActionEvent evt) {
//        setActionFormComponents();
        supplyFormActions.nextButtonActionPerformed();
    }

    private void editSupplyButtonActionPerformed(ActionEvent evt) {
//        setActionFormComponents();
        supplyFormActions.editSupplyButtonActionPerformed();
    }

    private void deleteSupplyButtonActionPerformed(ActionEvent evt) {
//        setActionFormComponents();
        supplyFormActions.deleteSupplyButtonActionPerformed();
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
            java.util.logging.Logger.getLogger(ViewEditDeleteSupplyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewEditDeleteSupplyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewEditDeleteSupplyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewEditDeleteSupplyForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new ViewEditDeleteSupplyForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ascendingRadioButton;
    private javax.swing.JComboBox<String> contentLimitComboBox;
    private javax.swing.JTextField currentPageNumberTextField;
    private javax.swing.JButton deleteSupplyButton;
    private javax.swing.JRadioButton descendingRadioButton;
    private javax.swing.JButton editSupplyButton;
    private javax.swing.JPanel editingPanel;
    private javax.swing.JLabel limitLabel;
    private javax.swing.JLabel minimumQuantityLabel;
    private javax.swing.JPanel minimumQuantityPanel;
    private javax.swing.JTextField minimumQuantityTextField;
    private javax.swing.JButton nextButton;
    private javax.swing.JPanel paginationAndSortPanel;
    private javax.swing.JButton previousButton;
    private javax.swing.JLabel sortLabel;
    private javax.swing.ButtonGroup sortMethodGroup;
    private javax.swing.JComboBox<String> sortingMethodComboBox;
    private javax.swing.JComboBox<String> supplierComboBox;
    private javax.swing.JLabel supplierLabel;
    private javax.swing.JPanel supplierPanel;
    private javax.swing.JComboBox<String> supplyCategoryComboBox;
    private javax.swing.JLabel supplyCategoryLabel;
    private javax.swing.JPanel supplyCategoryPanel;
    private javax.swing.JLabel supplyFormTitle;
    private javax.swing.JLabel supplyNameLabel;
    private javax.swing.JPanel supplyNamePanel;
    private javax.swing.JTextField supplyNameTextField;
    private javax.swing.JTable supplyTable;
    private javax.swing.JScrollPane tableScrollPanel;
    private javax.swing.JComboBox<String> unitOfMeasurementComboBox;
    private javax.swing.JLabel unitOfMeasurementLabel;
    private javax.swing.JPanel unitOfMeasurementPanel;
    // End of variables declaration//GEN-END:variables
}
