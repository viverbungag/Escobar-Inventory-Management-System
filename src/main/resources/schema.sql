DROP TABLE IF EXISTS monthly_report CASCADE;
DROP TABLE IF EXISTS monthly_sales CASCADE;
DROP TABLE IF EXISTS daily_sales CASCADE;
DROP TABLE IF EXISTS monthly_expenses CASCADE;
DROP TABLE IF EXISTS monthly_income_expenses CASCADE;
DROP TABLE iF EXISTS monthly_transactions CASCADE;
DROP TABLE IF EXISTS monthly_utility CASCADE;
DROP TABLE IF EXISTS utility CASCADE;
DROP TABLE IF EXISTS serving CASCADE;
DROP TABLE IF EXISTS food_order CASCADE;
DROP TABLE IF EXISTS customer CASCADE;
DROP TABLE IF EXISTS menu CASCADE;
DROP TABLE IF EXISTS transactions CASCADE;
DROP TABLE IF EXISTS supply CASCADE;
DROP TABLE IF EXISTS supplier CASCADE;
DROP TABLE IF EXISTS supply_category CASCADE;
DROP TABLE IF EXISTS unit_of_measurement CASCADE;
DROP TABLE IF EXISTS menu_category CASCADE;
DROP TABLE IF EXISTS account CASCADE;
DROP TABLE IF EXISTS accessible_systems CASCADE;
DROP TABLE IF EXISTS employee CASCADE;
DROP TABLE IF EXISTS employee_income_per_month CASCADE;
DROP TABLE IF EXISTS employee_attendance CASCADE;
DROP TABLE IF EXISTS employee_position CASCADE;


CREATE TABLE IF NOT EXISTS employee_position(
    position_id BIGINT NOT NULL AUTO_INCREMENT,
    position_name VARCHAR(255) NOT NULL,
    PRIMARY KEY (position_id)
);

CREATE TABLE IF NOT EXISTS employee_attendance(
    attendance_id BIGINT NOT NULL AUTO_INCREMENT,
    check_in DATETIME,
    check_out DATETIME,
    PRIMARY KEY (attendance_id)
);

CREATE TABLE IF NOT EXISTS employee_income_per_month(
    income_id BIGINT NOT NULL AUTO_INCREMENT,
    payPerHour DECIMAL(10, 2),
    total_hours_worked DECIMAL (4, 2),
    overtimePayPerHour DECIMAL (10,2),
    total_overtime_hours_worked DECIMAL (4,2),
    gross_pay DECIMAL (10,2),
    PRIMARY KEY (income_id)
);

CREATE TABLE IF NOT EXISTS employee(
    employee_id BIGINT NOT NULL AUTO_INCREMENT,
    employee_first_name VARCHAR(255) NOT NULL,
    employee_last_name VARCHAR(255) NOT NULL,
    employee_address VARCHAR(255),
    employee_contact_number INTEGER,
    date_employed DATE,
    monthly_wage DECIMAL(10, 2),
    attendance_per_month_id BIGINT,
    income_id BIGINT,
    position_id BIGINT,
    supperior_employee_id BIGINT,
    PRIMARY KEY (employee_id),
    FOREIGN KEY (attendance_per_month_id) REFERENCES employee_attendance(attendance_id),
    FOREIGN KEY (income_id) REFERENCES employee_income_per_month(income_id),
    FOREIGN KEY (position_id) REFERENCES employee_position(position_id),
    CONSTRAINT emp_supperior FOREIGN KEY (supperior_employee_id) REFERENCES employee(employee_id)
);

CREATE TABLE IF NOT EXISTS accessible_systems(
    accessible_systems_id BIGINT NOT NULL AUTO_INCREMENT,
    access_inventory_management_system BOOLEAN DEFAULT false,
    access_employee_management_system BOOLEAN DEFAULT false,
    access_income_and_expense_system BOOLEAN DEFAULT false,
    access_ordering_system BOOLEAN DEFAULT false,
    access_payroll_system BOOLEAN DEFAULT false,
    PRIMARY KEY (accessible_systems_id)
);

