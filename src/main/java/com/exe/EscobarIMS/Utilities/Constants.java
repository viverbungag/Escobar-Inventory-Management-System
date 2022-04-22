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
    }

    interface SuccessfulTitles{
        String SUCCESSFUL_TITLE = "Successful!";
    }

    interface SuccessMessages{
        String MENU_CATEGORY_ADDED_MESSAGE = "The Menu Category was added";
        String MENU_CATEGORY_DELETED_MESSAGE = "The Menu Category was deleted";
        String MENU_CATEGORY_UPDATED_MESSAGE = "The Menu Category was updated";
    }

    interface TableColumnNumbers{
        int MENU_CATEGORY_NAME_COLUMN_NUMBER = 0;
    }
}
