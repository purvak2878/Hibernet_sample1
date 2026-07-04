package com.ssit.Hibernet_sample.entity;

import com.ssit.Hibernet_sample.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
