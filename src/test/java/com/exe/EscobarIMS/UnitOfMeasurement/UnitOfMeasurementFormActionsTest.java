package com.exe.EscobarIMS.UnitOfMeasurement;

import com.exe.EscobarIMS.UnitOfMeasurement.AddUnitOfMeasurement.AddUnitOfMeasurementRepository;
import com.exe.EscobarIMS.UnitOfMeasurement.ViewEditDeleteUnitOfMeasurement.ViewEditDeleteUnitOfMeasurementRepository;
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
class UnitOfMeasurementFormActionsTest {

    @Autowired
    UnitOfMeasurementRepository unitOfMeasurementRepository;
    @Autowired
    AddUnitOfMeasurementRepository addUnitOfMeasurementRepository;
    @Autowired
    ViewEditDeleteUnitOfMeasurementRepository viewEditDeleteUnitOfMeasurementRepository;
    @Autowired
    UnitOfMeasurementFormActions unitOfMeasurementFormActions;
    @Autowired
    MessageDialogues messageDialogues;

    private JRadioButton ascendingRadioButton;
    private JComboBox<String> contentLimitComboBox;
    private JTextField currentPageNumberTextField;
    private JRadioButton descendingRadioButton;
    private JTextField unitOfMeasurementNameTextField;
    private JTextField unitOfMeasurementAbbreviationTextField;
    private JTable unitOfMeasurementTable;
    private JComboBox<String> sortingMethodComboBox;


