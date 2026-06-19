package com.example.Validation.service;

import com.example.Validation.dto.DepartmentDTO;
import com.example.Validation.entity.Department;
import com.example.Validation.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        Department department = new Department(departmentDTO.getName(), departmentDTO.getDescription());
        Department savedDepartment = departmentRepository.save(department);
        return new DepartmentDTO(savedDepartment.getId(), savedDepartment.getName(), savedDepartment.getDescription());
    }
}
