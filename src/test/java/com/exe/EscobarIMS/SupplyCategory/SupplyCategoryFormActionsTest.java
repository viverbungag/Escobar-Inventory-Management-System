package com.exe.EscobarIMS.SupplyCategory;

import com.exe.EscobarIMS.SupplyCategory.AddSupplyCategory.AddSupplyCategoryRepository;
import com.exe.EscobarIMS.SupplyCategory.ViewEditDeleteSupplyCategory.ViewEditDeleteSupplyCategoryRepository;
import com.exe.EscobarIMS.Utilities.MessageDialogues;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest(properties = {"spring.main.lazy-initialization=true"})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SupplyCategoryFormActionsTest {

    @Autowired SupplyCategoryRepository supplyCategoryRepository;
    @Autowired AddSupplyCategoryRepository addSupplyCategoryRepository;
    @Autowired ViewEditDeleteSupplyCategoryRepository viewEditDeleteSupplyCategoryRepository;
    @Autowired SupplyCategoryFormActions supplyCategoryFormActions;
    @Autowired MessageDialogues messageDialogues;

    private JRadioButton ascendingRadioButton;
    private JComboBox<String> contentLimitComboBox;
    private JTextField currentPageNumberTextField;
    private JRadioButton descendingRadioButton;
    private JTextField supplyCategoryNameTextField;
    private JTable supplyCategoryTable;
    private JComboBox<String> sortingMethodComboBox;


    public void initComponents() {
        supplyCategoryTable = new JTable();
        supplyCategoryNameTextField = new JTextField();
        currentPageNumberTextField = new JTextField();
        sortingMethodComboBox = new JComboBox<>();
        ascendingRadioButton = new JRadioButton();
        descendingRadioButton = new JRadioButton();
        contentLimitComboBox = new JComboBox<>();

        supplyCategoryTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {
                        "Supply Category Name"
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
        sortingMethodComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Supply Category Name" }));
        contentLimitComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "5", "15", "30", "50", "100" }));
        setActionFormComponents();
    }

    private void setActionFormComponents(){
        supplyCategoryFormActions.setContentLimitComboBox(contentLimitComboBox);
        supplyCategoryFormActions.setCurrentPageNumberTextField(currentPageNumberTextField);
        supplyCategoryFormActions.setSupplyCategoryNameTextField(supplyCategoryNameTextField);
        supplyCategoryFormActions.setSupplyCategoryTable(supplyCategoryTable);
        supplyCategoryFormActions.setAscendingRadioButton(ascendingRadioButton);
        supplyCategoryFormActions.setDescendingRadioButton(descendingRadioButton);
        supplyCategoryFormActions.setSortingMethodComboBox(sortingMethodComboBox);
    }

    @BeforeAll
    public void beforeAllSetUp(){
        initComponents();
        setActionFormComponents();
        messageDialogues.setShouldShowMessageDialog(false);
    }


    @BeforeEach
    public void setUp(){
        viewEditDeleteSupplyCategoryRepository.deleteAll();
        SupplyCategory supplyCategory1 = new SupplyCategory("Supply Category 1");
        SupplyCategory supplyCategory2 = new SupplyCategory("Supply Category 2");
        SupplyCategory supplyCategory3 = new SupplyCategory("Supply Category 3");
        addSupplyCategoryRepository.saveAll(List.of(supplyCategory1, supplyCategory2, supplyCategory3));
    }

    @AfterEach
    void tearDown(){

    }

    @Test
    void injected_components_are_not_null(){
        assertNotNull(supplyCategoryRepository);
        assertNotNull(addSupplyCategoryRepository);
        assertNotNull(viewEditDeleteSupplyCategoryRepository);
        assertNotNull(supplyCategoryFormActions);
        assertNotNull(messageDialogues);
    }

    @Test
    void adding_supply_category_name_when_successful(){
        supplyCategoryNameTextField.setText("Supply Category 4");
        assertTrue(supplyCategoryFormActions.isAddSupplyCategorySuccessful(), "Check if the adding of supply category was successful");

        SupplyCategory acquiredSupplyCategory = supplyCategoryRepository.findBySupplyCategoryName("Supply Category 4");
        assertNotNull(acquiredSupplyCategory, "Check if the supply category added is existing");

        List<SupplyCategory> supplyCategories = viewEditDeleteSupplyCategoryRepository.getAllSupplyCategories();
        assertEquals(4, supplyCategories.size(),"Check if the number of supply categories increased");
    }

    @Test
    void adding_supply_category_name_when_not_successful(){
        supplyCategoryNameTextField.setText("Supply Category 1");
        assertFalse(supplyCategoryFormActions.isAddSupplyCategorySuccessful(), "When the name inputted is existing");

        supplyCategoryNameTextField.setText("");
        assertFalse(supplyCategoryFormActions.isAddSupplyCategorySuccessful(), "When the text field is blank");
    }

    @Test
    void editing_supply_category_name_when_successful(){
        supplyCategoryFormActions.generateTableContents();
        supplyCategoryTable.setRowSelectionInterval(0,0);
        supplyCategoryNameTextField.setText("Supply Category 4");
        assertTrue(supplyCategoryFormActions.isEditSupplyCategorySuccessful());

        SupplyCategory acquiredSupplyCategory = supplyCategoryRepository.findBySupplyCategoryName("Supply Category 4");
        List<SupplyCategory> supplyCategories = viewEditDeleteSupplyCategoryRepository.getAllSupplyCategories();
        assertNotNull(acquiredSupplyCategory, "Check if the editing of supply category was successful");
        assertEquals(3, supplyCategories.size(), "Check if there are still 3 supply categories");
    }

    @Test
    void editing_supply_category_name_when_not_successful(){
        supplyCategoryFormActions.generateTableContents();
        supplyCategoryTable.clearSelection();
        supplyCategoryNameTextField.setText("Supply Category 4");
        assertFalse(supplyCategoryFormActions.isEditSupplyCategorySuccessful(), "When there are no rows selected");

        supplyCategoryNameTextField.setText("");
        supplyCategoryTable.setRowSelectionInterval(0,0);
        assertFalse(supplyCategoryFormActions.isEditSupplyCategorySuccessful(), "When the text field is blank");

        supplyCategoryNameTextField.setText("Supply Category 4");
        supplyCategoryTable.setRowSelectionInterval(0,2);
        assertFalse(supplyCategoryFormActions.isEditSupplyCategorySuccessful(), "When there are multiple rows selected");

        supplyCategoryNameTextField.setText("Supply Category 1");
        supplyCategoryTable.setRowSelectionInterval(0,0);
        assertFalse(supplyCategoryFormActions.isEditSupplyCategorySuccessful(), "When the inputted name already exist");
    }

    @Test
    void deleting_supply_category_name_when_successful(){
        supplyCategoryFormActions.generateTableContents();
        supplyCategoryTable.setRowSelectionInterval(0,0);
        assertTrue(supplyCategoryFormActions.isDeleteSupplyCategorySuccessful(), "Deleting one supply category");


        List<SupplyCategory> supplyCategories = viewEditDeleteSupplyCategoryRepository.getAllSupplyCategories();
        assertEquals(2, supplyCategories.size(), "Check if there are 2 supply categories after deleting one");

        supplyCategoryFormActions.generateTableContents();
        supplyCategoryTable.setRowSelectionInterval(0,2);
        assertTrue(supplyCategoryFormActions.isDeleteSupplyCategorySuccessful(), "Deleting two supply category");

        List<SupplyCategory> supplyCategories2 = viewEditDeleteSupplyCategoryRepository.getAllSupplyCategories();
        assertEquals(0, supplyCategories2.size(), "Check if there are 0 supply categories after deleting two");
    }

    @Test
    void deleting_supply_category_name_when_not_successful(){
        supplyCategoryFormActions.generateTableContents();
        supplyCategoryTable.clearSelection();
        assertFalse(supplyCategoryFormActions.isDeleteSupplyCategorySuccessful(), "When there are no row selected");

        List<SupplyCategory> supplyCategories = viewEditDeleteSupplyCategoryRepository.getAllSupplyCategories();
        assertEquals(3, supplyCategories.size(), "Check if there are no supply categories that were deleted");
    }
}