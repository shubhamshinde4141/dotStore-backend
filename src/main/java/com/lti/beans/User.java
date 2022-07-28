package com.lti.beans;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {

//	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator="USERSEQ")
//	@SequenceGenerator(name="USERSEQ", sequenceName="userseq",allocationSize=1)
//	@Column(name="ID")
	private int id;
	
	//@Column(name="NAME", length = 20)
	private String name;
	
	//@Column(name="EMAIL")
	private String email;

	private String phone;
	
	private String password;
	
	private String token;
	
	private String address;
	
	private String gender;
	
	private String dob;

	private LocalDate createdAt;
	
	private LocalDate updatedAt;
	
	
	
	
	
}
