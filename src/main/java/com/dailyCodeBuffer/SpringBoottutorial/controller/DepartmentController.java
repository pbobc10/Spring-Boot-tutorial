package com.dailyCodeBuffer.SpringBoottutorial.controller;

import com.dailyCodeBuffer.SpringBoottutorial.entity.Department;
import com.dailyCodeBuffer.SpringBoottutorial.error.DepartmentNotFoundException;
import com.dailyCodeBuffer.SpringBoottutorial.service.DepartmentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    public DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(Department.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
      return  departmentService.saveDepartment(department);

    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        LOGGER.info("Inside fetchDepartmentById of DepartmentController");
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        LOGGER.info("Inside deleteDepartmentById of DepartmentController");
        departmentService.deleteDepartmentById(departmentId);
        return "Department Id deleted successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department){
        LOGGER.info("Inside updateDepartment of DepartmentController");
        return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        LOGGER.info("Inside fetchDepartmentByName   of DepartmentController");
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
