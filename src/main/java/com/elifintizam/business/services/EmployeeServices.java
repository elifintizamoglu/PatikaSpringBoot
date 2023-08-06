package com.elifintizam.business.services;

import com.elifintizam.business.dto.EmployeeDto;
import com.elifintizam.data.entity.EmployeeEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface EmployeeServices {
    //CRUD
    List<EmployeeDto> getAllEmployees();

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    ResponseEntity<EmployeeDto> getEmployeeById(Long id) throws Throwable;

    ResponseEntity<EmployeeDto> updateEmployee(Long id, EmployeeDto employeeDto) throws Throwable;

    ResponseEntity<Map<String, Boolean>> deleteEmployee(Long id) throws Throwable;

    //model mapper
    EmployeeDto EntityToDto(EmployeeEntity employeeEntity);

    EmployeeEntity DtoToEntity(EmployeeDto employeeDto);
}

