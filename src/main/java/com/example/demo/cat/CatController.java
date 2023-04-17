package com.example.demo.cat;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.utils.Sorting;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin("${cross_origin}")
@RequestMapping("/cat/")
public class CatController {

	final private CatService catService;
	
	@GetMapping(value = "list/{page}/{size}", produces = "application/json")
	public Page<Cat> getAllCats(@RequestParam String sortFieldName, @RequestParam Sorting sorting, 
			@PathVariable Integer page, @PathVariable Integer size) {
		if (Boolean.TRUE.equals(Sorting.ASC == sorting)) {
			return catService.getCats(PageRequest.of(page, size, 
					Sort.by(sortFieldName).ascending()));
		} 
		return catService.getCats(PageRequest.of(page, size, 
					Sort.by(sortFieldName).descending()));
	}
	
	@PostMapping("save")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Cat saveCat(@RequestBody CatRequest catRequest) {
		return catService.save(catRequest);
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteById(@PathVariable Integer id) {
		catService.deleteById(id);
	}
	
	@PatchMapping("update/{id}")
	public Cat updateById(@PathVariable Integer id, @RequestBody CatRequest catRequest) {
		return catService.updateById(id, catRequest);
	}
	
	@GetMapping("get/{id}")
	public Cat getById(@PathVariable Integer id) {
		return catService.getById(id);
	}
}
