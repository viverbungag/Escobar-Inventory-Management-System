package com.exe.EscobarIMS.MenuCategory;

import com.exe.EscobarIMS.MenuCategory.AddMenuCategory.AddMenuCategoryRepository;
import com.exe.EscobarIMS.MenuCategory.ViewEditDeleteMenuCategory.ViewEditDeleteMenuCategoryRepository;
import com.exe.EscobarIMS.Utilities.Exceptions.IntegerValuesOnlyException;
import com.exe.EscobarIMS.Utilities.MessageDialogues;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(properties = {"spring.main.lazy-initialization=true"})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MenuCategoryPaginationTest {
    @Autowired
    MenuCategoryRepository menuCategoryRepository;
    @Autowired
    AddMenuCategoryRepository addMenuCategoryRepository;
    @Autowired
    ViewEditDeleteMenuCategoryRepository viewEditDeleteMenuCategoryRepository;
    @Autowired
    MenuCategoryFormActions menuCategoryFormActions;
    @Autowired
    MessageDialogues messageDialogues;

    private JRadioButton ascendingRadioButton;
    private JComboBox<String> contentLimitComboBox;
    private JTextField currentPageNumberTextField;
    private JRadioButton descendingRadioButton;
    private JTextField menuCategoryNameTextField;
    private JTable menuCategoryTable;
    private JComboBox<String> sortingMethodComboBox;
    public JButton previousButton;
    public JButton nextButton;



    public void initComponents() {
        menuCategoryTable = new JTable();
        menuCategoryNameTextField = new JTextField();
        currentPageNumberTextField = new JTextField();
        sortingMethodComboBox = new JComboBox<>();
        ascendingRadioButton = new JRadioButton();
        descendingRadioButton = new JRadioButton();
        contentLimitComboBox = new JComboBox<>();
        previousButton = new JButton();
        nextButton = new JButton();

        menuCategoryTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {
                        "Menu Category Name"
                })
        {
            Class[] types = new Class [] {
                    String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        currentPageNumberTextField.setText("1");
        sortingMethodComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Menu Category Name" }));
        contentLimitComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "5", "15", "30", "50", "100" }));
        setActionFormComponents();
    }

    private void setActionFormComponents(){
        menuCategoryFormActions.setContentLimitComboBox(contentLimitComboBox);
        menuCategoryFormActions.setCurrentPageNumberTextField(currentPageNumberTextField);
        menuCategoryFormActions.setMenuCategoryNameTextField(menuCategoryNameTextField);
        menuCategoryFormActions.setMenuCategoryTable(menuCategoryTable);
        menuCategoryFormActions.setAscendingRadioButton(ascendingRadioButton);
        menuCategoryFormActions.setDescendingRadioButton(descendingRadioButton);
        menuCategoryFormActions.setSortingMethodComboBox(sortingMethodComboBox);
        menuCategoryFormActions.setPreviousButton(previousButton);
        menuCategoryFormActions.setNextButton(nextButton);
    }

    @BeforeAll
    public void beforeAllSetUp(){
        initComponents();
        setActionFormComponents();
    }


    @BeforeEach
    public void setUp(){
        viewEditDeleteMenuCategoryRepository.deleteAll();
        MenuCategory menuCategory1 = new MenuCategory("Menu Category 1");
        MenuCategory menuCategory2 = new MenuCategory("Menu Category 2");
        MenuCategory menuCategory3 = new MenuCategory("Menu Category 3");
        MenuCategory menuCategory4 = new MenuCategory("Menu Category 4");
        MenuCategory menuCategory5 = new MenuCategory("Menu Category 5");
        MenuCategory menuCategory6 = new MenuCategory("Menu Category 6");
        MenuCategory menuCategory7 = new MenuCategory("Menu Category 7");
        MenuCategory menuCategory8 = new MenuCategory("Menu Category 8");
        MenuCategory menuCategory9 = new MenuCategory("Menu Category 9");
        MenuCategory menuCategory10 = new MenuCategory("Menu Category 10");
        MenuCategory menuCategory11 = new MenuCategory("Menu Category 11");
        MenuCategory menuCategory12 = new MenuCategory("Menu Category 12");
        MenuCategory menuCategory13 = new MenuCategory("Menu Category 13");
        MenuCategory menuCategory14 = new MenuCategory("Menu Category 14");
        MenuCategory menuCategory15 = new MenuCategory("Menu Category 15");
        MenuCategory menuCategory16 = new MenuCategory("Menu Category 16");
        addMenuCategoryRepository.saveAll(List.of(
                menuCategory1, menuCategory2, menuCategory3,
                menuCategory4, menuCategory5, menuCategory6,
                menuCategory7, menuCategory8, menuCategory9,
                menuCategory10, menuCategory11, menuCategory12,
                menuCategory13, menuCategory14, menuCategory15,
                menuCategory16));

        descendingRadioButton.setSelected(false);
        ascendingRadioButton.setSelected(false);
        sortingMethodComboBox.setSelectedItem("None");
        currentPageNumberTextField.setText("1");
        contentLimitComboBox.setSelectedItem("5");
    }

    @AfterEach
    void tearDown(){

    }

    @Test
    void injected_components_are_not_null(){
        assertNotNull(menuCategoryRepository);
        assertNotNull(addMenuCategoryRepository);
        assertNotNull(viewEditDeleteMenuCategoryRepository);
        assertNotNull(menuCategoryFormActions);
        assertNotNull(messageDialogues);
    }

    @Test
    void previousButtonActionPerformed_when_pressing_previous_button(){
        currentPageNumberTextField.setText("2");
        menuCategoryFormActions.previousButtonActionPerformed();
        assertEquals("1", currentPageNumberTextField.getText(), "Check if the current page number text field decreased");

        menuCategoryTable.setRowSelectionInterval(0,0);
        menuCategoryFormActions.menuCategoryTableMousePressed();
        assertEquals("Menu Category 1", menuCategoryNameTextField.getText(), "Check if the first row is correct");

        assertFalse(previousButton.isEnabled(), "Check if the button is disabled");
    }

    @Test
    void nextButtonActionPerformed_when_pressing_next_button(){
        currentPageNumberTextField.setText("3");
        menuCategoryFormActions.nextButtonActionPerformed();
        assertEquals("4", currentPageNumberTextField.getText(), "Check if the current page number text field increased");

        menuCategoryTable.setRowSelectionInterval(0,0);
        menuCategoryFormActions.menuCategoryTableMousePressed();
        assertEquals("Menu Category 16", menuCategoryNameTextField.getText(), "Check if the first row is correct");

        assertFalse(nextButton.isEnabled(), "Check if the button is disabled");
    }

    @Test
    void currentPageNumberTextFieldFocusLost(){
        currentPageNumberTextField.setText("one");
        assertThrows(IntegerValuesOnlyException.class, () -> menuCategoryFormActions.validateCurrentPageNumberTextFieldFocusLost());

        currentPageNumberTextField.setText("-1");
        assertDoesNotThrow(() -> menuCategoryFormActions.validateCurrentPageNumberTextFieldFocusLost());
        assertEquals("1", currentPageNumberTextField.getText());

        currentPageNumberTextField.setText("5");
        assertDoesNotThrow(() -> menuCategoryFormActions.validateCurrentPageNumberTextFieldFocusLost());
        assertEquals("4", currentPageNumberTextField.getText());
    }

    @Test
    void contentLimitComboBoxActionPerformed_when_data_are_not_sorted(){
        currentPageNumberTextField.setText("5");
        menuCategoryFormActions.contentLimitComboBoxActionPerformed();
        assertEquals("1", currentPageNumberTextField.getText(), "Check if the current page number text field would reset to 1 if it is more than the last page");
        assertEquals("Menu Category 1", menuCategoryTable.getValueAt(0,0), "Check if the first row is correct");
    }

    @Test
    void ascendingRadioButtonItemStateChanged_clicking_the_ascending_button_and_sorted_by_name(){
        ascendingRadioButton.setSelected(true);
        descendingRadioButton.setSelected(false);

        sortingMethodComboBox.setSelectedItem("Menu Category Name");
        menuCategoryFormActions.ascendingRadioButtonItemStateChanged();
        assertEquals("Menu Category 1", menuCategoryTable.getValueAt(0,0), "Check if the first row is correct");
    }

    @Test
    void ascendingRadioButtonItemStateChanged_clicking_the_descending_button_and_sorted_by_name(){
        descendingRadioButton.setSelected(true);
        ascendingRadioButton.setSelected(false);

        sortingMethodComboBox.setSelectedItem("Menu Category Name");
        menuCategoryFormActions.ascendingRadioButtonItemStateChanged();
        assertEquals("Menu Category 9", menuCategoryTable.getValueAt(0,0), "Check if the first row is correct");
    }

    @Test
    void sortingMethodComboBoxActionPerformed_when_the_limit_is_15_and_page_is_1(){
        currentPageNumberTextField.setText("1");
        contentLimitComboBox.setSelectedItem("15");
        menuCategoryFormActions.sortingMethodComboBoxActionPerformed();
        assertEquals(15, menuCategoryTable.getRowCount());
    }

    @Test
    void sortingMethodComboBoxActionPerformed_when_the_limit_is_15_and_page_is_2(){
        currentPageNumberTextField.setText("2");
        contentLimitComboBox.setSelectedItem("15");
        menuCategoryFormActions.sortingMethodComboBoxActionPerformed();
        assertEquals(1, menuCategoryTable.getRowCount());
    }

}
