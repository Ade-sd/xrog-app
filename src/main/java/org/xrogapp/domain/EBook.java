package org.xrogapp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
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

}
