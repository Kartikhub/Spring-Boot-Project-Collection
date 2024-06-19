package com.xyzschool.school.schoolmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xyzschool.school.schoolmanagement.model.Student;
import com.xyzschool.school.schoolmanagement.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping(value = "/save")
	public String saveStud(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
}
