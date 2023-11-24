package com.UserMicroservices.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	 @Id
	 private String uId;
	 private String name;
	 private String email;
	 private String about;
	 
	 @Transient
	 private List<Rating> ratings=new ArrayList<>();
	 
}
