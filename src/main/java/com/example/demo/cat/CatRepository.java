package com.example.demo.cat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CatRepository extends JpaRepository<Cat, Integer> {
	
	@Query(value = "SELECT id, name FROM cat", nativeQuery = true)
	List<List<Object>> getCats();
}
