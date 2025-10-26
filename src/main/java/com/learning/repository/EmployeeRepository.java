package com.learning.repository;

import com.learning.model.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class EmployeeRepository {

    private final List<Employee> employees = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(0);

    @PostConstruct
    public void init() {
        employees.add(Employee.builder().id(idGenerator.incrementAndGet())
                .firstName("John").lastName("Doe").email("john.doe@example.com").department("IT").build());

        employees.add(Employee.builder().id(idGenerator.incrementAndGet()).firstName("Jane").lastName("Smith")
                .email("jane.smith@example.com").department("HR").build());

        employees.add(Employee.builder().id(idGenerator.incrementAndGet()).firstName("Alice").lastName("Johnson")
                .email("alice.johnson@example.com").department("Finance").build());
    }

    public List<Employee> findAll() {
        return new ArrayList<>(employees);
    }

    public Optional<Employee> findById(Long id) {
        return employees.stream().filter(employee -> employee.getId().equals(id)).findFirst();
    }

    public Optional<Employee> findByEmail(String email) {
        return employees.stream().filter(employee -> employee.getEmail().equalsIgnoreCase(email)).findFirst();
    }

    public Employee save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(idGenerator.incrementAndGet());
            employees.add(employee);
        } else {
            employees.replaceAll(emp -> emp.getId().equals(employee.getId()) ? employee : emp);
        }
        return employee;
    }

    public boolean existsById(Long id) {
        return employees.stream().anyMatch(employee -> employee.getId().equals(id));
    }

    public void deleteById(Long id) {
        employees.removeIf(employee -> employee.getId().equals(id));
    }
}
