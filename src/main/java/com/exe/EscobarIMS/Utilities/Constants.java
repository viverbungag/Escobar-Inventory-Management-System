package com.exe.EscobarIMS.Utilities;

public interface Constants {

    interface ErrorTitles{
        String ERROR_TITLE = "Something is Wrong!";
    }

    interface ErrorMessages  {
        String NAME_ALREADY_EXISTS_MESSAGE = "The name you input already exists, Please try another one";
        String SELECT_ONE_OR_MORE_ROW_MESSAGE = "Please select one or more rows in the table";
        String SELECT_JUST_ONE_ROW_MESSAGE = "Please select just one row in the table";
        String FILL_OUT_ALL_TEXT_FIELD_MESSAGE = "Please fill out all text fields";
        String NUMERIC_VALUES_ONLY_MESSAGE = "Please input numeric values only";
        String INVALID_PHONE_NUMBER_MESSAGE = "Please input a valid phone number";
    }

    interface SuccessfulTitles{
        String SUCCESSFUL_TITLE = "Successful!";
    }

    interface SuccessMessages{

        String MENU_CATEGORY_ADDED_MESSAGE = "The Menu Category was added";
        String MENU_CATEGORY_DELETED_MESSAGE = "The Menu Category was deleted";
        String MENU_CATEGORY_UPDATED_MESSAGE = "The Menu Category was updated";

        String SUPPLY_CATEGORY_ADDED_MESSAGE = "The Supply Category was added";
        String SUPPLY_CATEGORY_DELETED_MESSAGE = "The Supply Category was deleted";
        String SUPPLY_CATEGORY_UPDATED_MESSAGE = "The Supply Category was updated";

        String UNIT_OF_MEASUREMENT_ADDED_MESSAGE = "The Unit of Measurement was added";
        String UNIT_OF_MEASUREMENT_DELETED_MESSAGE = "The Unit of Measurement was deleted";
        String UNIT_OF_MEASUREMENT_UPDATED_MESSAGE = "The Unit of Measurement was updated";

        String SUPPLIER_CATEGORY_ADDED_MESSAGE = "The Supplier Category was added";
        String SUPPLIER_CATEGORY_DELETED_MESSAGE = "The Supplier Category was deleted";
        String SUPPLIER_CATEGORY_UPDATED_MESSAGE = "The Supplier Category was updated";
    }

    interface TableColumnNumbers{
        int MENU_CATEGORY_NAME_COLUMN_NUMBER = 0;

        int SUPPLY_CATEGORY_NAME_COLUMN_NUMBER = 0;

        int UNIT_OF_MEASUREMENT_NAME_COLUMN_NUMBER = 0;
        int UNIT_OF_MEASUREMENT_ABBREVIATION_COLUMN_NUMBER = 1;

        int SUPPLIER_NAME_COLUMN_NUMBER = 0;
        int SUPPLIER_ADDRESS_COLUMN_NUMBER = 1;
        int SUPPLIER_CONTACT_NUMBER_COLUMN_NUMBER = 2;
        int SUPPLIER_CONTACT_PERSON_COLUMN_NUMBER = 3;
    }
}
