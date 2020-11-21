package org.xrogapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xrogapp.domain.Student;
import org.xrogapp.repository.EBookRepository;
import org.xrogapp.repository.StudentRepository;
import org.xrogapp.service.interfaces.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	
	// Creating clone of StundetRepository and EbookRepository bean 
	// for using CRUD services
	private final StudentRepository studentRepository;
	private final EBookRepository eBookRepository;
	
	// Inject via constructor injection and also @Autowired
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository,
							  EBookRepository ebookRepository) {
		this.studentRepository = studentRepository;
		this.eBookRepository = ebookRepository;
	}
	
	// Add student object and call studentRepository and eBookRepository
	// to save relation object. 

	@Override
	public Student addStudent(Student student) {
		studentRepository.save(student);
		eBookRepository.save(student.getEbook());
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

}
