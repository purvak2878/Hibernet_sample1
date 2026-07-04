package com.ssit.Hibernet_sample;

import com.ssit.Hibernet_sample.entity.Employee;
import com.ssit.Hibernet_sample.entity.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class HibernetSampleApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository repository;

	public HibernetSampleApplication(EmployeeRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(HibernetSampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Employee e1 = new Employee(101, "Purva", "Java Developer", 50000);
		Employee e2 = new Employee(102, "Riya", "Software Engineer", 45000);
		Employee e3 = new Employee(103, "Aman", "Tester", 40000);

		repository.save(e1);
		repository.save(e2);
		repository.save(e3);

		System.out.println("Employees Saved Successfully...");

		System.out.println("\nReading One Employee");
		Optional<Employee> temp = repository.findById(101);

		if(temp.isPresent()) {
			Employee emp = temp.get();
			System.out.println(emp);
		}

		System.out.println("\nReading All Employees");

		List<Employee> employees = repository.findAll();

		for(Employee emp : employees) {
			System.out.println(emp);
		}

		Employee updateEmp = new Employee(101, "Purva", "Senior Java Developer", 70000);
		repository.save(updateEmp);
		System.out.println("Employee Updated Successfully");

		System.out.println("\nReading Updated Employee");
		Employee updatedEmployee = repository.findById(101).get();
		System.out.println(updatedEmployee);

		System.out.println("\nDeleting Employee...");
		repository.deleteById(103);
		System.out.println("Employee Deleted Successfully");
		System.out.println("\nEmployees After Deletion");

        employees = repository.findAll();
		for (Employee emp : employees) {
			System.out.println(emp);
		}
	}
}