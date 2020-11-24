package org.xrogapp.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.xrogapp.domain.EBook;
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
	
	// Fetch EBook by EBook id.
	Optional<EBook> getEBookById(int id);
	
	// Fetch student by student id.
	Student getStudentById(int id);

}