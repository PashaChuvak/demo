package com.example.demo.db;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class CatDatabaseId {

	private Long time;
	private Integer catId;
	private String catIdentified;
}
