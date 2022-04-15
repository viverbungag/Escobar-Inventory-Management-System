package com.exe.EscobarIMS.Utilities;

import javax.swing.*;

public class LookAndFeelUtils {

    public static void setWindowsLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "There was an error while loading windows look and feel",
                    "Alert",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
