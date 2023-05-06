package com.dailyCodeBuffer.SpringBoottutorial.service;

import com.dailyCodeBuffer.SpringBoottutorial.entity.Department;
import com.dailyCodeBuffer.SpringBoottutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    Department fetchDepartmentByName(String departmentName);
}
