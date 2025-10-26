package com.learning.service.impl;

import com.learning.dto.EmployeeDto;
import com.learning.mapper.EmployeeMapper;
import com.learning.model.Employee;
import com.learning.repository.EmployeeRepository;
import com.learning.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        repository.findByEmail(employeeDto.getEmail()).ifPresent(employee -> {
            throw new RuntimeException("Employee with email already exists");
        });
        Employee employee = mapper.toEntity(employeeDto);
        Employee saved = repository.save(employee);
        return mapper.toDto(saved);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        return mapper.toDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Employee existing = repository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
        mapper.updateEntityFromDto(employeeDto, existing);
        Employee updated = repository.save(existing);
        return mapper.toDto(updated);
    }

    @Override
    public void deleteEmployee(Long id) {
        if (!repository.existsById(id)) throw new RuntimeException("Employee not found with id: " + id);
        repository.deleteById(id);
    }
}
