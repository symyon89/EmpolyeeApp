package com.example.empolyeeapp.service;

import com.example.empolyeeapp.exception.EmployeeNotFoundException;
import com.example.empolyeeapp.model.Employee;
import com.example.empolyeeapp.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteById(Integer id) {
        employeeRepository.delete(this.findById(id));
    }
}
