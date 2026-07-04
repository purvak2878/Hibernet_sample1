package com.ssit.Hibernet_sample;

import com.ssit.Hibernet_sample.entity.Employee;
import com.ssit.Hibernet_sample.entity.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HibernetController {
    @Autowired
    EmployeeRepository repository;

    @PostMapping("/save")
    public String saveEmployee(@RequestBody Employee employee) {

        repository.save(employee);

        return "Employee Saved Successfully";
    }

    @GetMapping("/")
    public String show() {
        return "Hibernate Sample";
    }
}
