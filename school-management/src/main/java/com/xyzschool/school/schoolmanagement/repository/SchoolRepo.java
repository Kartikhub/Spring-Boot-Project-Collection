package com.xyzschool.school.schoolmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xyzschool.school.schoolmanagement.model.Student;

public interface SchoolRepo extends JpaRepository<Student, Integer>{

}
