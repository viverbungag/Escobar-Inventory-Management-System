package com.exe.EscobarIMS.Supplier;

import com.exe.EscobarIMS.Supplier.AddSupplier.AddSupplierRepository;
import com.exe.EscobarIMS.Supplier.ViewEditDeleteSupplier.ViewEditDeleteSupplierRepository;
import com.exe.EscobarIMS.Utilities.Exceptions.*;
import com.exe.EscobarIMS.Utilities.MessageDialogues;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = {"spring.main.lazy-initialization=true"})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SupplierFormActionsTest {
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    AddSupplierRepository addSupplierRepository;
    @Autowired
    ViewEditDeleteSupplierRepository viewEditDeleteSupplierRepository;
    @Autowired
    SupplierFormActions supplierFormActions;
    @Autowired
    MessageDialogues messageDialogues;

    private JRadioButton ascendingRadioButton;
    private JComboBox<String> contentLimitComboBox;
    private JTextField currentPageNumberTextField;
    private JRadioButton descendingRadioButton;
    private JTextField supplierNameTextField;
    private JTextField supplierAddressTextField;
    private JTextField supplierContactNumberTextField;
    private JTextField supplierContactPersonTextField;
    private JTable supplierTable;
    private JComboBox<String> sortingMethodComboBox;


    public void initComponents() {
        supplierTable = new JTable();
        supplierNameTextField = new JTextField();
        supplierAddressTextField = new JTextField();
        supplierContactNumberTextField = new JTextField();
        supplierContactPersonTextField = new JTextField();
        currentPageNumberTextField = new JTextField();
        sortingMethodComboBox = new JComboBox<>();
        ascendingRadioButton = new JRadioButton();
        descendingRadioButton = new JRadioButton();
        contentLimitComboBox = new JComboBox<>();

        supplierTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {
                        "Supplier Name", "Supplier Address", "Supplier Contact Number", "Supplier Contact Person"
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
        sortingMethodComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Supplier Name", "Supplier Address", "Supplier Contact Number", "Supplier Contact Person" }));
        contentLimitComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "5", "15", "30", "50", "100" }));
    }

    private void setActionFormComponents(){
        supplierFormActions.setContentLimitComboBox(contentLimitComboBox);
        supplierFormActions.setCurrentPageNumberTextField(currentPageNumberTextField);
        supplierFormActions.setSupplierNameTextField(supplierNameTextField);
        supplierFormActions.setSupplierAddressTextField(supplierAddressTextField);
        supplierFormActions.setSupplierContactNumberTextField(supplierContactNumberTextField);
        supplierFormActions.setSupplierContactPersonTextField(supplierContactPersonTextField);
        supplierFormActions.setSupplierTable(supplierTable);
        supplierFormActions.setAscendingRadioButton(ascendingRadioButton);
        supplierFormActions.setDescendingRadioButton(descendingRadioButton);
        supplierFormActions.setSortingMethodComboBox(sortingMethodComboBox);
    }

    @BeforeAll
    public void beforeAllSetUp(){
        initComponents();
        setActionFormComponents();
        messageDialogues.setShouldShowMessageDialog(false);
    }


    @BeforeEach
    public void setUp(){
        viewEditDeleteSupplierRepository.deleteAll();
        Supplier supplier1 = new Supplier(
                "Supplier 1",
                "Address 1",
                "09273173101",
                "Person 1");
        Supplier supplier2 = new Supplier(
                "Supplier 2",
                "Address 2",
                "09273173102",
                "Person 2");
        Supplier supplier3 = new Supplier(
                "Supplier 3",
                "Address 3",
                "09273173103",
                "Person 3");
        addSupplierRepository.saveAll(List.of(supplier1, supplier2, supplier3));
    }

    @AfterEach
    void tearDown(){

    }

    @Test
    void injected_components_are_not_null(){
        assertNotNull(supplierRepository);
        assertNotNull(addSupplierRepository);
        assertNotNull(viewEditDeleteSupplierRepository);
        assertNotNull(supplierFormActions);
        assertNotNull(messageDialogues);
    }

    @Test
    void adding_supplier_when_successful(){
        supplierNameTextField.setText("Supplier 4");
        supplierAddressTextField.setText("Address 4");
        supplierContactNumberTextField.setText("09273173104");
        supplierContactPersonTextField.setText("Person 4");
        assertDoesNotThrow(() -> supplierFormActions.isAddSupplierSuccessful());

        Supplier supplier = supplierRepository.findBySupplierName("Supplier 4");
        assertNotNull(supplier, "Check if the Supplier added is existing");

        List<Supplier> suppliers = viewEditDeleteSupplierRepository.getAllSupplier();
        assertEquals(4, suppliers.size(),"Check if the number of Suppliers increased");
    }

    @Test
    void adding_supplier_when_not_successful(){
        supplierNameTextField.setText("Supplier 1");
        supplierAddressTextField.setText("Address 1");
        supplierContactNumberTextField.setText("09273173101");
        supplierContactPersonTextField.setText("Person 1");
        assertThrows(NameAlreadyExistsException.class, () -> supplierFormActions.isAddSupplierSuccessful(), "When the name inputted is existing");

        supplierNameTextField.setText("Supplier 4");
        supplierAddressTextField.setText("Address 4");
        supplierContactNumberTextField.setText("Not a number");
        supplierContactPersonTextField.setText("Person 4");
        assertThrows(InvalidPhoneNumberException.class, () -> supplierFormActions.isAddSupplierSuccessful(), "When the contact number inputted is not valid");

        supplierNameTextField.setText("");
        supplierAddressTextField.setText("Address 4");
        supplierContactNumberTextField.setText("09273173104");
        supplierContactPersonTextField.setText("Person 4");
        assertThrows(FillOutAllTextFieldsException.class, () -> supplierFormActions.isAddSupplierSuccessful(), "When the name text field is blank");

        supplierNameTextField.setText("Supplier 4");
        supplierAddressTextField.setText("");
        supplierContactNumberTextField.setText("09273173104");
        supplierContactPersonTextField.setText("Person 4");
        assertThrows(FillOutAllTextFieldsException.class, () -> supplierFormActions.isAddSupplierSuccessful(), "When the Address text field is blank");

        supplierNameTextField.setText("Supplier 4");
        supplierAddressTextField.setText("Address 4");
        supplierContactNumberTextField.setText("");
        supplierContactPersonTextField.setText("Person 4");
        assertThrows(FillOutAllTextFieldsException.class, () -> supplierFormActions.isAddSupplierSuccessful(), "When the Contact Number text field is blank");

        supplierNameTextField.setText("Supplier 4");
        supplierAddressTextField.setText("Address 4");
        supplierContactNumberTextField.setText("09273173104");
        supplierContactPersonTextField.setText("");
        assertThrows(FillOutAllTextFieldsException.class, () -> supplierFormActions.isAddSupplierSuccessful(), "When the Contact Person text field is blank");
    }

    @Test
    void editing_supplier_when_successful(){
        supplierFormActions.generateTableContents();
        supplierTable.setRowSelectionInterval(0,0);
        supplierNameTextField.setText("Updated Supplier 1");
        supplierAddressTextField.setText("Updated Address 1");
        supplierContactNumberTextField.setText("19273173101");
        supplierContactPersonTextField.setText("Updated Person 1");
        assertDoesNotThrow(() -> supplierFormActions.isEditSupplierSuccessful());

        Supplier supplier = supplierRepository.findBySupplierName("Updated Supplier 1");
        List<Supplier> suppliers = viewEditDeleteSupplierRepository.getAllSupplier();
        assertNotNull(supplier, "Check if the editing of supplier was successful");
        assertEquals(supplier.getSupplierAddress(), "Updated Address 1", "Check if the address is updated");
        assertEquals(supplier.getSupplierContactNumber(), "19273173101", "Check if the contact number is updated");
        assertEquals(supplier.getSupplierContactPerson(), "Updated Person 1", "Check if the contact person is updated");
        assertEquals(3, suppliers.size(), "Check if there are still 3 suppliers");

        supplierFormActions.generateTableContents();
        supplierTable.setRowSelectionInterval(1,1);
        supplierNameTextField.setText("Supplier 2");
        supplierAddressTextField.setText("Updated Supplier Address 2");
        supplierContactNumberTextField.setText("19273173102");
        supplierContactPersonTextField.setText("Updated Person 2");
        assertDoesNotThrow(() -> supplierFormActions.isEditSupplierSuccessful(), "Checks if it can update everything other than the name");
        Supplier supplier2 = supplierRepository.findBySupplierName("Supplier 2");
        assertEquals(supplier2.getSupplierAddress(), "Updated Supplier Address 2", "Check if the address is updated");
        assertEquals(supplier2.getSupplierContactNumber(), "19273173102", "Check if the contact number is updated");
        assertEquals(supplier2.getSupplierContactPerson(), "Updated Person 2", "Check if the contact person is updated");
    }

    @Test
    void editing_supplier_when_not_successful(){
        supplierFormActions.generateTableContents();
        supplierTable.clearSelection();
        assertThrows(SelectJustOneRowException.class, () -> supplierFormActions.isEditSupplierSuccessful(), "When there are no rows selected");

        supplierTable.setRowSelectionInterval(0,0);
        supplierNameTextField.setText("Updated Supplier 1");
        supplierAddressTextField.setText("Updated Address 1");
        supplierContactNumberTextField.setText("Not a number");
        supplierContactPersonTextField.setText("Updated Person 1");
        assertThrows(InvalidPhoneNumberException.class, () -> supplierFormActions.isEditSupplierSuccessful(), "When the contact number inputted is not valid");

        supplierTable.setRowSelectionInterval(0,0);
        supplierNameTextField.setText("");
        supplierAddressTextField.setText("Updated Address 1");
        supplierContactNumberTextField.setText("19273173101");
        supplierContactPersonTextField.setText("Updated Person 1");
        assertThrows(FillOutAllTextFieldsException.class, () -> supplierFormActions.isEditSupplierSuccessful(), "When the name text field is blank");

        supplierTable.setRowSelectionInterval(0,0);
        supplierNameTextField.setText("Updated Supplier 1");
        supplierAddressTextField.setText("");
        supplierContactNumberTextField.setText("19273173101");
        supplierContactPersonTextField.setText("Updated Person 1");
        assertThrows(FillOutAllTextFieldsException.class, () -> supplierFormActions.isEditSupplierSuccessful(), "When the Address text field is blank");

        supplierTable.setRowSelectionInterval(0,0);
        supplierNameTextField.setText("Updated Supplier 1");
        supplierAddressTextField.setText("Updated Address 1");
        supplierContactNumberTextField.setText("");
        supplierContactPersonTextField.setText("Updated Person 1");
        assertThrows(FillOutAllTextFieldsException.class, () -> supplierFormActions.isEditSupplierSuccessful(), "When the Contact Number text field is blank");

        supplierTable.setRowSelectionInterval(0,0);
        supplierNameTextField.setText("Updated Supplier 1");
        supplierAddressTextField.setText("Updated Address 1");
        supplierContactNumberTextField.setText("19273173101");
        supplierContactPersonTextField.setText("");
        assertThrows(FillOutAllTextFieldsException.class, () -> supplierFormActions.isEditSupplierSuccessful(), "When the Contact Person text field is blank");

        supplierTable.setRowSelectionInterval(0,2);
        supplierNameTextField.setText("Updated Supplier 1");
        supplierAddressTextField.setText("Updated Address 1");
        supplierContactNumberTextField.setText("19273173101");
        supplierContactPersonTextField.setText("Updated Person 1");
        assertThrows(SelectJustOneRowException.class, () -> supplierFormActions.isEditSupplierSuccessful(), "When there are multiple rows selected");

        supplierTable.setRowSelectionInterval(0,0);
        supplierNameTextField.setText("Supplier 2");
        supplierAddressTextField.setText("Updated Address 1");
        supplierContactNumberTextField.setText("19273173101");
        supplierContactPersonTextField.setText("Updated Person 1");
        assertThrows(NameAlreadyExistsException.class, () -> supplierFormActions.isEditSupplierSuccessful(), "When the inputted name already exist");
    }

    @Test
    void deleting_supplier_when_successful(){
        supplierFormActions.generateTableContents();
        supplierTable.setRowSelectionInterval(0,0);
        assertDoesNotThrow(() -> supplierFormActions.isDeleteSupplierSuccessful(), "Deleting one Supplier");


        List<Supplier> suppliers = viewEditDeleteSupplierRepository.getAllSupplier();
        assertEquals(2, suppliers.size(), "Check if there are 2 Suppliers after deleting one");

        supplierFormActions.generateTableContents();
        supplierTable.setRowSelectionInterval(0,2);
        assertDoesNotThrow(() -> supplierFormActions.isDeleteSupplierSuccessful(), "Deleting two Supplier");

        List<Supplier> suppliers2 = viewEditDeleteSupplierRepository.getAllSupplier();
        assertEquals(0, suppliers2.size(), "Check if there are 0 Suppliers after deleting two");
    }

    @Test
    void deleting_supplier_when_not_successful(){
        supplierFormActions.generateTableContents();
        supplierTable.clearSelection();
        assertThrows(SelectOneOrMoreRowException.class, () -> supplierFormActions.isDeleteSupplierSuccessful(), "When there are no row selected");

        List<Supplier> suppliers = viewEditDeleteSupplierRepository.getAllSupplier();
        assertEquals(3, suppliers.size(), "Check if there are no suppliers that were deleted");
    }
}