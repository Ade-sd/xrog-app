package org.xrogapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author ade
 * @date November-19-2020
 * @Entity EBook domain object
 */

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false , name = "last_name")
	private String lastName;
	
	@Column(nullable = false)
	private String email;
	
	@ManyToOne
	private EBook ebook;
	
	// == constructor's ==
	
	public Student(String name, String lastName, String email, EBook ebook) {
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.ebook = ebook;
	}  
	
	public Student() {
		// default constructor
	}

	// == public methods ==

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EBook getEbook() {
		return ebook;
	}

	public void setEbook(EBook ebook) {
		this.ebook = ebook;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", lastName=" +
				lastName + ", email=" + email + ", ebook=" + ebook + "]";
	}
	
}
