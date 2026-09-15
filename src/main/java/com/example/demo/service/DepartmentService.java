package com.example.demo.service;

import com.example.demo.Department;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department createDepartment(
            Department department){
        return departmentRepository.save(department);
    }
    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }
    public Department getDepartmentById(Long id){
        return departmentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException(id));
    }
}
