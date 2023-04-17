package com.example.demo.cat;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CatService {
	
	final private CatRepository catRepository;

	@Transactional(readOnly = true)
	public Page<Cat> getCats(Pageable p) {
		return catRepository.findAll(p);
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
