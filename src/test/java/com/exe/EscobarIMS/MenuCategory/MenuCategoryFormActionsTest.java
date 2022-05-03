package com.exe.EscobarIMS.MenuCategory;

import com.exe.EscobarIMS.MenuCategory.AddMenuCategory.AddMenuCategoryRepository;
import com.exe.EscobarIMS.MenuCategory.ViewEditDeleteMenuCategory.ViewEditDeleteMenuCategoryRepository;
import com.exe.EscobarIMS.Utilities.Exceptions.FillOutAllTextFieldsException;
import com.exe.EscobarIMS.Utilities.Exceptions.NameAlreadyExistsException;
import com.exe.EscobarIMS.Utilities.Exceptions.SelectJustOneRowException;
import com.exe.EscobarIMS.Utilities.Exceptions.SelectOneOrMoreRowException;
import com.exe.EscobarIMS.Utilities.MessageDialogues;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest(properties = {"spring.main.lazy-initialization=true"})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MenuCategoryFormActionsTest {

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
    }


    @BeforeEach
    public void setUp(){
        viewEditDeleteMenuCategoryRepository.deleteAll();
        MenuCategory menuCategory1 = new MenuCategory("Menu Category 1");
        MenuCategory menuCategory2 = new MenuCategory("Menu Category 2");
        MenuCategory menuCategory3 = new MenuCategory("Menu Category 3");
        addMenuCategoryRepository.saveAll(List.of(menuCategory1, menuCategory2, menuCategory3));
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
    void adding_menu_category_name_when_successful(){
        menuCategoryNameTextField.setText("Menu Category 4");
        assertDoesNotThrow(() -> menuCategoryFormActions.validateIfAddingOfMenuCategoryIsSuccessful());

        MenuCategory acquiredMenuCategory = menuCategoryRepository.findByMenuCategoryName("Menu Category 4");
        assertNotNull(acquiredMenuCategory, "Check if the menu category added is existing");

        List<MenuCategory> menuCategories = viewEditDeleteMenuCategoryRepository.getAllMenuCategories();
        assertEquals(4, menuCategories.size(),"Check if the number of menu categories increased");
    }

    @Test
    void adding_menu_category_name_when_not_successful(){
        menuCategoryNameTextField.setText("Menu Category 1");
        assertThrows(NameAlreadyExistsException.class, () -> menuCategoryFormActions.validateIfAddingOfMenuCategoryIsSuccessful());

        menuCategoryNameTextField.setText("");
        assertThrows(FillOutAllTextFieldsException.class, () -> menuCategoryFormActions.validateIfAddingOfMenuCategoryIsSuccessful());
    }

    @Test
    void editing_menu_category_name_when_successful(){
        menuCategoryFormActions.updateTableContents();
        menuCategoryTable.setRowSelectionInterval(0,0);
        menuCategoryNameTextField.setText("Updated Menu Category 1");
        assertDoesNotThrow(() -> menuCategoryFormActions.validateIfEditingOfMenuCategoryIsSuccessful());

        MenuCategory acquiredMenuCategory = menuCategoryRepository.findByMenuCategoryName("Updated Menu Category 1");
        List<MenuCategory> menuCategories = viewEditDeleteMenuCategoryRepository.getAllMenuCategories();
        assertNotNull(acquiredMenuCategory, "Check if the editing of menu category was successful");
        assertEquals(3, menuCategories.size(), "Check if there are still 3 menu categories");
    }

    @Test
    void editing_menu_category_name_when_not_successful(){
        menuCategoryFormActions.updateTableContents();
        menuCategoryTable.clearSelection();
        menuCategoryNameTextField.setText("Updated Menu Category 1");
        assertThrows(SelectJustOneRowException.class, () -> menuCategoryFormActions.validateIfEditingOfMenuCategoryIsSuccessful());

        menuCategoryNameTextField.setText("");
        menuCategoryTable.setRowSelectionInterval(0,0);
        assertThrows(FillOutAllTextFieldsException.class, () -> menuCategoryFormActions.validateIfEditingOfMenuCategoryIsSuccessful());

        menuCategoryNameTextField.setText("Updated Menu Category 1");
        menuCategoryTable.setRowSelectionInterval(0,2);
        assertThrows(SelectJustOneRowException.class, () -> menuCategoryFormActions.validateIfEditingOfMenuCategoryIsSuccessful());

        menuCategoryNameTextField.setText("Menu Category 1");
        menuCategoryTable.setRowSelectionInterval(0,0);
        assertThrows(NameAlreadyExistsException.class, () -> menuCategoryFormActions.validateIfEditingOfMenuCategoryIsSuccessful());
    }

    @Test
    void deleting_menu_category_name_when_successful(){
        menuCategoryFormActions.updateTableContents();
        menuCategoryTable.setRowSelectionInterval(0,0);
        assertDoesNotThrow(() -> menuCategoryFormActions.validateIfDeletingOfMenuCategoryIsSuccessful());


        List<MenuCategory> menuCategories = viewEditDeleteMenuCategoryRepository.getAllMenuCategories();
        assertEquals(2, menuCategories.size(), "Check if there are 2 menu categories after deleting one");

        menuCategoryFormActions.updateTableContents();
        menuCategoryTable.setRowSelectionInterval(0,1);
        assertDoesNotThrow(() -> menuCategoryFormActions.validateIfDeletingOfMenuCategoryIsSuccessful());

        List<MenuCategory> menuCategories2 = viewEditDeleteMenuCategoryRepository.getAllMenuCategories();
        assertEquals(0, menuCategories2.size(), "Check if there are 0 menu categories after deleting two");
    }

    @Test
    void deleting_menu_category_name_when_not_successful(){
        menuCategoryFormActions.updateTableContents();
        menuCategoryTable.clearSelection();
        assertThrows(SelectOneOrMoreRowException.class, () -> menuCategoryFormActions.validateIfDeletingOfMenuCategoryIsSuccessful());

        List<MenuCategory> menuCategories = viewEditDeleteMenuCategoryRepository.getAllMenuCategories();
        assertEquals(3, menuCategories.size(), "Check if there are no menu categories that were deleted");
    }
}