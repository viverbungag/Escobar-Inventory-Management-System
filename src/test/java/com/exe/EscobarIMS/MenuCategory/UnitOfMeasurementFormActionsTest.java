package com.exe.EscobarIMS.MenuCategory;

import com.exe.EscobarIMS.MenuCategory.AddMenuCategory.AddMenuCategoryRepository;
import com.exe.EscobarIMS.MenuCategory.ViewEditDeleteMenuCategory.ViewEditDeleteMenuCategoryRepository;
import com.exe.EscobarIMS.Utilities.MessageDialogues;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(properties = "spring.main.lazy-initialization=true")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UnitOfMeasurementFormActionsTest {

    @Autowired MenuCategoryRepository menuCategoryRepository;
    @Autowired AddMenuCategoryRepository addMenuCategoryRepository;
    @Autowired ViewEditDeleteMenuCategoryRepository viewEditDeleteMenuCategoryRepository;
    @Autowired MenuCategoryFormActions menuCategoryFormActions;
    @Autowired MessageDialogues messageDialogues;

    private JRadioButton ascendingRadioButton;
    private JComboBox<String> contentLimitComboBox;
    private JTextField currentPageNumberTextField;
    private JRadioButton descendingRadioButton;
    private JTextField menuCategoryNameTextField;
    private JTable menuCategoryTable;
    private JComboBox<String> sortingMethodComboBox;


    public void initComponents() {
        menuCategoryTable = new JTable();
        menuCategoryNameTextField = new JTextField();
        currentPageNumberTextField = new JTextField();
        sortingMethodComboBox = new JComboBox<>();
        ascendingRadioButton = new JRadioButton();
        descendingRadioButton = new JRadioButton();
        contentLimitComboBox = new JComboBox<>();

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
    }

    @BeforeAll
    public void beforeAllSetUp(){
        initComponents();
        setActionFormComponents();
        messageDialogues.setShouldShowMessageDialog(false);
    }


    @BeforeEach
    public void setUp(){
        MenuCategory menuCategory1 = new MenuCategory("Menu Category 1");
        MenuCategory menuCategory2 = new MenuCategory("Menu Category 2");
        MenuCategory menuCategory3 = new MenuCategory("Menu Category 3");
        addMenuCategoryRepository.saveAll(List.of(menuCategory1, menuCategory2, menuCategory3));
    }

    @AfterEach
    void tearDown(){
        viewEditDeleteMenuCategoryRepository.deleteAll();
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
    void adding_menu_category_name_when_successful(){
        menuCategoryNameTextField.setText("Menu Category 4");
        assertTrue(menuCategoryFormActions.isAddMenuCategorySuccessful(), "Check if the adding of menu category was successful");

        MenuCategory acquiredMenuCategory = menuCategoryRepository.findByMenuCategoryName("Menu Category 4");
        assertNotNull(acquiredMenuCategory, "Check if the menu category added is existing");

        List<MenuCategory> menuCategories = viewEditDeleteMenuCategoryRepository.getAllMenuCategories();
        assertEquals(4, menuCategories.size(),"Check if the number of menu categories increased");
    }

    @Test
    void adding_menu_category_name_when_not_successful(){
        menuCategoryNameTextField.setText("Menu Category 1");
        assertFalse(menuCategoryFormActions.isAddMenuCategorySuccessful(), "When the name inputted is existing");

        menuCategoryNameTextField.setText("");
        assertFalse(menuCategoryFormActions.isAddMenuCategorySuccessful(), "When the text field is blank");
    }

    @Test
    void editing_menu_category_name_when_successful(){
        menuCategoryFormActions.generateTableContents();
        menuCategoryTable.setRowSelectionInterval(0,0);
        menuCategoryNameTextField.setText("Updated Menu Category 1");
        assertTrue(menuCategoryFormActions.isEditMenuCategorySuccessful());

        MenuCategory acquiredMenuCategory = menuCategoryRepository.findByMenuCategoryName("Updated Menu Category 1");
        List<MenuCategory> menuCategories = viewEditDeleteMenuCategoryRepository.getAllMenuCategories();
        assertNotNull(acquiredMenuCategory, "Check if the editing of menu category was successful");
        assertEquals(3, menuCategories.size(), "Check if there are still 3 menu categories");
    }

    @Test
    void editing_menu_category_name_when_not_successful(){
        menuCategoryFormActions.generateTableContents();
        menuCategoryTable.clearSelection();
        menuCategoryNameTextField.setText("Updated Menu Category 1");
        assertFalse(menuCategoryFormActions.isEditMenuCategorySuccessful(), "When there are no rows selected");

        menuCategoryNameTextField.setText("");
        menuCategoryTable.setRowSelectionInterval(0,0);
        assertFalse(menuCategoryFormActions.isEditMenuCategorySuccessful(), "When the text field is blank");

        menuCategoryNameTextField.setText("Updated Menu Category 1");
        menuCategoryTable.setRowSelectionInterval(0,2);
        assertFalse(menuCategoryFormActions.isEditMenuCategorySuccessful(), "When there are multiple rows selected");

        menuCategoryNameTextField.setText("Menu Category 1");
        menuCategoryTable.setRowSelectionInterval(0,0);
        assertFalse(menuCategoryFormActions.isEditMenuCategorySuccessful(), "When the inputted name already exist");
    }

    @Test
    void deleting_menu_category_name_when_successful(){
        menuCategoryFormActions.generateTableContents();
        menuCategoryTable.setRowSelectionInterval(0,0);
        assertTrue(menuCategoryFormActions.isDeleteMenuCategorySuccessful(), "Deleting one menu category");


        List<MenuCategory> menuCategories = viewEditDeleteMenuCategoryRepository.getAllMenuCategories();
        assertEquals(2, menuCategories.size(), "Check if there are 2 menu categories after deleting one");

        menuCategoryFormActions.generateTableContents();
        menuCategoryTable.setRowSelectionInterval(0,2);
        assertTrue(menuCategoryFormActions.isDeleteMenuCategorySuccessful(), "Deleting two menu category");

        List<MenuCategory> menuCategories2 = viewEditDeleteMenuCategoryRepository.getAllMenuCategories();
        assertEquals(0, menuCategories2.size(), "Check if there are 0 menu categories after deleting two");
    }

    @Test
    void deleting_menu_category_name_when_not_successful(){
        menuCategoryFormActions.generateTableContents();
        menuCategoryTable.clearSelection();
        assertFalse(menuCategoryFormActions.isDeleteMenuCategorySuccessful(), "When there are no row selected");

        List<MenuCategory> menuCategories = viewEditDeleteMenuCategoryRepository.getAllMenuCategories();
        assertEquals(3, menuCategories.size(), "Check if there are no menu categories that were deleted");
    }
}