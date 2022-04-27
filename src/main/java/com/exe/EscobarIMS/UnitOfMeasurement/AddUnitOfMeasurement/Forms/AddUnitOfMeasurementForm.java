/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.exe.EscobarIMS.UnitOfMeasurement.AddUnitOfMeasurement.Forms;

import com.exe.EscobarIMS.UnitOfMeasurement.UnitOfMeasurementFormActions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;

/**
 *
 * @author Viver
 */
@Component
public class AddUnitOfMeasurementForm extends javax.swing.JFrame {

    /**
     * Creates new form AddUnitOfMeasurementForm
     */

    @Autowired
    UnitOfMeasurementFormActions unitOfMeasurementFormActions;
    
    public AddUnitOfMeasurementForm() {
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

        addUnitOfMeasurementButton = new javax.swing.JButton();
        unitOfMeasurementNameTextField = new javax.swing.JTextField();
        UnitOfMeasurementFormTitle = new javax.swing.JLabel();
        unitOfMeasurementNameLabel = new javax.swing.JLabel();
        unitOfMeasurementAbbreviationTextField = new javax.swing.JTextField();
        unitOfMeasurementNameLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        addUnitOfMeasurementButton.setText("Add Unit of Measurement");
        addUnitOfMeasurementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUnitOfMeasurementButtonActionPerformed(evt);
            }
        });

        UnitOfMeasurementFormTitle.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        UnitOfMeasurementFormTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UnitOfMeasurementFormTitle.setText("Add Unit of Measurement Form");

        unitOfMeasurementNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        unitOfMeasurementNameLabel.setText("Unit of Measurement Name");

        unitOfMeasurementNameLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        unitOfMeasurementNameLabel1.setText("Unit of Measurement Abbreviation");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(unitOfMeasurementNameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(UnitOfMeasurementFormTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
            .addComponent(unitOfMeasurementNameLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(unitOfMeasurementNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(unitOfMeasurementAbbreviationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80))))
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(addUnitOfMeasurementButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(UnitOfMeasurementFormTitle)
                .addGap(24, 24, 24)
                .addComponent(unitOfMeasurementNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(unitOfMeasurementNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(unitOfMeasurementNameLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(unitOfMeasurementAbbreviationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(addUnitOfMeasurementButton)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(WindowEvent evt) {
        setActionFormComponents();
    }

    private void setActionFormComponents(){
        unitOfMeasurementFormActions.setUnitOfMeasurementNameTextField(unitOfMeasurementNameTextField);
        unitOfMeasurementFormActions.setUnitOfMeasurementAbbreviationTextField(unitOfMeasurementAbbreviationTextField);
    }

    private void addUnitOfMeasurementButtonActionPerformed(ActionEvent evt) {
        unitOfMeasurementFormActions.addUnitOfMeasurementButtonActionPerformed();
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
            java.util.logging.Logger.getLogger(AddUnitOfMeasurementForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddUnitOfMeasurementForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddUnitOfMeasurementForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddUnitOfMeasurementForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddUnitOfMeasurementForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UnitOfMeasurementFormTitle;
    private javax.swing.JButton addUnitOfMeasurementButton;
    private javax.swing.JTextField unitOfMeasurementAbbreviationTextField;
    private javax.swing.JLabel unitOfMeasurementNameLabel;
    private javax.swing.JLabel unitOfMeasurementNameLabel1;
    private javax.swing.JTextField unitOfMeasurementNameTextField;
    // End of variables declaration//GEN-END:variables
}
