package com.ssit.Hibernet_sample.dao;
import com.ssit.Hibernet_sample.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager entityManager;

    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {

        entityManager.persist(employee);

        return employee;
    }

    @Override
    public Employee findById(int id) {

        return entityManager.find(Employee.class, id);

    }

    @Override
    public List<Employee> findAll() {

        return entityManager
                .createQuery("FROM Employee", Employee.class)
                .getResultList();

    }
}
