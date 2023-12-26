package com.kodilla.kodillahibernate2.manytomany.facade;

public class EmployeeQueryProcessingException extends Exception {

    public static String ERR_EMPLOYEE_NOT_FOUND = "Employee not found";
    public static String ERR_EMPTY_DATABASE = "Database is empty";

    public EmployeeQueryProcessingException(String message) {
        super(message);
    }

}
