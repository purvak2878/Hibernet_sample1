package com.ssit.Hibernet_sample.controller;

import com.ssit.Hibernet_sample.dao.EmployeeDAO;
import com.ssit.Hibernet_sample.entity.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeDAO employeeDAO;

    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeDAO.save(employee);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeDAO.findById(id);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeDAO.findAll();
    }
}
