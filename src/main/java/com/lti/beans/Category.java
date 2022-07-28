package com.lti.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Category")
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator="CATSEQ")
	@SequenceGenerator(name="CATSEQ", sequenceName="catseq",allocationSize=1)
	@Column(name="ID")
	private int id;
	
	@Column(name="NAME")
	private String name ;
	
	@Column(name="description")
	private String description;
	
//	@Column(name="createdAt")
//	private LocalDate createdAt;
//	
//	@Column(name="updatedAt")
//	private LocalDate updatedAt;

	public Category() {
		super();
	}

	public Category(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
//		this.createdAt = createdAt;
//		this.updatedAt = updatedAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public LocalDate getCreatedAt() {
//		return createdAt;
//	}
//
//	public void setCreatedAt(LocalDate createdAt) {
//		this.createdAt = createdAt;
//	}
//
//	public LocalDate getUpdatedAt() {
//		return updatedAt;
//	}
//
//	public void setUpdatedAt(LocalDate updatedAt) {
//		this.updatedAt = updatedAt;
//	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + "]";
	} 
	
	
	

}