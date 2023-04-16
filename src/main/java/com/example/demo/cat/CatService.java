package com.example.demo.cat;

import java.util.Arrays;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.util.Json;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CatService {
	
	final private CatRepository catRepository;

	@Transactional(readOnly = true)
	public String getCats() {
		return Json.getJson(Json.getArrayHashMap(catRepository.getCats(), 
				Arrays.asList("id", "name")));
	}
	
	@Transactional
	public Cat save(CatRequest catRequest) {
		Cat cat = new Cat();
		cat.setName(catRequest.getName());
		return catRepository.save(cat);
	}
	
	@Transactional
	public void deleteById(Integer id) {
		catRepository.deleteById(id);;
	}
	
	@Transactional
	public Cat updateById(Integer id, CatRequest catRequest) {
		Cat cat = new Cat();
		cat.setId(id);
		cat.setName(catRequest.getName());
		return catRepository.save(cat);
	}
	
	@Transactional(readOnly = true)
	public Cat getById(Integer id) {
		return catRepository.findById(id).orElse(null);
	}	
}
