package org.xrogapp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.PRIVATE)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false , name = "last_name")
	private String lastName;
	
	@Column(nullable = false)
	private String email;
	
	@ManyToOne
	private EBook ebook;
	
}
