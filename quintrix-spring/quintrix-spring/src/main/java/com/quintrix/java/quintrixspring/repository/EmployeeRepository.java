package com.quintrix.java.quintrixspring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.quintrix.java.quintrixspring.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
