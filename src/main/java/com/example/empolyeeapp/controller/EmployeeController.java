package com.example.empolyeeapp.controller;

import com.example.empolyeeapp.exception.EmployeeNotFoundException;
import com.example.empolyeeapp.model.Employee;
import com.example.empolyeeapp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RequiredArgsConstructor
@RestController
@RequestMapping("employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), BAD_REQUEST);
    }

    @GetMapping("{id}")
    public Employee findById(@PathVariable Integer id) {
        return employeeService.findById(id);
    }
    @PostMapping
    public Employee save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteByID(@PathVariable Integer id) {
        employeeService.deleteById(id);
    }
}
