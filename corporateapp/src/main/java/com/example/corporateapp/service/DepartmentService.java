package com.example.corporateapp.service;

import com.example.corporateapp.model.Department;
import com.example.corporateapp.model.Company;
import com.example.corporateapp.repository.DepartmentRepository;
import com.example.corporateapp.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final CompanyRepository companyRepository;

    public Department createDepartment(Long companyId, Department department) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new RuntimeException("Company not found"));
        department.setCompany(company);
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    public Department updateDepartment(Long id, Department updated) {
        Department department = getDepartmentById(id);
        department.setName(updated.getName());
        return departmentRepository.save(department);
    }
}
