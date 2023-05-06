package com.dailyCodeBuffer.SpringBoottutorial.service;

import com.dailyCodeBuffer.SpringBoottutorial.entity.Department;
import com.dailyCodeBuffer.SpringBoottutorial.error.DepartmentNotFoundException;
import com.dailyCodeBuffer.SpringBoottutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department= departmentRepository.findById(departmentId);
        // enable exception in spring Boot
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department Not Available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        // find de department in the database
        Department depDB = departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(depDB.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            depDB.setDepartmentName(department.getDepartmentName());
        }
        if (Objects.nonNull(depDB.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())){
           depDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        if (Objects.nonNull(depDB.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
