package com.exe.EscobarIMS.Validations;


import com.exe.EscobarIMS.Utilities.Validations;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = {"spring.main.lazy-initialization=true"})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ValidationsTest {

    @Autowired
    Validations validations;

    JTextField textField = new JTextField();

    @Test
    void injected_components_are_not_null(){
        assertNotNull(validations);
    }

    @Test
    void isTextFieldContainingOnlyDecimalValues_test(){
        textField.setText("1");
        assertTrue(validations.isTextFieldContainingOnlyDecimalValues(textField));

        textField.setText("-1");
        assertTrue(validations.isTextFieldContainingOnlyDecimalValues(textField));

        textField.setText("1.1");
        assertTrue(validations.isTextFieldContainingOnlyDecimalValues(textField));

        textField.setText("-1.1");
        assertTrue(validations.isTextFieldContainingOnlyDecimalValues(textField));

        textField.setText("0");
        assertTrue(validations.isTextFieldContainingOnlyDecimalValues(textField));
    }

    @Test
    void isTextFieldContainingOnlyIntegerValues_test(){
        textField.setText("1.1");
        assertFalse(validations.isTextFieldContainingOnlyIntegerValues(textField));

        textField.setText("-1.1");
        assertFalse(validations.isTextFieldContainingOnlyIntegerValues(textField));

        textField.setText("1");
        assertTrue(validations.isTextFieldContainingOnlyIntegerValues(textField));

        textField.setText("-1");
        assertTrue(validations.isTextFieldContainingOnlyIntegerValues(textField));
    }

    @Test
    void isTextFieldNegativeValue_test(){
        textField.setText("-1");
        assertTrue(validations.isTextFieldNegativeValue(textField));

        textField.setText("1");
        assertFalse(validations.isTextFieldNegativeValue(textField));

        textField.setText("-1.1");
        assertTrue(validations.isTextFieldNegativeValue(textField));
    }
}