CREATE TABLE IF NOT EXISTS account(
    account_id BIGINT NOT NULL AUTO_INCREMENT,
    account_username VARCHAR(255) NOT NULL,
    account_password VARCHAR(255) NOT NULL,
    accessible_systems_id BIGINT,
    employee_id BIGINT,
    PRIMARY KEY (account_id),
    FOREIGN KEY (accessible_systems_id) REFERENCES accessible_systems(accessible_systems_id),
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);

CREATE TABLE IF NOT EXISTS menu_category(
    menu_category_id BIGINT NOT NULL AUTO_INCREMENT,
    menu_category_name VARCHAR(255) NOT NULL,
    PRIMARY KEY (menu_category_id)
);

CREATE TABLE IF NOT EXISTS unit_of_measurement(
    unit_of_measurement_id BIGINT NOT NULL AUTO_INCREMENT,
    unit_of_measurement_name VARCHAR(255) NOT NULL,
    unit_of_measurement_abbreviation VARCHAR(255) NOT NULL,
    PRIMARY KEY (unit_of_measurement_id)
);

CREATE TABLE IF NOT EXISTS supply_category(
    supply_category_id BIGINT AUTO_INCREMENT,
    supply_category_name VARCHAR(255) NOT NULL,
    PRIMARY KEY (supply_category_id)
);

CREATE TABLE IF NOT EXISTS supplier(
    supplier_id BIGINT NOT NULL AUTO_INCREMENT,
    supplier_name VARCHAR(255),
    supplier_address VARCHAR(255),
    supplier_contact_number VARCHAR(255),
    supplier_contact_person VARCHAR(255),
    PRIMARY KEY (supplier_id)
);

