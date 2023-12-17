package com.codewithdurgesh.blog.blogappapis.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {
	 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 private  int id;
	 @Column(name="user_name", nullable = false,length = 100)
	 private  String  name;
	  
	 private  String email;
	 
	 private  String  password;
	 
	 private  String  about;
	 

}
