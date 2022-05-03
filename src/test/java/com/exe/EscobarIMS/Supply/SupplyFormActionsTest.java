package com.exe.EscobarIMS.Supply;

import com.exe.EscobarIMS.Supplier.AddSupplier.AddSupplierRepository;
import com.exe.EscobarIMS.Supplier.Supplier;
import com.exe.EscobarIMS.Supply.AddSupply.AddSupplyRepository;
import com.exe.EscobarIMS.Supply.ViewEditDeleteSupply.ViewEditDeleteSupplyRepository;
import com.exe.EscobarIMS.SupplyCategory.AddSupplyCategory.AddSupplyCategoryRepository;
import com.exe.EscobarIMS.SupplyCategory.SupplyCategory;
import com.exe.EscobarIMS.UnitOfMeasurement.AddUnitOfMeasurement.AddUnitOfMeasurementRepository;
import com.exe.EscobarIMS.UnitOfMeasurement.UnitOfMeasurement;
import com.exe.EscobarIMS.Utilities.Exceptions.*;
import com.exe.EscobarIMS.Utilities.MessageDialogues;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = {"spring.main.lazy-initialization=true"})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SupplyFormActionsTest {

    @Autowired
    SupplyRepository supplyRepository;
    @Autowired
    AddSupplyRepository addSupplyRepository;
    @Autowired
    ViewEditDeleteSupplyRepository viewEditDeleteSupplyRepository;
    @Autowired
    SupplyFormActions supplyFormActions;
    @Autowired
    MessageDialogues messageDialogues;
    @Autowired
    AddUnitOfMeasurementRepository addUnitOfMeasurementRepository;
    @Autowired
    AddSupplierRepository addSupplierRepository;
    @Autowired
    AddSupplyCategoryRepository addSupplyCategoryRepository;

    private JRadioButton ascendingRadioButton;
    private JComboBox<String> contentLimitComboBox;
    private JTextField currentPageNumberTextField;
    private JRadioButton descendingRadioButton;
    private JComboBox<String> sortingMethodComboBox;
    private JTextField supplyNameTextField;
    private JTextField minimumQuantityTextField;
    private JComboBox<String> supplierNameComboBox;
    private JComboBox<String> unitOfMeasurementNameComboBox;
    private JComboBox<String> supplyCategoryNameComboBox;
    private JTable supplyTable;
    private Supplier supplier1;
    private Supplier supplier2;
    private Supplier supplier3;
    private Supplier supplier4;
    private SupplyCategory supplyCategory1;
    private SupplyCategory supplyCategory2;
    private SupplyCategory supplyCategory3;
    private SupplyCategory supplyCategory4;
    private UnitOfMeasurement unitOfMeasurement1;
    private UnitOfMeasurement unitOfMeasurement2;
    private UnitOfMeasurement unitOfMeasurement3;
    private UnitOfMeasurement unitOfMeasurement4;

    public void initComponents(){
        ascendingRadioButton = new JRadioButton();
        contentLimitComboBox = new JComboBox<>();
        currentPageNumberTextField = new JTextField();
        descendingRadioButton = new JRadioButton();
        supplyTable = new JTable();
        sortingMethodComboBox = new JComboBox<>();
        supplyNameTextField = new JTextField();
        minimumQuantityTextField = new JTextField();
        supplierNameComboBox = new JComboBox<>();
        unitOfMeasurementNameComboBox = new JComboBox<>();
        supplyCategoryNameComboBox = new JComboBox<>();

        supplyTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {
                        "Supply Name", "Supply Category", "Supplier", "Quantity", "Unit of Measurement", "Minimum Quantity", "Is below Minimum Quantity?"
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
        sortingMethodComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Supply Name", "Supply Category", "Supplier", "Quantity", "Unit of Measurement", "Minimum Quantity", "Is below Minimum Quantity?"}));
        contentLimitComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "5", "15", "30", "50", "100" }));
    }

    private void setActionFormComponents(){
        supplyFormActions.setAscendingRadioButton(ascendingRadioButton);
        supplyFormActions.setContentLimitComboBox(contentLimitComboBox);
        supplyFormActions.setCurrentPageNumberTextField(currentPageNumberTextField);
        supplyFormActions.setDescendingRadioButton(descendingRadioButton);
        supplyFormActions.setSupplyNameTextField(supplyNameTextField);
        supplyFormActions.setMinimumQuantityTextField(minimumQuantityTextField);
        supplyFormActions.setSupplierNameComboBox(supplierNameComboBox);
        supplyFormActions.setUnitOfMeasurementNameComboBox(unitOfMeasurementNameComboBox);
        supplyFormActions.setSupplyCategoryNameComboBox(supplyCategoryNameComboBox);
        supplyFormActions.setSupplyTable(supplyTable);
        supplyFormActions.setSortingMethodComboBox(sortingMethodComboBox);
    }

    @BeforeAll
    public void beforeAllSetUp(){
        initComponents();
        setActionFormComponents();
        messageDialogues.setShouldShowMessageDialog(false);

        addSupplyCategoryRepository.deleteAll();
        addUnitOfMeasurementRepository.deleteAll();
        addSupplierRepository.deleteAll();

        supplyCategory1 = new SupplyCategory("Supply Category 1");
        supplyCategory2 = new SupplyCategory("Supply Category 2");
        supplyCategory3 = new SupplyCategory("Supply Category 3");
        supplyCategory4 = new SupplyCategory("Supply Category 4");
        addSupplyCategoryRepository.saveAll(List.of(supplyCategory1, supplyCategory2, supplyCategory3, supplyCategory4));

        supplier1 = new Supplier(
                "Supplier 1",
                "Address 1",
                "09273173101",
                "Person 1");
        supplier2 = new Supplier(
                "Supplier 2",
                "Address 2",
                "09273173102",
                "Person 2");
        supplier3 = new Supplier(
                "Supplier 3",
                "Address 3",
                "09273173103",
                "Person 3");
        supplier4 = new Supplier(
                "Supplier 4",
                "Address 4",
                "09273173104",
                "Person 4");
        addSupplierRepository.saveAll(List.of(supplier1, supplier2, supplier3, supplier4));

        unitOfMeasurement1 = new UnitOfMeasurement("Unit of Measurement 1", "UOM 1");
        unitOfMeasurement2 = new UnitOfMeasurement("Unit of Measurement 2", "UOM 2");
        unitOfMeasurement3 = new UnitOfMeasurement("Unit of Measurement 3", "UOM 3");
        unitOfMeasurement4 = new UnitOfMeasurement("Unit of Measurement 4", "UOM 4");
        addUnitOfMeasurementRepository.saveAll(List.of(unitOfMeasurement1, unitOfMeasurement2, unitOfMeasurement3, unitOfMeasurement4));
    }

    @BeforeEach
    public void setUp(){
        viewEditDeleteSupplyRepository.deleteAll();

        Supply supply1 = new Supply(
                "Supply 1",
                11D,
                supplier1,
                unitOfMeasurement1,
                supplyCategory1);
        Supply supply2 = new Supply(
                "Supply 2",
                12D,
                supplier2,
                unitOfMeasurement2,
                supplyCategory2);
        Supply supply3 = new Supply(
                "Supply 3",
                13D,
                supplier3,
                unitOfMeasurement3,
                supplyCategory3);
        addSupplyRepository.saveAll(List.of(supply1, supply2, supply3));
    }

    @Test
    void injected_components_are_not_null(){
        assertNotNull(supplyRepository);
        assertNotNull(addSupplyRepository);
        assertNotNull(viewEditDeleteSupplyRepository);
        assertNotNull(supplyFormActions);
        assertNotNull(messageDialogues);
    }

    @Test
    void adding_supply_when_successful(){
        supplyFormActions.generateComboBoxContents();
        supplyNameTextField.setText("Supply 4");
        minimumQuantityTextField.setText("14");
        supplierNameComboBox.setSelectedItem("Supplier 4");
        unitOfMeasurementNameComboBox.setSelectedItem("Unit of Measurement 4");
        supplyCategoryNameComboBox.setSelectedItem("Supply Category 4");
        assertDoesNotThrow(() -> supplyFormActions.validateIfAddingOfSupplyIsSuccessful());

        Supply supply = supplyRepository.findBySupplyName("Supply 4");
        assertNotNull(supply, "Check if the supply added is existing");

        List<Supply> supplies = viewEditDeleteSupplyRepository.getAllSupply();
        assertEquals(4, supplies.size(), "Check if the number of supplies increased");
        assertEquals("Supplier 4", supplies.get(3).getSupplierName());
        assertEquals("Supply Category 4", supplies.get(3).getSupplyCategoryName());
        assertEquals("Unit of Measurement 4", supplies.get(3).getUnitOfMeasurementName());
    }

    @Test
    void adding_supply_when_not_successful(){
        supplyFormActions.generateComboBoxContents();
        supplyNameTextField.setText("");
        minimumQuantityTextField.setText("14");
        supplierNameComboBox.setSelectedItem("Supplier 4");
        unitOfMeasurementNameComboBox.setSelectedItem("Unit of Measurement 4");
        supplyCategoryNameComboBox.setSelectedItem("Supply Category 4");
        assertThrows(FillOutAllTextFieldsException.class, () -> supplyFormActions.validateIfAddingOfSupplyIsSuccessful());

        supplyNameTextField.setText("Supply 4");
        minimumQuantityTextField.setText("");
        supplierNameComboBox.setSelectedItem("Supplier 4");
        unitOfMeasurementNameComboBox.setSelectedItem("Unit of Measurement 4");
        supplyCategoryNameComboBox.setSelectedItem("Supply Category 4");
        assertThrows(FillOutAllTextFieldsException.class, () -> supplyFormActions.validateIfAddingOfSupplyIsSuccessful());

        supplyNameTextField.setText("Supply 4");
        minimumQuantityTextField.setText("one");
        supplierNameComboBox.setSelectedItem("Supplier 4");
        unitOfMeasurementNameComboBox.setSelectedItem("Unit of Measurement 4");
        supplyCategoryNameComboBox.setSelectedItem("Supply Category 4");
        assertThrows(InvalidMinimumQuantityException.class, () -> supplyFormActions.validateIfAddingOfSupplyIsSuccessful());

        supplyNameTextField.setText("Supply 4");
        minimumQuantityTextField.setText("-1");
        supplierNameComboBox.setSelectedItem("Supplier 4");
        unitOfMeasurementNameComboBox.setSelectedItem("Unit of Measurement 4");
        supplyCategoryNameComboBox.setSelectedItem("Supply Category 4");
        assertThrows(InvalidMinimumQuantityException.class, () -> supplyFormActions.validateIfAddingOfSupplyIsSuccessful());
    }

    @Test
    void editing_supply_when_successful(){
        supplyFormActions.generateComboBoxContents();
        supplyFormActions.updateTableContents();
        supplyTable.setRowSelectionInterval(0,0);
        supplyNameTextField.setText("Updated Supply 1");
        minimumQuantityTextField.setText("13");
        supplierNameComboBox.setSelectedItem("Supplier 2");
        unitOfMeasurementNameComboBox.setSelectedItem("Unit of Measurement 3");
        supplyCategoryNameComboBox.setSelectedItem("Supply Category 2");
        assertDoesNotThrow(() -> supplyFormActions.validateIfEditingOfSupplySuccessful());

        Supply supply = supplyRepository.findBySupplyName("Updated Supply 1");
        List<Supply> supplies = viewEditDeleteSupplyRepository.getAllSupply();
        assertNotNull(supplies, "Check if the editing of supplies was successful");
        assertEquals(13, supply.getMinimumQuantity());
        assertEquals("Supplier 2", supply.getSupplierName());
        assertEquals("Unit of Measurement 3", supply.getUnitOfMeasurementName());
        assertEquals("Supply Category 2", supply.getSupplyCategoryName());
    }

    @Test
    void editing_supply_when_not_successful(){
        supplyFormActions.generateComboBoxContents();
        supplyFormActions.updateTableContents();
        supplyTable.clearSelection();
        supplyNameTextField.setText("Updated Supply 1");
        minimumQuantityTextField.setText("13");
        supplierNameComboBox.setSelectedItem("Supplier 2");
        unitOfMeasurementNameComboBox.setSelectedItem("Unit of Measurement 3");
        supplyCategoryNameComboBox.setSelectedItem("Supply Category 2");
        assertThrows(SelectJustOneRowException.class, () -> supplyFormActions.validateIfEditingOfSupplySuccessful());

        supplyTable.setRowSelectionInterval(0,0);
        supplyNameTextField.setText("Updated Supply 1");
        minimumQuantityTextField.setText("Not a number");
        supplierNameComboBox.setSelectedItem("Supplier 2");
        unitOfMeasurementNameComboBox.setSelectedItem("Unit of Measurement 3");
        supplyCategoryNameComboBox.setSelectedItem("Supply Category 2");
        assertThrows(InvalidMinimumQuantityException.class, () -> supplyFormActions.validateIfEditingOfSupplySuccessful());

        supplyTable.setRowSelectionInterval(0,0);
        supplyNameTextField.setText("");
        minimumQuantityTextField.setText("Not a number");
        supplierNameComboBox.setSelectedItem("Supplier 2");
        unitOfMeasurementNameComboBox.setSelectedItem("Unit of Measurement 3");
        supplyCategoryNameComboBox.setSelectedItem("Supply Category 2");
        assertThrows(FillOutAllTextFieldsException.class, () -> supplyFormActions.validateIfEditingOfSupplySuccessful());

        supplyTable.setRowSelectionInterval(0,0);
        supplyNameTextField.setText("Updated Supply 1");
        minimumQuantityTextField.setText("");
        supplierNameComboBox.setSelectedItem("Supplier 2");
        unitOfMeasurementNameComboBox.setSelectedItem("Unit of Measurement 3");
        supplyCategoryNameComboBox.setSelectedItem("Supply Category 2");
        assertThrows(FillOutAllTextFieldsException.class, () -> supplyFormActions.validateIfEditingOfSupplySuccessful());
    }

    @Test
    void deleting_supply_when_successful(){
        supplyFormActions.updateTableContents();
        supplyTable.setRowSelectionInterval(0,0);
        assertDoesNotThrow(() -> supplyFormActions.validateIfDeletingOfSupplySuccessful(), "Deleting one supplier");

        List<Supply> supplies = viewEditDeleteSupplyRepository.getAllSupply();
        assertEquals(2, supplies.size(), "Check if there are 2 supplies after deleting one");

        supplyFormActions.updateTableContents();
        supplyTable.setRowSelectionInterval(0,1);
        assertDoesNotThrow(() -> supplyFormActions.validateIfDeletingOfSupplySuccessful(), "Deleting two supplies");

        List<Supply> supplies2 = viewEditDeleteSupplyRepository.getAllSupply();
        assertEquals(0, supplies2.size(), "Check if there are 0 supplies after deleting two");
    }
}
