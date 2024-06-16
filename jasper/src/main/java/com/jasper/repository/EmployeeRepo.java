package com.jasper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jasper.entity.Employee;



@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	List<Employee> findAll();
	Employee findByLoginIdAndPassword(String loginId , String password);
}
