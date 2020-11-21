package org.xrogapp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class EBook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int ebookNo;
	
	@Column(nullable = false)
	private double storage;
	
	@Column(nullable = false)
	@OneToMany(mappedBy = "ebook")
	private List<Student> student = new ArrayList<Student>();
	
	// == constructor's ==
	
	public EBook(double storage, List<Student> student) {
		super();
		this.storage = storage;
		this.student = student;
	}
	
	public EBook() {
		// default constructor
	}
	
	public int getEbookNo() {
		return ebookNo;
	}


	public double getStorage() {
		return storage;
	}

	public void setStorage(double storage) {
		this.storage = storage;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "EBook [ebookNo=" + ebookNo + ", storage=" + storage + ", student=" + student + "]";
	}

}
