package com.dailyCodeBuffer.SpringBoottutorial.repository;

import com.dailyCodeBuffer.SpringBoottutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    // use one of then

    // for case sensitive
    Department findByDepartmentNameIgnoreCase(String departmentName);
    // for ignoring case
    //Department findByDepartmentName(String departmentName);
}
