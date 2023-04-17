package com.example.demo.db;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class CatDatabase {
	
	@EmbeddedId
	private CatDatabaseId catDBId;
	private String nickName;
}
