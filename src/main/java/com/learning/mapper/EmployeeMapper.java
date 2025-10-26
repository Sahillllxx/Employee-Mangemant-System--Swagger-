package com.learning.mapper;

import com.learning.dto.EmployeeDto;
import com.learning.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeDto toDto(Employee entity) {
        if (entity == null) return null;
        return EmployeeDto.builder().id(entity.getId()).firstName(entity.getFirstName()).lastName(entity.getLastName())
                .email(entity.getEmail()).department(entity.getDepartment()).build();
    }

    public Employee toEntity(EmployeeDto dto) {
        if (dto == null) return null;
        return Employee.builder().firstName(dto.getFirstName())
                .lastName(dto.getLastName()).email(dto.getEmail()).department(dto.getDepartment()).build();
    }

    public void updateEntityFromDto(EmployeeDto dto, Employee entity) {
        if (dto == null || entity == null) return;
        if (dto.getFirstName() != null) entity.setFirstName(dto.getFirstName());
        if (dto.getLastName() != null) entity.setLastName(dto.getLastName());
        if (dto.getEmail() != null) entity.setEmail(dto.getEmail());
        if (dto.getDepartment() != null) entity.setDepartment(dto.getDepartment());
    }
}
