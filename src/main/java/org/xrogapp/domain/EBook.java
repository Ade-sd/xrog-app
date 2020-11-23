package org.xrogapp.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author ade
 * @date November-19-2020
 * @Entity EBook domain object
 */

@Entity
public class EBook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int ebookNo;

	private String brand;
	
	@Column(nullable = false)
	private double storage;
	
	// == constructor's ==
	
	public EBook(String brand,double storage) {
		this.brand = brand;
		this.storage = storage;
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
	
	

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "EBook [ebookNo=" + ebookNo + ", brand=" + brand + ", storage=" + storage + "]";
	}

}
