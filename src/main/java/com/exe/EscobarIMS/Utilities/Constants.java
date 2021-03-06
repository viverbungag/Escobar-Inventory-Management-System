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
        String INTEGER_VALUES_ONLY_MESSAGE = "Please input integer values only";
        String INVALID_PHONE_NUMBER_MESSAGE = "Please input a valid phone number";
        String NUMERICAL_VALUES_ONLY_MESSAGE = "Please input numerical values only";
        String POSITIVE_VALUES_ONLY_MESSAGE = "Please input positive values only";
        String INVALID_MINIMUM_QUANTITY_NUMBER_MESSAGE = "Please input a valid minimum quantity";
        String SUPPLY_ALREADY_EXIST_MESSAGE = "This supply already exist, please input another name or choose another supplier";
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

        String SUPPLIER_ADDED_MESSAGE = "The Supplier Category was added";
        String SUPPLIER_DELETED_MESSAGE = "The Supplier Category was deleted";
        String SUPPLIER_UPDATED_MESSAGE = "The Supplier Category was updated";

        String SUPPLY_ADDED_MESSAGE = "The Supply was added";
        String SUPPLY_DELETED_MESSAGE = "The Supply was deleted";
        String SUPPLY_UPDATED_MESSAGE = "The Supply was updated";
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

        int SUPPLY_NAME_COLUMN_NUMBER = 0;
        int SUPPLY_CATEGORY_COLUMN_NUMBER = 1;
        int SUPPLY_SUPPLIER_COLUMN_NUMBER = 2;
        int SUPPLY_QUANTITY_COLUMN_NUMBER = 3;
        int SUPPLY_UNIT_OF_MEASUREMENT_COLUMN_NUMBER = 4;
        int SUPPLY_MINIMUM_QUANTITY_COLUMN_NUMBER = 5;
        int SUPPLY_IN_MINIMUM_QUANTITY_COLUMN_NUMBER = 6;
    }
}
