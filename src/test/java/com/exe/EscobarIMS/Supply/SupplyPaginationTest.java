package com.exe.EscobarIMS.Supply;

import com.exe.EscobarIMS.Supplier.AddSupplier.AddSupplierRepository;
import com.exe.EscobarIMS.Supplier.Supplier;
import com.exe.EscobarIMS.Supply.AddSupply.AddSupplyRepository;
import com.exe.EscobarIMS.Supply.ViewEditDeleteSupply.ViewEditDeleteSupplyRepository;
import com.exe.EscobarIMS.SupplyCategory.AddSupplyCategory.AddSupplyCategoryRepository;
import com.exe.EscobarIMS.SupplyCategory.SupplyCategory;
import com.exe.EscobarIMS.UnitOfMeasurement.AddUnitOfMeasurement.AddUnitOfMeasurementRepository;
import com.exe.EscobarIMS.UnitOfMeasurement.UnitOfMeasurement;
import com.exe.EscobarIMS.Utilities.Exceptions.IntegerValuesOnlyException;
import com.exe.EscobarIMS.Utilities.MessageDialogues;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.*;
import java.util.List;

import static com.exe.EscobarIMS.Utilities.Constants.TableColumnNumbers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(properties = {"spring.main.lazy-initialization=true"})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SupplyPaginationTest {

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
    private JComboBox<String> supplierComboBox;
    private JComboBox<String> unitOfMeasurementComboBox;
    private JComboBox<String> supplyCategoryComboBox;
    public JButton previousButton;
    public JButton nextButton;
    private JTable supplyTable;
    private Supplier supplier1;
    private Supplier supplier2;
    private Supplier supplier3;
    private Supplier supplier4;
    private Supplier supplier5;
    private Supplier supplier6;
    private Supplier supplier7;
    private Supplier supplier8;
    private Supplier supplier9;
    private Supplier supplier10;
    private Supplier supplier11;
    private Supplier supplier12;
    private Supplier supplier13;
    private Supplier supplier14;
    private Supplier supplier15;
    private Supplier supplier16;
    private SupplyCategory supplyCategory1;
    private SupplyCategory supplyCategory2;
    private SupplyCategory supplyCategory3;
    private SupplyCategory supplyCategory4;
    private SupplyCategory supplyCategory5;
    private SupplyCategory supplyCategory6;
    private SupplyCategory supplyCategory7;
    private SupplyCategory supplyCategory8;
    private SupplyCategory supplyCategory9;
    private SupplyCategory supplyCategory10;
    private SupplyCategory supplyCategory11;
    private SupplyCategory supplyCategory12;
    private SupplyCategory supplyCategory13;
    private SupplyCategory supplyCategory14;
    private SupplyCategory supplyCategory15;
    private SupplyCategory supplyCategory16;
    private UnitOfMeasurement unitOfMeasurement1;
    private UnitOfMeasurement unitOfMeasurement2;
    private UnitOfMeasurement unitOfMeasurement3;
    private UnitOfMeasurement unitOfMeasurement4;
    private UnitOfMeasurement unitOfMeasurement5;
    private UnitOfMeasurement unitOfMeasurement6;
    private UnitOfMeasurement unitOfMeasurement7;
    private UnitOfMeasurement unitOfMeasurement8;
    private UnitOfMeasurement unitOfMeasurement9;
    private UnitOfMeasurement unitOfMeasurement10;
    private UnitOfMeasurement unitOfMeasurement11;
    private UnitOfMeasurement unitOfMeasurement12;
    private UnitOfMeasurement unitOfMeasurement13;
    private UnitOfMeasurement unitOfMeasurement14;
    private UnitOfMeasurement unitOfMeasurement15;
    private UnitOfMeasurement unitOfMeasurement16;

    public void initComponents(){
        ascendingRadioButton = new JRadioButton();
        contentLimitComboBox = new JComboBox<>();
        currentPageNumberTextField = new JTextField();
        descendingRadioButton = new JRadioButton();
        supplyTable = new JTable();
        sortingMethodComboBox = new JComboBox<>();
        supplyNameTextField = new JTextField();
        minimumQuantityTextField = new JTextField();
        supplierComboBox = new JComboBox<>();
        unitOfMeasurementComboBox = new JComboBox<>();
        supplyCategoryComboBox = new JComboBox<>();
        previousButton = new JButton();
        nextButton = new JButton();

        supplyTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {
                        "Supply Name", "Supply Category", "Supplier", "Quantity", "Unit of Measurement", "Minimum Quantity", "Below Minimum"
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
        sortingMethodComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Supply Name", "Supply Category", "Supplier", "Quantity", "Unit of Measurement", "Minimum Quantity", "Below Minimum"}));
        contentLimitComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "5", "15", "30", "50", "100" }));
    }

    private void setActionFormComponents(){
        supplyFormActions.setAscendingRadioButton(ascendingRadioButton);
        supplyFormActions.setContentLimitComboBox(contentLimitComboBox);
        supplyFormActions.setCurrentPageNumberTextField(currentPageNumberTextField);
        supplyFormActions.setDescendingRadioButton(descendingRadioButton);
        supplyFormActions.setSupplyNameTextField(supplyNameTextField);
        supplyFormActions.setMinimumQuantityTextField(minimumQuantityTextField);
        supplyFormActions.setSupplierComboBox(supplierComboBox);
        supplyFormActions.setUnitOfMeasurementComboBox(unitOfMeasurementComboBox);
        supplyFormActions.setSupplyCategoryComboBox(supplyCategoryComboBox);
        supplyFormActions.setSupplyTable(supplyTable);
        supplyFormActions.setSortingMethodComboBox(sortingMethodComboBox);
        supplyFormActions.setPreviousButton(previousButton);
        supplyFormActions.setNextButton(nextButton);
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
        supplyCategory5 = new SupplyCategory("Supply Category 5");
        supplyCategory6 = new SupplyCategory("Supply Category 6");
        supplyCategory7 = new SupplyCategory("Supply Category 7");
        supplyCategory8 = new SupplyCategory("Supply Category 8");
        supplyCategory9 = new SupplyCategory("Supply Category 9");
        supplyCategory10 = new SupplyCategory("Supply Category 10");
        supplyCategory11 = new SupplyCategory("Supply Category 11");
        supplyCategory12 = new SupplyCategory("Supply Category 12");
        supplyCategory13 = new SupplyCategory("Supply Category 13");
        supplyCategory14 = new SupplyCategory("Supply Category 14");
        supplyCategory15 = new SupplyCategory("Supply Category 15");
        supplyCategory16 = new SupplyCategory("Supply Category 16");
        addSupplyCategoryRepository.saveAll(List.of(
                supplyCategory1, supplyCategory2, supplyCategory3, supplyCategory4,
                supplyCategory5, supplyCategory6, supplyCategory7, supplyCategory8,
                supplyCategory9, supplyCategory10, supplyCategory11, supplyCategory12,
                supplyCategory13, supplyCategory14, supplyCategory15, supplyCategory16));

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
        supplier5 = new Supplier(
                "Supplier 5",
                "Address 5",
                "09273173105",
                "Person 5");
        supplier6 = new Supplier(
                "Supplier 6",
                "Address 6",
                "09273173106",
                "Person 6");
        supplier7 = new Supplier(
                "Supplier 7",
                "Address 7",
                "09273173107",
                "Person 7");
        supplier8 = new Supplier(
                "Supplier 8",
                "Address 8",
                "09273173108",
                "Person 8");
        supplier9 = new Supplier(
                "Supplier 9",
                "Address 9",
                "09273173109",
                "Person 9");
        supplier10 = new Supplier(
                "Supplier 10",
                "Address 10",
                "09273173110",
                "Person 10");
        supplier11 = new Supplier(
                "Supplier 11",
                "Address 11",
                "09273173111",
                "Person 1");
        supplier12 = new Supplier(
                "Supplier 12",
                "Address 12",
                "09273173112",
                "Person 12");
        supplier13 = new Supplier(
                "Supplier 13",
                "Address 13",
                "09273173113",
                "Person 13");
        supplier14 = new Supplier(
                "Supplier 14",
                "Address 14",
                "09273173114",
                "Person 14");
        supplier15 = new Supplier(
                "Supplier 15",
                "Address 15",
                "09273173115",
                "Person 15");
        supplier16 = new Supplier(
                "Supplier 16",
                "Address 16",
                "09273173116",
                "Person 16");

        addSupplierRepository.saveAll(List.of(
                supplier1, supplier2, supplier3, supplier4,
                supplier5,supplier6,supplier7,supplier8,
                supplier9,supplier10,supplier11,supplier12,
                supplier13,supplier14,supplier15,supplier16));

        unitOfMeasurement1 = new UnitOfMeasurement("Unit of Measurement 1", "UOM 1");
        unitOfMeasurement2 = new UnitOfMeasurement("Unit of Measurement 2", "UOM 2");
        unitOfMeasurement3 = new UnitOfMeasurement("Unit of Measurement 3", "UOM 3");
        unitOfMeasurement4 = new UnitOfMeasurement("Unit of Measurement 4", "UOM 4");
        unitOfMeasurement5 = new UnitOfMeasurement("Unit of Measurement 5", "UOM 5");
        unitOfMeasurement6 = new UnitOfMeasurement("Unit of Measurement 6", "UOM 6");
        unitOfMeasurement7 = new UnitOfMeasurement("Unit of Measurement 7", "UOM 7");
        unitOfMeasurement8 = new UnitOfMeasurement("Unit of Measurement 8", "UOM 8");
        unitOfMeasurement9 = new UnitOfMeasurement("Unit of Measurement 9", "UOM 9");
        unitOfMeasurement10 = new UnitOfMeasurement("Unit of Measurement 10", "UOM 10");
        unitOfMeasurement11 = new UnitOfMeasurement("Unit of Measurement 11", "UOM 11");
        unitOfMeasurement12 = new UnitOfMeasurement("Unit of Measurement 12", "UOM 12");
        unitOfMeasurement13 = new UnitOfMeasurement("Unit of Measurement 13", "UOM 13");
        unitOfMeasurement14 = new UnitOfMeasurement("Unit of Measurement 14", "UOM 14");
        unitOfMeasurement15 = new UnitOfMeasurement("Unit of Measurement 15", "UOM 15");
        unitOfMeasurement16 = new UnitOfMeasurement("Unit of Measurement 16", "UOM 16");
        addUnitOfMeasurementRepository.saveAll(List.of(
                unitOfMeasurement1, unitOfMeasurement2, unitOfMeasurement3, unitOfMeasurement4,
                unitOfMeasurement5,unitOfMeasurement6,unitOfMeasurement7,unitOfMeasurement8,
                unitOfMeasurement9,unitOfMeasurement10,unitOfMeasurement11,unitOfMeasurement12,
                unitOfMeasurement13,unitOfMeasurement14,unitOfMeasurement15,unitOfMeasurement16));
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
        Supply supply4 = new Supply(
                "Supply 4",
                14D,
                supplier4,
                unitOfMeasurement4,
                supplyCategory4);
        Supply supply5 = new Supply(
                "Supply 5",
                15D,
                supplier5,
                unitOfMeasurement5,
                supplyCategory5);
        Supply supply6 = new Supply(
                "Supply 6",
                16D,
                supplier6,
                unitOfMeasurement6,
                supplyCategory6);
        Supply supply7 = new Supply(
                "Supply 7",
                17D,
                supplier7,
                unitOfMeasurement7,
                supplyCategory7);
        Supply supply8 = new Supply(
                "Supply 8",
                18D,
                supplier8,
                unitOfMeasurement8,
                supplyCategory8);
        Supply supply9 = new Supply(
                "Supply 9",
                19D,
                supplier9,
                unitOfMeasurement9,
                supplyCategory9);
        Supply supply10 = new Supply(
                "Supply 10",
                20D,
                supplier10,
                unitOfMeasurement10,
                supplyCategory10);
        Supply supply11 = new Supply(
                "Supply 11",
                21D,
                supplier11,
                unitOfMeasurement11,
                supplyCategory11);
        Supply supply12 = new Supply(
                "Supply 12",
                22D,
                supplier12,
                unitOfMeasurement12,
                supplyCategory12);
        Supply supply13 = new Supply(
                "Supply 13",
                23D,
                supplier13,
                unitOfMeasurement13,
                supplyCategory13);
        Supply supply14 = new Supply(
                "Supply 14",
                24D,
                supplier14,
                unitOfMeasurement14,
                supplyCategory14);
        Supply supply15 = new Supply(
                "Supply 15",
                25D,
                supplier15,
                unitOfMeasurement15,
                supplyCategory15);
        Supply supply16 = new Supply(
                "Supply 16",
                26D,
                supplier16,
                unitOfMeasurement16,
                supplyCategory16);
        addSupplyRepository.saveAll(List.of(
                supply1, supply2, supply3, supply4,
                supply5, supply6, supply7, supply8,
                supply9, supply10, supply11, supply12,
                supply13, supply14, supply15, supply16));

        descendingRadioButton.setSelected(false);
        ascendingRadioButton.setSelected(false);
        sortingMethodComboBox.setSelectedItem("None");
        currentPageNumberTextField.setText("1");
        contentLimitComboBox.setSelectedItem("5");
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
    void previousButtonActionPerformed_when_pressing_previous_button(){
        currentPageNumberTextField.setText("2");
        supplyFormActions.previousButtonActionPerformed();
        assertEquals("1", currentPageNumberTextField.getText(), "Check if the current page number text field decreased");
        assertEquals("Supply 1", supplyTable.getValueAt(0,0), "Check if the first row is correct");
        assertFalse(previousButton.isEnabled(), "Check if the button is disabled");
    }

    @Test
    void nextButtonActionPerformed_when_pressing_next_button(){
        currentPageNumberTextField.setText("3");
        supplyFormActions.nextButtonActionPerformed();
        assertEquals("4", currentPageNumberTextField.getText(), "Check if the current page number text field increased");
        assertEquals("Supply 16", supplyTable.getValueAt(0,0), "Check if the first row is correct");
        assertFalse(nextButton.isEnabled(), "Check if the button is disabled");
    }

    @Test
    void currentPageNumberTextFieldFocusLost(){
        currentPageNumberTextField.setText("one");
        assertThrows(IntegerValuesOnlyException.class, () -> supplyFormActions.validateCurrentPageNumberTextFieldFocusLost());

        currentPageNumberTextField.setText("-1");
        assertDoesNotThrow(() -> supplyFormActions.validateCurrentPageNumberTextFieldFocusLost());
        assertEquals("1", currentPageNumberTextField.getText());

        currentPageNumberTextField.setText("5");
        assertDoesNotThrow(() -> supplyFormActions.validateCurrentPageNumberTextFieldFocusLost());
        assertEquals("4", currentPageNumberTextField.getText());
    }

    @Test
    void contentLimitComboBoxActionPerformed_when_data_are_not_sorted(){
        currentPageNumberTextField.setText("5");
        supplyFormActions.contentLimitComboBoxActionPerformed();
        assertEquals("1", currentPageNumberTextField.getText(), "Check if the current page number text field would reset to 1 if it is more than the last page");
        assertEquals("Supply 1", supplyTable.getValueAt(0,SUPPLY_NAME_COLUMN_NUMBER), "Check if the first row is correct");
    }

    @Test
    void sortingMethodComboBoxActionPerformed_when_the_limit_is_15_and_page_is_1(){
        currentPageNumberTextField.setText("1");
        contentLimitComboBox.setSelectedItem("15");
        supplyFormActions.sortingMethodComboBoxActionPerformed();
        assertEquals(15, supplyTable.getRowCount());
    }

    @Test
    void sortingMethodComboBoxActionPerformed_when_the_limit_is_15_and_page_is_2(){
        currentPageNumberTextField.setText("2");
        contentLimitComboBox.setSelectedItem("15");
        supplyFormActions.sortingMethodComboBoxActionPerformed();
        assertEquals(1, supplyTable.getRowCount());
    }

    @Test
    void ascendingRadioButtonItemStateChanged_clicking_the_ascending_button_and_sorted_by_name(){
        ascendingRadioButton.setSelected(true);
        descendingRadioButton.setSelected(false);

        sortingMethodComboBox.setSelectedItem("Supply Name");
        supplyFormActions.ascendingRadioButtonItemStateChanged();
        assertEquals("Supply 1", supplyTable.getValueAt(0,SUPPLY_NAME_COLUMN_NUMBER), "Check if the first row is correct");
    }

    @Test
    void ascendingRadioButtonItemStateChanged_clicking_the_descending_button_and_sorted_by_name(){
        ascendingRadioButton.setSelected(false);
        descendingRadioButton.setSelected(true);

        sortingMethodComboBox.setSelectedItem("Supply Name");
        supplyFormActions.ascendingRadioButtonItemStateChanged();
        assertEquals("Supply 9", supplyTable.getValueAt(0,SUPPLY_NAME_COLUMN_NUMBER), "Check if the first row is correct");
    }

    @Test
    void ascendingRadioButtonItemStateChanged_clicking_the_ascending_button_and_sorted_by_category(){
        ascendingRadioButton.setSelected(true);
        descendingRadioButton.setSelected(false);

        sortingMethodComboBox.setSelectedItem("Supply Category");
        supplyFormActions.ascendingRadioButtonItemStateChanged();
        assertEquals("Supply Category 1", supplyTable.getValueAt(0,SUPPLY_CATEGORY_COLUMN_NUMBER), "Check if the first row is correct");
    }

    @Test
    void ascendingRadioButtonItemStateChanged_clicking_the_descending_button_and_sorted_by_category(){
        ascendingRadioButton.setSelected(false);
        descendingRadioButton.setSelected(true);

        sortingMethodComboBox.setSelectedItem("Supply Category");
        supplyFormActions.ascendingRadioButtonItemStateChanged();
        assertEquals("Supply Category 9", supplyTable.getValueAt(0,SUPPLY_CATEGORY_COLUMN_NUMBER), "Check if the first row is correct");
    }

    @Test
    void ascendingRadioButtonItemStateChanged_clicking_the_ascending_button_and_sorted_by_supplier(){
        ascendingRadioButton.setSelected(true);
        descendingRadioButton.setSelected(false);

        sortingMethodComboBox.setSelectedItem("Supplier");
        supplyFormActions.ascendingRadioButtonItemStateChanged();
        assertEquals("Supplier 1", supplyTable.getValueAt(0,SUPPLY_SUPPLIER_COLUMN_NUMBER), "Check if the first row is correct");
    }

    @Test
    void ascendingRadioButtonItemStateChanged_clicking_the_descending_button_and_sorted_by_supplier(){
        ascendingRadioButton.setSelected(false);
        descendingRadioButton.setSelected(true);

        sortingMethodComboBox.setSelectedItem("Supplier");
        supplyFormActions.ascendingRadioButtonItemStateChanged();
        assertEquals("Supplier 9", supplyTable.getValueAt(0,SUPPLY_SUPPLIER_COLUMN_NUMBER), "Check if the first row is correct");
    }

    @Test
    void ascendingRadioButtonItemStateChanged_clicking_the_ascending_button_and_sorted_by_quantity(){
        ascendingRadioButton.setSelected(true);
        descendingRadioButton.setSelected(false);

        sortingMethodComboBox.setSelectedItem("Quantity");
        supplyFormActions.ascendingRadioButtonItemStateChanged();
        assertEquals("0.0", supplyTable.getValueAt(0,SUPPLY_QUANTITY_COLUMN_NUMBER), "Check if the first row is correct");
    }

    @Test
    void ascendingRadioButtonItemStateChanged_clicking_the_descending_button_and_sorted_by_quantity(){
        ascendingRadioButton.setSelected(false);
        descendingRadioButton.setSelected(true);

        sortingMethodComboBox.setSelectedItem("Quantity");
        supplyFormActions.ascendingRadioButtonItemStateChanged();
        assertEquals("0.0", supplyTable.getValueAt(0,SUPPLY_QUANTITY_COLUMN_NUMBER), "Check if the first row is correct");
    }

    @Test
    void ascendingRadioButtonItemStateChanged_clicking_the_ascending_button_and_sorted_by_unit_of_measurement(){
        ascendingRadioButton.setSelected(true);
        descendingRadioButton.setSelected(false);

        sortingMethodComboBox.setSelectedItem("Unit of Measurement");
        supplyFormActions.ascendingRadioButtonItemStateChanged();
        assertEquals("Unit of Measurement 1", supplyTable.getValueAt(0,SUPPLY_UNIT_OF_MEASUREMENT_COLUMN_NUMBER), "Check if the first row is correct");
    }

    @Test
    void ascendingRadioButtonItemStateChanged_clicking_the_descending_button_and_sorted_by_unit_of_measurement(){
        ascendingRadioButton.setSelected(false);
        descendingRadioButton.setSelected(true);

        sortingMethodComboBox.setSelectedItem("Unit of Measurement");
        supplyFormActions.ascendingRadioButtonItemStateChanged();
        assertEquals("Unit of Measurement 9", supplyTable.getValueAt(0,SUPPLY_UNIT_OF_MEASUREMENT_COLUMN_NUMBER), "Check if the first row is correct");
    }

    @Test
    void ascendingRadioButtonItemStateChanged_clicking_the_ascending_button_and_sorted_by_minimum_quantity(){
        ascendingRadioButton.setSelected(true);
        descendingRadioButton.setSelected(false);

        sortingMethodComboBox.setSelectedItem("Minimum Quantity");
        supplyFormActions.ascendingRadioButtonItemStateChanged();
        assertEquals("11.0", supplyTable.getValueAt(0,SUPPLY_MINIMUM_QUANTITY_COLUMN_NUMBER), "Check if the first row is correct");
    }

    @Test
    void ascendingRadioButtonItemStateChanged_clicking_the_descending_button_and_sorted_by_minimum_quantity(){
        ascendingRadioButton.setSelected(false);
        descendingRadioButton.setSelected(true);

        sortingMethodComboBox.setSelectedItem("Minimum Quantity");
        supplyFormActions.ascendingRadioButtonItemStateChanged();
        assertEquals("26.0", supplyTable.getValueAt(0,SUPPLY_MINIMUM_QUANTITY_COLUMN_NUMBER), "Check if the first row is correct");
    }

    @Test
    void ascendingRadioButtonItemStateChanged_clicking_the_ascending_button_and_sorted_by_in_minimum_quantity(){
        ascendingRadioButton.setSelected(true);
        descendingRadioButton.setSelected(false);

        sortingMethodComboBox.setSelectedItem("Below Minimum");
        supplyFormActions.ascendingRadioButtonItemStateChanged();
        assertEquals("false", supplyTable.getValueAt(0,SUPPLY_IN_MINIMUM_QUANTITY_COLUMN_NUMBER), "Check if the first row is correct");
    }

    @Test
    void ascendingRadioButtonItemStateChanged_clicking_the_descending_button_and_sorted_by_in_minimum_quantity(){
        ascendingRadioButton.setSelected(false);
        descendingRadioButton.setSelected(true);

        sortingMethodComboBox.setSelectedItem("Below Minimum");
        supplyFormActions.ascendingRadioButtonItemStateChanged();
        assertEquals("false", supplyTable.getValueAt(0,SUPPLY_IN_MINIMUM_QUANTITY_COLUMN_NUMBER), "Check if the first row is correct");
    }


}
