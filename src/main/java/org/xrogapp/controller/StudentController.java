package org.xrogapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.xrogapp.domain.Student;
import org.xrogapp.service.interfaces.StudentService;
import org.xrogapp.util.Mappings;

@RestController
public class StudentController {

	private final StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@PostMapping(Mappings.ADD_STUDENT)
	public Student addStudent(@RequestBody Student student) {
		Student result = studentService.addStudent(student);
		return result;
	}
}