    public void initComponents() {
        unitOfMeasurementTable = new JTable();
        unitOfMeasurementNameTextField = new JTextField();
        unitOfMeasurementAbbreviationTextField = new JTextField();
        currentPageNumberTextField = new JTextField();
        sortingMethodComboBox = new JComboBox<>();
        ascendingRadioButton = new JRadioButton();
        descendingRadioButton = new JRadioButton();
        contentLimitComboBox = new JComboBox<>();

        unitOfMeasurementTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {},
                new String [] {
                        "Unit of Measurement Name", "Unit of Measurement Abbreviation"
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
        sortingMethodComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Unit of Measurement Name", "Unit of Measurement Abbreviation" }));
        contentLimitComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "5", "15", "30", "50", "100" }));
        setActionFormComponents();
    }

    private void setActionFormComponents(){
        unitOfMeasurementFormActions.setContentLimitComboBox(contentLimitComboBox);
        unitOfMeasurementFormActions.setCurrentPageNumberTextField(currentPageNumberTextField);
        unitOfMeasurementFormActions.setUnitOfMeasurementNameTextField(unitOfMeasurementNameTextField);
        unitOfMeasurementFormActions.setUnitOfMeasurementAbbreviationTextField(unitOfMeasurementAbbreviationTextField);
        unitOfMeasurementFormActions.setUnitOfMeasurementTable(unitOfMeasurementTable);
        unitOfMeasurementFormActions.setAscendingRadioButton(ascendingRadioButton);
        unitOfMeasurementFormActions.setDescendingRadioButton(descendingRadioButton);
        unitOfMeasurementFormActions.setSortingMethodComboBox(sortingMethodComboBox);
    }

    @BeforeAll
    public void beforeAllSetUp(){
        initComponents();
        setActionFormComponents();
        messageDialogues.setShouldShowMessageDialog(false);
    }


    @BeforeEach
    public void setUp(){
        viewEditDeleteUnitOfMeasurementRepository.deleteAll();
        UnitOfMeasurement unitOfMeasurement1 = new UnitOfMeasurement("Unit of Measurement 1", "UOM 1");
        UnitOfMeasurement unitOfMeasurement2 = new UnitOfMeasurement("Unit of Measurement 2", "UOM 2");
        UnitOfMeasurement unitOfMeasurement3 = new UnitOfMeasurement("Unit of Measurement 3", "UOM 3");
        addUnitOfMeasurementRepository.saveAll(List.of(unitOfMeasurement1, unitOfMeasurement2, unitOfMeasurement3));
    }

    @AfterEach
    void tearDown(){

    }

    @Test
    void injected_components_are_not_null(){
        assertNotNull(unitOfMeasurementRepository);
        assertNotNull(addUnitOfMeasurementRepository);
        assertNotNull(viewEditDeleteUnitOfMeasurementRepository);
        assertNotNull(unitOfMeasurementFormActions);
        assertNotNull(messageDialogues);
    }

    @Test
    void adding_unit_of_measurement_when_successful(){
        unitOfMeasurementNameTextField.setText("Unit of Measurement 4");
        unitOfMeasurementAbbreviationTextField.setText("UOM 4");
        assertDoesNotThrow(() -> unitOfMeasurementFormActions.validateIfAddingOfUnitOfMeasurementIsSuccessful());

        UnitOfMeasurement acquiredUnitOfMeasurement = unitOfMeasurementRepository.findByUnitOfMeasurementName("Unit of Measurement 4");
        assertNotNull(acquiredUnitOfMeasurement, "Check if the Unit of Measurement added is existing");

        List<UnitOfMeasurement> unitOfMeasurement = viewEditDeleteUnitOfMeasurementRepository.getAllUnitOfMeasurements();
        assertEquals(4, unitOfMeasurement.size(),"Check if the number of Unit of Measurement increased");
    }

    @Test
    void adding_menu_category_name_when_not_successful(){
        unitOfMeasurementNameTextField.setText("Unit of Measurement 1");
        unitOfMeasurementAbbreviationTextField.setText("UOM 1");
        assertThrows(NameAlreadyExistsException.class, () -> unitOfMeasurementFormActions.validateIfAddingOfUnitOfMeasurementIsSuccessful(), "When the name inputted is existing");

        unitOfMeasurementNameTextField.setText("");
        unitOfMeasurementAbbreviationTextField.setText("UOM 4");
        assertThrows(FillOutAllTextFieldsException.class, () -> unitOfMeasurementFormActions.validateIfAddingOfUnitOfMeasurementIsSuccessful(), "When the name text field is blank");

        unitOfMeasurementNameTextField.setText("Unit of Measurement 4");
        unitOfMeasurementAbbreviationTextField.setText("");
        assertThrows(FillOutAllTextFieldsException.class, () -> unitOfMeasurementFormActions.validateIfAddingOfUnitOfMeasurementIsSuccessful(), "When the abbreviation text field is blank");
    }

    @Test
    void editing_menu_category_name_when_successful(){
        unitOfMeasurementFormActions.updateTableContents();
        unitOfMeasurementTable.setRowSelectionInterval(0,0);
        unitOfMeasurementNameTextField.setText("Updated Unit of Measurement 1");
        unitOfMeasurementAbbreviationTextField.setText("Updated UOM 1");
        assertDoesNotThrow(() -> unitOfMeasurementFormActions.validateIfEditingOfUnitOfMeasurementIsSuccessful());

        UnitOfMeasurement acquiredUnitOfMeasurement = unitOfMeasurementRepository.findByUnitOfMeasurementName("Updated Unit of Measurement 1");
        List<UnitOfMeasurement> unitOfMeasurements = viewEditDeleteUnitOfMeasurementRepository.getAllUnitOfMeasurements();
        assertNotNull(acquiredUnitOfMeasurement, "Check if the editing of unit of measurement was successful");
        assertEquals(acquiredUnitOfMeasurement.getUnitOfMeasurementAbbreviation(), "Updated UOM 1", "Check if the abbreviation is updated");
        assertEquals(3, unitOfMeasurements.size(), "Check if there are still 3 unit of measurements");

        unitOfMeasurementFormActions.updateTableContents();
        unitOfMeasurementTable.setRowSelectionInterval(1,1);
        unitOfMeasurementNameTextField.setText("Unit of Measurement 2");
        unitOfMeasurementAbbreviationTextField.setText("Updated UOM 2");
        assertDoesNotThrow(() -> unitOfMeasurementFormActions.validateIfEditingOfUnitOfMeasurementIsSuccessful(), "Checks if it can update just the abbreviation");
        UnitOfMeasurement acquiredUnitOfMeasurement2 = unitOfMeasurementRepository.findByUnitOfMeasurementName("Unit of Measurement 2");
        assertEquals(acquiredUnitOfMeasurement2.getUnitOfMeasurementAbbreviation(), "Updated UOM 2", "Check if the abbreviation is updated");
    }

    @Test
    void editing_menu_category_name_when_not_successful(){
        unitOfMeasurementFormActions.updateTableContents();
        unitOfMeasurementTable.clearSelection();
        unitOfMeasurementNameTextField.setText("Updated Unit of Measurement 1");
        assertThrows(SelectJustOneRowException.class, () -> unitOfMeasurementFormActions.validateIfEditingOfUnitOfMeasurementIsSuccessful(), "When there are no rows selected");

        unitOfMeasurementNameTextField.setText("");
        unitOfMeasurementAbbreviationTextField.setText("Updated UOM 1");
        unitOfMeasurementTable.setRowSelectionInterval(0,0);
        assertThrows(FillOutAllTextFieldsException.class, () -> unitOfMeasurementFormActions.validateIfEditingOfUnitOfMeasurementIsSuccessful(), "When the name text field is blank");

        unitOfMeasurementNameTextField.setText("Updated Unit of Measurement 1");
        unitOfMeasurementAbbreviationTextField.setText("");
        unitOfMeasurementTable.setRowSelectionInterval(0,0);
        assertThrows(FillOutAllTextFieldsException.class, () -> unitOfMeasurementFormActions.validateIfEditingOfUnitOfMeasurementIsSuccessful(), "When the abbreviation text field is blank");

        unitOfMeasurementNameTextField.setText("Updated Unit of Measurement 1");
        unitOfMeasurementAbbreviationTextField.setText("Updated UOM 1");
        unitOfMeasurementTable.setRowSelectionInterval(0,2);
        assertThrows(SelectJustOneRowException.class, () -> unitOfMeasurementFormActions.validateIfEditingOfUnitOfMeasurementIsSuccessful(), "When there are multiple rows selected");

        unitOfMeasurementNameTextField.setText("Unit of Measurement 2");
        unitOfMeasurementAbbreviationTextField.setText("Updated UOM 1");
        unitOfMeasurementTable.setRowSelectionInterval(0,0);
        assertThrows(NameAlreadyExistsException.class, () -> unitOfMeasurementFormActions.validateIfEditingOfUnitOfMeasurementIsSuccessful(), "When the inputted name already exist");
    }

    @Test
    void deleting_menu_category_name_when_successful(){
        unitOfMeasurementFormActions.updateTableContents();
        unitOfMeasurementTable.setRowSelectionInterval(0,0);
        assertDoesNotThrow(() -> unitOfMeasurementFormActions.validateIfDeletingOfUnitOfMeasurementIsSuccessful(), "Deleting one Unit of Measurement");


        List<UnitOfMeasurement> unitOfMeasurements = viewEditDeleteUnitOfMeasurementRepository.getAllUnitOfMeasurements();
        assertEquals(2, unitOfMeasurements.size(), "Check if there are 2 Unit of Measurement after deleting one");

        unitOfMeasurementFormActions.updateTableContents();
        unitOfMeasurementTable.setRowSelectionInterval(0,1);
        assertDoesNotThrow(() -> unitOfMeasurementFormActions.validateIfDeletingOfUnitOfMeasurementIsSuccessful(), "Deleting two Unit of Measurement");

        List<UnitOfMeasurement> unitOfMeasurements2 = viewEditDeleteUnitOfMeasurementRepository.getAllUnitOfMeasurements();
        assertEquals(0, unitOfMeasurements2.size(), "Check if there are 0 Unit of Measurement after deleting two");
    }

    @Test
    void deleting_menu_category_name_when_not_successful(){
        unitOfMeasurementFormActions.updateTableContents();
        unitOfMeasurementTable.clearSelection();
        assertThrows(SelectOneOrMoreRowException.class, () -> unitOfMeasurementFormActions.validateIfDeletingOfUnitOfMeasurementIsSuccessful(), "When there are no row selected");

        List<UnitOfMeasurement> unitOfMeasurements = viewEditDeleteUnitOfMeasurementRepository.getAllUnitOfMeasurements();
        assertEquals(3, unitOfMeasurements.size(), "Check if there are no menu categories that were deleted");
    }
}