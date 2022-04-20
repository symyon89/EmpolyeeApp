package com.example.empolyeeapp.exception;

import java.util.NoSuchElementException;

public class EmployeeNotFoundException extends NoSuchElementException {
    public EmployeeNotFoundException(){
        super("Employee not found, check id number");
    }
}
