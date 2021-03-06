package org.xrogapp.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.xrogapp.domain.Student;
/**
 * @author ade
 * @date  November-21-2020
 * @category Student service layer
 */

public interface StudentService {
	
	// Add new student to database.
	Student addStudent(Student Student);
	
	// Fetch list of all students from database .
	List<Student> getAllStudents();
	
	// Fetch student by student id.
	Student getStudentById(int id);
	
	// Fetch student by student name.
	Optional<Student> getStudentByName(String name);

}