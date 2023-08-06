package com.elifintizam.business.services.impl;

import com.elifintizam.business.dto.EmployeeDto;
import com.elifintizam.business.services.EmployeeServices;
import com.elifintizam.data.entity.EmployeeEntity;
import com.elifintizam.data.repository.EmployeeRepository;
import com.elifintizam.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    //LIST
    // http://localhost:8080/api/v1/employees
    @GetMapping("/employees")
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> listDto = new ArrayList<>();
        Iterable<EmployeeEntity> teacherList = employeeRepository.findAll();
        for (EmployeeEntity entity : teacherList) {
            EmployeeDto employeeDto = EntityToDto(entity);//model
            listDto.add(employeeDto);
        }
        return listDto;
    }

    //FIND
    // http://localhost:8080/api/v1/employees/1
    @GetMapping("/employees/{id}")
    @Override
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(name = "id") Long id) throws Throwable {

        EmployeeEntity employee = (EmployeeEntity) employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee " + id + " numaralı product id bulunamadı !!!!"));
        EmployeeDto employeeDto = EntityToDto(employee);//model
        return ResponseEntity.ok(employeeDto);
    }

    //SAVE
    // http://localhost:8080/api/v1/employees
    @PostMapping("/employees")
    public EmployeeDto createEmployee(@RequestBody EmployeeDto employeeDto) { //@RequestBody
        EmployeeEntity employeeEntity = DtoToEntity(employeeDto);//ModelMapper
        employeeRepository.save(employeeEntity);
        return employeeDto;
    }

    //DELETE
    // http://localhost:8080/api/v1/employees
    @DeleteMapping("/employees/{id}")
    @Override
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable(name = "id") Long id) throws Throwable {
        EmployeeEntity employee = (EmployeeEntity) employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    //UPDATE
    // http://localhost:8080/api/v1/employees
    @PutMapping("/employees/{id}")
    @Override
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable(name = "id") Long id, @RequestBody EmployeeDto employeeDetails) throws Throwable {
        EmployeeEntity employeeEntity = DtoToEntity(employeeDetails);//ModelMapper

        EmployeeEntity employee = (EmployeeEntity) employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employee.setFirstName(employeeEntity.getFirstName());
        employee.setLastName(employeeEntity.getLastName());
        employee.setEmail(employeeEntity.getEmail());

        EmployeeEntity updatedEmployee = (EmployeeEntity) employeeRepository.save(employee);
        EmployeeDto employeeDto = EntityToDto(updatedEmployee);//model
        return ResponseEntity.ok(employeeDto);
    }


    ////////////////////////////////////
    //Model Mapper Entity ==> Dto
    @Override
    public EmployeeDto EntityToDto(EmployeeEntity employeeEntity) {
        EmployeeDto employeeDto = modelMapper.map(employeeEntity, EmployeeDto.class);
        return employeeDto;
    }

    //Model Mapper Dto  ==> Entity
    @Override
    public EmployeeEntity DtoToEntity(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDto, EmployeeEntity.class);
        return employeeEntity;
    }
}
