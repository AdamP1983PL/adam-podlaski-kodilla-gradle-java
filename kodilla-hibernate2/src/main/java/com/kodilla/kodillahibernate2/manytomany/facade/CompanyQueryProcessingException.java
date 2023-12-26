package com.kodilla.kodillahibernate2.manytomany.facade;

public class CompanyQueryProcessingException extends Exception {

    public static String ERR_COMPANY_NOT_FOUND = "Company name with given snippet not found";
    public static String ERR_EMPTY_DATABASE = "Database is empty";

    public CompanyQueryProcessingException(String message) {
        super(message);
    }
}
