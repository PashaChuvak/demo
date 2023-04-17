package com.example.demo.cat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class Cat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cat_seq")
	@SequenceGenerator(name = "cat_seq", allocationSize = 1)
	private Integer id;
	private String name;
	private String color;
	private String description;
}
