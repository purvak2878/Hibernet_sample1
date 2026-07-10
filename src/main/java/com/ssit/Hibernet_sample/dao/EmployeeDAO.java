package com.ssit.Hibernet_sample.dao;
import com.ssit.Hibernet_sample.entity.Employee;
import java.util.List;

public interface EmployeeDAO {

    Employee save(Employee employee);

    Employee findById(int id);

    List<Employee> findAll();

}
