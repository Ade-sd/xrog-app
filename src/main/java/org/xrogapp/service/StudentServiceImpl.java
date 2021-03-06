package org.xrogapp.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xrogapp.domain.EBook;
import org.xrogapp.domain.Student;
import org.xrogapp.repository.EBookRepository;
import org.xrogapp.repository.StudentRepository;
import org.xrogapp.service.interfaces.StudentService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ade
 * @date November-23-2020
 * @category Business logic layer for using JPA CRUD service.
 */

@Service
@Slf4j
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
		// Check first if inserted EBook id exist (or maybe not inserted)
		Optional<EBook> eBookMaybe = getEBookById(student.getEbook().getEbookNo());
				
		// 1.If id set in JSON object and EBook with this id already exist in DB:
		// 	 inject eBookMaybe object into Student{EBook} and then just save student object (EBook skipped).
		
		// 2.If id not set in JSON object or it's set but EBook did not exist in DB:
		// 	 Normally save both student and EBook object's.
		eBookMaybe.ifPresentOrElse(
				ebook -> { 
					student.setEbook(ebook); 
					studentRepository.save(student);
				},
				() -> {
					if(student.getEbook().getBrand()==null || student.getEbook().getStorage()==0.0) {
						// not persist
						 log.info("Worng id or null student EBook(null brand and ebook 0.0 storage)");
					}else {
						eBookRepository.save(student.getEbook());
						studentRepository.save(student);
					}
				});
			
		return student;
	}

	// Fetch all students from database with name natural order.
	@Override
	public List<Student> getAllStudents() {
		List<Student> sortedStudents = studentRepository.findAll()
				.stream()
				.sorted(Comparator.comparing(Student::getName))
				.collect(Collectors.toList());
		return sortedStudents;
	}

	// GET EBook by id and return an optional<EBook> 
	// (this method is't part of studentService interface).
	private Optional<EBook> getEBookById(int id) {
		return eBookRepository.findById(id);
	}

	// GET Student by id and return Student object.
	@Override
	public Student getStudentById(int id) {
		return studentRepository.findById(id)
				.orElseThrow();
	}

	//Get Student by name and return Optional of student.
	@Override
	public Optional<Student> getStudentByName(String name) {
		return studentRepository.findByName(name);	
	}

}
