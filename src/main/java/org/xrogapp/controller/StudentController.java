package org.xrogapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xrogapp.domain.Student;
import org.xrogapp.service.interfaces.StudentService;
import org.xrogapp.util.Mappings;

/**
 * @author ade
 * @date November-23-2020
 * @category Controller layer
 * 
 * @RequestPath "/student"
 */

@RestController
@RequestMapping(Mappings.STUDENT_CONTROLLER)
public class StudentController {

	private final StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	// Call student service addStudent() method 
	// path = "/add" 
	@PostMapping(value = Mappings.ADD_STUDENT)
	public Student addStudent(@RequestBody Student student) {
		Student result = studentService.addStudent(student);
		return result;
	}
	
	// Get all students from database
	@GetMapping(value = Mappings.GET_ALL_STUDENTS)
	public List<Student> allStudents(){
		return studentService.getAllStudents();
	}
	
}
