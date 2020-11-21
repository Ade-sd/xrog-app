package org.xrogapp.service.interfaces;

import java.util.List;

import org.xrogapp.domain.Student;
/**
 * @author ade
 * @date  November-21-2020
 * @category Student Object service
 */

public interface StudentService {
	
	// Add new student to database
	Student addStudent(Student student);
	
	// Fetch list of all students from database 
	List<Student> getAllStudents();

}
