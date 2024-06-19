package com.xyzschool.school.schoolmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyzschool.school.schoolmanagement.model.Student;
import com.xyzschool.school.schoolmanagement.repository.SchoolRepo;

@Service
public class StudentService {

	@Autowired
	private SchoolRepo schoolRepo;
	
	public String saveStudent(Student student) {
		schoolRepo.save(student);
		return "Saved!!";
	}
	
}
