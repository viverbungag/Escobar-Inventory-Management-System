package com.exe.EscobarIMS.Utilities;

import javax.swing.*;

import static javax.swing.JOptionPane.*;

public class LookAndFeelUtils {

    public static void setWindowsLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            showMessageDialog(
                    null,
                    "There was an error while loading windows look and feel",
                    "Alert",
                    ERROR_MESSAGE);
        }
    }
}