CREATE TABLE IF NOT EXISTS supply(
    supply_id BIGINT NOT NULL AUTO_INCREMENT,
    supply_name VARCHAR(255) NOT NULL,
    supply_quantity DECIMAL(10, 2) NOT NULL,
    supplier_id BIGINT,
    unit_of_measurement_id BIGINT,
    supply_category_id BIGINT,
    minimum_quantity DECIMAL(10, 2),
    in_minimum_quantity BOOLEAN,
    PRIMARY KEY (supply_id),
    FOREIGN KEY (supplier_id) REFERENCES supplier(supplier_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (unit_of_measurement_id) REFERENCES unit_of_measurement(unit_of_measurement_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (supply_category_id) REFERENCES supply_category(supply_category_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS transactions(
    transaction_id BIGINT NOT NULL AUTO_INCREMENT,
    transact_by BIGINT,
    transaction_date DATETIME,
    supplier_id BIGINT,
    transaction_supply_quantity DECIMAL(10, 5),
    supply_id BIGINT,
    supply_per_unit_cost DECIMAL(10, 2),
    expiry_date DATETIME,
    PRIMARY KEY (transaction_id)
--    FOREIGN KEY (supply_id) REFERENCES supply(supply_id) ON DELETE CASCADE ON UPDATE CASCADE,
--    FOREIGN KEY (supplier_id) REFERENCES supplier(supplier_id) ON DELETE CASCADE ON UPDATE CASCADE,
--    FOREIGN KEY (transact_by) REFERENCES employee(employee_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS menu(
    menu_id BIGINT NOT NULL AUTO_INCREMENT,
    menu_name VARCHAR(255) NOT NULL,
    menu_price DECIMAL(10, 2) NOT NULL,
    menu_category_id BIGINT,
    ingredients BIGINT,
    number_of_servings_left INTEGER,
    PRIMARY KEY (menu_id),
    FOREIGN KEY (menu_category_id) REFERENCES menu_category(menu_category_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (ingredients) REFERENCES supply(supply_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS customer(
    customer_id BIGINT NOT NULL AUTO_INCREMENT,
    payment DECIMAL(10, 2),
    change_from_payment DECIMAL(10,2),
    PRIMARY KEY (customer_id)
);

CREATE TABLE IF NOT EXISTS food_order(
    food_order_id BIGINT NOT NULL AUTO_INCREMENT,
    menu_id BIGINT,
    order_quantity INTEGER,
    PRIMARY KEY (food_order_id),
    FOREIGN KEY (menu_id) REFERENCES menu(menu_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS serving(
    serving_id BIGINT NOT NULL AUTO_INCREMENT,
    employee_id BIGINT,
    servingTime DATETIME,
    food_order_id BIGINT,
    customer_id BIGINT,
    total_cost DECIMAL(10, 2),
    PRIMARY KEY (serving_id),
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (food_order_id) REFERENCES food_order(food_order_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (customer_id) REFERENCES customer(customer_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS utility(
    utility_id BIGINT NOT NULL AUTO_INCREMENT,
    utility_name VARCHAR(255) NOT NULL,
    utility_price DECIMAL(10, 2),
    PRIMARY KEY (utility_id)
);

CREATE TABLE IF NOT EXISTS monthly_utility(
    monthly_utility_id BIGINT NOT NULL AUTO_INCREMENT,
    utility_month DATE NOT NULL,
    utility_id BIGINT,
    PRIMARY KEY (monthly_utility_id),
    FOREIGN KEY (utility_id) REFERENCES utility(utility_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS monthly_transactions(
    monthly_transaction_id BIGINT NOT NULL AUTO_INCREMENT,
    transaction_month DATE NOT NULL,
    transaction_id BIGINT,
    PRIMARY KEY (monthly_transaction_id),
    FOREIGN KEY (transaction_id) REFERENCES transactions(transaction_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS monthly_income_expenses(
    monthly_income_expenses_id BIGINT NOT NULL AUTO_INCREMENT,
    income_expenses_month DATE,
    income_id BIGINT,
    PRIMARY KEY (monthly_income_expenses_id),
    FOREIGN KEY (income_id) REFERENCES employee_income_per_month(income_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS monthly_expenses(
    monthly_expenses_id BIGINT NOT NULL AUTO_INCREMENT,
    expenses_month DATE NOT NULL,
    monthly_transactions_id BIGINT,
    monthly_utility_id BIGINT,
    monthly_income_expenses_id BIGINT,
    PRIMARY KEY (monthly_expenses_id),
    FOREIGN KEY (monthly_income_expenses_id) REFERENCES monthly_income_expenses(monthly_income_expenses_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (monthly_utility_id) REFERENCES monthly_utility(monthly_utility_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (monthly_transactions_id) REFERENCES monthly_transactions(monthly_transaction_id) ON DELETE CASCADE ON UPDATE CASCADE
);



CREATE TABLE IF NOT EXISTS daily_sales(
    daily_sales_id BIGINT NOT NULL AUTO_INCREMENT,
    sales_date DATE,
    daily_sales_earned DECIMAL(10, 2),
    serving_id BIGINT,
    PRIMARY KEY (daily_sales_id),
    FOREIGN KEY (serving_id) REFERENCES serving(serving_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS monthly_sales(
    monthly_sales_id BIGINT NOT NULL AUTO_INCREMENT,
    sales_month DATE NOT NULL,
    daily_sales_id BIGINT,
    PRIMARY KEY (monthly_sales_id),
    FOREIGN KEY (daily_sales_id) REFERENCES daily_sales(daily_sales_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS monthly_report(
    monthly_report_id BIGINT NOT NULL AUTO_INCREMENT,
    report_month DATE,
    monthly_sales_id BIGINT,
    monthly_expenses_id BIGINT,
    PRIMARY KEY (monthly_report_id),
    FOREIGN KEY (monthly_sales_id) REFERENCES monthly_sales(monthly_sales_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (monthly_expenses_id) REFERENCES monthly_expenses(monthly_expenses_id) ON DELETE CASCADE ON UPDATE CASCADE
);


