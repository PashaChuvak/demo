package com.example.demo.database;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class CatDatabase {
	
	@EmbeddedId
	private CatDatabaseId catDatabaseId;
	private String nickName;
}
